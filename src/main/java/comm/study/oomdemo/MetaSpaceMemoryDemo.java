/**
 * Copyright(c) 2018 asura
 */
package comm.study.oomdemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p></p>
 *
 * -XX:MetaspaceSize=5M -XX:MaxMetaspaceSize=5M - 设置元空间的大小
 *
 * 模拟MetaSpace内存溢出
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/24 4:44 下午
 */
public class MetaSpaceMemoryDemo {
    static class OOMTest{}

    static byte[] bytes = null;
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        int i = 0; //计数器
        try{
            while (true){
                /**
                 * Cglib的动态代理实现
                 */
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);//创建代理类对象
                enhancer.setUseCache(false);//是否缓存
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        return proxy.invokeSuper(obj,args);
                    }
                });//回调函数
            }
        }catch (Throwable e){
            System.out.println("*************对象被创建多少次后异常：" +i);
            throw e;
        }
    }
}
