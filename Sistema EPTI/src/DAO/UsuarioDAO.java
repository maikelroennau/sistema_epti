
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.PermissoesVO;
import modelo.UsuarioVO;
import persistencia.ConexaoBanco;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 
 */
public class UsuarioDAO {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 10/01/2015
     * @param user Objeto com os dados a serem cadastrados
     * @throws SQLException Falha ao cadastrar setor
     */
    public void cadastrarUsuario(UsuarioVO user) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "insert into usuario(idusuario, nomeusuario, loginusuario, senhausuario, "
                + "statususuario, idpermissoes) values(null, ?, ?, ?, ?, ?)";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, user.getNomeUsuario());
            stat.setString(2, user.getLoginUsuario());
            stat.setString(3, user.getSenhaUsuario());
            stat.setByte(4, user.getStatusUsuario());
            stat.setLong(5, user.getPermissoes().getIdPermissoes());
            
            //Executando insersão:
            stat.execute();
            
            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao cadastar usuário!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método cadastrarUsuario.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 11/01/2015
     * @return Objeto com setores cadastrados
     * @throws SQLException Falha ao selecionar setores
     */
    public ArrayList<UsuarioVO> selecionarUsuarios() throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        Statement stat = con.createStatement();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select * from usuario as u inner join permissoes as p "
                + "on u.idpermissoes = p.idpermissoes "
                + "where u.idusuario <> 2 "
                + "order by nomeusuario";
            
            //Executando busca:
            ResultSet rs = stat.executeQuery(sql);
            
            //ArrayList para receber o resultado da query:
            ArrayList<UsuarioVO> usuario = new ArrayList<>();
            
            //Instanciando objeto da classe base:
            UsuarioVO user;
            
            //Instanciando objeto da classe auxiliar:
            PermissoesVO per;
            
            //While para montra os objetos resultantes da busca:
            while(rs.next()){
                
                //Criando novo objeto para receber os dados:
                per = new PermissoesVO();
                
                //Enviando dados da consulta para o objeto:
                per.setIdPermissoes(rs.getLong("idpermissoes"));
                per.setCadastrarComputador(rs.getByte("cadastrarcomputador"));
                per.setConsultarComputador(rs.getByte("consultarcomputador"));
                per.setEditarComputador(rs.getByte("editarcomputador"));
                per.setExcluirComputador(rs.getByte("excluircomputador"));                               
                per.setCadastrarSecretaria(rs.getByte("cadastrarsecretaria"));
                per.setConsultarSecretaria(rs.getByte("consultarsecretaria"));
                per.setEditarSecretaria(rs.getByte("editarsecretaria"));
                per.setExcluirSecretaria(rs.getByte("excluirsecretaria"));
                per.setCadastrarSetor(rs.getByte("cadastrarsetor"));
                per.setConsultarSetor(rs.getByte("consultarsetor"));
                per.setEditarSetor(rs.getByte("editarsetor"));
                per.setExcluirSetor(rs.getByte("excluirsetor"));
                per.setCadastrarUsuario(rs.getByte("cadastrarusuario"));
                per.setConsultarUsuario(rs.getByte("consultarusuario"));
                per.setEditarUsuario(rs.getByte("editarusuario"));
                per.setExcluirUsuario(rs.getByte("excluirusuario"));
                per.setEditarPermissoes(rs.getByte("editarpermissoes"));
                per.setRealizarManutencao(rs.getByte("realizarmanutencao"));
                
                //Criando novo objeto para receber os dados:
                user = new UsuarioVO();
                
                //Enviando dados da consulta para o objeto:
                user.setIdUsuario(rs.getLong("idusuario"));
                user.setNomeUsuario(rs.getString("nomeusuario"));
                user.setLoginUsuario(rs.getString("loginusuario"));
                user.setSenhaUsuario(rs.getString("senhausuario"));
                user.setStatusUsuario(rs.getByte("statususuario"));
                user.setPermissoes(per);
                
                //Adicionando objeto ao ArrayList:
                usuario.add(user);
            }//Fecha while.
            
            //Retornando ArryaList com o resultado da busca:
            return usuario;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao selecionar usuários!");
        } finally {
            
            //Fechando conexões com o banco de dados:
            con.close();
            stat.close();
        }//Fecha finally.
    }//Fecha método selecionarUsuarios.
    
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 11/01/2015
     * @param pesquisa Variável com a pesquisa a ser feita
     * @return Resultado da pesquisa
     * @throws SQLException Falha ao pesquisar
     */
    public ArrayList<UsuarioVO> filtarUsuario(String pesquisa) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        Statement stat = con.createStatement();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select * from usuario inner join permissoes "
                + "on usuario.idpermissoes = permissoes.idpermissoes "
                + "where loginusuario like '%" + pesquisa + "%' "
                + "order by nomeusuario";                    
                    
            //Executando busca:
            ResultSet rs = stat.executeQuery(sql);
            
            //ArrayList para receber o resultado da query:
            ArrayList<UsuarioVO> usuario = new ArrayList<>();
            
            //Instanciando objeto da classe base:
            UsuarioVO user;
            
            //Instanciando objeto da classe auxiliar:
            PermissoesVO per;
            
            //While para montra os objetos resultantes da busca:
            while(rs.next()){
                
                //Criando novo objeto para receber os dados:
                per = new PermissoesVO();
                
                //Enviando dados da consulta para o objeto:
                per.setIdPermissoes(rs.getLong("idpermissoes"));
                per.setCadastrarComputador(rs.getByte("cadastrarcomputador"));
                per.setConsultarComputador(rs.getByte("consultarcomputador"));
                per.setEditarComputador(rs.getByte("editarcomputador"));
                per.setExcluirComputador(rs.getByte("excluircomputador"));                               
                per.setCadastrarSecretaria(rs.getByte("cadastrarsecretaria"));
                per.setConsultarSecretaria(rs.getByte("consultarsecretaria"));
                per.setEditarSecretaria(rs.getByte("editarsecretaria"));
                per.setExcluirSecretaria(rs.getByte("excluirsecretaria"));
                per.setCadastrarSetor(rs.getByte("cadastrarsetor"));
                per.setConsultarSetor(rs.getByte("consultarsetor"));
                per.setEditarSetor(rs.getByte("editarsetor"));
                per.setExcluirSetor(rs.getByte("excluirsetor"));
                per.setCadastrarUsuario(rs.getByte("cadastrarusuario"));
                per.setConsultarUsuario(rs.getByte("consultarusuario"));
                per.setEditarUsuario(rs.getByte("editarusuario"));
                per.setExcluirUsuario(rs.getByte("excluirusuario"));
                per.setEditarPermissoes(rs.getByte("editarpermissoes"));
                per.setRealizarManutencao(rs.getByte("realizarmanutencao"));
                
                //Criando novo objeto para receber os dados:
                user = new UsuarioVO();
                
                //Enviando dados da consulta para o objeto:
                user.setIdUsuario(rs.getLong("idusuario"));
                user.setNomeUsuario(rs.getString("nomeusuario"));
                user.setLoginUsuario(rs.getString("loginusuario"));
                user.setSenhaUsuario(rs.getString("senhausuario"));
                user.setStatusUsuario(rs.getByte("statususuario"));
                user.setPermissoes(per);
                
                //Adicionando objeto ao ArrayList:
                usuario.add(user);
            }//Fecha while.
            
            //Retornando ArryaList com o resultado da busca:
            return usuario;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao filtar usuário!");
        } finally {
            
            //Fechando as conexões com o banco de dados:
            con.close();
            stat.close();
        }//Fecha finally.
    }//Fecha método filtarUsuario.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 11/01/2015
     * @param loginUsuario Variável com a pesquisa a ser feita
     * @return Resultado da pesquisa
     * @throws SQLException Falha ao pesquisar
     */
    public ArrayList<UsuarioVO> buscarUsuarioParaLogin(String loginUsuario) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select * from usuario inner join permissoes "
                + "on usuario.idpermissoes = permissoes.idpermissoes "
                + "where loginusuario = ?";                    
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, loginUsuario);
            
            //Executando busca:
            ResultSet rs = stat.executeQuery();
            
            //ArrayList para receber o resultado da query:
            ArrayList<UsuarioVO> usuario = new ArrayList<>();
            
            //Instanciando objeto da classe base:
            UsuarioVO user;
            
            //Instanciando objeto da classe auxiliar:
            PermissoesVO per;
            
            //While para montra os objetos resultantes da busca:
            while(rs.next()){
                
                //Criando novo objeto para receber os dados:
                per = new PermissoesVO();
                
                //Enviando dados da consulta para o objeto:
                per.setIdPermissoes(rs.getLong("idpermissoes"));
                per.setCadastrarComputador(rs.getByte("cadastrarcomputador"));
                per.setConsultarComputador(rs.getByte("consultarcomputador"));
                per.setEditarComputador(rs.getByte("editarcomputador"));
                per.setExcluirComputador(rs.getByte("excluircomputador"));                               
                per.setCadastrarSecretaria(rs.getByte("cadastrarsecretaria"));
                per.setConsultarSecretaria(rs.getByte("consultarsecretaria"));
                per.setEditarSecretaria(rs.getByte("editarsecretaria"));
                per.setExcluirSecretaria(rs.getByte("excluirsecretaria"));
                per.setCadastrarSetor(rs.getByte("cadastrarsetor"));
                per.setConsultarSetor(rs.getByte("consultarsetor"));
                per.setEditarSetor(rs.getByte("editarsetor"));
                per.setExcluirSetor(rs.getByte("excluirsetor"));
                per.setCadastrarUsuario(rs.getByte("cadastrarusuario"));
                per.setConsultarUsuario(rs.getByte("consultarusuario"));
                per.setEditarUsuario(rs.getByte("editarusuario"));
                per.setExcluirUsuario(rs.getByte("excluirusuario"));
                per.setEditarPermissoes(rs.getByte("editarpermissoes"));
                per.setRealizarManutencao(rs.getByte("realizarmanutencao"));
                
                //Criando novo objeto para receber os dados:
                user = new UsuarioVO();
                
                //Enviando dados da consulta para o objeto:
                user.setIdUsuario(rs.getLong("idusuario"));
                user.setNomeUsuario(rs.getString("nomeusuario"));
                user.setLoginUsuario(rs.getString("loginusuario"));
                user.setSenhaUsuario(rs.getString("senhausuario"));
                user.setStatusUsuario(rs.getByte("statususuario"));
                user.setPermissoes(per);
                
                //Adicionando objeto ao ArrayList:
                usuario.add(user);
            }//Fecha while.
            
            //Retornando ArryaList com o resultado da busca:
            return usuario;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao filtar usuário!");
        } finally {
            
            //Fechando as conexões com o banco de dados:
            con.close();
        }//Fecha finally.        
    }//Fecha método buscarUsuarioParaLogin.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 15/01/2015
     * @return Resultado da pesquisa
     * @throws SQLException Falha ao pesquisar
     */
    public ArrayList<UsuarioVO> buscarTecnicos() throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        Statement stat = con.createStatement();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select * from usuario as u inner join permissoes as p "
                + "on u.idpermissoes = p.idpermissoes "
                + "where u.idusuario <> 2 and p.realizarmanutencao = 1 "
                + "order by nomeusuario";
            
            //Executando busca:
            ResultSet rs = stat.executeQuery(sql);
            
            //ArrayList para receber o resultado da query:
            ArrayList<UsuarioVO> usuario = new ArrayList<>();
            
            //Instanciando objeto da classe base:
            UsuarioVO user;
            
            //While para montra os objetos resultantes da busca:
            while(rs.next()){

                //Criando novo objeto para receber os dados:
                user = new UsuarioVO();
                
                //Enviando dados da consulta para o objeto:
                user.setIdUsuario(rs.getLong("idusuario"));
                user.setNomeUsuario(rs.getString("nomeusuario"));
                user.setLoginUsuario(rs.getString("loginusuario"));
                user.setSenhaUsuario(rs.getString("senhausuario"));
                user.setStatusUsuario(rs.getByte("statususuario"));
                
                //Adicionando objeto ao ArrayList:
                usuario.add(user);
            }//Fecha while.
            
            //Retornando ArryaList com o resultado da busca:
            return usuario;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao selecionar técnicos!");
        } finally {
            
            //Fechando conexões com o banco de dados:
            con.close();
            stat.close();
        }//Fecha finally.
    }//Fecha método buscarTecnicos.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 24/01/2015
     * @param idUsuario ID do usuário a ser discriminado na pesquisa
     * @return Resultado da busca
     * @throws SQLException Falha ao buscar demais usuários
     */
    public ArrayList<UsuarioVO> buscarDemaisTecnicos(long idUsuario) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select * from usuario as u inner join permissoes as p where u.idusuario != ? "
                + "and p.realizarmanutencao = 1 and u.idpermissoes = p.idpermissoes order by u.loginusuario asc";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setLong(1, idUsuario);
            
            //Executando busca:
            ResultSet rs = stat.executeQuery();            
            
            //ArrayList para receber o resultado da query:
            ArrayList<UsuarioVO> usuario = new ArrayList<>();
            
            //Instanciando objeto da classe base:
            UsuarioVO user;
            
            //While para montra os objetos resultantes da busca:
            while(rs.next()){
                
                //Criando novo objeto para receber os dados:
                user = new UsuarioVO();
                
                //Enviando dados da consulta para o objeto:
                user.setIdUsuario(rs.getLong("idusuario"));
                user.setNomeUsuario(rs.getString("nomeusuario"));
                
                //Adicionando objeto ao ArrayList:
                usuario.add(user);
            }//Fecha while.
            
            //Retornando ArryaList com o resultado da busca:
            return usuario;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao atualizar usuário!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método buscarDemaisTecnicos.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 11/01/2015
     * @param user Objeto com os dados a serem atualizados
     * @throws SQLException Falha ao atualizar setor
     */
    public void atualizarUsuario(UsuarioVO user) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "update usuario set nomeusuario = ?, loginusuario = ?, senhausuario = ?, " 
                + "statususuario = ? where idusuario = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, user.getNomeUsuario());
            stat.setString(2, user.getLoginUsuario());
            stat.setString(3, user.getSenhaUsuario());
            stat.setByte(4, user.getStatusUsuario());
            stat.setLong(5, user.getIdUsuario());

            //Executando atualização:
            stat.executeUpdate();
            
            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao atualizar usuário!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método atualizarUsuario.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 11/01/2015
     * @param idPermissao Variável com o ID do usuário a ser excluído
     * @throws SQLException Falha ao excluir setor
     */
    public void excluirUsuario(String idPermissao) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "delete from permissoes where idpermissoes = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, idPermissao);
            
            //Executando exclusão:
            stat.execute();
            
            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao excluir usuário!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método excluirUsuario.
}//Fecha classe.
