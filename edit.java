//package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;

public class edit extends JFrame{	
	blocks tetrisBlocks = new blocks();
	private speedFactor sf = new speedFactor();
	private levelFactor lf = new levelFactor();
	private scoresFactor ssf = new scoresFactor();
	private sizeFactor sif = new sizeFactor();
	private squareFactor sqf = new squareFactor();
	
	private JButton speed = new JButton("Speed(S)");
	private JButton level = new JButton("Level(N)");
	private JButton scores = new JButton("Score(M)");
	private JButton size = new JButton("Size");
	private JButton square = new JButton("Square");
	private JButton ok = new JButton("OK");
	
	private ButtonGroup speedGroup = new ButtonGroup();
	private ButtonGroup levelGroup = new ButtonGroup();
	private ButtonGroup scoreGroup = new ButtonGroup();
	
	private JRadioButton level1 = new JRadioButton("Level 1 (Deafult)");
	private JRadioButton level2 = new JRadioButton("Level 2");
	private JRadioButton level3 = new JRadioButton("Level 3");
	private JRadioButton level4 = new JRadioButton("Level 4");
	private JRadioButton level5 = new JRadioButton("Level 5");
	
	private JRadioButton speedFactor1 = new JRadioButton("Speed 1 (Deafult)");
	private JRadioButton speedFactor2 = new JRadioButton("Speed 2");
	private JRadioButton speedFactor3 = new JRadioButton("Speed 3");
	private JRadioButton speedFactor4 = new JRadioButton("Speed 4");
	private JRadioButton speedFactor5 = new JRadioButton("Speed 5");
	private JRadioButton speedFactor6 = new JRadioButton("Speed 6");
	private JRadioButton speedFactor7 = new JRadioButton("Speed 7");
	private JRadioButton speedFactor8 = new JRadioButton("Speed 8");
	private JRadioButton speedFactor9 = new JRadioButton("Speed 9");
	private JRadioButton speedFactor10 = new JRadioButton("Speed 10");
	
	private JRadioButton scoreFactor1 = new JRadioButton("M1 (Deafult)");
	private JRadioButton scoreFactor2 = new JRadioButton("M2");
	private JRadioButton scoreFactor3 = new JRadioButton("M3");
	private JRadioButton scoreFactor4 = new JRadioButton("M4");
	private JRadioButton scoreFactor5 = new JRadioButton("M5");
	private JRadioButton scoreFactor6 = new JRadioButton("M6");
	private JRadioButton scoreFactor7 = new JRadioButton("M7");
	private JRadioButton scoreFactor8 = new JRadioButton("M8");
	private JRadioButton scoreFactor9 = new JRadioButton("M9");
	private JRadioButton scoreFactor10 = new JRadioButton("M10");
	
	private JButton larger = new JButton("Larger");
	private JButton smaller = new JButton("Smaller");
	
	private JLabel setRows = new JLabel("Rows:");
	private JLabel setColumns = new JLabel("Columns:");
	private JTextField sr = new JTextField();
	private JTextField sc = new JTextField();
	private JButton setSize = new JButton("Set");
			
