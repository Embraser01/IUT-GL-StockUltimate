/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stockultimate.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author p1400336
 */
public class ImageCanvas extends JComponent{

    private Image img;
    private int x;
    private int y;
    
    public ImageCanvas(int x, int y, String path) {
        this.x = x;
        this.y = y;
        
        try {

            img = ImageIO.read(new File(path));
            img = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    
   
    
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(null),img.getHeight(null));
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
    
    
    
}
