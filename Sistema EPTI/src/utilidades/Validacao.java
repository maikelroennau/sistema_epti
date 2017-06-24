
package utilidades;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 06/01/2015
 */
public class Validacao {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param nome Nome a ser validado
     * @return Resultado da validação
     * @throws Exception Falha ao validar nome
     */
    public static boolean validarNomeComputador(String nome) throws Exception {
        
        //Verificando se o nome é válido:
        if(nome.matches("^([a-zA-Z]{2,17})([0-9]{3})$")){
            
            //Retornando resultado positivo:
            return true;
        } else {
            
            //Lançando erro:
            throw new Exception("Nome do computador inválido!");
        }//Fecha else.
    }//Fecha método validarNomeComputador.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param descricao Descrição a ser validada
     * @return Resultado da validação
     * @throws Exception Falha ao validar nome
     */
    public static boolean validarDescricaoComputador(String descricao) throws Exception {
        
        //Verificando se a descrição é válida:
        if(descricao.matches("^.{5,65535}$")){
            
            //Retornando resultado positivo:
            return true;
        } else {
            
            //Lançando erro:
            throw new Exception("Descrição inválida!");
        }//Fecha else.
    }//Fecha método validarDescricaoComputador.
    
    /**************************************************************************/
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 06/01/2015
     * @param nomeSigla Sigla a ser validada
     * @return Resultado da validação
     * @throws Exception Falha ao validar sigla
     */
    public static boolean validarNomeSiglaSetor(String nomeSigla) throws Exception {
        
        //Verificando se o nome é válido:
        if(nomeSigla.matches("^[a-zA-ZçÇéúíóáÉÚÍÓÁèùìòàÈÙÌÒÀõãñÕÃÑêûîôâÊÛÎÔÂëÿüïöäËYÜÏÖÄ,.´ -]{2,29}$")){
            
            //Retornando resultado positivo.
            return true;
        } else {
            
            //Lançando erro:
            throw new Exception("Nome/sigla inválido(a)!");
        }//Fecha else.
    }//Fecha método validarSigla.
    
    /**************************************************************************/
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 18/05/2014
     * @param login Recebido da interface
     * @return Resultado da validação do login
     * @throws Exception Falha se o login for inválido
     */
    public static boolean validarLogin(String login) throws Exception {
        
        //Verificando se o login é valido:
        if(login.matches("^[a-zA-Z.]{5,20}$")){
            
            return true;
        } else {
            
            //Lançando erro:
            throw new Exception("Login inválido!");
        }//Fecha else.
    }//Fecha método validarLogin.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 2.0
     * @since 18/05/2014
     * @param senha Recebido da interface
     * @param senhaRepetida Recebido da interface
     * @return Resultado da validação da senha do usuário
     * @throws Exception Falha se a senha for inválida
     */
    public static boolean validarSenha(String senha, String senhaRepetida) throws Exception {
        
        //Verificando se a senha é valida:
        if(senha.matches("^([a-zA-Z0-9çÇéúíóáÉÚÍÓÁèùìòàÈÙÌÒÀõãñÕÃÑêûîôâÊÛÎÔÂëÿüïöäËYÜÏÖÄ!@#$%&*-_.,:?|£¢¬§]){6,20}$")){
            
            //Verificando se as senhas são iguais:
            if(senha.equals(senhaRepetida)){
                
                return true;
            } else {
                
                //Lançando erro:
                throw new Exception("As senhas não coincidem!");
            }//Fecha else.
        } else {
            
            //Lançando erro:
            throw new Exception("Senha inválida! Por favor certifique-se de que"
                              + "\n sua senha atende aos requisitos mínimos:"
                              + "   \n\n- Compimento de 6 caracteres");
        }//Fecha else.
    }//Fecha método validarSenha.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 15/01/2015
     * @param nome Nome a ser validado
     * @return Resultado da validação
     * @throws Exception Falha ao validar nome
     */
    public static boolean validarNomeTecnico(String nome) throws Exception {
        
        //Verificando se o nome é válido:
        if(nome.matches("^[a-zA-ZçÇéúíóáÉÚÍÓÁèùìòàÈÙÌÒÀõãñÕÃÑêûîôâÊÛÎÔÂëÿüïöäËYÜÏÖÄ,.´ ]{5,71}$")){
            
            //Retornando resultado positivo:
            return true;
        } else {
            
            //Lançando erro:
            throw new Exception("Selecione um técnico!");
        }//Fecha else.
    }//Fecah método validarNomeTecnico.
    
