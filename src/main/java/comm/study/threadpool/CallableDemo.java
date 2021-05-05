/**
 * Copyright(c) 2018 asura
 */
package comm.study.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <p></p>
 *
 * FutureTask 使用
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/17 12:34 上午
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        new Thread(futureTask,"AA").start();
        Integer result = futureTask.get();
        System.out.println(Thread.currentThread().getName()+" futureTask result value = " + result);

    }
}



class MyThread implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("****************futureTask comm in****************");
        return 1024;
    }
}
