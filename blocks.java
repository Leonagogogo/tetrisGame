//package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class blocks {
	
	
	public static int[][][][] shape = new int[][][][]{  
        // S
        { { {0,1,0,0}, {1,1,0,0}, {1,0,0,0}, {0,0,0,0} },   
        { {0,0,0,0}, {1,1,0,0}, {0,1,1,0}, {0,0,0,0} },   
        { {0,1,0,0}, {1,1,0,0}, {1,0,0,0}, {0,0,0,0} },   
        { {0,0,0,0}, {1,1,0,0}, {0,1,1,0}, {0,0,0,0} } },  
        // Z:  
        { { {1,0,0,0}, {1,1,0,0}, {0,1,0,0}, {0,0,0,0} },   
        { {0,1,1,0}, {1,1,0,0}, {0,0,0,0}, {0,0,0,0} },   
        { {1,0,0,0}, {1,1,0,0}, {0,1,0,0}, {0,0,0,0} },   
        { {0,1,1,0}, {1,1,0,0}, {0,0,0,0}, {0,0,0,0} } },  
        // L:  
        { { {0,0,0,0}, {1,1,1,0}, {0,0,1,0}, {0,0,0,0} },   
        { {0,0,1,0}, {0,0,1,0}, {0,1,1,0}, {0,0,0,0} },   
        { {0,0,0,0}, {0,1,0,0}, {0,1,1,1}, {0,0,0,0} },   
        { {0,0,0,0}, {0,1,1,0}, {0,1,0,0}, {0,1,0,0} } },  
        // J:  
        { { {0,0,0,0}, {0,0,1,0}, {1,1,1,0}, {0,0,0,0} },   
        { {0,1,0,0}, {0,1,0,0}, {0,1,1,0}, {0,0,0,0} },   
        { {0,0,0,0}, {0,1,1,1}, {0,1,0,0}, {0,0,0,0} },   
        { {0,0,0,0}, {0,1,1,0}, {0,0,1,0}, {0,0,1,0} } },  
        // I:  
        { { {0,1,0,0}, {0,1,0,0}, {0,1,0,0}, {0,1,0,0} },   
        { {0,0,0,0}, {1,1,1,1}, {0,0,0,0}, {0,0,0,0} },   
        { {0,1,0,0}, {0,1,0,0}, {0,1,0,0}, {0,1,0,0} },   
        { {0,0,0,0}, {1,1,1,1}, {0,0,0,0}, {0,0,0,0} } },  
        // O:  
        { { {0,0,0,0}, {0,1,1,0}, {0,1,1,0}, {0,0,0,0} },   
        { {0,0,0,0}, {0,1,1,0}, {0,1,1,0}, {0,0,0,0}  },   
        { {0,0,0,0}, {0,1,1,0}, {0,1,1,0}, {0,0,0,0}  },   
        { {0,0,0,0}, {0,1,1,0}, {0,1,1,0}, {0,0,0,0}  } },  
        // T:  
        { { {0,1,0,0}, {1,1,1,0}, {0,0,0,0}, {0,0,0,0} },   
        { {0,1,0,0}, {0,1,1,0}, {0,1,0,0}, {0,0,0,0} },   
        { {0,0,0,0}, {1,1,1,0}, {0,1,0,0}, {0,0,0,0} },   
        { {0,1,0,0}, {1,1,0,0}, {0,1,0,0}, {0,0,0,0} } },
	};
	
	 public static int[][][][] newShape = new int[][][][] {
         { { {0,1,0,0}, {1,1,0,0},{0,0,0,0},{0,0,0,0}},   
             { {0,1,0,0}, {0,1,1,0}, {0,0,0,0},{0,0,0,0}},   
             { {0,0,0,0}, {1,1,0,0}, {0,1,0,0},{0,0,0,0}},   
             { {0,0,0,0}, {0,1,1,0}, {0,1,0,0},{0,0,0,0}}},  
             
             { { {1,0,0,0}, {0,1,1,0}, {0,0,0,0},{0,0,0,0}},   
             { {0,0,1,0}, {0,1,0,0}, {0,1,0,0},{0,0,0,0}},   
             { {0,0,0,0}, {1,1,0,0}, {0,0,1,0},{0,0,0,0}},   
             { {0,1,0,0}, {0,1,0,0}, {1,0,0,0},{0,0,0,0}}},  
             
             { { {0,0,0,0}, {0,0,0,0}, {1,1,1,0},{0,0,0,0}},   
             { {0,1,0,0}, {0,1,0,0}, {0,1,0,0},{0,0,0,0}},   
             { {0,0,0,0}, {0,0,0,0}, {1,1,1,0},{0,0,0,0}},   
             { {0,0,0,0}, {0,0,0,0}, {1,1,1,0},{0,0,0,0}}},  
             
             { { {0,0,1,0}, {0,1,0,0}, {0,0,0,0},{0,0,0,0}},   
             { {0,0,0,0}, {0,1,0,0}, {0,0,1,0},{0,0,0,0}},   
             { {0,0,0,0}, {0,1,0,0}, {1,0,0,0},{0,0,0,0}},   
             { {1,0,0,0}, {0,1,0,0}, {0,0,0,0},{0,0,0,0}}},  
               
             { { {0,0,0,0}, {0,1,0,0}, {0,1,0,0},{0,0,0,0}},   
             { {0,1,0,0}, {0,1,0,0}, {0,0,0,0},{0,0,0,0}},   
             { {0,0,0,0}, {0,1,0,0}, {0,1,0,0},{0,0,0,0}},   
             { {0,1,0,0}, {0,1,0,0}, {0,0,0,0},{0,0,0,0}}},  
              
             { { {0,1,0,0}, {1,0,1,0}, {0,0,0,0},{0,0,0,0}},   
             { {0,1,0,0}, {0,0,1,0}, {0,1,0,0},{0,0,0,0}},   
             { {0,0,0,0}, {1,0,1,0}, {0,1,0,0},{0,0,0,0}},   
             { {0,1,0,0}, {1,0,0,0}, {0,1,0,0},{0,0,0,0}}},  
              
             { { {0,0,0,0}, {0,1,0,0}, {0,0,0,0},{0,0,0,0}},   
             { {0,0,0,0}, {0,1,0,0}, {0,0,0,0},{0,0,0,0}},   
             { {0,0,0,0}, {0,1,0,0}, {0,0,0,0},{0,0,0,0}},   
             { {0,0,0,0}, {0,1,0,0}, {0,0,0,0},{0,0,0,0}}},
             
             { { {0,0,1,0}, {0,1,0,0}, {1,0,0,0},{0,0,0,0}},   
                 { {1,0,0,0}, {0,1,0,0}, {0,0,1,0},{0,0,0,0}},   
                 { {0,0,1,0}, {0,1,0,0}, {1,0,0,0},{0,0,0,0}},   
                 { {1,0,0,0}, {0,1,0,0}, {0,0,1,0},{0,0,0,0}}},
 	};
     
     public int type, state, nextType, nextState; 
     public Color[] color = new Color[]{Color.green, Color.red, Color.orange, Color.blue, Color.cyan, Color.yellow, Color.magenta, Color.gray};  
      
     public void drawMainAreaBlocks(Graphics g, int pointX, int PointY, int PixelX,int PixelY) {
  	 	g.setColor(color[type%7]);  	
 		for(int i = 0; i < 4; i++){  
 			for(int j = 0; j < 4; j++){  
 				if (constants.tempShape[type][state][i][j]==1) {  
 					g.fill3DRect((pointX+(constants.moveXpos+i)*PixelX), (PointY+(constants.moveYpos + j)*PixelY), PixelX, PixelY,true);                 
 				}  
 			}  
 		}
     }
     
     public void drawNextAreaBlocks(Graphics g, int pointX, int PointY, int PixelX,int PixelY) {
    	 	g.setColor(color[nextType%7]);
		for(int i = 0; i < 4; i++){  
			for(int j = 0; j < 4; j++){  
				if (constants.tempShape[nextType][nextState][i][j]==1) {  
					g.fill3DRect((pointX+i*PixelX), (PointY+j*PixelY), PixelX, PixelY,true);                 
				}  
			}  
		}
     }
     
     public void drawBackground(Graphics g, int pointX, int PointY, int PixelX,int PixelY) {
         for(int i = 0; i < constants.column; i++){  
             for(int j = 0; j < constants.row; j++){  
                 if (constants.map[i][j] == 1) {  
                     g.setColor(color[constants.level % 7]);  
                     g.fill3DRect(pointX+i*PixelX, PointY+j*PixelY, PixelX, PixelY,true);  
                 }  
             }  
         } 	
     }
     
     private boolean newBegin =true;    
     
     public void newShape() {    	 	
    	 	Random rand = new Random();  
    	 	if(newBegin) {
    	 		type = rand.nextInt(7+constants.shapeNumber);
            state = rand.nextInt(4);   
            newBegin = false;  
   	 	}else {
    	 		type = nextType;
    	 		state = nextState;
    	 	}
    	 	constants.moveYpos = 0;
    	 	constants.moveXpos = 2;
        nextType = rand.nextInt(7+constants.shapeNumber);
        nextState = rand.nextInt(4); 
     
        if(isGameOver(type, state, constants.moveXpos, constants.moveYpos)){          
            JOptionPane.showMessageDialog(null, "GAME OVER!");    
    	 		constants.level = 1;
            newGame();       
        } 
     }
     
     private boolean check(int type, int state, int x, int y){  
         for(int i = 0; i < 4; i++){  
             for(int j = 0; j < 4; j++){  
                 if ((constants.tempShape[type][state][i][j] == 1) && ((x+i>=constants.column) || (x+i<0 ) || (y+j>=constants.row) || (constants.map[x+i][y+j]==1))) {  
                     return false;  
                 }  
             }  
         }  
         return true;  
     } 
     
     private void add(int type, int state, int x, int y){  
         for(int i = 0; i < 4; i++){  
             for(int j = 0; j < 4 ; j++){  
                 if((y+j<constants.row)&&(x+i<constants.column)&&(x+i>=0)&&(constants.map[x+i][y+j]==0)){  
                     constants.map[x+i][y+j]=constants.tempShape[type][state][i][j];  
                     constants.mapColor[x+i][y+j]=color[type%7];  
                 }  
             }  
         }  
     } 
     
     public void timerListenerAction(){
    	 	if(check(type, state, constants.moveXpos, constants.moveYpos+1)) {
			constants.moveYpos = constants.moveYpos + 1;
		}else {
			add(type, state, constants.moveXpos, constants.moveYpos); 
			delLine();
			newShape();			
		}		
     }
     
     public void backwardTurn() {
        int tmpState = state;  
    	 	state = (state+3)%4;
        if (!check(type,state, constants.moveXpos, constants.moveYpos)) {  
            state = tmpState;     
        }          
     }
     
     public void forwardTurn(){  
         int tmpState = state;  
         state = (state + 1)%4;  
         if (!check(type,state, constants.moveXpos, constants.moveYpos)) {  
             state = tmpState;       
         }    
     } 
     
     public void left(){  
         if(check(type,state, constants.moveXpos-1, constants.moveYpos)){  
             --constants.moveXpos;             
         }  
     }  
   
     public void right(){  
         if (check(type,state, constants.moveXpos+1, constants.moveYpos)) {  
             ++constants.moveXpos;  
         }  
     }
     
     private boolean isGameOver(int type, int state, int x, int y){  
         return !check(type, state, x, y);  
     } 
     
     private void newMap(){  
         for(int i = 0; i < constants.column; i++){  
             Arrays.fill(constants.map[i],0);  
         }          
     } 
     
     public  void newGame() {
        constants.lines = 0;
       	constants.scores = 0; 
       	
		constants.timerFac = 700;			
		constants.timer.setDelay(constants.timerFac);

       	constants.speedfactor = (float) 0.1;
       	constants.scorefactor = 1;
    	 	newMap();
    	 	newBegin =true;    	
     }
     
     private void delLine(){  
         boolean flag = false;  
         for(int j = 0; j < constants.row; j++){  
             flag = true;  
             for( int i = 0; i < constants.column; i++){  
                 if (constants.map[i][j]==0){  
                     flag = false;  
                     break;  
                 }  
             }  
             if(flag){             	 
            	 	constants.scores += constants.level * constants.scorefactor;
            	 	for(int t = j; t > 0; t--){
            	 		for(int i = 0; i <constants.column; i++){
            	 			constants.map[i][t] = constants.map[i][t-1];                          
                     }  
                 } 
                 constants.lines += 1; 
                 checkLevel(constants.lines); 
             }  
         }             
     }
     
     private void checkLevel(int lines) {
    		if(constants.linesNum == 0) {
    	 		if(lines == 20) {
    	 			constants.level = 2;
    	   			constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));
    	   			constants.timer.setDelay(constants.timerFac);
    	 		}
    	 		else if(lines == 30) {
    	 			constants.level = 3;
       	   		constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));
    	   			constants.timer.setDelay(constants.timerFac);
    	 		}
    	 		else if(lines == 40) {
    	 			constants.level = 4;
       	   		constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));
    	   			constants.timer.setDelay(constants.timerFac);
    	 		}
    	 		else if(lines >= 50) {
    	 			constants.level  = 5; 
       	   		constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));
    	   			constants.timer.setDelay(constants.timerFac);
    	 		}   	 	
 
    	 	}else {
    	 		switch(constants.linesNum) {
	 			case 20:{
	 				if(lines == 20) {
	 					constants.level = 2;	 
		 				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));
		   				constants.timer.setDelay(constants.timerFac);
	 				}
	 				if(lines == 30) {
	 					constants.level = 3;	 					
	 					constants.linesNum += 10;
		 				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));
		   				constants.timer.setDelay(constants.timerFac);
	 				}
	 				
	 			}
	 			case 30:{
	 				if(lines == 30) {
	 					constants.level = 3;
		   				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));
		   				constants.timer.setDelay(constants.timerFac);	 			
	 				}
	 				if(lines == 40) {
	 					constants.level = 4;
	 					constants.linesNum += 10;
		   				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));
		   				constants.timer.setDelay(constants.timerFac);	 			
	 				}
	 			}
	 			case 40:{
	 				if(lines == 40) {
	 					constants.level = 4;
		   				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));
		   				constants.timer.setDelay(constants.timerFac);	 		
	 				}
	 				if(lines == 50) {
	 					constants.level = 5;
	 					constants.linesNum += 10;
		   				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));
		   				constants.timer.setDelay(constants.timerFac);	 		
	 				}
	 			}
	 			case 50:{
	 				if(lines == 50) {
	 					constants.level = 5;
		   				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));
		   				constants.timer.setDelay(constants.timerFac);
	 				}
	 			}default:break;
	 		} 
	 	}
    	 }    
}