    /**************************************************************************/
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 06/01/2015
     * @param nome Nome a ser validado
     * @return Resultado da validação
     * @throws Exception Falha ao validar nome
     */
    public static boolean validarNomeProprio(String nome) throws Exception {
        
        //Verificando se o nome é válido:
        if(nome.matches("^[a-zA-ZçÇéúíóáÉÚÍÓÁèùìòàÈÙÌÒÀõãñÕÃÑêûîôâÊÛÎÔÂëÿüïöäËYÜÏÖÄ,.´ ]{5,71}$")){
            
            //Retornando resultado positivo:
            return true;
        } else {
            
            //Lançando erro:
            throw new Exception("Nome inválido!");
        }//Fecha else.
    }//Fecha método validarNomeProprio.    
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 06/01/2015
     * @param sigla Sigla a ser validada
     * @return Resultado da validação
     * @throws Exception Falha ao validar sigla
     */
    public static boolean validarSigla(String sigla) throws Exception {
        
        //Verificando se o nome é válido:
        if(sigla.matches("^[a-zA-Z ]{2,10}$")){
            
            //Retornando resultado positivo.
            return true;
        } else {
            
            //Lançando erro:
            throw new Exception("Sigla inválida!");
        }//Fecha else.
    }//Fecha método validarSigla.
    
    /**************************************************************************/
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 2.0
     * @since 07/01/2015
     * @param nome Nome a ser validado
     * @return Resultado da validação
     * @throws Exception Falha ao validar nome
     */
    public static boolean validarPesquisaNomeProprio(String nome) throws Exception {
        
        //Verificando se o nome é válido:
        if(nome.matches("^[a-zA-ZçÇéúíóáÉÚÍÓÁèùìòàÈÙÌÒÀõãñÕÃÑêûîôâÊÛÎÔÂëÿüïöäËYÜÏÖÄ,.´ ]{0,71}$")){
            
            //Retornando resultado positivo.
            return true;
        } else {
            
            //Lançando erro:
            throw new Exception("Pesquisa por nome inválida!");
        }//Fecha else.
    }//Fecha método validarPesquisaNomeProprio.    
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 2.0
     * @since 07/01/2015
     * @param sigla Sigla a ser validada
     * @return Resultado da validação
     * @throws Exception Falha ao validar sigla
     */
    public static boolean validarPesquisaSigla(String sigla) throws Exception {
        
        //Verificando se o nome é válido:
        if(sigla.matches("^[a-zA-Z- ]{0,10}$")){
            
            //Retornando resultado positivo.
            return true;
        } else {
            
            //Lançando erro:
            throw new Exception("Pesquisa por sigla inválida!");
        }//Fecha else.
    }//Fecha método validarPesquisaSigla.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param nome Nome a ser validado
     * @return Resultado da validação
     * @throws Exception Falha ao validar nome
     */
    public static boolean validarPesquisaNomeComputador(String nome) throws Exception {
        
        //Verificando se o nome é válido:
        if(nome.matches("^([a-zA-Z]{0,8})([0-9]{0,3})$")){
            
            //Retornando resultado positivo:
            return true;
        } else {
            
            //Lançando erro:
            throw new Exception("Pesquisa por nome do computador inválido!");
        }//Fecha else.
    }//Fecha método validarNomeComputador.
}//Fecha classe.
