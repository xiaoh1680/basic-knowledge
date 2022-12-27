package com.basic.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolRejectedTest {

    public static void main(String[] args) {
        try {
            // 自定义的线程池任务拒绝策略
            RejectedExecutionHandler rejected = (Runnable r, ThreadPoolExecutor executor) -> {
                if (r instanceof RunnableImpl) {
                    RunnableImpl rm = (RunnableImpl) r;
                    System.out.println("线程任务被拒绝 : " + rm.id);
                    try {
                        // 等待1.5秒后，尝试将当前被拒绝的任务重新加入线程队列
                        // 此时主线程是会被阻塞的
                        Thread.sleep(1500);
                        System.out.println("尝试重新加入 : " + rm.id);
                        executor.execute(r);
                    } catch (Exception e) {
                    }
                }
            };
            // 将线程池队列设置为有界队列
            LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(1);
            // 初始化线程池
            ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, queue, rejected);
            // 模拟一个迭代器
            ListIterator<String> iterator = list(105).listIterator();
            // 假设每个线程每次处理20条数据
            List<String> list = new ArrayList<String>(20);
            int i = 1;
            while (iterator.hasNext()) {
                list.add(iterator.next());
                if (list.size() >= 20 || !iterator.hasNext()) {
                    executor.execute(new RunnableImpl(i++, list));
                    list.clear();
                }
            }

            System.out.println("--------------------任务添加完成");
            executor.shutdown();
            while (!executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
            }
            System.out.println("--------------------线程池执行结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> list(int size) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 1; i <= size; i++) {
            list.add(i + "");
        }
        return list;
    }
}

class RunnableImpl implements Runnable {

    public Integer id = -1;

    public RunnableImpl(int id, List<String> list) {
        this.id = id;
        System.out.println("初始化完成 : " + id);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000); // 假设线程每次处理需要3秒钟
            System.out.println("-----------------------------------线程执行结束 : " + id);
        } catch (Exception e) {
        }
    }
}
