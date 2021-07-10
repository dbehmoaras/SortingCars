package sortingcars;

import java.util.LinkedList;

public class QuicksortEngine {

	public QuicksortEngine(){
	}

	public void sort(LinkedList<Car> localCarList) {
		int left = 0;
		int right = localCarList.size() - 1;

		quickSort(left, right, localCarList);
	}

	// This method is used to sort the array using quicksort algorithm.
	// It takes left and the right end of the array as two cursors
	private void quickSort(int left, int right, LinkedList<Car> localCarList) {

		// If both cursor scanned the complete array quicksort exits
		if (left >= right)
			return;

		// Pivot using median of 3 approach
		Car pivot = getMedian(left, right, localCarList);
		int partition = partition(left, right, pivot, localCarList);

		// Recursively, calls the quicksort with the different left and right parameters
		// of the sub-array
		quickSort(0, partition - 1, localCarList);
		quickSort(partition + 1, right, localCarList);
	}

	// This method is used to partition the given array and returns the integer
	// which points to the sorted pivot index
	private int partition(int left, int right, Car pivot, LinkedList<Car> localCarList) {
		int leftCursor = left - 1;
		int rightCursor = right;
		while (leftCursor < rightCursor) {
			while (((Comparable<Car>) localCarList.get(++leftCursor)).compareTo(pivot) < 0);
			while (rightCursor > 0 && ((Comparable<Car>) localCarList.get(--rightCursor)).compareTo(pivot) > 0);
			if (leftCursor >= rightCursor) {
				break;
			} else {
				swap(leftCursor, rightCursor, localCarList);
			}
		}
		swap(leftCursor, right, localCarList);
		return leftCursor;
	}

	public Car getMedian(int left, int right, LinkedList<Car> localCarList) {
		int center = (left + right) / 2;

		if (((Comparable<Car>) localCarList.get(left)).compareTo(localCarList.get(center)) > 0)
			swap(left, center, localCarList);

		if (((Comparable<Car>) localCarList.get(left)).compareTo(localCarList.get(right)) > 0)
			swap(left, right, localCarList);

		if (((Comparable<Car>) localCarList.get(center)).compareTo(localCarList.get(right)) > 0)
			swap(center, right, localCarList);

		swap(center, right, localCarList);
		return localCarList.get(right);
	}

	// This method is used to swap the values between the two given index
	public void swap(int left, int right, LinkedList<Car> localCarList) {
		Car temp = localCarList.get(left);
		localCarList.set(left, localCarList.get(right));
		localCarList.set(right, temp);
	}

	public void printArray(LinkedList<Car> localCarList) {
		for (Car car : localCarList) {
			System.out.println(car + " ");
		}
	}
}
