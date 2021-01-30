package telas;

import conexão.FuncionarioDAO;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import modelos.Funcionario;
import modelos.Sonumero;

public class CadastroFuncionario extends javax.swing.JFrame {

    Funcionario mod = new Funcionario();
    FuncionarioDAO fdao = new FuncionarioDAO();

    public CadastroFuncionario() {
        initComponents();
        formatarCPF();
        formatarNumero();
        txtId.setDocument(new Sonumero());

    }

    public void nomeUsuarioTela(Funcionario pes) {
        mod = fdao.buscarFuncionarioUsuario(pes);

    }

    private void formatarCPF() {
        try {
            MaskFormatter mask = new MaskFormatter("###########");
            mask.install(txtfCPF);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto!", "Error", JOptionPane.ERROR);
        }
    }

    private void formatarNumero() {
        try {
            MaskFormatter mask = new MaskFormatter("(##)#####-####");
            mask.install(txtfNumero);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto!", "Error", JOptionPane.ERROR);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        txtConfSenha = new javax.swing.JPasswordField();
        btCadastrar = new javax.swing.JButton();
        btExluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        txtfCPF = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtfNumero = new javax.swing.JFormattedTextField();
        btLista = new javax.swing.JButton();
        btBuscarFuncionario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Funcionário");

        jLabel1.setText("Nome:");

        jLabel2.setText("Id:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Senha:");

        jLabel5.setText("Confirmar senha:");

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btExluir.setText("Excluir");
        btExluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExluirActionPerformed(evt);
            }
        });

        jLabel6.setText("Usuário:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Funcionário" }));

        jLabel7.setText("Número:");

        btLista.setText(">");
        btLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListaActionPerformed(evt);
            }
        });

        btBuscarFuncionario.setText("Buscar Funcionário pelo Id");
        btBuscarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(105, 105, 105))
                            .addComponent(txtfCPF)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addComponent(jLabel7)
                            .addComponent(txtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btLista)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExluir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btBuscarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btLista)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(4, 4, 4)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExluir)
                    .addComponent(btCadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscarFuncionario)
                .addGap(6, 6, 6))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListaActionPerformed

        TodosFuncionarios fu = new TodosFuncionarios();
        fu.nomeUsuarioTela(mod);
        fu.setVisible(true);
    }//GEN-LAST:event_btListaActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, ("Por favaor preencha o campo Nome!"));
            txtNome.requestFocusInWindow();
        } else {
            if (txtfCPF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, ("Por favaor preencha o campo CPF!"));
                txtfCPF.requestFocusInWindow();
            } else {
                if (txtUsuario.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, ("Por favaor preencha o campo Usuário!"));
                    txtUsuario.requestFocusInWindow();
                } else {
                    if ((txtConfSenha.getText().isEmpty()) || (!txtConfSenha.getText().equals(txtSenha.getText()))) {
                        JOptionPane.showMessageDialog(null, ("Por favaor verifique o campo Confirmar senha!"));
                        txtConfSenha.requestFocusInWindow();
                    } else {
                        if (txtfNumero.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, ("Por favaor preencha o campo Número!"));
                            txtfNumero.requestFocusInWindow();
                        } else {
                            if (fdao.verificarSeJaExisteBD(txtNome.getText())) {
                                JOptionPane.showMessageDialog(null, "Esse Nome já foi resgistrado, por favor digite outro!");
                                txtNome.setText("");
                                txtNome.requestFocusInWindow();
                            } else {

                                if (fdao.verificarSeJaExisteBDCPF(txtfCPF.getText())) {
                                    JOptionPane.showMessageDialog(null, "Esse CPF já foi resgistrado, por favor digite outro!");
                                    txtfCPF.setText("");
                                    txtfCPF.requestFocusInWindow();
                                } else {
                                    if (fdao.verificarSeJaExisteBDId(Integer.parseInt(txtId.getText()))) {
                                        JOptionPane.showMessageDialog(null, "Esse Id já foi resgistrado, por favor digite outro!");
                                        txtId.setText("");
                                        txtId.requestFocusInWindow();
                                    } else {

                                        Funcionario p = new Funcionario();

                                        p.setId(Integer.parseInt(txtId.getText()));
                                        p.setNome(txtNome.getText());
                                        p.setCpf(txtfCPF.getText());
                                        p.setUsuario(txtUsuario.getText());
                                        p.setSenha(txtSenha.getText());
                                        p.setNumero(txtfNumero.getText());
                                        p.setTipoUsuario((String) jComboBox1.getSelectedItem());

                                        fdao.inserirFuncionario(p);

                                        txtNome.setText("");
                                        txtfNumero.setText("");
                                        txtConfSenha.setText("");
                                        txtSenha.setText("");
                                        txtfCPF.setText("");
                                        txtUsuario.setText("");
                                        txtId.setText("");
                                        jComboBox1.setSelectedItem(1);
                                        txtNome.requestFocusInWindow();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btBuscarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarFuncionarioActionPerformed
        Funcionario e = new Funcionario();
        e.setPesquisa((txtId.getText()));
        Funcionario f = fdao.buscarFuncionarioID(e);
        txtNome.setText(f.getNome());
        txtfCPF.setText(f.getCpf());
        txtUsuario.setText(f.getUsuario());
        txtId.setText("" + f.getId());
        txtfNumero.setText(f.getNumero());
        jComboBox1.setSelectedItem(f.getTipoUsuario());

    }//GEN-LAST:event_btBuscarFuncionarioActionPerformed

    private void btExluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExluirActionPerformed
        if (txtfCPF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, ("Por favaor preencha o campo CPF!"));
            txtfCPF.requestFocusInWindow();
        } else {
            FuncionarioDAO cdao = new FuncionarioDAO();
            Funcionario p = new Funcionario();
            cdao.excluirFuncionario(txtfCPF.getText());
            txtNome.setText("");
            txtfNumero.setText("");
            txtConfSenha.setText("");
            txtSenha.setText("");
            txtfCPF.setText("");
            txtUsuario.setText("");
            txtId.setText("");
            jComboBox1.setSelectedItem("Administrador");
            txtNome.requestFocusInWindow();
        }
    }//GEN-LAST:event_btExluirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarFuncionario;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExluir;
    private javax.swing.JButton btLista;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField txtConfSenha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JFormattedTextField txtfCPF;
    private javax.swing.JFormattedTextField txtfNumero;
    // End of variables declaration//GEN-END:variables
}
