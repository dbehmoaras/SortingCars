package sortingcars;

import java.util.LinkedList;
import java.util.Iterator;

public class ThreadPoolMain {


	private static String[] initFileList;
	// private static String[] sortedFileList;

	private static final int NUMBEROFLISTS = 5;
	private static final int NUMBEROFCARS = 240;
	private static final int NUMBEROFTHREADS = 5;



	public static void main(String[] args) throws Exception {

		 /**
			* Randomly generate car data. Overwrites in-place data.
		  */
		long dataGenStartTime = System.nanoTime();
		System.out.println("Generating car data...");
		initFileList = CarDataController.generateCarData(NUMBEROFLISTS, NUMBEROFCARS);
		long dataGenTimeElapsed = (System.nanoTime() - dataGenStartTime) / 1000000;
		System.out.println("Car data generated in "+dataGenTimeElapsed+" milliseconds.");


		/**
		 * Initialize the quicksort engine and the thread pool.
		 */
		QuicksortEngine quickSort = new QuicksortEngine();

		ThreadPool threadPool = new ThreadPool(NUMBEROFTHREADS, NUMBEROFLISTS);

		/**
		 * iterate through the number of lists, add the quicksort callback to the task queue
		 */
		for (int i = 0; i < NUMBEROFLISTS; i++) {

			int taskNo = i;
			threadPool.addRunnable(() -> {
				long startTime = System.nanoTime();

				LinkedList<Car> carList = CarDataController.readList(initFileList[taskNo]);
				quickSort.sort(carList);
				CarDataController.writeSortedCarData(carList, taskNo);

				long timeElapsed = (System.nanoTime() - startTime) / 1000000;

				String message = Thread.currentThread().getName() + ": Task " + taskNo + ", sorting: " + initFileList[taskNo]
						+ "\nCompleted in " + timeElapsed + " milliseconds.";
				System.out.println(message);
			});

		}

		System.out.println("threadpool size task queue"+threadPool.taskQueue.size());
		System.out.println("threadpool size task queue"+threadPool.runnables.size());

		while (threadPool.taskQueue.size()>0){
			threadPool.execute(threadPool.taskQueue.take());
		}

		threadPool.waitUntilAllTasksFinished();


		threadPool.stop();
	}
}
