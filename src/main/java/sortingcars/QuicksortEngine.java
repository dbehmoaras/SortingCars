package sortingcars;

import java.util.LinkedList;

public class QuicksortEngine {

	private static LinkedList<Car> localCarList;

	public static void main(String[] args) {
		// Get an String array
		// a = new String[] { "X", "E", "C", "A" };
		CarDataController.generateCarData(5,100);
		CarDataController.createFiles(5, true);
		setLocalCarList(CarDataController.readList(CarDataController.getFileList()[1]));

		// prints the given array
		printArray();

		// sort the array
		sort();

		CarDataController.writeSortedCarData(localCarList, 1);

		System.out.println(localCarList);

		// prints the sorted array
		printArray();

	}

	// This method sort an array internally and internally calls quickSort
	public static void sort() {
		int left = 0;
		int right = localCarList.size() - 1;

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
			while (((Comparable<Car>) localCarList.get(++leftCursor)).compareTo(pivot) < 0);
			while (rightCursor > 0 && ((Comparable<Car>) localCarList.get(--rightCursor)).compareTo(pivot) > 0);
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

		if (((Comparable<Car>) localCarList.get(left)).compareTo(localCarList.get(center)) > 0)
			swap(left, center);

		if (((Comparable<Car>) localCarList.get(left)).compareTo(localCarList.get(right)) > 0)
			swap(left, right);

		if (((Comparable<Car>) localCarList.get(center)).compareTo(localCarList.get(right)) > 0)
			swap(center, right);

		swap(center, right);
		return localCarList.get(right);
	}

	// This method is used to swap the values between the two given index
	public static void swap(int left, int right) {
		Car temp = localCarList.get(left);
		localCarList.set(left, localCarList.get(right));
		localCarList.set(right, temp);
	}

	public static void printArray() {
		for (Car car : localCarList) {
			System.out.println(car + " ");
		}
	}

	/**
	 * Accessor and mutator methods for the localCarList
	 */
	public static LinkedList<Car> getLocalCarList(){
		return localCarList;
	}
	public static void setLocalCarList(LinkedList<Car> carList){
		localCarList = carList;
	}
}
