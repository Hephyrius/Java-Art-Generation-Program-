package Model;

/**
 * @author Harnick Khera - P13233249
 *
 */

import java.awt.Color;

public class DataSystem {
    
    // class fields
    
    private Color[][] imageData;
    private int height;
    private int width;
    
    // default constructor
    public DataSystem(){
        height = 500;
        width = 500;
        imageData = new Color[width][height];
    }
    
    //constructor with
    public DataSystem(int x, int y){
        imageData= new Color[x][y];
        height = y;
        width = x;
    }
    
    
    //class methods
    
    /**
     * This method sets the the colour of a pixel
     * @param x the x coordinate of a pixel
     * @param y the y coordinate of a pixel
     * @param c the colour value of a pixel
     */
    public void setColor(int x, int y, Color c){
        imageData[x][y] = c;
    }
    
    /**
     * returns the colour of a pixel
     * @param x the x coordinate of a pixel
     * @param y the y coordinate of a pixel
     * @return the colour of the pixel
     */
    
    public Color getColor(int x, int y){
        return imageData[x][y];
    }
    
    /**
     * Sets the colour of a canvas to a solid colour
     * @param c the colour that will be applied to the canvas
     */
    public void setSolidColor(Color c){
        int x,y;
        for(x=0;x<=(width-1);x++){
            for(y=0;y<=(height-1);y++){
                setColor(x,y,c);
            }
        }
    }
    
    /**
     * returns the height of the imagedata
     * @return integer value of the height field
     */
    public int getHeight(){
        return this.height;
    }
    
    /**
     * returns width of the imagedata
     * @return integer value of the width field
     */
    public int getWidth(){
        return this.width;
    }
    
    /**
     * merges two data systems and returns the outcome
     * @param d1 data system that will be used in merging
     * @param d2 data system that will be used in merging
     * @return the result of the merge
     */
    public DataSystem mergeSystems(DataSystem d1, DataSystem d2){
        int x,y;
        
        DataSystem o = new DataSystem(d1.getWidth(),d1.getHeight());
        
        for(x=0;x<=(width-1);x++){
            for(y=0;y<=(height-1);y++){
                Color c1 = d1.getColor(x, y);
                Color c2 = d2.getColor(x, y);
                int r = (c1.getRed() + c2.getRed())/2;
                int g = (c1.getGreen() + c2.getGreen())/2;
                int b = (c1.getBlue() + c2.getBlue())/2;
                Color c3 = new Color(r,g,b);
                o.setColor(x,y,c3);
            }
        }
        return o;
    }
    
    
    /**
     *
     * merges two data systems and returns the outcome
     * @param d1 data system that will be used in merging
     * @param d2 data system that will be used in merging
     * @param d3
     * @return the result of the merge
     */
    public DataSystem mergeTripleSystems(DataSystem d1, DataSystem d2, DataSystem d3){
        int x,y;
        
        DataSystem o = new DataSystem(d1.getWidth(),d1.getHeight());
        
        for(x=0;x<=(width-1);x++){
            for(y=0;y<=(height-1);y++){
                Color c1 = d1.getColor(x, y);
                Color c2 = d2.getColor(x, y);
                Color c3 = d3.getColor(x, y);
                int r = (c1.getRed() + c2.getRed
                                                        ()+ c3.getRed())/3;
                int g = (c1.getGreen() + c2.getGreen()+ c3.getGreen())/3;
                int b = (c1.getBlue() + c2.getBlue()+ c3.getBlue())/3;
                
                Color c4 = new Color(r,g,b);
                o.setColor(x,y,c4);
            }
        }
        return o;
    }
    
    /**
     * clones a data system currently in memory
     * @param original the datasystem that will be duplicated
     * @return cloned system
     */
    public DataSystem copySystem(DataSystem original){
        int x,y;
        
        DataSystem newDS = new DataSystem(original.getWidth(),original.getHeight());
        
        for(x=0;x<=(width-1);x++){
            for(y=0;y<=(height-1);y++){
                Color c = original.getColor(x, y);
                newDS.setColor(x,y,c);
            }
        }
        return newDS;
    }
    
