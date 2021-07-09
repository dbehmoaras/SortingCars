package sortingcars;

import java.io.File; // Import the File class
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Simple function that creates a car list in a txt format.
 * @param int: the number of the car list created
 * @return String: the file name so it can be used by the write method
 */
public class GenerateData {
	public static String create(int listNum) {
		try {
			File myObj = new File("carlists/cars-"+listNum+".txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
				return myObj.getName();
			} else {
				System.out.println("File already exists.");
				return myObj.getName();
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			return null;
		}
	}

	public static void write(String fileName, Car car) {
		try {
			String writeToFile = car.getDestination() + "\t" + car.getColor().toString() + "\t" + car.getVin() + "\t"
					+ car.getRecId() + "\n";
			Files.write(Paths.get("carlists/" + fileName), writeToFile.getBytes(), StandardOpenOption.APPEND);
			// System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void clear(String fileName) {
		try {
			Files.write(Paths.get("carlists/" + fileName), "".getBytes());
			System.out.println("Cleared");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
