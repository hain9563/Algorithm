import java.util.Arrays;
import java.util.Scanner;

public class 약수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //약수의 개수
        int[] divide = new int[n];
        for(int i=0;i<n;i++){
            divide[i] = sc.nextInt();
        }
        Arrays.sort(divide);

        System.out.println(divide[0] * divide[n-1]);
    }

}
