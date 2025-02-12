package interceptor;

import java.util.HashMap;
import java.util.Map;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class MapaMemory {

    private Map<String, String> map = new HashMap<>();

    public Map<String, String> getAtributo() {
        return map;
    }

    public void setAtributo(String atributo) {
        this.map.put("atributo", atributo);
    }

    @Override
    public String toString() {
        return "MapaMemory [map=" + map + "]";
    }

}
