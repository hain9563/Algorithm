import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 제곱수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];

        a[1] = 1;
        for(int i=2;i<=n;i++){
            int temp = (int) Math.sqrt(i);
            int power = (int) Math.pow(temp, 2);
            if(power == i){ //제곱수인 경우
                a[i] = 1;
            }
            else{   //제곱수가 아닌 경우
                int min = 100000;
                int small = (int) Math.pow(temp - 1, 2);
                if(small == 0)  a[i] = a[power] + a[i - power];
                else {
                    for (int j = temp; j > temp / 2; j--) {
                        int check = (int) Math.pow(j, 2);
//                        System.out.println("i : "+i+" j : "+j + " check : "+ check);
                        min = Math.min(min, a[check] + a[i - check]);

                    }
                    a[i] = min;
                }
            }
        }
        System.out.println(a[n]);
    }
}
