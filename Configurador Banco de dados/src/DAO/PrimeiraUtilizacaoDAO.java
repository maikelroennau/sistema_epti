
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import persistencia.ConexaoBanco;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 03/02/2015
 */
public class PrimeiraUtilizacaoDAO {

    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 03/02/2015
     * @throws SQLException Erro ao configurar primeria utilização
     */
    public void configurarBancoPrimeiraUtilizacao() throws SQLException {

        //Conectando com o banco de dados:
        Connection con = ConexaoBanco.getConnection();
        Statement stat = con.createStatement();

        try {

            //Variável para receber o comando SQL:
            String sql;

            //Comandos para configurar o banco de dados:
            sql = "use epti;";
            stat.execute(sql);
            
            sql = "CREATE TABLE secretaria("
                + "   idsecretaria BIGINT AUTO_INCREMENT,"
                + "   nomesecretaria VARCHAR(71) NOT NULL,"
                + "   siglasecretaria VARCHAR(10) NOT NULL,"
                + "   UNIQUE KEY(nomesecretaria),"
                + "   UNIQUE KEY(siglasecretaria),"
                + "   PRIMARY KEY(idsecretaria)"
                + ");";
            stat.execute(sql);
                
            sql = "CREATE TABLE setor("
                + "   idsetor BIGINT AUTO_INCREMENT,"
                + "   nomesetor VARCHAR(29) NOT NULL,"
                + "   idsecretaria BIGINT NOT NULL,"
                + "   PRIMARY KEY(idsetor),"
                + "   FOREIGN KEY(idsecretaria) REFERENCES secretaria(idsecretaria) ON UPDATE CASCADE ON DELETE CASCADE"
                + ");";
            stat.execute(sql);
            
            sql = "CREATE TABLE permissoes("
                + "   idpermissoes BIGINT AUTO_INCREMENT,"
                + "   cadastrarcomputador TINYINT,"
                + "   consultarcomputador TINYINT,"
                + "   editarcomputador TINYINT,"
                + "   excluircomputador TINYINT,"
                + "   cadastrarsecretaria TINYINT,"
                + "   consultarsecretaria TINYINT,"
                + "   editarsecretaria TINYINT,"
                + "   excluirsecretaria TINYINT,"
                + "   cadastrarsetor TINYINT,"
                + "   consultarsetor TINYINT,"
                + "   editarsetor TINYINT,"
                + "   excluirsetor TINYINT,"
                + "   cadastrarusuario TINYINT,"
                + "   consultarusuario TINYINT,"
                + "   editarusuario TINYINT,"
                + "   excluirusuario TINYINT,"
                + "   editarpermissoes TINYINT,"
                + "   realizarmanutencao TINYINT,"
                + "   PRIMARY KEY(idpermissoes)"
                + ");";
            stat.execute(sql);
            
            sql = "CREATE TABLE usuario("
                + "   idusuario BIGINT AUTO_INCREMENT,"
                + "   nomeusuario VARCHAR(40) NOT NULL,"
                + "   loginusuario VARCHAR(20) NOT NULL,"
                + "   senhausuario VARCHAR(128) NOT NULL,"
                + "   statususuario TINYINT NOT NULL,"
                + "   idpermissoes BIGINT NOT NULL,"
                + "   UNIQUE KEY(nomeusuario),"
                + "   UNIQUE KEY(loginusuario),"
                + "   PRIMARY KEY(idusuario),"
                + "   FOREIGN KEY(idpermissoes) REFERENCES permissoes(idpermissoes) ON DELETE CASCADE"
                + ");";
            stat.execute(sql);
            
            sql = "CREATE TABLE historicocomputador("
                + "   idhistoricocomputador BIGINT AUTO_INCREMENT,"
                + "   dataentrada DATE NOT NULL,"
                + "   horaentrada TIME NOT NULL,"
                + "   dataconclusao DATE,"
                + "   horaconclusao TIME,"
                + "   limpeza TINYINT,"
                + "   backup TINYINT,"
                + "   reparacaoso TINYINT,"
                + "   instalacaoso TINYINT,"
                + "   substituicaohd TINYINT,"
                + "   driverpack TINYINT,"
                + "   trocadefonte TINYINT,"
                + "   libreoffice TINYINT,"
                + "   antivirus TINYINT,"
                + "   navegadores TINYINT,"
                + "   java TINYINT,"
                + "   adobereader TINYINT,"
                + "   winrarflash TINYINT,"
                + "   conversorespdf TINYINT,"
                + "   firewallcentralseg TINYINT,"
                + "   usuarios TINYINT,"
                + "   dominio TINYINT,"
                + "   ultravnc TINYINT,"
                + "   ativacaowindows TINYINT,"
                + "   icones TINYINT,"
                + "   historicocomputador TEXT,"
                + "   PRIMARY KEY(idhistoricocomputador)"
                + ");";
            stat.execute(sql);
            
            sql = "CREATE TABLE computador("
                + "   idcomputador BIGINT AUTO_INCREMENT,"
                + "   nomecomputador VARCHAR(20) NOT NULL,"
                + "   statuscomputador VARCHAR(21) NOT NULL,"
                + "   memorandocomputador VARCHAR(9),"
                + "   contato VARCHAR(40),"
                + "   telefone VARCHAR(14),"
                + "   descricaocomputador TEXT NOT NULL,"
                + "   idhistoricocomputador BIGINT NOT NULL,"
                + "   idtecnico BIGINT NOT NULL,"
                + "   idsecretaria BIGINT NOT NULL,"
                + "   idsetor BIGINT NOT NULL,"
                + "   UNIQUE KEY(nomecomputador),"
                + "   PRIMARY KEY(idcomputador),"
                + "   FOREIGN KEY(idhistoricocomputador) REFERENCES historicocomputador(idhistoricocomputador) ON DELETE CASCADE,"
                + "   FOREIGN KEY(idtecnico) REFERENCES usuario(idusuario) ON UPDATE CASCADE,"
                + "   FOREIGN KEY(idsecretaria) REFERENCES secretaria(idsecretaria) ON DELETE CASCADE,"
                + "   FOREIGN KEY(idsetor) REFERENCES setor(idsetor) ON DELETE CASCADE"
                + ");";
            stat.execute(sql);
            
            sql = "INSERT INTO `permissoes` (`idpermissoes`, `cadastrarcomputador`, `consultarcomputador`,"
                + "`editarcomputador`, `excluircomputador`, `cadastrarsecretaria`, `consultarsecretaria`,"
                + "`editarsecretaria`, `excluirsecretaria`, `cadastrarsetor`, `consultarsetor`, `editarsetor`,"
                + "`excluirsetor`, `cadastrarusuario`, `consultarusuario`, `editarusuario`, `excluirusuario`,"
                + "`editarpermissoes`, `realizarmanutencao`) VALUES "
                + "(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0),"
                + "(2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);";
            stat.execute(sql);
            
            sql = "INSERT INTO `usuario` (`idusuario`, `nomeusuario`, `loginusuario`, `senhausuario`, "
                + "`statususuario`, `idpermissoes`) VALUES(1, 'Administrator', 'user.admin', "
                + "'26E4F0AEC6AB6290F1538840149E1CEED84EC59793A290EA05B999EC736CF94828E0C7B15F2C1A3888548A64BC7EAECF5EDC574A5A5D130F80FE77C74CCF3AAD', 1, 1),"
                + "(2, 'Não selecionado', 'zzznao.selecionado', '26E4F0AEC6AB6290F1538840149E1CEED84EC59793A290EA05B999EC736CF94828E0C7B15F2C1A3888548A64BC7EAECF5EDC574A5A5D130F80FE77C74CCF3AAD', 1, 2);";
            stat.execute(sql);
        } catch (Exception e) {

            //Lançando erro:
            throw new SQLException(e.getMessage());
        } finally {

            //Fechando conexões com o banco de dados:
            con.close();
            stat.close();
        }//Fecha finally.
    }//Fecha método configurarBancoPrimeiraUtilizacao.
}//Fecha classe.
