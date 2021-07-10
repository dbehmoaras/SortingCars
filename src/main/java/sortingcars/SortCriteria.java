package sortingcars;

import java.util.Map;
import sortingcars.Car.Color;


/**
 * SortCriteria provides a static interface containing two Maps
 * defining the sorting orders for Destinations and Colors to refer.
 * The Maps are accessed by the Car's compareTo method.
 */
public class SortCriteria {

	public static final Map<String, Integer> OrderDest = Map.of(
		"Los Angeles" , 0,
		"Houston", 1,
		"New Orleans", 2,
		"Miami", 3,
		"New York", 4
	);

	public static final Map<Enum<Color>, Integer> OrderColor = Map.of(
		Color.RED, 0,
		Color.BLUE, 1,
		Color.BLACK, 2,
		Color.WHITE, 3
	);

}