    /**
     * avaraging function that avarages a collection of numbers
     * @return avaraged colour
     */
    public int avarage(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9){
        int av = i1 + i2 + i3 + i4+ i5+ i6+ i7+ i8+ i9;
        av = av/9;
        return av;
    }
    
    /**
     * //smooth function that avarages out colours across a data system
     */
    public void smooth(){
        int x,y;
        
        for(x=1;x<=(width-2);x++){
            for(y=1;y<=(height-2);y++){
                
                Color c1 = this.getColor(x+1, y+1);
                Color c2 = this.getColor(x+1, y);
                Color c3 = this.getColor(x+1, y-1);
                Color c4 = this.getColor(x-1, y+1);
                Color c5 = this.getColor(x-1, y);
                Color c6 = this.getColor(x-1, y-1);
                Color c7 = this.getColor(x, y+1);
                Color c8 = this.getColor(x, y);
                Color c9 = this.getColor(x, y-1);
                
                int r = avarage(c1.getRed(),c2.getRed(),c3.getRed(),c4.getRed(),c5.getRed(),
                        c6.getRed(),c7.getRed(),c8.getRed(),c9.getRed());
                int g = avarage(c1.getGreen(),c2.getGreen(),c3.getGreen(),c4.getGreen(),c5.getGreen(),
                        c6.getGreen(),c7.getGreen(),c8.getGreen(),c9.getGreen());
                int b = avarage(c1.getBlue(),c2.getBlue(),c3.getBlue(),c4.getBlue(),c5.getBlue(),
                        c6.getBlue(),c7.getBlue(),c8.getBlue(),c9.getBlue());
                
                Color o = new Color(r,g,b);
                this.setColor(x,y,o);
            }
        }
    }
    
    /**
     * execute the smooth function  multiple times
     * @param y the number of iterations that will occur
     */
    public void multiSmooth(int y){
        int x = 0;
        while(x != y){
            smooth();
            x++;
        }
    }
    
    /**
     * avarages a row the colour of a row
     * @param y row coordinate
     */
    public void smoothRow(int y){
        int avgR = 0;
        int avgG = 0;
        int avgB = 0;
        Color[] c = imageData[y];
        for(Color c1: c){
            avgR = avgR + c1.getRed();
            avgG = avgG +c1.getGreen();
            avgB = avgB + c1.getBlue();
        }
        
        
        Color avg = new Color((avgR/width), (avgG/(width)), (avgB/(width)));
        
        for(int x=0;x<width;x++){
            setColor(x, y, avg);
        }
        
    }
    
    /**
     * //smooths each row
     */
    public void smoothEachRow(){
        for(int y=0;y<height;y++){
            smoothRow(y);
        }
    }
    
    /**
     * avarages a the colours of a column
     * @param x column coordinate
     */
    public void smoothColumn(int x){
        int avgR = 0;
        int avgG = 0;
        int avgB = 0;
        Color[] c = imageData[x];
        for(Color c1: c){
            avgR = avgR + c1.getRed();
            avgG = avgG +c1.getGreen();
            avgB = avgB + c1.getBlue();
        }
        
        
        Color avg = new Color((avgR/width), (avgG/(width)), (avgB/(width)));
        
        for(int y=0;y<height;y++){
            setColor(x, y, avg);
        }
        
    }
    
    /**
     * smooth each column of the data system
     */
    public void smoothEachColumn(){
        for(int x=0;x<width;x++){
            smoothColumn(x);
        }
    }
    
   /**
    * invert the colours used across the entire system
    */
    public void invert(){
        int x,y;
        for(x=0;x<=(width-1);x++){
            for(y=0;y<=(height-1);y++){
                Color c1 = this.getColor(x, y);
                Color c2 = new Color(255-c1.getRed(), 255-c1.getGreen(), 255-c1.getBlue());
                this.setColor(x, y, c2);
            }
        }
        
    }
    
    /**
     * Updates the sizes of the data system
     * @param w integer width value
     * @param h integer height value
     */
    public void updateSize(int w, int h){
        width = w;
        height = h;
        imageData = new Color[width][height];
    }
}
