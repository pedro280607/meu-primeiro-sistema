
package br.com.starlog.model;

public class Produto {

    private Long id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(Long id, String nome, double preco, int estoque) {
        validarDados(nome, preco, estoque);

        this.id = id;
        this.nome = nome.trim();
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(String nome, double preco, int estoque) {
        this(null, nome, preco, estoque);
    }

    private void validarDados(String nome, double preco, int estoque) {

        if (nome == null || nome.trim().length() < 3) {
            throw new IllegalArgumentException(
                "O nome deve possuir pelo menos 3 caracteres."
            );
        }

        if (preco <= 0.0) {
            throw new IllegalArgumentException(
                "O preço deve ser maior que zero."
            );
        }

        if (estoque < 0) {
            throw new IllegalArgumentException(
                "O estoque não pode ser negativo."
            );
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPreco(double preco) {
        if (preco <= 0.0) {
            throw new IllegalArgumentException(
                "O preço deve ser maior que zero."
            );
        }

        this.preco = preco;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException(
                "O estoque não pode ser negativo."
            );
        }

        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %d | Nome: %s | Preço: R$ %.2f | Estoque: %d",
            id, nome, preco, estoque
        );
    }
}
