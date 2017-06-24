
package utilidades;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 11/01/2015
 */
public class Login {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 11/01/2015
     * @param senhaUsuario Senha cadastrada no banco de dados
     * @param senhaDigitada Senha digitada pelo usuário
     * @return Resultado da validação da senha
     * @throws Exception Falha ao validar senha
     */
    public static boolean validarSenha(String senhaUsuario, String senhaDigitada) throws Exception {

        //Criptografando senha digitada para comparação:
        senhaDigitada = Criptografia.criptografarSenha(senhaDigitada);
        
        //Verificando se as senhas coincidem:
        return senhaUsuario.equals(senhaDigitada);
    }//Fecha método validarSenha.
}//Fecha classe.
