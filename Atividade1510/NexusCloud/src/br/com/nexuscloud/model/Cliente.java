package br.com.nexuscloud.model;

// Importa Objects para facilitar a comparação dos atributos
// utilizados nos métodos equals e hashCode. RA: 25239192-2
import java.util.Objects;

// Representa um cliente cadastrado no sistema NexusCloud. RA: 25239192-2
public class Cliente {

    // Armazena o CPF e o nome do cliente com encapsulamento. RA: 25239192-2
    private String cpf;
    private String nome;

    // Construtor responsável por inicializar os dados do cliente. RA: 25239192-2
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Retorna o CPF armazenado no objeto Cliente. RA: 25239192-2
    public String getCpf() {
        return cpf;
    }

    // Retorna o nome armazenado no objeto Cliente. RA: 25239192-2
    public String getNome() {
        return nome;
    }

    // Compara dois clientes considerando exclusivamente o CPF como identidade. RA: 25239192-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Cliente cliente = (Cliente) obj;
        return Objects.equals(cpf, cliente.cpf);
    }

    // Gera o código hash utilizando exclusivamente o CPF do cliente. RA: 25239192-2
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}