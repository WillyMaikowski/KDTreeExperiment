package experiment;

import java.util.ArrayList;
import java.util.List;

public class SecondaryMemoryExperimentContainer extends StructExperimentContainer{

	
	private List<Integer> accessContainer;
	private double accessSum;
	
	public SecondaryMemoryExperimentContainer( String kdTreeName,
         String pointType, int size ) {
	   super( kdTreeName, pointType, size );
	   this.accessContainer = new ArrayList<Integer>();
	   accessSum=0;
   }
	
	
	public void addObservation( int height, long time, int size, int numAccess ) {
		super.addObservation( height, time, size );
		this.accessContainer.add( numAccess );
		this.accessSum += numAccess;
	}
	
	public double getAverageAccess() {
		if( this.getNumberOBservations() > 0 ) return 1.0 * this.accessSum / this.getNumberOBservations();
		return 0.0;
	} 
	
	public boolean finished() {
		int mayorq = 1;
		return this.getNumberOBservations() >= mayorq;
	}
	
	public double getAccessStd() {
		if( this.getNumberOBservations() == 0 ) return 0;
		double avg = this.getAverageAccess();
		double var = 0;

		for( int access : this.accessContainer ) {
			var += Math.pow( access - avg, 2 );
		}
		return Math.sqrt( var / this.getNumberOBservations() );
	}
	
	public String toString(){
		return super.toString()+ "\t" + this.getAverageAccess()+"\t"+this.getAccessStd();
	}
	
	

}
