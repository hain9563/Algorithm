import java.util.Scanner;

public class 일로만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];

        for(int i=2;i<n+1;i++){
            a[i] = a[i-1] +1;
            if(i%3 == 0)    a[i] = Math.min(a[i], a[i/3]+1);
            if(i%2 == 0)    a[i] = Math.min(a[i], a[i/2]+1);

        }
        System.out.println(a[n]);
    }
}
