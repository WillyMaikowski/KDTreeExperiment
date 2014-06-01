package experiment;

import java.util.ArrayList;
import java.util.List;

public class StructExperimentContainer {

	private List<Integer> heightContainer;
	private List<Long> timeContainer;
	private List<Integer> sizeContainer;
	private double heightSum;
	private double timeSum;
	private double sizeSum;
	private String kdTreeName;
	private String pointType;
	private int n;
	private int size;

	public StructExperimentContainer( String kdTreeName, String pointType,
	      int size ) {
		this.heightContainer = new ArrayList<Integer>();
		this.timeContainer = new ArrayList<Long>();
		this.sizeContainer = new ArrayList<Integer>();
		this.heightSum = 0.0;
		this.timeSum = 0.0;
		this.sizeSum = 0.0;
		this.kdTreeName = kdTreeName;
		this.pointType = pointType;
		this.n = 0;
		this.size = size;
	}

	public double getAverageHeight() {
		if( this.n > 0 ) return 1.0 * this.heightSum / this.n;
		return 0.0;
	}

	public double getAverageTime() {
		if( this.n > 0 ) return 1.0 * this.timeSum / this.n;
		return 0L;
	}

	public double getAverageSize() {
		if( this.n > 0 ) return 1.0 * this.sizeSum / this.n;
		return 0.0;
	}

	public double getTimeStd() {
		if( n == 0 ) return 0;

		double avg = this.getAverageTime();
		double var = 0;

		for( Long time : this.timeContainer ) {
			var += Math.pow( time - avg, 2 );
		}
		return Math.sqrt( var / this.n );
	}

	public double getheightStd() {
		if( n == 0 ) return 0;

		double avg = this.getAverageHeight();
		double var = 0;

		for( int height : this.heightContainer ) {
			var += Math.pow( height - avg, 2 );
		}
		return Math.sqrt( var / this.n );
	}

	public double getsizeStd() {
		if( n == 0 ) return 0;

		double avg = this.getAverageSize();
		double var = 0;

		for( int size : this.sizeContainer ) {
			var += Math.pow( size - avg, 2 );
		}
		return Math.sqrt( var / this.n );
	}

	public void addObservation( int height, long time, int size ) {
		this.heightContainer.add( height );
		this.timeContainer.add( time );
		this.sizeContainer.add( size );

		this.heightSum += height;
		this.timeSum += time;
		this.sizeSum += size;
		n++;
	}

	public int getNumberOBservations() {
		return this.n;
	}

	public boolean finished() {
		int mayorq = 20;
		// if( this.size > Math.pow( 2, 16 ) ) mayorq = 1;
		return this.n >= mayorq;
		      //&& this.getAverageTime() * 0.05 >= this.getTimeStd();
	}

	/**
	 * NombreAlgoritmo tipoDePuntos size n avgHeight avgTime avgSize stdHeight
	 * stdTime stdSize
	 * 
	 * @return
	 */
	public String getResult() {
		return "[" + this.kdTreeName + "\t" + this.pointType + "\t" + this.size
		      + "\t" + this.n + "\t" + this.getAverageHeight() + "\t"
		      + this.getAverageTime() + "\t" + this.getAverageSize() + "\t"
		      + this.getheightStd() + "\t" + this.getTimeStd() + "\t"
		      + this.getsizeStd() + "\t" + "]";
	}

}
