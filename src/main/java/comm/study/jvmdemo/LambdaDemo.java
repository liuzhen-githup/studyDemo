/**
 * Copyright(c) 2018 asura
 */
package comm.study.jvmdemo;

import org.junit.Test;

/**
 * <p></p>
 *
 * 调试 JDK8 特有的编程方式 Lambda 表达式
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/6 1:14 下午
 */
public class LambdaDemo {

    public static void main(String[] args) {;
        teesLambda2();
    }

    @Test
    public static void testLambda1(){
        /**
         * lambda 表达式
         *  调用无参数 无返回接口
         */
        LambdaInter.NoReturnParam noReturnParam = () ->{
            System.out.println("无参数无返回");
        };
        noReturnParam.method();

        /**
         * lambda 表达式
         *  调用单参数 无返回接口
         */
        LambdaInter.NoReturnOneParam noReturnOneParam = (int a) ->{
            System.out.println("输出参数值 = " + a);
        };
        noReturnOneParam.method(66);


        /**
         * lambda 表达式
         *  调用多参数 无返回接口
         */
        LambdaInter.NoReturnMultiParam  noReturnMultiParam = (int a,int b) ->{
            System.out.println("多参数值计算 = {" + a +"}, {"+ b + "}");
        };
        noReturnMultiParam.method(66 , 44);



        /**
         * lambda 表达式
         *  调用无参数 有返回接口
         */
        LambdaInter.ReturnParam returnParam = () ->{
            System.out.println("无参数，有返回接口");
            return 1;
        };
        returnParam.method();


        /**
         * lambda 表达式
         *  调用单参数 有返回接口
         */
        LambdaInter.ReturnOneParam returnOneParam = (int a) ->{
            System.out.println("单参数，有返回接口，返回值：= " + a );
            return ++a;
        };
        int oneLen = returnOneParam.method(10);
        System.out.println("单参数 有返回接口，输出返回值：=" + oneLen);


        /**
         * lambda 表达式
         *  调用多参数 有返回接口
         */
        LambdaInter.ReturnMuliteParam returnMuliteParam = (int a , int b) ->{
            System.out.println("单参数，有返回接口，返回值：= {" + a +"},{" + b + "}" );
            return a + b;
        };
        int len = returnMuliteParam.method(10 , 20);
        System.out.println("多参数 有返回接口，输出返回值：=" + len);
    }


    /**
     * 更优雅的Lambda表达式
     * 简化版
     */
    @Test
    public static void teesLambda2(){
        /**
         * 多参数，无返回的简化版表达式
         */
        LambdaInter.NoReturnMultiParam noReturnMultiParam = (a , b) ->
                System.out.println("多参数，无返回 = 「"+ a + "」，「" + b +"」" );
        noReturnMultiParam.method(11,22);

        /**
         * 单参数，无返回的简化
         */
        LambdaInter.NoReturnOneParam noReturnOneParam = a ->
                System.out.println("单参数，无返回 = 「" + a +"」");
        noReturnOneParam.method(30);

        /**
         * 无参数，无返回
         */
        LambdaInter.NoReturnParam noReturnParam = () ->
                System.out.println("无参数，无返回");
        noReturnParam.method();


        /**
         * 多参数，有返回
         */
        LambdaInter.ReturnMuliteParam returnMuliteParam = (a, b) -> a + b;
        int lena = returnMuliteParam.method(11 ,22);
        System.out.println("多参数，有返回 lena = "+ lena);

        /**
         * 单参数，有返回
         */
        LambdaInter.ReturnOneParam returnOneParam = (a) -> ++a;
        int lemb = returnOneParam.method(87);
        System.out.println("单参数，有返回 lemb = "+ lemb);

        /**
         * 无参数，有返回
         */
        LambdaInter.ReturnParam returnParam = () -> 1;
        int lemc = returnParam.method();
        System.out.println("无参数，有返回 lemc = "+ lemc);
    }

}


