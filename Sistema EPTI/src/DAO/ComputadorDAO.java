
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.ComputadorVO;
import modelo.HistoricoComputadorVO;
import modelo.SecretariaVO;
import modelo.SetorVO;
import modelo.UsuarioVO;
import persistencia.ConexaoBanco;

/**
 * @author Maikel Maciel Rönnau
 * @since 1.0
 * @version 14/01/2015
 */
public class ComputadorDAO {
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 14/01/2015
     * @version 1.0
     * @param com Objeto com os dados a serem cadastrados
     * @throws SQLException Falha ao cadastrar computador
     */
    public void cadastrarComputador(ComputadorVO com) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "insert into computador(idcomputador, nomecomputador, statuscomputador, "
                + "memorandocomputador, contato, telefone, descricaocomputador, idhistoricocomputador, "
                + "idtecnico, idsecretaria, idsetor) values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, com.getNomeComputador());
            stat.setString(2, com.getStatusComputador());
            stat.setString(3, com.getMemorandoComputador());
            stat.setString(4, com.getContato());
            stat.setString(5, com.getTelefone());
            stat.setString(6, com.getDescricaoComputador());
            stat.setLong(7, com.getHistoricoComputador().getIdHistoricoComputador());
            stat.setLong(8, com.getTecnico().getIdUsuario());
            stat.setLong(9, com.getSecretaria().getIdSecretaria());
            stat.setLong(10, com.getSetor().getIdSetor());
            
            //Executando insersão:
            stat.execute();
            
