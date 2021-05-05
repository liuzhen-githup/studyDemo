/**
 * Copyright(c) 2018 asura
 */
package comm.study.lambda;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/23 5:43 下午
 */
public class LambdaTest {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run...");
            }
        };
        new Thread(runnable).start();

        Runnable runnable1 = () ->{
            System.out.println("hello");
        };
        new Thread(runnable1).start();
    }
}
