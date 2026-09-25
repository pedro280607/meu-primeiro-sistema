package br.com.technexus.main;

import br.com.technexus.model.Loja;
import br.com.technexus.model.Produto;

public class Main {

    public static void main(String[] args) {

        Loja loja = new Loja();

        // 2 GAMES
        loja.cadastrar(
                new Produto("The Witcher", "GAMES", 150.00)
        );

        loja.cadastrar(
                new Produto("FIFA", "GAMES", 200.00)
        );

        // 2 LIVROS
        loja.cadastrar(
                new Produto("Java for Dummies", "LIVROS", 100.00)
        );

        loja.cadastrar(
                new Produto("Clean Code", "LIVROS", 80.00)
        );

        // 1 HARDWARE
        loja.cadastrar(
                new Produto("Mouse", "HARDWARE", 50.00)
        );


        // Buscar somente GAMES
        System.out.println("=== GAMES ===");

        System.out.println(
                loja.buscarPorCategoria("GAMES")
        );


        // Patrimônio total
        System.out.println("=== PATRIMÔNIO TOTAL ===");

        System.out.println(
                loja.calcularPatrimonioTotal()
        );


        // Total dos livros
        System.out.println("=== TOTAL LIVROS ===");

        System.out.println(
                loja.calcularTotalPorCategoria("LIVROS")
        );
    }
}