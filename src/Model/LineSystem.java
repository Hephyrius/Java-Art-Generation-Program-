
package Model;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * @author Harnick Khera - P13233249
 *
 */
public class LineSystem {
    
    //fields
    private DataSystem imageData;
    private BufferedImage bi;
    private Graphics g;
    private int width;
    private int height;
    
    //constructor
    public LineSystem(DataSystem ds){
        imageData = ds;
        width = ds.getWidth();
        height = ds.getHeight();
        bi = new  BufferedImage(width*2, height*2 ,BufferedImage.TYPE_INT_RGB);
        g = bi.createGraphics();
        
    }
    
    /**
     * Draws lines based on the input parametres passed in
     * @param li integer value of total number of lines
     * @param a integer value of angle
     * @param le integer value of length
     * @param s integer value of grouwth
     * @param modifier  double value of line modifier
     */
    public void drawLines(int li, int a, int le, int s, double modifier){
        double startx = width/2;
        double starty = height/2;
        double length = le;
        double originalangle = a;
        double angle = 0;
        double endx;
        double endy;
        int increment = s;
        int iterations = 0;
        
        while(iterations < li){
            length = length+increment;
            angle = angle+originalangle;
            
            
            
            endx = startx + Math.cos(angle* 0.01745329252) * length;
            endy = starty + Math.sin(angle* 0.01745329252) * length;
            
            
            g.drawLine((int)startx, (int)starty, (int)endx, (int)endy);
            
            startx = startx + Math.cos(angle* 0.01745329252) * (length *modifier);
            starty = starty + Math.sin(angle* 0.01745329252) * (length*modifier);
            iterations++;
        }
    }
    
    /**
     * draws lines based on pre programmed values
     */
    public void drawLines(){
        double startx = width/2;
        double starty = height/2;
        double length = 5;
        double originalangle = 74;
        double angle = 0;
        double endx;
        double endy;
        int increment = 3;
        int iterations = 0;
        
        while(iterations < 1000){
            length = length+increment;
            angle = angle+originalangle;
            
            
            
            endx = startx + Math.cos(angle* 0.01745329252) * length;
            endy = starty + Math.sin(angle* 0.01745329252) * length;
            
            
            g.drawLine((int)startx, (int)starty, (int)endx, (int)endy);
            
            startx = endx+1;
            starty = endy+1;
            iterations++;
        }
    }
    
    /**
     * Converts the temporary buffered image into a data system
     * @return the output data system
     */
    public DataSystem updateData(){
        
        DataSystem temp = new DataSystem(width, height);
        
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                int r = bi.getRGB((width/4)+x, (height/4)+y);
                temp.setColor(x, y, new Color(r));
            }
        }
        
        return temp;
    }
}
