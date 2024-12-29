
package br.com.a3.view;

// @author Carlos

import br.com.a3.model.Reserva;

public class BilheteView extends javax.swing.JFrame {

    public BilheteView(Reserva novaReserva) {
    initComponents();
    origem.setText(novaReserva.getVoo().getOrigem());
    destino.setText(novaReserva.getVoo().getDestino());
    data.setText(new java.text.SimpleDateFormat("dd/MM/yyyy").format(novaReserva.getVoo().getData()));
    horario.setText(novaReserva.getVoo().getHorario());
    assento.setText(novaReserva.getAssento());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        destino = new javax.swing.JLabel();
        assento = new javax.swing.JLabel();
        origem = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        horario = new javax.swing.JLabel();
        jButtonPerfil = new javax.swing.JButton();
        jButtonHistorico = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        destino.setBackground(new java.awt.Color(188, 205, 212));
        destino.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        destino.setForeground(new java.awt.Color(188, 205, 212));
        destino.setText("Destino");
        destino.setToolTipText("");
        destino.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 130, 20));

        assento.setBackground(new java.awt.Color(188, 205, 212));
        assento.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        assento.setForeground(new java.awt.Color(188, 205, 212));
        assento.setText("Assento");
        assento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(assento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, -1));

        origem.setBackground(new java.awt.Color(188, 205, 212));
        origem.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        origem.setForeground(new java.awt.Color(188, 205, 212));
        origem.setText("Origem");
        origem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(origem, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 90, 20));

        data.setBackground(new java.awt.Color(188, 205, 212));
        data.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        data.setForeground(new java.awt.Color(188, 205, 212));
        data.setText("Data");
        data.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(data, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 90, -1));

        horario.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        horario.setForeground(new java.awt.Color(188, 205, 212));
        horario.setText("Horario");
        horario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, -1, -1));

        jButtonPerfil.setContentAreaFilled(false);
        jButtonPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 60, 70));

        jButtonHistorico.setContentAreaFilled(false);
        jButtonHistorico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHistoricoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonHistorico, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 70, 70));

        jButtonVoltar.setContentAreaFilled(false);
        jButtonVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/8.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 800, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPerfilActionPerformed
      PerfilView perfilView = new PerfilView();
      perfilView.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButtonPerfilActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
      MenuPrincipalView telaPrincipal = new MenuPrincipalView();
      telaPrincipal.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHistoricoActionPerformed
      HistoricoDeReservasView telaDeHistorico = new HistoricoDeReservasView();
      telaDeHistorico.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButtonHistoricoActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assento;
    private javax.swing.JLabel data;
    private javax.swing.JLabel destino;
    private javax.swing.JLabel horario;
    private javax.swing.JButton jButtonHistorico;
    private javax.swing.JButton jButtonPerfil;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel origem;
    // End of variables declaration//GEN-END:variables
}
