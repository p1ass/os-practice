package com.p1ass.ospractice.practice11;

public class Main {
    public static void main(String[] args) {
        System.out.println("mainを実行中です");

        var semaphore = new Semaphore(2);

        semaphore.V();
        semaphore.P();
        semaphore.P();
        semaphore.P();
        // カウントが0なので一生先に進まない
        semaphore.P();
        semaphore.V();
        semaphore.V();

        System.out.println("mainを終了しました");
    }
}
