
package servicos;

import DAO.DAOFactory;
import DAO.EstatisticasDAO;
import java.sql.SQLException;
import modelo.EstatisticasVO;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 01/02/2015
 */
public class EstatisticasServicos {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 01/02/2015
     * @return Objeto com o resultado da consulta
     * @throws SQLException Falha ao buscar estatísticas
     */
    public EstatisticasVO buscarEstatisticasGerais() throws SQLException{
        
        //Instanciando objeto da classe EstatisticasDAO:
        EstatisticasDAO eDAO = DAOFactory.getEstatisticasVO();
        
        //Buscando estatísticas gerais:
        return eDAO.buscarEstatisticasGerais();
    }//Fecha método buscarEstatisticasGerais.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 01/02/2015
     * @return Objeto com o resultado da consulta
     * @throws SQLException Falha ao buscar estatísticas
     */
    public EstatisticasVO buscarEstatisticasComputador() throws SQLException {
        
        //Instanciando objeto da classe EstatisticasDAO:
        EstatisticasDAO eDAO = DAOFactory.getEstatisticasVO();
        
        //Buscando estatísticas computador:
        return eDAO.buscarEstatisticasComputador();
    }//Fecha método buscarEstatisticasComputador.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 01/02/2015
     * @param idSecretaria ID da secretaria
     * @param idSetor ID do setor
     * @return Objeto com o resultado da consulta
     * @throws SQLException Falha ao buscar estatísticas
     */
    public EstatisticasVO buscarEstatisticasSecretariaSetor(long idSecretaria, long idSetor) throws SQLException {
        
        //Instanciando objeto da classe EstatisticasDAO:
        EstatisticasDAO eDAO = DAOFactory.getEstatisticasVO();
        
        //Buscando estatísticas secretaria e setor:
        return eDAO.buscarEstatisticasSecretariaSetor(idSecretaria, idSetor);
    }//Fecha método buscarEstatisticasSecretariaSetor.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 01/02/2015
     * @param idTecnico ID do técnico
     * @return Objeto com o resultado da consulta
     * @throws SQLException Falha ao buscar estatísticas
     */
    public EstatisticasVO buscarEstatisticasTecnico(long idTecnico) throws SQLException {
        
        //Instanciando objeto da classe EstatisticasDAO:
        EstatisticasDAO eDAO = DAOFactory.getEstatisticasVO();
        
        //Buscando estatísticas técnico:
        return eDAO.buscarEstatisticasTecnico(idTecnico);
    }//Fecha método buscarEstatisticasTecnico.
}//Fecha classe.
