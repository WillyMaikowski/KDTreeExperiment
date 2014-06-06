package KDTree;

import KDTree.Point;

import java.io.IOException;
import java.util.List;

import recordfile.RecordsFileException;

public interface KDTree extends java.io.Serializable {
	public Point VecinoMasCercano( KDTree T, Point q );

	public Point VecinoMasCercano( Point q );

	public Point VecinoMasCercano( Point q, Point mejorPrevio, double distMejorPrevio );

	public KDTree createLeaf( Point q );

	public KDTree createNode( List<Point> points, Axis axis );

	public int height();
	
	public int getNumAccess();
	
	public int getLenghtOfFile() throws IOException, RecordsFileException;
	
	public void reInitialize();
}
