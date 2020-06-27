package com.p1ass.ospractice.practice9;

import com.p1ass.ospractice.Sha256;

import java.util.Random;


public class HashCalculatorThread extends Thread {
    Random random = new Random();


    // ヒープにアロケートされる変数に対して複数スレッドからアクセスされるが、
    // false → true にしかならないので、整合性は保たれる
    private static boolean is_found = false;


    public void run() {
        System.out.printf("スレッドを開始しました。 id=%d \n", this.getId());
        while (!HashCalculatorThread.is_found) {
            var number = this.random.nextInt();
            var hash = Sha256.getHash(String.valueOf(number));
            if (hash.startsWith("000000")) {
                System.out.println(String.format("number is %d, hash is %s", number, hash));
                HashCalculatorThread.is_found = true;
                break;
            }
        }

        System.out.printf("スレッドが終了しました。id=%d \n", this.getId());
    }

}

