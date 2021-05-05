/**
 * Copyright(c) 2018 asura
 */
package comm.study.redis;

import redis.clients.jedis.Jedis;

/**
 * <p></p>
 *
 * 主从复制
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/31 8:48 上午
 */
public class MasterAndAlaveDemo {

    private static String IP = "127.0.0.1";

    private static Integer M_PORT = 6379;

    private static Integer S_PORT = 6380;


    public static void main(String[] args) {

      Jedis jedis_m = new Jedis( IP, M_PORT);
      Jedis jedis_s = new Jedis( IP, S_PORT);
      jedis_s.slaveof(IP,M_PORT);

      jedis_m.set("k3","v3");

      System.out.println(jedis_s.get("k3"));
    }


}
