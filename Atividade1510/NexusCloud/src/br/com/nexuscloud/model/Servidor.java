package br.com.nexuscloud.model;

// Importa ArrayList e List para armazenar os containers do servidor.
// RA: 25239192-2
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.nexuscloud.exception.CapacidadeExcedidaException;
import br.com.nexuscloud.exception.ServidorOfflineException;

// Representa um servidor da infraestrutura de nuvem NexusCloud. RA: 25239192-2
public class Servidor {

    // Armazena o endereço IP, a RAM total, o preço por hora e o estado do servidor.
    // A lista guarda os containers alocados. RA: 25239192-2
    private String ip;
    private double ramTotal;
    private double precoPorHora;
    private boolean statusLigado;
    private List<Container> containers = new ArrayList<>();

    // Inicializa os dados do servidor, que começa desligado. RA: 25239192-2
    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip;
        this.ramTotal = ramTotal;
        this.precoPorHora = precoPorHora;
        this.statusLigado = false;
    }

    // Retorna o endereço IP do servidor. RA: 25239192-2
    public String getIp() {
        return ip;
    }

    // Retorna a quantidade total de memória RAM do servidor. RA: 25239192-2
    public double getRamTotal() {
        return ramTotal;
    }

    // Retorna o preço cobrado por hora de utilização. RA: 25239192-2
    public double getPrecoPorHora() {
        return precoPorHora;
    }

    // Informa se o servidor está ligado. RA: 25239192-2
    public boolean isStatusLigado() {
        return statusLigado;
    }

    // Liga o servidor alterando seu estado para verdadeiro. RA: 25239192-2
    public void ligar() {
        this.statusLigado = true;
    }

    // Desliga o servidor alterando seu estado para falso. RA: 25239192-2
    public void desligar() {
        this.statusLigado = false;
    }

    // Calcula a soma da memória RAM utilizada pelos containers usando Streams API.
    // RA: 25239192-2
    public double calcularRamEmUso() {
        return containers.stream()
                .mapToDouble(Container::getRamNecessaria)
                .sum();
    }

    // Verifica o estado e a capacidade do servidor antes de adicionar um container.
    // RA: 25239192-2
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {

        if (!statusLigado) {
            throw new ServidorOfflineException(
                    "Erro: Não é possível alocar containers em um servidor desligado.");
        }

        if (calcularRamEmUso() + c.getRamNecessaria() > ramTotal) {
            throw new CapacidadeExcedidaException(
                    "Falha Crítica: Memória RAM insuficiente no servidor " + ip + ".");
        }

        containers.add(c);
    }

    // Compara dois servidores considerando exclusivamente o endereço IP. RA: 25239192-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Servidor servidor = (Servidor) obj;
        return Objects.equals(ip, servidor.ip);
    }

    // Gera o código hash utilizando exclusivamente o endereço IP. RA: 25239192-2
    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }
}