package sortingcars;

public class mainSC{
	public static void main (String[] args){

		/**
		 * Main method
		 */

		generateCarData();
	}

	public static void generateCarData(){
		/**
		 * create the file list and begin the rec_id count
		 * make sure all of the data is clear in case the
		 * files already exist
		 */
		int numberOfLists = 5;
		int numberOfCars = 100;
		String[] fileList = GenerateData.createFiles(numberOfLists);
		long rec_id = 0;
		GenerateData.clearAll(fileList);

		for (rec_id++; rec_id <= numberOfCars; rec_id++){
			Car car = new Car(rec_id);
			GenerateData.write(fileList[(int) rec_id % numberOfLists], car);
		}

	}
}