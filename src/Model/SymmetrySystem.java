package Model;

/**
 * @author Harnick Khera - P13233249
 *
 */

import java.awt.Color;
import java.util.Random;

public class SymmetrySystem {
    //class fields
    private DataSystem imageData;
    private  int reflections;
    
    //constructor
    public SymmetrySystem(int r, DataSystem im){
        imageData = im;
        reflections = r;
    }
    
    /**
     * reflects vertically from left to right
     */
    public void verticalReflection(){
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        width = width-1;
        int x,y;
        Color c;
        
        
        for(y=0;y<height;y++){
            int iteration = 0;
            for(x=0;x<width;x++){
                c = imageData.getColor(x, y);
                imageData.setColor(width-iteration, y, c);
                iteration++;
            }
        }
        
    }
    
    /**
     * reflects vertically from right to left
     */
    public void verticalReflectionAlternative(){
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        width = width-1;
        int x,y;
        Color c;
        
        for(y=0;y<height;y++){
            int iteration = 0;
            for(x=imageData.getWidth()-1;x>(width/2);x--){
                c = imageData.getColor(x, y);
                imageData.setColor(iteration, y, c);
                iteration++;
            }
        }
    }
    /**
     * reflects left to centre
     */
    public void verticalReflectionHalf(){
        int height = imageData.getHeight();
        int width = imageData.getWidth()/2;
        width = width-1;
        int x,y;
        Color c;
        
        for(y=0;y<height;y++){
            int iteration = 0;
            for(x=0;x<width;x++){
                c = imageData.getColor(x, y);
                imageData.setColor(width-iteration, y, c);
                iteration++;
            }
        }
    }
    
    /**
     * reflects vertically centre to left
     */
    public void verticalReflectionHalfAlternative(){
        int height = imageData.getHeight();
        int width = imageData.getWidth()/2;
        width = width-1;
        int x,y;
        Color c;
        
        for(y=0;y<height;y++){
            int iteration = 0;
            for(x=width;x>width/2;x--){
                c = imageData.getColor(x, y);
                imageData.setColor(iteration, y, c);
                iteration++;
            }
        }
    }
    
    /**
     * reflects vertically from centre to right
     */
    public void verticalReflectionHalfOther(){
        int height = imageData.getHeight();
        int width = imageData.getWidth()/2;
        width = width-1;
        int x,y;
        Color c;
        
        for(y=0;y<height;y++){
            int iteration = 0;
            for(x=width/2;x<(width/4)*3;x++){
                c = imageData.getColor(x, y);
                imageData.setColor((width/4)*3+iteration, y, c);
                iteration++;
            }
        }
    }
    
    /**
     * reflects vertically from right to centre
     */
    public void verticalReflectionHalfOtherAlternative(){
        int height = imageData.getHeight();
        int width = imageData.getWidth()/2;
        width = width-1;
        int x,y;
        Color c;
        
        for(y=0;y<height;y++){
            int iteration = 0;
            for(x=width;x>(width/4)*3;x--){
                c = imageData.getColor(x, y);
                imageData.setColor((width/2)+iteration, y, c);
                iteration++;
            }
        }
    }
    
    /**
     * reflects horizontally from top to bottom
     */
    public void horizontalReflection(){
        
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        int x,y;
        Color c;
        int halfHeight = height/2;
        
        for(x=0;x<width;x++){
            height = imageData.getHeight();
            for(y=0;y<halfHeight;y++){
                c = imageData.getColor(x, y);
                imageData.setColor(x, (height-1), c);
                height--;
            }
        }
    }
    
    /**
     * reflects horizontally from bottom to top
     */
    public void horizontalReflectionAlternative(){
        
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        int x,y;
        Color c;
        int halfHeight = height/2;
        
        for(x=0;x<width;x++){
            int iteration = 0;
            
            for(y=imageData.getHeight()-1;y>halfHeight;y--){
                c = imageData.getColor(x, y);
                imageData.setColor(x, iteration, c);
                iteration++;
            }
        }
    }
    
