import java.util.Scanner;

public class 타일링2n_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];

        a[1] = 1;
        if(n>1) {
            a[2] = 3;
            for (int i = 3; i <= n; i++) {
                a[i] = a[i - 2] * 2 % 10007 + a[i - 1] % 10007;
            }
        }
        System.out.println(a[n]%10007);
    }
}
