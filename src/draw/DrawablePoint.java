package draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import KDTree.Point;
import java.util.List;

import javax.swing.JPanel;

public class DrawablePoint extends JPanel {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	private List<Point> p;

	public DrawablePoint( List<Point> p ) {
		this.p = p;
	}

	public void paintComponent( Graphics g ) {
		super.paintComponent( g );

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor( Color.red );
		for( Point point : p ) {
			g2d.drawOval( (int) point.getX() * 10, (int) point.getY() * 10, 5, 5 );
		}
	}
}
