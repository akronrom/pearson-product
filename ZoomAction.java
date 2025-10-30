import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

class ZoomAction implements MouseWheelListener {
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent me) {
		
		Plotter.scale = Math.max(Plotter.scale + me.getWheelRotation(), 1);
		
		
	}
		
	
}

