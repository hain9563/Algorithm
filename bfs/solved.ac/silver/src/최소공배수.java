import java.util.Scanner;

public class 최소공배수 {
    public static long gcd(long a, long b){
        while(b!=0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long answer = a * b/gcd(a,b);
        System.out.println(answer);
    }


}
