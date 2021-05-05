/**
 * Copyright(c) 2018 asura
 */
package comm.study.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/31 9:14 上午
 */
public class RedisPoolDemo {

    private static String IP = "127.0.0.1";

    private static Integer PORT = 6379;

    private static volatile JedisPool instance = null;

    /**
     * double check lock
     *  创建jedisPool
     * @param
     * @return
     */
    private static JedisPool getInstance(){
        if(instance == null){
            synchronized (RedisPoolDemo.class){
                if(instance == null){
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    //最大连接数
                    jedisPoolConfig.setMaxTotal(10000);
                    //控制空闲数
                    jedisPoolConfig.setMaxIdle(32);
                    //最大等待毫秒数
                    jedisPoolConfig.setMaxWaitMillis(100*1000);
                    //测试连通性
                    jedisPoolConfig.setTestOnBorrow(true);
                    //无参数时，默认IP本机地址和默认端口6379
                    instance = new JedisPool(jedisPoolConfig,IP,PORT);
                }
            }
        }
        return instance;
    }

    /**
     * 回收Jedis实例
     * @param jedis
     */
    private static void release(Jedis jedis){
        if(jedis != null){
          jedis.close();
        }
    }


    public static void main(String[] args) {
        JedisPool jedisPool = RedisPoolDemo.getInstance();
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();

            jedis.set("aa","bb");

            System.out.println(jedis.get("aa"));
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            RedisPoolDemo.release(jedis);
        }


    }

}
