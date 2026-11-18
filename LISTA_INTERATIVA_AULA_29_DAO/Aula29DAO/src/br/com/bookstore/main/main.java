
package br.com.bookstore.main;

import br.com.bookstore.dao.LivroDAO;
import br.com.bookstore.dao.LivroDaoSqlite;
import br.com.bookstore.model.Livro;

import java.util.List;

// Classe principal responsável por executar os testes da Bookstore.
public class main {

    public static void main(String[] args) {

        // Instancia a interface, utilizando a implementação SQLite.
        LivroDAO dao = new LivroDaoSqlite();

        // Cria três livros com títulos, autores e preços diferentes.
        Livro livro1 = new Livro(
            "Clean Code",
            "Robert C. Martin",
            89.90
        );

        Livro livro2 = new Livro(
            "Design Patterns",
            "Erich Gamma",
            99.90
        );

        Livro livro3 = new Livro(
            "Refactoring",
            "Martin Fowler",
            109.90
        );

        // Persiste os livros no banco de dados.
        dao.salvar(livro1);
        dao.salvar(livro2);
        dao.salvar(livro3);

        // Exibe os IDs gerados automaticamente pelo banco.
        System.out.println("=== LIVROS CADASTRADOS ===");

        System.out.println("Livro 1 - ID gerado: " + livro1.getId());
        System.out.println("Livro 2 - ID gerado: " + livro2.getId());
        System.out.println("Livro 3 - ID gerado: " + livro3.getId());

        // Busca o livro que possui ID 2.
        System.out.println("\n=== BUSCA PELO ID 2 ===");

        dao.buscarPorId(2L).ifPresentOrElse(
            livro -> System.out.println(livro),
            () -> System.out.println("Livro não encontrado.")
        );

        // Busca um ID inexistente para demonstrar o uso de Optional.
        System.out.println("\n=== BUSCA PELO ID 999 ===");

        dao.buscarPorId(999L).ifPresentOrElse(
            livro -> System.out.println(livro),
            () -> System.out.println("Nenhum livro encontrado com o ID informado.")
        );

        // Recupera todos os livros cadastrados.
        System.out.println("\n=== LISTA COMPLETA DE LIVROS ===");

        List<Livro> livros = dao.listarTodos();

        // Imprime os registros em formato de tabela.
        System.out.printf(
            "%-5s | %-25s | %-25s | %10s%n",
            "ID", "TÍTULO", "AUTOR", "PREÇO"
        );

        System.out.println("--------------------------------------------------------------------------");

        for (Livro livro : livros) {
            System.out.printf(
                "%-5d | %-25s | %-25s | R$ %8.2f%n",
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getPreco()
            );
        }
    }
}
