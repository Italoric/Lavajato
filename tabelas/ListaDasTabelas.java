package tabelas;

import conexão.ClienteDAO;
import conexão.FuncionarioDAO;
import modelos.Cliente;
import modelos.Funcionario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author clemerson.medeiros
 */
public class ListaDasTabelas {

    //Essa classe não é para existir, serve apenas para demostrar a aplicação com dados dos clientes, vendedor e/ou pedido
    //La na construção da consulta, onde trabalho com esta classe, deverá ser substituido pela classe DAO que vc utiliza para pegar dados do banco
    public ListaDasTabelas() {

    }
    
    FuncionarioDAO fdao = new FuncionarioDAO();
    ClienteDAO cdao = new ClienteDAO();

    public ListaDasTabelas(ArrayList<Cliente> listar) {
        
    }
    public void readTable() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setNumRows(0);
        ClienteDAO cdao = new ClienteDAO();

        for (Cliente p : cdao.listar()) {
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getNumero(),
                p.getCpf(),
                p.getQuantidade()
            });
        }
    }


//    public List<Pedido> getListPedido(){
//        List<Pedido> lista = new ArrayList();
//        for (int i = 0; i < 10; i++) {
//            Pedido pedido = new Pedido(); //eu construo um novo Pedido e adiciono os seguintes dados:
//            List<Cliente> listaCliente = getListCliente(); // eu peguei a lista dos clientes para q assim possa instanciar um cliente ao pedido
//            List<Vendedor> listaVendedor = getListVendedor();
//            pedido.setIdPedido(Short.parseShort(String.valueOf(i))); 
//            pedido.setCodCliente(listaCliente.get(i)); 
//            pedido.setCodVendedor(listaVendedor.get(i));
//            pedido.setDataPedido(new Date());
//            pedido.setStatusPedido("Aberto");
//            lista.add(pedido); 
//        }
//        return lista;
//    }
    public void readTableF() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setNumRows(0);

        for (Funcionario p : fdao.listar()) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getCpf(),
                p.getUsuario(),
                p.getTipoUsuario(),
                p.getNumero()
            });
        }
    }
    
 
    
}
