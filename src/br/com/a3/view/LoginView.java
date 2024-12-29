
package br.com.a3.view;
import br.com.a3.model.ConexaoBD;
import br.com.a3.model.Usuario;

import java.sql.Connection;
/**
 *
 * @author carlo
 */
public class LoginView extends javax.swing.JFrame {
    Connection conexao = ConexaoBD.conectar();
    
    /**
     * Creates new form LoginView
     */
  
    public LoginView() {
        initComponents();
        Usuario.carregarUsuariosDoBanco();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginSenha = new javax.swing.JPasswordField();
        loginEmail = new javax.swing.JTextField();
        jButtonEsqueciSenha = new javax.swing.JButton();
        jButtonCriarConta = new javax.swing.JButton();
        jButtonEntrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginSenha.setBackground(new java.awt.Color(188, 205, 212));
        loginSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(loginSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 180, -1));

        loginEmail.setBackground(new java.awt.Color(188, 205, 212));
        loginEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginEmailActionPerformed(evt);
            }
        });
        getContentPane().add(loginEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 180, -1));

        jButtonEsqueciSenha.setContentAreaFilled(false);
        jButtonEsqueciSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEsqueciSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEsqueciSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEsqueciSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 70, 20));

        jButtonCriarConta.setContentAreaFilled(false);
        jButtonCriarConta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarContaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCriarConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 80, 20));

        jButtonEntrar.setContentAreaFilled(false);
        jButtonEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 273, 120, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 800, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginEmailActionPerformed
  
    }//GEN-LAST:event_loginEmailActionPerformed

    private void jButtonEsqueciSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEsqueciSenhaActionPerformed
        EsqueciSenhaView telaRecuperarSenha = new EsqueciSenhaView();
        telaRecuperarSenha.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_jButtonEsqueciSenhaActionPerformed

    private void jButtonCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCriarContaActionPerformed
        CadastroView telaDeCadastro = new CadastroView();
        telaDeCadastro.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_jButtonCriarContaActionPerformed

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
    String email = loginEmail.getText();
    String senha = new String(loginSenha.getPassword());

    Usuario usuario = Usuario.realizarLogin(email, senha);
    if (usuario != null) {
        MenuPrincipalView telaMenuPrincipal = new MenuPrincipalView();
        telaMenuPrincipal.setVisible(true);
        dispose(); 
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Email ou senha incorretos.", "Erro de Login", javax.swing.JOptionPane.ERROR_MESSAGE);
    } 

    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void loginSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginSenhaActionPerformed

    }//GEN-LAST:event_loginSenhaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCriarConta;
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonEsqueciSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField loginEmail;
    private javax.swing.JPasswordField loginSenha;
    // End of variables declaration//GEN-END:variables
}
