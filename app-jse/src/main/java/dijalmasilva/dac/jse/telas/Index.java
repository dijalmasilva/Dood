/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates

 * and open the template in the editor.
 */
package dijalmasilva.dac.jse.telas;

import dijalmasilva.dac.shared.entidades.Usuario;
import dijalmasilva.dac.shared.interfaces.ConviteService;
import dijalmasilva.dac.shared.interfaces.DoodService;
import dijalmasilva.dac.shared.interfaces.UserService;
import javax.swing.JOptionPane;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class Index extends javax.swing.JFrame {

    private final String userEnd = "java:global/dood-core/UsuarioServiceImpl";
    private final String doodEnd = "java:global/dood-core/DoodServiceImpl";
    private final String convEnd = "java:global/dood-core/ConviteServiceImpl";

    /**
     * Creates new form Index
     */
    public Index() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private boolean isEmailValido(String email) {
        if (email.equals("")) {
            return false;
        }

        if (!email.contains("@")) {
            return false;
        }

        return email.contains(".com");
    }

    private boolean isUserValido(Usuario user) {

        if (user == null) {
            return false;
        }

        return user.getClass().getSimpleName().equals("Administrador");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        btLogar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textPassword = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("GERENCIAMENTO DO SISTEMA DOOD");

        btLogar.setText("Logar");
        btLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogarActionPerformed(evt);
            }
        });

        jLabel2.setText("Email:");

        jLabel3.setText("Senha:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Dood.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addComponent(textEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textPassword))
                        .addGap(137, 137, 137))))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(207, 207, 207))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogarActionPerformed
        // TODO add your handling code here:
        UserService userService = new ServiceLocator().lookup(userEnd, UserService.class);
        DoodService doodService = new ServiceLocator().lookup(doodEnd, DoodService.class);
        ConviteService cService = new ServiceLocator().lookup(convEnd, ConviteService.class);

//        Usuario u = new Administrador("admin@gmail.com", "Dijalma", "Silva", "manoeldj20", TypeSexo.MASCULINO, LocalDate.now());
//        userService.save(u);
//        Usuario u2 = new Administrador("dijalmacz@gmail.com", "Dijalma", "Silva", "manoeldj20", TypeSexo.MASCULINO, LocalDate.now());
//        userService.save(u2);
//        String email = textEmail.getText();
//        String senha = textPassword.getText();
        Usuario admin = userService.find("admin@gmail.com");
        Usuario dijalma = userService.find("dijalmacz@gmail.com");
        admin.seguir(dijalma);
        userService.update(admin);
//        Convite c = new Convite("teste@gmail", "descricao", TypeUser.Professor);
//        c.gerarLink();
//        cService.solicitaConvite(c);
//        doodService.save(new Dood("Dijalma", "doija", null));
//        Dood find = doodService.find("JPA");
//        JOptionPane.showMessageDialog(null, find);
//        if (isEmailValido(email)) {
//            if (senha.equals("")) {
//                exibeSenhaInvalido();
//            } else {
//                Usuario user = userService.login(email, senha);
//                if (isUserValido(user)) {
//                    Administrador admin = (Administrador) user;
//                    JOptionPane.showConfirmDialog(null, admin);
//                } else {
//                    exibeUserInvalido();
//                }
//            }
//        } else {
//            exibeEmailInvalido();
//        }

    }//GEN-LAST:event_btLogarActionPerformed

    private void exibeEmailInvalido() {
        JOptionPane.showMessageDialog(null, "Digite um email válido, por exemplo: \n"
                + "example@mail.com");
    }

    private void exibeSenhaInvalido() {
        JOptionPane.showMessageDialog(null, "Você não digitou a senha!");
    }

    private void exibeUserInvalido() {
        JOptionPane.showMessageDialog(null, "Email ou senha incorreto!");
    }

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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField textEmail;
    private javax.swing.JPasswordField textPassword;
    // End of variables declaration//GEN-END:variables
}
