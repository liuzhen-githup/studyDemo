/**
 * Copyright(c) 2018 asura
 */
package comm.study.queue;

import java.awt.image.TileObserver;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 * 1.队列
 * 2.阻塞队列
 *  2.1 阻塞队列有没有好的一面
 *  2.2 不得不阻塞，你如何管理
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/15 3:30 下午
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {
        //System.out.println(Integer.MAX_VALUE);

        try {
            offerAndPollAPI2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * API调用异常
     */
    public static void addAndRemoveApi(){
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        /**
         * add(e),插入成功则返回true ，队列满时则抛出异常java.lang.IllegalStateException: Queue full
         */
        System.out.println(queue.add("a"));
        System.out.println(queue.add("b"));
        System.out.println(queue.add("c"));

        /**
         * remove()，移除队列元素成功则返回元素，队列为空时则抛出异常NoSuchElementException
         */
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
    /**
     * API
     */
    public static void offerAndPollApi(){
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        /**
         * offer(e),插入成功返回true，队列满时则插入返回false
         */
        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("b"));
        System.out.println(queue.offer("c"));

        /**
         * poll()，移除成功返回true，队列为空时移除则返回false
         */
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        //用来判断队列是否还有值，返回值是下一个出队的元素
        System.out.println(queue.peek());
    }

    public static void putAndTakeApt() throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        /**
         * put(e),无返回值，队列满时，队列一直处理阻塞状态，直至插入成功
         */
        queue.put("a");
        queue.put("b");
        queue.put("c");
        System.out.println("++=================");


        /**
         * take()，获取队首元素，获取成功则返回元素，对列为空时，则一直处于阻塞状态，直至拿到元素
         */
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }


    public static void offerAndPollAPI2() throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        /**
         * offer(e, TimeOut, TimeType),插入成功则返回true，队列满时则，且超时 则返回false
         */
        System.out.println(queue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(queue.offer("b", 2L, TimeUnit.SECONDS));
        System.out.println(queue.offer("c", 2L, TimeUnit.SECONDS));
        System.out.println(queue.offer("X", 2L, TimeUnit.SECONDS));

        /**
         * poll(timeout,TimeType)，获取元素成功则返回元素值，队列为空时，且超时，则返回null
         */
        System.out.println(queue.poll(2L, TimeUnit.SECONDS));
        System.out.println(queue.poll(2L, TimeUnit.SECONDS));
        System.out.println(queue.poll(2L, TimeUnit.SECONDS));
        System.out.println(queue.poll(2L, TimeUnit.SECONDS));

    }

}
