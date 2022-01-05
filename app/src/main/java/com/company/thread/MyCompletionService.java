package com.company.thread;

import java.util.concurrent.*;

public class MyCompletionService {
    final static CountDownLatch latch = new CountDownLatch(4);
    static ExecutorService executorService = Executors.newCachedThreadPool();
    static CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);

    public static void completionServiceCount() {
        for (int i = 1; i < 5; i++) {
            completionService.submit(getTask(i));
        }
    }
        public static Callable<Integer> getTask(int no) {
            Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    latch.countDown();
                    return no;
                }
            };
            return task;
        }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        completionServiceCount();
        latch.await();
        int sum=0;
        for (int i = 0; i < 4; i++) {
            int temp = completionService.take().get();
            sum += temp;
        }
        System.out.println(sum);
    }
}