	public edit() {			
		this.setLayout(null);
		this.setTitle("Preference");
		this.setPreferredSize(new Dimension(25 * 20,25 * 20));
		this.setSize(25* 20,25 * 20);
		this.setResizable(false);	
		this.setLocationRelativeTo(null); 
		this.setVisible(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.add(scores);
		this.add(level);
		this.add(speed);	
		this.add(square);
		this.add(size);
		this.add(ok);
		this.add(sf);
		this.add(ssf);
		this.add(lf);
		this.add(sif);
		this.add(sqf);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "Click OK button to exit!"); 
			}
		});
			
		addComponentListener(new ComponentAdapter()  {
			public void componentResized(ComponentEvent e) {	  
				int sizeX = e.getComponent().getWidth();
				int sizeY = e.getComponent().getHeight();	
				int wordFont = (int)(0.00008 * sizeX * sizeY);
				
				scores.setFont(new Font("Times", Font.BOLD,wordFont));
				scores.setBounds(0, sizeY/15, sizeX/4, sizeY/20);
				scores.setBorder(BorderFactory.createLineBorder(Color.black));
				
				level.setFont(new Font("Times", Font.BOLD,wordFont));
				level.setBounds(0, sizeY*2/15, sizeX/4, sizeY/20);
				level.setBorder(BorderFactory.createLineBorder(Color.black));
				
				speed.setFont(new Font("Times", Font.BOLD,wordFont));
				speed.setBounds(0, sizeY/5, sizeX/4, sizeY/20);
				speed.setBorder(BorderFactory.createLineBorder(Color.black));
				
				size.setFont(new Font("Times", Font.BOLD,wordFont));
				size.setBounds(0, sizeY*4/15, sizeX/4, sizeY/20);
				size.setBorder(BorderFactory.createLineBorder(Color.black));
				
				square.setFont(new Font("Times", Font.BOLD,wordFont));
				square.setBounds(0, sizeY/3, sizeX/4, sizeY/20);
				square.setBorder(BorderFactory.createLineBorder(Color.black));
				
				ok.setFont(new Font("Times", Font.BOLD,wordFont));
				ok.setBounds(0, sizeY*4/5, sizeX/6, sizeY/20);
				ok.setBorder(BorderFactory.createLineBorder(Color.black));
				
				sf.setLayout(null);
				sf.setBackground(Color.white);	
				sf.setPreferredSize(new Dimension(sizeX*3/4,sizeY));
				sf.setBounds(sizeX/4, 0, sizeX*3/4, sizeY);
				sf.setVisible(false);
				speedGroup.add(speedFactor1);
				speedGroup.add(speedFactor2);
				speedGroup.add(speedFactor3);
				speedGroup.add(speedFactor4);
				speedGroup.add(speedFactor5);
				speedGroup.add(speedFactor6);
				speedGroup.add(speedFactor7);
				speedGroup.add(speedFactor8);
				speedGroup.add(speedFactor9);
				speedGroup.add(speedFactor10);
				sf.add(speedFactor1);
				sf.add(speedFactor2);
				sf.add(speedFactor3);
				sf.add(speedFactor4);
				sf.add(speedFactor5);
				sf.add(speedFactor6);
				sf.add(speedFactor7);
				sf.add(speedFactor8);
				sf.add(speedFactor9);
				sf.add(speedFactor10);
				
				ssf.setLayout(null);
				ssf.setBackground(Color.white);	
				ssf.setPreferredSize(new Dimension(sizeX*3/4,sizeY));
				ssf.setBounds(sizeX/4, 0, sizeX*3/4, sizeY);
				ssf.setVisible(false);
				scoreGroup.add(scoreFactor1);
				scoreGroup.add(scoreFactor2);
				scoreGroup.add(scoreFactor3);
				scoreGroup.add(scoreFactor4);
				scoreGroup.add(scoreFactor5);
				scoreGroup.add(scoreFactor6);
				scoreGroup.add(scoreFactor7);
				scoreGroup.add(scoreFactor8);
				scoreGroup.add(scoreFactor9);
				scoreGroup.add(scoreFactor10);
				ssf.add(scoreFactor1);
				ssf.add(scoreFactor2);
				ssf.add(scoreFactor3);
				ssf.add(scoreFactor4);
				ssf.add(scoreFactor5);
				ssf.add(scoreFactor6);
				ssf.add(scoreFactor7);
				ssf.add(scoreFactor8);
				ssf.add(scoreFactor9);
				ssf.add(scoreFactor10);
				
				lf.setLayout(null);
				lf.setBackground(Color.white);	
				lf.setPreferredSize(new Dimension(sizeX*3/4,sizeY));
				lf.setBounds(sizeX/4, 0, sizeX*3/4, sizeY);
				lf.setVisible(false);
							
				levelGroup.add(level1);	
				levelGroup.add(level2);	
				levelGroup.add(level3);	
				levelGroup.add(level4);
				levelGroup.add(level5);			
				lf.add(level1);
				lf.add(level2);
				lf.add(level3);
				lf.add(level4);
				lf.add(level5);	
				
				sif.setLayout(null);
				sif.setBackground(Color.white);	
				sif.setPreferredSize(new Dimension(sizeX*3/4,sizeY));
				sif.setBounds(sizeX/4, 0, sizeX*3/4, sizeY);
				sif.setVisible(false);
				sif.add(setRows);
				sif.add(setColumns);
				sif.add(sr);
				sif.add(sc);
				sif.add(setSize);
				
				sqf.setLayout(null);
				sqf.setBackground(Color.white);	
				sqf.setPreferredSize(new Dimension(sizeX*3/4,sizeY));
				sqf.setBounds(sizeX/4, 0, sizeX*3/4, sizeY);
				sqf.setVisible(false);				
				sqf.add(larger);
				sqf.add(smaller);
			}
		});
			
		speed.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				ssf.setVisible(false);
				lf.setVisible(false);
				sif.setVisible(false);
				sqf.setVisible(false);
				sf.setVisible(true);
			}
		});
		speedFactor1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.speedfactor = 0;
				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));				
				constants.timer.setDelay(constants.timerFac);
		}
		});
		speedFactor2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.speedfactor = (float) 0.1;
				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));				
				constants.timer.setDelay(constants.timerFac);
			}
		});
		speedFactor3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.speedfactor = (float) 0.2;
				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));				
				constants.timer.setDelay(constants.timerFac);
			}
		});
		speedFactor4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.speedfactor = (float) 0.3;
				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));				
				constants.timer.setDelay(constants.timerFac);
			}
		});
		speedFactor5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.speedfactor = (float) 0.4;
				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));				
				constants.timer.setDelay(constants.timerFac);
			}
		});
		speedFactor6.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.speedfactor = (float) 0.5;
				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));				
				constants.timer.setDelay(constants.timerFac);
			}
		});
		speedFactor7.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.speedfactor = (float) 0.6;
				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));				
				constants.timer.setDelay(constants.timerFac);
			}
		});
		speedFactor8.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.speedfactor = (float) 0.7;
				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));				
				constants.timer.setDelay(constants.timerFac);
			}
		});
		speedFactor9.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.speedfactor = (float) 0.8;
				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));				
				constants.timer.setDelay(constants.timerFac);
			}
		});
		speedFactor10.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.speedfactor = (float) 0.9;
				constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));				
				constants.timer.setDelay(constants.timerFac);
			}
		});	
		
		level.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				ssf.setVisible(false);
				lf.setVisible(true);
				sif.setVisible(false);
				sqf.setVisible(false);
				sf.setVisible(false);
			}
		});
		
		level1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.level = 1;	
				constants.linesNum = 0;
				constants.timerFac = 700;			
				constants.timer.setDelay(constants.timerFac);
							
			}
		});		
		level2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.level = 2;
				constants.linesNum = 20;
				constants.timerFac = 600;
			//	constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));			
				constants.timer.setDelay(constants.timerFac);
			}
		});
		level3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.level = 3;
				constants.linesNum = 30;
				constants.timerFac = 500;
			//	constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));			
				constants.timer.setDelay(constants.timerFac);
			}
		});
		level4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.level = 4;
				constants.linesNum = 40;
				constants.timerFac = 400;
			//	constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));		
				constants.timer.setDelay(constants.timerFac);
			}
		});
		level5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.level = 5;
				constants.linesNum = 50;
				constants.timerFac = 300;
			//	constants.timerFac = (int) (constants.timerFac / (1 + constants.level * constants.speedfactor));		
				constants.timer.setDelay(constants.timerFac);
			}
		});
		
		scores.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				ssf.setVisible(true);
				lf.setVisible(false);
				sif.setVisible(false);
				sqf.setVisible(false);
				sf.setVisible(false);
			}
		});
		scoreFactor1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.scorefactor = 1;
			}
		});
		scoreFactor2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.scorefactor = 2;
				
			}
		});
		scoreFactor3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.scorefactor = 3;
			}
		});
		scoreFactor4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.scorefactor = 4;
			}
		});
		scoreFactor5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.scorefactor = 5;
			}
		});
		scoreFactor6.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.scorefactor = 6;
			}
		});
		scoreFactor7.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.scorefactor = 7;
			}
		});
		scoreFactor8.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.scorefactor = 8;
			}
		});
		scoreFactor9.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.scorefactor = 9;
			}
		});
		scoreFactor10.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				constants.scorefactor = 10;
			}
		});
		
		size.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				ssf.setVisible(false);
				lf.setVisible(false);
				sif.setVisible(true);
				sqf.setVisible(false);
				sf.setVisible(false);
			}
		});
		
		square.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				ssf.setVisible(false);
				lf.setVisible(false);
				sif.setVisible(false);
				sqf.setVisible(true);
				sf.setVisible(false);
			}
		});
		larger.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {	
				constants.panelNum = 25;
				constants.Pixel = constants.Pixel + 5;	
				if(constants.Pixel > 40) {
					constants.Pixel = 40;
					JOptionPane.showMessageDialog(null, "Could not be bigger anymore!"); 	
					return;
				}else {	
					constants.drawPanelHeight = constants.Pixel * constants.panelNum;
					constants.drawPanelWidth = constants.Pixel * constants.panelNum;
				
					constants.row =  constants.drawPanelWidth / constants.Pixel - 3;
					constants.column = constants.row / 2;
					
					constants.map = new int[constants.column][constants.row];
					constants.mapColor = new Color[constants.column][constants.row];
				}
				repaint();
			}
		});
		smaller.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {				
				constants.Pixel = constants.Pixel - 5;	
				if(constants.Pixel < 15) {
					constants.Pixel = 15;
					JOptionPane.showMessageDialog(null, "Could not be bigger anymore!"); 	
					return;
				}else {
					constants.drawPanelHeight = constants.Pixel * constants.panelNum;
					constants.drawPanelWidth = constants.Pixel * constants.panelNum;
					
					constants.row =  constants.drawPanelWidth / constants.Pixel - 4;
					constants.column = constants.row / 2;
					constants.map = new int[constants.column][constants.row];
					constants.mapColor = new Color[constants.column][constants.row];
				}
				repaint();
			}
		});
		setSize.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {			
				String sizeRow = sr.getText();	
				constants.Pixel = 25;
				if(sizeRow.equals("")) {
					JOptionPane.showMessageDialog(null, "Please input the rows.");
				}else {
					constants.setSizeRow = Integer.parseInt(sizeRow);		
					if((constants.setSizeRow < 20) || (constants.setSizeRow > 40)){
						JOptionPane.showMessageDialog(null, "The row should be bigger than 20 or smaller than 40.");
					}else {
						constants.row = constants.setSizeRow;						
						constants.column = constants.row / 2;											
					}
					constants.map = new int[constants.column][constants.row];
					constants.mapColor = new Color[constants.column][constants.row];	
					constants.panelNum = constants.row + 3;
					constants.drawPanelHeight = constants.Pixel * constants.panelNum;
					constants.drawPanelWidth = constants.drawPanelHeight;
					
					JOptionPane.showMessageDialog(null, "OK");
				}						
			}
		});
		
		ok.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mousePressed(MouseEvent e) {
				//tetrisBlocks.newGame();
				setVisible(false);			
				constants.game.setPreferredSize(new Dimension(constants.drawPanelWidth,constants.drawPanelHeight));
				constants.game.setSize(constants.drawPanelWidth, constants.drawPanelHeight);		
								
			}
		});
	}
	
	public class speedFactor extends JPanel{		
		public speedFactor() {		
			this.setVisible(false);	
			
			addComponentListener(new ComponentAdapter() {
				public void componentResized(ComponentEvent e) {
					int sizeX = e.getComponent().getWidth();
					int sizeY = e.getComponent().getHeight();	
					int wordFont = (int)(0.00010667 * sizeX * sizeY);
					
					speedFactor1.setFont(new Font("Times", Font.BOLD,wordFont));
					speedFactor1.setBounds(sizeX/10, sizeY/7, sizeX/2, sizeY/20);
					speedFactor1.setBorder(BorderFactory.createLineBorder(Color.black));

					speedFactor2.setFont(new Font("Times", Font.BOLD,wordFont));
					speedFactor2.setBounds(sizeX*5/8, sizeY/7, sizeX/4, sizeY/20);
					speedFactor2.setBorder(BorderFactory.createLineBorder(Color.black));

					speedFactor3.setFont(new Font("Times", Font.BOLD,wordFont));
					speedFactor3.setBounds(sizeX/10, sizeY*2/7, sizeX/4, sizeY/20);
					speedFactor3.setBorder(BorderFactory.createLineBorder(Color.black));

					speedFactor4.setFont(new Font("Times", Font.BOLD,wordFont));
					speedFactor4.setBounds(sizeX*5/8, sizeY*2/7, sizeX/4, sizeY/20);
					speedFactor4.setBorder(BorderFactory.createLineBorder(Color.black));

					speedFactor5.setFont(new Font("Times", Font.BOLD,wordFont));
					speedFactor5.setBounds(sizeX/10, sizeY*3/7, sizeX/4, sizeY/20);
					speedFactor5.setBorder(BorderFactory.createLineBorder(Color.black));
					
					speedFactor6.setFont(new Font("Times", Font.BOLD,wordFont));
					speedFactor6.setBounds(sizeX*5/8, sizeY*3/7, sizeX/4, sizeY/20);
					speedFactor6.setBorder(BorderFactory.createLineBorder(Color.black));

					speedFactor7.setFont(new Font("Times", Font.BOLD,wordFont));
					speedFactor7.setBounds(sizeX/10, sizeY*4/7, sizeX/4, sizeY/20);
					speedFactor7.setBorder(BorderFactory.createLineBorder(Color.black));

					speedFactor8.setFont(new Font("Times", Font.BOLD,wordFont));
					speedFactor8.setBounds(sizeX*5/8, sizeY*4/7, sizeX/4, sizeY/20);
					speedFactor8.setBorder(BorderFactory.createLineBorder(Color.black));

					speedFactor9.setFont(new Font("Times", Font.BOLD,wordFont));
					speedFactor9.setBounds(sizeX/10, sizeY*5/7, sizeX/4, sizeY/20);
					speedFactor9.setBorder(BorderFactory.createLineBorder(Color.black));

					speedFactor10.setFont(new Font("Times", Font.BOLD,wordFont));
					speedFactor10.setBounds(sizeX*5/8, sizeY*5/7, sizeX/3, sizeY/20);
					speedFactor10.setBorder(BorderFactory.createLineBorder(Color.black));									
				}
			});	
		}
	}

	
	public class levelFactor extends JPanel{		
		public levelFactor() {		
			this.setVisible(false);	
			
			addComponentListener(new ComponentAdapter() {
				public void componentResized(ComponentEvent e) {
					int sizeX = e.getComponent().getWidth();
					int sizeY = e.getComponent().getHeight();	
					int wordFont = (int)(0.00010667 * sizeX * sizeY);
					
					level1.setFont(new Font("Times", Font.BOLD,wordFont));
					level1.setBounds(sizeX/3, sizeY/7, sizeX/2, sizeY/20);
					level1.setBorder(BorderFactory.createLineBorder(Color.black));

					level2.setFont(new Font("Times", Font.BOLD,wordFont));
					level2.setBounds(sizeX/3, sizeY*2/7, sizeX/4, sizeY/20);
					level2.setBorder(BorderFactory.createLineBorder(Color.black));

					level3.setFont(new Font("Times", Font.BOLD,wordFont));
					level3.setBounds(sizeX/3, sizeY*3/7, sizeX/4, sizeY/20);
					level3.setBorder(BorderFactory.createLineBorder(Color.black));

					level4.setFont(new Font("Times", Font.BOLD,wordFont));
					level4.setBounds(sizeX/3, sizeY*4/7, sizeX/4, sizeY/20);
					level4.setBorder(BorderFactory.createLineBorder(Color.black));

					level5.setFont(new Font("Times", Font.BOLD,wordFont));
					level5.setBounds(sizeX/3, sizeY*5/7, sizeX/4, sizeY/20);
					level5.setBorder(BorderFactory.createLineBorder(Color.black));
				}
			});
		}
	}
	
	public class scoresFactor extends JPanel{		
		public scoresFactor() {		
			this.setVisible(false);	
			
			addComponentListener(new ComponentAdapter() {
				public void componentResized(ComponentEvent e) {
					int sizeX = e.getComponent().getWidth();
					int sizeY = e.getComponent().getHeight();	
					int wordFont = (int)(0.00010667 * sizeX * sizeY);
					
					scoreFactor1.setFont(new Font("Times", Font.BOLD,wordFont));
					scoreFactor1.setBounds(sizeX/7, sizeY/7, sizeX/2, sizeY/20);
					scoreFactor1.setBorder(BorderFactory.createLineBorder(Color.black));

					scoreFactor2.setFont(new Font("Times", Font.BOLD,wordFont));
					scoreFactor2.setBounds(sizeX*5/7, sizeY/7, sizeX/4, sizeY/20);
					scoreFactor2.setBorder(BorderFactory.createLineBorder(Color.black));

					scoreFactor3.setFont(new Font("Times", Font.BOLD,wordFont));
					scoreFactor3.setBounds(sizeX/7, sizeY*2/7, sizeX/4, sizeY/20);
					scoreFactor3.setBorder(BorderFactory.createLineBorder(Color.black));

					scoreFactor4.setFont(new Font("Times", Font.BOLD,wordFont));
					scoreFactor4.setBounds(sizeX*5/7, sizeY*2/7, sizeX/4, sizeY/20);
					scoreFactor4.setBorder(BorderFactory.createLineBorder(Color.black));

					scoreFactor5.setFont(new Font("Times", Font.BOLD,wordFont));
					scoreFactor5.setBounds(sizeX/7, sizeY*3/7, sizeX/4, sizeY/20);
					scoreFactor5.setBorder(BorderFactory.createLineBorder(Color.black));
					
					scoreFactor6.setFont(new Font("Times", Font.BOLD,wordFont));
					scoreFactor6.setBounds(sizeX*5/7, sizeY*3/7, sizeX/4, sizeY/20);
					scoreFactor6.setBorder(BorderFactory.createLineBorder(Color.black));

					scoreFactor7.setFont(new Font("Times", Font.BOLD,wordFont));
					scoreFactor7.setBounds(sizeX/7, sizeY*4/7, sizeX/4, sizeY/20);
					scoreFactor7.setBorder(BorderFactory.createLineBorder(Color.black));

					scoreFactor8.setFont(new Font("Times", Font.BOLD,wordFont));
					scoreFactor8.setBounds(sizeX*5/7, sizeY*4/7, sizeX/4, sizeY/20);
					scoreFactor8.setBorder(BorderFactory.createLineBorder(Color.black));

					scoreFactor9.setFont(new Font("Times", Font.BOLD,wordFont));
					scoreFactor9.setBounds(sizeX/7, sizeY*5/7, sizeX/4, sizeY/20);
					scoreFactor9.setBorder(BorderFactory.createLineBorder(Color.black));

					scoreFactor10.setFont(new Font("Times", Font.BOLD,wordFont));
					scoreFactor10.setBounds(sizeX*5/7, sizeY*5/7, sizeX/4, sizeY/20);
					scoreFactor10.setBorder(BorderFactory.createLineBorder(Color.black));									
				}
			});
		}
	}
	
	public class sizeFactor extends JPanel{
		int sizeX = 0;
		int sizeY = 0;
		int wordFont = 0;
		public sizeFactor() {
			this.setVisible(false);
			
			addComponentListener(new ComponentAdapter() {
				public void componentResized(ComponentEvent e) {
					sizeX = e.getComponent().getWidth();
					sizeY = e.getComponent().getHeight();	
					wordFont = (int)(0.00010667 * sizeX * sizeY);
									
					setRows.setFont(new Font("Times", Font.BOLD,wordFont));
					setRows.setBounds(sizeX/6, sizeY/5, sizeX/4, sizeY/20);
					setRows.setBorder(null);					
					sr.setFont(new Font("Times", Font.BOLD,wordFont));
					sr.setBounds(sizeX/2, sizeY/5, sizeX/4, sizeY/20);
					sr.setBorder(BorderFactory.createLineBorder(Color.black));
					
					setSize.setFont(new Font("Times", Font.BOLD,wordFont));
					setSize.setBounds(sizeX/3, sizeY*4/5, sizeX/4, sizeY/20);
					setSize.setBorder(BorderFactory.createLineBorder(Color.black));
				}
			});
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.black); 
			g.setFont(new Font("Times", Font.BOLD,wordFont));
			g.drawString("The Column is half of Row.", sizeX/8, sizeY/3);		
		}
	}
	
	public class squareFactor extends JPanel{
		int sizeX;
		int sizeY;
		public squareFactor() {
			this.setVisible(false);					
			addComponentListener(new ComponentAdapter() {
				public void componentResized(ComponentEvent e) {
					sizeX = e.getComponent().getWidth();
					sizeY = e.getComponent().getHeight();
					int wordFont = (int)(0.00010667 * sizeX * sizeY);
					larger.setFont(new Font("Times", Font.BOLD,wordFont));
					larger.setBounds(sizeX/7, sizeY*3/4, sizeX/3, sizeY/15);
					larger.setBorder(BorderFactory.createLineBorder(Color.black));
					
					smaller.setFont(new Font("Times", Font.BOLD,wordFont));
					smaller.setBounds(sizeX/2, sizeY*3/4, sizeX/3, sizeY/15);
					smaller.setBorder(BorderFactory.createLineBorder(Color.black));
				}
			});
		}		
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.green);  
			g.fill3DRect(sizeX/2, sizeY/3,constants.Pixel,constants.Pixel,true);			
		}
	}
}
