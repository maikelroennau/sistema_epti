
package servicos;

import DAO.DAOFactory;
import DAO.SecretariaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.SecretariaVO;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 06/01/2015
 */
public class SecretariaServicos {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 06/01/2015
     * @param sec Objeto com os dados a serem cadastrados
     * @throws SQLException Falha ao cadastrar secretaria
     */
    public void cadastrarSecretaria(SecretariaVO sec) throws SQLException {
        
        //Instanciando objeto da classe SecretariaDAO:
        SecretariaDAO sDAO = DAOFactory.getSecretariaDAO();
        
        //Cadastrando secretaria:
        sDAO.cadastarSecretaria(sec);
    }//Fecha método cadastrarSecretaria.    
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 01/01/2015
     * @version 1.0
     * @return Objeto com as secretarias cadastradas
     * @throws SQLException Falha ao selecionar secretarias
     */
    public ArrayList<SecretariaVO> selecionarSecretarias() throws SQLException {
        
        //Instanciando objeto da classe SecretariaDAO:
        SecretariaDAO sDAO = DAOFactory.getSecretariaDAO();
        
        //Selecionando secretarias:
        return sDAO.selecionarSecretarias();
    }//Fecha método selecionarSecretariasCadastradas.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 07/01/2015
     * @version 1.0
     * @param tipoPesquisa Variável com o tipo de pesquisa a ser feita
     * @param pesquisa Variável com a pesquisa a ser feita
     * @return Resultado da pesquisa
     * @throws SQLException Falha ao pesquisar
     */
    public ArrayList<SecretariaVO> filtrarSecretaria(String tipoPesquisa, String pesquisa) throws SQLException {
        
        //Instanciando objeto da classe SecretariaDAO:
        SecretariaDAO sDAO = DAOFactory.getSecretariaDAO();

        //Filtrando secretaria:
        return sDAO.filtrarSecretaria(tipoPesquisa, pesquisa);
    }//Fecha método filtarSecretaria.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 24/01/2015
     * @version 1.0
     * @param idSecretaria ID da secretaria a ser discriminada na pesquisa
     * @return Resultado da busca
     * @throws SQLException  Falha ao buscar demais secretarias
     */
    public ArrayList<SecretariaVO> buscarDemaisSecretarias(long idSecretaria) throws SQLException {
        
        //Instanciando objeto da classe SecretariaDAO:
        SecretariaDAO sDAO = DAOFactory.getSecretariaDAO();
        
        //Buscando demais secretarias:
        return sDAO.buscarDemaisSecretarias(idSecretaria);
    }//Fecha método buscarDemaisSecretarias.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 07/01/2015
     * @version 1.0
     * @param sec Objeto com os dados a serem atualizados
     * @throws SQLException Falha ao atualizar secretaria
     */
    public void atualizarSecretaria(SecretariaVO sec) throws SQLException {
        
        //Instanciando objeto da classe SecretariaDAO:
        SecretariaDAO sDAO = DAOFactory.getSecretariaDAO();
        
        //Arualizando secretaria:
        sDAO.atualizarSecretaria(sec);
    }//Fecha método atualizarSecretaria.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 01/01/2015
     * @version 1.0
     * @param idSecretaria Variável com o ID da secretaria a ser excluída
     * @throws SQLException Falha ao excluir secretaria
     */
    public void excluirSecretaria(String idSecretaria) throws SQLException {
        
        //Instanciando objeto da classe SecretariaDAO:
        SecretariaDAO sDAO = DAOFactory.getSecretariaDAO();
        
        //Excluindo secretaria:
        sDAO.excluirSecretaria(idSecretaria);
    }//Fecha método excluirSecretaria.
}//Fecha classe.
