import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실2 {
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

//        for(int i=0;i<N;i++){
//            for(int j=0;j<2;j++){
//                System.out.print(num[i][j]+" ");
//            }
//            System.out.println();
//        }

        int begin = 0;
        int end = 0;
        int temp = 0;
        int count = 0;
        for(int i=0;i<N;i++){
            begin = num[i][0];
            end = num[i][1];
            if(temp <= begin){
                temp = end;
                count++;
            }
        }
        System.out.println(count);
    }
}
