package com.p1ass.ospractice.practice10;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

// 正しく終了処理を行っています。
public class Main {
    public static void main(String[] args) {
        System.out.println("mainを実行中です");

        var random = new Random();

        var queue = new ConcurrentLinkedQueue<Integer>();

        var thread1 = new HashCalculatorFromQueueThread(queue);
        thread1.start();
        var thread2 = new HashCalculatorFromQueueThread(queue);
        thread2.start();
        var thread3 = new HashCalculatorFromQueueThread(queue);
        thread3.start();
        var thread4 = new HashCalculatorFromQueueThread(queue);
        thread4.start();

        while (!HashCalculatorFromQueueThread.is_found) {
            if (queue.size() < 10000) {
                queue.add(random.nextInt());
            }
        }

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("mainを終了しました");
    }
}
