package demo01;

public class happy_number {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    public static boolean isHappy(int n) {
        int fast=n,slow=n;
        do{
            slow=num(slow);
            fast=num(fast);
            fast=num(fast);
        }while(slow!=fast);
        return (fast==1);
    }
    public static int num(int n){
        int sum=0;
        while(n!=0){
            sum+=Math.pow(n%10,2);
            n/=10;
        }
        return sum;
    }
}
