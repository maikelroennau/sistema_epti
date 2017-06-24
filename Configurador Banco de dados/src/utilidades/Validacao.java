
package utilidades;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 03/02/2015
 */
public class Validacao {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param dados Descrição a ser validada
     * @return Resultado da validação
     * @throws Exception Falha ao validar nome
     */
    public static boolean validarDados(String dados) throws Exception {
        
        //Verificando se a descrição é válida:
        if(dados.matches("^[a-z0-9.]{2,15}$")){
            
            //Retornando resultado positivo:
            return true;
        } else {
            
            //Lançando erro:
            throw new Exception("Existem dados inválidos!");
        }//Fecha else.
    }//Fecha método validarDados.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param dados Descrição a ser validada
     * @return Resultado da validação
     * @throws Exception Falha ao validar nome
     */
    public static boolean validarUsuario(String dados) throws Exception {
        
        //Verificando se a descrição é válida:
        if(dados.matches("^[a-z._]{2,15}$")){
            
            //Retornando resultado positivo:
            return true;
        } else {
            
            //Lançando erro:
            throw new Exception("Usuário inválido!");
        }//Fecha else.
    }//Fecha método validarDados.
}//Fecha classe.
