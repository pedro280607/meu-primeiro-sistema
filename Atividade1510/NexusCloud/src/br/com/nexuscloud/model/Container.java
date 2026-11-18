package br.com.nexuscloud.model;

// Importa Objects para realizar a comparação de identidade
// e gerar o código hash utilizando o ID do container. RA: 25239192-2
import java.util.Objects;

// Representa um container (aplicação) dentro da infraestrutura NexusCloud. RA: 25239192-2
public class Container {

    // Armazena o identificador único, o nome da aplicação e a RAM necessária. RA: 25239192-2
    private String id;
    private String nomeApp;
    private double ramNecessaria;

    // Construtor utilizado para inicializar os dados do container. RA: 25239192-2
    public Container(String id, String nomeApp, double ramNecessaria) {
        this.id = id;
        this.nomeApp = nomeApp;
        this.ramNecessaria = ramNecessaria;
    }

    // Retorna o identificador do container. RA: 25239192-2
    public String getId() {
        return id;
    }

    // Permite atualizar o identificador do container. RA: 25239192-2
    public void setId(String id) {
        this.id = id;
    }

    // Retorna o nome da aplicação armazenada no container. RA: 25239192-2
    public String getNomeApp() {
        return nomeApp;
    }

    // Permite atualizar o nome da aplicação. RA: 25239192-2
    public void setNomeApp(String nomeApp) {
        this.nomeApp = nomeApp;
    }

    // Retorna a quantidade de memória RAM necessária para o container. RA: 25239192-2
    public double getRamNecessaria() {
        return ramNecessaria;
    }

    // Permite atualizar a quantidade de memória RAM necessária. RA: 25239192-2
    public void setRamNecessaria(double ramNecessaria) {
        this.ramNecessaria = ramNecessaria;
    }

    // Compara dois containers considerando exclusivamente o ID como identidade. RA: 25239192-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Container container = (Container) obj;
        return Objects.equals(id, container.id);
    }

    // Gera o código hash utilizando exclusivamente o ID do container. RA: 25239192-2
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}