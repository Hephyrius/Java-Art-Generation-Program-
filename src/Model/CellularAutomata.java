package Model;

/**
 * @author Harnick Khera - P13233249
 *
 */

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class CellularAutomata {

	//class functions
	private boolean [][] caGrid;
	private int height;
	private int width;
	private DataSystem imageData;
	private ArrayList<int[]> ruleset;

	//Constructor
	public CellularAutomata(int x, int y, DataSystem in){
		width = x;
		height = y;
		caGrid = new boolean[x][y];
		imageData = in;
	}

	/**
         * get the height of the CA
         * @return integer value of height
         */
	public int getHeight() {
		return height;
	}
        
        /**
         * sets the height of the ca 
         * @param height integer value of height
         */
	public void setHeight(int height) {
		this.height = height;
	}
        
        /**
         * get the width of the CA
         * @return integer value of width
         */
	public int getWidth() {
		return width;
	}
        /**
         * sets the width of the ca 
         * @param width integer value of width
         */
	public void setWidth(int width) {
		this.width = width;
	}

	//wolfram related methods;

	/**
         * get the value of grid member
         * @param x integer x coordinate 
         * @param y integer y coordinate
         * @return value of grid value
         */
	public boolean getGridValue(int x, int y){
		return caGrid[x][y];
	}

	/**
         * @param x integer x coordinate 
         * @param y integer y coordinate
         * @param b boolean value of truth value
         */
	public void setGridValue(int x, int y, boolean b){
		caGrid[x][y] = b;
	}

	/**
         * generates a random set of rules
         * @return array of rules
         */
	public boolean[] RandomizedRules(){
		boolean[] rules = new boolean[8];
		Random r = new Random();
		rules[0] = r.nextBoolean();
		rules[1] = r.nextBoolean();
		rules[2] = r.nextBoolean();
		rules[3] = r.nextBoolean();
		rules[4] = r.nextBoolean();
		rules[5] = r.nextBoolean();
		rules[6] = r.nextBoolean();
		rules[7] = r.nextBoolean();
		return rules;
	}

	/**
         * populates the list of rules used by the system
         */
	public void wolframRulesCreation(){

		ruleset = new ArrayList<int[]>();

		int x = 256;
		int w = 0;
		while(w<x){
			String rule = Integer.toBinaryString(w);

			if(rule.length()!= 8){
				int s1 = 0;
				int s2 = 8 - rule.length();
				String additions = "";

				while(s1!=s2){
					additions = additions+"0";
					s2--;
				}
				rule = additions+rule;
			}
			int i0 = (int) rule.charAt(0);
			if(i0 == 48){
				i0 = 0;
			}
			else if(i0 == 49){
				i0 = 1;
			}

			int i1 = (int) rule.charAt(1);
			if(i1 == 48){
				i1 = 0;
			}
			else if(i1 == 49){
				i1 = 1;
			}

			int i2 = (int) rule.charAt(2);
			if(i2 == 48){
				i2 = 0;
			}
			else if(i2 == 49){
				i2 = 1;
			}

			int i3 = (int) rule.charAt(3);
			if(i3 == 48){
				i3 = 0;
			}
			else if(i3 == 49){
				i3 = 1;
			}

			int i4 = (int) rule.charAt(4);
			if(i4 == 48){
				i4 = 0;
			}
			else if(i4 == 49){
				i4 = 1;
			}

			int i5 = (int) rule.charAt(5);
			if(i5 == 48){
				i5 = 0;
			}
			else if(i5 == 49){
				i5 = 1;
			}

			int i6 = (int) rule.charAt(6);
			if(i6 == 48){
				i6 = 0;
			}
			else if(i6 == 49){
				i6 = 1;
			}

			int i7 = (int) rule.charAt(7);if(i0 == 48){
				i7 = 0;
			}
			else if(i0 == 49){
				i7 = 1;
			}

			ruleset.add(new int[] {i0, i1, i2, i3, i4, i5, i6, i7});


			w++;
		}

	}

	/**
         * method creates arraylist of rules, grabs the ruleset as a parametre, 
         * converts intoo bool array and then executes tge simulation
         * @param i rule number
         */
	public void WolframRules(int i){

		wolframRulesCreation();

		int[] r = ruleset.get(i);

		boolean[] rules = new boolean[8];

		if(r[0]==0){
			rules[0]=false;
		}
		else if(r[0]==1){
			rules[0]=true;
		}

		if(r[1]==0){
			rules[1]=false;
		}
		else if(r[1]==1){
			rules[1]=true;
		}

		if(r[2]==0){
			rules[2]=false;
		}
		else if(r[2]==1){
			rules[2]=true;
		}

		if(r[3]==0){
			rules[3]=false;
		}
		else if(r[3]==1){
			rules[3]=true;
		}

		if(r[4]==0){
			rules[4]=false;
		}
		else if(r[4]==1){
			rules[4]=true;
		}

		if(r[5]==0){
			rules[5]=false;
		}
		else if(r[5]==1){
			rules[5]=true;
		}

		if(r[6]==0){
			rules[6]=false;
		}
		else if(r[6]==1){
			rules[6]=true;
		}

		if(r[7]==0){
			rules[7]=false;
		}
		else if(r[7]==1){
			rules[7]=true;
		}

		boolean[][] output = new boolean[width][height];
		setGridValue((width/8),1,true);
		setGridValue((width/8)*6,1,true);

		for(int y=1;y<height-1;y++){
			for(int x=1;x<width-1;x++){

				if(getGridValue(x-1,y) == true & getGridValue(x,y) == true & getGridValue(x+1,y) == true){
					output[x][y+1] = rules[0];
				}
				else if(getGridValue(x-1,y) == true & getGridValue(x,y) == true & getGridValue(x+1,y) == false){
					output[x][y+1] = rules[1];
				}
				else if(getGridValue(x-1,y) == true & getGridValue(x,y) == false & getGridValue(x+1,y) == true){
					output[x][y+1] = rules[2];
				}
				else if(getGridValue(x-1,y) == true & getGridValue(x,y) == false & getGridValue(x+1,y) == false){
					output[x][y+1] = rules[3];
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == true & getGridValue(x+1,y) == true){
					output[x][y+1] = rules[4];
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == true & getGridValue(x+1,y) == false){
					output[x][y+1] = rules[5];
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == false & getGridValue(x+1,y) == true){
					output[x][y+1] = rules[6];
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == false & getGridValue(x+1,y) == false){
					output[x][y+1] = rules[7];
				}
			}
			caGrid = output;
		}
	}
        
        /**
         * method creates arraylist of rules, grabs the ruleset as a parametre, 
         * converts intoo bool array and then executes
         * @param i rule number
         * @param b number of start points
         */
	public void WolframRules(int i, int b){

		wolframRulesCreation();

		int[] r = ruleset.get(i);

		boolean[] rules = new boolean[8];

		if(r[0]==0){
			rules[0]=false;
		}
		else if(r[0]==1){
			rules[0]=true;
		}

		if(r[1]==0){
			rules[1]=false;
		}
		else if(r[1]==1){
			rules[1]=true;
		}

		if(r[2]==0){
			rules[2]=false;
		}
		else if(r[2]==1){
			rules[2]=true;
		}

		if(r[3]==0){
			rules[3]=false;
		}
		else if(r[3]==1){
			rules[3]=true;
		}

		if(r[4]==0){
			rules[4]=false;
		}
		else if(r[4]==1){
			rules[4]=true;
		}

		if(r[5]==0){
			rules[5]=false;
		}
		else if(r[5]==1){
			rules[5]=true;
		}

		if(r[6]==0){
			rules[6]=false;
		}
		else if(r[6]==1){
			rules[6]=true;
		}

		if(r[7]==0){
			rules[7]=false;
		}
		else if(r[7]==1){
			rules[7]=true;
		}

		boolean[][] output = new boolean[width][height];
                
                for(int z = 0; z<b; z++){
		setGridValue((width/b)*z,1,true);
                }
                
		for(int y=1;y<height-1;y++){
			for(int x=1;x<width-1;x++){

				if(getGridValue(x-1,y) == true & getGridValue(x,y) == true & getGridValue(x+1,y) == true){
					output[x][y+1] = rules[0];
				}
				else if(getGridValue(x-1,y) == true & getGridValue(x,y) == true & getGridValue(x+1,y) == false){
					output[x][y+1] = rules[1];
				}
				else if(getGridValue(x-1,y) == true & getGridValue(x,y) == false & getGridValue(x+1,y) == true){
					output[x][y+1] = rules[2];
				}
				else if(getGridValue(x-1,y) == true & getGridValue(x,y) == false & getGridValue(x+1,y) == false){
					output[x][y+1] = rules[3];
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == true & getGridValue(x+1,y) == true){
					output[x][y+1] = rules[4];
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == true & getGridValue(x+1,y) == false){
					output[x][y+1] = rules[5];
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == false & getGridValue(x+1,y) == true){
					output[x][y+1] = rules[6];
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == false & getGridValue(x+1,y) == false){
					output[x][y+1] = rules[7];
				}
			}
			caGrid = output;
		}
	}
        
        
        /**    
         * converts randomized int to bool array and then executes
         */
	public void WolframRand(){
		boolean[] rules = RandomizedRules();
		boolean[][] output = new boolean[width][height];
		setGridValue((width/8),1,true);
		setGridValue((width/8)*6,1,true);

		for(int y=1;y<height-1;y++){
			for(int x=1;x<width-1;x++){

				if(getGridValue(x-1,y) == true & getGridValue(x,y) == true & getGridValue(x+1,y) == true){
					output[x][y+1] = rules[0];
				}
				else if(getGridValue(x-1,y) == true & getGridValue(x,y) == true & getGridValue(x+1,y) == false){
					output[x][y+1] = rules[1];
				}
				else if(getGridValue(x-1,y) == true & getGridValue(x,y) == false & getGridValue(x+1,y) == true){
					output[x][y+1] = rules[2];
				}
				else if(getGridValue(x-1,y) == true & getGridValue(x,y) == false & getGridValue(x+1,y) == false){
					output[x][y+1] = rules[3];
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == true & getGridValue(x+1,y) == true){
					output[x][y+1] = rules[4];
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == true & getGridValue(x+1,y) == false){
					output[x][y+1] = rules[5];
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == false & getGridValue(x+1,y) == true){
					output[x][y+1] = rules[6];
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == false & getGridValue(x+1,y) == false){
					output[x][y+1] = rules[7];
				}
			}
			caGrid = output;
		}
	}

        
        
        
	/**
         * test function that uses rule 30 used during testing
         */
	public void Wolfram(){

		boolean[][] output = new boolean[width][height];
		setGridValue((width/8),1,true);
		setGridValue((width/8)*6,1,true);

		for(int y=1;y<height-1;y++){
			for(int x=1;x<width-1;x++){

				if(getGridValue(x-1,y) == true & getGridValue(x,y) == true & getGridValue(x+1,y) == true){
					output[x][y+1] = true;
				}
				else if(getGridValue(x-1,y) == true & getGridValue(x,y) == true & getGridValue(x+1,y) == false){
					output[x][y+1] = false;
				}
				else if(getGridValue(x-1,y) == true & getGridValue(x,y) == false & getGridValue(x+1,y) == true){
					output[x][y+1] = true;
				}
				else if(getGridValue(x-1,y) == true & getGridValue(x,y) == false & getGridValue(x+1,y) == false){
					output[x][y+1] = true;
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == true & getGridValue(x+1,y) == true){
					output[x][y+1] = false;
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == true & getGridValue(x+1,y) == false){
					output[x][y+1] = false;
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == false & getGridValue(x+1,y) == true){
					output[x][y+1] = true;
				}
				else if(getGridValue(x-1,y) == false & getGridValue(x,y) == false & getGridValue(x+1,y) == false){
					output[x][y+1] = false;
				}
			}
			caGrid = output;
		}
	}

	/**
         * selects colour and then updates the data system based on the truth values
         */
	public void paintCA(){
		Color t  = new Color(0,0,0);
		//Color f = new Color(0,0,0);

		for(int x=0;x<width;x++){
			for(int y=0;y<height;y++){
				if(getGridValue(x,y)== true){
					imageData.setColor(x, y, t);
				}
				else if(getGridValue(x,y)== false){
					//imageData.setColor(x, y, t);
				}
			}
		}
	}

	/**
         * executes rule30 wolfram algorithm
         */
	public void executeWolfram(){
		Wolfram();
		paintCA();
	}

        /**
         * executes wolfram algorithm with user defined rule
         * @param i int value of rule
         */
	public void executeWolframRules(int i){
		WolframRules(i);
		paintCA();
	}
        
 
        /**
         * executes wolfram algorithm with user defined rule
         * @param i int value of rule
         * @param b integer value of start points
         */
        public void executeWolframRules(int i, int b){
		WolframRules(i, b);
		paintCA();
	}
        
         /**
         * executes wolfram algorithm with user defined rule
         * @param i int value of rule
         * @param b boolean value which randomizes the start grid
         */
        public void executeWolframRules(int i, boolean b){
            if(b == true){
                randomizeGrid();
            }
		WolframRules(i);
		paintCA();
	}

	/**
         * executrs the random wolfram algorithm
         */
	public void executeWolframRand(){
		WolframRand();
		paintCA();
	}

	/**
         * returns the generated datasystem
         * @return generated data
         */
	public DataSystem getOutput(){
		return imageData;
	}


	//2d CA methods
        
        /**
         * 
         * @param x integer value of x coord
         * @param y integer value of y coord
         * @return  rule set
         */
	public boolean[] localValues(int x, int y){
		boolean[] localArea = new boolean[9];

		localArea[0] = this.getGridValue(x+1, y+1);
		localArea[1] = this.getGridValue(x+1, y);
		localArea[2] = this.getGridValue(x+1, y-1);
		localArea[3] = this.getGridValue(x-1, y+1);
		localArea[4] = this.getGridValue(x-1, y);
		localArea[5]= this.getGridValue(x-1, y-1);
		localArea[6] = this.getGridValue(x, y+1);
		localArea[7] = this.getGridValue(x, y);
		localArea[8] = this.getGridValue(x, y-1);

		return localArea;
	}

	/**
         * 
         * @param x coordinate of x value
         * @param y coordinate of y value
         * @return the inerger value of truths
         */
	public int localTrueValues(int x, int y){
		int t =0;

		if(getGridValue(x+1, y+1) == true){
			t++;
		}
		if(getGridValue(x+1, y+0) == true){
			t++;
		}
		if(getGridValue(x+1, y-1) == true){
			t++;
		}
		if(getGridValue(x, y+1) == true){
			t++;
		}
		if(getGridValue(x, y) == true){
			t++;
		}
		if(getGridValue(x, y-1) == true){
			t++;
		}
		if(getGridValue(x-1, y+1) == true){
			t++;
		}
		if(getGridValue(x-1, y) == true){
			t++;
		}
		if(getGridValue(x-1, y-1) == true){
			t++;
		}
		return t;
	}

        /**
         * 
         * @param x coordinate of x value
         * @param y coordinate of y value
         * @return the inerger value of truths
         */
	public int localTrueOtherValues(int x, int y){
		int t =0;

		if(getGridValue(x, y) == true){
			t++;
		}
		if(getGridValue(x+1, y) == true){
			t++;
		}
		if(getGridValue(x-1, y) == true){
			t++;
		}
		if(getGridValue(x, y+1) == true){
			t++;
		}
		if(getGridValue(x, y-1) == true){
			t++;
		}
		return t;
	}

	/**
         * randomizes the thruth grid
         */
	public void randomizeGrid(){

		Random r = new Random();

		for(int x=1;x<width-2;x++){
			for(int y=1;y<height-2;y++){
				setGridValue(x,y,r.nextBoolean());
			}
		}
	}

	/**
         * a simple 2d rule set execution
         */
	public void twoDimensionalCASmallarea(){
		boolean[][] output = new boolean[width][height];
		for(int x=1;x<width-2;x++){
			for(int y=1;y<height-2;y++){
				//int t = getTrueNeighbours(x,y);
				int t =localTrueOtherValues(x,y);
				if(t==0){
					output[x][y]=false;
				}
				else if(t==1){
					output[x][y]=true;
				}
				else if(t==2){
					output[x][y]=false;
				}
				else if(t==3){
					output[x][y]=true;
				}
				else if(t==4){
					output[x][y]=true;
				}
				else if(t==5){
					output[x][y]=true;
				}

			}
		}
		this.caGrid = output;
	}

	/**
         * a simple 2d rule set using the 3 by 3 area
         */
	public void twoDimensionalCA(){
		boolean[][] output = new boolean[width][height];
		for(int x=1;x<width-2;x++){
			for(int y=1;y<height-2;y++){
				//int t = getTrueNeighbours(x,y);
				int t =localTrueValues(x,y);
				if(t==0){
					output[x][y]=false;
				}
				else if(t==1){
					output[x][y]=false;
				}
				else if(t==2){
					output[x][y]=true;
				}
				else if(t==3){
					output[x][y]=true;
				}
				else if(t==4){
					output[x][y]=true;
				}
				else if(t==5){
					output[x][y]=false;
				}
				else if(t==6){
					output[x][y]=false;
				}
				else if(t==7){
					output[x][y]=false;
				}
				else if(t==8){
					output[x][y]=false;
				}
				else if(t==9){
					output[x][y]=false;
				}

			}
		}
		this.caGrid = output;
	}

	/**
         * iterates the ceellular automata this many times
         * @param x integer value of iterations
         */
	public void multiTwoDimension(int x){
		int w, o;
		w = 0;
		o = x;
		while(w!=o){
			twoDimensionalCA();
			w++;
		}
	}

	/**
         * executes simulation and paints canvas
         * @param x int value of iterations
         */
	public void execute2D(int x){
		randomizeGrid();
		multiTwoDimension(x);
		paintCA();
	}



	//methods for a 5x5 grid

	
        /**
         * 5 by 5 area scan
         * @param x x coord of centre cell
         * @param y y coord of centre cell
         * @return integer value of number of true cells in area
         */
	public boolean[] localValues5x5(int x, int y){
		boolean[] localArea = new boolean[9];

		localArea[0] = this.getGridValue(x+2, y+2);
		localArea[1] = this.getGridValue(x+2, y+1);
		localArea[2] = this.getGridValue(x+2, y);
		localArea[3] = this.getGridValue(x+2, y-1);
		localArea[4] = this.getGridValue(x+2, y-2);

		localArea[0] = this.getGridValue(x+1, y+2);
		localArea[1] = this.getGridValue(x+1, y+1);
		localArea[2] = this.getGridValue(x+1, y);
		localArea[3] = this.getGridValue(x+1, y-1);
		localArea[4] = this.getGridValue(x+1, y-2);

		localArea[0] = this.getGridValue(x, y+2);
		localArea[1] = this.getGridValue(x, y+1);
		localArea[2] = this.getGridValue(x, y);
		localArea[3] = this.getGridValue(x, y-1);
		localArea[4] = this.getGridValue(x, y-2);

		localArea[0] = this.getGridValue(x-1, y+2);
		localArea[1] = this.getGridValue(x-1, y+1);
		localArea[2] = this.getGridValue(x-1, y);
		localArea[3] = this.getGridValue(x-1, y-1);
		localArea[4] = this.getGridValue(x-1, y-2);

		localArea[0] = this.getGridValue(x-2, y+2);
		localArea[1] = this.getGridValue(x-2, y+1);
		localArea[2] = this.getGridValue(x-2, y);
		localArea[3] = this.getGridValue(x-2, y-1);
		localArea[4] = this.getGridValue(x-2, y-2);

		return localArea;
	}

        /**
         * 
         * a simple 2d rule set and execution using the 5 by 5 area
         */
	public void twoDimensionalCA5x5(){
		boolean[][] output = new boolean[width][height];
		for(int x=2;x<width-3;x++){
			for(int y=2;y<height-3;y++){

				int t = 0;
				boolean [] area= localValues5x5(x, y);

				for( boolean b : area){
					if(b==true){
						t++;
					}
				}

				if(t==0){
					output[x][y] =false;
				}
				else if(t==1){
					output[x][y] =false;
				}
				else if(t==2){
					output[x][y] =true;
				}
				else if(t==3){
					output[x][y] =true;
				}
				else if(t==4){
					output[x][y] =false;
				}
				else if(t==5){
					output[x][y] =false;
				}
				else if(t==6){
					output[x][y] =true;
				}
				else if(t==7){
					output[x][y] =true;
				}
				else if(t==8){
					output[x][y] =false;
				}
				else if(t==9){
					output[x][y] =false;
				}
				else if(t==10){
					output[x][y] =true;
				}
				else if(t==11){
					output[x][y] =true;
				}
				else if(t==12){
					output[x][y] =false;
				}
				else if(t==13){
					output[x][y] =false;
				}
				else if(t==14){
					output[x][y] =true;
				}
				else if(t==15){
					output[x][y] =true;
				}
				else if(t==16){
					output[x][y] =false;
				}
				else if(t==17){
					output[x][y] =false;
				}
				else if(t==18){
					output[x][y] =true;
				}
				else if(t==19){
					output[x][y] =true;
				}
				else if(t==20){
					output[x][y] =false;
				}
				else if(t==21){
					output[x][y] =false;
				}
				else if(t==22){
					output[x][y] =true;
				}
				else if(t==23){
					output[x][y] =true;
				}
				else if(t==24){
					output[x][y] =false;
				}
				else if(t==25){
					output[x][y] =false;
				}
			}
		}
		this.caGrid = output;
	}

	/**
         * execute ca from 5x5 grid and paint the data system
         * @param count the integer number of iterations
         */
	public void execute5x5(int count){
		randomizeGrid();
		for(int x=0; x!= count; x++){
			twoDimensionalCA5x5();
		}
		paintCA();
	}
	
	//alternative CA
	
        /**
         * 
         * a simple experimental ca
         */
	public void experimentalCA1(){
		boolean[][] output = new boolean[width][height];
		setGridValue((width/8),1,true);
		setGridValue((width/8)+1,1,true);
		setGridValue((width/8)-1,1,true);
		setGridValue((width/8)*6,1,true);

		for(int y=1;y<height-1;y++){
			for(int x=1;x<width-1;x++){

				if(getGridValue(x-1,y)& getGridValue(x+1,y)){
					output[x][y+1] = true;
				}
				else{
					output[x][y+1] = false;
				}
				
			}
			caGrid = output;
		}
	}
	
        /**
         * executes the first experiment
         */
	public void executeExperiment1(){
		randomizeGrid();
		experimentalCA1();
		paintCA();
	}
	
         /**
         * 
         * a simple experimental ca
         */
	public void experimentalCA2(){
		boolean[][] output = new boolean[width][height];
		setGridValue((width/8),1,true);
		setGridValue((width/8)+1,1,true);
		setGridValue((width/8)-1,1,true);
		setGridValue((width/8)*6,1,true);

		for(int y=1;y<height-1;y++){
			for(int x=1;x<width-1;x++){

				if(getGridValue(x-1,y)& getGridValue(x+1,y)){
					output[x][y] = true;
					output[x][y+1] = true;
				}
				else{
					output[x][y] = false;
					output[x][y+1] = false;
				}
				
			}
			caGrid = output;
		}
	}
	
        /**
         * executes the second experiment
         */
	public void executeExperiment2(){
		randomizeGrid();
		experimentalCA2();
		paintCA();
	}
}

















