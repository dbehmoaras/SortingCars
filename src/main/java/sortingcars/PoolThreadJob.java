package sortingcars;

import java.util.concurrent.BlockingQueue;


/**
 * Class that represents a runnable job object.
 * The quicksort invocation gets passed into
 * the thread pool as a runnable PoolThreadJob.
 */
public class PoolThreadJob implements Runnable {


	private Thread thread = null;
	private BlockingQueue taskQueue = null;
	private boolean isStopped = false;

	/**
	 * Constructor for the PoolThreadJob Runnable object.
	 * Accepts a blocking queue as an argument and stores
	 * it on the instance. This has the effect of binding
	 * the passed in BlockingQueue instance to an instance
	 * of a PoolThreadJob object.
	 * @param queue
	 */
	public PoolThreadJob(BlockingQueue queue) {
		taskQueue = queue;
	}

	/**
	 * This PoolThreadJob implements the runnable interface,
	 * so this is it's dedicated run() method. When an object
	 * implementing Runnable is used to create a thead (ie
	 * below) starting the thread causes the object's run
	 * method to be called in that separately executing thread.
	 */
	public void run() {
		/**
		 * Allocates a single thread to this run method.
		 * IE binds an isntance of the PoolThreadJob to
		 * the thread returned below before running the
		 * callback stored in the runnable taken from the
		 * taskQueue.
		 */
		this.thread = Thread.currentThread();

		/**
		 * While the thread is running
		 * 	it takes a Runnable object from the taskQueue
		 * 	and runs the callback stored as the task on
		 * 	that Runnable object.
		 */
		while (!isStopped()) {
			try {
				Runnable runnable = (Runnable) taskQueue.take();
				runnable.run();
			} catch (Exception e) {
				System.out.println("Error in PoolThreadJob Run() instance");
			}
		}
	}

	public synchronized void doStop() {
		this.thread = Thread.currentThread();
		isStopped = true;
		// break pool thread out of dequeue() call.
		this.thread.interrupt();
	}

	public synchronized boolean isStopped() {
		return isStopped;
	}

	public void addToQueue(Runnable job){
		taskQueue.add(job);
	}
}
