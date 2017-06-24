
package servicos;

import DAO.ComputadorDAO;
import DAO.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ComputadorVO;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 14/01/2015
 */
public class ComputadorServicos {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param com Objeto com os dados a serem cadastrados
     * @throws SQLException Falha ao cadastrar computador
     */
    public void cadastrarComputador(ComputadorVO com) throws SQLException {
        
        //Instanciando objeto da classe ComputadorDAO:
        ComputadorDAO cDAO = DAOFactory.getComputadorDAO();
        
        //Cadastrando computador:
        cDAO.cadastrarComputador(com);
    }//Fecha método cadastrarComputador.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 15/01/201
     * @return Objeto com os computadores cadastrados
     * @throws SQLException Falha ao selecionar computadores
     */
    public ArrayList<ComputadorVO> selecionarComputadores() throws SQLException {
        
        //Instanciando objeto da classe ComputadorDAO:
        ComputadorDAO cDAO = DAOFactory.getComputadorDAO();
        
        //Selecionando computadores:
        return cDAO.selecionarComputadores();
    }//Fecha método selecionarComputadores.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 15/01/2015
     * @version 1.0
     * @param nomeComputador Mome do computador a ser pesquisado
     * @param idTecnico ID do técnico a ser pesquisado
     * @param idSecretaria ID da secretaria a ser pesquisada
     * @param idSetor ID do setor a ser pesquisado
     * @param statusComputador Status do computador a ser pesquisado
     * @param dataEntrada Data a ser pesquisada
     * @return Resultado da pesquisa
     * @throws SQLException Falha ao pesquisar
     */
    public ArrayList<ComputadorVO> filtrarComputador(String nomeComputador, String idTecnico,
            String idSecretaria, String idSetor, String statusComputador, String dataEntrada) throws SQLException {
        
        //Instanciando objeto da classe ComputadorDAO:
        ComputadorDAO cDAO = DAOFactory.getComputadorDAO();
        
        //Filtrando computador:
        return cDAO.filtrarComputador(nomeComputador, idTecnico, idSecretaria, idSetor, statusComputador, dataEntrada);
    }//Fecha método filtrarComputador.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 23/01/2015
     * @version 1.0
     * @param idComputador ID do computador a ser buscado
     * @return Objeto com o resultado da busca
     * @throws SQLException Falha ao buscar computador
     */
    public ComputadorVO buscarComputadorParaEdicao(long idComputador) throws SQLException {
        
        //Instanciando objeto da classe ComputadorDAO:
        ComputadorDAO cDAO = DAOFactory.getComputadorDAO();
        
        //Buscando computador:
        return cDAO.buscarComputadorParaEdicao(idComputador);
    }//Fecha método buscarComputadorParaEdicao.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 26/01/2015
     * @param com Objeto com os dados a serem atualizados
     * @throws SQLException Falha ao atualizar computador
     */
    public void atualizarComputador(ComputadorVO com) throws SQLException {
        
        //Instanciando objeto da classe ComputadorDAO:
        ComputadorDAO cDAO = DAOFactory.getComputadorDAO();
        
        //Atualizando computador;
        cDAO.atualizarComputador(com);
    }//Fecha método atualizarComputador.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 07/01/2015
     * @version 1.0
     * @param idComputador Variável com o ID do computador a ser excluído
     * @throws SQLException Falha ao excluir computador
     */
    public void excluirComputador(String idComputador) throws SQLException {
        
        //Instanciando objeto da classe ComputadorDAO:
        ComputadorDAO cDAO = DAOFactory.getComputadorDAO();
        
        //Excluíndo computador:
        cDAO.excluirComputador(idComputador);
    }//Fecha método excluirComputador.
}//Fecha classe.
