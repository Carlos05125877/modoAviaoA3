
package br.com.a3.view;

import br.com.a3.model.Pagamento;
import br.com.a3.model.Reserva;
import br.com.a3.model.Usuario;
import br.com.a3.model.Usuario.Sessao;
import br.com.a3.model.Voo;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PagamentoView extends javax.swing.JFrame {

    private Voo vooSelecionado;
    private String assento;
    public PagamentoView(Voo vooSelecionado, String assento) {
    this.vooSelecionado = vooSelecionado;
    this.assento = assento;
    initComponents();
    carregarDadosDoVoo();
    }

    private void carregarDadosDoVoo() {
        if (vooSelecionado != null) {
            voo.setText(String.format("%-20s %-20s %-21s %-16s R$%-8.2f%n",
                vooSelecionado.origem, vooSelecionado.destino,
                new SimpleDateFormat("dd/MM/yyyy").format(vooSelecionado.data),
                vooSelecionado.horario, vooSelecionado.valor));
        }
    }
private void validarPagamento() {
    String numero = numeroCartao.getText();
    String nome = nomeCartao.getText();
    String cvv = cvvCartao.getText();
    String dataTexto = jFormattedTextField1.getText();

    if (numero.isEmpty() || nome.isEmpty() || cvv.isEmpty() || dataTexto.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!");
        return;
    }

    Date dataVencimento;
    try {
        dataVencimento = new java.text.SimpleDateFormat("dd/MM/yy").parse(dataTexto);
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Data de vencimento inválida!");
        return;
    }

    Pagamento pagamento = new Pagamento(1, "Cartão de Crédito", new Date(), vooSelecionado.getValor(), "Pendente");

    if (!pagamento.ValidarNumero(numero) || !pagamento.ValidarCvv(cvv) || !pagamento.ValidarData(dataVencimento)) {
        javax.swing.JOptionPane.showMessageDialog(this, "Informações de pagamento inválidas!");
        return;
    }

    boolean sucesso = pagamento.processarPagamento();
    if (sucesso) {
        Usuario usuarioLogado = Sessao.usuarioLogado;
        if (usuarioLogado == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro: nenhum usuário está logado!");
            return;
        }
        System.out.println("Assento Selecionado: "+assento);
        Reserva novaReserva = new Reserva(0, new Date(), assento, usuarioLogado, vooSelecionado);
        if (novaReserva.salvarNoBanco()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pagamento realizado com sucesso!");
            BilheteView bilhete = new BilheteView(novaReserva);
            bilhete.setVisible(true);
            dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao salvar a reserva no banco!");
        }
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Falha no processamento do pagamento!");
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cvvCartao = new javax.swing.JTextField();
        nomeCartao = new javax.swing.JTextField();
        numeroCartao = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        voo = new javax.swing.JLabel();
        valor = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonVoltar = new javax.swing.JButton();
        jButtonConfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cvvCartao.setBackground(new java.awt.Color(188, 205, 212));
        cvvCartao.setToolTipText("");
        getContentPane().add(cvvCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 50, -1));

        nomeCartao.setBackground(new java.awt.Color(188, 205, 212));
        nomeCartao.setToolTipText("");
        getContentPane().add(nomeCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 170, -1));

        numeroCartao.setBackground(new java.awt.Color(188, 205, 212));
        numeroCartao.setToolTipText("");
        getContentPane().add(numeroCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 170, -1));

        jFormattedTextField1.setBackground(new java.awt.Color(188, 205, 212));
        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        getContentPane().add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 120, -1));

        voo.setBackground(new java.awt.Color(188, 205, 212));
        voo.setFont(new java.awt.Font("Engravers MT", 0, 10)); // NOI18N
        voo.setForeground(new java.awt.Color(188, 205, 212));
        getContentPane().add(voo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 460, 20));
        getContentPane().add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 50, 20));

        jComboBox1.setBackground(new java.awt.Color(188, 205, 212));
        jComboBox1.setFont(new java.awt.Font("Engravers MT", 0, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Débito", "Crédito" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 130, 30));

        jButtonVoltar.setContentAreaFilled(false);
        jButtonVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        jButtonConfirmar.setContentAreaFilled(false);
        jButtonConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 120, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/7.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 800, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
      MenuPrincipalView telaPrincipal = new MenuPrincipalView();
      telaPrincipal.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
     validarPagamento();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cvvCartao;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nomeCartao;
    private javax.swing.JTextField numeroCartao;
    private javax.swing.JLabel valor;
    private javax.swing.JLabel voo;
    // End of variables declaration//GEN-END:variables

 
}
