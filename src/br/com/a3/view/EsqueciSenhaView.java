
package br.com.a3.view;
import br.com.a3.model.Usuario;
import javax.swing.JOptionPane;

// @author Carlos
public class EsqueciSenhaView extends javax.swing.JFrame {
    public EsqueciSenhaView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginEmail = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        loginSenha = new javax.swing.JPasswordField();
        jButtonVoltar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginEmail.setBackground(new java.awt.Color(188, 205, 212));
        loginEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginEmailActionPerformed(evt);
            }
        });
        getContentPane().add(loginEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 180, -1));

        cpf.setBackground(new java.awt.Color(188, 205, 212));
        cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfActionPerformed(evt);
            }
        });
        getContentPane().add(cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 180, -1));

        loginSenha.setBackground(new java.awt.Color(188, 205, 212));
        getContentPane().add(loginSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 180, -1));

        jButtonVoltar.setContentAreaFilled(false);
        jButtonVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        jButtonSalvar.setContentAreaFilled(false);
        jButtonSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/3.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 800, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginEmailActionPerformed

    private void cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        LoginView telaDeLogin = new LoginView();
        telaDeLogin.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
    String email = loginEmail.getText(); 
    String cpfText = cpf.getText();      
    String novaSenha = new String(loginSenha.getPassword());

    if (email.isEmpty() || cpfText.isEmpty() || novaSenha.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
        return;
    }

    boolean sucesso = Usuario.esqueciSenha(email, cpfText, novaSenha);

    if (sucesso) {
        JOptionPane.showMessageDialog(this, "Senha atualizada com sucesso!");
        LoginView telaDeLogin = new LoginView();
        telaDeLogin.setVisible(true);
        dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao atualizar a senha. Verifique os dados.");
    }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EsqueciSenhaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpf;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField loginEmail;
    private javax.swing.JPasswordField loginSenha;
    // End of variables declaration//GEN-END:variables
}
