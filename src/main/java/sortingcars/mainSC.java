package sortingcars;

import java.util.LinkedList;


public class mainSC{

	/**
	 * initialize local variables, including the local file lists
	 * declare constants for the number of lists and number of cars
	 */
	private static String[] initFileList;
	// private static String[] sortedFileList;

	private static final int NUMBEROFLISTS = 5;
	private static final int NUMBEROFCARS = 100;


	public static void main (String[] args){

		/**
		 * Main method
		 *
		 * access the initial file list by generatring the car data
		 * initialize the quick sort engine
		 * initialize the ThreadPool
		 *
		 *
		 * iterate through the initial file list
		 * 	on every turn, use the CarDataController to access the
		 * 	unsorted car list data in each file and store it in
		 * 	the local scope
		 * 	invoke the sorting engine by passing in the car list
		 * 	stored locally
		 * 	pass the data stored locally into the CarDataController's
		 * 	writeSortedCarData method, using the current index as the
		 * 	list number
		 */


		initFileList = CarDataController.generateCarData(NUMBEROFLISTS, NUMBEROFCARS);
		QuicksortEngine quickSort = new QuicksortEngine();

		for (int i = 0; i < initFileList.length; i+=1){
			LinkedList<Car> carList = CarDataController.readList(initFileList[i]);
			quickSort.sort(carList);
			CarDataController.writeSortedCarData(carList, i);

		}

	}
}