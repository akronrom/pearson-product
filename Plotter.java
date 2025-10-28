import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.util.Calendar;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.SimpleDateFormat;

class Plotter extends JPanel {
	
	JFrame frame;
	
	int WIDTH 	= 500;
	int HEIGHT 	= 500;
	
	double[] xt, yt; 
	
	float 	scale;
	double 	r;
	String 	msg;
	
	Plotter(double[] xt, 	double[] yt, 
			float scale, 	double 	r, 
			int 	num, 	String msg) {	
	
		this.xt 	= xt;
		this.yt 	= yt;
		this.r 		= r;
		this.msg 	= msg;
		this.scale 	= scale;
	
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		frame = new JFrame();
		
		frame.setTitle("Pearson Coefficient, #" + num);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add(this);
		frame.pack();
		
	}
	
	public static String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat();
		return sdf.format(cal.getTime());
	}
	
	public void paint(Graphics g) {
		
		int SIZE = 5;
		
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
		
		g.drawString("Written by: Gabriel", WIDTH - 125, 25);
		g.drawString(displDeg + ", "+ r, 	25, HEIGHT - 25);			
		g.drawString(now(), 				25, 		 25);	
		
		for (int i = 0; i < xt.length; i++) {
			
			switch (i % 2) {
				
				case 0:	g.fillRect(
				
						WIDTH 	- (int) (xt[i] * scale), 
						HEIGHT 	- (int) (yt[i] * scale),
						
						SIZE, SIZE	// Dimensions
						
						);
						
						break;
					
				case 1: g.drawRect(
				
						WIDTH 	- (int) (xt[i] * scale), 
						HEIGHT 	- (int) (yt[i] * scale),
						
						SIZE, SIZE
						
						);
						
						break;
					
			}
			
			
			
		}
		
		
		
	}
	
	
	
}
