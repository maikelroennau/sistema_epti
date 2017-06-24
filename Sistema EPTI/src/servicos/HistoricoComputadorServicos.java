
package servicos;

import DAO.DAOFactory;
import DAO.HistoricoComputadorDAO;
import java.sql.SQLException;
import modelo.HistoricoComputadorVO;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 14/01/2015
 */
public class HistoricoComputadorServicos {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param his Objeto com os dados a serem cadastrados
     * @return ID do histórico cadastrado
     * @throws SQLException Falha ao cadastrar histórico
     */
    public long cadastrarHistoricoComputador(HistoricoComputadorVO his) throws SQLException {
        
        //Instanciando objeto da classe HistoricoComputadorDAO:
        HistoricoComputadorDAO hDAO = DAOFactory.getHistoricoComputadorDAO();
        
        //Cadastrando histórico:
        return hDAO.cadastrarHistoricoComputador(his);
    }//Fecha método cadastrarHistoricoComputador.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param his Objeto com os dados a serem atualizados
     * @throws SQLException Falha ao atualizar histórico
     */
    public void atualizarHistoricoComputador(HistoricoComputadorVO his) throws SQLException {
        
        //Instanciando objeto da classe HistoricoComputadorDAO:
        HistoricoComputadorDAO hDAO = DAOFactory.getHistoricoComputadorDAO();
        
        //Atualizando histórico:
        hDAO.atualizarHistoricoComputador(his);
    }//Fecha método atualizarHistoricoComputador.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param his Objeto com os dados a serem atualizado
     * @throws SQLException Falha ao atualizar histórico
     */
    public void atualizarHistorico(HistoricoComputadorVO his) throws SQLException {
        
        //Instanciando objeto da classe HistoricoComputadorDAO:
        HistoricoComputadorDAO hDAO = DAOFactory.getHistoricoComputadorDAO();
        
        //Atualizando histórico:
        hDAO.atualizarHistorico(his);
    }//Fecha método atualizarHistorico.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param idHistoricoComputador ID do histórico a ser excluído
     * @throws SQLException Falha ao cadastrar excluír setor
     */
    public void excluirHistoricoComputador(long idHistoricoComputador) throws SQLException {
        
        //Instanciando objeto da classe HistoricoComputadorDAO:
        HistoricoComputadorDAO hDAO = DAOFactory.getHistoricoComputadorDAO();
        
        //Excluíndo histórico:
        hDAO.excluirHistoricoComputador(idHistoricoComputador);
    }//Fecha método excluirHistoricoComputador.
}//Fecha classe.
