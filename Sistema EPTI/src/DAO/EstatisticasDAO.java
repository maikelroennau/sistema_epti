
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.EstatisticasVO;
import persistencia.ConexaoBanco;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 01/02/2015
 */
public class EstatisticasDAO {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 01/02/2015
     * @return Objeto com o resultado da consulta
     * @throws SQLException Falha ao buscar estatísticas
     */
    public EstatisticasVO buscarEstatisticasGerais() throws SQLException{
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        Statement stat = con.createStatement();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Objeto para receber o resultado da consulta:
            EstatisticasVO est = new EstatisticasVO();
            
            /*** Buscando total de computadores *******************************/
            
            //Atribuindo comando à variável:
            sql = "select count(idcomputador) as totalcomputadores from computador";
            
            //Executando busca:
            ResultSet rs = stat.executeQuery(sql);
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setTotalComputadores(rs.getString("totalcomputadores"));
            
            /*** Buscando total de Secretarias ********************************/
            
            //Atribuindo novo comando à variável:
            sql = "select count(idsecretaria) as totalsecretarias from secretaria";
            
            //Executando busca:
            rs = stat.executeQuery(sql);
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setTotalSecretarias(rs.getString("totalsecretarias"));
            
            /*** Buscando total de Setores ************************************/
            
            //Atribuindo novo comando à variável:
            sql = "select count(idsetor) as totalidsetor from setor";
            
            //Executando busca:
            rs = stat.executeQuery(sql);
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setTotalSetores(rs.getString("totalidsetor"));
            
            /*** Buscando total de Usuários ***********************************/
            
            //Atribuindo novo comando à variável:
            sql = "select count(idusuario) as totalidusuario from usuario";
            
            //Executando busca:
            rs = stat.executeQuery(sql);
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setTotalUsuarios(rs.getString("totalidusuario"));
            
            //Retornando objeto com o resultado da busca:
            return est;
        } catch (Exception e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao buscar estatísticas!");
        } finally {
            
            //Fechando conexões com o banco de dados:
            con.close();
            stat.close();
        }//Fecha finally.
    }//Fehca método buscarEstatisticasGerais.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 01/02/2015
     * @return Objeto com o resultado da consulta
     * @throws SQLException Falha ao buscar estatísticas
     */
    public EstatisticasVO buscarEstatisticasComputador() throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        Statement stat = con.createStatement();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Objeto para receber o resultado da consulta:
            EstatisticasVO est = new EstatisticasVO();
            
            /*** Computadores concluídos **************************************/
            
            //Atribuindo comando à variável:
            sql = "select count(idcomputador) as computadoresconcluidos from computador where statuscomputador = 'Concluído'";
            
            //Executando busca:
            ResultSet rs = stat.executeQuery(sql);
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setComputadoresConcluidos(rs.getString("computadoresconcluidos"));
            
            /*** Computadores descartados *************************************/
            
            //Atribuindo comando à variável:
            sql = "select count(idcomputador) as computadoresdescartados from computador where statuscomputador = 'Descartado'";
            
            //Executando busca:
            rs = stat.executeQuery(sql);
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setComputadoresDescartados(rs.getString("computadoresdescartados"));
            
            /*** Computadores em manutenção ***********************************/
            
            //Atribuindo comando à variável:
            sql = "select count(idcomputador) as computadoresmanutencao from computador where statuscomputador = 'Em manutenção'";
            
            //Executando busca:
            rs = stat.executeQuery(sql);
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setComputadoresManutencao(rs.getString("computadoresmanutencao"));
            
            /*** Computadores aguardando manutenção ***************************/
            
            //Atribuindo comando à variável:
            sql = "select count(idcomputador) as computadoresaguardandomanutencao from computador where statuscomputador = 'Aguardando manutenção'";
            
            //Executando busca:
            rs = stat.executeQuery(sql);
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setComputadoresAguardandoManutencao(rs.getString("computadoresaguardandomanutencao"));
            
            //Retornando objeto com o resultado da busca:
            return est;
        } catch (Exception e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao buscar estatísticas!");
        } finally {
            
            //Fechando conexões com o banco de dados:
            con.close();
            stat.close();
        }//Fecha finally.
    }//Fecha método buscarEstatisticasComputador.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 01/02/2015
     * @param idSecretaria ID da secretaria
     * @param idSetor ID do setor
     * @return Objeto com o resultado da consulta
     * @throws SQLException Falha ao buscar estatísticas
     */
    public EstatisticasVO buscarEstatisticasSecretariaSetor(long idSecretaria, long idSetor) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Objeto para receber o resultado da consulta:
            EstatisticasVO est = new EstatisticasVO();
            
            /*** Estatistícas secretaria **************************************/
            
            sql = "select count(idcomputador) as computadoresdasecretaria from computador where idsecretaria = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setLong(1, idSecretaria);
            
            //Executando busca:
            ResultSet rs = stat.executeQuery();
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setComputadoresDaSecretaria(rs.getString("computadoresdasecretaria"));
            
            /*** Estatistícas setor *******************************************/
            
            sql = "select count(idcomputador) as computadoresdosetor from computador where idsecretaria = ? "
                + "and idsetor = ?";
            
            //Preparando insersão de dados:
            stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setLong(1, idSecretaria);
            stat.setLong(2, idSetor);
            
            //Executando busca:
            rs = stat.executeQuery();
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setComputadoresDoSetor(rs.getString("computadoresdosetor"));
            
            //Fechando conexão com o banco de dados:
            stat.close();
            
            //Retornando objeto com o resultado da busca:
            return est;
        } catch (Exception e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao buscar estatísticas!");
        } finally {
            
            //Fechando conexões com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método buscarEstatisticasSecretariaSetor.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 01/02/2015
     * @param idTecnico ID do técnico
     * @return Objeto com o resultado da consulta
     * @throws SQLException Falha ao buscar estatísticas
     */
    public EstatisticasVO buscarEstatisticasTecnico(long idTecnico) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Objeto para receber o resultado da consulta:
            EstatisticasVO est = new EstatisticasVO();
                       
            /*** Estatistícas computadores do técnico *************************/
            
            //Atribuindo comando à variável SQL:
            sql = "select count(idcomputador) as computadoresdotecnico from computador where idtecnico = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setLong(1, idTecnico);
            
            //Executando busca:
            ResultSet rs = stat.executeQuery();
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setComputadoresDoTecnico(rs.getString("computadoresdotecnico"));
            
            /*** Estatistícas concluídos **************************************/
            
            //Atribuindo comando à variável SQL:
            sql = "select count(idcomputador) as computadoresconcluidostecnico from computador where idtecnico = ? "
                + "and statuscomputador = 'Concluído'";
            
            //Preparando insersão de dados:
            stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setLong(1, idTecnico);
            
            //Executando busca:
            rs = stat.executeQuery();
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setComputadoresConcluidosTecnico(rs.getString("computadoresconcluidostecnico"));
            
            /*** Estatistícas em manutenção ***********************************/
            
            //Atribuindo comando à variável SQL:
            sql = "select count(idcomputador) as computadoresmanutencaotecnico from computador where idtecnico = ? "
                + "and statuscomputador = 'Em manutenção'";
            
            //Preparando insersão de dados:
            stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setLong(1, idTecnico);
            
            //Executando busca:
            rs = stat.executeQuery();
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setComputadoresManutencaoTecnico(rs.getString("computadoresmanutencaotecnico"));
            
            /*** Estatistícas aguardando manutenção ***************************/
            
            //Atribuindo comando à variável SQL:
            sql = "select count(idcomputador) as computadoresaguardandomanutencaotecnico from computador where idtecnico = ? "
                + "and statuscomputador = 'Aguardando manutenção'";
            
            //Preparando insersão de dados:
            stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setLong(1, idTecnico);
            
            //Executando busca:
            rs = stat.executeQuery();
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setComputadoresAguardandoManutencaoTecnico(rs.getString("computadoresaguardandomanutencaotecnico"));
            
            /*** Estatistícas descartados *************************************/
            
            //Atribuindo comando à variável SQL:
            sql = "select count(idcomputador) as computadoresdescartadostecnico from computador where idtecnico = ? "
                + "and statuscomputador = 'Descartado'";
            
            //Preparando insersão de dados:
            stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setLong(1, idTecnico);
            
            //Executando busca:
            rs = stat.executeQuery();
            
            //Configurando objeto com o resultado:
            rs.next();
            
            //Enviando resultado para o objeto de retorno:
            est.setComputadoresDescartadosTecnico(rs.getString("computadoresdescartadostecnico"));
            
            //Fechando conexão com o banco de dados:
            stat.close();
            
            //Retornando objeto com o resultado da busca:
            return est;
        } catch (Exception e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao buscar estatísticas!");
        } finally {
            
            //Fechando conexões com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método buscarEstatisticasTecnico.
}//Fecha classe.
