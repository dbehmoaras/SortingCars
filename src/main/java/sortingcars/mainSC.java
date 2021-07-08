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

		Car testCar = new Car(1, "PW4Y2JD5099A", Color.BLACK, "Los Angeles");
		System.out.println(testCar.getRecId());
		System.out.println(testCar.getVin());
		System.out.println(testCar.getColor());
		System.out.println(testCar.getDestination());

	}
}