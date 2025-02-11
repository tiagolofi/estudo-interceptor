package rest;

public class Resposta {

    private int id;
    private String nome;

    public Resposta (int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
