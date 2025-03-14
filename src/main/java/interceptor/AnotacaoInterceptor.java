package interceptor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import rest.Resposta;

@AnotacaoMarcadora
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 500)
public class AnotacaoInterceptor {
    
    @Inject
    MapaMemory mapa;

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        try {
            AnotacaoCompleta anotacaoCompleta = context.getMethod().getAnnotation(AnotacaoCompleta.class);
            System.out.println("Interceptando anotação: " + anotacaoCompleta.value() + " - " + anotacaoCompleta.numero());
            return context.proceed();
        } catch (Exception e) {
            System.out.println("Interceptando exceção: " + e.getMessage());
            return context.proceed();
        } finally {
            Object result = context.proceed();
            if (result instanceof Resposta dados) {
                System.out.println("Interceptando resultado: " + dados.getId() + " - " + dados.getNome());
            }

            System.out.println(mapa.toString());

            for (Field field : context.getMethod().getDeclaringClass().getDeclaredFields()) {
                System.out.println("Interceptando campo: " + field.getName());
                System.out.println(field.canAccess(context.getTarget()));

                // @SuppressWarnings({ "unchecked", "rawtypes" })
                // ConcurrentHashMap<String, String> map = (ConcurrentHashMap) field.get(context.getTarget());
                // System.out.println("Interceptando valor: " + map.get("atributo"));
            }
        }
    }

}
