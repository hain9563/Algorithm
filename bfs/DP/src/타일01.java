import java.util.Scanner;

public class 타일01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        long[] a = new long[n+1];
        a[0] = 1;
        a[1] = 1;
        for(int i=2;i<=n;i++){
            a[i] = a[i-2]%15746 + a[i-1]%15746;
        }
        System.out.println(a[n]%15746);
    }
}
