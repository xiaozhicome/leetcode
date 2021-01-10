package com.myself.leetcode.thread;

public class NotifyExample implements Runnable{

    private Integer lockNum;

    public NotifyExample(Integer num){
        this.lockNum=num;
    }

    public String doRun(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+" " +"doRun() satrt");
        synchronized (lockNum){
            System.out.println(threadName+" "+"get lock");
            try {
                System.out.println(threadName+" " +lockNum+" ready to wait");
                lockNum.wait();
                System.out.println(threadName+" " +lockNum+" wait() return");
                System.out.println(threadName+" "+lockNum+" ready to release lock");
                System.out.println(threadName+" " +"without InterruptedException "+Thread.interrupted());
            } catch (InterruptedException e) {
                System.out.println(threadName+" " +lockNum+" wait() interrupted");
                System.out.println(threadName+" " +"after catch InterruptedException "+Thread.interrupted());
            }
        }
        System.out.println(threadName+" " +"doRun() finish");
        return lockNum.toString();
    }

    @Override
    public void run() {
        doRun();
    }

    public static void main(String[] args){
        Integer lockNum=99;

        NotifyExample notifyExample = new NotifyExample(lockNum);
        NotifyOne notifyOne = new NotifyOne(lockNum);
        NotifyAll notifyAll = new NotifyAll(lockNum);
        for(int i=1;i<=3;i++){
            new Thread(new NotifyExample(lockNum),"Thread_wait_"+i).start();
        }
        /**
         * object.wait() 当前线程释放锁，后续代码阻塞
         * object.notify() 通知wait()中的线程一个，信号只有一个，所以该线程一定能抢到锁，
         * 其他等待线程继续阻塞，如果没有其他线程调用notify/notifyAll会一直阻塞
         * 当前线程继续持有锁，synchronized(){}执行完毕后自然释放锁
         * object.notifyAll() 通知wait()中的所有线程，信号是所有，所有线程都去抢锁，挨个抢锁执行，
         * 当前线程继续持有锁，synchronized(){}执行完毕后自然释放锁
         */
//        new Thread(new NotifyOne(lockNum),"Thread_notify").start();

        new Thread(new NotifyAll(lockNum),"Thread_notifyAll").start();
    }
}

class NotifyOne implements Runnable {

    private Integer lockNum;

    public NotifyOne(Integer num) {
        this.lockNum = num;
    }

    public String doNotify() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " " + "doNotify() satrt");
        synchronized (lockNum) {
            System.out.println(threadName + " " + "get lock");
            System.out.println(threadName + " " + lockNum + " ready to notify");
            lockNum.notify();
            System.out.println(threadName + " " + lockNum + " notify() return");
            System.out.println(threadName + " " + lockNum + " ready to release lock");
        }
        System.out.println(threadName + " " + "doNotify() finish");
        return lockNum.toString();
    }

    @Override
    public void run() {
        doNotify();
    }
}

class NotifyAll implements Runnable {

    private Integer lockNum;

    public NotifyAll(Integer num) {
        this.lockNum = num;
    }

    public String doNotifyAll() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " " + "doNotifyAll() satrt");
        synchronized (lockNum) {
            System.out.println(threadName + " " + "get lock");
            System.out.println(threadName + " " + lockNum + " ready to notify");
            lockNum.notifyAll();
            System.out.println(threadName + " " + lockNum + " notifyAll() return");
            System.out.println(threadName + " " + lockNum + " ready to release lock");
        }
        System.out.println(threadName + " " + "doNotifyAll() finish");
        return lockNum.toString();
    }


    @Override
    public void run() {
        doNotifyAll();
    }
}
