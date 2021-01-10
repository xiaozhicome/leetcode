package com.myself.leetcode.thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CirclePrintReentrantLock {

    private static volatile int status = 1;
    private static Lock lock = new ReentrantLock();

    public void doPrint(String msg, int check) {
        for (int i = 0; i < 10; ) {
            try {
                lock.lock();
                while (status % 3 == check) {
                    System.out.print(msg);
                    status++;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void printA() {
        doPrint("A", 1);
    }

    public void printB() {
        doPrint("B", 2);
    }

    public void printC() {
        doPrint("C", 3);
    }

    public static void main(String[] args) {

//        for (int i = 1; i <= 4; i++) {
//            //每次新建CirclePrintExample对象导致pointer无效
//            new Thread(new CirclePrintSynchronized(object,i),"Thread_"+i).start();
//        }

        CirclePrintReentrantLock print = new CirclePrintReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                print.printA();
            }
        }, "A").start();
        new Thread(print::printB, "B").start();
        new Thread(print::printC, "C").start();
    }
}
