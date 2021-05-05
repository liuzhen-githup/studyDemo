/**
 * Copyright(c) 2018 asura
 */
package comm.study.jucdemo;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p></p>
 * 独占锁、共享锁（写锁   ，读锁）
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源是可以同时进行的
 *  但是
 * 如果有一个线程想去写共享资源，就不应该允许其他线程同时并发去操作。否则会出现数组覆盖或死锁
 * ReentrantReadWriteLock - 读写分离类 读写锁
 *  rwLock.writeLock().lock(); - 写时独占
 *  rwLock.readLock().lock(); - 读时共享
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/13 5:15 下午
 */
public class ReadWriterLockDemo {

    public static void main(String[] args) {
      MyCache cache = new MyCache();
        for (int i = 1; i < 5; i++) {
            final String len = String.valueOf(i);
            new Thread(()->{
                cache.putMap(len ,len);
            },String.valueOf(i)).start();
        }


        for (int i = 1; i < 5; i++) {
            final String len = String.valueOf(i);
            new Thread(()->{
                cache.getMap(len);
            },String.valueOf(i)).start();
        }

    }
}

class MyCache{
    public volatile HashMap<String,String> map = new HashMap<>();

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    /**
     * 写入数据
     */
    public void putMap(String key,String value){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正准备写入数据..."+key+","+value);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入数据完毕..."+key+","+value);
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void getMap(String key){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 准备读取数据..."+key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取数据完成..."+result);
        } finally {
            rwLock.readLock().unlock();
        }

    }

}