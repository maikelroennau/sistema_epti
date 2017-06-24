
package modelo;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 10/01/2015
 */
public class PermissoesVO {

    //Atributos da classe:
    private long idPermissoes;
    
    //Permissões computador:
    private byte cadastrarComputador;
    private byte consultarComputador;
    private byte editarComputador;
    private byte excluirComputador;
    
    //Permissões secretaria:
    private byte cadastrarSecretaria;
    private byte consultarSecretaria;
    private byte editarSecretaria;
    private byte excluirSecretaria;
    
    //Permissões setor:
    private byte cadastrarSetor;
    private byte consultarSetor;
    private byte editarSetor;
    private byte excluirSetor;
    
    //Permissões usuário;
    private byte cadastrarUsuario;
    private byte consultarUsuario;
    private byte editarUsuario;
    private byte excluirUsuario;
    
    //Define se o usuário pode editar as suas permissões ou as de outo usuário:
    private byte editarPermissoes;
    
    //Define se o usuário irá realizar manutenções em computadores:
    private byte realizarManutencao;    
    //Fim dos atributos da classe.

    //Método construtor:
    public PermissoesVO() {
    }//Fecha método construtor.

    /*** Métodos acessores ****************************************************/
    public long getIdPermissoes() {
        return idPermissoes;
    }

    public void setIdPermissoes(long idPermissoes) {
        this.idPermissoes = idPermissoes;
    }

    public byte getCadastrarComputador() {
        return cadastrarComputador;
    }

    public void setCadastrarComputador(byte cadastrarComputador) {
        this.cadastrarComputador = cadastrarComputador;
    }

    public byte getConsultarComputador() {
        return consultarComputador;
    }

    public void setConsultarComputador(byte consultarComputador) {
        this.consultarComputador = consultarComputador;
    }

    public byte getEditarComputador() {
        return editarComputador;
    }

    public void setEditarComputador(byte editarComputador) {
        this.editarComputador = editarComputador;
    }

    public byte getExcluirComputador() {
        return excluirComputador;
    }

    public void setExcluirComputador(byte excluirComputador) {
        this.excluirComputador = excluirComputador;
    }

    public byte getCadastrarSecretaria() {
        return cadastrarSecretaria;
    }

    public void setCadastrarSecretaria(byte cadastrarSecretaria) {
        this.cadastrarSecretaria = cadastrarSecretaria;
    }

    public byte getConsultarSecretaria() {
        return consultarSecretaria;
    }

    public void setConsultarSecretaria(byte consultarSecretaria) {
        this.consultarSecretaria = consultarSecretaria;
    }

    public byte getEditarSecretaria() {
        return editarSecretaria;
    }

    public void setEditarSecretaria(byte editarSecretaria) {
        this.editarSecretaria = editarSecretaria;
    }

    public byte getExcluirSecretaria() {
        return excluirSecretaria;
    }

    public void setExcluirSecretaria(byte excluirSecretaria) {
        this.excluirSecretaria = excluirSecretaria;
    }

    public byte getCadastrarSetor() {
        return cadastrarSetor;
    }

    public void setCadastrarSetor(byte cadastrarSetor) {
        this.cadastrarSetor = cadastrarSetor;
    }

    public byte getConsultarSetor() {
        return consultarSetor;
    }

    public void setConsultarSetor(byte consultarSetor) {
        this.consultarSetor = consultarSetor;
    }

    public byte getEditarSetor() {
        return editarSetor;
    }

    public void setEditarSetor(byte editarSetor) {
        this.editarSetor = editarSetor;
    }

    public byte getExcluirSetor() {
        return excluirSetor;
    }

    public void setExcluirSetor(byte excluirSetor) {
        this.excluirSetor = excluirSetor;
    }

    public byte getCadastrarUsuario() {
        return cadastrarUsuario;
    }

    public void setCadastrarUsuario(byte cadastrarUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
    }

    public byte getConsultarUsuario() {
        return consultarUsuario;
    }

    public void setConsultarUsuario(byte consultarUsuario) {
        this.consultarUsuario = consultarUsuario;
    }

    public byte getEditarUsuario() {
        return editarUsuario;
    }

    public void setEditarUsuario(byte editarUsuario) {
        this.editarUsuario = editarUsuario;
    }

    public byte getExcluirUsuario() {
        return excluirUsuario;
    }

    public void setExcluirUsuario(byte excluirUsuario) {
        this.excluirUsuario = excluirUsuario;
    }

    public byte getEditarPermissoes() {
        return editarPermissoes;
    }

    public void setEditarPermissoes(byte editarPermissoes) {
        this.editarPermissoes = editarPermissoes;
    }

    public byte getRealizarManutencao() {
        return realizarManutencao;
    }

    public void setRealizarManutencao(byte realizarManutencao) {
        this.realizarManutencao = realizarManutencao;
    }
    /*** Fim dos métodos acessores ********************************************/
}//Fecha classe.
