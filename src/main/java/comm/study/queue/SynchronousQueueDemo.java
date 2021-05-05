/**
 * Copyright(c) 2018 asura
 */
package comm.study.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * 阻塞队列 SynchronousQueue
 *  该队列属于，生产一个 必须同步消费一个；否则队列会一直阻塞
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/16 3:11 下午
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {

        BlockingQueue<String> queue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"生产元素：a");
                queue.put("a");
                System.out.println(Thread.currentThread().getName()+"生产元素：b");
                queue.put("b");
                System.out.println(Thread.currentThread().getName()+"生产元素：c");
                queue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"消费元素："+queue.take());

                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"消费元素："+queue.take());

                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"消费元素："+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
