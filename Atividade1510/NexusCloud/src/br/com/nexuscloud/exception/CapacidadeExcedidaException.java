package br.com.nexuscloud.exception;

// Exceção utilizada quando a memória RAM disponível é insuficiente.
// RA: 25239192-2
public class CapacidadeExcedidaException extends Exception {

    // Construtor que recebe a mensagem de erro e encaminha para a classe Exception.
    // RA: 25239192-2
    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem);
    }
}