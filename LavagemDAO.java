
package conexão;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import modelos.Cliente;

public class LavagemDAO {

    private final String SQL_INSERE_CLIENTE= "INSERT INTO \"PUBLIC\".\"CLIENTE\"(\"ID\", \"NOME\", \"NUMERO\", \"QUANTIDADE\") VALUES (?,?,?,?);";
    private final String SQL_INSERE_ELEITOR= "INSERT INTO \"PUBLIC\".\"ELEITORES\"(\"CRACHA\") VALUES (?);";
    private final String SQL_ALTERA_CANDIDATO= "UPDATE CANDIDATOS SET NOME=?, SETOR=?, CAMINHO=?  WHERE NUMERO=?;";
    private final String SQL_EXCLUI_CANDIDATO= "DELETE FROM CANDIDATOS WHERE NUMERO=?";
    private final String SQL_EXCLUITUDO_CANDIDATO= "DELETE FROM CANDIDATOS";
    private final String SQL_EXCLUITUDO_ELEITOR= "DELETE FROM ELEITORES";
    private final String SQL_SELECIONA_CANDIDATO= "SELECT * FROM CANDIDATOS";
    private final String SQL_SELECIONAUM_CANDIDATO= "SELECT * FROM CANDIDATOS WHERE NUMERO=?;";
    private final String SQL_SELECIONAUM_ELEITOR= "SELECT * FROM ELEITORES WHERE CRACHA=?;";
    private final String SQL_VOTA_CANDIDATO= "UPDATE CANDIDATOS SET VOTO=?  WHERE NUMERO=?;";

    private PreparedStatement pst = null;
    
    public boolean inserirCliente(Cliente p){
        boolean ret = false;
        Connection con = Conexao.conectar();
        try {
            pst = con.prepareStatement(SQL_INSERE_CLIENTE);
            pst.setString(1, p.getCpf());
            pst.setString(2, p.getNome());
            pst.setString(3, p.getNumero());
            pst.setInt(4, p.getQuantidade());            
            ret = pst.execute();
            pst.close();
            Conexao.fecharcon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment " + e.toString());
        }
        return ret;
    }}
//    public boolean inserirEleitor(Eleitor p){
//        boolean ret = false;
//        Connection con = conexao.conectar();
//        try {
//            pst = con.prepareStatement(SQL_INSERE_ELEITOR);
//            pst.setInt(1, p.getCracha());            
//            ret = pst.execute();
//            pst.close();
//            conexao.fecharcon();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Erro ao executar o Statment " + e.toString());
//        }
//        return ret;
//    }
//    public ArrayList<Candidato> listar(){
//        ArrayList<Candidato> listadeCandidatos = new ArrayList<Candidato>();
//        Connection con = conexao.conectar();
//        
//        try {
//            pst = con.prepareStatement(SQL_SELECIONA_CANDIDATO);
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                Candidato p = new Candidato();
//                p.setNumber(rs.getInt("NUMERO"));
//                p.setVoto(rs.getInt("VOTO"));
//                p.setName(rs.getString("NOME"));
//                p.setSetor(rs.getString("SETOR"));
//                p.setCaminho(rs.getString("CAMINHO"));
//                listadeCandidatos.add(p);
//            }
//            rs.close();
//            pst.close();
//            conexao.fecharcon();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Erro ao lista candidatos! " + e.toString());
//        }
//        return listadeCandidatos;
//        }
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
