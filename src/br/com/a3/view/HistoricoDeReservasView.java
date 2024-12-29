
package br.com.a3.view;

import br.com.a3.model.Reserva;
import br.com.a3.model.Usuario;
import java.util.List;
import javax.swing.DefaultListModel;

public class HistoricoDeReservasView extends javax.swing.JFrame {
    private Usuario usuarioLogado;

    public HistoricoDeReservasView() {
        this.usuarioLogado = usuarioLogado;
        initComponents();
        carregarReservas();
    }

private void carregarReservas() {
    List<Reserva> reservas = new Reserva().buscarReservas();
    DefaultListModel<String> listModel = new DefaultListModel<>(); // Modelo com String

    for (Reserva reserva : reservas) {
        // Adiciona a data do voo, origem e destino como String no modelo
        String item = String.format("%-22s  %-22s  %-22s",
            reserva.getVoo() != null && reserva.getVoo().getData() != null ? 
            new java.text.SimpleDateFormat("dd/MM/yyyy").format(reserva.getVoo().getData()) : "N/A",
            reserva.getVoo() != null ? reserva.getVoo().getOrigem() : "N/A",
            reserva.getVoo() != null ? reserva.getVoo().getDestino() : "N/A");
        listModel.addElement(item);
    }

    jListReservas.setModel(listModel); // Configura o modelo no JList
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonPerfil = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListReservas = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonPerfil.setContentAreaFilled(false);
        jButtonPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 60, 70));

        jButtonVoltar.setContentAreaFilled(false);
        jButtonVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        jScrollPane1.setBorder(null);

        jListReservas.setBackground(new java.awt.Color(28, 82, 105));
        jListReservas.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jListReservas.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        jListReservas.setForeground(new java.awt.Color(188, 205, 212));
        jListReservas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListReservas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 430, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/5.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 800, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
      MenuPrincipalView telaPrincipal = new MenuPrincipalView();
      telaPrincipal.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPerfilActionPerformed
      PerfilView perfilView = new PerfilView();
      perfilView.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButtonPerfilActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoricoDeReservasView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPerfil;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jListReservas;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
