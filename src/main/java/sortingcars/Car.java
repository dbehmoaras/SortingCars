package sortingcars;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;


public class Car implements Comparable<Car> {
	private long REC_ID;
	private String VIN;
	private Color COLOR;
	private String DESTINATION;
	private UniqueVinGen vinGen = new UniqueVinGen(12, ThreadLocalRandom.current());

	/* define the enumerator for the Color options */
	public static enum Color {
		RED,
		BLUE,
		BLACK,
		WHITE
	};

	/**
	 * The Car constructor is overloaded so that it can be
	 * initilized in a variety of ways, including a version with
	 * a single argument of rec_id so that cars can be
	 * manufactured with randomly generated attributes for the
	 * car sorting algorithm.
	 * @param rec_id
	 * @param color
	 * @param destination
	 */
	public Car(long rec_id, Color color, String destination){
		REC_ID = rec_id;
		VIN = vinGen.nextString();
		COLOR = color;
		DESTINATION = destination;
	}

	/**
	 * This version of the constructor is implemented only in the testing
	 * suite for the Car class's compareTo function
	 * @param rec_id
	 * @param vin
	 * @param color
	 * @param destination
	 */
	public Car(long rec_id, String vin, Color color, String destination) {
		REC_ID = rec_id;
		VIN = vin;
		COLOR = color;
		DESTINATION = destination;
	}

	/**
	 * Overloaded constructor for a random Car generator.
	 * @param rec_id
	 */
	public Car(long rec_id){
		REC_ID = rec_id;
		VIN = vinGen.nextString();
		COLOR = getRandomColor();
		DESTINATION = getRandomDest();
	}



	/**
	 * Chooses a random color for the car.
	 * @return
	 */
	public static Color getRandomColor(){
		Random rand = new Random();
		Color[] colorArr = Color.class.getEnumConstants();
		return colorArr[rand.nextInt(colorArr.length)];
	}

	public static String getRandomDest(){
		String[] destinations = {
			"Los Angeles",
			"Houston",
			"New Orleans",
			"Miami",
			"New York"
		};
		Random rand = new Random();
		return destinations[rand.nextInt(destinations.length)];
	}


	/**
	 * We do not need to check if VINs are equal since the VIN data
	 * is already defined to be unique.
	 * @param car: car object to compare to this car
	 * @return int: returns the sign depending on the result of the
	 * comparison.
	 */
	public int compareTo(Car car){
		/**
		 * Get destination and color car sort criteria from the
		 * hashmaps and store them in local variables.
		 * There will be two vars for this car instance and two
		 * vars for the externally passed in car instance.
		 */

		int thisDestRank = SortCriteria.OrderDest.get(this.getDestination());
		int thisColorRank = SortCriteria.OrderColor.get(this.getColor());
		int extDestRank = SortCriteria.OrderDest.get(car.getDestination());
		int extColorRank = SortCriteria.OrderColor.get(car.getColor());

		if (thisDestRank == extDestRank){
			if (thisColorRank == extColorRank)
				return VIN.compareTo(car.VIN);
			else if (thisColorRank < extColorRank) return -1;
			else return 1;
		}
		else if (thisDestRank < extDestRank) return -1;
		else return 1;
	}




	/**
	 * Mutator and accessor methods for the car class are all
	 * below this javadoc. The methods are self explanatory.
	 * A mutator is not needed for the VIN is not needed since
	 * it is a randomly generated unique 12-digit alphanumeric
	 * String.
	 *
	 */

	public void setRecId(long id){
		REC_ID = id;
	}

	public void setColor(Color col){
		COLOR = col;
	}

	public void setDestination(String dest){
		DESTINATION = dest;
	}

	public long getRecId(){
		return REC_ID;
	}

	public String getVin(){
		return VIN;
	}

	public Color getColor(){
		return COLOR;
	}

	public String getDestination(){
		return DESTINATION;
	}
}