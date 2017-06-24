
package utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Maikel Maciel Rönnau
 */
public class DataHora {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.1
     * @since 07/05/2014
     * @return Data atual
     */
    public static String capturarData(){
        
        //Instancindo objeto da classe Date:
        Date data = new Date();
        
        //Formatando data:
        SimpleDateFormat formatadadorData = new SimpleDateFormat("dd/MM/yyyy");
        
        //Variável recebendo a data formatada:
        String dataFormatada = formatadadorData.format(data);
        
        //Retornando data formatada:
        return dataFormatada;
    }//Fecha método capturarData.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.1
     * @since 26/01/2015
     * @return Data atual
     */
    public static String capturarDataBancoDeDados(){
        
        //Instancindo objeto da classe Date:
        Date data = new Date();
        
        //Formatando data:
        SimpleDateFormat formatadadorData = new SimpleDateFormat("yyyy-MM-dd");
        
        //Variável recebendo a data formatada:
        String dataFormatada = formatadadorData.format(data);
        
        //Retornando data formatada:
        return dataFormatada;
    }//Fecha método capturarData.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.1
     * @since 07/05/2014
     * @return Hora atual 
     */
    public static String capturarHora(){
        
        //Instancindo objeto da classe Date:
        Date hora = new Date();
        
        //Formatando hora:
        SimpleDateFormat formatadorHora = new SimpleDateFormat("HH:mm:ss");
        
        //Variável recebendo a hora formatada:
        String horaFormatada = formatadorHora.format(hora);
        
        //Retornando hora formatada:
        return horaFormatada;
    }//Fecha método capturarHora.
}//Fecha classe.