            //Fechando conexão com o banco de dados:
            stat.close();
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao cadastrar computador!");
        } finally {
            
            //Fechando conexão:
            con.close();
        }//Fecha finally.
    }//Fecha método cadastrarComputador.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 15/01/2015
     * @version 1.0
     * @return Objeto com os computadores cadastrados
     * @throws SQLException Falha ao selecionar computadores
     */
    public ArrayList<ComputadorVO> selecionarComputadores() throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        Statement stat = con.createStatement();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select c.idcomputador, c.nomecomputador, c.contato, c.statuscomputador, "
                + "u.nomeusuario, h.dataentrada, h.horaentrada, s.siglasecretaria, se.nomesetor " 
                + "from computador as c inner join historicocomputador as h "
                + "on c.idhistoricocomputador = h.idhistoricocomputador "
                + "inner join secretaria as s on c.idsecretaria = s.idsecretaria "
                + "inner join setor as se on c.idsetor = se.idsetor "
                + "inner join usuario as u on c.idtecnico = u.idusuario "
                + "order by h.dataentrada desc";
            
            //Executando busca:
            ResultSet rs = stat.executeQuery(sql);
            
            //ArrayList para receber o resultado da query:
            ArrayList<ComputadorVO> computador = new ArrayList<>();
            
            //Instanciando objeto da classe base:
            ComputadorVO com;
            
            //Instanciando objeto das demais classes:
            HistoricoComputadorVO his;
            UsuarioVO user;
            SecretariaVO sec;
            SetorVO set;
            
            //While para montra os objetos resultantes da busca:
            while(rs.next()){
                
                //Criando novo objeto para receber os dados:
                his = new HistoricoComputadorVO();
                
                //Enviando dados da consulta para o objeto:
                his.setDataEntrada(rs.getDate("dataentrada"));
                his.setHoraEntrada(rs.getTime("horaentrada"));
                
                //Criando novo objeto para receber os dados:
                user = new UsuarioVO();
                
                //Enviando dados da consulta para o objeto:
                user.setNomeUsuario(rs.getString("nomeusuario"));
                
                //Criando novo objeto para receber os dados:
                sec = new SecretariaVO();
                
                //Enviando dados da consulta para o objeto:
                sec.setSiglaSecretaria(rs.getString("siglasecretaria"));
                
                //Criando novo objeto para receber os dados:
                set = new SetorVO();
                
                //Enviando dados da consulta para o objeto:
                set.setNomeSetor(rs.getString("nomesetor"));
                
                //Criando novo objeto para receber os dados:
                com = new ComputadorVO();
                
                //Enviando dados da consulta para o objeto:
                com.setIdComputador(rs.getLong("idcomputador"));
                com.setNomeComputador(rs.getString("nomecomputador"));
                com.setStatusComputador(rs.getString("statuscomputador"));
                com.setContato(rs.getString("contato"));
                com.setHistoricoComputador(his);
                com.setTecnico(user);
                com.setSecretaria(sec);
                com.setSetor(set);
                
                //Adicionando objeto ao ArrayList:
                computador.add(com);
            }//Fecha while.
            
            //Retornando ArryaList com o resultado da busca:
            return computador;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao selecionar computadores cadastrados!");
        } finally {
            
            //Fechando conexões com o banco de dados:
            con.close();
            stat.close();
        }//Fecha finally.
    }//Fecha método selecionarComputadores.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 15/01/2015
     * @version 1.0
     * @param nomeComputador Mome do computador a ser pesquisado
     * @param idTecnico ID do técnico a ser pesquisado
     * @param idSecretaria ID da secretaria a ser pesquisada
     * @param idSetor ID do setor a ser pesquisado
     * @param statusComputador Status do computador a ser pesquisado
     * @param dataEntrada Data com a pesquisa a ser feita
     * @return Resultado da pesquisa
     * @throws SQLException Falha ao pesquisar
     */
    public ArrayList<ComputadorVO> filtrarComputador(String nomeComputador, String idTecnico, 
            String idSecretaria, String idSetor, String statusComputador, String dataEntrada) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        Statement stat = con.createStatement();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select c.idcomputador, c.nomecomputador, c.contato, c.statuscomputador, "
                + "u.nomeusuario, h.dataentrada, h.horaentrada, s.siglasecretaria, se.nomesetor " 
                + "from computador as c inner join historicocomputador as h "
                + "on c.idhistoricocomputador = h.idhistoricocomputador "
                + "inner join secretaria as s on c.idsecretaria = s.idsecretaria "
                + "inner join setor as se on c.idsetor = se.idsetor "
                + "inner join usuario as u on c.idtecnico = u.idusuario "
                + "where c.nomecomputador like '%" + nomeComputador + "%' and "
                + "c.idtecnico " + idTecnico + " and c.idsecretaria " + idSecretaria + " and "
                + "c.idsetor " + idSetor + " and c.statuscomputador " + statusComputador + " "
                + dataEntrada;
            
            //Executando busca:
            ResultSet rs = stat.executeQuery(sql);
            
            //ArrayList para receber o resultado da query:
            ArrayList<ComputadorVO> computador = new ArrayList<>();
            
            //Instanciando objeto da classe base:
            ComputadorVO com;
            
            //Instanciando objeto das demais classes:
            HistoricoComputadorVO his;
            UsuarioVO user;
            SecretariaVO sec;
            SetorVO set;
            
            //While para montra os objetos resultantes da busca:
            while(rs.next()){
                
                //Criando novo objeto para receber os dados:
                his = new HistoricoComputadorVO();
                
                //Enviando dados da consulta para o objeto:
                his.setDataEntrada(rs.getDate("dataentrada"));
                his.setHoraEntrada(rs.getTime("horaentrada"));
                
                //Criando novo objeto para receber os dados:
                user = new UsuarioVO();
                
                //Enviando dados da consulta para o objeto:
                user.setNomeUsuario(rs.getString("nomeusuario"));
                
                //Criando novo objeto para receber os dados:
                sec = new SecretariaVO();
                
                //Enviando dados da consulta para o objeto:
                sec.setSiglaSecretaria(rs.getString("siglasecretaria"));
                
                //Criando novo objeto para receber os dados:
                set = new SetorVO();
                
                //Enviando dados da consulta para o objeto:
                set.setNomeSetor(rs.getString("nomesetor"));
                
                //Criando novo objeto para receber os dados:
                com = new ComputadorVO();
                
                //Enviando dados da consulta para o objeto:
                com.setIdComputador(rs.getLong("idcomputador"));
                com.setNomeComputador(rs.getString("nomecomputador"));
                com.setStatusComputador(rs.getString("statuscomputador"));
                com.setContato(rs.getString("contato"));
                com.setHistoricoComputador(his);
                com.setTecnico(user);
                com.setSecretaria(sec);
                com.setSetor(set);
                
                //Adicionando objeto ao ArrayList:
                computador.add(com);
            }//Fecha while.
            
            //Fechando conexão com o banco de dados:
            stat.close();
            
            //Retornando ArryaList com o resultado da busca:
            return computador;
        } catch (SQLException e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao filtrar computadores!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método filtrarComputador.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 23/01/2015
     * @version 1.0
     * @param idComputador ID do computador a ser buscado
     * @return Objeto com o resultado da busca
     * @throws SQLException Falha ao buscar computador
     */
    public ComputadorVO buscarComputadorParaEdicao(long idComputador) throws SQLException{
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "select * from computador as c inner join historicocomputador as h "
                + "on c.idhistoricocomputador = h.idhistoricocomputador  "
                + "inner join usuario as u on c.idtecnico = u.idusuario "
                + "inner join secretaria as s on c.idsecretaria = s.idsecretaria "
                + "inner join setor as se on c.idsetor = se.idsetor "
                + "where c.idcomputador = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setLong(1, idComputador);

            //Executando busca:
            ResultSet rs = stat.executeQuery();
            
            //Instanciando objeto da classe base:
            ComputadorVO com;
            
            //Instanciando objeto das demais classes:
            HistoricoComputadorVO his;
            UsuarioVO user;
            SecretariaVO sec;
            SetorVO set;
            
            //Configurando objeto de resultado:
            rs.next();
            
            //Criando novo objeto para receber os dados:
            his = new HistoricoComputadorVO();

            //Enviando dados da consulta para o objeto:
            his.setIdHistoricoComputador(rs.getLong("idhistoricocomputador"));
            his.setDataEntrada(rs.getDate("dataentrada"));
            his.setHoraEntrada(rs.getTime("horaentrada"));
            his.setDataConclusao(rs.getDate("dataconclusao"));
            his.setHoraConclusao(rs.getTime("horaconclusao"));
            his.setLimpeza(rs.getByte("limpeza"));
            his.setBackup(rs.getByte("backup"));
            his.setReparacaoso(rs.getByte("reparacaoso"));
            his.setInstalacaoso(rs.getByte("instalacaoso"));
            his.setSubstituicaoHd(rs.getByte("substituicaohd"));
            his.setDriverPack(rs.getByte("driverPack"));
            his.setTrocaDeFonte(rs.getByte("trocaDeFonte"));
            his.setLibreOffice(rs.getByte("libreOffice"));
            his.setAntivirus(rs.getByte("antivirus"));
            his.setNavegadores(rs.getByte("navegadores"));
            his.setJava(rs.getByte("java"));
            his.setAdobereader(rs.getByte("adobereader"));
            his.setWinrarFlash(rs.getByte("winrarFlash"));
            his.setConversoresPdf(rs.getByte("conversoresPdf"));
            his.setFirewallCentralSeg(rs.getByte("firewallCentralSeg"));
            his.setUsuarios(rs.getByte("usuarios"));
            his.setDominio(rs.getByte("dominio"));
            his.setUltravnc(rs.getByte("ultravnc"));
            his.setAtivacaoWindows(rs.getByte("ativacaoWindows"));
            his.setIcones(rs.getByte("icones"));
            his.setHistoricoComputador(rs.getString("historicocomputador"));            

            //Criando novo objeto para receber os dados:
            user = new UsuarioVO();

            //Enviando dados da consulta para o objeto:
            user.setIdUsuario(rs.getLong("idusuario"));
            user.setNomeUsuario(rs.getString("nomeusuario"));

            //Criando novo objeto para receber os dados:
            sec = new SecretariaVO();

            //Enviando dados da consulta para o objeto:
            sec.setIdSecretaria(rs.getLong("idsecretaria"));
            sec.setSiglaSecretaria(rs.getString("siglasecretaria"));

            //Criando novo objeto para receber os dados:
            set = new SetorVO();

            //Enviando dados da consulta para o objeto:
            set.setIdSetor(rs.getLong("idsetor"));
            set.setNomeSetor(rs.getString("nomesetor"));

            //Criando novo objeto para receber os dados:
            com = new ComputadorVO();

            //Enviando dados da consulta para o objeto:
            com.setIdComputador(rs.getLong("idcomputador"));
            com.setNomeComputador(rs.getString("nomecomputador"));
            com.setStatusComputador(rs.getString("statuscomputador"));
            com.setMemorandoComputador(rs.getString("memorandocomputador"));
            com.setContato(rs.getString("contato"));
            com.setTelefone(rs.getString("telefone"));
            com.setDescricaoComputador(rs.getString("descricaocomputador"));
            com.setHistoricoComputador(his);
            com.setTecnico(user);
            com.setSecretaria(sec);
            com.setSetor(set);
            
            //Fechando conexão com o banco de dados:
            stat.close();
            
            //Retornando objeto com o resultado da busca:
            return com;
        } catch (Exception e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao buscar computador para edição!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método buscarComputadorParaEdicao.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 26/01/2015
     * @param com Objeto com os dados a serem atualizados
     * @throws SQLException Falha ao atualizar computador
     */
    public void atualizarComputador(ComputadorVO com) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "update computador set nomecomputador = ?, statuscomputador = ?, "
                + "memorandocomputador = ?, contato = ?, telefone = ?, descricaocomputador = ?, "
                + "idtecnico = ? where idcomputador = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, com.getNomeComputador());
            stat.setString(2, com.getStatusComputador());
            stat.setString(3, com.getMemorandoComputador());
            stat.setString(4, com.getContato());
            stat.setString(5, com.getTelefone());
            stat.setString(6, com.getDescricaoComputador());
            stat.setLong(7, com.getTecnico().getIdUsuario());
            stat.setLong(8, com.getIdComputador());
            
            //Executando atualização:
            stat.executeUpdate();
            
            //Fechando conexão com o banco de dados:
            stat.close();            
        } catch (Exception e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao atualizar computador!");
        } finally {
            
            //Fechando conexão com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método atualizarComputador.
    
    /**
     * @author Maikel Maciel Rönnau
     * @since 07/01/2015
     * @version 1.0
     * @param idComputador Variável com o ID do computador a ser excluído
     * @throws SQLException Falha ao excluir computador
     */
    public void excluirComputador(String idComputador) throws SQLException {
        
        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        //Fim da conexão com o banco de dados.        
        
        try {
            
            //Variável para receber o comando SQL:
            String sql;
            
            //Atribuindo comando à variável:
            sql = "delete from computador where idcomputador = ?";
            
            //Preparando insersão de dados:
            PreparedStatement stat = con.prepareStatement(sql);
            
            //Inserindo dados ao comando:
            stat.setString(1, idComputador);
            
            //Executando exclusão:
            stat.execute();
            
            //Fechando conexão com o banco de dados:
            stat.close();            
        } catch (Exception e) {
            
            //Lançando erro:
            throw new SQLException("Erro ao excluir computador!");
        } finally {
        
            //Fechando conexões com o banco de dados:
            con.close();
        }//Fecha finally.
    }//Fecha método excluirComputador.
}//Fecha classe.
