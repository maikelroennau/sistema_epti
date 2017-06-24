
package DAO;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 06/01/2015
 */
public class DAOFactory {
    
    //Instanciado objeto estático e privado que irá acessar a classe ComputadorDAO:
    private static final ComputadorDAO computadorDAO = new ComputadorDAO();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static ComputadorDAO getComputadorDAO(){
        
        //Retornando objeto:
        return computadorDAO;
    }//Fecha método.
    
    //Instanciado objeto estático e privado que irá acessar a classe HistoricoComputadorDAO:
    private static final HistoricoComputadorDAO historicoComputadorDAO = new HistoricoComputadorDAO();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static HistoricoComputadorDAO getHistoricoComputadorDAO(){
        
        //Retornando objeto:
        return historicoComputadorDAO;
    }//Fecha método.
    
    
    //Instanciado objeto estático e privado que irá acessar a classe SecretariaDAO:
    private static final SecretariaDAO secretariaDAO = new SecretariaDAO();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 06/01/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static SecretariaDAO getSecretariaDAO(){
        
        //Retornando objeto:
        return secretariaDAO;
    }//Fecha método.
    
    //Instanciado objeto estático e privado que irá acessar a classe SetorDAO:
    private static final SetorDAO setorDAO = new SetorDAO();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 06/01/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static SetorDAO getSetroDAO(){
        
        //Retornando objeto:
        return setorDAO;
    }//Fecha método.
    
    //Instanciado objeto estático e privado que irá acessar a classe UsuarioDAO:
    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 10/01/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static UsuarioDAO getUsuarioDAO(){
        
        //Retornando objeto:
        return usuarioDAO;
    }//Fecha método.
    
    //Instanciado objeto estático e privado que irá acessar a classe PermissoesDAO:
    private static final PermissoesDAO permissoesDAO = new PermissoesDAO();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 10/01/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static PermissoesDAO getPermissoesDAO(){
        
        //Retornando objeto:
        return permissoesDAO;
    }//Fecha método.
    
    //Instanciado objeto estático e privado que irá acessar a classe Es
    private static final EstatisticasDAO estatisticasVO = new EstatisticasDAO();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 01/02/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static EstatisticasDAO getEstatisticasVO(){
        
        //Retornando objeto:
        return estatisticasVO;
    }//Fecha método.
}//Fecha classe.
