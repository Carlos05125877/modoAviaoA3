
package br.com.a3.view;

import br.com.a3.model.Usuario;
import br.com.a3.model.Voo;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MenuPrincipalView extends javax.swing.JFrame {
    
    private String assento_coluna;
    private String assento_fila;
    
    private ArrayList<Voo> listaVoos = new ArrayList<>();
    


    public MenuPrincipalView() {
        initComponents();
        carregarOpcoesDeVoo();
    }
    
    private void carregarOpcoesDeVoo() {
        listaVoos.clear(); // Limpa a lista para evitar dados antigos
        selecionarVoo.setFont(new Font("Monospaced", Font.PLAIN, 12));
        selecionarVoo.removeAllItems(); // Limpa os itens do JComboBox
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Voo> voosCarregados = new Voo().carregarVoos(); // Carrega os voos do banco

        for (Voo voo : voosCarregados) {
            String vooFormatado = String.format("%-20s %-20s %-18s %-11s R$%-8.2f%n",
                voo.origem, voo.destino,
                formatoData.format(voo.data),
                voo.horario, voo.valor);
        

        selecionarVoo.addItem(vooFormatado); // Adiciona a descrição no JComboBox
        listaVoos.add(voo); // Armazena o objeto Voo correspondente
    }
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonHistorico = new javax.swing.JButton();
        jButtonPerfil = new javax.swing.JButton();
        selecionarVoo = new javax.swing.JComboBox<>();
        jButtonVoltar = new javax.swing.JButton();
        jButtonProsseguir = new javax.swing.JButton();
        assentoColuna = new javax.swing.JTextField();
        assentoFila = new javax.swing.JTextField();
        jButtonVerMapa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonHistorico.setContentAreaFilled(false);
        jButtonHistorico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHistoricoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonHistorico, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 70, 70));

        jButtonPerfil.setContentAreaFilled(false);
        jButtonPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 70, 70));

        selecionarVoo.setBackground(new java.awt.Color(188, 205, 212));
        selecionarVoo.setFont(new java.awt.Font("Engravers MT", 0, 12)); // NOI18N
        selecionarVoo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selecionarVoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionarVooActionPerformed(evt);
            }
        });
        getContentPane().add(selecionarVoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 620, 30));

        jButtonVoltar.setContentAreaFilled(false);
        jButtonVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        jButtonProsseguir.setContentAreaFilled(false);
        jButtonProsseguir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonProsseguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProsseguirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonProsseguir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 120, 40));

        assentoColuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assentoColunaActionPerformed(evt);
            }
        });
        getContentPane().add(assentoColuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 30, -1));

        assentoFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assentoFilaActionPerformed(evt);
            }
        });
        getContentPane().add(assentoFila, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 30, -1));

        jButtonVerMapa.setContentAreaFilled(false);
        jButtonVerMapa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVerMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerMapaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVerMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 120, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/4.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 800, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
      LoginView telaDeLogin = new LoginView();
      telaDeLogin.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonProsseguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProsseguirActionPerformed
       String assento_fila = assentoFila.getText();
       String assento_coluna = assentoColuna.getText();
       
       if (assento_fila.isEmpty() || assento_coluna.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, preencha ambos os campos de assento.");
        return;
    }
       String assento = assento_fila+assento_coluna;
       
        int indiceSelecionado = selecionarVoo.getSelectedIndex(); // Obtém o índice do item selecionado

    if (indiceSelecionado >= 0) { // Verifica se um item foi selecionado
        Voo vooSelecionado = listaVoos.get(indiceSelecionado); // Busca o objeto Voo correspondente
        PagamentoView telaDePagamento = new PagamentoView(vooSelecionado, assento); // Passa o objeto para a próxima tela
        telaDePagamento.setVisible(true);
        dispose(); // Fecha a tela atual
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecione um voo.");
    }
    
    
    }//GEN-LAST:event_jButtonProsseguirActionPerformed

    private void jButtonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPerfilActionPerformed
      PerfilView perfilView = new PerfilView();
      perfilView.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButtonPerfilActionPerformed

    private void jButtonHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHistoricoActionPerformed
      HistoricoDeReservasView telaDeHistorico = new HistoricoDeReservasView();
      telaDeHistorico.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButtonHistoricoActionPerformed

    private void selecionarVooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarVooActionPerformed

    }//GEN-LAST:event_selecionarVooActionPerformed

    private void assentoFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assentoFilaActionPerformed
        assento_fila = assentoFila.getText().trim();
    }//GEN-LAST:event_assentoFilaActionPerformed

    private void assentoColunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assentoColunaActionPerformed
        assento_coluna = assentoColuna.getText().trim();
    }//GEN-LAST:event_assentoColunaActionPerformed

    private void jButtonVerMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerMapaActionPerformed
      MapaDeAssentosView telaDeAssentos = new MapaDeAssentosView();
      telaDeAssentos.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButtonVerMapaActionPerformed

   
   
    public static void main(String args[]) {
  

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalView().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField assentoColuna;
    private javax.swing.JTextField assentoFila;
    private javax.swing.JButton jButtonHistorico;
    private javax.swing.JButton jButtonPerfil;
    private javax.swing.JButton jButtonProsseguir;
    private javax.swing.JButton jButtonVerMapa;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> selecionarVoo;
    // End of variables declaration//GEN-END:variables
}
