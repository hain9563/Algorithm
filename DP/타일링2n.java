import java.util.Scanner;

public class 타일링2n {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int [n+1];
        a[0] = 1;
        a[1] = 1;
        for(int i=2;i<=n;i++){
            a[i] = a[i-2]%10007 + a[i-1]%10007;
        }
        System.out.println(a[n]%10007);
    }
}
