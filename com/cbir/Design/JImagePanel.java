package com.cbir.Design;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class JImagePanel extends JPanel{   
    private BufferedImage image;   
    int x, y,pwid,pht;   
    public JImagePanel(BufferedImage image, int x, int y,int pwid,int pht) {   
      //  super();   
        this.image = image;   
        this.x = x;   
        this.y = y;   
       this.pwid=pwid;
       this.pht=pht;
        
    }   
   
    /*
    protected void paintComponent(Graphics g) {   
        super.paintComponent(g);   
        g.drawImage(image,x,y,100,100, this);   
    } 
    */
    

    public  void paint(Graphics g) {   
           
       g.drawImage(image,x,y,pwid,pht,this); 
        
      
        
    } 
}  