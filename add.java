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
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class add extends JFrame{
		
	blocks blocks = new blocks();
	blockArea area = new blockArea();
	
	private int fill3DX = 0;
	private int fill3DY = 0;
	
	private JCheckBox box1 = new JCheckBox();
	private JCheckBox box2 = new JCheckBox();
	private JCheckBox box3 = new JCheckBox();
	private JCheckBox box4 = new JCheckBox();
	private JCheckBox box5 = new JCheckBox();
	private JCheckBox box6 = new JCheckBox();
	private JCheckBox box7 = new JCheckBox();
	private JCheckBox box8 = new JCheckBox();
	
	private JButton select = new JButton("Select");
	private JButton reset = new JButton("Reset");
	
	private int[] flagArray  = new int[8];

	public add() {
		this.setLayout(null);
		this.setTitle("Preference");
		this.setPreferredSize(new Dimension(constants.Pixel * 20,constants.Pixel * 20));
		this.setSize(constants.Pixel * 20,constants.Pixel * 20);
		this.setResizable(false);	
		this.setLocationRelativeTo(null); 
		this.setVisible(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.add(area);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "Click SELECT button to exit!"); 
			}
		});
		
		select.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				for(int i=0;i<8;i++) {
					flagArray[i] = 0;
				}
				constants.secNewShape.clear();
				
				if(box1.isSelected()) {
					flagArray[0] = 1;
				}else {
					flagArray[0] = -1;
				}
				if(box2.isSelected()) {
					flagArray[1] = 1;
				}else {
					flagArray[1] = -1;
				}
				if(box3.isSelected()) {
					flagArray[2] = 1;
				}else {
					flagArray[2] = -1;
				}
				if(box4.isSelected())  {
					flagArray[3] = 1;
				}else {
					flagArray[3] = -1;
				}
				if(box5.isSelected()) {
					flagArray[4] = 1;
				}else {
					flagArray[4] = -1;
				}
				if(box6.isSelected())  {
					flagArray[5] = 1;
				}else {
					flagArray[5] = -1;
				}
				if(box7.isSelected())  {
					flagArray[6] = 1;
				}else {
					flagArray[6] = -1;
				}
				if(box8.isSelected())  {
					flagArray[7] = 1;
				}else {
					flagArray[7] = -1;
				}
							
				for(int i=0;i<8;i++) {
					if(flagArray[i] == 1) {
						constants.secNewShape.add(i);
					}
				}
				int[][][][] temp = new int[constants.secNewShape.size()][4][4][4];
				for(int i=0;i<constants.secNewShape.size();i++) {
					int pos = constants.secNewShape.get(i);	
					temp[i] = blocks.newShape[pos];
				}			
				constants.tempShape = new int[7+temp.length][4][4][4];
				System.arraycopy(blocks.shape, 0, constants.tempShape, 0, 7);
				System.arraycopy(temp, 0, constants.tempShape, 7, temp.length);
				constants.shapeNumber = temp.length;
				setVisible(false);
				
				blocks.newGame();
			}
		});
		
		reset.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				constants.secNewShape.clear();
				box1.setSelected(false);
				box2.setSelected(false);
				box3.setSelected(false);
				box4.setSelected(false);
				box5.setSelected(false);
				box6.setSelected(false);
				box7.setSelected(false);
				box8.setSelected(false);
				
				blocks.newGame();
			}
		});
		
		addComponentListener(new ComponentAdapter()  {
			public void componentResized(ComponentEvent e) {	  
				int sizeX = e.getComponent().getWidth();
				int sizeY = e.getComponent().getHeight();	
				
				area.setLayout(null);
				area.setBackground(Color.white);
				area.setPreferredSize(new Dimension(sizeX,sizeY));
				area.setBounds(0,0,sizeX, sizeY);
				area.setBorder(BorderFactory.createLineBorder(Color.black));
				area.setVisible(true);
				
				area.add(box1);
				area.add(box2);
				area.add(box3);
				area.add(box4);
				area.add(box5);
				area.add(box6);
				area.add(box7);
				area.add(box8);
				
				area.add(select);	
				area.add(reset);
			}
		});
	}
	
	public class blockArea extends JPanel{
		public blockArea() {
			
			addComponentListener(new ComponentAdapter() {
				public void componentResized(ComponentEvent e) {
					int sizeX = e.getComponent().getWidth();
					int sizeY = e.getComponent().getHeight();	
					int wordFont = (int)(0.00008 * sizeX * sizeY);
					box1.setBounds(constants.Pixel,constants.Pixel*2,constants.Pixel, constants.Pixel);
					box1.setBorder(BorderFactory.createLineBorder(Color.black));
					box1.setVisible(true);

					box2.setBounds(constants.Pixel * 11,constants.Pixel*2,constants.Pixel, constants.Pixel);
					box2.setBorder(BorderFactory.createLineBorder(Color.black));
					box2.setVisible(true);
					
					box3.setBounds(constants.Pixel,constants.Pixel*6,constants.Pixel, constants.Pixel);
					box3.setBorder(BorderFactory.createLineBorder(Color.black));
					box3.setVisible(true);
					
					box4.setBounds(constants.Pixel * 11,constants.Pixel*6,constants.Pixel, constants.Pixel);
					box4.setBorder(BorderFactory.createLineBorder(Color.black));
					box4.setVisible(true);
					
					box5.setBounds(constants.Pixel,constants.Pixel*10,constants.Pixel, constants.Pixel);
					box5.setBorder(BorderFactory.createLineBorder(Color.black));
					box5.setVisible(true);

					box6.setBounds(constants.Pixel * 11,constants.Pixel*10,constants.Pixel, constants.Pixel);
					box6.setBorder(BorderFactory.createLineBorder(Color.black));
					box6.setVisible(true);
					
					box7.setBounds(constants.Pixel,constants.Pixel*14,constants.Pixel, constants.Pixel);
					box7.setBorder(BorderFactory.createLineBorder(Color.black));
					box7.setVisible(true);
					
					box8.setBounds(constants.Pixel * 11,constants.Pixel*14,constants.Pixel, constants.Pixel);
					box8.setBorder(BorderFactory.createLineBorder(Color.black));
					box8.setVisible(true);
					
					select.setFont(new Font("Times", Font.BOLD,wordFont));			
					select.setBounds(constants.Pixel * 11,constants.Pixel*17,constants.Pixel*4, constants.Pixel);
					select.setBorder(BorderFactory.createLineBorder(Color.black));
					select.setVisible(true);
					
					reset.setFont(new Font("Times", Font.BOLD,wordFont));
					reset.setBounds(constants.Pixel,constants.Pixel*17,constants.Pixel*4, constants.Pixel);
					reset.setBorder(BorderFactory.createLineBorder(Color.black));
					reset.setVisible(true);
				}				
			});			
		}

		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.green);  
			for(int k=0;k<8;k++) {	
				g.setColor(blocks.color[k]); 
				fill3DX = constants.Pixel * 3 + (k%2) * 10 * constants.Pixel;
				if(k%2 == 0) {				
					fill3DY = constants.Pixel + k * 2 * constants.Pixel;
				}else {
					fill3DY = constants.Pixel + (k-1) * 2 * constants.Pixel;
				}	
				for(int i = 0; i < 3; i++){  
					for(int j = 0; j < 3; j++){  
						if (blocks.newShape[k][0][i][j]==1) {  
							g.fill3DRect(fill3DX+j*constants.Pixel, fill3DY+i*constants.Pixel, constants.Pixel, constants.Pixel,true);                 
						}  
					}  
				}
			}
		}  
	}
}
