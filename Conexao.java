package conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {
    
    public Statement stm;
    public ResultSet rs;
    private static final String DRIVER_CLASS = "org.hsqldb.jdbcDriver";
    private static Connection con = null;
    private static String PathBase = "jdbc:hsqldb:file:C:\\Users\\Italo\\Documents\\NetBeansProjects\\Lavajato\\util\\lava";
    private static String Usu = "lavadb";
    private static String Senha = "";
    private static final String URL = "jdbc:hsqldb:file:" + PathBase + ";shutdown=true;hsqldb.write_delay=false; ";
    
    public static Connection conectar (){
        if (con == null) {
            try{
            //Caminho do drive
            Class.forName(DRIVER_CLASS);
            //estabelece a conexão caminho/usuario/senha
            con = DriverManager.getConnection(PathBase, Usu, Senha);
            //JOptionPane.showMessageDialog(null, "DB concetado com sucesso!!");
            
            }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null," Error no ClassName " + e);
            
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "DB concetado não com sucesso!!" + ex );

        } 
        }else{
//            JOptionPane.showMessageDialog(null, "Já está em outra conexão!");
        }
        
      return con;  
    }
 
    public void execultaSql (String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao execultar SQL:\n");
        }
    
    }
    
    public static void fecharcon (){
            try {
                    con.close();
                    con = null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado ao fechar a conexão" + e );
        }
    }
    
}
