
package conexão;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Cliente;

public class ClienteDAO {

    private final String SQL_INSERE_CLIENTE= "INSERT INTO \"PUBLIC\".\"CLIENTE\"(\"CPF\", \"NOME\", \"QUANTIDADE\", \"NUMERO\") VALUES (?,?,?,?);";
    private final String SQL_ALTERA_CLIENTE= "UPDATE CLIENTE SET NUMERO=? WHERE CPF=?;";
    private final String SQL_EXCLUI_CLIENTE= "DELETE FROM CLIENTE WHERE CPF=?";
    private final String SQL_EXCLUITUDO_CLIENTE= "DELETE FROM CLIENTE";
    private final String SQL_SELECIONA_CLIENTE= "SELECT * FROM CLIENTE";
    private final String SQL_SELECIONAUM_CLIENTE= "SELECT * FROM CLIENTE WHERE NOME=?;";
    private final String SQL_SELECIONAUMCPF_CLIENTE= "SELECT * FROM CLIENTE WHERE CPF=?;";
    private final String SQL_QTD_CLIENTE= "UPDATE CLIENTE SET QUANTIDADE=?  WHERE NOME=?;";

    private PreparedStatement pst = null;
    public ResultSet rs;
    Conexao conex = new Conexao();
    
    public boolean inserirCliente(Cliente p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_INSERE_CLIENTE);
            pst.setString(1, p.getCpf());
            pst.setString(2, p.getNome());
            pst.setInt(3, p.getQuantidade()); 
            pst.setString(4, p.getNumero());           
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment " + e.toString());
        }
        return ret;
    }
    public ArrayList<Cliente> listar(){
        ArrayList<Cliente> listadeCliente = new ArrayList<Cliente>();
        Connection con = Conexao.conectar();
        
        try {
            pst = con.prepareStatement(SQL_SELECIONA_CLIENTE);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cliente p = new Cliente();
                p.setCpf(rs.getString("CPF"));
                p.setNome(rs.getString("NOME"));
                p.setQuantidade(rs.getInt("QUANTIDADE"));
                p.setNumero(rs.getString("NUMERO"));
                listadeCliente.add(p);
            }
            rs.close();
            pst.close();
            Conexao.fecharcon();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao lista Clientes! " + e.toString());
        }
        return listadeCliente;
        }
    public boolean alterarCliente(Cliente p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_ALTERA_CLIENTE);
            pst.setString(1, p.getNumero());
            pst.setString(2, p.getCpf());
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment " + e.toString());
        }
        return ret;
    }
    public boolean excluirCliente( String s){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_EXCLUI_CLIENTE);
            pst.setString(1, s);
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment no momento da exclusão!" + e.toString());
        }
        return ret;
    }
    public boolean excluirTodosCliente(Cliente p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_EXCLUITUDO_CLIENTE);
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment no momento da exclusão!" + e.toString());
        }
        return ret;
    }

    public boolean quantCliente(Cliente p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_QTD_CLIENTE);
            pst.setInt(1, p.getQuantidade());
            pst.setString(2, p.getNome());
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
            JOptionPane.showMessageDialog(null,"Voto computado com sucesso! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment no momento de computar a quantidade!" + e.toString());
        }
        return ret;
    }

    public Cliente buscarClienteNome(Cliente cli){
        conex.conectar();
        conex.execultaSql("SELECT * FROM CLIENTE WHERE NOME LIKE'%"+cli.getPesquisa()+"%'");
        try {
            conex.rs.first();
            cli.setCpf(conex.rs.getString("CPF"));
            cli.setNome(conex.rs.getString("NOME"));
            cli.setNumero(conex.rs.getString("NUMERO"));
            cli.setQuantidade(conex.rs.getInt("QUANTIDADE"));            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar a verificação " + e.toString());            
        }
        conex.fecharcon();
        return cli;
    }
    public Cliente buscarClienteCPF(Cliente cli){
        conex.conectar();
        conex.execultaSql("SELECT * FROM CLIENTE WHERE CPF LIKE'%"+cli.getPesquisa()+"%'");
        try {
            conex.rs.first();
            cli.setCpf(conex.rs.getString("CPF"));
            cli.setNome(conex.rs.getString("NOME"));
            cli.setNumero(conex.rs.getString("NUMERO"));
            cli.setQuantidade(conex.rs.getInt("QUANTIDADE"));            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar a verificação " + e.toString());            
        }
        conex.fecharcon();
        return cli;
    }
    
    public boolean verificarSeJaExisteBD(String s){
        
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_SELECIONAUM_CLIENTE);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
               Conexao.fecharcon();
               return true;
            }            
            pst.close();
            Conexao.fecharcon();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar a verificação da existência!" + e.toString());
        }
        return false;
    }
    public boolean verificarSeJaExisteBDCPF(String s){
        
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_SELECIONAUMCPF_CLIENTE);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
               Conexao.fecharcon();
               return true;
            }            
            pst.close();
            Conexao.fecharcon();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar a verificação da existência!" + e.toString());
        }
        return false;
    }
}
