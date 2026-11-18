
package br.com.bookstore.model;

// Representa um livro no sistema Bookstore.
public class Livro {

    // Atributos privados para proteger os dados do livro.
    private Long id;
    private String titulo;
    private String autor;
    private double preco;

    // Construtor completo, utilizado para carregar livros do banco.
    public Livro(Long id, String titulo, String autor, double preco) {
        validarDados(titulo, autor, preco);

        this.id = id;
        this.titulo = titulo.trim();
        this.autor = autor.trim();
        this.preco = preco;
    }

    // Construtor de negócio, utilizado para cadastrar novos livros.
    // O ID será preenchido posteriormente pelo banco de dados.
    public Livro(String titulo, String autor, double preco) {
        this(null, titulo, autor, preco);
    }

    // Valida os dados antes de criar o objeto.
    private void validarDados(String titulo, String autor, double preco) {

        if (titulo == null || titulo.trim().length() < 2) {
            throw new IllegalArgumentException(
                "O título deve possuir pelo menos 2 caracteres."
            );
        }

        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "O autor não pode ser nulo ou vazio."
            );
        }

        if (preco <= 0.0) {
            throw new IllegalArgumentException(
                "O preço de venda deve ser estritamente positivo"
            );
        }
    }

    // Retorna o ID do livro.
    public Long getId() {
        return id;
    }

    // Retorna o título.
    public String getTitulo() {
        return titulo;
    }

    // Retorna o autor.
    public String getAutor() {
        return autor;
    }

    // Retorna o preço.
    public double getPreco() {
        return preco;
    }

    // Permite atualizar somente o ID gerado pelo banco.
    public void setId(Long id) {
        this.id = id;
    }

    // Retorna os dados formatados do livro.
    @Override
    public String toString() {
        return String.format(
            "ID: %d | Título: %s | Autor: %s | Preço: R$ %.2f",
            id, titulo, autor, preco
        );
    }
}
