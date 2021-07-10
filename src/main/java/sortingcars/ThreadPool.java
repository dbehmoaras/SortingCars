package sortingcars;


import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * ThreadPool class that stores the LinkedList containing the runnable
 * tasks, the task queue, and a flag that checks if the thread pool is
 * stopped.
 */
public class ThreadPool {

	public LinkedBlockingQueue<Runnable> taskQueue = null;
	public LinkedList<PoolThreadJob> runnables =
		new LinkedList<PoolThreadJob>();
	private boolean isStopped = false;
	// private int maxNoOfThreads;


	/**
	 * Main constructor for the ThreadPool class.
	 * Sets the maximum number of threads and initializes the task queue.
	 * @param noOfThreads
	 * @param maxNoOfTasks
	 */
	public ThreadPool(int maxNoOfThreads, int noOfTasks) {
		taskQueue = new LinkedBlockingQueue<Runnable>(maxNoOfThreads);
	}

	/**
	 * Accepts a runnable task and adds it to the taskQueue.
	 * @param task
	 * @throws Exception
	 */
	public synchronized void execute(Runnable task) throws Exception {
		if (this.isStopped)
			throw new IllegalStateException("ThreadPool is stopped");
		this.startRunnable(task);
		if (runnables.size() > 0) taskQueue.add(runnables.pollFirst());
		// this.taskQueue.put(task);
		// this.wait();
	}


	/**
	 * Stops the thread pool.
	 */
	public synchronized void stop() {
		this.isStopped = true;
		for (PoolThreadJob runnable : runnables) {
			runnable.doStop();
		}
	}

	/**
	 * Puts the threads to sleep once the tasks are finished executing.
	 */
	public synchronized void waitUntilAllTasksFinished() {
		while (this.taskQueue.size() > 0) {
			// System.out.println("runnables size" + this.taskQueue.size());
			while (runnables.size() > 0) {
				taskQueue.add(runnables.pollFirst());
				System.out.println("polled");
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Pushes a runnable PoolThreadJob to the task
	 */
	public void addRunnable(Runnable job){
		System.out.println(taskQueue.size());
		PoolThreadJob poolJob = new PoolThreadJob(taskQueue);
		try {
			poolJob.addToQueue(job);
		} catch (IllegalStateException e){
			System.out.println("Thread pool full. Pushing to runnables list");
			runnables.push(poolJob);
		}
		// if (runnables.size() < maxNoOfThreads){
		// } else {
		// 	System.out.println("***WARNING: Maximum number of threads reached. "+
		// 		"Offering task to blocking queue.***");
		// 	this.taskQueue.offer(poolJob);
		// }
	}

	/**
	 * Alternative method for starting a runnable directly
	 * @param runnable
	 */
	public void startRunnable(Runnable runnable){
		Thread newThread = new Thread(runnable);
		newThread.start();
		// newThread.notify();
	}
}
