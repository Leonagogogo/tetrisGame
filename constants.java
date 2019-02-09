//package tetris;

import java.awt.Color;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.Timer;

public class constants {
	public static int Pixel = 25;
	
	public static int level = 1;
	public static int lines = 0;
	public static int scores = 0;
	
	public static int row = 20;
	public static int column = 10;
	public static int panelNum = 25;	
	public static int linesNum = 0;
	
	public static boolean pause = false;
	
	public static int timerFac = 700;
	
	public static float speedfactor = (float) 0.1;
	public static int scorefactor = 1;
	
	public static Timer timer = new Timer(700, null);	
	
	public static int drawPanelX = 0;
	public static int drawPanelY = 0;
	
	public static int mainWidth,mainHeight;
	
	public static int setSizeRow = 0;
	public static int setSizeColumn = 0;
	
	public static int moveYpos=0;
	public static int moveXpos=2;
	
	public static int drawPanelWidth = 625;
	public static int drawPanelHeight = 625;
	
	public static ArrayList<Integer> secNewShape = new ArrayList<Integer>();
		
	public static tetrisGame game = new tetrisGame();
	
    public static int[][] map;
    public static Color[][] mapColor;
	
	public static int[][][][] tempShape;
	
	public static int number = 0;
	
	public static int shapeNumber = 0;
	
	public static int tempSquare;
}
