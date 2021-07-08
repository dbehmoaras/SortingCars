package sortingcars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import sortingcars.Car.Color;

public class CarTest {

	private static Car testCar1;
	private static Car testCar2;
	private static Car testCar3;

	@BeforeAll
	public static void init () {
		testCar1 = new Car(1, "PW4Y2JD5099A", Color.BLACK, "Los Angeles");
		testCar2 = new Car(2, "ND5N2XLUDMTB", Color.RED, "Miami");
		testCar3 = new Car(1, "PW4Y2JD5099B", Color.BLACK, "Los Angeles");
	}

	@Test
	public void car1CompareCar2 () {
		assertEquals(testCar1.compareTo(testCar2),-1);
	}

	@Test
	public void car2CompareCar1() {
		assertEquals(testCar2.compareTo(testCar1), 1);
	}

	@Test
	public void car3CompareCar1() {
		assertEquals(testCar3.compareTo(testCar1), 1);
	}

	@Test
	public void car1CompareCar3() {
		assertEquals(testCar1.compareTo(testCar3), -1);
	}

	@Test
	public void car2CompareCar3() {
		assertEquals(testCar2.compareTo(testCar3), 1);
	}

	@Test
	public void car3CompareCar2() {
		assertEquals(testCar3.compareTo(testCar2), -1);
	}
}
