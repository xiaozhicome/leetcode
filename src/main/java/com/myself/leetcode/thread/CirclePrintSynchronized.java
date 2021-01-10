package com.myself.leetcode.thread;

public class CirclePrintSynchronized {

    private volatile Integer pointor = 0;
    private Object lock = new Object();

    public void doPrint(String msg, int order) {
        int i = 0;
        String ThreadName = Thread.currentThread().getName();
        do {

            synchronized (lock) {
                while ((pointor % 3) != order) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(ThreadName + " " + "interrupted flag is " + Thread.interrupted());
                    }
                }
                System.out.println(ThreadName + " " + msg);
                pointor++;

                lock.notifyAll();
            }
            i++;

        } while (i <= 3);

    }

    public void printA(){
        doPrint("a",0);
    }

    public void printB(){
        doPrint("b",1);
    }

    public void printC(){
        doPrint("c",2);
    }

    public static void main(String[] args) {

//        for (int i = 1; i <= 4; i++) {
//            //每次新建CirclePrintExample对象导致pointer无效
//            new Thread(new CirclePrintSynchronized(object,i),"Thread_"+i).start();
//        }

        CirclePrintSynchronized print = new CirclePrintSynchronized();
        new Thread(new Runnable() {
            @Override
            public void run() {
                print.printA();
            }
        }, "Thread_1").start();
        new Thread(print::printB,"Thread_2").start();
        new Thread(print::printC,"Thread_3").start();
    }
}
