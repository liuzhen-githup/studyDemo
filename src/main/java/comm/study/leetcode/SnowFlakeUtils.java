/**
 * Copyright(c) 2018 asura
 */
package comm.study.leetcode;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;

import javax.annotation.PostConstruct;

/**
 * <p></p>
 *
 *
 * @Description: 利用Hutools整合雪花算法工具类生成 序列
 * @ClassName SnowFlakeUtils
 * @Author zhen.liu
 * @Date 2021/6/18 1:56 下午
 * @Version 1.0
 **/
public class SnowFlakeUtils {

    private long workerId= 0L;
    private long datacenterId= workerId + 1L;
    private Snowflake snowflake= IdUtil.createSnowflake(workerId, datacenterId);

    @PostConstruct
    public void init(){
        try{
            workerId= NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        }catch(Exception e){
            workerId=NetUtil.getLocalhostStr().hashCode();
        }

    }
    public synchronized long snowflakeId(long workerId,long datacenterId){
        Snowflake snowflake=IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }
    public synchronized long snowflakeId(){
        return snowflake.nextId();
    }


    public static void main(String[] args) {
        SnowFlakeUtils snowFlakeUtils = new SnowFlakeUtils();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+": "+snowFlakeUtils.snowflakeId());
            }, "ThreadA"+i).start();
        }

    }

}
