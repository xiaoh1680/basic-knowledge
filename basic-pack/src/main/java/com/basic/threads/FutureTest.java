package com.basic.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by xh826 on 2017/9/8.
 */
public class FutureTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            System.out.println("加入任务："+i);
            Task task = new Task(i);
            list.add(executor.submit(task));
        }
        executor.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("主线程在执行任务");
        list.forEach(integerFuture -> {
            try {
                System.out.println("task运行结果:"+integerFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println("所有任务执行完毕");
    }
    static class Task implements Callable<Integer> {
        private Integer type;

        public Task(Integer type) {
            this.type = type;
        }
        public Integer call() throws Exception {
            System.out.println("子线程在进行计算:"+type);
            Thread.sleep(5000);
            return type;
        }
    }
}


