
package servicos;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 03/02/2015
 */
public class ServicosFactory {
    
    //Instanciado objeto estático e privado que irá acessar a classe  PrimeiraUtilizacaoServicos:
    private static final PrimeiraUtilizacaoServicos primeiraUtilizacaoServicos = new PrimeiraUtilizacaoServicos();
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 03/02/2015
     * @return Objeto com o resultado do acesso à classe
     */
    public static PrimeiraUtilizacaoServicos getPrimeiraUtilizacaoServicos(){
        
        //Retornando objeto com o resultado do acesso à classe:
        return primeiraUtilizacaoServicos;
    }//Fecha método.
}//Fecha classe.
