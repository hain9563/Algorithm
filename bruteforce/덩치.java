import java.util.*;

public class 덩치 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int[] answer = new int[n];

        for(int i=0;i<n;i++){
            answer[i] = 1;
            for(int j=0;j<2;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    answer[i]++;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(answer[i]+ " ");
        }
    }
}
