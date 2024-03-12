import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;

public class CsvReader {
	
	public static final String SEPERATOR = ";";
	
	/*
	 * Reads a CSV-File and returns a LinkedList of TrainingData objects
	 * parsed from the text found. 
	 * If the file cannot be read, returns null.
	 * Invalid lines are ignored.
	 * If text cannot be parsed, returns an empty list.
	 */
	public static LinkedList<TrainingData> readFromFile(File file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			LinkedList<TrainingData> data = new LinkedList<TrainingData>();
			String line;
			while ((line = reader.readLine()) != null) {
				TrainingData td = getTrainingDataFromCSV(line);
				if (td != null)
					data.add(td);
			}
			return data;
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Converts a single line of CSV-Data into a TrainingData obj.
	 * If conversion is not possible, returns null
	 */
	/*
	 * Diese Methode hätte ich mir eher als statische Factory-Methode
	 * in TrainingData gewünscht. Dann ist dort alles, was zur TrainingData gehört.
	 */
	private static TrainingData getTrainingDataFromCSV(String line) {
		String[] data = line.split(SEPERATOR);
		
		if (data.length < 3) {
			System.err.println("Data corrupt: " + line);
			return null;
		}
		if (data.length > 3)
			System.err.println("Unexpected Data: " + line);
		
		try {
			/*
			 * gut recherchiert! Das spart Coding-Time und reduziert Fehler. Prima!
			 */
			LocalDate date = LocalDate.parse(data[0]);
			double distance = Double.valueOf(data[1]);
			int minutes = Integer.valueOf(data[2]); 
			
			return new TrainingData(date, distance, minutes);
			
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
