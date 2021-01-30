
package conexão;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Cliente;
import modelos.Lavagem;

public class LavagemDAO {

    private final String SQL_INSERE_LAVAGEM= "INSERT INTO \"PUBLIC\".\"LAVAGEM\"(\"ID\", \"CLIENTE\", \"PLACA\", \"TIPOVEICULO\", \"PERTECE\", \"DESCRICAO\", \"FUNCIONARIO\", \"TIPOPAGAMENTO\", \"VALOR\", \"DATAA\", \"USUARIO\") VALUES (?,?,?,?,?,?,?,?,?,?,?);";
    private final String SQL_ALTERA_LAVAGEM= "UPDATE CANDIDATOS SET NOME=?, SETOR=?, CAMINHO=?  WHERE NUMERO=?;";
    private final String SQL_EXCLUI_LAVAGEM= "DELETE FROM CANDIDATOS WHERE NUMERO=?";
    private final String SQL_EXCLUITUDO_LAVAGEM= "DELETE FROM CANDIDATOS";
    private final String SQL_SELECIONA_LAVAGEM= "SELECT * FROM LAVAGEM";
    private final String SQL_SELECIONAUM_LAVAGEM= "SELECT * FROM LAVAGEM WHERE DATAA LIKE'%?%'";
    private final String SQL_VOTA_LAVAGEM= "UPDATE CANDIDATOS SET VOTO=?  WHERE NUMERO=?;";

    private PreparedStatement pst = null;
    
    public boolean inserirLavagem(Lavagem p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_INSERE_LAVAGEM);
            pst.setInt(1, p.getId());
            pst.setString(2, p.getCliente());
            pst.setString(3, p.getPlaca());
            pst.setString(4, p.getTipoveiculo());
            pst.setString(5, p.getPertence());
            pst.setString(6, p.getDescricao());
            pst.setString(7, p.getFuncionario());
            pst.setString(8, p.getTipoPagamento());
            pst.setDouble(9, p.getValor());
            pst.setString(10, p.getData());
            pst.setString(11, p.getUsuario());            
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment " + e.toString());
        }
        return ret;
    }

    public ArrayList<Lavagem> listar(){
        ArrayList<Lavagem> listadeLavagem = new ArrayList<Lavagem>();
        Connection con = Conexao.conectar();
        
        try {
            pst = con.prepareStatement(SQL_SELECIONA_LAVAGEM);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Lavagem p = new Lavagem();
                p.setId(rs.getInt("ID"));
                p.setCliente(rs.getString("CLIENTE"));
                p.setPertence(rs.getString("PERTECE"));
                p.setPlaca(rs.getString("PLACA"));
                p.setTipoveiculo(rs.getString("TIPOVEICULO"));
                p.setDescricao(rs.getString("DESCRICAO"));
                p.setFuncionario(rs.getString("FUNCIONARIO"));
                p.setTipoPagamento(rs.getString("TIPOPAGAMENTO"));
                p.setValor(rs.getInt("VALOR"));
                p.setData(rs.getString("DATAA"));
                p.setUsuario(rs.getString("USUARIO"));
                
                listadeLavagem.add(p);
            }
            rs.close();
            pst.close();
            Conexao.fecharcon();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao lista Relatórios! " + e.toString());
        }
        return listadeLavagem;
        }

    public ArrayList<Lavagem> listarPorData(String s){
        ArrayList<Lavagem> listadeLavagem = new ArrayList<Lavagem>();
        Connection con = Conexao.conectar();
        
        try {
            pst = con.prepareStatement("SELECT * FROM LAVAGEM WHERE DATAA LIKE'%"+s+"%'");
//            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Lavagem p = new Lavagem();
                p.setId(rs.getInt("ID"));
                p.setCliente(rs.getString("CLIENTE"));
                p.setPertence(rs.getString("PERTECE"));
                p.setPlaca(rs.getString("PLACA"));
                p.setTipoveiculo(rs.getString("TIPOVEICULO"));
                p.setDescricao(rs.getString("DESCRICAO"));
                p.setFuncionario(rs.getString("FUNCIONARIO"));
                p.setTipoPagamento(rs.getString("TIPOPAGAMENTO"));
                p.setValor(rs.getDouble("VALOR"));
                p.setData(rs.getString("DATAA"));
                p.setUsuario(rs.getString("USUARIO"));
                listadeLavagem.add(p);
            }
            rs.close();
            pst.close();
            Conexao.fecharcon();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao lista Relatórios por data! " + e.toString());
        }
        return listadeLavagem;
        }}
