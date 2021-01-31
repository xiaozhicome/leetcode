package com.myself.leetcode.fail;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Print{
    Lock lock=new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();
    private static CountDownLatch latch = new CountDownLatch(1);

    public void printA(){
        lock.lock();
        try {
            a.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A");
        b.signal();
        lock.unlock();
    }

    public void printB(){
        lock.lock();
        try {
            b.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B");
        c.signal();
        lock.unlock();
    }

    public void printC(){
        lock.lock();
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("C");
        c.signal();
        lock.unlock();
    }

    public void down() {

        latch.countDown();
    }


    public static void main(String[] args) throws InterruptedException {
        Print p =new Print();

        new Thread(()->p.printA(),"A").start();
        new Thread(()->p.printB(),"B").start();
        new Thread(()->p.printB(),"C").start();
        new Thread(()->p.printB(),"C").start();
        p.a.signal();
        latch.await();

    }

}

