package project;

public class NegativeWeightCycleException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NegativeWeightCycleException () {
		super ();
	}
	
	public String message (String message){
		return message;
	}

}
