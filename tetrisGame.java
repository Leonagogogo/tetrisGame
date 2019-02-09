//package tetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//import package edit;
//import package blocks;
//import package add;

public class tetrisGame extends JFrame{	
	blocks tetrisBlock = new blocks();	
	private float mainPointx,mainPointy,nextPointx,nextPointy,descPointx,descPointy;
	private int nextWidth,nextHeight,descWidth,descHeight;
	
	private float pausePointx,pausePointy,levelPointx,levelPointy,linesPointx,linesPointy,
	scorePointx,scorePointy,quitPointx,quitPointy,pauseStringPointx,pauseStringPointy;
	private int pauseWidth,pauseHeight,quitWidth,quitHeight;

	private JButton quit = new JButton("QUIT");
	private JButton edit = new JButton("Set");
	private JButton add = new JButton("Add");
	private JButton newGame = new JButton("new Game");
	
	mainArea main = new mainArea();
	nextArea next = new nextArea();
	descArea desc = new descArea();	
	menu menuBar = new menu();

	private int wheelCountForward = 0;
	private int wheelCountBackward = 0;
	
	public tetrisGame() { 			
		constants.tempShape = new int[7][4][4][4];
		System.arraycopy(blocks.shape, 0, constants.tempShape, 0, 7);
	
		setLayout(null);
		setTitle("The Grame of Tetris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(constants.drawPanelWidth,constants.drawPanelHeight));
		setSize(constants.drawPanelWidth, constants.drawPanelHeight);
		setLocationRelativeTo(null); 
		setVisible(false);
			
		add(menuBar);
		add(main);
		add(next);
		add(desc);			
		
		constants.map = new int[constants.column][constants.row];
		constants.mapColor = new Color[constants.column][constants.row];
		
		tetrisBlock.newShape();
		constants.timer.start();
		constants.timer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){  
				tetrisBlock.	timerListenerAction();
				repaint();
		    }  				
		});
		
		addMouseMotionListener(new MouseMotionAdapter(){
			@Override
			public void mouseMoved(MouseEvent e) {				
				constants.pause = false;
				constants.timer.start();
				repaint();
			}		
		});
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == e.BUTTON1) {
					tetrisBlock.left();
				}else if(e.getButton() == e.BUTTON3) {
					tetrisBlock.right();
				}
			}
		});
		
		addMouseWheelListener(new MouseAdapter() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				if(e.getWheelRotation() == 1) {
					wheelCountForward++;
					if(wheelCountForward == 2) {
						tetrisBlock.forwardTurn();							
						wheelCountForward = 0;
					}
					
				}else if(e.getWheelRotation() == -1) {
					wheelCountBackward++;
					if(wheelCountBackward == 2) {
						tetrisBlock.backwardTurn();
						wheelCountBackward = 0;
					}				
				}
			}
		});
		
		addComponentListener(new ComponentAdapter()  {
			public void componentResized(ComponentEvent e) {	 
				constants.drawPanelX = e.getComponent().getWidth();
				constants.drawPanelY = e.getComponent().getHeight();	
									
				if(constants.drawPanelX > constants.drawPanelY) {
					constants.Pixel = constants.drawPanelY/constants.panelNum;
				}else {
					constants.Pixel = constants.drawPanelX/constants.panelNum;
				}											
								
				constants.mainWidth = constants.Pixel * constants.column;
				constants.mainHeight = constants.Pixel * constants.row;			
								
				mainPointx = constants.drawPanelX/2 - constants.mainWidth;
				mainPointy = constants.drawPanelY/2 - constants.mainHeight/2;	
				
				main.setLayout(new BorderLayout());
				main.setBackground(Color.white);	
				main.setPreferredSize(new Dimension(constants.mainWidth,constants.mainHeight));
				main.setBounds((int)mainPointx,(int)mainPointy,constants.mainWidth, constants.mainHeight);
				main.setBorder(BorderFactory.createLineBorder(Color.black));
				main.setVisible(true); 
				
				nextPointx = constants.drawPanelX/2 + constants.Pixel;
				nextPointy = mainPointy;
				nextWidth = constants.mainWidth - constants.Pixel*2;
				nextHeight = constants.mainHeight/3;								

				next.setBackground(Color.white);
				next.setPreferredSize(new Dimension(nextWidth,nextHeight));
				next.setBounds((int)nextPointx,(int)nextPointy,nextWidth, nextHeight);
				next.setBorder(BorderFactory.createLineBorder(Color.black));
				next.setVisible(true);
				
				descPointx = constants.drawPanelX/2 + constants.Pixel;
				descPointy = nextPointy + nextHeight;				
				descWidth = nextWidth;
				descHeight = constants.mainHeight - nextHeight;			
			
				desc.setLayout(null);
				desc.setPreferredSize(new Dimension(descWidth,descHeight));
				desc.setBounds((int)descPointx,(int)descPointy,descWidth, descHeight);			
				desc.add(quit);
				desc.setVisible(true);	

				menuBar.setLayout(null);
				menuBar.setBounds(0, 0, constants.drawPanelX, constants.Pixel);
				menuBar.setPreferredSize(new Dimension(constants.drawPanelX,constants.Pixel));
				menuBar.setVisible(true);	
				menuBar.add(edit);	
				menuBar.add(add);
				menuBar.add(newGame);
			}
		});
	}
	

	public class menu extends JPanel{
		public menu() {
			addComponentListener(new ComponentAdapter()  {
				public void componentResized(ComponentEvent e) {	 
					int sizeX = e.getComponent().getWidth();
					int sizeY = e.getComponent().getHeight();
					
					int wordFont = (int) (0.00075 * sizeX * sizeY);
					
					edit.setFont(new Font("Times", Font.BOLD,wordFont));
					edit.setBounds(0, 0, constants.Pixel * 3, sizeY);
					edit.setBorder(BorderFactory.createLineBorder(Color.black));	
					
					add.setFont(new Font("Times", Font.BOLD,wordFont));
					add.setBounds(constants.Pixel * 4, 0, constants.Pixel * 3, sizeY);
					add.setBorder(BorderFactory.createLineBorder(Color.black));	
					
					newGame.setFont(new Font("Times", Font.BOLD,wordFont));
					newGame.setBounds(constants.Pixel * 8, 0, constants.Pixel * 6, sizeY);
					newGame.setBorder(BorderFactory.createLineBorder(Color.black));	
				}
			});
			edit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					edit set = new edit();	
					constants.timer.stop();
					set.setVisible(true);	
				}
			});	
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add addGraphics = new add();
					constants.timer.stop();
					addGraphics.setVisible(true);
				}
			});	
			
			newGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					constants.level = 1;
					constants.moveYpos = 0;
		    	 		constants.moveXpos = 2;
					constants.tempShape = new int[7][4][4][4];
					System.arraycopy(blocks.shape, 0, constants.tempShape, 0, 7);

					tetrisBlock.newGame();
				}
			});
		}
	}
	

	public class mainArea extends JPanel{	
		int flag = 0;
		int wordFont = 0;
		int count = 0;
		public mainArea() {				
			addMouseMotionListener(new MouseMotionAdapter(){
				@Override
				public void mouseMoved(MouseEvent e) {
					constants.pause = true;
					constants.timer.stop();					
					repaint();			
					testPoint(e.getX(), e.getY());
				}		
			});
  			addComponentListener(new ComponentAdapter()  {
				public void componentResized(ComponentEvent e) {	
					constants.mainWidth = e.getComponent().getWidth();
					constants.mainHeight = e.getComponent().getHeight();					
					wordFont = (int) (0.00016 * constants.mainWidth * constants.mainHeight);								
					pausePointx = constants.mainWidth/3;
					pausePointy = constants.mainHeight/3;
					pauseWidth = (int) (constants.mainWidth/2.3);
					pauseHeight = (int) (constants.mainHeight/6);
					pauseStringPointx = (int) (0.4 * constants.mainWidth);
					pauseStringPointy = (int) (0.4 * constants.mainHeight);					
					repaint();
				}
			});
		}	
					
		public void paint(Graphics g) {
			super.paint(g);
			tetrisBlock.drawMainAreaBlocks(g,0,0,constants.Pixel,constants.Pixel);
			tetrisBlock.drawBackground(g,0,0,constants.Pixel,constants.Pixel);		
			
			if(constants.pause) {
				constants.pause = false;
				g.setColor(Color.cyan);
				g.drawRect((int)pausePointx, (int)pausePointy, (int)pauseWidth, (int)pauseHeight);
				g.setColor(Color.cyan);
				g.setFont(new Font("Times", Font.BOLD, wordFont));
				g.drawString("PAUSE", (int)pauseStringPointx, (int)pauseStringPointy);
			}
		}
		
		public void testPoint(int x, int y) {	
			int currentX1 = constants.moveXpos * constants.Pixel;
			int currentX2 = (constants.moveXpos + 4) * constants.Pixel;
			int currentY1 = constants.moveYpos * constants.Pixel;
			int currentY2 = (constants.moveYpos + 4) * constants.Pixel;
			
			if((x<currentX1)||(x>currentX2)||(y<currentY1)||(y>currentY2)) {
				return;
			}else {
				for(int i=0;i<4;i++) {
					for(int j=0;j<4;j++) {
						int x1 = (constants.moveXpos + i) * constants.Pixel;
						int y1 = (constants.moveYpos + j) * constants.Pixel;	
						if(constants.tempShape[tetrisBlock.type][tetrisBlock.state][i][j] == 1) {
							if((x>=x1)&(x<=x1+constants.Pixel)&(y>=y1)&(y<=y1+constants.Pixel)) {
								tetrisBlock.type = (tetrisBlock.type + 1)%(7+constants.shapeNumber);
								if(tetrisBlock.type == tetrisBlock.nextType) {
									tetrisBlock.type = (tetrisBlock.type + 1)%(7+constants.shapeNumber);
								}
								constants.scores = constants.scores - constants.level * constants.scorefactor;
								if(constants.scores < 0) {
									constants.scores = 0;
								}
								return;
							}
						}					
					}
				}
			}				
		}
	}
	
	public class nextArea extends JPanel{

		public nextArea() {				
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if(e.getButton() == e.BUTTON1) {
						tetrisBlock.left();
					}else if(e.getButton() == e.BUTTON3) {
						tetrisBlock.right();
					}
				}
			});
			
			addMouseWheelListener(new MouseAdapter() {
				public void mouseWheelMoved(MouseWheelEvent e) {
					if(e.getWheelRotation() == 1) {
						wheelCountForward++;					
						if(wheelCountForward == 2) {
							tetrisBlock.forwardTurn();							
							wheelCountForward = 0;
						}
						
					}else if(e.getWheelRotation() == -1) {
						wheelCountBackward++;
						if(wheelCountBackward == 2) {
							tetrisBlock.backwardTurn();
							wheelCountBackward = 0;
						}					
					}
				}
			});
			
			addMouseMotionListener(new MouseMotionAdapter(){
				@Override
				public void mouseMoved(MouseEvent e) {
					constants.pause = false;
					constants.timer.start();
					repaint();
				}		
			});
		}
		
		public void paint(Graphics g) {
			super.paint(g);	
			tetrisBlock.drawNextAreaBlocks(g,constants.Pixel, constants.Pixel, constants.Pixel,constants.Pixel); 
		}
	}
	
	public class descArea extends JPanel{
		int wordFont = 0;
		public descArea() {	
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if(e.getButton() == e.BUTTON1) {
						tetrisBlock.left();						
					}else if(e.getButton() == e.BUTTON3) {
						tetrisBlock.right();
					}
				}
			});
			
			addMouseWheelListener(new MouseAdapter() {
				public void mouseWheelMoved(MouseWheelEvent e) {
					if(e.getWheelRotation() == 1) {
						wheelCountForward++;					
						if(wheelCountForward == 2) {
							tetrisBlock.forwardTurn();							
							wheelCountForward = 0;
						}						
					}else if(e.getWheelRotation() == -1) {
						wheelCountBackward++;
						if(wheelCountBackward == 2) {
							tetrisBlock.backwardTurn();
							wheelCountBackward = 0;
						}						
					}
				}
			});
			
			addMouseMotionListener(new MouseMotionAdapter(){
				@Override
				public void mouseMoved(MouseEvent e) {
					constants.pause = false;
					constants.timer.start();
					repaint();
				}		
			});
			
			quit.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					System.exit(0);
				}
			});
			
			addComponentListener(new ComponentAdapter()  {
				public void componentResized(ComponentEvent e) {	  				
					int sizeX = e.getComponent().getWidth();
					int sizeY = e.getComponent().getHeight();
					
					wordFont = (int) (0.000296296 * sizeX * sizeY);
					
					levelPointx = 0; 
					levelPointy = sizeY/6;
					linesPointx = 0; 
					linesPointy = sizeY/3;
					scorePointx = 0; 
					scorePointy = sizeY/2;
					quitPointx = 0; 
					quitPointy = (float) (sizeY/1.25);				
					quitWidth = (int) (sizeX/2);
					quitHeight = (int) (sizeY/5);
					
					quit.setFont(new Font("Times", Font.BOLD,wordFont));
					quit.setBounds((int)quitPointx, (int)quitPointy, quitWidth, quitHeight);
					quit.setBorder(BorderFactory.createLineBorder(Color.black));
				}
			});
		}
		public void paint(Graphics g) {
			super.paint(g);
			g.setFont(new Font("Times", Font.BOLD, wordFont));
			g.drawString("Level: " + constants.level, (int)levelPointx, (int)levelPointy);
			g.setFont(new Font("Times", Font.BOLD, wordFont));
			g.drawString("Lines: " + constants.lines, (int)linesPointx, (int)linesPointy);
			g.setFont(new Font("Times", Font.BOLD, wordFont));
			g.drawString("Scores: " + constants.scores, (int)scorePointx, (int)scorePointy);
		}	
	} 
	
	public static void main(String[] args) {
		constants.game.setVisible(true);
	}
}
