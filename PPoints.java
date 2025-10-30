import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;

class PPoints {
	
	List<PlotPoint> pts;
	
	PPoints(double[] xt, 	
			double[] yt){
		
		pts = new ArrayList<>();
		
		for (int i = 0; i < xt.length; i++) {
			
			pts.add(
				new PlotPoint(
					xt[i],
					yt[i]
				)
			);
		}	
	}
	
	public void draw(Graphics g) {
		
		for (PlotPoint pt: pts) pt.draw(g);
		
	}
	
}

class PlotPoint {
	
	double 	x, y;
	int SIZE = 5;
	
	PlotPoint(double x, double y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public void draw(Graphics g) {
		
		g.drawOval(
				
			Plotter.offsetX + (int) (Plotter.scale * (x - SIZE/2)),		
			Plotter.offsetY + (int) (Plotter.scale * (y - SIZE/2)),
			(int) (SIZE * Plotter.scale), 
			(int) (SIZE * Plotter.scale)
						
			);

		if (Plotter.PARTY_MODE) {
			this.x += Math.random() - 0.5;
			this.y += Math.random() - 0.5;
		}
	}
	
}
