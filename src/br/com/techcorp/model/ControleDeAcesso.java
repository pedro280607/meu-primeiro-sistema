package br.com.techcorp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ControleDeAcesso {

    private List<Funcionario> historicoCatraca = new ArrayList<>();
    private Set<Funcionario> autorizadosSalaSegura = new HashSet<>();

    public void registrarPassagem(Funcionario funcionario) {
        historicoCatraca.add(funcionario);
    }

    public void concederAcessoSala(Funcionario funcionario) {
        boolean foiAdicionado = autorizadosSalaSegura.add(funcionario);

        if (foiAdicionado) {
            System.out.println("Acesso liberado para a Sala Segura");
        } else {
            System.out.println("Aviso: Matrícula já registrada na sala. Acesso não permitido.");
        }
    }
}