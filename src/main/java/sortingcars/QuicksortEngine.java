package sortingcars;

import java.util.LinkedList;

public class QuicksortEngine {

	private static LinkedList<Car> carList;

	public static void main(String[] args) {
		// Get an String array
		// a = new String[] { "X", "E", "C", "A" };
		CarData.generateCarData(5,100);
		carList = CarData.readList(CarData.getFileList()[0]);

		// prints the given array
		printArray();

		// sort the array
		sort();

		System.out.println("");

		// prints the sorted array
		printArray();

	}

	// This method sort an array internally and internally calls quickSort
	public static void sort() {
		int left = 0;
		int right = carList.size() - 1;

		quickSort(left, right);
	}

	// This method is used to sort the array using quicksort algorithm.
	// It takes left and the right end of the array as two cursors
	private static void quickSort(int left, int right) {

		// If both cursor scanned the complete array quicksort exits
		if (left >= right)
			return;

		// Pivot using median of 3 approach
		Car pivot = getMedian(left, right);
		int partition = partition(left, right, pivot);

		// Recursively, calls the quicksort with the different left and right parameters
		// of the sub-array
		quickSort(0, partition - 1);
		quickSort(partition + 1, right);
	}

	// This method is used to partition the given array and returns the integer
	// which points to the sorted pivot index
	private static int partition(int left, int right, Car pivot) {
		int leftCursor = left - 1;
		int rightCursor = right;
		while (leftCursor < rightCursor) {
			while (((Comparable<Car>) carList.get(++leftCursor)).compareTo(pivot) < 0);
			while (rightCursor > 0 && ((Comparable<Car>) carList.get(--rightCursor)).compareTo(pivot) > 0);
			if (leftCursor >= rightCursor) {
				break;
			} else {
				swap(leftCursor, rightCursor);
			}
		}
		swap(leftCursor, right);
		return leftCursor;
	}

	public static Car getMedian(int left, int right) {
		int center = (left + right) / 2;

		if (((Comparable<Car>) carList.get(left)).compareTo(carList.get(center)) > 0)
			swap(left, center);

		if (((Comparable<Car>) carList.get(left)).compareTo(carList.get(right)) > 0)
			swap(left, right);

		if (((Comparable<Car>) carList.get(center)).compareTo(carList.get(right)) > 0)
			swap(center, right);

		swap(center, right);
		return carList.get(right);
	}

	// This method is used to swap the values between the two given index
	public static void swap(int left, int right) {
		Car temp = carList.get(left);
		carList.set(left, carList.get(right));
		carList.set(right, temp);
	}

	public static void printArray() {
		for (Car car : carList) {
			System.out.print(car + " ");
		}
	}

}
