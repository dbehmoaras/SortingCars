package sortingcars;

// import sortingcars.SortCriteria;

public class Car implements Comparable<Car> {
	private long REC_ID;
	private String VIN;
	private Color COLOR;
	private String DESTINATION;

	/* define the enumerator for the Color options */
	public static enum Color {
		RED,
		BLUE,
		BLACK,
		WHITE
	};

	/* Main constructor method for the Car class */
	public Car(long rec_id, String vin, Color color, String destination){
		REC_ID = rec_id;
		VIN = vin;
		COLOR = color;
		DESTINATION = destination;
	}


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
	 * below this line.
	 *
	 */

	public void setRecId(long id){
		REC_ID = id;
	}

	public void setVin(String vin){
		VIN = vin;
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