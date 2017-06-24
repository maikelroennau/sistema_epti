
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.SecretariaVO;
import modelo.SetorVO;
import persistencia.ConexaoBanco;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 08/01/2015
 */
public class SetorDAO {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 08/01/2015
     * @param set Objeto com os dados a serem cadastrados
     * @throws SQLException Falha ao cadastrar setor
     */
    public void cadastrarSetor(SetorVO set) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "insert into setor(idsetor, nomesetor, idsecretaria) "
                + "values(null, ?, ?)";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, set.getNomeSetor());
            stat.setLong(2, set.getSecretaria().getIdSecretaria());
            
            //Executando insersão:
            stat.execute();
            
            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao cadastar setor!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método cadastrarSetor.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 09/01/2015
     * @version 1.0
     * @return Objeto com setores cadastrados
     * @throws SQLException Falha ao selecionar setores
     */
    public ArrayList<SetorVO> selecionarSetores() throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        Statement stat = con.createStatement();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select s.idsetor, s.nomesetor, s.idsecretaria, sec.siglasecretaria "
                + "from setor as s "
                + "inner join secretaria as sec "
                + "on s.idsecretaria = sec.idsecretaria "
                + "order by sec.siglasecretaria";
            
            //Executando busca:
            ResultSet rs = stat.executeQuery(sql);
            
            //ArrayList para receber o resultado da query:
            ArrayList<SetorVO> setor = new ArrayList<>();
            
            //Instanciando objeto da classe base:
            SetorVO set;
            
            //Instanciando objeto da classe pai:
            SecretariaVO sec;
            
            //While para montra os objetos resultantes da busca:
            while(rs.next()){
                
                //Criando novo objeto para receber os dados:
                sec = new SecretariaVO();
                
                //Enviando dados da consulta para o objeto:
                sec.setSiglaSecretaria(rs.getString("siglasecretaria"));
                
                //Criando novo objeto para receber os dados:
                set = new SetorVO();
                
                //Enviando dados da consulta para o objeto:
                set.setIdSetor(rs.getLong("idsetor"));
                set.setNomeSetor(rs.getString("nomesetor"));
                set.setSecretaria(sec);
                
                //Adicionando objeto ao ArrayList:
                setor.add(set);
            }//Fecha while.
            
            //Retornando ArryaList com o resultado da busca:
            return setor;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao selecionar setores!");
        } finally {
            
            //Fechando conexões com o banco de dados:
            con.close();
            stat.close();
        }//Fecha finally.
    }//Fecha método selecionarTodosSetores.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 09/01/2015
     * @version 1.0
     * @param tipoPesquisa Variável com o tipo de pesquisa a ser feita
     * @param pesquisa Variável com a pesquisa a ser feita
     * @return Resultado da pesquisa
     * @throws SQLException Falha ao pesquisar
     */
    public ArrayList<SetorVO> filtarSetor(String tipoPesquisa, String pesquisa) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        Statement stat = con.createStatement();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select s.idsetor, s.nomesetor, s.idsecretaria, sec.siglasecretaria "
                + "from setor as s "
                + "inner join secretaria as sec "
                + "on s.idsecretaria = sec.idsecretaria "
                + "where " + tipoPesquisa + pesquisa
                + " order by s.nomesetor";
            System.out.println(sql);
            //Executando busca:
            ResultSet rs = stat.executeQuery(sql);
            
            //ArrayList para receber o resultado da query:
            ArrayList<SetorVO> setor = new ArrayList<>();
            
            //Instanciando objeto da classe base:
            SetorVO set;
            
            //Instanciando objeto da classe pai:
            SecretariaVO sec;
            
            //While para montra os objetos resultantes da busca:
            while(rs.next()){
                
                //Criando novo objeto para receber os dados:
                sec = new SecretariaVO();
                
                //Enviando dados da consulta para o objeto:
                sec.setSiglaSecretaria(rs.getString("siglasecretaria"));
                
                //Criando novo objeto para receber os dados:
                set = new SetorVO();
                
                //Enviando dados da consulta para o objeto:
                set.setIdSetor(rs.getLong("idsetor"));
                set.setNomeSetor(rs.getString("nomesetor"));
                set.setSecretaria(sec);
                
                //Adicionando objeto ao ArrayList:
                setor.add(set);
            }//Fecha while.
            
            //Retornando ArryaList com o resultado da busca:
            return setor;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao filtar setor!");
        } finally {
            
            //Fechando as conexões com o banco de dados:
            con.close();
            stat.close();
        }//Fecha finally.
    }//Fecha método filtrarSetor.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 24/01/2015
     * @version 1.0
     * @param idSecretaria ID da secretaria do setor
     * @return Resultado da busca
     * @throws SQLException Falha ao buscar demais setores
     */
    public ArrayList<SetorVO> buscarDemaisSetores(long idSecretaria) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select * from setor where idsecretaria = ? order by nomesetor asc";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setLong(1, idSecretaria);
            
            //Executando busca:
            ResultSet rs = stat.executeQuery();
            
            //ArrayList para receber o resultado da query:
            ArrayList<SetorVO> setor = new ArrayList<>();
            
            //Instanciando objeto da classe base:
            SetorVO set;
            
            //Instanciando objeto da classe pai:
            SecretariaVO sec;
            
            //While para montra os objetos resultantes da busca:
            while(rs.next()){
                
                //Criando novo objeto para receber os dados:
                set = new SetorVO();
                
                //Enviando dados da consulta para o objeto:
                set.setIdSetor(rs.getLong("idsetor"));
                set.setNomeSetor(rs.getString("nomesetor"));
                
                //Adicionando objeto ao ArrayList:
                setor.add(set);
            }//Fecha while.
            
            //Fechando as conexão com o banco de dados:
            stat.close();
            
            //Retornando ArryaList com o resultado da busca:
            return setor;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao buscar demais setores!");
        } finally {
            
            //Fechando as conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método buscarDemaisSetores.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 09/01/2015
     * @version 1.0
     * @param set Objeto com os dados a serem atualizados
     * @throws SQLException Falha ao atualizar setor
     */
    public void atualizarSetor(SetorVO set) throws SQLException {
    
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {

            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "update setor set nomesetor = ? where idsetor = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, set.getNomeSetor());
            stat.setLong(2, set.getIdSetor());
            
            //Executando atualização:
            stat.executeUpdate();
            
            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao atualizar setor!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método atualizarSetor.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 09/01/2015
     * @version 1.0
     * @param idSetor Variável com o ID do setor a ser excluído
     * @throws SQLException Falha ao excluir setor
     */
    public void excluirSetor(String idSetor) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "delete from setor where idsetor = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, idSetor);
            
            //Executando exclusão:
            stat.execute();
            
            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao excluir setor!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método excluirSetor.
}//Fecha classe.
