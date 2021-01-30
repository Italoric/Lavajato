package telas;

import conexão.AgendamentoDAO;
import conexão.ClienteDAO;
import javax.swing.JOptionPane;
import modelos.Sonumero;
import conexão.FuncionarioDAO;
import conexão.LavagemDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelos.Agendamento;
import modelos.Cliente;
import modelos.Funcionario;
import modelos.Lavagem;

public class Atendimento extends javax.swing.JFrame {

    Cliente mod = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Funcionario f = new Funcionario();
    FuncionarioDAO fdao = new FuncionarioDAO();
    AgendamentoDAO agd = new AgendamentoDAO();
    Agendamento a = new Agendamento();
    Lavagem lv = new Lavagem();
    LavagemDAO lvdao = new LavagemDAO();

    public Atendimento() {
        initComponents();
        txtValor.setDocument(new Sonumero());
        btLavar.setEnabled(false);
        btMenuFun.setEnabled(false);
    }

    public void nomeUsuarioTela(Funcionario pes) {
        f = fdao.buscarFuncionarioUsuario(pes);
        jlUsuario.setText(f.getUsuario());
        if ((f.getTipoUsuario().equals("Administrador")) || (f.getTipoUsuario().equals("Super"))) {
            menu2.setEnabled(true);
            btMenuFun.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        cbVeiculo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbPagamento = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btLavar = new javax.swing.JButton();
        cbLavador = new javax.swing.JComboBox();
        txtImagem = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtfPlaca = new javax.swing.JFormattedTextField();
        txtNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPertence = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextPane();
        txtId = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        btMenuFun = new javax.swing.JMenuItem();
        btMenuCli = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        btAlteraSenha = new javax.swing.JMenuItem();
        menu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menu3 = new javax.swing.JMenu();
        btAgendar = new javax.swing.JMenuItem();
        btAtenderAgen = new javax.swing.JMenuItem();
        btSair = new javax.swing.JMenu();
        btSair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Lavagens");
        setPreferredSize(new java.awt.Dimension(870, 500));

        jLabel1.setText("Cliente:");

        jLabel2.setText("Veículo:");

        jLabel3.setText("Pertence:");

        jLabel4.setText("Descrição:");

        txtCliente.setEnabled(false);
        txtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtClienteMouseClicked(evt);
            }
        });

        cbVeiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar", "Carro", "Moto" }));

        jLabel5.setText("Lavador:");

        jLabel6.setText("Pagamento:");

        cbPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar", "Débito", "Crédito", "Dinheiro", "Transferência" }));
        cbPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPagamentoActionPerformed(evt);
            }
        });

        jLabel7.setText("Valor à pagar:");

        btLavar.setText("Lavar");
        btLavar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btLavar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLavarActionPerformed(evt);
            }
        });

        cbLavador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar", "Paulo", "Ítalo" }));

        txtImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/LavajatoR.jpg"))); // NOI18N
        txtImagem.setPreferredSize(new java.awt.Dimension(400, 300));

        jLabel9.setText("Usuário:");

        jLabel8.setText("Placa:");

        txtNumero.setEnabled(false);

        jLabel10.setText("Número:");

        jLabel11.setText("Quantidade:");

        txtQtd.setEnabled(false);

        jScrollPane1.setViewportView(txtPertence);

        jScrollPane2.setViewportView(txtDescricao);

        menu.setText("Cadastros");

        btMenuFun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        btMenuFun.setText("Cadastrar Funcionário");
        btMenuFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuFunActionPerformed(evt);
            }
        });
        menu.add(btMenuFun);

        btMenuCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        btMenuCli.setText("Cadastrar Cliente");
        btMenuCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuCliActionPerformed(evt);
            }
        });
        menu.add(btMenuCli);
        menu.add(jSeparator1);

        btAlteraSenha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        btAlteraSenha.setText("Alterar Senha");
        btAlteraSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlteraSenhaActionPerformed(evt);
            }
        });
        menu.add(btAlteraSenha);

        jMenuBar1.add(menu);

        menu2.setText("Relatórios");
        menu2.setEnabled(false);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Lavagens");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu2.add(jMenuItem1);

        jMenuBar1.add(menu2);

        menu3.setText("Agendar");

        btAgendar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        btAgendar.setText("Agendar");
        btAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgendarActionPerformed(evt);
            }
        });
        menu3.add(btAgendar);

        btAtenderAgen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        btAtenderAgen.setText("Atender Agendamento");
        btAtenderAgen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtenderAgenActionPerformed(evt);
            }
        });
        menu3.add(btAtenderAgen);

        jMenuBar1.add(menu3);

        btSair.setText("Sair");

        btSair1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        btSair1.setText("Sair");
        btSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSair1ActionPerformed(evt);
            }
        });
        btSair.add(btSair1);

        jMenuBar1.add(btSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(628, 628, 628)
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btLavar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbLavador, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(txtImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel11)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel8)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel5)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txtfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(cbLavador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btLavar)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPagamentoActionPerformed

        if ((cbVeiculo.getSelectedItem().equals("Selecionar")) || (cbLavador.getSelectedItem().equals("Selecionar")) || (txtPertence.getText().isEmpty()) || (cbPagamento.getSelectedItem().equals("Selecionar"))) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha os dados corretamente!");
            btLavar.setEnabled(false);
        } else {

            if ((cbPagamento.getSelectedItem().equals("Transferência")) || (cbPagamento.getSelectedItem().equals("Dinheiro")) || (cbPagamento.getSelectedItem().equals("Débito"))||(cbPagamento.getSelectedItem().equals("Crédito"))) {

                btLavar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_cbPagamentoActionPerformed

    private void btLavarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLavarActionPerformed
        if ((cbVeiculo.getSelectedItem().equals("Selecionar")) || (cbLavador.getSelectedItem().equals("Selecionar")) || (txtCliente.getText().isEmpty()) || (cbPagamento.getSelectedItem().equals("Selecionar"))||(txtDescricao.getText().isEmpty())||txtfPlaca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha os dados corretamente!");
            btLavar.setEnabled(false);
        } else {
            SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date dt = new Date();
            lv.setId(Integer.parseInt(txtId.getText()));
            lv.setCliente(txtCliente.getText());
            lv.setPlaca(txtfPlaca.getText());
            lv.setTipoveiculo(cbVeiculo.getSelectedItem().toString());
            lv.setPertence(txtPertence.getText());
            lv.setDescricao(txtDescricao.getText());
            lv.setFuncionario(cbLavador.getSelectedItem().toString());
            lv.setTipoPagamento(cbPagamento.getSelectedItem().toString());
            lv.setValor(Double.parseDouble(txtValor.getText()));
            lv.setData(sp.format(dt));
            lv.setUsuario(jlUsuario.getText());
            
            lvdao.inserirLavagem(lv);
            
            mod.setPesquisa(txtCliente.getText());
            Cliente cli = cdao.buscarClienteNome(mod);
            int b = 1 + cli.getQuantidade();
            cli.setQuantidade(b);
            cdao.quantCliente(cli);
            f.setPesquisa(jlUsuario.getText());
            f = fdao.buscarFuncionarioUsuario(f);
            Atendimento a1 = new Atendimento();
            a1.nomeUsuarioTela(f);
            a1.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btLavarActionPerformed

    private void btAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgendarActionPerformed
        f.setUsuario(jlUsuario.getText());
        Agendamentos age = new Agendamentos();
        age.nomeUsuarioTela(f);
        age.setVisible(true);
    }//GEN-LAST:event_btAgendarActionPerformed

    private void btMenuCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuCliActionPerformed
        CadastroCliente cad = new CadastroCliente();
        f.setUsuario(jlUsuario.getText());
        cad.nomeUsuarioTela(f);
        cad.setVisible(true);
    }//GEN-LAST:event_btMenuCliActionPerformed

    private void btMenuFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuFunActionPerformed
        CadastroFuncionario fun = new CadastroFuncionario();
        fun.setVisible(true);
        f.setUsuario(jlUsuario.getText());
        fun.nomeUsuarioTela(f);
    }//GEN-LAST:event_btMenuFunActionPerformed

    private void btAlteraSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlteraSenhaActionPerformed
        AlterarSenha fun = new AlterarSenha();
        Funcionario usu2 = new Funcionario();
        fun.setVisible(true);
        usu2.setUsuario(jlUsuario.getText());
        fun.nomeUsuarioTela(usu2);
    }//GEN-LAST:event_btAlteraSenhaActionPerformed

    private void btSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSair1ActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btSair1ActionPerformed

    private void btAtenderAgenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtenderAgenActionPerformed
        Consulta consulta = new Consulta(null, true, 1); // o 1(um) refere-se ao tipo de dados que quero que me informe, sera trabalhado nele na janela consulta
        consulta.setVisible(true);
        if (consulta.getSelecao() instanceof Agendamento) {
            Agendamento agendamento = (Agendamento)consulta.getSelecao();
            a.setPesquisa((agendamento != null)? "" + agendamento.getId(): null); // coloque o nome do cliente no jTextField
            Agendamento b = agd.buscarAgendamento(a);
            mod.setPesquisa(b.getCliente());
            mod = cdao.buscarClienteNome(mod);
            txtCliente.setText(mod.getNome());
            txtNumero.setText(mod.getNumero());
            txtQtd.setText("" + mod.getQuantidade());
            cbVeiculo.setSelectedItem(b.getTipoveiculo());
            agd.excluirAgendamento(b);
        }
    }//GEN-LAST:event_btAtenderAgenActionPerformed

    private void txtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClienteMouseClicked
        if (evt.getClickCount() >= 2) {
            Consulta consulta = new Consulta(null, true, 2); // o 2 refere-se ao tipo de dados que quero que me informe, sera trabalhado nele na janela consulta
            consulta.setVisible(true);
            if (consulta.getSelecao() instanceof Cliente) {
                Cliente cliente = (Cliente) consulta.getSelecao();
                mod.setPesquisa((cliente != null) ? "" + cliente.getCpf(): null); // coloque o nome do cliente no jTextField
                Cliente b = cdao.buscarClienteCPF(mod);
                txtCliente.setText(b.getNome());
                txtNumero.setText(b.getNumero());
                txtQtd.setText(""+b.getQuantidade());
            }
        }
    }//GEN-LAST:event_txtClienteMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Relatorio rl = new Relatorio();
        rl.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Atendimento a1 = new Atendimento();
                a1.setLocationRelativeTo(null);
                a1.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btAgendar;
    private javax.swing.JMenuItem btAlteraSenha;
    private javax.swing.JMenuItem btAtenderAgen;
    private javax.swing.JButton btLavar;
    private javax.swing.JMenuItem btMenuCli;
    private javax.swing.JMenuItem btMenuFun;
    private javax.swing.JMenu btSair;
    private javax.swing.JMenuItem btSair1;
    private javax.swing.JComboBox cbLavador;
    private javax.swing.JComboBox cbPagamento;
    private javax.swing.JComboBox cbVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JMenu menu;
    private javax.swing.JMenu menu2;
    private javax.swing.JMenu menu3;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextPane txtDescricao;
    private javax.swing.JTextField txtId;
    private javax.swing.JLabel txtImagem;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextPane txtPertence;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtValor;
    private javax.swing.JFormattedTextField txtfPlaca;
    // End of variables declaration//GEN-END:variables
}
