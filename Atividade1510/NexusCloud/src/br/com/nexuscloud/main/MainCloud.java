
package br.com.nexuscloud.main;

import br.com.nexuscloud.model.Cliente;
import br.com.nexuscloud.model.Servidor;
import br.com.nexuscloud.model.Container;
import br.com.nexuscloud.model.CloudManager;
import br.com.nexuscloud.exception.CapacidadeExcedidaException;

// Classe principal responsável por executar os testes do sistema NexusCloud.
// RA: 25239192-2
public class MainCloud {

    // Método principal que inicia a execução do programa.
    // RA: 25239192-2
    public static void main(String[] args) {

        // Cria o gerenciador responsável por armazenar clientes e servidores.
        // RA: 25239192-2
        CloudManager manager = new CloudManager();

        // Cria um cliente com CPF e nome.
        // RA: 25239192-2
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");

        // Cria um servidor com IP, capacidade total de RAM e preço por hora.
        // O servidor começa desligado.
        // RA: 25239192-2
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);

        // Registra o cliente no gerenciador.
        // RA: 25239192-2
        manager.registrarCliente(cliente);

        // Associa o servidor ao cliente registrado.
        // RA: 25239192-2
        manager.adicionarServidor(cliente, servidor);

        // Cria o primeiro container, que necessita de 10 GB de RAM.
        // RA: 25239192-2
        Container container1 = new Container("C-01", "Aplicacao 1", 10.0);

        // Cria o segundo container, que necessita de 8 GB de RAM.
        // RA: 25239192-2
        Container container2 = new Container("C-02", "Aplicacao 2", 8.0);

                // TESTE DA EXCEÇÃO UNCHECKED:
        // Descomente a linha abaixo para testar a tentativa de alocação com o servidor desligado.
        // A exceção ServidorOfflineException deve aparecer no console.
        // Depois do teste, comente novamente para continuar a execução.
        // RA: 25239192-2
        //try {
        //    servidor.alocarContainer(container1);
       // } catch (CapacidadeExcedidaException e) {
       //     System.out.println(e.getMessage());
      //  }

        // Liga o servidor para permitir a alocação de containers.
        // RA: 25239192-2
        servidor.ligar();

       

        // Aloca o primeiro container, que utiliza 10 GB dos 16 GB disponíveis.
        // RA: 25239192-2
        try {
            servidor.alocarContainer(container1);
            System.out.println("Container C-01 alocado com sucesso!");
        } catch (CapacidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        // TESTE DA EXCEÇÃO CHECKED:
        // Tenta alocar o segundo container, mas a soma de RAM ultrapassa a capacidade.
        // RA: 25239192-2
        try {
            servidor.alocarContainer(container2);
            System.out.println("Container C-02 alocado com sucesso!");
        } catch (CapacidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        // Calcula e apresenta a fatura dos servidores que estão ligados.
        // O valor esperado é R$ 5.50.
        // RA: 25239192-2
        System.out.println("Fatura ativa: R$ " + manager.calcularFaturaAtiva(cliente));
    }
}
