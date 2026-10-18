
package br.com.starlog.model;

/**
 * CAMADA MODEL (Modelo de Domínio)
 * Representa uma mensagem criptográfica a ser transmitida.
 */
public class CriptoMensagem {
    private final String remetente;
    private final String mensagem;
    private final int chaveDeslocamento;

    public CriptoMensagem(String remetente, String mensagem, int chaveDeslocamento) {

        // Validar remetente
        if (remetente == null || remetente.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Remetente não pode ser nulo ou vazio."
            );
        }

        // Validar mensagem
        if (mensagem == null || mensagem.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Mensagem não pode ser nula ou vazia."
            );
        }

        // Validar chave
        if (chaveDeslocamento < 1 || chaveDeslocamento > 25) {
            throw new IllegalArgumentException(
                "Chave deve estar entre 1 e 25."
            );
        }

        // Normalizar os dados
        this.remetente = remetente.trim().toUpperCase();
        this.mensagem = mensagem.trim().toUpperCase();
        this.chaveDeslocamento = chaveDeslocamento;
    }

    public String getRemetente() {
        return remetente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getChaveDeslocamento() {
        return chaveDeslocamento;
    }

    /**
     * Aplica a Cifra de César com deslocamento circular.
     */
    public String cifrar() {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < mensagem.length(); i++) {
            char c = mensagem.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                char cifrado = (char) (
                    'A' + (c - 'A' + chaveDeslocamento) % 26
                );
                resultado.append(cifrado);
            } else {
                resultado.append(c);
            }
        }

        return resultado.toString();
    }

    /**
     * Soma os códigos ASCII dos caracteres da mensagem em maiúsculo.
     */
    public int calcularChecksum() {
        int checksum = 0;

        for (int i = 0; i < mensagem.length(); i++) {
            checksum += (int) mensagem.charAt(i);
        }

        return checksum;
    }
}

