
package servicos;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 06/01/2015
 */
public class ServicosFactory {

    //Instanciado objeto estático e privado que irá acessar a classe ComputadorServicos:
    private static final ComputadorServicos computadorServicos = new ComputadorServicos();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static ComputadorServicos getComputadorServicos(){
        
        //Retornando objeto com o resultado do acesso à classe:
        return computadorServicos;
    }//Fecha método.
    
    //Instanciado objeto estático e privado que irá acessar a classe HistoricoComputadorServicos:
    private static final HistoricoComputadorServicos historicoComputadorServicos = new HistoricoComputadorServicos();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static HistoricoComputadorServicos getHistoricoComputadorServicos(){
        
        //Retorado objeto com resultado do acesso à classe:
        return historicoComputadorServicos;
    }//Fecha método.    
    
    //Instanciado objeto estático e privado que irá acessar a classe SecretariaServicos:
    private static final SecretariaServicos secretariaServicos = new SecretariaServicos();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 08/01/2015
     * @return Objeto com o resultado do acess à classe
     */
    public static SecretariaServicos getSecretariaServicos(){
        
        //Retorado objeto com resultado do acesso à classe:
        return secretariaServicos;
    }//Fecha método.    
    
    //Instanciado objeto estático e privado que irá acessar a classe SecretariaServicos:
    private static final SetorServicos setorServicos = new SetorServicos();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 08/01/2015
     * @return Objeto com o resultado do acess à classe
     */
    public static SetorServicos getSetorServicos(){
        
        //Retorado objeto com resultado do acesso à classe:
        return setorServicos;
    }//Fecha método.
    
    //Instanciado objeto estático e privado que irá acessar a classe UsuarioServicos:
    private static final UsuarioServicos usuarioServicos = new UsuarioServicos();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 10/01/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static UsuarioServicos getUsuarioServicos(){
        
        //Retorado objeto com resultado do acesso à classe:
        return usuarioServicos;
    }//Fecha método.
    
    //Instanciado objeto estático e privado que irá acessar a classe PermissoesServicos:
    private static final PermissoesServicos permissoesServicos = new PermissoesServicos();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 10/01/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static PermissoesServicos getPermissoesServicos(){
        
        //Retorado objeto com resultado do acesso à classe:
        return permissoesServicos;
    }//Fecha método.
    
    //Instanciado objeto estático e privado que irá acessar a classe EstatisticasServicos:
    private static final EstatisticasServicos estatisticasServicos = new EstatisticasServicos();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 01/02/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static EstatisticasServicos getEstatisticasServicos(){
        
        //Retornando objeto com o resultado do acesso à classe:
        return estatisticasServicos;
    }//Fecha método.
}//Fecha classe.
