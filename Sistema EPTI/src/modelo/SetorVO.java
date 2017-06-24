
package modelo;

/**
 * @author Maikel Maciel Rönnau
 * @since 1.0
 * @version 08/01/2015
 */
public class SetorVO {
    
    //Atributos da classe:
    private long idSetor;
    private String nomeSetor;
    private SecretariaVO secretaria;
    //Fim dos atributos da classe.

    //Método construtor:
    public SetorVO() {
    }//Fecha método construtor.

    /*** Métodos acessores ****************************************************/
    public long getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(long idSetor) {
        this.idSetor = idSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public SecretariaVO getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(SecretariaVO secretaria) {
        this.secretaria = secretaria;
    }
    /*** Métodos acessores ****************************************************/
    
    @Override
    public String toString() {
        return nomeSetor;
    }//Fecha método toString.
}//Fecha classe.
