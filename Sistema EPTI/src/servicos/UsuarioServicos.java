
package servicos;

import DAO.DAOFactory;
import DAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.UsuarioVO;

/**
 * @author Maikel Maciel Rönnau 
 * @version 1.0
 * @since 10/01/2015
 */
public class UsuarioServicos {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 10/01/2015
     * @param user Objeto com os dados a serem cadastrados
     * @throws SQLException Falha ao cadastrar setor
     */
    public void cadastrarUsuario(UsuarioVO user) throws SQLException {
        
        //Instanciando objeto da classe UsuarioDAO:
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        
        //Cadastrando usuário:
        uDAO.cadastrarUsuario(user);
    }//Fecha método cadastrarUsuario.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 11/01/2015
     * @return Objeto com usuários cadastrados
     * @throws SQLException Falha ao selecionar setores
     */
    public ArrayList<UsuarioVO> selecionarUsuarios() throws SQLException {
        
        //Instanciando objeto da classe UsuarioDAO:
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        
        //Selecionando usuários cadastrados:
        return uDAO.selecionarUsuarios();
    }//Fecha método selecionarUsuario.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 11/01/2015
     * @param user Objeto com os dados a serem atualizados
     * @throws SQLException Falha ao atualizar
     */
    public void atualizarUsuario(UsuarioVO user) throws SQLException {
        
        //Instanciando objeto da classe UsuarioDAO:
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        
        //Atualizar usuário:
        uDAO.atualizarUsuario(user);
    }//Fecha método atualizarUsuario.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 11/01/2015
     * @param pesquisa Variável com a pesquisa a ser feita
     * @return Resultado da pesquisa
     * @throws SQLException Falha ao pesquisar
     */
    public ArrayList<UsuarioVO> filtrarUsuarios(String pesquisa) throws SQLException {
        
        //Instanciando objeto da classe UsuarioDAO:
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        
        //Selecionando usuários cadastrados:
        return uDAO.filtarUsuario(pesquisa);
    }//Fecha método filtarUsuarios.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 11/01/2015
     * @param loginUsuario Variável com a pesquisa a ser feita
     * @return Resultado da pesquisa
     * @throws SQLException Falha ao pesquisar
     */
    public ArrayList<UsuarioVO> buscarUsuarioParaLogin(String loginUsuario) throws SQLException {
        
        //Instanciando objeto da classe UsuarioDAO:
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        
        //Buscando usuário:
        return uDAO.buscarUsuarioParaLogin(loginUsuario);
    }//Fecha método buscarUsuarioParaLogin.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 15/01/2015
     * @return Resultado da pesquisa
     * @throws SQLException Falha ao pesquisar
     */
    public ArrayList<UsuarioVO> buscarTecnicos() throws SQLException {
        
        //Instanciando objeto da classe UsuarioDAO:
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        
        //Buscando técnicos:
        return uDAO.buscarTecnicos();
    }//Fecha método buscarTecnicos.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 24/01/2015
     * @param idUsuario ID do usuário a ser discriminado na pesquisa
     * @return Resultado da busca
     * @throws SQLException Falha ao buscar demais usuários
     */
    public ArrayList<UsuarioVO> buscarDemaisTecnicos(long idUsuario) throws SQLException {
        
        //Instanciando objeto da classe UsuarioDAO:
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        
        //Buscando demais usuários:
        return uDAO.buscarDemaisTecnicos(idUsuario);
    }//Fecha método buscarDemaisTecnicos.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 11/01/2015
     * @param idPermissao Variável com o ID do setor a ser excluído
     * @throws SQLException Falha ao excluir
     */
    public void excluirUsuario(String idPermissao) throws SQLException {
        
        //Instanciando objeto da classe UsuarioDAO:
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        
        //Selecionando usuários cadastrados:
        uDAO.excluirUsuario(idPermissao);
    }//Fecha método excluirUsuario.
}//Fecha classe.
