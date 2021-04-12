import java.util.Arrays;
import java.util.Scanner;

public class Adventurer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] X = new int[N];
        int max = 0;
        for(int i=0;i<N;i++){
            X[i] = sc.nextInt();
            max = Math.max(max, X[i]);
        }



    }
}
