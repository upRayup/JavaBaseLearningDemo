package demo01;

public class demo_lambda {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).start();
        
    }
}
