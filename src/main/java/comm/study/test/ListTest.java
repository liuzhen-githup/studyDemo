/**
 * Copyright(c) 2018 asura
 */
package comm.study.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <p></p>
 *
 *
 * @Description:
 * @ClassName ListTest
 * @Author zhen.liu
 * @Date 2021/7/30 3:00 下午
 * @Version 1.0
 **/
public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList(){{
            add("KRS-001");
            add("KRS-002");
            add("ARS-001");
            add("ERS-001");
            add("ERS101");
            add("FRS101");
        }};
        Collections.sort(list);

        System.out.println(list);
    }
}
