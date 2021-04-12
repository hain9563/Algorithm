import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] num = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])  return o1[0]-o2[0];
                else    return o1[1]-o2[1];
            }
        });

        int count=0;
        int max = -1;
        for(int i=0;i<N;i++){
            count++;
            int temp = num[i][1];
            for(int j=i;j<N-1;j++){
                if(temp <= num[j+1][0]){
                    count++;
                    temp = num[j][1];
                }
            }
            max = Math.max(count, max);
            count = 0;
        }
        System.out.println(max);
//        for(int i=0;i<N;i++){
//            for(int j=0;j<2;j++){
//                System.out.print(num[i][j]+" ");
//            }
//            System.out.println();
//        }

    }
}
