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
		Car testCar2 = new Car(2, "ND5N2XLUDMTB", Color.RED, "Miami");
		Car testCar3 = new Car(1, "PW4Y2JD5099B", Color.BLACK, "Los Angeles");

		String fileName = CreateTxt.create(1);
		WriteToTxt.write(fileName, testCar1);
		WriteToTxt.write(fileName, testCar2);
		WriteToTxt.write(fileName, testCar3);

	}
}