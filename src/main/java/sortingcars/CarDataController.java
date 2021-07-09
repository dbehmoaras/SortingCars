package sortingcars;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;


import java.util.LinkedList;
import sortingcars.Car.Color;

/**
 * Simple function that creates a car list in a txt format.
 * @param int: the number of the car list created
 * @return String: the file name so it can be used by the write method
 */
public class CarDataController {

	private static String[] fileList;
	private static String[] sortedFileList;
	private static int numLists;

	/**
	 * Creates the text file. There is a better way to handle
	 * the sorted option (ie overloading methods) but this way
	 * is easier to implement and efficient to run.
	 * @param listNum
	 * @param sorted: boolean option. true if writing sorted
	 * data, false otherwise
	 * @return
	 */
	public static String createFile(int listNum, boolean sorted){
		try {
			if (sorted){
				File myObj = new File("carlists/carssorted-" + listNum + ".txt");
				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
					return myObj.getName();
				} else {
					System.out.println("File already exists.");
					return myObj.getName();
				}
			} else {
				File myObj = new File("carlists/cars-"+listNum+".txt");
				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
					return myObj.getName();
				} else {
					System.out.println("File already exists.");
					return myObj.getName();
				}
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * creates the lists and returns an array containing the
	 * names of each file stored in the system based on the
	 * sorted boolean option.
	 * @param numOfLists
	 * @param sorted: boolean option. true if writing sorted
	 * data, false otherwise
	 * @return
	 */
	public static String[] createFiles(int numOfLists, boolean sorted){
		numLists = numOfLists;
		if (sorted) {
			String[] localSortedFileList = new String[numOfLists];
			for (int i = 0; i < numOfLists; i += 1){
				localSortedFileList[i] = createFile(i, true);
			}
			return localSortedFileList;
		} else {
			String[] localFileList = new String[numOfLists];
			for (int i = 0; i < numOfLists; i += 1) {
				localFileList[i] = createFile(i, false);
			}
			return localFileList;
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

	/**
	 * clears the file by its name passed in
	 * @param fileName
	 */
	public static void clear(String fileName){
		try {
			Files.write(Paths.get("carlists/" + fileName), "".getBytes());
			System.out.println("Cleared");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * clears all files passed in through the fileList array
	 * @param fileList
	 */
	public static void clearAll(String[] fileList) {
		try {
			for (int i = 0; i < fileList.length; i += 1) {
				Files.write(Paths.get("carlists/" + fileList[i]), "".getBytes());
			}
			System.out.println("All Files Cleared");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * Reads a car list stored in a text file and
	 * @param fileName
	 * @return LinkedList<Car> a linked list containing the car objects
	 */
	public static LinkedList<Car> readList(String fileName){
		try {
			List<String> carListStrings = Files.readAllLines(Paths.get("carlists/"+fileName));
			LinkedList<Car> carList = new LinkedList<Car>();

			/**
			 * Iterate through the list of car strings to isolate each string
			 * and generate a car object based on the data stored in the txt
			 * files.
			 */
			for(int i = 0; i < carListStrings.size(); i += 1){
				String[] carString = carListStrings.get(i).split("\t");
				Car car = new Car(
					Long.valueOf(carString[3]),
					carString[2],
					Color.valueOf(carString[1]),
					carString[0]
				);
				carList.push(car);
			}
			return carList;
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			return null;
		}
	}

	 /**
		* Generates car data randomly using the Car constructor with only the
		* rec_id parameter.
		* @param numberOfLists
		* @param numberOfCars
	  */
	public static void generateCarData(int numberOfLists, int numberOfCars) {
		/**
		 * create the file list and begin the rec_id count make sure all of the data is
		 * clear in case the files already exist
		 */
		fileList = CarDataController.createFiles(numberOfLists, false);
		long rec_id = 0;
		CarDataController.clearAll(fileList);

		for (rec_id++; rec_id <= numberOfCars; rec_id++) {
			Car car = new Car(rec_id);
			CarDataController.write(fileList[(int) rec_id % numberOfLists], car);
		}
	}


	public static void writeSortedCarData(LinkedList<Car> carDataList, int listNumber){
		String localFileName = CarDataController.createFile(listNumber, true);
		for (int i = 0; i < carDataList.size(); i += 1){
			CarDataController.write(localFileName, carDataList.get(i));
		}
	}

	/**
	 * accessor method for the fileList
	 * @return	String[] of file names
	 */
	public static String[] getFileList(){
		return fileList;
	}

	/**
	 * accessor method for the sortedFileList
	 * @return	String[] of file names
	 */
	public static String[] getSortedFileList(){
		return sortedFileList;
	}
}
