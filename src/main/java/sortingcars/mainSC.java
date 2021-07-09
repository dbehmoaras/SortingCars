package sortingcars;

import java.util.LinkedList;
import java.util.ListIterator;


public class mainSC{

	private static String[] fileList;
	public static void main (String[] args){

		/**
		 * Main method
		 */

		CarDataController.generateCarData(5,100);
		LinkedList<Car> carList = CarDataController.readList(CarDataController.getFileList()[0]);
		ListIterator<Car> carIter = carList.listIterator();
		while(carIter.hasNext()){
			System.out.println(carIter.next());
		}
	}
}