package demo01;

public class demo01_test {
	public static void main(String[] args) {
		new Thread(new Runnable()){
			public void run(){
				System.out.println(Thread.currentThread().getName());
			}
		}.start();
		
	}

}
