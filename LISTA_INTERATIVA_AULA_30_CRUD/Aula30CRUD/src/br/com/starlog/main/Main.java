
package br.com.starlog.main;

import br.com.starlog.dao.ProdutoDAO;
import br.com.starlog.dao.ProdutoDAOSqlite;
import br.com.starlog.model.Produto;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // CREATE: cadastra dois produtos.
        ProdutoDAO dao = new ProdutoDAOSqlite();

        Produto teclado = new Produto(
            "Teclado Mecânico RGB",
            259.90,
            10
        );

        Produto mousepad = new Produto(
            "Mousepad Speed XL",
            79.90,
            20
        );

        dao.salvar(teclado);
        dao.salvar(mousepad);

        System.out.println("=== PRODUTOS CADASTRADOS ===");
        System.out.println("Teclado - ID: " + teclado.getId());
        System.out.println("Mousepad - ID: " + mousepad.getId());

        // READ: lista todos os produtos cadastrados.
        System.out.println("\n=== LISTA DE PRODUTOS ===");
        imprimirProdutos(dao.listarTodos());

        // UPDATE: altera o estoque e o preço do teclado.
        System.out.println("\n=== ATUALIZAÇÃO DO TECLADO ===");

        teclado.setEstoque(15);
        teclado.setPreco(289.90);

        boolean atualizado = dao.atualizar(teclado);

        if (atualizado) {
            System.out.println("Produto atualizado com sucesso!");
            dao.buscarPorId(teclado.getId()).ifPresent(System.out::println);
        } else {
            System.out.println("Não foi possível atualizar o produto.");
        }

        // DELETE: exclui o Mousepad pelo ID.
        System.out.println("\n=== EXCLUSÃO DO MOUSEPAD ===");

        boolean excluido = dao.excluir(mousepad.getId());

        if (excluido) {
            System.out.println("Mousepad excluído com sucesso!");
        } else {
            System.out.println("Mousepad não encontrado.");
        }

        // Testa a exclusão de um ID inexistente.
        System.out.println("\n=== EXCLUSÃO DE ID INEXISTENTE ===");

        boolean exclusaoInexistente = dao.excluir(888L);

        if (exclusaoInexistente) {
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Nenhum produto encontrado com o ID 888.");
        }

        // FINAL STATE: mostra os produtos restantes.
        System.out.println("\n=== ESTADO FINAL DO ESTOQUE ===");

        List<Produto> produtosFinais = dao.listarTodos();

        imprimirProdutos(produtosFinais);

        System.out.println("\nTotal de produtos restantes: " + produtosFinais.size());
    }

    // Exibe os produtos em formato de tabela.
    private static void imprimirProdutos(List<Produto> produtos) {

        System.out.printf(
            "%-5s | %-30s | %12s | %8s%n",
            "ID", "NOME", "PREÇO", "ESTOQUE"
        );

        System.out.println("--------------------------------------------------------------------------");

        for (Produto produto : produtos) {
            System.out.printf(
                "%-5d | %-30s | R$ %9.2f | %8d%n",
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getEstoque()
            );
        }
    }
}
