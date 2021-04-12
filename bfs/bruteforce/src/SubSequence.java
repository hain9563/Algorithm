import java.util.Arrays;
import java.util.Scanner;

public class SubSequence {
    private static int count = 0;
    public static void backtrack(int[]a, int sum, int index, int s) {
        if(index >= a.length) {
            if(sum == s) {
                count ++;
            }
            return;
        }

        backtrack(a, sum+a[index], index+1, s);
        backtrack(a, sum, index+1, s);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //정수의 개수
        int s = scan.nextInt(); //부분수열을 더한 값
        int [] a = new int[n];

        for(int i=0; i<n; i++)
            a[i] = scan.nextInt();
        backtrack(a, 0, 0, s);
        if(s == 0) count--; // 주어진 정수에서 아무것도 선택하지 않은 경우(2^n -1)
        System.out.println(count);
    }

}
