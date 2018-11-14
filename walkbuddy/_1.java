package walkbuddy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;


class WalkArea {
	public int AreaNumber;
}


@SuppressWarnings("unused")
class User {
	private int userID;
	private int userPhoneNumber;
	private String userGender;
	private int userX, userY;
	
	public void putUserX(int x) { this.userX = x; }
	public int getUserX() { return userX; }
	public void putUserY(int y) { this.userY = y; }
	public int getUserY() { return userY; }
}


class Point {
	public int x, y;

	public int getX() { return this.x; }
	public int getY() { return this.y; }
	public char getArea() {
		char area = 97;
			for(int i = 0 ; i < 3 ; i ++){
				for(int j = 0 ; j < 3 ; j++){
					if((this.x > i*230) && (this.x < (i+1) * 230)) {
						if((this.y > j*230) && (this.y < (j+1) * 230))
							break;
					}
				    else 
				    	area++;
				}}
		return area; 
	}
}


class WalkPoint extends Point {
	public int walkPointNumber;
	public String walkPointName;
	
	WalkPoint(int number, String name, int x, int y){
		this.walkPointNumber = number;
		this.walkPointName = name; 
		this.x = x; this.y = y;
	}
}


class Road {
	public int roadNumber;
	public String roadName;
	public Point startPoint, endPoint;
	
	public int getDistance() {
		int x = (this.startPoint.getX() - this.endPoint.getX());
		int y = (this.startPoint.getY() - this.endPoint.getY());
		int distance = (int)Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
		return distance;
	}
}


class Facility extends Point {
	public int facilityNumber;
	public String facilityName;
	
	Facility(int number, String name, int x, int y){
		this.facilityNumber = number;
		this.facilityName = name;
		this.x = x; this.y = y;
	}
	public int getDistanceBetweenpoint(int pointX, int pointY) {
		int x = (this.x - pointX);
		int y = (this.y - pointY);
		int distance = ((int)Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2))));
		return distance;
	}
}


class Toilet extends Facility {
	Toilet(int number, int x, int y){
		super(number, "Toilet", x, y);
	}
}

class VendingMachine extends Facility {
	VendingMachine(int number, int x, int y){
		super(number, "VendingMachine", x, y);
	}
}

class Bench extends Facility {
	Bench(int number, int x, int y){
		super(number, "Bench", x, y);
	}
}

class SnackBar extends Facility {
	SnackBar(int number, int x, int y){
		super(number, "SnackBar", x, y);
	}
}


class DataBase {
	public static Toilet[] toilets = new Toilet[5];
	public static VendingMachine[] vendingMachines = new VendingMachine[5];
	public static Bench[] benchs = new Bench[5];
	public static SnackBar[] snackBars = new SnackBar[5];
	public static WalkPoint[] walkPoints = new WalkPoint[10];
	public DataBase() {
		toilets[0] = new Toilet(11,195,315);	
		toilets[1] = new Toilet(12,358,400);
		toilets[2] = new Toilet(13,169,458);
		toilets[3] = new Toilet(14,424,322);
		toilets[4] = new Toilet(15,498,275);
		vendingMachines[0] = new VendingMachine(21,218,508);
		vendingMachines[1] = new VendingMachine(22,320,511);
		vendingMachines[2] = new VendingMachine(23,440,480);
		vendingMachines[3] = new VendingMachine(24,576,373);
		vendingMachines[4] = new VendingMachine(25,450,256);
		benchs[0] = new Bench(31,289,339);
		benchs[1] = new Bench(32,560,502);
		benchs[2] = new Bench(33,588,377);
		benchs[3] = new Bench(34,203,448);
		benchs[4] = new Bench(35,402,293);
		snackBars[0] = new SnackBar(41,338,511);
		snackBars[1] = new SnackBar(42,531,400);
		snackBars[2] = new SnackBar(43,403,253);
		snackBars[3] = new SnackBar(44,450,267);
		snackBars[4] = new SnackBar(45,220,315);
		walkPoints[0] = new WalkPoint(1,"GlobalPlaza",395,273);
		walkPoints[1] = new WalkPoint(2,"IT1",450,500);
		walkPoints[2] = new WalkPoint(3,"CentralPark",546,546);
		walkPoints[3] = new WalkPoint(4,"TechnPark",480,224);
		walkPoints[4] = new WalkPoint(5,"LargeGround",185,474);
		walkPoints[5] = new WalkPoint(6,"Il-ChungPond",426,436);
		walkPoints[6] = new WalkPoint(7,"Map-Lake",317,466);
		walkPoints[7] = new WalkPoint(8,"Man-Oh-One",221,405);
		walkPoints[8] = new WalkPoint(9,"BusinessColleage-Road",551,412);
		walkPoints[9] = new WalkPoint(10,"Marbling-Park",310,278);
	}
}


