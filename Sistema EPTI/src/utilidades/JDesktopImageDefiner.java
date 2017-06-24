
package utilidades;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 * @author Maikel Maciel Rönnau
 * @version 2.0
 * @since 05/01/2015
 */
public class JDesktopImageDefiner extends JDesktopPane {
    
    /**
     * @author Maikel Maciel Rönnau
     * @version 2.0
     * @since 05/01/2015
     * @param g Imagem a ser desenhada no JDesktopPane
     */
    @Override
    protected void paintComponent(Graphics g) {
        
        //Instanciando objeto para fazer o desenho da imagem:
        Graphics2D graphics = (Graphics2D) g.create();
        
        //Instanciando objeto da imagem de fundo: 
        Image img = new ImageIcon(getClass().getResource("/icones/wallpapper.png")).getImage();
        
        //Desenhar imagem conforme o tamanho da janela:
        graphics.drawImage(img, 0, 0, getWidth(), getHeight(), null); 
        
        //Desativando classe após desenhar.
        graphics.dispose();
    }//Fecha método paintComponent.
}//Fecha classe.
