import java.time.LocalDate;

public class TrainingData {
	
	public final LocalDate date;
	public final double distance;	//Total Distance in km
	public final int minutes;		//Duration in minutes
	public final double speedAvg;	//Speed in km/h
	public final double speedTrain;	//Speed in min/km
	
	public TrainingData(LocalDate date, double distance, int minutes) {
		this.date = date;
		this.distance = distance;
		this.minutes = minutes;
		
		speedAvg = distance / ((double)minutes/60.0);
		speedTrain = (double)minutes / distance;
	}
}
