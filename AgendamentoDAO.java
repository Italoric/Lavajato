
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
    private final String SQL_ALTERA_AGENDAMENTO= "UPDATE AGENDAMENTO SET NOME=?, SETOR=?, CAMINHO=?  WHERE NUMERO=?;";
    private final String SQL_EXCLUI_AGENDAMENTO= "DELETE FROM AGENDAMENTO WHERE NUMERO=?";
    private final String SQL_EXCLUITUDO_AGENDAMENTO= "DELETE FROM AGENDAMENTO";
    private final String SQL_SELECIONA_AGENDAMENTO= "SELECT * FROM AGENDAMENTO";
    private final String SQL_SELECIONAUM_AGENDAMENTO= "SELECT * FROM AGENDAMENTO WHERE ID=?;";
    private final String SQL_SELECIONAUM_ELEITOR= "SELECT * FROM ELEITORES WHERE CRACHA=?;";
    private final String SQL_VOTA_AGENDAMENTO= "UPDATE AGENDAMENTO SET VOTO=?  WHERE NUMERO=?;";

    private PreparedStatement pst = null;
    
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
//    public ArrayList<Candidato> listarum(int desc){
//        ArrayList<Candidato> listadoCandidato = new ArrayList<Candidato>();
//        Connection con = conexao.conectar();
//        
//        try {
//            pst = con.prepareStatement(SQL_SELECIONAUM_CANDIDATO);
//            pst.setString(1, desc+"");
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                Candidato p = new Candidato();
//                p.setNumber(rs.getInt("NUMERO"));
//                p.setName(rs.getString("NOME"));
//                p.setSetor(rs.getString("SETOR"));
//                p.setCaminho(rs.getString("CAMINHO"));
//                p.setVoto(rs.getInt("VOTO"));
//                listadoCandidato.add(p);
//            }
//            rs.close();
//            pst.close();
//            conexao.fecharcon();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Erro ao lista candidatos! " + e.toString());
//        }
//        return listadoCandidato;
//        }
//
//}
//}
