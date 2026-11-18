
package br.com.bookstore.dao;

import br.com.bookstore.model.Livro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Implementação do LivroDAO utilizando banco de dados SQLite.
public class LivroDaoSqlite implements LivroDAO {

    // URL de conexão com o banco SQLite.
    private static final String URL = "jdbc:sqlite:bookstore.db";

    // Construtor que inicializa a tabela automaticamente.
    public LivroDaoSqlite() {
        criarTabela();
    }

    // Cria a tabela caso ela ainda não exista.
    private void criarTabela() {

        String sql = "CREATE TABLE IF NOT EXISTS livros ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "titulo TEXT NOT NULL, "
                + "autor TEXT NOT NULL, "
                + "preco REAL NOT NULL"
                + ");";

        try (Connection conexao = DriverManager.getConnection(URL);
             Statement statement = conexao.createStatement()) {

            statement.execute(sql);

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar tabela: " + e.getMessage(), e);
        }
    }

    // Salva um livro e recupera o ID gerado automaticamente.
    @Override
    public void salvar(Livro livro) {

        String sql = "INSERT INTO livros (titulo, autor, preco) VALUES (?, ?, ?)";

        try (Connection conexao = DriverManager.getConnection(URL);
             PreparedStatement statement = conexao.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, livro.getTitulo());
            statement.setString(2, livro.getAutor());
            statement.setDouble(3, livro.getPreco());

            statement.executeUpdate();

            // Recupera a chave primária gerada pelo SQLite.
            try (ResultSet resultado = statement.getGeneratedKeys()) {

                if (resultado.next()) {
                    livro.setId(resultado.getLong(1));
                } else {
                    throw new SQLException("Não foi possível recuperar o ID gerado.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar livro: " + e.getMessage(), e);
        }
    }

    // Busca um livro pelo ID, retornando Optional para evitar null.
    @Override
    public Optional<Livro> buscarPorId(Long id) {

        String sql = "SELECT * FROM livros WHERE id = ?";

        try (Connection conexao = DriverManager.getConnection(URL);
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setLong(1, id);

            try (ResultSet resultado = statement.executeQuery()) {

                if (resultado.next()) {
                    return Optional.of(mapearLinha(resultado));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar livro: " + e.getMessage(), e);
        }

        return Optional.empty();
    }

    // Lista todos os livros cadastrados em ordem de ID.
    @Override
    public List<Livro> listarTodos() {

        List<Livro> livros = new ArrayList<>();

        String sql = "SELECT * FROM livros ORDER BY id";

        try (Connection conexao = DriverManager.getConnection(URL);
             PreparedStatement statement = conexao.prepareStatement(sql);
             ResultSet resultado = statement.executeQuery()) {

            while (resultado.next()) {
                livros.add(mapearLinha(resultado));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar livros: " + e.getMessage(), e);
        }

        return livros;
    }

    // Centraliza a conversão de uma linha do banco para um objeto Livro.
    private Livro mapearLinha(ResultSet resultado) throws SQLException {

        return new Livro(
            resultado.getLong("id"),
            resultado.getString("titulo"),
            resultado.getString("autor"),
            resultado.getDouble("preco")
        );
    }
}
