import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 탈출 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextByte();

        int[] computer = new int[p+1];
        int[][] reserve = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                reserve[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(reserve, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])  return o1[1] - o2[1];
                else    return o1[0] - o2[0];
            }
        });

//        for(int i=0;i<n;i++) {
//            for (int j = 0; j < 2; j++) {
//                System.out.print(reserve[i][j] + " ");
//            }
//            System.out.println("");
//        }
        for(int i=0;i<n;i++) {

                if(reserve[i][1] > h )  continue;
                computer[reserve[i][0]] = reserve[i][1]+1;

        }
        System.out.println(Arrays.toString(computer));

        for(int i=1;i<p+1;i++){
            int a = computer[i] * 1000;
            System.out.println(i+" "+a);
        }
    }
}
