package com.baokang.sdk.fork;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author wahaha
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        List<Integer> numList = Lists.newArrayList();
        final int size = 4000;
        final Random random = new Random();
        for (int i = 1; i <= size; i++) {
            int anInt = random.nextInt();
            numList.add(Math.abs(anInt));
        }
        for (int i = 0; i < 10; i++) {
            fork(numList);
            forkThread(numList);
        }


    }

    private static void fork(List<Integer> numList) {
        long start = System.currentTimeMillis();
        int count = 0;
        for (Integer integer : numList) {
            if (integer % 2 == 1) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        }
        System.out.println("invoke:" + count + ",time:" + (System.currentTimeMillis() - start));
    }

    private static void forkThread(List<Integer> numList) {
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountTask countTask = new CountTask(0, numList.size() - 1, numList);
        Integer invoke = forkJoinPool.invoke(countTask);
        System.out.println("invoke:" + invoke + ",time:" + (System.currentTimeMillis() - start));
    }

}

class CountTask extends RecursiveTask<Integer> {


    private int start;
    private int end;
    private List<Integer> a;

    CountTask(int start, int end, List<Integer> a) {
        this.start = start;
        this.end = end;
        this.a = a;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        int num = 500;
        if (end - start < num) {
            int count = 0;
            for (int i = start; i < end; i++) {
                //如果是奇数 当true
                if (a.get(i) % 2 == 1) {
                    count++;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return count;
        } else {
            int i = (start + end) / 2;
            CountTask f = new CountTask(start, i, a);
            CountTask r = new CountTask(i + 1, end, a);
            invokeAll(f, r);
            return f.join() + r.join();

        }

    }
}