    /**
     * reflects horizontally from top to centre
     */
    public void horizontalReflectionHalf(){
        
        int height = imageData.getHeight()/2;
        int width = imageData.getWidth();
        int x,y;
        Color c;
        int halfHeight = height/2;
        
        for(x=0;x<width;x++){
            height = imageData.getHeight()/2;
            for(y=0;y<halfHeight;y++){
                c = imageData.getColor(x, y);
                imageData.setColor(x, (height-1), c);
                height--;
            }
        }
    }
    
    /**
     * reflects horizontally from centre to top
     */
    public void horizontalReflectionHalfAlternative(){
        
        int height = imageData.getHeight()/2;
        int width = imageData.getWidth();
        int x,y;
        Color c;
        int halfHeight = height/2;
        
        for(x=0;x<width;x++){
            height = imageData.getHeight()/2;
            int iteration = 0;
            for(y=height;y>halfHeight/2;y--){
                c = imageData.getColor(x, y);
                imageData.setColor(x, iteration, c);
                iteration++;
            }
        }
    }
    
    /**
     * reflects horizontally from centre to bottom
     */
    public void horizontalReflectionHalfRight(){
        
        int height = imageData.getHeight()/2;
        int width = imageData.getWidth();
        int x,y;
        Color c;
        int halfHeight = height/2;
        
        for(x=0;x<width;x++){
            height = imageData.getHeight()/2;
            int iteration = 0;
            for(y=halfHeight;y<(height/4)*3;y++){
                c = imageData.getColor(x, y);
                imageData.setColor(x, height-iteration, c);
                iteration++;
            }
        }
    }
    
    /**
     * reflects horizontally from bottom to centre
     */
    public void horizontalReflectionHalfRightAlternative(){
        
        int height = imageData.getHeight()/2;
        int width = imageData.getWidth();
        int x,y;
        Color c;
        int halfHeight = height/2;
        
        for(x=0;x<width;x++){
            height = imageData.getHeight();
            int iteration = 0;
            for(y=height-1;y>(halfHeight/2)*3;y--){
                c = imageData.getColor(x, y);
                imageData.setColor(x, halfHeight+iteration, c);
                iteration++;
            }
        }
    }
    
    /**
     * first attempt at diagonal reflection
     */
    public void diagReflection(){
        
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        Color c;
        double  gradient;
        int ycord, xcord, translation;
        gradient = (double)width/(double)height;
        translation = 0;
        int x=0;
        int y =0;
        
        for(x = 0; x<width; x++){
            xcord = xcoordFinder(y, gradient, translation);
            for(y = 0; y<height; y++){
                ycord = ycoordFinder(x, gradient, translation);
                if(y<ycord & x<xcord){
                    c = imageData.getColor(x,y);
                    imageData.setColor(height-y-1, width-x-1, c);
                }
                
            }
        }
        System.out.println("diagonal");
        
    }
    
    
    /**
     * finds the y coordinate in a line of symmetry
     * @param x int value of x coordinate
     * @param m double value of gradient
     * @param c int value of translation
     * @return  int value of y coordinate
     */
    
    public int ycoordFinder(int x, double m, int c){
        int y = ((int)m*x)+c;
        return y;
    }
    
    /**
     * finds the x coordinate in a line of symmetry
     * @param y int value of y coordinate
     * @param m double value of gradient
     * @param c int value of translation
     * @return  int value of coordinate
     */
    public int xcoordFinder(int y, double m, int c){
        double x = (y-c)/m;
        return (int) x;
    }
    
    /**
     * second attempt at diagonal reflection
     */
    public void diagReflectionAlternative(){
        
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        Color c;
        double  gradient;
        int ycord, xcord, translation;
        gradient = (double)height/(double)width;
        translation = width;
        int x=0;
        int y =0;
        
        for(x = 0; x<width; x++){
            xcord = xcoordFinder(y, gradient, translation);
            for(y = 0; y<height; y++){
                ycord = ycoordFinder(x, gradient, translation);
                if(y<ycord & x<xcord){
                    c = imageData.getColor(width-x,height-y);
                    imageData.setColor(y, x, c);
                }
                
            }
        }
        System.out.println("alt diagonal");
        
    }
    
