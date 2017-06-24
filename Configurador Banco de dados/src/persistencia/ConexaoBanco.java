
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 06/01/2015
 */
public class ConexaoBanco {
    
    /*** Atributos estáticos com os dados da conexão com o banco de dados *****/
    
    //Endereço do banco de dados:
    private static final String URL = "jdbc:mysql://localhost:3306/epti";
    
    //Usuário para autenticação:
    private static final String USUARIO = "root";
    
    //Senha do usuário para autenticação:
    private static final String SENHA = "root";
    
    /*** Fim dos atributos da conexão com o banco de dados ********************/
    
    public static Connection getConnection() throws SQLException {
        
        //Criando objeto para receber a conexão;
        Connection c;
        
        try {
            
            //Atribuindo conexão ao objeto criado:
            c = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            
            //Lançando erro:
            throw new SQLException("Não foi possível estabelecer conexão com o banco de dados, "
                    + "contate o admistrador para resolver este problema. " + e.getMessage());
        }//Fecha catch.
        
        //Retornando objeto com a conexão:
        return c;
    }//Fecha método getConnection.
}//Fecha classe.
