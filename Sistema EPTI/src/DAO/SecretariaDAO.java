
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.SecretariaVO;
import persistencia.ConexaoBanco;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 06/01/2015
 */
public class SecretariaDAO {
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 01/01/2015
     * @version 1.0
     * @param sec Objeto com os dados a serem cadastrados
     * @throws SQLException Falha ao cadastrar secretaria
     */
    public void cadastarSecretaria(SecretariaVO sec) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
        
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "insert into secretaria(idsecretaria, nomesecretaria, siglasecretaria) "
                + "values(null, ?, ?)";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, sec.getNomeSecretaria());
            stat.setString(2, sec.getSiglaSecretaria());
            
            //Executando insersão:
            stat.execute();
            
            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao cadastar secretaria!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método cadastrarSecretaria.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 01/01/2015
     * @version 1.0
     * @return Objeto com as secretarias cadastradas
     * @throws SQLException Falha ao selecionar secretarias
     */
    public ArrayList<SecretariaVO> selecionarSecretarias() throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        Statement stat = con.createStatement();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select * from secretaria order by nomesecretaria asc";
            
            //Executando busca:
            ResultSet rs = stat.executeQuery(sql);
            
            //ArrayList para receber o resultado da query:
            ArrayList<SecretariaVO> secretaria = new ArrayList<>();
            
            //Instanciando objeto da classe base:
            SecretariaVO sec;
            
            //While para montra os objetos resultantes da busca:
            while(rs.next()){
                
                //Criando novo objeto para receber os dados:
                sec = new SecretariaVO();
                
                //Enviando dados da consulta para o objeto:
                sec.setIdSecretaria(rs.getLong("idsecretaria"));
                sec.setNomeSecretaria(rs.getString("nomesecretaria"));
                sec.setSiglaSecretaria(rs.getString("siglasecretaria"));
                
                //Adicionando objeto ao ArrayList:
                secretaria.add(sec);
            }//Fecha while.
            
            //Retornando ArryaList com o resultado da busca:
            return secretaria;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao selecionar secretarias cadastradas!");
        } finally {
            
            //Fechando conexões com o banco de dados:
            con.close();
            stat.close();
        }//Fecha finally.
    }//Fecha método selecionarTodasSecretarias.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 07/01/2015
     * @version 1.0
     * @param tipoPesquisa Variável com o tipo de pesquisa a ser feita
     * @param pesquisa Variável com a pesquisa a ser feita
     * @return Resultado da pesquisa
     * @throws SQLException Falha ao pesquisar
     */
    public ArrayList<SecretariaVO> filtrarSecretaria(String tipoPesquisa, String pesquisa) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        Statement stat = con.createStatement();
        //Fim da conexão com o banco de dados.
        
        try {
        
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select * from secretaria where " + tipoPesquisa + " like '%" + pesquisa + "%'";
            
            //Executando busca:
            ResultSet rs = stat.executeQuery(sql);
            
            //ArrayList para receber o resultado da query:
            ArrayList<SecretariaVO> secretaria = new ArrayList<>();
            
            //Instanciando objeto da classe base:
            SecretariaVO sec;
            
            //While para montra os objetos resultantes da busca:
            while(rs.next()){
                
                //Criando novo objeto para receber os dados:
                sec = new SecretariaVO();
                
                //Enviando dados da consulta para o objeto:
                sec.setIdSecretaria(rs.getLong("idsecretaria"));
                sec.setNomeSecretaria(rs.getString("nomesecretaria"));
                sec.setSiglaSecretaria(rs.getString("siglasecretaria"));
                
                //Adicionando objeto ao ArrayList:
                secretaria.add(sec);
            }//Fecha while.
            
            //Retornando ArryaList com o resultado da busca:
            return secretaria;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao filtar secretaria!");
        } finally {
            
            //Fechando conexões com o banco de dados:
            con.close();
            stat.close();
        }//Fecha finally.
    }//Fecha método filtrarSecretaria.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 24/01/2015
     * @version 1.0
     * @param idSecretaria ID da secretaria a ser discriminada na pesquisa
     * @return Resultado da busca
     * @throws SQLException Falha ao buscar demais secretarias
     */
    public ArrayList<SecretariaVO> buscarDemaisSecretarias(long  idSecretaria) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select * from secretaria where idsecretaria != ? order by siglasecretaria asc";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setLong(1, idSecretaria);
            
            //Executando busca:
            ResultSet rs = stat.executeQuery();
            
            //ArrayList para receber o resultado da query:
            ArrayList<SecretariaVO> secretaria = new ArrayList<>();
            
            //Instanciando objeto da classe base:
            SecretariaVO sec;
            
            //While para montra os objetos resultantes da busca:
            while(rs.next()){
                
                //Criando novo objeto para receber os dados:
                sec = new SecretariaVO();
                
                //Enviando dados da consulta para o objeto:
                sec.setIdSecretaria(rs.getLong("idsecretaria"));
                sec.setNomeSecretaria(rs.getString("nomesecretaria"));
                sec.setSiglaSecretaria(rs.getString("siglasecretaria"));
                
                //Adicionando objeto ao ArrayList:
                secretaria.add(sec);
            }//Fecha while.
            
            //Retornando ArryaList com o resultado da busca:
            return secretaria;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao buscar demais secretarias!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método buscarDemaisSecretarias.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 07/01/2015
     * @version 1.0
     * @param sec Objeto com os dados a serem atualizados
     * @throws SQLException Falha ao atualizar secretaria
     */
    public void atualizarSecretaria(SecretariaVO sec) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "update secretaria set nomesecretaria = ?, siglasecretaria = ? where idsecretaria = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, sec.getNomeSecretaria());
            stat.setString(2, sec.getSiglaSecretaria());
            stat.setString(3, String.valueOf(sec.getIdSecretaria()));
            
            //Executando atualização:
            stat.executeUpdate();
            
            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao atualizar secretaria!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método atualizarSecretaria.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 07/01/2015
     * @version 1.0
     * @param idSecretaria Variável com o ID da secretaria a ser excluída
     * @throws SQLException Falha ao excluir secretaria
     */
    public void excluirSecretaria(String idSecretaria) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "delete from secretaria where idsecretaria = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, idSecretaria);
            
            //Executando exclusão:
            stat.execute();
            
            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao excluir secretaria!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método excluirSecretaria.
}//Fecha classe.
