package demo_annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class main_test {
    public static void main(String[] args) throws IOException {
        Calculator cal=new Calculator();
        //用对象获取字节码文件
        Class<? extends Calculator> aClass = cal.getClass();
        //获取所有方法
        Method[] methods = aClass.getMethods();
        BufferedWriter bw=new BufferedWriter(new FileWriter("bug.txt"));
        int num=0;
        for (Method method : methods) {
            //检查是否有Check这个注解
            if(method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(cal);
                } catch (Exception e) {
                    num++;
                    bw.write(method.getName()+"方法出现异常");
                    bw.newLine();
                    bw.write("异常名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("--------------------------------");
                    bw.newLine();
                    bw.flush();
                }
            }
        }
        bw.close();
        System.out.println("一共出现了"+num +"次异常");
    }
}
