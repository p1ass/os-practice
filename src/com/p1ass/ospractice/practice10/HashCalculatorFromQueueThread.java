package com.p1ass.ospractice.practice10;

import com.p1ass.ospractice.Sha256;

import java.util.concurrent.ConcurrentLinkedQueue;

public class HashCalculatorFromQueueThread extends Thread {

    ConcurrentLinkedQueue<Integer> queue;

    // ヒープにアロケートされる変数に対して複数スレッドからアクセスされるが、
    // false → true にしかならないので、整合性は保たれる
    public static boolean is_found = false;

    HashCalculatorFromQueueThread(ConcurrentLinkedQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        System.out.printf("スレッドを開始しました。 id=%d \n", this.getId());

        while (!HashCalculatorFromQueueThread.is_found) {
            var number = queue.poll();
            if (number == null) {
                continue;
            }
            var hash = Sha256.getHash(String.valueOf(number));

            if (hash.startsWith("000000")) {
                System.out.println(String.format("number is %d, hash is %s", number, hash));
                HashCalculatorFromQueueThread.is_found = true;
                break;
            }
        }

        System.out.printf("スレッドが終了しました。id=%d \n", this.getId());
    }

}

