package conexão;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Funcionario;


public class FuncionarioDAO {
    private final String SQL_INSERE_FUNCIONARIO= "INSERT INTO \"PUBLIC\".\"FUNCIONARIO\"(\"ID\", \"NOME\", \"CPF\", \"USUARIO\", \"SENHA\", \"NUMERO\", \"TIPOUSUARIO\") VALUES (?,?,?,?,?,?,?);";
    private final String SQL_ALTERA_NUMERO_FUNCIONARIO= "UPDATE FUNCIONARIO SET NUMERO=?  WHERE CPF=?;";
    private final String SQL_ALTERA_SENHA_FUNCIONARIO= "UPDATE FUNCIONARIO SET SENHA=?  WHERE CPF=?;";
    private final String SQL_EXCLUI_FUNCIONARIO= "DELETE FROM FUNCIONARIO WHERE CPF=?";
    private final String SQL_EXCLUITUDO_FUNCIONARIO= "DELETE FROM FUNCIONARIO WHERE ID BETWEEN ? AND ?";
    private final String SQL_SELECIONA_FUNCIONARIO= "SELECT * FROM FUNCIONARIO";
    private final String SQL_SELECIONAUM_FUNCIONARIO= "SELECT * FROM FUNCIONARIO WHERE NOME=?;";
    private final String SQL_SELECIONAUMCPF_FUNCIONARIO= "SELECT * FROM FUNCIONARIO WHERE CPF=?;";
    private final String SQL_SELECIONAUMID_FUNCIONARIO= "SELECT * FROM FUNCIONARIO WHERE ID=?;";
    private final String SQL_QTD_FUNCIONARIO= "UPDATE FUNCIONARIO SET QUANTIDADE=?  WHERE NOME=?;";

    private PreparedStatement pst = null;
    public ResultSet rs;
    Conexao conex = new Conexao();
    
    public boolean inserirFuncionario(Funcionario p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_INSERE_FUNCIONARIO);
            pst.setInt(1, p.getId());
            pst.setString(2, p.getNome());
            pst.setString(3, p.getCpf()); 
            pst.setString(4, p.getUsuario());           
            pst.setString(5, p.getSenha());           
            pst.setString(6, p.getNumero());           
            pst.setString(7, p.getTipoUsuario());           
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar ao adicionar funcionario! " + e.toString());
        }
        return ret;
    }
    public ArrayList<Funcionario> listar(){
        ArrayList<Funcionario> listadeFuncionario = new ArrayList<Funcionario>();
        Connection con = Conexao.conectar();
        
        try {
            pst = con.prepareStatement(SQL_SELECIONA_FUNCIONARIO);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Funcionario p = new Funcionario();
                p.setCpf(rs.getString("CPF"));
                p.setNome(rs.getString("NOME"));
                p.setId(rs.getInt("ID"));
                p.setNumero(rs.getString("NUMERO"));
                p.setUsuario(rs.getString("USUARIO"));
                p.setTipoUsuario(rs.getString("TIPOUSUARIO"));
                listadeFuncionario.add(p);
            }
            rs.close();
            pst.close();
            Conexao.fecharcon();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao lista Clientes! " + e.toString());
        }
        return listadeFuncionario;
        }
    public boolean alterarNumeroFuncionario(Funcionario p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_ALTERA_NUMERO_FUNCIONARIO);
            pst.setString(1, p.getNumero());
            pst.setString(2, p.getCpf());
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
            JOptionPane.showMessageDialog(null,("Número alterado com sucesso! "));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar a alteração do número! " + e.toString());
        }
        return ret;
    }
    public boolean alterarSenha(Funcionario p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_ALTERA_SENHA_FUNCIONARIO);
            pst.setString(1, p.getSenha());
            pst.setString(2, p.getCpf());
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
            JOptionPane.showMessageDialog(null,("Senha alterada com sucesso! "));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar a alteração de senha! " + e.toString());
        }
        return ret;
    }
    public boolean excluirFuncionario( String s){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_EXCLUI_FUNCIONARIO);
            pst.setString(1, s);
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment no momento da exclusão!" + e.toString());
        }
        return ret;
    }
    public boolean excluirFuncionarioEntre( String s, String q){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_EXCLUITUDO_FUNCIONARIO);
            pst.setString(1, s);
            pst.setString(2, q);
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment no momento da exclusão! ");
        }
        return ret;
    }
    public boolean excluirTodosFuncionario(Funcionario p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_EXCLUITUDO_FUNCIONARIO);
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment no momento da exclusão de todos os funcionários! ");
        }
        return ret;
    }
    public Funcionario buscarFuncionarioNome(Funcionario p){
        conex.conectar();
        conex.execultaSql("SELECT * FROM FUNCIONARIO WHERE NOME LIKE'%"+p.getPesquisa()+"%'");
        //Connection con = conexao.conectar();
        try {
            conex.rs.first();
            p.setCpf(conex.rs.getString("CPF"));
            p.setNome(conex.rs.getString("NOME"));
            p.setNumero(conex.rs.getString("NUMERO"));
            p.setId(conex.rs.getInt("ID"));            
            p.setUsuario(conex.rs.getString("USUARIO"));
            p.setTipoUsuario(conex.rs.getString("TIPOUSUARIO"));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar nome! ");            
        }
        conex.fecharcon();
        return p;
    }
    public Funcionario buscarFuncionarioID (Funcionario p){
        conex.conectar();
        
        try {
            conex.execultaSql("SELECT * FROM FUNCIONARIO WHERE ID="+p.getPesquisa()+";");
            conex.rs.first();
            p.setCpf(conex.rs.getString("CPF"));
            p.setNome(conex.rs.getString("NOME"));
            p.setId(conex.rs.getInt("ID"));
            p.setNumero(conex.rs.getString("NUMERO"));
            p.setUsuario(conex.rs.getString("USUARIO"));
            p.setTipoUsuario(conex.rs.getString("TIPOUSUARIO"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar ID!");            
        }
        conex.fecharcon();
        return p;
    }
    public Funcionario buscarFuncionarioUsuario(Funcionario p){
        conex.conectar();
        conex.execultaSql("SELECT * FROM FUNCIONARIO WHERE USUARIO LIKE'%"+p.getPesquisa()+"%'");
        try {
            conex.rs.first();
            p.setCpf(conex.rs.getString("CPF"));
            p.setNome(conex.rs.getString("NOME"));
            p.setId(conex.rs.getInt("ID"));
            p.setNumero(conex.rs.getString("NUMERO"));
            p.setUsuario(conex.rs.getString("USUARIO"));
            p.setTipoUsuario(conex.rs.getString("TIPOUSUARIO"));            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar usuário! ");            
        }
        conex.fecharcon();
        return p;
    }
    public boolean verificarSeJaExisteBD(String s){
        
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_SELECIONAUM_FUNCIONARIO);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
               Conexao.fecharcon();
               return true;
            }            
            pst.close();
            Conexao.fecharcon();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar a verificação de existência! ");
        }
        return false;
    }
    public boolean verificarSeJaExisteBDCPF(String s){
        
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_SELECIONAUMCPF_FUNCIONARIO);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
               Conexao.fecharcon();
               return true;
            }            
            pst.close();
            Conexao.fecharcon();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar a verificação de existência do CPF! ");
        }
        return false;
    }
    public boolean verificarSeJaExisteBDId(int s){
        
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_SELECIONAUMID_FUNCIONARIO);
            pst.setInt(1, s);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
               Conexao.fecharcon();
               return true;
            }            
            pst.close();
            Conexao.fecharcon();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar a verificação de existência do ID! ");
        }
        return false;
    }
}