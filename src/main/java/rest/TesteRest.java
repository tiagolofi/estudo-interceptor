package rest;

import java.util.HashMap;
import java.util.Map;

import interceptor.AnotacaoCompleta;
import interceptor.AnotacaoMarcadora;
import interceptor.MapaMemory;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/teste")
@RequestScoped
public class TesteRest {
    
    @Inject
    MapaMemory mapa;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/resposta")
    @AnotacaoMarcadora
    @AnotacaoCompleta(value = "Teste", numero = 1)
    public Resposta teste() {
        mapa.setAtributo( "Teste");
        return new Resposta(1, "Teste");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/resposta2")
    @AnotacaoMarcadora
    @AnotacaoCompleta(value = "Teste", numero = 2)
    public Resposta teste2() {
        mapa.setAtributo("Teste2");
        return new Resposta(2, "Teste2");
    }

}
