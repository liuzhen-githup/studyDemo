/**
 * Copyright(c) 2018 asura
 */
package comm.study.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.*;

/**
 * <p></p>
 *
 * Redis 集成
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/30 9:34 下午
 */
public class RedisDemo {

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
        jedis = RedisDemo.getRedis();
        testHash(jedis);
    }

    /**
     * 测试String
     * @param jedis
     */
    public static void testString(Jedis jedis){
        jedis.setnx("name","liuzhen");
        jedis.setnx("age","27");
        jedis.setnx("email","abc@cn.com");
        jedis.setnx("general","男");
        jedis.setnx("salar","10001.11");
        System.out.println("测试redis连接：name = " +jedis.get("name"));
        Set<String> stringSet = jedis.keys("*");
        System.out.println(stringSet);

    }

    /**
     * 测试list集合
     * @param jedis
     */
    public static void testlist(Jedis jedis){
        jedis.lpush("list1","a","b","c","d");
        System.out.println(jedis.lrange("list1",0,-1));
        System.out.println(jedis.rpop("list1"));
        System.out.println(jedis.lrange("list1",0,-1));
    }


    /**
     * 测试hash集合
     * @param jedis
     */
    public static void testHash(Jedis jedis){
        jedis.hset("user","name","xy");
        Map<String,String> map = new HashMap<>();
        map.put("age","30");
        map.put("email","xxx@cn.com");
        map.put("gener","girl");
        jedis.hmset("user",map);
        List<String> list = jedis.hmget("user","name","age","email");
        for (String str: list) {
            System.out.println(str);
        }

        Map<String,String> maps = jedis.hgetAll("user");
        for(String key : maps.keySet()){
            System.out.println("当前 key ：" +key +"，value："+maps.get(key));
        }
    }

    /**
     * 测试Set集合
     * @param jedis
     */
    public static void testSet(Jedis jedis){
        jedis.sadd("user","name","xy");


    }
    /**
     * 测试Zset集合
     * @param jedis
     */
    public static void testZset(Jedis jedis){

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
