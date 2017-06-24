
package utilidades;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import modelo.ComputadorVO;


/**
 * @author Maikel Maciel Rönnau
 * @version 1.0
 * @since 28/01/2015
 */
public class Relatorio {
    
    //Atributos da classe:
    private static String caminhoNome;
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 29/01/2015
     * @param computador ArrayList com os dados a serem impressos
     * @throws FileNotFoundException Falha ao não encontrar o caminho
     * @throws DocumentException Falha ao gerar o PDF
     */
    public static void gerarRelatorio(ArrayList<ComputadorVO> computador) throws FileNotFoundException, DocumentException, IOException {
        
        //Criando novo documento:
        Document doc = new Document();
        
        //Criando stream de saída:
        OutputStream os;
        
        //Instanciando classe para salvamento do arquivo:
        JFileChooser fc = new JFileChooser();
        
        //Variável para controlar a abertrua dos relatórios:
        boolean abrirRelatorio = false;
        
        try {

            /*** Criação e exportação do PDF **********************************/

            //Enviando título da janela de salvamento:
            fc.setDialogTitle("Escolha um local para salvar");
            
            //Enviando sugestão de nome para o arquivo:
            fc.setSelectedFile(new File("Relatório de computadores"));
            
            //Não mostrnado arquivos ocultos:
            fc.setFileHidingEnabled(true);
            
            //Mostrando janela de seleção de local de salvamento:
            if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){               
            
                //Definindo abertura do relatório:
                abrirRelatorio = true;
                
                //Recebendo caminho de salvamento e nome arquivo:
                caminhoNome = String.valueOf(fc.getSelectedFile().getPath());

                //Criando documento no padrão A4:
                doc = new Document(PageSize.A4, 40, 40, 40, 40);

                //Configurando páginas em modo paisagem:
                doc.setPageSize(PageSize.A4.rotate());

                //Cria o Stream de saída do documento:
                os = new FileOutputStream(new File(caminhoNome + ".pdf"));

                //Associando a Stream de saída:
                PdfWriter.getInstance(doc, os);

                /*** Fim da criação e exportação do documento *****************/

                //Abrindo o documento:
                doc.open();

                /**************************************************************/
                /*** Cabeçalho ************************************************/
                /**************************************************************/

                //Formatando fonte para o cabeçalho:
                Font fCabecalho = new Font(Font.FontFamily.COURIER, 8);

                //Cabeçalho do documento:
                Paragraph pCabecalho = new Paragraph("EPTI - Escritório Público de Tecnologia da Informação - "
                        + "Prefeitura Municipal de Gravataí", fCabecalho);

                //Alinhando cabeçalho no centro:
                pCabecalho.setAlignment(Element.ALIGN_CENTER);

                //Adicionando espaço:
                pCabecalho.setSpacingAfter(15);

                //Adicionando cabeçalho ao documento:
                doc.add(pCabecalho);

                /**************************************************************/
                /*** Fim cabeçalho ********************************************/
                /**************************************************************/

                /**************************************************************/
                /*** Tablea ***************************************************/
                /**************************************************************/

                //Criando tabela com 7 colunas:
                PdfPTable tabelaComputador = new PdfPTable(new float[] {
                    0.03f, 0.12f, 0.07f, 0.17f, 0.15f, 0.0701f, 0.19f});

                //Configurando tabela para ocupar todo espaço horizontal:
                tabelaComputador.setWidthPercentage(100.0f);

                //Fontes da tabela:
                Font fTituloTabela = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
                Font fColunas = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
                Font fDados = new Font(Font.FontFamily.COURIER, 9);
                Font fNumeroLinhas = new Font(Font.FontFamily.COURIER, 7, Font.BOLD);

                //Criando cabeçalho da tabela:
                PdfPCell header = new PdfPCell(new Paragraph("Relação de computadores", fTituloTabela));

                //Mesclando células do cabeçalho;
                header.setColspan(7);

                //Posicionando cabeçalho:
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setPaddingBottom(6);

                //Enviando cabelalho para a tabela:
                tabelaComputador.addCell(header);

                //Criando colunas da tabela:
                PdfPCell numero = new PdfPCell(new Paragraph("N°", fColunas));
                PdfPCell nomeComputador = new PdfPCell(new Paragraph("Nome computador", fColunas));
                PdfPCell siglaSecretaria = new PdfPCell(new Paragraph("Secretaria", fColunas));
                PdfPCell nomeSetor = new PdfPCell(new Paragraph("Setor", fColunas));
                PdfPCell statusComputador = new PdfPCell(new Paragraph("Status", fColunas));
                PdfPCell dataEntrada = new PdfPCell(new Paragraph("Entrada", fColunas));
                PdfPCell nomeTecnico = new PdfPCell(new Paragraph("Técnico", fColunas));

                //Posicionando colunas:
                numero.setHorizontalAlignment(Element.ALIGN_CENTER);
                nomeComputador.setHorizontalAlignment(Element.ALIGN_CENTER);
                siglaSecretaria.setHorizontalAlignment(Element.ALIGN_CENTER);
                nomeSetor.setHorizontalAlignment(Element.ALIGN_CENTER);
                statusComputador.setHorizontalAlignment(Element.ALIGN_CENTER);
                dataEntrada.setHorizontalAlignment(Element.ALIGN_CENTER);
                nomeTecnico.setHorizontalAlignment(Element.ALIGN_CENTER);
                numero.setPaddingBottom(6);
                nomeComputador.setPaddingBottom(6);
                siglaSecretaria.setPaddingBottom(6);
                nomeSetor.setPaddingBottom(6);
                statusComputador.setPaddingBottom(6);
                dataEntrada.setPaddingBottom(6);
                nomeTecnico.setPaddingBottom(6);

                //Definindo background das colunas:
                numero.setBackgroundColor(BaseColor.LIGHT_GRAY);
                nomeComputador.setBackgroundColor(BaseColor.LIGHT_GRAY);
                siglaSecretaria.setBackgroundColor(BaseColor.LIGHT_GRAY);
                nomeSetor.setBackgroundColor(BaseColor.LIGHT_GRAY);
                statusComputador.setBackgroundColor(BaseColor.LIGHT_GRAY);
                dataEntrada.setBackgroundColor(BaseColor.LIGHT_GRAY);
                nomeTecnico.setBackgroundColor(BaseColor.LIGHT_GRAY);

                //Enviando colunas para a tabela:
                tabelaComputador.addCell(numero);
                tabelaComputador.addCell(nomeComputador);
                tabelaComputador.addCell(siglaSecretaria);
                tabelaComputador.addCell(nomeSetor);
                tabelaComputador.addCell(statusComputador);
                tabelaComputador.addCell(dataEntrada);
                tabelaComputador.addCell(nomeTecnico);

                //Criando variáveis para receber os dados do(s) computadore(s):
                PdfPCell coluna1;
                PdfPCell coluna2;
                PdfPCell coluna3;
                PdfPCell coluna4;
                PdfPCell coluna5;
                PdfPCell coluna6;
                PdfPCell coluna7;

                //Variável para contrar o número de linhas:
                long numeroLinhas = 1;

                for (ComputadorVO computador1 : computador) {

                    //Criando nova linha de dados:
                    coluna1 = new PdfPCell(new Paragraph(String.valueOf(numeroLinhas), fNumeroLinhas));
                    coluna2 = new PdfPCell(new Paragraph(computador1.getNomeComputador(), fDados));
                    coluna3 = new PdfPCell(new Paragraph(computador1.getSecretaria().getSiglaSecretaria(), fDados));
                    coluna4 = new PdfPCell(new Paragraph(computador1.getSetor().getNomeSetor(), fDados));
                    coluna5 = new PdfPCell(new Paragraph(computador1.getStatusComputador(), fDados));
                    coluna6 = new PdfPCell(new Paragraph(Tratamento.dataParaInterface(computador1.getHistoricoComputador().getDataEntrada().toString()), fDados));
                    coluna7 = new PdfPCell(new Paragraph(computador1.getTecnico().getNomeUsuario(), fDados));

                    //Incrementando contagem:
                    numeroLinhas++;

                    //Posicionando dados:
                    coluna1.setHorizontalAlignment(Element.ALIGN_LEFT);
                    coluna2.setHorizontalAlignment(Element.ALIGN_LEFT);
                    coluna3.setHorizontalAlignment(Element.ALIGN_LEFT);
                    coluna4.setHorizontalAlignment(Element.ALIGN_LEFT);
                    coluna5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    coluna6.setHorizontalAlignment(Element.ALIGN_CENTER);
                    coluna7.setHorizontalAlignment(Element.ALIGN_LEFT);
                    coluna1.setPaddingBottom(6);
                    coluna2.setPaddingBottom(6);
                    coluna3.setPaddingBottom(6);
                    coluna4.setPaddingBottom(6);
                    coluna5.setPaddingBottom(6);
                    coluna6.setPaddingBottom(6);
                    coluna7.setPaddingBottom(6);

                    //Adicionando recúo aos dados:
                    coluna2.setPaddingLeft(5);
                    coluna3.setPaddingLeft(5);
                    coluna4.setPaddingLeft(5);
                    coluna7.setPaddingLeft(5);

                    //Definindo background:
                    if(numeroLinhas % 2 != 0){

                        //Definindo cor de fundo:
                        coluna1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        coluna2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        coluna3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        coluna4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        coluna5.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        coluna6.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        coluna7.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }//Fecha if.

                    //Enviando dados para a tabela:
                    tabelaComputador.addCell(coluna1);
                    tabelaComputador.addCell(coluna2);
                    tabelaComputador.addCell(coluna3);
                    tabelaComputador.addCell(coluna4);
                    tabelaComputador.addCell(coluna5);
                    tabelaComputador.addCell(coluna6);
                    tabelaComputador.addCell(coluna7);
                } //Fecha for.

                //Enviando tabela para o documento:
                doc.add(tabelaComputador);            

                /**************************************************************/
                /*** Fim tablea ***********************************************/
                /**************************************************************/
            }//Fecha if.
        } catch (HeadlessException | FileNotFoundException | DocumentException e) {
            
            /*
                Somente entrará aqui caso o usuário cancele a geração do PDF
            */            
        } finally {
            
            //Fechando o documento e liberando objetos::
            doc.close();
            
            //Verificando se um relatório deve ser aberto:
            if(abrirRelatorio){
                
                //Abrindo relatório gerado:
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + caminhoNome + ".pdf");
            }//Fehca if.
        }//Fecha finally.
    }//Fecha método gerarRelatorio.  
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 29/01/2015
     * @param com Objeto com os dados do computador
     * @throws FileNotFoundException Falha ao não encontrar o caminho
     */
    public static void gerarRelatorioManutencao(ComputadorVO com) throws IOException{
        
        //Criando novo documento:
        Document doc = new Document();
        
        //Criando stream de saída:
        OutputStream os;
        
        //Instanciando classe para salvamento do arquivo:
        JFileChooser fc = new JFileChooser();
        
        //Variável para controlar a abertrua dos relatórios:
        boolean abrirRelatorio = false;
        
        try {

            /*** Criação e exportação do PDF **********************************/

            //Enviando título da janela de salvamento:
            fc.setDialogTitle("Escolha um local para salvar");
            
            //Enviando sugestão de nome para o arquivo:
            fc.setSelectedFile(new File(String.valueOf(com.getHistoricoComputador().getIdHistoricoComputador()) 
                    + " - Relatório Manutenção " + com.getNomeComputador()));
            
            //Não mostrnado arquivos ocultos:
            fc.setFileHidingEnabled(true);
            
            //Mostrando janela de seleção de local de salvamento:
            if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            
                //Definindo abertura do relatório:
                abrirRelatorio = true;
                
                //Recebendo caminho de salvamento e nome arquivo:
                caminhoNome = String.valueOf(fc.getSelectedFile().getPath());

                //Criando documento no padrão A4:
                doc = new Document(PageSize.A4, 40, 40, 40, 40);

                //Configurando páginas em modo paisagem:
                //doc.setPageSize(PageSize.A4.rotate());

                //Cria o Stream de saída do documento:
                os = new FileOutputStream(new File(caminhoNome + ".pdf"));

                //Associando a Stream de saída:
                PdfWriter.getInstance(doc, os);

                /*** Fim da criação e exportação do documento *****************/

                //Abrindo o documento:
                doc.open();

                /**************************************************************/
                /*** Cabeçalho ************************************************/
                /**************************************************************/

                //Formatando fonte para o cabeçalho:
                Font fCabecalho = new Font(Font.FontFamily.COURIER, 7);

                //Cabeçalho do documento:
                Paragraph pCabecalho = new Paragraph("EPTI - Escritório Público de Tecnologia da Informação - "
                        + "Prefeitura Municipal de Gravataí", fCabecalho);

                //Alinhando cabeçalho no centro:
                pCabecalho.setAlignment(Element.ALIGN_CENTER);

                //Adicionando espaço:
                pCabecalho.setSpacingAfter(10);

                //Adicionando cabeçalho ao documento:
                doc.add(pCabecalho);

                /**************************************************************/
                /*** Fim Cabeçalho ********************************************/
                /**************************************************************/          

                /**************************************************************/
                /*** Tabela Dados *********************************************/
                /**************************************************************/

                //Criando tabela com 4 colunas:
                PdfPTable tabelaDados = new PdfPTable(new float[] {0.16f, 0.3f, 0.16f, 0.3f});

                //Configurando tabela para ocupar todo espaço horizontal:
                tabelaDados.setWidthPercentage(100.0f);

                //Criando fonte para os títulos dos dados e para os dados:
                Font fTituloDocumento = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
                Font fSubtitulo = new Font(Font.FontFamily.COURIER, 9, Font.BOLD);
                Font fTituloDados = new Font(Font.FontFamily.COURIER, 8, Font.BOLD);
                Font fDados = new Font(Font.FontFamily.COURIER, 8);
                Font fDescricao = new Font(Font.FontFamily.COURIER, 7);
                Font flinhas = new Font(Font.FontFamily.COURIER, 12);

                //Criando cabeçalho da tabela:
                PdfPCell header = new PdfPCell(new Paragraph("Relatório de manutenção computador " 
                        + com.getNomeComputador(), fTituloDocumento));

                //Mesclando células do cabeçalho;
                header.setColspan(4);

                //Posicionando cabeçalho:
                header.setPaddingBottom(10);
                header.setBorder(Rectangle.NO_BORDER);
                header.setBorder(Rectangle.BOTTOM);

                //Enviando cabelalho para a tabela:
                tabelaDados.addCell(header);            

                //Variável para receber os títulos e os dados:
                PdfPCell celula;

                /*** Adicionando títulos e dados à tabela *********************/

                celula = new PdfPCell(new Paragraph("   N° relatório.:", fTituloDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph(String.valueOf(com.getHistoricoComputador().getIdHistoricoComputador()), fDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph("   Contato......:", fTituloDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph(com.getContato(), fDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph("   Nome.........:", fTituloDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph(com.getNomeComputador(), fDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph("   Telefone.....:", fTituloDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                if(com.getTelefone().equals("(51)    -    ")){
                    celula = new PdfPCell(new Paragraph(" - - -", fDados));
                } else {
                    celula = new PdfPCell(new Paragraph(com.getTelefone(), fDados));
                }//Fecha else.
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph("   Secretaria...:", fTituloDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph(com.getSecretaria().getSiglaSecretaria(), fDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph("   Data entrada.:", fTituloDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph(Tratamento.dataParaInterface(com.getHistoricoComputador().getDataEntrada().toString()), fDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph("   Setor........:", fTituloDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph(com.getSetor().getNomeSetor(), fDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph("   Hora entrada.:", fTituloDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph(com.getHistoricoComputador().getHoraEntrada().toString(), fDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph("   Status.......:", fTituloDados));
                celula.setPaddingTop(5);
                celula.setPaddingBottom(12);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph(com.getStatusComputador(), fDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                celula = new PdfPCell(new Paragraph("   Memorando....:", fTituloDados));
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);

                if(com.getMemorandoComputador().equals("    /    ") | com.getMemorandoComputador().isEmpty()){
                    celula = new PdfPCell(new Paragraph(" - - -", fDados));
                } else {
                    celula = new PdfPCell(new Paragraph(com.getMemorandoComputador(), fDados));
                }//Fecha else.
                celula.setPaddingTop(5);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaDados.addCell(celula);            

                /**************************************************************/
                /*** Fim Tabela Dados *****************************************/
                /**************************************************************/

                /**************************************************************/
                /*** Descrição ************************************************/
                /**************************************************************/

                //Criando novo cabeçalho da tabela:
                header = new PdfPCell(new Paragraph("Descrição/problema", fSubtitulo));

                //Mesclando células do cabeçalho;
                header.setColspan(4);

                //Posicionando cabeçalho:
                header.setPaddingTop(5);
                header.setPaddingBottom(10);
                header.setBorder(Rectangle.NO_BORDER);
                header.setBorder(Rectangle.TOP);

                //Enviando cabelalho para a tabela:
                tabelaDados.addCell(header);            

                //Preparando descrição:
                celula = new PdfPCell(new Paragraph(com.getDescricaoComputador(), fDescricao));
                celula.setPaddingBottom(5);
                celula.setBorder(Rectangle.NO_BORDER);
                celula.setBorder(Rectangle.BOTTOM);
                celula.setColspan(4);

                //Enviando descrição do computador para a tabela:
                tabelaDados.addCell(celula);

                //Adicionando tabela ao documento:
                doc.add(tabelaDados); 

                /**************************************************************/
                /*** Fim Descrição ********************************************/
                /**************************************************************/

                /**************************************************************/
                /*** Tabela Relatório *****************************************/
                /**************************************************************/

                //Criando nova tabela para o relatório de manutenção:
                PdfPTable tabelaRelatorio = new PdfPTable(new float[] {0.25f, 0.23f, 0.27f, 0.25f});

                //Configurando tabela para ocupar todo espaço horizontal:
                tabelaRelatorio.setWidthPercentage(100.0f);

                //Criando novo cabeçalho da tabela:
                header = new PdfPCell(new Paragraph("Relatório de manutenção", fSubtitulo));

                //Mesclando células do cabeçalho;
                header.setColspan(4);

                //Posicionando cabeçalho:
                header.setPaddingTop(5);
                header.setPaddingBottom(10);
                header.setBorder(Rectangle.NO_BORDER);
                header.setBorder(Rectangle.TOP);

                //Enviando cabelalho para a tabela:
                tabelaRelatorio.addCell(header);            

                /*** Enviando relatório ***************************************/

                if(com.getHistoricoComputador().getLimpeza() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Limpeza", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Limpeza", fDados));
                }//Fecha else.
                celula.setPaddingBottom(8);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getDriverPack() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Driver Pack", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Driver Pack", fDados));
                }//Fecha else.
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getJava() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Java", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Java", fDados));
                }//Fecha else.
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getUsuarios() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Usuários", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Usuários", fDados));
                }//Fecha else.
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getBackup() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Backup", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Backup", fDados));
                }//Fecha else.
                celula.setPaddingBottom(8);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getTrocaDeFonte() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Troca de fonte", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Troca de fonte", fDados));
                }//Fecha else.
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getAdobereader() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Adobe Reader", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Adobe Reader", fDados));
                }//Fecha else.
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getDominio() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Domínio", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Domínio", fDados));
                }//Fecha else.
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getReparacaoso() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Reparação S.O", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Reparação S.O", fDados));
                }//Fecha else.
                celula.setPaddingBottom(8);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getLibreOffice() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Libre Office", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Libre Office", fDados));
                }//Fecha else.
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getWinrarFlash() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Winrar/Flash Player", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Winrar/Flash Player", fDados));
                }//Fecha else.
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getUltravnc() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Ultra VNC", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Ultra VNC", fDados));
                }//Fecha else.
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getInstalacaoso() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Instalação S.O", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Instalação S.O", fDados));
                }//Fecha else.
                //celula.setPaddingTop(8);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getAntivirus() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Antivírus", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Antivírus", fDados));
                }//Fecha else.
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getConversoresPdf() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Conversores PDF", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Conversores PDF", fDados));
                }//Fecha else.
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getAtivacaoWindows() == 1){
                    celula = new PdfPCell(new Paragraph("( X ) Ativação Windows", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Ativação Windows", fDados));
                }//Fecha else.
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getSubstituicaoHd()== 1){
                    celula = new PdfPCell(new Paragraph("( X ) Substituição HD", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Substituição HD", fDados));
                }//Fecha else.
                celula.setPaddingTop(8);
                celula.setPaddingBottom(8);
                //celula.setBorder(Rectangle.NO_BORDER);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getNavegadores()== 1){
                    celula = new PdfPCell(new Paragraph("( X ) Navegadores", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Navegadores", fDados));
                }//Fecha else.
                celula.setPaddingTop(8);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getFirewallCentralSeg()== 1){
                    celula = new PdfPCell(new Paragraph("( X ) Firewall/Central Seg.", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Firewall/Central Seg.", fDados));
                }//Fecha else.
                celula.setPaddingTop(8);
                //celula.setBorder(Rectangle.NO_BORDER);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);

                if(com.getHistoricoComputador().getIcones()== 1){
                    celula = new PdfPCell(new Paragraph("( X ) Ícones", fTituloDados));
                } else {
                    celula = new PdfPCell(new Paragraph("(   ) Ícones", fDados));
                }//Fecha else.
                celula.setPaddingTop(8);
                celula.setBorder(Rectangle.NO_BORDER);
                tabelaRelatorio.addCell(celula);            

                /**************************************************************/
                /*** Fim Tabela Relatório *************************************/
                /**************************************************************/

                /**************************************************************/
                /*** Observações e demais informações *************************/
                /**************************************************************/

                //Criando novo cabeçalho da tabela:
                header = new PdfPCell(new Paragraph("Observações", fSubtitulo));

                //Mesclando células do cabeçalho;
                header.setColspan(4);

                //Posicionando cabeçalho:
                header.setPaddingTop(5);
                header.setPaddingBottom(5);
                header.setBorder(Rectangle.NO_BORDER);
                header.setBorder(Rectangle.TOP);

                //Adicionando cabeçalho:
                tabelaRelatorio.addCell(header);

                //Adicionando tabela ao documento:
                doc.add(tabelaRelatorio);

                //Adicionando linhas de observação:
                Paragraph linha = new Paragraph("__________________________________"
                        + "________________________________________________________"
                        + "________________________________________________________"
                        + "________________________________________________________"
                        + "________________________________________________________"
                        + "__________________________", flinhas);
                linha.setSpacingAfter(10);
                doc.add(linha);

                /*** Informações de conclusão *************************************/

                //Envinado novo subtitulo:
                doc.add(new Paragraph("Informações sobre a conclusão", fSubtitulo));

                //Variável para receber as informações de conclusão:
                Paragraph conclusao;

                //Enviando data e hora de conclusão:
                if(com.getStatusComputador().equals("Concluído") | com.getStatusComputador().equals("Descartado")){

                    conclusao = new Paragraph("Data: " + Tratamento.dataParaInterface(
                        com.getHistoricoComputador().getDataConclusao().toString())
                        + "             Hora: " + com.getHistoricoComputador().getHoraConclusao().toString(), fSubtitulo);
                } else {

                    conclusao = new Paragraph("Data: __/__/____             Hora: ________", fSubtitulo);
                }//Fecha else.
                conclusao.setSpacingBefore(15);
                conclusao.setAlignment(Element.ALIGN_CENTER);
                doc.add(conclusao);

                //Enviando linha de assinatura:
                conclusao = new Paragraph("___________________________", flinhas);            
                conclusao.setSpacingBefore(15);
                conclusao.setAlignment(Element.ALIGN_CENTER);
                doc.add(conclusao);

                //Enviando nome do ténico:
                conclusao = new Paragraph(com.getTecnico().getNomeUsuario(), fSubtitulo);
                conclusao.setSpacingBefore(6);
                conclusao.setAlignment(Element.ALIGN_CENTER);
                doc.add(conclusao);    

                /**************************************************************/
                /*** Observações e demais informações *************************/
                /**************************************************************/
            }//Fecha if.
        } catch (HeadlessException | FileNotFoundException | DocumentException e) {
            
            /*
                Somente entrará aqui caso o usuário cancele a geração do PDF
            */ 
        } finally {
            
            //Fechando o documento:
            doc.close();
             
            //Verificando se um relatório deve ser aberto:
            if(abrirRelatorio){
                
                //Abrindo relatório gerado:
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + caminhoNome + ".pdf");
            }//Fehca if.
        }//Fecha finally.
    }//Fecha método gerarRelatorioManutencao.
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 1.0
     * @since 29/01/2015
     * @param com Objeto com os dados do computador
     * @throws FileNotFoundException Falha ao não encontrar o caminho
     */
    public static void imprimirRelatorioManutencao(ComputadorVO com) throws FileNotFoundException{
        
        //Criando novo documento:
        Document doc = new Document();
        
        //Criando stream de saída:
        OutputStream os;
        
        try {
            
            //Criando arquivo do relatório:
            os = new FileOutputStream(new File("C:\\Program Files (x86)\\Sistema EPTI\\relatorios\\rel_man_to_print.pdf"));
            
            //Associando a stream de saída:
            PdfWriter.getInstance(doc, os);
            
            //Abrindo o documento:
            doc.open();
            
            /******************************************************************/
            /*** Cabeçalho ****************************************************/
            /******************************************************************/
            
            //Formatando fonte para o cabeçalho:
            Font fCabecalho = new Font(Font.FontFamily.COURIER, 7);
            
            //Cabeçalho do documento:
            Paragraph pCabecalho = new Paragraph("EPTI - Escritório Público de Tecnologia da Informação - "
                    + "Prefeitura Municipal de Gravataí", fCabecalho);
            
            //Alinhando cabeçalho no centro:
            pCabecalho.setAlignment(Element.ALIGN_CENTER);
            
            //Adicionando espaço:
            pCabecalho.setSpacingAfter(10);
            
            //Adicionando cabeçalho ao documento:
            doc.add(pCabecalho);

            /******************************************************************/
            /*** Fim Cabeçalho ************************************************/
            /******************************************************************/          

            /******************************************************************/
            /*** Tabela Dados *************************************************/
            /******************************************************************/
            
            //Criando tabela com 4 colunas:
            PdfPTable tabelaDados = new PdfPTable(new float[] {0.16f, 0.3f, 0.16f, 0.3f});
            
            //Configurando tabela para ocupar todo espaço horizontal:
            tabelaDados.setWidthPercentage(100.0f);
            
            //Criando fonte para os títulos dos dados e para os dados:
            Font fTituloDocumento = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
            Font fSubtitulo = new Font(Font.FontFamily.COURIER, 9, Font.BOLD);
            Font fTituloDados = new Font(Font.FontFamily.COURIER, 8, Font.BOLD);
            Font fDados = new Font(Font.FontFamily.COURIER, 8);
            Font fDescricao = new Font(Font.FontFamily.COURIER, 7);
            Font flinhas = new Font(Font.FontFamily.COURIER, 12);

            //Criando cabeçalho da tabela:
            PdfPCell header = new PdfPCell(new Paragraph("Relatório de manutenção computador " + com.getNomeComputador(), fTituloDocumento));
            
            //Mesclando células do cabeçalho;
            header.setColspan(4);
            
            //Posicionando cabeçalho:
            header.setPaddingBottom(10);
            header.setBorder(Rectangle.NO_BORDER);
            header.setBorder(Rectangle.BOTTOM);
            
            //Enviando cabelalho para a tabela:
            tabelaDados.addCell(header);            
            
            //Variável para receber os títulos e os dados:
            PdfPCell celula;
            
            /*** Adicionando títulos e dados à tabela *************************/
            
            celula = new PdfPCell(new Paragraph("   N° relatório.:", fTituloDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph(String.valueOf(com.getHistoricoComputador().getIdHistoricoComputador()), fDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph("   Contato......:", fTituloDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph(com.getContato(), fDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph("   Nome.........:", fTituloDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph(com.getNomeComputador(), fDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph("   Telefone.....:", fTituloDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            if(com.getTelefone().equals("(51)    -    ")){
                celula = new PdfPCell(new Paragraph(" - - -", fDados));
            } else {
                celula = new PdfPCell(new Paragraph(com.getTelefone(), fDados));
            }//Fecha else.
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph("   Secretaria...:", fTituloDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph(com.getSecretaria().getSiglaSecretaria(), fDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph("   Data entrada.:", fTituloDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph(Tratamento.dataParaInterface(com.getHistoricoComputador().getDataEntrada().toString()), fDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph("   Setor........:", fTituloDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph(com.getSetor().getNomeSetor(), fDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph("   Hora entrada.:", fTituloDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph(com.getHistoricoComputador().getHoraEntrada().toString(), fDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph("   Status.......:", fTituloDados));
            celula.setPaddingTop(5);
            celula.setPaddingBottom(12);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph(com.getStatusComputador(), fDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            celula = new PdfPCell(new Paragraph("   Memorando....:", fTituloDados));
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);
            
            if(com.getMemorandoComputador().equals("    /    ") | com.getMemorandoComputador().isEmpty()){
                celula = new PdfPCell(new Paragraph(" - - -", fDados));
            } else {
                celula = new PdfPCell(new Paragraph(com.getMemorandoComputador(), fDados));
            }//Fecha else.
            celula.setPaddingTop(5);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaDados.addCell(celula);            
            
            /******************************************************************/
            /*** Fim Tabela Dados *********************************************/
            /******************************************************************/
            
            /******************************************************************/
            /*** Descrição ****************************************************/
            /******************************************************************/
            
            //Criando novo cabeçalho da tabela:
            header = new PdfPCell(new Paragraph("Descrição/problema", fSubtitulo));
            
            //Mesclando células do cabeçalho;
            header.setColspan(4);
            
            //Posicionando cabeçalho:
            header.setPaddingTop(5);
            header.setPaddingBottom(10);
            header.setBorder(Rectangle.NO_BORDER);
            header.setBorder(Rectangle.TOP);
            
            //Enviando cabelalho para a tabela:
            tabelaDados.addCell(header);            
            
            //Preparando descrição:
            celula = new PdfPCell(new Paragraph(com.getDescricaoComputador(), fDescricao));
            celula.setPaddingBottom(5);
            celula.setBorder(Rectangle.NO_BORDER);
            celula.setBorder(Rectangle.BOTTOM);
            celula.setColspan(4);
            
            //Enviando descrição do computador para a tabela:
            tabelaDados.addCell(celula);
            
            //Adicionando tabela ao documento:
            doc.add(tabelaDados); 
            
            /******************************************************************/
            /*** Fim Descrição ************************************************/
            /******************************************************************/
            
            /******************************************************************/
            /*** Tabela Relatório *********************************************/
            /******************************************************************/
            
            //Criando nova tabela para o relatório de manutenção:
            PdfPTable tabelaRelatorio = new PdfPTable(new float[] {0.25f, 0.23f, 0.27f, 0.25f});
            
            //Configurando tabela para ocupar todo espaço horizontal:
            tabelaRelatorio.setWidthPercentage(100.0f);
            
            //Criando novo cabeçalho da tabela:
            header = new PdfPCell(new Paragraph("Relatório de manutenção", fSubtitulo));
            
            //Mesclando células do cabeçalho;
            header.setColspan(4);
            
            //Posicionando cabeçalho:
            header.setPaddingTop(5);
            header.setPaddingBottom(10);
            header.setBorder(Rectangle.NO_BORDER);
            header.setBorder(Rectangle.TOP);
            
            //Enviando cabelalho para a tabela:
            tabelaRelatorio.addCell(header);            
            
            /*** Enviando relatório *******************************************/
            
            if(com.getHistoricoComputador().getLimpeza() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Limpeza", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Limpeza", fDados));
            }//Fecha else.
            celula.setPaddingBottom(8);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getDriverPack() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Driver Pack", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Driver Pack", fDados));
            }//Fecha else.
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getJava() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Java", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Java", fDados));
            }//Fecha else.
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getUsuarios() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Usuários", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Usuários", fDados));
            }//Fecha else.
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getBackup() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Backup", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Backup", fDados));
            }//Fecha else.
            celula.setPaddingBottom(8);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getTrocaDeFonte() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Troca de fonte", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Troca de fonte", fDados));
            }//Fecha else.
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getAdobereader() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Adobe Reader", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Adobe Reader", fDados));
            }//Fecha else.
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getDominio() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Domínio", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Domínio", fDados));
            }//Fecha else.
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getReparacaoso() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Reparação S.O", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Reparação S.O", fDados));
            }//Fecha else.
            celula.setPaddingBottom(8);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getLibreOffice() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Libre Office", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Libre Office", fDados));
            }//Fecha else.
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getWinrarFlash() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Winrar/Flash Player", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Winrar/Flash Player", fDados));
            }//Fecha else.
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getUltravnc() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Ultra VNC", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Ultra VNC", fDados));
            }//Fecha else.
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getInstalacaoso() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Instalação S.O", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Instalação S.O", fDados));
            }//Fecha else.
            //celula.setPaddingTop(8);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getAntivirus() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Antivírus", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Antivírus", fDados));
            }//Fecha else.
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getConversoresPdf() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Conversores PDF", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Conversores PDF", fDados));
            }//Fecha else.
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getAtivacaoWindows() == 1){
                celula = new PdfPCell(new Paragraph("( X ) Ativação Windows", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Ativação Windows", fDados));
            }//Fecha else.
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getSubstituicaoHd()== 1){
                celula = new PdfPCell(new Paragraph("( X ) Substituição HD", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Substituição HD", fDados));
            }//Fecha else.
            celula.setPaddingTop(8);
            celula.setPaddingBottom(8);
            //celula.setBorder(Rectangle.NO_BORDER);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getNavegadores()== 1){
                celula = new PdfPCell(new Paragraph("( X ) Navegadores", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Navegadores", fDados));
            }//Fecha else.
            celula.setPaddingTop(8);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getFirewallCentralSeg()== 1){
                celula = new PdfPCell(new Paragraph("( X ) Firewall/Central Seg.", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Firewall/Central Seg.", fDados));
            }//Fecha else.
            celula.setPaddingTop(8);
            //celula.setBorder(Rectangle.NO_BORDER);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);
            
            if(com.getHistoricoComputador().getIcones()== 1){
                celula = new PdfPCell(new Paragraph("( X ) Ícones", fTituloDados));
            } else {
                celula = new PdfPCell(new Paragraph("(   ) Ícones", fDados));
            }//Fecha else.
            celula.setPaddingTop(8);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaRelatorio.addCell(celula);            
            
            /******************************************************************/
            /*** Fim Tabela Relatório *****************************************/
            /******************************************************************/
            
            /******************************************************************/
            /*** Observações e demais informações *****************************/
            /******************************************************************/
            
            //Criando novo cabeçalho da tabela:
            header = new PdfPCell(new Paragraph("Observações", fSubtitulo));
            
            //Mesclando células do cabeçalho;
            header.setColspan(4);
            
            //Posicionando cabeçalho:
            header.setPaddingTop(5);
            header.setPaddingBottom(5);
            header.setBorder(Rectangle.NO_BORDER);
            header.setBorder(Rectangle.TOP);
            
            //Adicionando cabeçalho:
            tabelaRelatorio.addCell(header);
            
            //Adicionando tabela ao documento:
            doc.add(tabelaRelatorio);
            
            //Adicionando linhas de observação:
            Paragraph linha = new Paragraph("__________________________________"
                    + "________________________________________________________"
                    + "________________________________________________________"
                    + "________________________________________________________"
                    + "________________________________________________________"
                    + "__________________________", flinhas);
            linha.setSpacingAfter(10);
            doc.add(linha);
            
            /*** Informações de conclusão *************************************/
            
            //Envinado novo subtitulo:
            doc.add(new Paragraph("Informações sobre a conclusão", fSubtitulo));
            
            //Variável para receber as informações de conclusão:
            Paragraph conclusao;

            //Enviando data e hora de conclusão:
            if(com.getStatusComputador().equals("Concluído") | com.getStatusComputador().equals("Descartado")){
                
                conclusao = new Paragraph("Data: " + Tratamento.dataParaInterface(
                    com.getHistoricoComputador().getDataConclusao().toString())
                    + "             Hora: " + com.getHistoricoComputador().getHoraConclusao().toString(), fSubtitulo);
            } else {
                
                conclusao = new Paragraph("Data: __/__/____             Hora: ________", fSubtitulo);
            }//Fecha else.
            conclusao.setSpacingBefore(15);
            conclusao.setAlignment(Element.ALIGN_CENTER);
            doc.add(conclusao);
            
            //Enviando linha de assinatura:
            conclusao = new Paragraph("___________________________", flinhas);            
            conclusao.setSpacingBefore(15);
            conclusao.setAlignment(Element.ALIGN_CENTER);
            doc.add(conclusao);
            
            //Enviando nome do ténico:
            conclusao = new Paragraph(com.getTecnico().getNomeUsuario(), fSubtitulo);
            conclusao.setSpacingBefore(6);
            conclusao.setAlignment(Element.ALIGN_CENTER);
            doc.add(conclusao);    
            
            /******************************************************************/
            /*** Observações e demais informações *****************************/
            /******************************************************************/
            
        } catch (HeadlessException | DocumentException e) {
            
            /*
                Somente entrará aqui caso o usuário cancele a geração do PDF
            */ 
        } finally {
            
            //Fechando o documento:
            doc.close();
        }//Fecha finally.
    }//Fecha método imprimirRelatorioManutencao.
}//Fecha classe.


