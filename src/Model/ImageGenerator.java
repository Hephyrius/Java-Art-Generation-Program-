package Model;
/**
 * @author Harnick Khera - P13233249
 *
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageGenerator extends Canvas {
    //fields
    private DataSystem imageData;
    
    //constructor
    public ImageGenerator(DataSystem d){
        imageData = d;
    }
    
    /**
     * updates the data system that is referenced
     * @param d the new data system
     */
    public void setData(DataSystem d){
        imageData = d;
    }
    
    /**
     * paints the canvas
     */
    @Override
    public void paint(Graphics g) {
        Color c;
        int width = imageData.getWidth();
        int height = imageData.getHeight();
        super.paint(g);
        
        //iterates over data and gets color values. maps this to pixels.
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                c = imageData.getColor(x, y);
                g.setColor(c);
                g.drawLine(x, y, x, y);
            }
        }
    }
    
    /**
     * Converts and saves the data system
     * @param s streng value containing the file name and path
     */
    public void saveImg(String s){
        int width = imageData.getWidth();
        int height = imageData.getHeight();
        BufferedImage image = new  BufferedImage(imageData.getWidth(), imageData.getHeight(),BufferedImage.TYPE_INT_RGB);
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                Color c = imageData.getColor(x, y);
                int i = c.getRGB();
                image.setRGB(x, y, i);
            }
        }
        try {
            System.out.println("Exporting image: "+s+".png");
            FileOutputStream out = new FileOutputStream(s+".png");
            ImageIO.write(image, "png", out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Converts and saves the data system
     * @param s string value containing the file name and path
     * @param i integer used to diffentiate between save methods
     */
    public void saveImg(String s, int in){
        int width = imageData.getWidth();
        int height = imageData.getHeight();
        BufferedImage image = new  BufferedImage(imageData.getWidth(), imageData.getHeight(),BufferedImage.TYPE_INT_RGB);
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                Color c = imageData.getColor(x, y);
                int i = c.getRGB();
                image.setRGB(x, y, i);
            }
        }
        try {
            System.out.println("Exporting image: "+s);
            FileOutputStream out = new FileOutputStream(s);
            ImageIO.write(image, "png", out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * import a image file and convert it to a dataSystem
     * @param in string containing file name and path
     * @return converted data system of the imported image
     */
    public DataSystem imagetoDataSystem(String in){
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(new File(in));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        DataSystem importedData = new DataSystem(image.getWidth(), image.getHeight());
        
        for(int x =0; x<image.getWidth(); x++){
            for(int y = 0; y<image.getHeight(); y++){
                int c = image.getRGB(x, y);
                importedData.setColor(x, y, new Color(c));
            }
        }
        
        return importedData;
    }
    
}
