
package modelo;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 06/01/2015
 */
public class SecretariaVO {
    
    //Atributos da classe:
    private long idSecretaria;
    private String nomeSecretaria;
    private String siglaSecretaria;
    //Fim dos atributos.

    //Método construtor:
    public SecretariaVO() {
    }//Fecha método construtor.

    /*** Métodos acessores ****************************************************/
    public long getIdSecretaria() {
        return idSecretaria;
    }

    public void setIdSecretaria(long idSecretaria) {
        this.idSecretaria = idSecretaria;
    }

    public String getNomeSecretaria() {
        return nomeSecretaria;
    }

    public void setNomeSecretaria(String nomeSecretaria) {
        this.nomeSecretaria = nomeSecretaria;
    }

    public String getSiglaSecretaria() {
        return siglaSecretaria;
    }

    public void setSiglaSecretaria(String siglaSecretaria) {
        this.siglaSecretaria = siglaSecretaria;
    }
    /*** Fim dos métodos acessores ********************************************/
    
    @Override
    public String toString() {
        return siglaSecretaria;
    }//Fecha método toString.
}//Fecha classe.
