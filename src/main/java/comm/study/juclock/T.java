/**
 * Copyright(c) 2018 asura
 */
package comm.study.juclock;

import org.openjdk.jol.info.ClassLayout;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/27 9:26 下午
 */
public class T {

    static L l = new L();

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
    }

    public static void locks(){

        synchronized (l){
            System.out.println("AAAAAAAAAAAAA");
        }
    }
}
