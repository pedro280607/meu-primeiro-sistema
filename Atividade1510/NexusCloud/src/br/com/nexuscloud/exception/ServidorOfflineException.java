package br.com.nexuscloud.exception;

// Exceção utilizada quando alguém tenta alocar um container em um servidor desligado.
// RA: 25239192-2
public class ServidorOfflineException extends RuntimeException {

    // Construtor que recebe a mensagem de erro e encaminha para RuntimeException.
    // RA: 25239192-2
    public ServidorOfflineException(String mensagem) {
        super(mensagem);
    }
}