package demo.demoMultiThreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainTest {
	public Integer count = 0;

	public static void main(String[] args) {
		final MainTest demo = new MainTest();
		Executor executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 1000; i++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(demo.count);
					demo.count++;
				}
			});
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("final count value:" + demo.count);
	}
}
