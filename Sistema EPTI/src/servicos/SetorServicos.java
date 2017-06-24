
package servicos;

import DAO.DAOFactory;
import DAO.SetorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.SetorVO;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 08/01/2015
 */
public class SetorServicos {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 08/01/2015
     * @param set Objeto com os dados a serem cadastrados
     * @throws SQLException Falha ao cadastrar setor
     */
    public void cadastrarSetor(SetorVO set) throws SQLException {
        
        //Instanciando objeto da classe SetorDAO:
        SetorDAO sDAO = DAOFactory.getSetroDAO();
        
        //Cadastrando setor:
        sDAO.cadastrarSetor(set);
    }//Fecha método cadastrarSetor.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 08/01/2015
     * @return Objeto com os setores cadastrados
     * @throws SQLException Falha ao selecionar setores
     */
    public ArrayList<SetorVO> selecionarSetores() throws SQLException {
        
        //Instanciando objeto da classe SetorDAO:
        SetorDAO sDAO = DAOFactory.getSetroDAO();
        
        //Selecionar setores cadastrados:
        return sDAO.selecionarSetores();
    }//Fecha método selecionarTodosSetores.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 09/01/2015
     * @param tipoPesquisa Variável com o tipo de pesquisa a ser feita
     * @param pesquisa Variável com a pesquisa a ser feita
     * @return Resultado da pesquisa
     * @throws SQLException Falha ao pesquisar
     */
    public ArrayList<SetorVO> filtrarSetor(String tipoPesquisa, String pesquisa) throws SQLException {
        
        //Instanciando objeto da classe SetorDAO:
        SetorDAO sDAO = DAOFactory.getSetroDAO();
        
        //Filtrando setor:
        return sDAO.filtarSetor(tipoPesquisa, pesquisa);
    }//Fecha método filtrarSetor.
   
   /**
    * @author Maikel Maciel Rönnau
    * @version 1.0
    * @since 09/01/2015
    * @param set Objeto com os dados a serem atualizados
    * @throws SQLException Falha ao atualizar
    */
    public void atualizarSetor(SetorVO set) throws SQLException {
        
        //Instanciando objeto da classe SetorDAO:
        SetorDAO sDAO = DAOFactory.getSetroDAO();
        
        //Atualizando setor:
        sDAO.atualizarSetor(set);
    }//Fecha método atualizarSetor.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 24/01/2015
     * @version 1.0
     * @param idSecretaria ID da secretaria do setor
     * @return Resultado da busca
     * @throws SQLException Falha ao buscar demais setores
     */
    public ArrayList<SetorVO> buscarDemaisSetores(long idSecretaria) throws SQLException {
        
        //Instanciando objeto da classe SetorDAO:
        SetorDAO sDAO = DAOFactory.getSetroDAO();
        
        //Buscando demais setores:
        return sDAO.buscarDemaisSetores(idSecretaria);
    }//Fecha método buscarDemaisSetores.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 09/01/2015
     * @param idSetor Variável com o ID do setor a ser excluído
     * @throws SQLException Falha ao excluir
     */
    public void excluirSetor(String idSetor) throws SQLException {
        
        //Instanciando objeto da classe SetorDAO:
        SetorDAO sDAO = DAOFactory.getSetroDAO();
        
        //Excluindo setor:
        sDAO.excluirSetor(idSetor);
    }//Fecha método excluirSetor.
}//Fecha classe.
