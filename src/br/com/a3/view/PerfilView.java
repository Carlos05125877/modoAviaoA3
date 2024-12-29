
package br.com.a3.view;
import br.com.a3.model.Usuario;

// @author Carlos
public class PerfilView extends javax.swing.JFrame {
     private Usuario usuarioLogado;
     
    public PerfilView() {
        initComponents();
        usuarioLogado = Usuario.Sessao.usuarioLogado;
            nomePerfil.setText(usuarioLogado.getNomeUsuario());
            emailPerfil.setText(usuarioLogado.getEmailUsuario());
            cpfPerfil.setText(usuarioLogado.getCpfUsuario());
            telefonePerfil.setText(usuarioLogado.getTelefoneUsuario());
            dataNascimentoPerfil.setText(usuarioLogado.getDataNascUsuario().toString());        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonVoltar = new javax.swing.JButton();
        dataNascimentoPerfil = new javax.swing.JLabel();
        cpfPerfil = new javax.swing.JLabel();
        telefonePerfil = new javax.swing.JLabel();
        emailPerfil = new javax.swing.JLabel();
        nomePerfil = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonVoltar.setContentAreaFilled(false);
        jButtonVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        dataNascimentoPerfil.setBackground(new java.awt.Color(188, 205, 212));
        dataNascimentoPerfil.setForeground(new java.awt.Color(188, 205, 212));
        dataNascimentoPerfil.setText("jLabel2");
        getContentPane().add(dataNascimentoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 170, -1));

        cpfPerfil.setBackground(new java.awt.Color(188, 205, 212));
        cpfPerfil.setForeground(new java.awt.Color(188, 205, 212));
        cpfPerfil.setText("jLabel2");
        getContentPane().add(cpfPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 170, -1));

        telefonePerfil.setBackground(new java.awt.Color(188, 205, 212));
        telefonePerfil.setForeground(new java.awt.Color(188, 205, 212));
        telefonePerfil.setText("jLabel2");
        getContentPane().add(telefonePerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 170, -1));

        emailPerfil.setBackground(new java.awt.Color(188, 205, 212));
        emailPerfil.setForeground(new java.awt.Color(188, 205, 212));
        emailPerfil.setText("jLabel2");
        getContentPane().add(emailPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 170, -1));

        nomePerfil.setBackground(new java.awt.Color(188, 205, 212));
        nomePerfil.setForeground(new java.awt.Color(188, 205, 212));
        nomePerfil.setText("jLabel2");
        getContentPane().add(nomePerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/9.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 800, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
      MenuPrincipalView telaPrincipal = new MenuPrincipalView();
      telaPrincipal.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerfilView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cpfPerfil;
    private javax.swing.JLabel dataNascimentoPerfil;
    private javax.swing.JLabel emailPerfil;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nomePerfil;
    private javax.swing.JLabel telefonePerfil;
    // End of variables declaration//GEN-END:variables
}
