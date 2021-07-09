package sortingcars;

import java.util.LinkedList;

public class ThreadPoolMain {


	private static String[] initFileList;
	// private static String[] sortedFileList;

	private static final int NUMBEROFLISTS = 5;
	private static final int NUMBEROFCARS = 100;



	public static void main(String[] args) throws Exception {


		initFileList = CarDataController.generateCarData(NUMBEROFLISTS, NUMBEROFCARS);
		QuicksortEngine quickSort = new QuicksortEngine();

		ThreadPool threadPool = new ThreadPool(5, 5);

		for (int i = 0; i < 5; i++) {
			int taskNo = i;
			threadPool.addRunnable();
			threadPool.startRunnable(() -> {
				LinkedList<Car> carList = CarDataController.readList(initFileList[taskNo]);
				quickSort.sort(carList);
				CarDataController.writeSortedCarData(carList, taskNo);
				String message = Thread.currentThread().getName() + ": Task " + taskNo + ", sorting: "+ initFileList[taskNo];
				System.out.println(message);
			});
		}
		System.out.println("gets here");
		// for (int i = 0; i < 5; i++) {
		// 	int taskNo2 = i;
		// 	threadPool.execute(() -> {
		// 		String message = Thread.currentThread().getName() + ": Task 2" + taskNo2;
		// 		System.out.println(message);
		// 	});
		// }

		threadPool.waitUntilAllTasksFinished();
		threadPool.stop();

	}
}
