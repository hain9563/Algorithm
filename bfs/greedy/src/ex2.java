import java.util.Arrays;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] num = sc.next().split("");
        int[] num_arr = new int[num.length];

        for(int i=0;i<num_arr.length;i++){
            num_arr[i] = Integer.parseInt(num[i]);
        }

        int sum = num_arr[0];
        for(int i=1;i<num_arr.length;i++){
            if(num_arr[i-1] == 0){
                sum = num_arr[i]+ sum;
                System.out.println(sum);
            }
            else{
                sum = num_arr[i] * sum;
                System.out.println(sum);
            }
        }
        System.out.println(sum);

    }
}
