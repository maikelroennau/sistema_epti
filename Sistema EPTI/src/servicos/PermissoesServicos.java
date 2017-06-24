
package servicos;

import DAO.DAOFactory;
import DAO.PermissoesDAO;
import java.sql.SQLException;
import modelo.PermissoesVO;

/**
* @author Maikel Maciel Rönnau
* @version 1.0
* @since 06/01/2015
 */
public class PermissoesServicos {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 06/01/2015
     * @return ID da permissão cadastrada
     * @param per Objeto com os dados a serem cadastrados
     * @throws SQLException Falha ao cadastrar permissões
     */
    public long cadastrarPermissoes(PermissoesVO per) throws SQLException {
        
        //Instanciando objeto da classe PermissoesDAO:
        PermissoesDAO pDAO = DAOFactory.getPermissoesDAO();
        
        //Cadastrando permissões:
        return pDAO.cadastrarPermissoes(per);
    }//Fecha método cadastrarPermissoes.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 06/01/2015
     * @param per Objeto com os dados a serem cadastrados
     * @throws SQLException Falha ao cadastrar permissões
     */
    public void atualizarPermissoes(PermissoesVO per) throws SQLException {
        
        //Instanciando objeto da classe PermissoesDAO:
        PermissoesDAO pDAO = DAOFactory.getPermissoesDAO();
        
        //Atualizando permissões:
        pDAO.atualizarPermissoes(per);
    }//Fecha método atualizarPermissoes.
}//Fecha classe.
