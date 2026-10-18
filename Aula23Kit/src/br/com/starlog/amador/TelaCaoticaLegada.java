
package br.com.starlog.amador;

import javax.swing.*;
import java.awt.*;

import br.com.starlog.controller.TransmissaoController;

/**
 * VIEW: responsável pela interface gráfica.
 * As regras de negócio ficam no Model e no Controller.
 */
public class TelaCaoticaLegada extends JFrame {

    private JTextField txtRemetente;
    private JTextField txtMensagem;
    private JTextField txtChaveCifra;
    private JButton btnDespacharCifrado;
    private JTextArea areaLog;

    // A tela delega o processamento ao Controller.
    private final TransmissaoController controller =
            new TransmissaoController();

    public TelaCaoticaLegada() {
        super("SISTEMA STARLOG");

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Remetente da Frota:"));
        txtRemetente = new JTextField(20);
        add(txtRemetente);

        add(new JLabel("Mensagem Secreta:"));
        txtMensagem = new JTextField(20);
        add(txtMensagem);

        add(new JLabel("Chave de Deslocamento (César 1 a 25):"));
        txtChaveCifra = new JTextField(5);
        add(txtChaveCifra);

        btnDespacharCifrado = new JButton("Cifrar e Transmitir");
        add(btnDespacharCifrado);

        areaLog = new JTextArea(10, 35);
        areaLog.setEditable(false);
        add(new JScrollPane(areaLog));

        // O botão apenas coleta os dados e delega o processamento.
        btnDespacharCifrado.addActionListener(e -> {
            String remetente = txtRemetente.getText();
            String mensagem = txtMensagem.getText();
            String chave = txtChaveCifra.getText();

            try {
                String pacote = controller.processarTransmissao(
                        remetente,
                        mensagem,
                        chave
                );

                areaLog.append(pacote + "\n");

                JOptionPane.showMessageDialog(
                        this,
                        "Transmissão efetuada com sucesso!"
                );

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Erro na transmissão",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new TelaCaoticaLegada().setVisible(true)
        );
    }
}