@SuppressWarnings("serial")
//road drawing class
class DrawPanel extends JPanel {
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.clearRect(0, 0, 695, 575);
		int xArray0[] = { MainFrame.user.getUserX()-5, MainFrame.point1.x-5, MainFrame.point2.x-5, MainFrame.user.getUserX()-5};
		int yArray0[] = { MainFrame.user.getUserY()-25, MainFrame.point1.y-25, MainFrame.point2.y-25, MainFrame.user.getUserY()-25};
		int xArray1[] = { MainFrame.user.getUserX()-4, MainFrame.point1.x-4, MainFrame.point2.x-4, MainFrame.user.getUserX()-4};
		int yArray1[] = { MainFrame.user.getUserY()-24, MainFrame.point1.y-24, MainFrame.point2.y-24, MainFrame.user.getUserY()-24};
		int xArray2[] = { MainFrame.user.getUserX()-6, MainFrame.point1.x-6, MainFrame.point2.x-6, MainFrame.user.getUserX()-6};
		int yArray2[] = { MainFrame.user.getUserY()-26, MainFrame.point1.y-26, MainFrame.point2.y-26, MainFrame.user.getUserY()-26};
		g.setColor(new Color(240,70,70,255));
		g.drawPolyline(xArray0, yArray0, 4);
		g.drawPolyline(xArray1, yArray1, 4);
		g.drawPolyline(xArray2, yArray1, 4);
		g.drawPolyline(xArray1, yArray2, 4);
		g.drawPolyline(xArray2, yArray2, 4);
		
	}
}


class TimeDelay extends Thread {
	public static void timeDelayfunction() {
		try { Thread.sleep(500); } catch (InterruptedException e) {}
	}
}


@SuppressWarnings("serial")
//for display road
//by paint over clear JFrame 
class RoadFrame extends JFrame {
	public RoadFrame() {
		setLocation(105, 25);
		setSize(695, 575);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		DrawPanel panel = new DrawPanel();
		add(panel);
		setVisible(true);
	}
}


@SuppressWarnings("serial")
class StartFrame extends JFrame {
	// URL image : for image output on export
	URL imageURL0 = getClass().getClassLoader().getResource("backgroundimage.jpg");
	URL imageURL1 = getClass().getClassLoader().getResource("titleimage.jpg");
	URL imageURL2 = getClass().getClassLoader().getResource("knuicon.jpg");
	URL imageURL3 = getClass().getClassLoader().getResource("iconimage1.jpg");
	URL imageURL4 = getClass().getClassLoader().getResource("iconimage2.jpg");
	URL imageURL5 = getClass().getClassLoader().getResource("iconimage3.jpg");
	JLabel titleLabel = new JLabel(new ImageIcon(imageURL0));
	JLabel titleImageLabel = new JLabel(new ImageIcon(imageURL1));
	JLabel knuIconLabel = new JLabel(new ImageIcon(imageURL2));
	JLabel iconImageLabel1 = new JLabel(new ImageIcon(imageURL3));
	JLabel iconImageLabel2 = new JLabel(new ImageIcon(imageURL4));
	JLabel iconImageLabel3 = new JLabel(new ImageIcon(imageURL5));
	
