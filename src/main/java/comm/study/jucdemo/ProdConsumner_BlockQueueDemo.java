/**
 * Copyright(c) 2018 asura
 */
package comm.study.jucdemo;

import comm.study.bean.Emp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/16 11:46 下午
 */
public class ProdConsumner_BlockQueueDemo {

    public static void main(String[] args) {
        //创建消费对象实列 且创建一个 数组队列 长度为10
        MyResource resource = new MyResource(new SynchronousQueue<>());

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                resource.prod(new Emp("test", 21));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");

            System.out.println();
            System.out.println();
            try {
                resource.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer").start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();

        System.out.println("10秒后结束消息对象创建，结束整个流程！！！！！！");
        resource.close();
    }


}

class MyResource{
    //可见性
    private volatile boolean FLAG = true;
    /**
     * TODO原子引用
     */
    AtomicReference<Emp> atomicReference = new AtomicReference<>();
    BlockingQueue<String> queue = null;
    /**
     * 构造器注入
     * @param queue
     */
    public MyResource(BlockingQueue<String> queue){
        this.queue = queue;
        System.out.println(Thread.currentThread().getName()+"传入队列类型："+queue.getClass().getName());
    }

    /**
     * 生产消息
     * @param emp
     * @throws InterruptedException
     */
     public void prod(Emp emp) throws InterruptedException {
        String result = null;
        while(FLAG){
            atomicReference.set(emp);
            result = atomicReference.get().toString();
            boolean resultB = queue.offer(result,2L, TimeUnit.SECONDS);
            if(resultB){
                System.out.println(Thread.currentThread().getName()+"\t 生产对象："+result +"成功");
            } else {
                System.out.println(Thread.currentThread().getName()+"\t 生产对象："+result +"失败");
            }
            //每2秒生产一个对象
            TimeUnit.SECONDS.sleep(2);
        }
        //跳出循环表示结束生产
         System.out.println(Thread.currentThread().getName()+"生产结束，状态已经变为 FLAG = false");
     }
    /**
     * 消费消息
     * @throws InterruptedException
     */
    public void consumer() throws InterruptedException {
        String data = null;
        while(FLAG){
          data = queue.poll(5L,TimeUnit.SECONDS);
          if(data == null || data.equalsIgnoreCase("")){
              FLAG = false;
              System.out.println(Thread.currentThread().getName()+"\t 超出5秒没有取到值，消费对象结束");
              return;
          }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+data+"成功");
        }
        System.out.println(Thread.currentThread().getName()+"\t 消费结束了，队列消息无");
    }

    /**
     * 结束线程
     */
    public void close(){
        FLAG = false;
    }

}
