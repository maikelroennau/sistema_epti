
package modelo;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 14/01/2015
 */
public class ComputadorVO {
    
    //Atributos da classe:
    private long idComputador;
    private String nomeComputador;
    private String statusComputador;
    private String memorandoComputador;
    private String contato;
    private String telefone;
    private String descricaoComputador;
    private HistoricoComputadorVO historicoComputador;
    private UsuarioVO tecnico;
    private SecretariaVO secretaria;
    private SetorVO setor;
    //Fim dos atributos da classe.

    //Método construtor:
    public ComputadorVO() {
    }//Fecha construtor.

    /*** Métodos acessores ****************************************************/
    public long getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(long idComputador) {
        this.idComputador = idComputador;
    }

    public String getNomeComputador() {
        return nomeComputador;
    }

    public void setNomeComputador(String nomeComputador) {
        this.nomeComputador = nomeComputador;
    }

    public String getStatusComputador() {
        return statusComputador;
    }

    public void setStatusComputador(String statusComputador) {
        this.statusComputador = statusComputador;
    }

    public String getMemorandoComputador() {
        return memorandoComputador;
    }

    public void setMemorandoComputador(String memorandoComputador) {
        this.memorandoComputador = memorandoComputador;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricaoComputador() {
        return descricaoComputador;
    }

    public void setDescricaoComputador(String descricaoComputador) {
        this.descricaoComputador = descricaoComputador;
    }

    public HistoricoComputadorVO getHistoricoComputador() {
        return historicoComputador;
    }

    public void setHistoricoComputador(HistoricoComputadorVO historicoComputador) {
        this.historicoComputador = historicoComputador;
    }

    public UsuarioVO getTecnico() {
        return tecnico;
    }

    public void setTecnico(UsuarioVO tecnico) {
        this.tecnico = tecnico;
    }

    public SecretariaVO getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(SecretariaVO secretaria) {
        this.secretaria = secretaria;
    }

    public SetorVO getSetor() {
        return setor;
    }

    public void setSetor(SetorVO setor) {    
        this.setor = setor;
    }
    /*** Fim dos métodos acessores ********************************************/
    
    @Override
    public String toString() {
        return nomeComputador;
    } //Fecha toString.
}//Fecha classe.
