/**
 * Copyright(c) 2018 asura
 */
package comm.study.jucdemo;

import comm.study.bean.Emp;

import java.util.concurrent.atomic.AtomicReference;

/**
 * <p></p>
 *
 * 原子引用
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/10 10:49 下午
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        Emp emp1 = new Emp("liuzhen", 24);
        Emp emp2 = new Emp("xiaoying" , 26);

        //主内存初始对象设置为emp1
        AtomicReference<Emp> reference = new AtomicReference<>();
        reference.set(emp1);
        System.out.println("初始化的对象："+reference.get().toString());
        //将emp1与主内存的对象比较 ，并交换为emp2
        boolean a = reference.compareAndSet(emp1,emp2);
        System.out.println("交换结果："+ a +"，第一次交换后的对象："+reference.get().toString());

        //将emp1与主内存对象比较，并交换为emp1
        boolean b = reference.compareAndSet(emp2,emp1);
        System.out.println("交换结果："+ b +"，第二次交换后的对象："+reference.get().toString());



    }

}


