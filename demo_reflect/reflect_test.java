package demo_reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*
    需求：创建一个“框架”，不改动代码的情况下，可以帮助我们创建任意类的对象，执行任意方法

    方法：通过修改配置文件来实现
 */
@SuppressWarnings("all")
public class reflect_test {
    public static void main(String[] args) throws Exception {
        //创建一个properties对象，用load方法来获取
        Properties pro=new Properties();
        //获取本类的类加载器
        ClassLoader cl = reflect_test.class.getClassLoader();
        //用类加载器来获取配置文件的输入流
        InputStream is = cl.getResourceAsStream("pro.properties");
        pro.load(is);

        //获取propertie文件里的东西
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //把该类加载进内存
        Class<?> aClass = Class.forName(className);
        //加载进内存的类创建新的对象
        Object obj = aClass.newInstance();
        //获得该类的方法
        Method method = aClass.getMethod(methodName);
        //执行方法
        method.invoke(obj);
    }
}
