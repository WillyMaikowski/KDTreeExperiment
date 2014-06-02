package experiment;

import java.util.List;

import javax.swing.JFrame;

import draw.DrawablePoint;
import KDTree.KDTree;
import KDTree.MeanKDTreeNode;
import KDTree.MedianKDTreeNode;
import KDTree.Point;

public class MainPointVisualization {

	public static void main( String[] args ) {

		int c = 1;
		int n = 10;
		int x = (int) ( c * Math.sqrt( Math.pow( 2, n ) ) ) * 10;
		int y = (int) ( c * Math.sqrt( Math.pow( 2, n ) ) ) * 10;

		List<Point> randomPoints = MainExperiment.generateRandomPoints( c, n );
		List<Point> lowPoints = MainExperiment.generateLowDiscrepancyPoints( c, n );

		JFrame frame = new JFrame( "Random Points" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( x, y );
		frame.add( new DrawablePoint( randomPoints ) );
		frame.setVisible( true );
		
		JFrame frame2 = new JFrame( "Low Discrepancy Points" );
		frame2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame2.setSize( x, y );
		frame2.add( new DrawablePoint( lowPoints ) );
		frame2.setVisible( true );
	}
}
