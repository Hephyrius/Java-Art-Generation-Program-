package Model;

/**
 * @author Harnick Khera - P13233249
 *
 */

import java.awt.Color;
import java.util.Random;

public class NoiseGenerator {
    
    //fields
    private DataSystem imageData;
    private int mode;
    private Random rand = new Random();
    
    /**
     * Constructor
     * @param m integer value of mode
     * @param im input data system
     */
    public NoiseGenerator(int m, DataSystem im){
        imageData = im;
        mode = m;
    }
    
    /**
     * Randomizes all colours
     */
    public void trueRandom(){
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        int x,y;
        Color c;
        
        for(x=0;x<width;x++){
            for(y=0;y<height;y++){
                c= new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
                imageData.setColor(x, y, c);
            }
        }
    }
    
    /**
     * randomize only red colour values
     */
    public void redRandom(){
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        int x,y;
        Color c;
        
        for(x=0;x<width;x++){
            for(y=0;y<height;y++){
                c= new Color(rand.nextInt(256),0,0);
                imageData.setColor(x, y, c);
            }
        }
    }
    
    /**
     * randomize only green colour values
     */
    public void greenRandom(){
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        int x,y;
        Color c;
        
        for(x=0;x<width;x++){
            for(y=0;y<height;y++){
                c= new Color(0,rand.nextInt(256),0);
                imageData.setColor(x, y, c);
            }
        }
    }
    
/**
 * randomize only blue colour values
 */
    public void blueRandom(){
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        int x,y;
        Color c;
        
        for(x=0;x<width;x++){
            for(y=0;y<height;y++){
                c= new Color(0,0,rand.nextInt(256));
                imageData.setColor(x, y, c);
            }
        }
    }
    /**
     * Randomizes all colours within a limited range
     */
    public void trueLimitedRandom(){
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        int x,y;
        Color c;
        
        for(x=0;x<width;x++){
            for(y=0;y<height;y++){
                c= new Color(rand.nextInt(256)/2,rand.nextInt(256)/3,rand.nextInt(256)/4);
                imageData.setColor(x, y, c);
            }
        }
    }
    
    /**
     * update the data system based on assigned mode
     */
    public void update(){
        if(mode == 0){
            trueRandom();
        }
        else if(mode == 1){
            trueLimitedRandom();
        }
        else if(mode == 2){
            redRandom();
        }
        else if(mode == 3){
            greenRandom();
        }
        else if(mode == 4){
            blueRandom();
        }
        
    }
    
    /**
     * return the generated noise
     * @return generated noise data system
     */
    public DataSystem returnData(){
        return imageData;
    }
}
