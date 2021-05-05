/**
 * Copyright(c) 2018 asura
 */
package comm.study.jvmdemo;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/6 1:15 下午
 */
public interface LambdaInter {

    /**
     * 多参数无返回
     */
    @FunctionalInterface
    public interface NoReturnMultiParam{
        void method(int a, int b);
    }

    /**
     * 无参数无返回
     */
    @FunctionalInterface
    public interface NoReturnParam{
        void method();
    }

    /**
     * 有一个参数无返回
     */
    @FunctionalInterface
    public interface NoReturnOneParam{
        void method(int a);
    }

    /**
     * 无参数有返回
     */
    @FunctionalInterface
    public interface ReturnParam{
        int method();
    }

    /**
     * 有参数有返回
     */
    @FunctionalInterface
    public interface ReturnMuliteParam{
        int method(int a ,int b);
    }

    /**
     * 有参数有返回
     */
    @FunctionalInterface
    public interface ReturnOneParam{
        int method(int a);
    }
}
