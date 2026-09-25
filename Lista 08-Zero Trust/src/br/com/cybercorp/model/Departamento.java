package br.com.cybercorp.model;

public class Departamento {

    private String sigla;
    private String nome;
    private int andar;

    public Departamento(String sigla, String nome, int andar) {
        this.sigla = sigla;
        this.nome = nome;
        this.andar = andar;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "sigla='" + sigla + '\'' +
                ", nome='" + nome + '\'' +
                ", andar=" + andar +
                '}';
    }
}