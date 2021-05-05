/**
 * Copyright(c) 2018 asura
 */
package comm.study.threadpool;

import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 *  线程死锁:
 *  死锁是指两个或两个以上的进程在执行任务过程中，
 *  因为争夺资源而造成的一种互相等待的现象
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/18 10:38 下午
 */
public class LockDeadDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new MyResource(lockA,lockB),"AAA").start();
        new Thread(new MyResource(lockB,lockA),"BBB").start();

    }

}

class MyResource implements Runnable{
    private String lockA;
    private String lockB;

    public MyResource(String lockA,String lockB){
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 已经拥有锁 "+lockA +"\t 尝试获取锁 "+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 已经拥有锁 "+lockB+"\t 尝试获取锁 "+lockA);
            }
        }

    }
}
