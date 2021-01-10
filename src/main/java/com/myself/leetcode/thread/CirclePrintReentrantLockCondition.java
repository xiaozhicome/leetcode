package com.myself.leetcode.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CirclePrintReentrantLockCondition {

    private static volatile int status = 1;
    private static Lock lock = new ReentrantLock();
    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();

    public void doPrint(String msg,
                        Condition m,
                        Condition n,
                        int check,
                        int target) {
        for (int i = 0; i < 10; i++) {
            try {
                lock.lock();
                while (status != check) {//多线程并发不能用if
                    m.await();
                }
                System.out.print(msg);
                status = target;
                n.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printA() {
        doPrint("A", a, b, 1, 2);
    }

    public void printB() {
        doPrint("B", b, c, 2, 3);
    }

    public void printC() {
        doPrint("C", c, a, 3, 1);
    }

    public static void main(String[] args) {

//        for (int i = 1; i <= 4; i++) {
//            //每次新建CirclePrintExample对象导致pointer无效
//            new Thread(new CirclePrintSynchronized(object,i),"Thread_"+i).start();
//        }

        CirclePrintReentrantLockCondition print = new CirclePrintReentrantLockCondition();
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
