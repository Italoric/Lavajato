
package conexão;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Agendamento;
import modelos.Cliente;

public class AgendamentoDAO {

    private final String SQL_INSERE_AGENDAMENTO= "INSERT INTO \"PUBLIC\".\"AGENDAMENTO\"(\"ID\", \"CLIENTE\", \"NUMERO\", \"TIPOVEICULO\", \"DATAA\", \"HORA\", \"VALOR\", \"FUNCIONARIO\") VALUES (?,?,?,?,?,?,?,?);";
    private final String SQL_INSERE_ELEITOR= "INSERT INTO \"PUBLIC\".\"ELEITORES\"(\"CRACHA\") VALUES (?);";
    private final String SQL_ALTERA_AGENDAMENTO= "UPDATE AGENDAMENTO SET CLIENTE=?, NUMERO=?, TIPOVEICULO=?, DATAA=?, HORA=?, VALOR=?, FUNCIONARIO=? WHERE ID=?;";
    private final String SQL_EXCLUI_AGENDAMENTO= "DELETE FROM AGENDAMENTO WHERE ID=?";
    private final String SQL_EXCLUITUDO_AGENDAMENTO= "DELETE FROM AGENDAMENTO";
    private final String SQL_SELECIONA_AGENDAMENTO= "SELECT * FROM AGENDAMENTO";
    private final String SQL_SELECIONAUM_AGENDAMENTO= "SELECT * FROM AGENDAMENTO WHERE ID=?;";
    private final String SQL_SELECIONAUM_ELEITOR= "SELECT * FROM ELEITORES WHERE CRACHA=?;";
    private final String SQL_VOTA_AGENDAMENTO= "UPDATE AGENDAMENTO SET VOTO=?  WHERE NUMERO=?;";

    private PreparedStatement pst = null;
    public ResultSet rs;
    Conexao conex = new Conexao();
    
    public boolean inserirAgendamento(Agendamento p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_INSERE_AGENDAMENTO);
            pst.setInt(1, p.getId());
            pst.setString(2, p.getCliente());
            pst.setString(3, p.getNumero());
            pst.setString(4, p.getTipoveiculo());            
            pst.setString(5, p.getData());            
            pst.setString(6, p.getHora());            
            pst.setDouble(7, p.getValor());            
            pst.setString(8, p.getFuncionario());            
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar agendamento! " + e.toString());
        }
        return ret;
    }

    public ArrayList<Agendamento> listar(){
        ArrayList<Agendamento> listadeAgendamento = new ArrayList<Agendamento>();
        Connection con = Conexao.conectar();
        
        try {
            pst = con.prepareStatement(SQL_SELECIONA_AGENDAMENTO);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Agendamento p = new Agendamento();
                p.setId(rs.getInt("ID"));
                p.setCliente(rs.getString("CLIENTE"));
                p.setNumero(rs.getString("NUMERO"));
                p.setTipoveiculo(rs.getString("TIPOVEICULO"));
                p.setData(rs.getString("DATAA"));
                p.setHora(rs.getString("HORA"));
                p.setValor(rs.getDouble("VALOR"));
                p.setFuncionario(rs.getString("FUNCIONARIO"));
                listadeAgendamento.add(p);
            }
            rs.close();
            pst.close();
            Conexao.fecharcon();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao lista os Agendamentos! " + e.toString());
        }
        return listadeAgendamento;
        }

    public boolean alterarAgendamento(Agendamento p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_ALTERA_AGENDAMENTO);
            pst.setString(1, p.getCliente());
            pst.setString(2, p.getNumero());
            pst.setString(3, p.getTipoveiculo());
            pst.setString(4, p.getData());
            pst.setString(5, p.getHora());
            pst.setDouble(6, p.getValor());
            pst.setString(7, p.getFuncionario());
            pst.setInt(8, p.getId());
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao Alterar " + toString());
        }
        return ret;
    }
    public boolean excluirAgendamento(Agendamento p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_EXCLUI_AGENDAMENTO);
            pst.setInt(1, p.getId());
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment " + e.toString());
        }
        return ret;
    }
    public boolean excluirTodosAgendamento(Agendamento p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_EXCLUITUDO_AGENDAMENTO);
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar exclusão! " + e.toString());
        }
        return ret;
    }

    public Agendamento buscarAgendamento(Agendamento a){
        conex.conectar();
        conex.execultaSql("SELECT * FROM AGENDAMENTO WHERE ID="+a.getPesquisa()+";");
        try {
            conex.rs.first();
            a.setCliente(conex.rs.getString("CLIENTE"));
            a.setTipoveiculo(conex.rs.getString("TIPOVEICULO"));
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar Agendamento! ");            
        }
        conex.fecharcon();
        return a;
    }}
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