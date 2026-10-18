
package br.com.starlog.controller;

import br.com.starlog.model.CriptoMensagem;
import java.util.ArrayList;
import java.util.List;

public class TransmissaoController {

    private final List<String> bufferTransmissoes = new ArrayList<>();

    public String processarTransmissao(
            String remetenteRaw,
            String msgRaw,
            String chaveStr) {

        int chave;

        // 1. Converter a chave para inteiro
        try {
            chave = Integer.parseInt(chaveStr.trim());
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException(
                "Chave deve ser um número inteiro válido."
            );
        }

        // 2. Criar o objeto do Model
        CriptoMensagem cripto = new CriptoMensagem(
            remetenteRaw,
            msgRaw,
            chave
        );

        // 3. Obter a mensagem cifrada e o checksum
        String textoCifrado = cripto.cifrar();
        int checksum = cripto.calcularChecksum();

        // 4. Montar o pacote de transmissão
        String pacote = String.format(
            "[%s] #%d -> %s",
            cripto.getRemetente(),
            checksum,
            textoCifrado
        );

        // 5. Guardar no histórico
        bufferTransmissoes.add(pacote);

        // 6. Retornar o pacote
        return pacote;
    }

    public int getTotalTransmissoes() {
        return bufferTransmissoes.size();
    }
}
