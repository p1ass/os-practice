package com.p1ass.ospractice.practice11;

public class Semaphore {

    int count;
    Object lock_obj;

    Semaphore(int count) {
        this.count = count;
        this.lock_obj = new Object();
    }

    void P() {
        synchronized (this.lock_obj) {
            if (this.count == 0) {
                try {
                    System.out.println("waitします");
                    lock_obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("waitが解除されました");
            }
            this.count--;
            System.out.printf("カウントを減らしました : %d\n", this.count);
        }
    }

    void V() {
        synchronized (this.lock_obj) {
            this.count++;
            lock_obj.notify();
            System.out.printf("カウントを増やしました : %d\n", this.count);
        }
    }
}
