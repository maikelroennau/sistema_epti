
package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 06/01/2015
 */
public class Tratamento {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param textoRecebido Variável com o texto a ser convertido
     * @return Texto convertido com os caracteres em iniciais de cada palavra em maiúsculo
     */
    public static String converterInicialDeCadaPalavraMaiucula(String textoRecebido) {
        
        //Variável para receber as letras separadamente:
        char[] letras = textoRecebido.toCharArray();
        
        //Convertendo inicial de cada palavra para maiúsculo:
        for(int i = 0; i < letras.length; i++){
            
            //Verificando se é uma letra:
            if(i == 0 || !Character.isLetterOrDigit(letras[i-1])){
                
                //Convertendo para maiúsculo:
                letras[i] = Character.toUpperCase(letras[i]);
            }//Fecha if.
        }//Fecha for.
        
        //Retornando texto formatado:
        return new String(letras);
    }//Fecha método converterInicialDeCadaPalavraMaiucula.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.2
     * @since 07/05/2014
     * @param data Recebida do banco de dados
     * @return Data formatada para a interface
     */
    public static String dataParaInterface(String data) {
        
        //Variável para receber o modelo:
        Date date;
        
        //Variável para receber a data formatada:
        String dataFormatada = null;
                
        try {            
            
            //Aplicando modelo:
            date = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            
            //Variável recebendo data formatada:
            dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(date);
        } catch (ParseException ex) {
            
            //Lançando erro:
            Logger.getLogger(Tratamento.class.getName()).log(Level.SEVERE, null, ex);
        }//Fecha catch.
        
        //Retornando data formatada:
        return dataFormatada;
    }//Fecha método invertarDataParaInterface.
}//Fecha classe.
