
package br.com.bookstore.dao;

import br.com.bookstore.model.Livro;
import java.util.List;
import java.util.Optional;

// Define o contrato de operações de acesso aos livros.
public interface LivroDAO {

    // Salva um livro no banco de dados.
    void salvar(Livro livro);

    // Busca um livro pelo seu ID.
    Optional<Livro> buscarPorId(Long id);

    // Retorna todos os livros cadastrados.
    List<Livro> listarTodos();
}
