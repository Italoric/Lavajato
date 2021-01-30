package telas;
import conexão.Conexao;
import conexão.FuncionarioDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.Funcionario;

public class Login extends javax.swing.JFrame {

    Funcionario f = new Funcionario();
    FuncionarioDAO fdao = new FuncionarioDAO();
    Conexao con = new Conexao();
    public Login() {
        initComponents();
        con.conectar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUsuario = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        botaoEntrar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        jbSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelUsuario.setText("Usuário:");
        getContentPane().add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        labelSenha.setForeground(new java.awt.Color(255, 255, 255));
        labelSenha.setText("Senha:");
        getContentPane().add(labelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 40, -1));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 170, -1));

        botaoEntrar.setText("Entrar");
        botaoEntrar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 181, 100, -1));
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 170, -1));

        jbSair.setText("Sair");
        jbSair.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });
        getContentPane().add(jbSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 181, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/csirc400.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed


        try {
            con.execultaSql("select * from FUNCIONARIO where USUARIO='"+txtUsuario.getText()+"';");
            con.rs.first();
            if(con.rs.getString("SENHA").equals(txtSenha.getText())){
            Atendimento at = new Atendimento();
            Funcionario p = new Funcionario();
            p.setPesquisa(txtUsuario.getText());
            f = fdao.buscarFuncionarioUsuario(p);
            at.nomeUsuarioTela(f);
            at.setLocationRelativeTo(null);
            at.setVisible(true);
            this.dispose(); 
            }else {
            JOptionPane.showMessageDialog(rootPane, "Verifique sua senha e preencha novamente!");
            txtSenha.requestFocus();
            txtSenha.setText("");
            }
        
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Verifique se você é cadastrado! ");
            
        }
        
    }//GEN-LAST:event_botaoEntrarActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSairActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbSair;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
