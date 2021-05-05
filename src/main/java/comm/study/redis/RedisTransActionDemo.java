/**
 * Copyright(c) 2018 asura
 */
package comm.study.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * <p></p>
 *
 * Redis事物测试
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/30 10:36 下午
 */
public class RedisTransActionDemo {
    public static Jedis jedis = null;

    /**
     * Redis的IP
     */
    private static String IP = "127.0.0.1";
    /**
     * Redis的端口号
     */
    private static Integer PORT = 6379;

    public static void main(String[] args) {
        jedis = getRedis();
        testWatch(jedis);
    }

    /**
     * 测试watch 与 unwatch
     *
     * 当锁定值之后，该值被修改后，事物操作该值，提交无效
     * @param jedis
     */
    public static void testWatch(Jedis jedis){
        System.out.println("************init total = " +jedis.get("total"));
        System.out.println("************init num = "+jedis.get("num"));
        int consume = 10;
        jedis.watch("total");

        jedis.set("total","200");

        int total = Integer.parseInt(jedis.get("total"));
        if(total < consume){
            jedis.unwatch();
            System.out.println("余额不足 total = " +total);
        } else {
            //开启事物
            System.out.println("开始事物*****************transaction");
            Transaction transaction = jedis.multi();
            transaction.decrBy("total",consume);
            transaction.incrBy("num",consume);
            transaction.exec();

            System.out.println("*****************total = "+jedis.get("total"));
            System.out.println("*****************num = "+jedis.get("num"));
        }
    }

    /**
     * 测试discard
     *  注意discard下面不能和exec一起使用
     *  JedisDataException: ERR EXEC without MULTI
     */
    public static void testDisCard(Jedis jedis){
        Transaction transaction = jedis.multi();

        transaction.set("total","100");
        transaction.set("num","0");
        transaction.discard();
//        transaction.exec();
        System.out.println(jedis.get("total"));
    }

    /**
     * 获取redis对象实例
     * @return
     */
    public static Jedis getRedis() {
        //连接redis服务器(在这里是连接本地的)
        jedis = new Jedis(IP, PORT);
        System.out.println("连接服务成功"+jedis.ping());
        return jedis;
    }
}
