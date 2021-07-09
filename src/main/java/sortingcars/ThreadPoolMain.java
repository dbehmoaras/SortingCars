package sortingcars;

public class ThreadPoolMain {

	public static void main(String[] args) throws Exception {

		ThreadPool threadPool = new ThreadPool(256, 256);

		for (int i = 0; i < 256; i++) {
			int taskNo = i;
			threadPool.addRunnable();
			threadPool.startRunnable(() -> {
				String message = Thread.currentThread().getName() + ": Task " + taskNo;
				System.out.println(message);
			});

			threadPool.execute(() -> {
				String message = Thread.currentThread().getName() + ": Task " + taskNo;
				System.out.println(message);
			});
		}

		threadPool.waitUntilAllTasksFinished();
		threadPool.stop();

	}
}
