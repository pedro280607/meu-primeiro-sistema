package br.com.techcorp.main;

import br.com.techcorp.model.ControleDeAcesso;
import br.com.techcorp.model.Funcionario;

public class MainTechCorp {

    public static void main(String[] args) {

        ControleDeAcesso controleAcesso = new ControleDeAcesso();

        Funcionario f1 = new Funcionario(
                "T-001",
                "Alice",
                "Analista de Sistemas"
        );

        Funcionario f2 = new Funcionario(
                "T-001",
                "Alice Duplicada",
                "Analista de Sistemas"
        );

        controleAcesso.registrarPassagem(f1);
        controleAcesso.registrarPassagem(f2);

        controleAcesso.concederAcessoSala(f1);
        controleAcesso.concederAcessoSala(f2);
    }
}