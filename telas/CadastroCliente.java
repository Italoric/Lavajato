package telas;

import conexão.ClienteDAO;
import conexão.FuncionarioDAO;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import modelos.Cliente;
import modelos.Funcionario;

public class CadastroCliente extends javax.swing.JFrame {

    Cliente mod = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Funcionario f = new Funcionario();
    FuncionarioDAO fdao = new FuncionarioDAO();

    public CadastroCliente() {
        initComponents();
        formatarNumero();
        formatarCPF();
    }
    public String D = "";

    public void nomeUsuarioTela(Funcionario pes) {
        f = fdao.buscarFuncionarioUsuario(pes);
        if ((f.getTipoUsuario().equals("Administrador")) || (f.getTipoUsuario().equals("Super"))) {
            btExluir.setEnabled(true);
            btLista.setEnabled(true);
        } else {
        }
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
        txtNome = new javax.swing.JTextField();
        txtfCPF = new javax.swing.JFormattedTextField();
        btCadastrar = new javax.swing.JButton();
        btExluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JTextField();
        btLista = new javax.swing.JButton();
        txtfNumero = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");

        jLabel1.setText("Nome Do Cliente:");

        jLabel2.setText("Telefone Celular:");

        jLabel3.setText("CPF:");

        txtNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNomeMouseClicked(evt);
            }
        });

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btExluir.setText("Excluir");
        btExluir.setEnabled(false);
        btExluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExluirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade:");

        txtQtd.setEnabled(false);

        btLista.setText(">");
        btLista.setEnabled(false);
        btLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(349, Short.MAX_VALUE)
                .addComponent(btLista)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btExluir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btLista)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlterar)
                    .addComponent(btExluir)
                    .addComponent(btCadastrar))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, ("Por favor preencha o campo Nome!"));
            txtNome.requestFocusInWindow();
        } else {
            if (txtfNumero.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, ("Por favor preencha o campo Número!"));
                txtfNumero.requestFocusInWindow();
            } else {
                if (txtfCPF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, ("Por favor preencha o campo CPF!"));
                    txtfCPF.requestFocusInWindow();
                } else {

                    if (cdao.verificarSeJaExisteBD(txtNome.getText())) {
                        JOptionPane.showMessageDialog(null, "Esse Nome já foi resgistrado, por favor digite outro!");
                        txtNome.setText("");
                        txtNome.requestFocusInWindow();
                    } else {

                        if (cdao.verificarSeJaExisteBDCPF(txtfCPF.getText())) {
                            JOptionPane.showMessageDialog(null, "Esse CPF já foi resgistrado, por favor digite outro!");
                            txtfCPF.setText("");
                            txtfCPF.requestFocusInWindow();
                        } else {

                            Cliente p = new Cliente();

                            p.setNome(txtNome.getText());
                            p.setNumero(txtfNumero.getText());
                            p.setCpf(txtfCPF.getText());
                            p.setQuantidade(0);

                            cdao.inserirCliente(p);

                            txtNome.setText("");
                            txtfNumero.setText("");
                            txtfCPF.setText("");
                            txtNome.requestFocusInWindow();
                            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btExluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExluirActionPerformed
        if (txtfCPF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, ("Por favaor preencha o campo CPF!"));
            txtfCPF.requestFocusInWindow();
        } else {

            Cliente p = new Cliente();
            cdao.excluirCliente(txtfCPF.getText());
            txtNome.setText("");
            txtfNumero.setText("");
            txtfCPF.setText("");
            txtQtd.setText("");
            txtNome.requestFocusInWindow();
        }
    }//GEN-LAST:event_btExluirActionPerformed

    private void btListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListaActionPerformed

        TodosClientes cli = new TodosClientes();
        cli.nomeUsuarioTela(f);
        cli.setVisible(true);
    }//GEN-LAST:event_btListaActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, ("Por favaor preencha o campo Nome!"));
            txtNome.requestFocusInWindow();
        } else {
            if (txtfNumero.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, ("Por favaor preencha o campo Número!"));
                txtfNumero.requestFocusInWindow();
            } else {
                if (txtfCPF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, ("Por favaor preencha o campo CPF!"));
                    txtfCPF.requestFocusInWindow();
                } else {

                    Cliente p = new Cliente();

                    p.setNumero(txtfNumero.getText());
                    p.setCpf(txtfCPF.getText());

                    cdao.alterarCliente(p);

                    txtNome.setText("");
                    txtfNumero.setText("");
                    txtfCPF.setText("");
                    txtNome.requestFocusInWindow();
                    JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");

                }
            }
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void txtNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomeMouseClicked
        if (evt.getClickCount() >= 2) {
            Consulta consulta = new Consulta(null, true, 2); // o 2 refere-se ao tipo de dados que quero que me informe, sera trabalhado nele na janela consulta
            consulta.setVisible(true);
            if (consulta.getSelecao() instanceof Cliente) {
                Cliente cliente = (Cliente) consulta.getSelecao();
                mod.setPesquisa((cliente != null) ? "" + cliente.getCpf() : null); // coloque o nome do cliente no jTextField
                Cliente b = cdao.buscarClienteCPF(mod);
                txtNome.setText(b.getNome());
                txtfCPF.setText(b.getCpf());
                txtfNumero.setText(b.getNumero());
                txtQtd.setText("" + b.getQuantidade());
            }
        }
    }//GEN-LAST:event_txtNomeMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExluir;
    private javax.swing.JButton btLista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JFormattedTextField txtfCPF;
    private javax.swing.JFormattedTextField txtfNumero;
    // End of variables declaration//GEN-END:variables
}
