package sortingcars;

import java.io.File; // Import the File class
import java.io.IOException;

/**
 * Simple function that creates a car list in a txt format.
 * @param int: the number of the car list created
 * @return String: the file name so it can be used by the write method
 */
public class CreateTxt {
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
}
