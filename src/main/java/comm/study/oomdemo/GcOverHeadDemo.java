/**
 * Copyright(c) 2018 asura
 */
package comm.study.oomdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p></p>
 *
 * GC回收时间过长会抛出OutOfMemoryError ，GC回收占比不超过2%，
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/22 10:05 下午
 */
public class GcOverHeadDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while(true){
            String str = new String("GCOverHead") + UUID.randomUUID().toString();
            list.add(str);
        }
    }
}
