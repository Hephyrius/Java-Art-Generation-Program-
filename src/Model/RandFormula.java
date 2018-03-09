package Model;
/**
 * @author Harnick Khera - P13233249
 *
 */
import java.awt.Color;
import java.util.Random;


public class RandFormula{
    
    //fields
    private DataSystem imageData;
    private Random rand = new Random();
    private int red,green,blue,gamma;
    private int Rmode,Gmode,Bmode, Amode;
    
    //constructor
    public RandFormula(DataSystem im){
        imageData = im;
    }
    
    //class methods
    
    /**
     *sets the mode which are used to select formulas
     */
    public void setMode(){
        Rmode = rand.nextInt(10);
        Gmode = rand.nextInt(10);
        Bmode = rand.nextInt(10);
        Amode = rand.nextInt(3);
    }
    
    /**
     * sets gamma value based on input mode
     * @param x integer value of x coordinate
     * @param y integer value of y coordinate
     * @param m integer value of mode
     */
    public void genGamma(int x, int y, int m){
        
        if(m==0){
            gamma=(y*y)/255;
        }
        else if(m==1){
            gamma=(x*x)/255;
        }
        else if(m==2){
            gamma = (x*y)/255;
        }
        
        gamma = validateRGBInt(gamma);
    }
    
    /**
     * calculate the green integer value
     * @param x integer value of x coordinate
     * @param y integer value of y coordinate
     * @param m integer value of mode
     */
    public void randGreen(int x, int y, int m){
        if(m==0){
            green=x+y-255;
        }
        else if(m==1){
            green=x-255;
        }
        else if(m==2){
            green=y-255;
        }
        else if(m==3){
            green=(x/255)*y;
            
        }
        else if(m==4){
            green=(x*y)/255;
            
        }
        else if(m==5){
            green= (y/255)*x;
        }
        else if(m==6){
            green=(y*y)/255;
        }
        else if(m==7){
            green=(x*x)/255;
        }
        else if(m==8){
            green = (x*x*x)/(255+y);
        }
        else if(m==9){
            green = (y*y*y)/(255+x);
        }
        
        green = validateRGBInt(green);
    }
    
    /**
     * calculate the blue integer value
     * @param x integer value of x coordinate
     * @param y integer value of y coordinate
     * @param m integer value of mode
     */
    public void randBlue(int x, int y, int m){
        if(m==0){
            blue=x+y-255;
        }
        else if(m==1){
            blue=x-255;
        }
        else if(m==2){
            blue=y-255;
        }
        else if(m==3){
            blue=(x/255)*y;
            
        }
        else if(m==4){
            blue=(x*y)/255;
            
        }
        else if(m==5){
            blue= (y/255)*x;
        }
        else if(m==6){
            blue=(y*y)/255;
        }
        else if(m==7){
            blue=(x*x)/255;
        }
        else if(m==8){
            blue = (x*x*x)/(255+y);
        }
        else if(m==9){
            blue = (y*y*y)/(255+x);
        }
        
        
        blue = validateRGBInt(blue);
    }
    
    /**
     * calculate the red integer value
     * @param x integer value of x coordinate
     * @param y integer value of y coordinate
     * @param m integer value of mode
     */
    public void randRed(int x, int y, int m){
        if(m==0){
            red=x+y-255;
        }
        else if(m==1){
            red=x-255;
        }
        else if(m==2){
            red=y-255;
        }
        else if(m==3){
            red=(x/255)*y;
            
        }
        else if(m==4){
            red=(x*y)/255;
            
        }
        else if(m==5){
            red= (y/255)*x;
        }
        else if(m==6){
            red=(y*y)/255;
        }
        else if(m==7){
            red=(x*x)/255;
        }
        else if(m==8){
            red = (x*x*x)/(255+y);
        }
        else if(m==9){
            red = (y*y*y)/(255+x);
        }
        
        red = validateRGBInt(red);
    }
    
    
    /**
     *ensures values are within the range of 0-255
     * @param i value that is being checked
     * @return verified integer
     */
    public int validateRGBInt(int i){
        if(i>255){
            i=255;
        }
        else if(0>i){
            i=0;
        }
        return i;
    }
    
    
    /**
     * Creates a colour from generated RGB Values
     * @param x integer value of x coordinate
     * @param y integer value of y coordinate
     * @return generated colour
     */
    public Color rgb(int x, int y){
        randRed(x,y,Rmode);
        randGreen(x,y,Gmode);
        randBlue(x,y,Bmode);
        Color c = new Color(red, green, blue);
        return c;
    }
    
    /**
     * Creates a colour from generated aRGB Values
     * @param x integer value of x coordinate
     * @param y integer value of y coordinate
     * @return generated colour
     */
    public Color rgbGamma(int x, int y){
        randRed(x,y,Rmode);
        randGreen(x,y,Gmode);
        randBlue(x,y,Bmode);
        genGamma(x,y, Amode);
        Color c = new Color(red, green, blue, gamma);
        return c;
    }
    
    /**
     * updates the data system using the generated values
     */
    public void updateDS(){
        setMode();
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        int x,y;
        Color c;
        for(x=0;x< width;x++){
            for(y=0;y<height;y++){
                c = rgb(x,y);
                imageData.setColor(x, y, c);
            }
        }
    }
    
    
    /**
     * updates the data system using the generated values
     */
    public void updateDSGamma(){
        setMode();
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        int x,y;
        Color c;
        for(x=0;x< width;x++){
            for(y=0;y<height;y++){
                c = rgbGamma(x,y);
                imageData.setColor(x, y, c);
            }
        }
    }
    
    /**
     * returns the generated data system
     * @return generated image
     */
    public DataSystem returnData(){
        return imageData;
    }
}
