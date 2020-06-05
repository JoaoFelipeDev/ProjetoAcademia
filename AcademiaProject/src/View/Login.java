/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ramon
 */
public class Login extends javax.swing.JFrame {
    private String nome, senha;
    private int encontrou;
    
   // private MenuPrincipal entrarMenu;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        nome = "";
        senha = "";
        encontrou = 0;
      // MenuPrincipal entrarMenu = new MenuPrincipal();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelSenha = new javax.swing.JLabel();
        LabelUsuario = new javax.swing.JLabel();
        TextUsuario = new javax.swing.JTextField();
        TextSenha = new javax.swing.JPasswordField();
        ButtonLogin = new javax.swing.JButton();
        LabelTitulo = new javax.swing.JLabel();
        LabelTemplate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelSenha.setFont(new java.awt.Font("Haettenschweiler", 0, 36)); // NOI18N
        LabelSenha.setForeground(new java.awt.Color(255, 255, 255));
        LabelSenha.setText("Senha:");
        getContentPane().add(LabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        LabelUsuario.setFont(new java.awt.Font("Haettenschweiler", 0, 36)); // NOI18N
        LabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LabelUsuario.setText("Usuário:");
        getContentPane().add(LabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));
        getContentPane().add(TextUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 390, 40));
        getContentPane().add(TextSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 390, 40));

        ButtonLogin.setBackground(new java.awt.Color(255, 255, 255));
        ButtonLogin.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        ButtonLogin.setForeground(new java.awt.Color(51, 51, 51));
        ButtonLogin.setText("Entrar");
        ButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 160, 70));

        LabelTitulo.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setText("Login");
        getContentPane().add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        LabelTemplate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/login.jpg"))); // NOI18N
        getContentPane().add(LabelTemplate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoginActionPerformed
        // TODO add your handling code here:
        //entrarMenu.setVisible(true);
        //this.dispose();
        String n, s;
        nome = TextUsuario.getText();
        senha = TextSenha.getText();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/academia","root","");
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery("Select * from logar");
            
            while(res.next())
            {
                n = res.getString("nome");
                s = res.getString("senha");
                
                if(nome.equals(n) && senha.equals(s))
                {
                    encontrou = 1;
                }
                else
                {
                    encontrou = 0;
                }
            }
            if(encontrou == 1)
            {
                
                JOptionPane.showMessageDialog(null,"Login realizado","Sucesso",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Login e/ou usuário errado(s)","Erro",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(ClassNotFoundException e)
        {
               JOptionPane.showMessageDialog(null,e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);           
        }
        catch(SQLException e)
        {
               JOptionPane.showMessageDialog(null,e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_ButtonLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLogin;
    private javax.swing.JLabel LabelSenha;
    private javax.swing.JLabel LabelTemplate;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JPasswordField TextSenha;
    private javax.swing.JTextField TextUsuario;
    // End of variables declaration//GEN-END:variables
}
