
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.PermissoesVO;
import persistencia.ConexaoBanco;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 10/01/2015
 */
public class PermissoesDAO {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 10/01/2015
     * @param per Objeto com os dados a serem cadastrados
     * @return ID da permissão cadastrada
     * @throws SQLException Falha ao cadastrar permissões
     */
    public long cadastrarPermissoes(PermissoesVO per) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber os comando SLQ:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "insert into permissoes(idpermissoes, cadastrarcomputador, consultarcomputador, "
                + "editarcomputador, excluircomputador, cadastrarsecretaria, consultarsecretaria, "
                + "editarsecretaria, excluirsecretaria, cadastrarsetor, consultarsetor, editarsetor, "
                + "excluirsetor, cadastrarusuario, consultarusuario, editarusuario,  excluirusuario, "
                + "editarpermissoes, realizarmanutencao) values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?)";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //Inserindo dados ao comando:
            stat.setByte(1, per.getCadastrarComputador());
            stat.setByte(2, per.getConsultarComputador());
            stat.setByte(3, per.getEditarComputador());
            stat.setByte(4, per.getExcluirComputador());
            stat.setByte(5, per.getCadastrarSecretaria());
            stat.setByte(6, per.getConsultarSecretaria());
            stat.setByte(7, per.getEditarSecretaria());
            stat.setByte(8, per.getExcluirSecretaria());
            stat.setByte(9, per.getCadastrarSetor());
            stat.setByte(10, per.getConsultarSetor());
            stat.setByte(11, per.getEditarSetor());
            stat.setByte(12, per.getExcluirSetor());
            stat.setByte(13, per.getCadastrarUsuario());
            stat.setByte(14, per.getConsultarUsuario());
            stat.setByte(15, per.getEditarUsuario());
            stat.setByte(16, per.getExcluirUsuario());
            stat.setByte(17, per.getEditarPermissoes());
            stat.setByte(18, per.getRealizarManutencao());
            
            //Executando insersão:
            stat.execute();
            
            //Recebendo ID gerado:
            ResultSet rs = stat.getGeneratedKeys();
            
            //Preparando para receber o ID:
            rs.next();
            
            //Variável para receber o ID gerado:
            long id = rs.getLong(1);
            
            //Fechando conexão com o banco de dados:
            stat.close();
            
            //Retornando ID:
            return id;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao cadastrar permissões!");
        } finally {
            
            //Fechando conexão:
            con.close();
        }//Fecha finally.        
    }//Fecha método cadastrarPermissoes.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 10/01/2015
     * @param per Objeto com os dados a serem atualizados
     * @throws SQLException Falha ao atualizar permissões
     */
    public void atualizarPermissoes(PermissoesVO per) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "update permissoes set cadastrarcomputador = ?, consultarcomputador = ?, "
                + "editarcomputador = ?, excluircomputador = ?, cadastrarsecretaria = ?, "
                + "consultarsecretaria = ?, editarsecretaria = ?, excluirsecretaria = ?, "
                + "cadastrarsetor = ?, consultarsetor = ?, editarsetor = ?, excluirsetor = ?, "
                + "cadastrarusuario = ?, consultarusuario = ?, editarusuario = ?, excluirusuario = ?, "
                + "editarpermissoes = ?, realizarmanutencao = ? where idpermissoes = ?";
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setByte(1, per.getCadastrarComputador());
            stat.setByte(2, per.getConsultarComputador());
            stat.setByte(3, per.getEditarComputador());
            stat.setByte(4, per.getExcluirComputador());
            stat.setByte(5, per.getCadastrarSecretaria());
            stat.setByte(6, per.getConsultarSecretaria());
            stat.setByte(7, per.getEditarSecretaria());
            stat.setByte(8, per.getExcluirSecretaria());
            stat.setByte(9, per.getCadastrarSetor());
            stat.setByte(10, per.getConsultarSetor());
            stat.setByte(11, per.getEditarSetor());
            stat.setByte(12, per.getExcluirSetor());
            stat.setByte(13, per.getCadastrarUsuario());
            stat.setByte(14, per.getConsultarUsuario());
            stat.setByte(15, per.getEditarUsuario());
            stat.setByte(16, per.getExcluirUsuario());
            stat.setByte(17, per.getEditarPermissoes());
            stat.setByte(18, per.getRealizarManutencao());
            stat.setLong(19, per.getIdPermissoes());

            //Executando atualização:
            stat.executeUpdate();
            
            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao atualizar permissões!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método atualizarPermissoes.
}//Fecha classe.
