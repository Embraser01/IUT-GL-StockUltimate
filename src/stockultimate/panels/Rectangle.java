/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockultimate.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author p1400336
 */
public class Rectangle extends JComponent {

    int x;
    int y;
    int w;
    int h;
    Color c;
    
    public Rectangle(int x, int y, int w, int h, Color c) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;
        
    
        
    }

    // Creation Rectangle
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x-2, y-2, w+4, h+4);
        g.setColor(c);
        g.fillRect(x, y, w, h);
        
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

   
}
