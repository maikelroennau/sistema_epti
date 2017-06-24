
package servicos;

import DAO.DAOFactory;
import DAO.PrimeiraUtilizacaoDAO;
import java.sql.SQLException;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 03/02/2015
 */
public class PrimeiraUtilizacaoServicos {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 03/02/2015
     * @throws SQLException Falha ao configurar banco de dados
     */
    public void configurarBancoPrimeiraUtilizacao() throws SQLException {
        
        //Instanciando objeto da classe PrimeiraUtilizacaoDAO:
        PrimeiraUtilizacaoDAO pDAO = DAOFactory.getPrimeiraUtilizacaoDAO();
        
        //Configurando banco de dados:
        pDAO.configurarBancoPrimeiraUtilizacao();
    }//Fecha método configurarBancoPrimeiraUtilizacao().
}//Fecha classe.
