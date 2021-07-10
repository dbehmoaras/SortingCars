package sortingcars;


import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * T
 */
public class ThreadPool {

	private BlockingQueue taskQueue = null;
	private LinkedList<PoolThreadJob> runnables =
		new LinkedList<PoolThreadJob>();
	private boolean isStopped = false;

	public ThreadPool(int maxNoOfThreads, int maxNoOfTasks) {
		taskQueue = new LinkedBlockingQueue<PoolThreadJob>(maxNoOfTasks);
	}

	public synchronized void execute(Runnable task) throws Exception {
		if (this.isStopped)
			throw new IllegalStateException("ThreadPool is stopped");

		this.taskQueue.offer(task);
	}

	public synchronized void stop() {
		this.isStopped = true;
		for (PoolThreadJob runnable : runnables) {
			runnable.doStop();
		}
	}

	public synchronized void waitUntilAllTasksFinished() {
		while (this.taskQueue.size() > 0) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void addRunnable(){
		PoolThreadJob poolThreadJob = new PoolThreadJob(taskQueue);
		runnables.push(poolThreadJob);
	}

	public void startRunnable(Runnable runnable){
		new Thread(runnable).start();
	}
}