//    public boolean alterarCandidato(Candidato p){
//        boolean ret = false;
//        Connection con = conexao.conectar();
//        try {
//            pst = con.prepareStatement(SQL_ALTERA_CANDIDATO);
//            pst.setString(1, p.getName());
//            pst.setString(2, p.getSetor());
//            pst.setString(3, p.getCaminho());
//            pst.setInt(4, p.getNumber());
//            ret = pst.execute();
//            pst.close();
//            conexao.fecharcon();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment " + e.toString());
//        }
//        return ret;
//    }
//    public boolean excluirCandidato(Candidato p){
//        boolean ret = false;
//        Connection con = conexao.conectar();
//        try {
//            pst = con.prepareStatement(SQL_EXCLUI_CANDIDATO);
//            pst.setInt(1, p.getNumber());
//            ret = pst.execute();
//            pst.close();
//            conexao.fecharcon();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment " + e.toString());
//        }
//        return ret;
//    }
//    public boolean excluirTodosCandidato(Candidato p){
//        boolean ret = false;
//        Connection con = conexao.conectar();
//        try {
//            pst = con.prepareStatement(SQL_EXCLUITUDO_CANDIDATO);
//            ret = pst.execute();
//            pst.close();
//            conexao.fecharcon();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment " + e.toString());
//        }
//        return ret;
//    }
//    public boolean excluirTodosEleitores(Eleitor p){
//        boolean ret = false;
//        Connection con = conexao.conectar();
//        try {
//            pst = con.prepareStatement(SQL_EXCLUITUDO_ELEITOR);
//            ret = pst.execute();
//            pst.close();
//            conexao.fecharcon();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment " + e.toString());
//        }
//        return ret;
//    }
//    public boolean votoCandidato(Candidato p){
//        boolean ret = false;
//        Connection con = conexao.conectar();
//        try {
//            pst = con.prepareStatement(SQL_VOTA_CANDIDATO);
//            pst.setInt(1, p.getVoto());
//            pst.setInt(2, p.getNumber());
//            ret = pst.execute();
//            pst.close();
//            conexao.fecharcon();
//            JOptionPane.showMessageDialog(null,"Voto computado com sucesso! ");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment " + e.toString());
//        }
//        return ret;
//    }
//    public boolean verificarSeJaExisteBD(int s){
//        
//        Connection con = conexao.conectar();
//        try {
//            pst = con.prepareStatement(SQL_SELECIONAUM_ELEITOR);
//            pst.setInt(1, s);
//            ResultSet rs = pst.executeQuery();
//            if(rs.next()) {
//               conexao.fecharcon();
//               return true;
//            }            
//            pst.close();
//            conexao.fecharcon();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Erro ao executar a verificação " + e.toString());
//            
//        }
//        return false;
//    }
//    public boolean verificarSeJaExisteCand(int s){
//        
//        Connection con = conexao.conectar();
//        try {
//            pst = con.prepareStatement(SQL_SELECIONAUM_CANDIDATO);
//            pst.setInt(1, s);
//            ResultSet rs = pst.executeQuery();
//            if(rs.next()) {
//               conexao.fecharcon();
//               return true;
//            }            
//            pst.close();
//            conexao.fecharcon();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Erro ao executar a verificação " + e.toString());
//            
//        }
//        return false;
//    }
//
//    

//
//}
//}
