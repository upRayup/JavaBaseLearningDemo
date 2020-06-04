package demo_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class reflect_try {
    public static void main(String[] args) throws Exception {
        Class<Person> prc = Person.class;
        Person person=new Person();
        //获取成员变量，获取一个公有的
//        Field name = prc.getField("Name");
//        Object name1 = name.get(person);
//        System.out.println(name1);

        //获取所有公有的成员变量
//        Field[] f = prc.getFields();
//        for (Field field : f) {
//            Object name2 = field.get(person);
//            System.out.println(name2);
//        }

        //获取一个成员变量
//        Field age = prc.getDeclaredField("age");
//        //访问私有成员变量的时候，需要访问权限
//        age.setAccessible(true);
//        age.set(person,100);
//        Object age1 = age.get(person);
//        System.out.println(age1);

        //获取所有成员变量
//        Field[] all = prc.getDeclaredFields();
//        for (Field field : all) {
//            System.out.println(field);
//        }

//        //获取构造方法
//        Constructor<Person> constructor = prc.getConstructor(String.class, int.class);
//        //创建对象
//        Person p = constructor.newInstance("Ray", 22);
//        System.out.println(p);

        //获取方法，无参
        Method m = prc.getMethod("eat");
        //执行方法
        m.invoke(person);
        //获取方法，有参
        Method m1 = prc.getMethod("eat", String.class);
        //执行方法
        m1.invoke(person,"shit");
        //获取方法名称
        Method[] methods = prc.getMethods();
        for (Method mm : methods) {
            System.out.println(mm);
            System.out.println(mm.getName());
        }
    }
}
