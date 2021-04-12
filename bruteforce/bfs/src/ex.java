import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int check[] =  new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        int count = 0;
        int min = -1;
        int move = 0;
        for(int i=0;i<3;i++){
            for(int j=i;;){
//                System.out.println(j);
                move = a[j];
                check[j] = 1;
                j = move + j;
                count ++;
                if(check[j] == 1){
//                    System.out.println(count);
                    break;
                }
            }
            min = Math.max(min, count+1);
            count = 0;
            move = 0;
            Arrays.fill(check, 0);
        }
        System.out.println(min);
    }


}
