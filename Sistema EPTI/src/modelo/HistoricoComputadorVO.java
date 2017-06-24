
package modelo;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 14/01/2015
 */
public class HistoricoComputadorVO {
    
    //Atributos da classe:
    private long idHistoricoComputador;
    
    private Date dataEntrada;
    private Time horaEntrada;
    private Date dataConclusao;
    private Time horaConclusao;
    
    private byte limpeza;
    private byte backup;
    private byte reparacaoso;
    private byte instalacaoso;
    private byte substituicaoHd;
    
    private byte driverPack;
    private byte trocaDeFonte;
    private byte libreOffice;
    private byte antivirus;
    private byte navegadores;
    
    private byte java;
    private byte adobereader;
    private byte winrarFlash;
    private byte conversoresPdf;
    private byte firewallCentralSeg;
    
    private byte usuarios;
    private byte dominio;
    private byte ultravnc;
    private byte ativacaoWindows;
    private byte icones;
    
    private String historicoComputador;
    //Fim dos atributos da classe.
    
    //Método construtor:
    public HistoricoComputadorVO() {
    }//Fecha construtor.

    /*** Métodos acessores da classe ******************************************/
    
    public long getIdHistoricoComputador() {
        return idHistoricoComputador;
    }

    public void setIdHistoricoComputador(long idHistoricoComputador) {
        this.idHistoricoComputador = idHistoricoComputador;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Time getHoraConclusao() {
        return horaConclusao;
    }

    public void setHoraConclusao(Time horaConclusao) {
        this.horaConclusao = horaConclusao;
    }

    public byte getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(byte limpeza) {
        this.limpeza = limpeza;
    }

    public byte getBackup() {
        return backup;
    }

    public void setBackup(byte backup) {
        this.backup = backup;
    }

    public byte getReparacaoso() {
        return reparacaoso;
    }

    public void setReparacaoso(byte reparacaoso) {
        this.reparacaoso = reparacaoso;
    }

    public byte getInstalacaoso() {
        return instalacaoso;
    }

    public void setInstalacaoso(byte instalacaoso) {
        this.instalacaoso = instalacaoso;
    }

    public byte getSubstituicaoHd() {
        return substituicaoHd;
    }

    public void setSubstituicaoHd(byte substituicaoHd) {
        this.substituicaoHd = substituicaoHd;
    }

    public byte getDriverPack() {
        return driverPack;
    }

    public void setDriverPack(byte driverPack) {
        this.driverPack = driverPack;
    }

    public byte getTrocaDeFonte() {
        return trocaDeFonte;
    }

    public void setTrocaDeFonte(byte trocaDeFonte) {
        this.trocaDeFonte = trocaDeFonte;
    }

    public byte getLibreOffice() {
        return libreOffice;
    }

    public void setLibreOffice(byte libreOffice) {
        this.libreOffice = libreOffice;
    }

    public byte getAntivirus() {
        return antivirus;
    }

    public void setAntivirus(byte antivirus) {
        this.antivirus = antivirus;
    }

    public byte getNavegadores() {
        return navegadores;
    }

    public void setNavegadores(byte navegadores) {
        this.navegadores = navegadores;
    }

    public byte getJava() {
        return java;
    }

    public void setJava(byte java) {
        this.java = java;
    }

    public byte getAdobereader() {
        return adobereader;
    }

    public void setAdobereader(byte adobereader) {
        this.adobereader = adobereader;
    }

    public byte getWinrarFlash() {
        return winrarFlash;
    }

    public void setWinrarFlash(byte winrarFlash) {
        this.winrarFlash = winrarFlash;
    }

    public byte getConversoresPdf() {
        return conversoresPdf;
    }

    public void setConversoresPdf(byte conversoresPdf) {
        this.conversoresPdf = conversoresPdf;
    }

    public byte getFirewallCentralSeg() {
        return firewallCentralSeg;
    }

    public void setFirewallCentralSeg(byte firewallCentralSeg) {
        this.firewallCentralSeg = firewallCentralSeg;
    }

    public byte getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(byte usuarios) {
        this.usuarios = usuarios;
    }

    public byte getDominio() {
        return dominio;
    }

    public void setDominio(byte dominio) {
        this.dominio = dominio;
    }

    public byte getUltravnc() {
        return ultravnc;
    }

    public void setUltravnc(byte ultravnc) {
        this.ultravnc = ultravnc;
    }

    public byte getAtivacaoWindows() {
        return ativacaoWindows;
    }

    public void setAtivacaoWindows(byte ativacaoWindows) {
        this.ativacaoWindows = ativacaoWindows;
    }

    public byte getIcones() {
        return icones;
    }

    public void setIcones(byte icones) {
        this.icones = icones;
    }

    public String getHistoricoComputador() {
        return historicoComputador;
    }

    public void setHistoricoComputador(String historicoComputador) {
        this.historicoComputador = historicoComputador;
    }
    /*** Fim dos métodos acessores da classe **********************************/
}//Fecha classe.
