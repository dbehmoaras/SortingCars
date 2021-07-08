package sortingcars;
import sortingcars.Car.Color;


public class mainSC{
	public static void main (String[] args){
		// int[] arr = { 10, 7, 8, 9, 1, 5 };
		// int n = arr.length;

		// QuicksortEngine.quickSort(arr, 0, n - 1);
		// System.out.println("Sorted array: ");
		// QuicksortEngine.printResults(arr, n);

		// String a = "PW4Y2JD5099A";
		// String b = "ND5N2XLUDMTB";

		// System.out.println(a.compareTo(b));
		// System.out.println(b.compareTo(a));

		Car testCar1 = new Car(1, "PW4Y2JD5099A", Color.BLACK, "Los Angeles");
		System.out.println(testCar1.getRecId());
		System.out.println(testCar1.getVin());
		System.out.println(testCar1.getColor());
		System.out.println(testCar1.getDestination());

		Car testCar2 = new Car(2, "ND5N2XLUDMTB", Color.RED, "Miami");
		System.out.println(testCar2.getRecId());
		System.out.println(testCar2.getVin());
		System.out.println(testCar2.getColor());
		System.out.println(testCar2.getDestination());

		Car testCar3 = new Car(1, "PW4Y2JD5099B", Color.BLACK, "Los Angeles");
		System.out.println(testCar3.getRecId());
		System.out.println(testCar3.getVin());
		System.out.println(testCar3.getColor());
		System.out.println(testCar3.getDestination());

		System.out.println("*****************************");
		System.out.println(testCar1.compareTo(testCar2));
		System.out.println(testCar2.compareTo(testCar1));
		System.out.println(testCar3.compareTo(testCar1));
		System.out.println(testCar1.compareTo(testCar3));
		System.out.println(testCar2.compareTo(testCar3));
		System.out.println(testCar3.compareTo(testCar2));
	}
}