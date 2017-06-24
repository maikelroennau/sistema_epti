
package utilidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Maikel Maciel Rönnau
 * @since 27/05/2014
 * @version 1.0
 */
public class Criptografia {
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 27/05/2014
     * @version 1.0
     * @param senha Recebido do usuário
     * @return Senha criptografada em MD5
     * @throws Exception Falha ao criptogradar
     */   
    public static String criptografarSenha(String senha) throws Exception {
        
        try {
            
            //Instanciando classe de geração de hashes:
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            
            //Atribuindo bytes da senha recebida a uma variável array:
            byte byteHash[] = digest.digest(senha.getBytes("UTF-8"));
            
            //Criando uma string para receber a senha que será gerada:
            StringBuilder hexHash = new StringBuilder();
            
            //Convertendo senha recebida em um hash:
            for(byte b : byteHash){
                hexHash.append(String.format("%02X", 0xFF & b));
            }//Fecha for.
            
            //Variável recebendo o hash gerado convertido para string:
            String senhaGerada = hexHash.toString();

            //Retornando senha gerada:
            return senhaGerada;
        } catch (NoSuchAlgorithmException e) {
            
            //Lancando erro:
            throw new Exception("Erro ao criptografar senha!");
        }//Fecha catch.        
    }//Fecha método criptografarSenha.
}//Fecha classe.
