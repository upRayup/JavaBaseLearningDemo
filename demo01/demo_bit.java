package demo01;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class demo_bit {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        show01();
//        show02();
//        show03();
//        show04();
//        show05();
//        show06();
//        show07();
        show08();
    }

    private static void show08() throws IOException, ClassNotFoundException {
        //反序列化流
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("c.txt"));
        Object o = ois.readObject();
        ois.close();
        Person o1=(Person)o;
        System.out.println(o1.getName()+" "+o1.getAge());
    }

    private static void show07() throws IOException{
        //序列化流
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("c.txt"));
        oos.writeObject(new Person("小新",5));
        oos.close();
    }

    private static void show06() throws IOException {
        //转换流默认使用utf-8
//        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("b.txt"));
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("b.txt"),"GBK");
        osw.write("转换流呀");
        osw.close();
    }

    private static void show05() throws IOException {
        FileInputStream fis=new FileInputStream("a.txt");
        BufferedInputStream bis=new BufferedInputStream(fis);
        byte []bytes=new byte[1024];
        int len=0;
        while((len=bis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        bis.close();
    }

    private static void show04() throws IOException {
        FileOutputStream fos=new FileOutputStream("a.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        bos.write("字节输出缓冲流".getBytes());
        bos.flush();
        bos.close();
    }

    private static void show03() throws IOException {
        Properties prop=new Properties();
        FileReader fr=new FileReader("demo_properties.txt");
        prop.load(fr);
        fr.close();
        Set<String> set = prop.stringPropertyNames();
        for(String k:set){
            String value = prop.getProperty(k);
            System.out.println(k+"="+value);
        }
    }


    private static void show02() throws IOException {
        Properties prop=new Properties();
        prop.setProperty("小明","18");
        prop.setProperty("小红","17");
        prop.setProperty("小军","19");

        FileWriter fw=new FileWriter("demo_properties.txt");
        prop.store(fw,"properties_save");
        fw.close();

    }

    private static void show01() {
        //不用写泛型，自动为String类型
        Properties prop=new Properties();
        prop.setProperty("小明","18");
        prop.setProperty("小红","17");
        prop.setProperty("小军","19");

        Set<String> p_set = prop.stringPropertyNames();
        for(String k:p_set){
            String value = prop.getProperty(k);
            System.out.println(k+":"+value);
        }
    }
}
