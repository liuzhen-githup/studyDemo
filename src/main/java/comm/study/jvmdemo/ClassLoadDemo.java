/**
 * Copyright(c) 2018 asura
 */
package comm.study.jvmdemo;

/**
 * <p></p>
 *
 * java在运行加载类中分为 3 大类加载器
 *   最底层 ： ClassLoad
 *   系统类加载器： AppClassLoader
 *   扩展类加载器：ExtClassLoader
 *   引导类加载器：BootStrap ClassLoad
 *
 *   我们在编写自定义类 使用的是系统类加载器加载的
 *   虚拟机的核心类库采用的是 引导类加载器加载
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/4 8:49 下午
 */
public class ClassLoadDemo {

    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(sysClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取其上层加载器 - 扩展类加载器
        ClassLoader extClassLoader = sysClassLoader.getParent();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@3cd1a2f1

        //获取上上层加载器 - 引导类加载器
        ClassLoader classLoader = extClassLoader.getParent();
        System.out.println(classLoader);

        //获取当前类的类加载器 - 使用的是系统类加载器加载
        ClassLoader classLoader1 = ClassLoadDemo.class.getClassLoader();
        System.out.println(classLoader1);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //String类使用的是引导类加载器加载 - 虚拟机核心类库使用引导类加载器
        ClassLoader classLoader2 = String.class.getClassLoader();
        System.out.println(classLoader2);
    }
}
