import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	
	public static void main(String[] args) {
		// Habs mit relativem Pfad versucht, aber hat nicht funktioniert.
		/*
		 * Da ist Eclipse die Bitch. Ich zeige euch das beim Thema GUI.
		 * Liegt tatsächlich nicht an Java, sondern an Eclipse ;-)
		 */
		File file = new File("H:/Eclipse/Marathontraining/CSV.csv");
		List<TrainingData> dataSet = CsvReader.readFromFile(file);
		
		Map<String, Double> results = analyseData(dataSet);
		
		System.out.println("Total Distance: \t\t" + results.get("totalDistance") + " km");
		System.out.println("Maximum single Distance: \t" + results.get("maxDistance") + " km");
		System.out.println("Best Speed: \t\t" + results.get("bestSpeed") + " min/km");
		System.out.println("Average Speed: \t\t" + results.get("avgSpeed") + " min/km");
		
	}
	
	/*
	 * sehr schön, dass du das hier mit einer Map implementierst.
	 * Experimentierfreude ist vorhanden und dazu die passende Kompetenz, das
	 * auch ans Ziel zu führen. Weiter so!
	 */
	private static Map<String, Double> analyseData(List<TrainingData> dataSet) {
		double totalDistance = 0;
		double maxDistance = 0;
		double bestSpeed = Double.MAX_VALUE;
		double avgSpeed = 0;
		
		for (TrainingData element : dataSet) {
			totalDistance += element.distance;
			
			if (maxDistance < element.distance) {
				maxDistance = element.distance;
			}
				
			if (bestSpeed > element.speedTrain) {
				bestSpeed = element.speedTrain;
			}
			
			avgSpeed += element.speedTrain;
		}
		avgSpeed = avgSpeed / (double)dataSet.size();
		
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("totalDistance", totalDistance);
		map.put("maxDistance", maxDistance);
		map.put("bestSpeed", bestSpeed);
		map.put("avgSpeed", avgSpeed);
		return map;
	}

	/*
	 * sehr schöner, klar strukturierter, einfacher und kurzer Code!
	 * So lese ich Code unheimlich gerne! Einfach schön zu lesen!
	 * Prima, weiter so, alles bestens!
	 */
}