	public StartFrame() {
		setUndecorated(true);
		setSize(600, 280); 
		setLocation(150,350); // Ã¢ ¶ß´Â À§Ä¡ 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Âü ´ÝÈ÷¸é ÇÁ·Î¼¼½ºµµ Á¾·á
		setLayout(null);

		titleLabel.setBounds(0, 0, 600, 280);
		titleImageLabel.setBounds(145, 50, 450, 100);
		knuIconLabel.setBounds(345, 180, 220, 50);
		iconImageLabel1.setBounds(20, 20, 150, 250);
		iconImageLabel2.setBounds(20, 20, 150, 250);
		iconImageLabel3.setBounds(20, 20, 150, 250);
		iconImageLabel1.setVisible(false);
		iconImageLabel2.setVisible(false);
		iconImageLabel3.setVisible(false);
		titleLabel.add(titleImageLabel);
		titleLabel.add(knuIconLabel);
		titleLabel.add(iconImageLabel1);
		titleLabel.add(iconImageLabel2);
		titleLabel.add(iconImageLabel3);
		
		add(titleLabel); 
		setVisible(true);
		TimeDelay.timeDelayfunction();
		for(int i = 0; i<2; i++) {
			iconImageLabel3.setVisible(false);
			iconImageLabel1.setVisible(true);
			TimeDelay.timeDelayfunction();
			iconImageLabel1.setVisible(false);
			iconImageLabel2.setVisible(true);
			TimeDelay.timeDelayfunction();
			iconImageLabel2.setVisible(false);
			iconImageLabel3.setVisible(true);
			TimeDelay.timeDelayfunction();	
		}
		TimeDelay.timeDelayfunction();
		setVisible(false);
	}
}


@SuppressWarnings("serial")
class MainFrame extends JFrame {
	
	static User user = new User();
	int stageFlag = 1;
	boolean locationFlag = false, distanceFlag;
	double userInput, distance, time;
	static WalkPoint point1, point2;
	
	JLayeredPane layeredPane = new JLayeredPane();
	Font font1 = new Font("³ª´®½ºÄù¾î",Font.BOLD, 20);
	URL imageURL1 = getClass().getClassLoader().getResource("Map image.jpg");
	JLabel mapLabel = new JLabel(new ImageIcon(imageURL1));
	URL imageURL2 = getClass().getClassLoader().getResource("Lined Map image.jpg");
	JLabel linedMapLabel = new JLabel(new ImageIcon(imageURL2));
	URL imageURL3 = getClass().getClassLoader().getResource("Status image.jpg");
	JLabel statusLabel = new JLabel(new ImageIcon(imageURL3));
	URL imageURL4 = getClass().getClassLoader().getResource("toiletimage.jpg");
	JLabel toilet = new JLabel(new ImageIcon(imageURL4));
	URL imageURL5 = getClass().getClassLoader().getResource("vendingmachineimage.jpg");
	JLabel vendingMachine = new JLabel(new ImageIcon(imageURL5));
	URL imageURL6 = getClass().getClassLoader().getResource("benchimage.jpg");
	JLabel bench = new JLabel(new ImageIcon(imageURL6));
	URL imageURL7 = getClass().getClassLoader().getResource("snackbarimage.jpg");
	JLabel snackBar = new JLabel(new ImageIcon(imageURL7));
	URL imageURL8 = getClass().getClassLoader().getResource("explainimage.png");
	JLabel explainImageLabel = new JLabel(new ImageIcon(imageURL8));
	URL imageURL9 = getClass().getClassLoader().getResource("userpoint.png");
	JLabel userPoint = new JLabel(new ImageIcon("./image/userpoint.png")); 
	JLabel[] pointLabel = new JLabel[10];
	URL imageURL10 = getClass().getClassLoader().getResource("okbutton.jpg");
	JButton okButton = new JButton(new ImageIcon(imageURL10));
	URL imageURL11 = getClass().getClassLoader().getResource("nextbutton.jpg");
	JButton nextButton = new JButton(new ImageIcon(imageURL11));
	URL imageURL12 = getClass().getClassLoader().getResource("backbutton.jpg");
	JButton backButton = new JButton(new ImageIcon(imageURL12));
	URL imageURL13 = getClass().getClassLoader().getResource("distancebutton.jpg");
	JButton distanceButton = new JButton(new ImageIcon(imageURL13));
	URL imageURL14 = getClass().getClassLoader().getResource("timebutton.jpg");
	JButton timeButton = new JButton(new ImageIcon(imageURL14));
	JTextField userInputTextField  = new JTextField(3);

	JLabel commentLabel1 = new JLabel("Hello! I¡¯m Walk Buddy!");
	JLabel commentLabel2 = new JLabel("I show you the Walking trails you want!");
	JLabel commentLabel3 = new JLabel("");
	JLabel errorcommentLabel = new JLabel("- Invalid input value!");
	
	Toolkit kit = Toolkit.getDefaultToolkit();
	URL imageURL15 = getClass().getClassLoader().getResource("icon.png");
	Image img = kit.getImage(imageURL15);
	
