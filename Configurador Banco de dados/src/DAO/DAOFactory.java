
package DAO;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 03/02/2015
 */
public class DAOFactory {
    
    //Instanciado objeto estático e privado que irá acessar a classe 
    private static final PrimeiraUtilizacaoDAO primeiraUtilizacaoDAO = new PrimeiraUtilizacaoDAO();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 03/02/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static PrimeiraUtilizacaoDAO getPrimeiraUtilizacaoDAO(){
        
        //Retornando objeto:
        return primeiraUtilizacaoDAO;
    }//Fecha método.
}//Fecha classe.
