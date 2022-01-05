package com.company.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CountDownLatchExample {
    // 处理文件的数量
    private static final int threadCount = 6;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建一个具有固定线程数量的线程池对象（推荐使用构造方法创建）
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        List<Future<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            lists.add(threadPool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int n = 0;
                    if(threadnum==1){
                        n = 2;
                    }
                    else {
                        n = 1;
                    }
                                        countDownLatch.countDown();
                    return n;
                }
            }));
//            threadPool.execute(() -> {
//                try {
//                    int n = 0;
//                    if(threadnum==1){
//                        n = 0/0;
//                    }
//                    else {
//                        n = 1;
//                    }
//                    return n;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    //表示一个文件已经被完成
//                    countDownLatch.countDown();
//                }
//            });
        }
        countDownLatch.await();
        int sum=0;
        for(Future<Integer> f:lists){
            sum += f.get();
        }
        threadPool.shutdown();
        System.out.println("finish"+sum);
    }
}
