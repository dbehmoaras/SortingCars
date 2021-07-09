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

	public PoolThreadJob(BlockingQueue queue) {
		taskQueue = queue;
	}

	public void run() {
		this.thread = Thread.currentThread();
		while (!isStopped()) {
			try {
				Runnable runnable = (Runnable) taskQueue.take();
				runnable.run();
			} catch (Exception e) {
				// log or otherwise report exception,
				// but keep pool thread alive.
			}
		}
	}

	public synchronized void doStop() {
		isStopped = true;
		// break pool thread out of dequeue() call.
		this.thread.interrupt();
	}

	public synchronized boolean isStopped() {
		return isStopped;
	}
}
