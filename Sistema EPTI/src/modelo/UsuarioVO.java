
package modelo;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 10/01/2015
 */
public class UsuarioVO {
    
    //Atributos da classe:
    private long idUsuario;
    private String nomeUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private byte statusUsuario;
    private PermissoesVO permissoes;
    //Fim dos atributos da classe.
    
    //Método construtor:
    public UsuarioVO() {
    }//Fecha método construtor.

    /*** Métodos acessores ****************************************************/    
    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public byte getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(byte statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public PermissoesVO getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(PermissoesVO permissoes) {
        this.permissoes = permissoes;
    }
    /*** Fim dos métodos acessores ********************************************/
    
    @Override
    public String toString() {
        return nomeUsuario;
    }//Fecha método toString.
}//Fecha classe.
