import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Calendar;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.SimpleDateFormat;

// Listeners for User Inputs.
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelListener;

public class Plotter extends JPanel {

	JFrame frame;
	
	static int 	WIDTH  = 300;
	static int 	HEIGHT = 300;
	
	static float scale;
	
	static int 	offsetX;
	static int 	offsetY;
	double[] 	xt, yt; 
	String 		msg;
	
	double 		r;
	
	PPoints 	points;
	
	static boolean PARTY_MODE = false;
	
	Plotter(double[] xt, 	double[] yt, 
			float scale, 	double 	r, 
			int 	num, 	String msg) {	
	
		this.xt 	= xt;
		this.yt 	= yt;
		this.r	 	= r;
		this.msg 	= msg;
		this.scale 	= scale;
	
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		frame = new JFrame();
		
		frame.setTitle("Pearson Coefficient, #" + num);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
		frame.setAlwaysOnTop(true);
		frame.add(this);
		frame.pack();
		
		points = new PPoints(xt, yt);
		
		frame.addKeyListener(new ViewController(xt, yt));
		addMouseWheelListener(new ZoomAction());
		 
	}
	
	public static String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat();
		return sdf.format(cal.getTime());
	}
	
	public void paint(Graphics g) {
		
		String displDeg = "";
		
		switch ((int) Math.round(4 * r)) {
			
			case -4	: 	displDeg = "Very Highly Negative";
						break;
						
			case -3	: 	displDeg = "Highly Negative";
						break;
						
			case -2	: 	displDeg = "Moderately Negative";
						break;
			
			case -1	: 	displDeg = "Low Negative";
						break;
					 
			case 0	: 	displDeg = "No correlation.";
						break;
						
			case 1	: 	displDeg = "Low Positive";
						break;
						
			case 2	: 	displDeg = "Moderately Positive";
						break;
						
			case 3	: 	displDeg = "Highly Positive";
						break;

			case 4	: 	displDeg = "Very Highly Positive";
						break;
			
		}
		
		g.setColor(Color.LIGHT_GRAY);
		
		g.drawLine(
			WIDTH/2, 0,
			WIDTH/2, HEIGHT
			);
			
		g.drawLine(
			0, HEIGHT/2,
			WIDTH, HEIGHT/2
			);
					
		
		g.setColor(Color.BLACK);
		
		g.drawString("Written by: Gabriel", WIDTH - 125, 25);
		g.drawString(displDeg + " ("+r+")", 25, HEIGHT - 25);			
		g.drawString(now(), 				25, 		 25);	
		
		points.draw(g);
		
		frame.repaint();
		
		
	}
	
	
	
}
