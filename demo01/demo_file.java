package demo01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo_file {
    public static void main(String[] args) throws IOException {
//        show01();
//        show02();
//        show03();
//        show04();
    }
    //字节输出流创建文件并写入值
    private static void show04() throws IOException {
        FileOutputStream fos=new FileOutputStream("b.txt");
        fos.write(97);
        fos.close();
    }
    //查看路径
    private static void show03() {
        File f3=new File("b.txt");
        System.out.println("绝对路径为"+f3.getAbsolutePath());
        System.out.println("相对路径为"+f3.getPath());
    }

    //用相对路径创建文件
    private static void show02() throws IOException {
        File f2=new File("b.txt");
        System.out.println(f2.createNewFile());
    }
    //用绝对路径创建文件
    private static void show01() throws IOException {
        File f1=new File("D:\\Java_code\\demo\\src\\demo01\\a.txt");
        System.out.println(f1.createNewFile());
    }


}
