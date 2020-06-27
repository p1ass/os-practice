package com.p1ass.ospractice.practice9;

// 正しく終了処理を行っています。
public class Main {
    public static void main(String[] args) {
        System.out.println("mainを実行中です");

        var thread1 = new HashCalculatorThread();
        thread1.start();
        var thread2 = new HashCalculatorThread();
        thread2.start();
        var thread3 = new HashCalculatorThread();
        thread3.start();
        var thread4 = new HashCalculatorThread();
        thread4.start();

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
