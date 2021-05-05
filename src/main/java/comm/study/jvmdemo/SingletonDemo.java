/**
 * Copyright(c) 2018 asura
 */
package comm.study.jvmdemo;

/**
 * <p></p>
 *
 * 多线程下的单列模式
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/8 11:13 上午
 */
public class SingletonDemo {

    /**
     * 多线程下 防止指令重排
     */
    private static volatile SingletonDemo instance = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t 私有构造器SingletonDemo()");
    }

    /**
     * DCL 模式
     *  DCL 模式属于双端检锁模式；在加锁的前后进行双重判断，达到保证运行的结果一致
     *  缺点：线程不安全，指令会做重排操作。多线程可能存在结果不一致
     * @return
     */
    public static SingletonDemo getInstance(){
        if(instance == null){
            synchronized (SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //单线程模式（main线程下的操作）
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());

        // 多线程模式
        for (int i = 1; i < 10; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }

    }
}
