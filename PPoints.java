
class PPoints {
	
	List<PlotPoint> pts;
	
	PPoints(double[] xt, 	double[] yt,
			float scale){
		
		pts = new ArrayList<>();
		
		for (int i = 0; i < xt.length; i++) {
			
			pts.add(
				new PlotPoint(
					xt[i] * scale,
					yt[i] * scale
				)
			);
		}	
	}
	
	public void draw(Graphics g) {
		
		for (PlotPoint pt: pts) {
			
			pt.draw(g);
			
		}
		
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
		
		g.drawRect(
				
			(int) (x - SIZE/2),		
			(int) (y - SIZE/2),
			SIZE, SIZE
						
		);
		
	}
	
}
