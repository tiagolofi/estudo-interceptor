package rest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import interceptor.AnotacaoCompleta;
import interceptor.AnotacaoMarcadora;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/teste")
@RequestScoped
public class TesteRest {
    
    public Map<String, String> map = new ConcurrentHashMap<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/resposta")
    @AnotacaoMarcadora
    public Resposta teste() {
        map.put("atributo", "Teste");
        return new Resposta(1, "Teste");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/resposta2")
    @AnotacaoMarcadora
    @AnotacaoCompleta(value = "Teste", numero = 2)
    public Resposta teste2() {
        map.put("atributo", "Teste2");
        return new Resposta(2, "Teste2");
    }

}
