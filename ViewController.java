import java.awt.event.*;

class ViewController implements KeyListener {
	
	double[] 	xt, yt; 
	
	static double avg(double[] table) {
	
		double result = 0;
		
		for (int i = 0; i < table.length; i++) {
			
			result += table[i];
			
		}
		
		return result/table.length;
	}
	
	ViewController(double[] xt, double[] yt) {
		
		this.xt 	= xt;
		this.yt 	= yt;
		
	}
	
	@Override
	public void keyPressed(KeyEvent l) {
		
		char kP = l.getKeyChar();
		
		int x = 0, y = 0;
		
		switch (kP) {
			
			case 'w':	y = 10;	
						break;
						
			case 'a':	x = 10;	
						break;
						
			case 's':	y = -10; 
						break;
						
			case 'd':	x = -10; 
						break;
						
						
						
			// Special Actions.
						
			case 'r':	Plotter.offsetX = Plotter.WIDTH/2  - (int) (avg(xt) * Plotter.scale);
						Plotter.offsetY = Plotter.HEIGHT/2 - (int) (avg(yt) * Plotter.scale);
						break;
						
			case ' ':	Plotter.PARTY_MODE = !Plotter.PARTY_MODE;
						break;			
		}
		
		Plotter.offsetX += Math.ceil(x/Plotter.scale);
		Plotter.offsetY += Math.ceil(y/Plotter.scale);
	}
	
	@Override
	public void keyReleased(KeyEvent l) {
		
		//System.out.println(l.getKeyChar());
	}
	
	@Override
	public void keyTyped(KeyEvent l) {
		
		//System.out.println(l.getKeyChar());
	}
	
}
