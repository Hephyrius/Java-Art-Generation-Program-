package Model;

/**
 * @author Harnick Khera - P13233249
 */

import java.awt.Color;

public class TilingSystem {

	//fields
	private DataSystem imageData;
	private int width;
	private int height;

	//constructor
	public TilingSystem(DataSystem Data){
		imageData = Data;
		width = imageData.getWidth();
		height = imageData.getHeight();
	}

	//class methods

	/**
         * grabs a section of the image and tiles it across the datassytem
         * @return the tiled image 
         */
	public DataSystem generateImage(){
		
		DataSystem out = new DataSystem(width,height);
		int x, y;
                int targetx = 20;
                int targety = 20;
                DataSystem tile = new DataSystem(targetx,targety);
                
                for(x = 0; x<targetx;x++){
                    for(y=0;y<targety;y++){
                        Color c = imageData.getColor(x+50, y+30);
                        tile.setColor(x, y, c);
                    }
                }
                
                int xiterator = 0;
                int yiterator = 0;
                
                for(x = 0; x<width;x++){
                    for(y=0;y<height;y++){
                        if(xiterator == tile.getWidth()){
                            xiterator = 0;   
                        }
                        
                        if(yiterator == tile.getHeight()){
                            yiterator = 0;   
                        }
                        Color c = tile.getColor(xiterator, yiterator);
                        out.setColor(x, y, c);
                        yiterator++;
                    }
                    xiterator++;
                }
		
		return out;
	}
        
        /**
         * * grabs a section of the image and tiles it across the datassytem
         * @param desiredWidth integer value of desired width
         * @param desiredHeight integer value of desired height
         * @param startx integer value of start x location
         * @param starty integer value of start y location
         * @return the tiled image
         */
        
        public DataSystem generateImage(int desiredWidth, int desiredHeight, int startx, int starty){
		
		DataSystem out = new DataSystem(width,height);
		int x, y;
                int targetx = desiredWidth;
                int targety = desiredHeight;
                DataSystem tile = new DataSystem(targetx,targety);
                
                for(x = 0; x<targetx;x++){
                    for(y=0;y<targety;y++){
                        Color c = imageData.getColor(x+startx, y+starty);
                        tile.setColor(x, y, c);
                    }
                }
                
                int xiterator = 0;
                int yiterator = 0;
                
                for(x = 0; x<width;x++){
                    for(y=0;y<height;y++){
                        if(xiterator == tile.getWidth()){
                            xiterator = 0;   
                        }
                        
                        if(yiterator == tile.getHeight()){
                            yiterator = 0;   
                        }
                        Color c = tile.getColor(xiterator, yiterator);
                        out.setColor(x, y, c);
                        yiterator++;
                    }
                    xiterator++;
                }
		
		return out;
	}
}






