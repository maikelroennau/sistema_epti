
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.HistoricoComputadorVO;
import persistencia.ConexaoBanco;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 14/01/2015
 */
public class HistoricoComputadorDAO {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param his Objeto com os dados a serem cadastrados
     * @return ID da permissão cadastrada
     * @throws SQLException Falha ao cadastrar histórico
     */
    public long cadastrarHistoricoComputador(HistoricoComputadorVO his) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "insert into historicocomputador(idhistoricocomputador, dataentrada, horaentrada,"
                + "dataconclusao, horaconclusao, limpeza, backup, reparacaoso, instalacaoso, "
                + "substituicaohd, driverpack, trocadefonte, libreoffice, antivirus, navegadores, "
                + "java, adobereader, winrarflash, conversorespdf, firewallcentralseg, usuarios, "
                + "dominio, ultravnc, ativacaowindows, icones, historicocomputador) "
                + "values(null, now(), now(), null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null)";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
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
            throw new SQLException("Erro ao cadastrar hitórico!");
        } finally {
            
            //Fechando conexão:
            con.close();
        }//Fecha finally.
    }//Fecha método cadastrarHistoricoComputador.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param his Objeto com os dados a serem atualizados
     * @throws SQLException Falha ao atualizar histórico
     */
    public void atualizarHistoricoComputador(HistoricoComputadorVO his) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {

            //Variável para receber o comando SQL:
            String sql;

            //Atribuindo comando à variável:
            sql = "update historicocomputador set dataentrada = ?, horaentrada = ?, dataconclusao = ?, "
                + "horaconclusao = ?, limpeza = ?, backup = ?, reparacaoso = ?, instalacaoso = ?, "
                + "substituicaohd = ?, driverpack = ?, trocadefonte = ?, libreoffice = ?, antivirus = ?, "
                + "navegadores = ?, java = ?, adobereader = ?, winrarflash = ?, conversorespdf = ?, "
                + "firewallcentralseg = ?, usuarios = ?, dominio = ?, ultravnc = ?, ativacaowindows = ?, "
                + "icones = ? where idhistoricocomputador = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);

            //Inserindo dados ao comando:
            stat.setDate(1, his.getDataEntrada());
            stat.setTime(2, his.getHoraEntrada());
            stat.setDate(3, his.getDataConclusao());
            stat.setTime(4, his.getHoraConclusao());
            stat.setByte(5, his.getLimpeza());
            stat.setByte(6, his.getBackup());
            stat.setByte(7, his.getReparacaoso());
            stat.setByte(8, his.getInstalacaoso());
            stat.setByte(9, his.getSubstituicaoHd());
            stat.setByte(10, his.getDriverPack());
            stat.setByte(11, his.getTrocaDeFonte());
            stat.setByte(12, his.getLibreOffice());
            stat.setByte(13, his.getAntivirus());
            stat.setByte(14, his.getNavegadores());
            stat.setByte(15, his.getJava());
            stat.setByte(16, his.getAdobereader());
            stat.setByte(17, his.getWinrarFlash());
            stat.setByte(18, his.getConversoresPdf());
            stat.setByte(19, his.getFirewallCentralSeg());
            stat.setByte(20, his.getUsuarios());
            stat.setByte(21, his.getDominio());
            stat.setByte(22, his.getUltravnc());
            stat.setByte(23, his.getAtivacaoWindows());
            stat.setByte(24, his.getIcones());
            stat.setLong(25, his.getIdHistoricoComputador());
            
            //Executando exclusão:
            stat.executeUpdate();

            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {

            //Lançando erro:
            throw new SQLException("Erro ao atualizar histórico!");
        } finally {

            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método atualizarHistorico.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 14/01/2015
     * @param his Objeto com os dados a serem atualizado
     * @throws SQLException Falha ao atualizar histórico
     */
    public void atualizarHistorico(HistoricoComputadorVO his) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "update historicocomputador set historicocomputador = ? "
                + "where idhistoricocomputador = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, his.getHistoricoComputador());
            stat.setLong(2, his.getIdHistoricoComputador());

            //Executando exclusão:
            stat.executeUpdate();
            
            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao atualizar histórico!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método atualizarHistorico.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 15/01/2015
     * @version 1.0
     * @param idHistoricoComputador Variável com o ID do histórico a ser excluído
     * @throws SQLException Falha ao excluir histórico
     */
    public void excluirHistoricoComputador(long idHistoricoComputador) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "delete from historicocomputador where idhistorico = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setLong(1, idHistoricoComputador);
            
            //Executando exclusão:
            stat.execute();
            
            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao excluir histórico!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método excluirHistorico.
}//Fecha classe.
