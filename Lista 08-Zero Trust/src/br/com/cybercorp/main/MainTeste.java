package br.com.cybercorp.main;

import br.com.cybercorp.model.Credencial;
import br.com.cybercorp.model.Departamento;
import br.com.cybercorp.model.Funcionario;
import br.com.cybercorp.model.SistemaSeguranca;
import br.com.cybercorp.model.Veiculo;

public class MainTeste {

    public static void main(String[] args) {

        Departamento departamento = new Departamento(
                "TI",
                "Tecnologia da Informação",
                3
        );

        Funcionario funcionario = new Funcionario(
                "F001",
                "Pedro",
                departamento
        );

        Veiculo veiculo = new Veiculo(
                "ABC-1234",
                "Honda Civic",
                funcionario
        );

        SistemaSeguranca sistema = new SistemaSeguranca(2);

        Credencial c1 = new Credencial(
                "FFF-999",
                true,
                funcionario
        );

        Credencial clone = new Credencial(
                "FFF-999",
                true,
                funcionario
        );

        // Teste da catraca
        sistema.registrarCatraca(funcionario);
        sistema.registrarCatraca(funcionario);

        // Teste do cofre
        sistema.acessarCofre(c1);
        sistema.acessarCofre(clone);

        // Teste da garagem
        sistema.estacionarVeiculo(veiculo, 0);

        // Deve gerar ArrayIndexOutOfBoundsException
        sistema.estacionarVeiculo(veiculo, 5);
    }
}