	@SuppressWarnings("deprecation")
	public MainFrame() {
		
		//Defalut value for preventing roadframe error
		user.putUserX(0);user.putUserY(0);
		point1 = DataBase.walkPoints[0];
		point2 = DataBase.walkPoints[0];
		RoadFrame roadframe = new RoadFrame();
		roadframe.setVisible(false);
		setResizable(false);
		setIconImage(img);
		setSize(700, 800); 
		setTitle("Walk Buddy"); 
		setBackground(Color.WHITE); 
		setLocation(100,0); // Ã¢ ¶ß´Â À§Ä¡ 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // process exit
		setLayout(null);
		
		layeredPane.setOpaque(true);  
		layeredPane.setBackground(Color.WHITE); 
		layeredPane.setBounds(0, 0, 699, 799);
		
		mapLabel.setBounds(5, 0, 680, 650);
		linedMapLabel.setBounds(6, 0, 680, 650);
		linedMapLabel.setVisible(false);
		statusLabel.setBounds(0, 600,690, 200);
		explainImageLabel.setBounds(10, 10, 280, 50);
		explainImageLabel.setVisible(false);
		commentLabel1.setBounds(90, 670, 400, 30);
		commentLabel2.setBounds(90, 700, 400, 30);
		commentLabel1.setFont(font1);
		commentLabel2.setFont(font1);
		commentLabel3.setFont(font1);
		commentLabel3.setVisible(false);
		userInputTextField.setBounds(90, 700, 60, 30);
		userInputTextField.setFont(font1);
		userInputTextField.setVisible(false);
		userInputTextField.setHorizontalAlignment(JTextField.RIGHT);
		userInputTextField.addKeyListener((KeyListener) new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				JTextField textField = (JTextField) k.getSource();
				if(textField.getText().length()>=3) k.consume();
		}});
		
		URL imageURL16 = getClass().getClassLoader().getResource("okbutton1.jpg");
		okButton.setRolloverIcon(new ImageIcon(imageURL16)); 
		okButton.setBorderPainted(false); 
		okButton.setBounds(580,645, 100, 42); 
		okButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					if(stageFlag == 1) {
						okButton.setVisible(false);
						commentLabel1.setVisible(false);
						commentLabel2.setVisible(false);
						commentLabel1 = new JLabel("Please click your location.");
						commentLabel1.setBounds(90, 685, 400, 30);
						commentLabel1.setFont(font1);
						layeredPane.add(commentLabel1, new Integer(2));
						mapLabel.setVisible(false);
						linedMapLabel.setVisible(true);
						stageFlag = 2;
					}
					if(stageFlag == 5) {
						System.exit(0);
					}
				}});
		nextButton.setVisible(false);
		URL imageURL17 = getClass().getClassLoader().getResource("nextbutton1.jpg");
		nextButton.setRolloverIcon(new ImageIcon(imageURL17)); 
		nextButton.setBorderPainted(false); 
		nextButton.setBounds(580,645, 100, 42); 
		nextButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					switch(stageFlag) {
					case 2: {
						linedMapLabel.setVisible(false);
						mapLabel.setVisible(true);
						commentLabel1.setVisible(false);
						commentLabel1 = new JLabel("Please choose you want to know");
						commentLabel2 = new JLabel("by Time or Distance.");
						commentLabel1.setBounds(120, 670, 400, 30);
						commentLabel2.setBounds(120, 700, 400, 30);
						commentLabel1.setFont(font1);
						commentLabel2.setFont(font1);
						layeredPane.add(commentLabel1, new Integer(2));
						layeredPane.add(commentLabel2, new Integer(2));
						nextButton.setVisible(false);
						timeButton.setVisible(true);
						distanceButton.setVisible(true);
						explainImageLabel.setVisible(true);
						displayNearFacility();
						stageFlag = 3;
						locationFlag = true;
						break;
					}
					case 4 : {
						try {
							if(distanceFlag) {
								userInput = 500*Double.parseDouble(userInputTextField.getText());
							}
							else {
								userInput = 31.25*Double.parseDouble(userInputTextField.getText());
							}
							errorcommentLabel.setVisible(false);
							nextButton.setVisible(false);
							okButton.setVisible(true);
							commentLabel1.setVisible(false);
							commentLabel2.setVisible(false);
							userInputTextField.setVisible(false);
							calculateRoad();
							commentLabel1 = new JLabel("Here is the Walking trails you want!");
							commentLabel2 = new JLabel("Total distance is "+distance+"km ");
							commentLabel3 = new JLabel("and estimated time is "+time+"minute.");
							commentLabel1.setBounds(100, 655, 400, 30);
							commentLabel2.setBounds(100, 685, 400, 30);
							commentLabel3.setBounds(100, 715, 400, 30);
							commentLabel1.setFont(font1);
							commentLabel2.setFont(font1);
							commentLabel3.setFont(font1);
							layeredPane.add(commentLabel1, new Integer(2));
							layeredPane.add(commentLabel2, new Integer(2));
							layeredPane.add(commentLabel3, new Integer(2));
							stageFlag = 5;
							roadframe.repaint();
							roadframe.setVisible(true);
							roadframe.setAlwaysOnTop(true);
						} catch(NumberFormatException e1) {
							errorcommentLabel.setVisible(true);
							errorcommentLabel.setForeground(Color.red);
							errorcommentLabel.setBounds(245, 710, 150, 10);
							layeredPane.add(errorcommentLabel, new Integer(2));
						}
						break;
					}
					default : break;
		}}});
		backButton.setVisible(false);
		URL imageURL18 = getClass().getClassLoader().getResource("backbutton1.jpg");
		backButton.setRolloverIcon(new ImageIcon(imageURL18)); 
		backButton.setBorderPainted(false); 
		backButton.setBounds(580,715, 100, 42); 
		backButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					switch(stageFlag) {
					case 4: {
						mapLabel.setVisible(false);
						linedMapLabel.setVisible(true);
						commentLabel1.setVisible(false);
						commentLabel2.setVisible(false);
						commentLabel1 = new JLabel("Please click your location.");
						commentLabel1.setBounds(90, 685, 400, 30);
						commentLabel1.setFont(font1);
						layeredPane.add(commentLabel1, new Integer(2));
						backButton.setVisible(false);
						nextButton.setVisible(true);
						userInputTextField.setVisible(false);
						errorcommentLabel.setVisible(false);
						toilet.setVisible(false);
						vendingMachine.setVisible(false);
						snackBar.setVisible(false);
						bench.setVisible(false);
						for(int i = 0; i < 10; i++) {
							pointLabel[i].setVisible(false);
						}
						stageFlag = 2;
						locationFlag = false;
						break;	
					}
					case 5 : {
						mapLabel.setVisible(false);
						linedMapLabel.setVisible(true);
						explainImageLabel.setVisible(false);
						commentLabel1.setVisible(false);
						commentLabel2.setVisible(false);
						commentLabel3.setVisible(false);
						commentLabel1 = new JLabel("Please click your location.");
						commentLabel1.setBounds(90, 685, 400, 30);
						commentLabel1.setFont(font1);
						layeredPane.add(commentLabel1, new Integer(2));
						okButton.setVisible(false);
						backButton.setVisible(false);
						nextButton.setVisible(true);
						toilet.setVisible(false);
						vendingMachine.setVisible(false);
						snackBar.setVisible(false);
						bench.setVisible(false);
						for(int i = 0; i < 10; i++) {
							pointLabel[i].setVisible(false);
						}
						stageFlag = 2;
						locationFlag = false;
						roadframe.setAlwaysOnTop(false);
						roadframe.setVisible(false);
						break;	
					}
					default : break;
		}}});
		timeButton.setVisible(false);
		URL imageURL19 = getClass().getClassLoader().getResource("timebutton1.jpg");
		timeButton.setRolloverIcon(new ImageIcon(imageURL19)); 
		timeButton.setBorderPainted(false); 
		timeButton.setBounds(580,645, 100, 42); 
		timeButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					if(stageFlag == 3) {
						timeButton.setVisible(false);
						distanceButton.setVisible(false);
						nextButton.setVisible(true);
						commentLabel1.setVisible(false);
						commentLabel2.setVisible(false);
						userInputTextField.setVisible(true);
						commentLabel1 = new JLabel("How Long do you want to walk?");
						commentLabel2 = new JLabel(":            minute");
						commentLabel1.setBounds(80, 670, 330, 30);
						commentLabel2.setBounds(80, 700, 300, 30);
						commentLabel1.setFont(font1);
						commentLabel2.setFont(font1);
						for(int i = 0; i < 10; i++) {
							pointLabel[i].setVisible(true);
						}
						layeredPane.add(commentLabel1, new Integer(2));
						layeredPane.add(commentLabel2, new Integer(2));
						commentLabel2.setVisible(true);
						backButton.setVisible(true);
						stageFlag = 4;
						distanceFlag = false;
		}}});
		distanceButton.setVisible(false);
		URL imageURL20 = getClass().getClassLoader().getResource("distancebutton1.jpg");
		distanceButton.setRolloverIcon(new ImageIcon(imageURL20)); 
		distanceButton.setBorderPainted(false); 
		distanceButton.setBounds(580,715, 100, 42); 
		distanceButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					if(stageFlag == 3) {
						timeButton.setVisible(false);
						distanceButton.setVisible(false);
						nextButton.setVisible(true);
						commentLabel1.setVisible(false);
						commentLabel2.setVisible(false);
						userInputTextField.setVisible(true);
						commentLabel1 = new JLabel("How Far do you want to walk?");
						commentLabel2 = new JLabel(":            km");
						commentLabel1.setBounds(80, 670, 330, 30);
						commentLabel2.setBounds(80, 700, 300, 30);
						commentLabel1.setFont(font1);
						commentLabel2.setFont(font1);
						for(int i = 0; i < 10; i++) {
							pointLabel[i].setVisible(true);
						}
						layeredPane.add(commentLabel1, new Integer(2));
						layeredPane.add(commentLabel2, new Integer(2));
						backButton.setVisible(true);
						stageFlag = 4;
						distanceFlag = true;
		}}});
		addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e){
				if((locationFlag == false) && (stageFlag == 2) && (e.getY() <= 650)) {
					user.putUserX(e.getX()); 
					user.putUserY(e.getY());
					userPoint.setBounds(user.getUserX()-20, user.getUserY()-71, 35, 45);
					layeredPane.add(userPoint, new Integer(4));
					add(layeredPane);
					nextButton.setVisible(true);
		}}});	
		
		layeredPane.add(linedMapLabel, new Integer(0));
		layeredPane.add(mapLabel, new Integer(0));
		layeredPane.add(statusLabel, new Integer(1));
		layeredPane.add(explainImageLabel, new Integer(2));
		layeredPane.add(okButton, new Integer(2));layeredPane.add(nextButton, new Integer(2));
		layeredPane.add(backButton, new Integer(2));layeredPane.add(timeButton, new Integer(2));
		layeredPane.add(distanceButton, new Integer(2));
		layeredPane.add(commentLabel1, new Integer(2));layeredPane.add(commentLabel2, new Integer(2));
		layeredPane.add(userInputTextField, new Integer(2));
		
		for(int i = 0; i < 10; i++) {
			URL imageURL21 = getClass().getClassLoader().getResource("pointimage.png");
			pointLabel[i] = new JLabel(new ImageIcon(imageURL21));
			pointLabel[i].setBounds(DataBase.walkPoints[i].x-13, DataBase.walkPoints[i].y-50, 18, 24);
			pointLabel[i].setVisible(false);
			layeredPane.add(pointLabel[i], new Integer(3));
		}
		
		add(layeredPane); setVisible(true);
	}
	@SuppressWarnings("deprecation")
	public void displayNearFacility() {
		int[] a = {0, 0, 0, 0};
		for(int i = 0; i< DataBase.toilets.length; i ++) {
			if(i == 0) 
				a[0] = i;
			else if( DataBase.toilets[i].getDistanceBetweenpoint(user.getUserX(), user.getUserY()) 
						< DataBase.toilets[a[0]].getDistanceBetweenpoint(user.getUserX(), user.getUserY())) 
				a[0] = i;
		}
		for(int i = 0; i< DataBase.vendingMachines.length; i ++) {
			if(i == 0) 
				a[1] = i;
			else if( DataBase.vendingMachines[i].getDistanceBetweenpoint(user.getUserX(), user.getUserY())
					< DataBase.vendingMachines[a[1]].getDistanceBetweenpoint(user.getUserX(), user.getUserY())) 
				a[1] = i;
		}
		for(int i = 0; i< DataBase.benchs.length; i ++) {
			if(i == 0) 
				a[2] = i;
			else if( DataBase.benchs[i].getDistanceBetweenpoint(user.getUserX(), user.getUserY())
					< DataBase.benchs[a[2]].getDistanceBetweenpoint(user.getUserX(), user.getUserY())) 
				a[2] = i;
		}
		for(int i = 0; i< DataBase.snackBars.length; i ++) {
			if(i == 0) 
				a[3] = i;
			else if( DataBase.snackBars[i].getDistanceBetweenpoint(user.getUserX(), user.getUserY())
					< DataBase.snackBars[a[3]].getDistanceBetweenpoint(user.getUserX(), user.getUserY())) 
				a[3] = i;
		}
		toilet.setBounds(DataBase.toilets[a[0]].x-13, DataBase.toilets[a[0]].y-13, 26, 26);
		vendingMachine.setBounds(DataBase.vendingMachines[a[1]].x-13, DataBase.vendingMachines[a[1]].y-13, 26, 26);
		bench.setBounds(DataBase.benchs[a[2]].x-13, DataBase.benchs[a[2]].y-13, 26, 26);
		snackBar.setBounds(DataBase.snackBars[a[3]].x-13, DataBase.snackBars[a[3]].y-13, 26, 26);
		layeredPane.add(toilet, new Integer(3));
		layeredPane.add(vendingMachine, new Integer(3));
		layeredPane.add(bench, new Integer(3));
		layeredPane.add(snackBar, new Integer(3));
		toilet.setVisible(true);
		vendingMachine.setVisible(true);
		snackBar.setVisible(true);
		bench.setVisible(true);
		userPoint.setVisible(false);
		userPoint.setVisible(true);
	}
	public void calculateRoad() {
		double min = 0;
		int first = 0, second = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {// use Pythagorean theorem
				if(i == 0 && j == 0) {
					min = Math.abs(userInput
					- (Math.sqrt(Math.pow(user.getUserX()-DataBase.walkPoints[i].x, 2)
						+Math.pow(user.getUserY()-DataBase.walkPoints[i].y, 2))
					+ Math.sqrt(Math.pow(DataBase.walkPoints[j].x-DataBase.walkPoints[i].x, 2)
						+Math.pow(DataBase.walkPoints[j].y-DataBase.walkPoints[i].y, 2))
					+ Math.sqrt(Math.pow(user.getUserX()-DataBase.walkPoints[j].x, 2)
						+Math.pow(user.getUserY()-DataBase.walkPoints[j].y, 2))));
					first = i; second = j;
				}
				else {
					if( min > Math.abs(userInput
				
							- (Math.sqrt(Math.pow(user.getUserX()-DataBase.walkPoints[i].x, 2)
									+Math.pow(user.getUserY()-DataBase.walkPoints[i].y, 2))
							+ Math.sqrt(Math.pow(DataBase.walkPoints[j].x-DataBase.walkPoints[i].x, 2)
									+Math.pow(DataBase.walkPoints[j].y-DataBase.walkPoints[i].y, 2))
							+ Math.sqrt(Math.pow(user.getUserX()-DataBase.walkPoints[j].x, 2)
									+Math.pow(user.getUserY()-DataBase.walkPoints[j].y, 2))))&&(i != j)){
						min = Math.abs(userInput
							- (Math.sqrt(Math.pow(user.getUserX()-DataBase.walkPoints[i].x, 2)
									+Math.pow(user.getUserY()-DataBase.walkPoints[i].y, 2))
							+ Math.sqrt(Math.pow(DataBase.walkPoints[j].x-DataBase.walkPoints[i].x, 2)
									+Math.pow(DataBase.walkPoints[j].y-DataBase.walkPoints[i].y, 2))
							+ Math.sqrt(Math.pow(user.getUserX()-DataBase.walkPoints[j].x, 2)
									+Math.pow(user.getUserY()-DataBase.walkPoints[j].y, 2))));
						first = i; second = j;
					}
				}
			}
		}
		point1 = DataBase.walkPoints[first];
		point2 = DataBase.walkPoints[second];
		distance = Double.parseDouble(String.format("%.2g%n", (Math.sqrt(Math.pow(user.getUserX()-DataBase.walkPoints[first].x, 2)
				+Math.pow(user.getUserY()-DataBase.walkPoints[first].y, 2))
		+ Math.sqrt(Math.pow(DataBase.walkPoints[second].x-DataBase.walkPoints[first].x, 2)
				+Math.pow(DataBase.walkPoints[second].y-DataBase.walkPoints[first].y, 2))
		+ Math.sqrt(Math.pow(user.getUserX()-DataBase.walkPoints[second].x, 2)
				+Math.pow(user.getUserY()-DataBase.walkPoints[second].y, 2)))/500));
		time = Double.parseDouble(String.format("%.2g%n", (distance*16)));
	}
}

public class _1 {
	public static void main(String[] args) {
		new DataBase();
		new StartFrame();
		new MainFrame();
		
	}
}