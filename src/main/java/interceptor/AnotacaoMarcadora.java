package interceptor;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface AnotacaoMarcadora {}
