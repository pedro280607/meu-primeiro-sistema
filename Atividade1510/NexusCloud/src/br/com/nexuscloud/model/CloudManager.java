
package br.com.nexuscloud.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Classe responsável por gerenciar os clientes e seus servidores na NexusCloud.
// RA: 25239192-2
public class CloudManager {

    // Mapa que associa cada cliente ao conjunto de servidores que pertence a ele.
    // O HashMap permite armazenar os dados utilizando a identidade lógica do Cliente.
    // RA: 25239192-2
    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    // Registra um cliente no banco de dados, criando um conjunto vazio de servidores.
    // RA: 25239192-2
    public void registrarCliente(Cliente cliente) {
        bancoDeDados.putIfAbsent(cliente, new HashSet<>());
    }

    // Adiciona um servidor ao conjunto de servidores associado ao cliente informado.
    // O computeIfAbsent também garante a criação do conjunto caso o cliente ainda não esteja registrado.
    // RA: 25239192-2
    public void adicionarServidor(Cliente cliente, Servidor servidor) {
        bancoDeDados.computeIfAbsent(cliente, chave -> new HashSet<>()).add(servidor);
    }

    // Calcula a soma dos preços por hora somente dos servidores que estão ligados.
    // Utiliza Streams para filtrar os servidores ativos e somar seus valores.
    // RA: 25239192-2
    public double calcularFaturaAtiva(Cliente cliente) {
        return bancoDeDados.getOrDefault(cliente, new HashSet<>())
                .stream()
                .filter(Servidor::isStatusLigado)
                .mapToDouble(Servidor::getPrecoPorHora)
                .sum();
    }
}
