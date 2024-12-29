
package br.com.a3.view;

import br.com.a3.model.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class CadastroView extends javax.swing.JFrame {
    private String nomeUsuario;
    private String emailUsuario;
    private String telefoneUsuario;
    private String cpfUsuario;
    private Date dataNascUsuario;

    public CadastroView() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        email = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        dataNascimento = new javax.swing.JFormattedTextField();
        senha = new javax.swing.JPasswordField();
        jButtonVoltar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        email.setBackground(new java.awt.Color(188, 205, 212));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 180, -1));

        nome.setBackground(new java.awt.Color(188, 205, 212));
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });
        getContentPane().add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 180, -1));

        telefone.setBackground(new java.awt.Color(188, 205, 212));
        telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneActionPerformed(evt);
            }
        });
        getContentPane().add(telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 180, -1));

        cpf.setBackground(new java.awt.Color(188, 205, 212));
        cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfActionPerformed(evt);
            }
        });
        getContentPane().add(cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 180, -1));

        dataNascimento.setBackground(new java.awt.Color(188, 205, 212));
        dataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        getContentPane().add(dataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 120, -1));

        senha.setBackground(new java.awt.Color(188, 205, 212));
        getContentPane().add(senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 180, -1));

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
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 120, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 800, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        emailUsuario = email.getText().trim();
    }//GEN-LAST:event_emailActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
      LoginView telaDeLogin = new LoginView();
      telaDeLogin.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
       nomeUsuario = nome.getText().trim();
    }//GEN-LAST:event_nomeActionPerformed

    private void telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneActionPerformed
        telefoneUsuario = telefone.getText().trim();
    }//GEN-LAST:event_telefoneActionPerformed

    private void cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfActionPerformed
        cpfUsuario = cpf.getText().trim();
    }//GEN-LAST:event_cpfActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
    // Captura os valores dos campos de texto
    String nomeUsuario = nome.getText();
    String emailUsuario = email.getText();
    String senhaUsuario = new String(senha.getPassword());
    String cpfUsuario = cpf.getText();
    String telefoneUsuario = telefone.getText();
    String dataNascimentoTexto = dataNascimento.getText();

    // Validação de data
    Date dataNascUsuario = null;
    try {
        dataNascUsuario = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoTexto);
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Data de nascimento inválida. Use o formato DD/MM/YYYY.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Verificação de duplicidade
    if (Usuario.verificarDuplicidade("emailUsuario", emailUsuario)) {
        JOptionPane.showMessageDialog(this, "Erro: Este e-mail já está cadastrado.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (Usuario.verificarDuplicidade("cpfUsuario", cpfUsuario)) {
        JOptionPane.showMessageDialog(this, "Erro: Este CPF já está cadastrado.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Cadastra o usuário usando a classe Usuario
    Usuario usuario = Usuario.cadastrarUsuario(nomeUsuario, emailUsuario, senhaUsuario, cpfUsuario, telefoneUsuario, dataNascUsuario);

    if (usuario != null) {
        // Confirmação do cadastro e redirecionamento para a tela de login
        JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        LoginView telaDeLogin = new LoginView();
        telaDeLogin.setVisible(true);
        dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao realizar o cadastro. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpf;
    private javax.swing.JFormattedTextField dataNascimento;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nome;
    private javax.swing.JPasswordField senha;
    private javax.swing.JTextField telefone;
    // End of variables declaration//GEN-END:variables
}
