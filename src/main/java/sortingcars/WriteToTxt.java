package sortingcars;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

/**
 * Basic function that write the car data into a text file
 */
public class WriteToTxt {
	public static void write(String fileName, Car car) {
		try {
			String writeToFile =
				car.getDestination()+"\t"+car.getColor().toString()+
				"\t"+car.getVin()+"\t"+car.getRecId()+"\n";
			Files.write(Paths.get(fileName), writeToFile.getBytes(), StandardOpenOption.APPEND);
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
