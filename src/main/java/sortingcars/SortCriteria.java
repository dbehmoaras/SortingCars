package sortingcars;

// import java.util.HashMap;
import java.util.Map;
import sortingcars.Car.Color;


/**
 * SortCriteria provides a static interface containing two Maps
 * definine the order to refer to when sorting the destination
 * or the color that will be accessed by the quick sort engine.
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