    /**
     * rotates canvas 90 degrees
     */
    public void rotate90(){
        
        int width = imageData.getWidth();
        int height = imageData.getHeight();
        int x,y;
        Color c;
        DataSystem temp = new DataSystem(height, width);
        for(x=1; x<width; x++){
            for(y=1; y<height; y++ ){
                
                c = imageData.getColor(x, y);
                temp.setColor(y, x, c);
                
            }
        }
        imageData = temp;
    }
    
    /**
     * rotates canvas 180 degrees
     */
    public void rotate180(){
        
        int width = imageData.getWidth();
        int height = imageData.getHeight();
        int x,y;
        Color c;
        DataSystem temp = new DataSystem(width, height);
        for(x=1; x<width; x++){
            for(y=1; y<height; y++ ){
                
                c = imageData.getColor(x, y);
                temp.setColor(width-x, height-y, c);
                
            }
        }
        imageData = temp;
    }
    
    /**
     * rotates canvas 270 degrees
     */
    public void rotate270(){
        rotate180();
        rotate90();
    }
    
    /**
     * updates the data system by checking the mode and then applying the correct function
     */
    public void update(){
        if(reflections == 0){
            horizontalReflection();
        }
        else if(reflections == 1){
            horizontalReflectionAlternative();
        }
        else if(reflections == 2){
            verticalReflection();
        }
        else if(reflections == 3){
            verticalReflectionAlternative();
        }
        else if(reflections == 4){
            verticalReflectionHalf();
        }
        else if(reflections == 5){
            verticalReflectionHalfAlternative();
        }
        else if(reflections == 6){
            verticalReflectionHalfOther();
        }
        else if(reflections == 7){
            verticalReflectionHalfOtherAlternative();
        }
        else if(reflections == 8){
            horizontalReflectionHalf();
        }
        else if(reflections == 9){
            horizontalReflectionHalfAlternative();
        }
        else if(reflections == 10){
            horizontalReflectionHalfRight();
        }
        else if(reflections == 11){
            horizontalReflectionHalfRightAlternative();
        }
        else if(reflections == 12){
            
            diagReflectionAlternative();
        }
        else if(reflections == 13){
            diagReflection();
        }
        else if(reflections ==14){
            rotate90();
        }
        else if(reflections ==15){
            rotate180();
        }
        else if (reflections ==16){
            rotate270();
        }
        else if (reflections ==17){
            randomizeWidth();
        }
        else if (reflections ==18){
            randomizeHeight();
        }
        else if (reflections ==19){
            randomizeHeight();
            randomizeWidth();
        }
    }
    
    /**
     * returns the modified data system
     * @return generated data system
     */
    public DataSystem returnData(){
        return imageData;
    }
    
    /**
     * randomizes the pixel data across the width of the image
     */
    public void randomizeWidth(){
        int iteration = 0;
        int width = imageData.getWidth();
        int height = imageData.getHeight();
        int x,y;
        Color c;
        DataSystem temp = new DataSystem(width, height);
        Random r = new Random();
        
        for(x=0; x<width; x++){
            int xi = r.nextInt(width);
            for(y=0;y<height;y++){
                c = imageData.getColor(xi, y);
                temp.setColor(x, y, c);
            }
            
        }
        imageData = temp;
        
    }
    
    /**
     * randomized pixel data across the height of the image
     */
    
    public void randomizeHeight(){
        int iteration = 0;
        int width = imageData.getWidth();
        int height = imageData.getHeight();
        int x,y;
        Color c;
        DataSystem temp = new DataSystem(width, height);
        Random r = new Random();
        
        for(y=0;y<height;y++){
            int yi = r.nextInt(height);
            for(x=0; x<width; x++){
                c = imageData.getColor(x, yi);
                temp.setColor(x, y, c);
            }
            
        }
        imageData = temp;
        
    }
    
}
