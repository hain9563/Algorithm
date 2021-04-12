import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 과제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dw = new int[N][2];

        int last = -1;
        for(int i=0;i<N;i++){
            for(int j=0;j<2;j++){
                dw[i][j] = sc.nextInt();
                last = Math.max(last, dw[i][0]);    //제일 큰 d-day 저장
            }
        }

        Arrays.sort(dw, new Comparator<int[]>() {   //점수 기준 내림차순, 점수가 같은 경우 d-day 오름차순
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])  return o1[0]-o2[0];
                else    return o2[1]-o1[1];
            }
        });

        int[] toDo = new int[last+1];
        for(int i=0;i<N;i++){
            if(toDo[dw[i][0]] == 0 )    toDo[dw[i][0]] = dw[i][1];
            else{
                for(int j=dw[i][0]-1;j>=1;j--){
                    if(toDo[j] == 0 ){  //d-day보다 작은 인덱스가 비어있으면 채움
                        toDo[j] = dw[i][1];
                        break;
                    }
                }

            }
        }
//        System.out.println(Arrays.toString(toDo));
        int sum=0;
        for(int i=0;i<last+1;i++){
            sum = sum+ toDo[i];
        }
        System.out.println(sum);

//        for(int i=0;i<N;i++){
//            for(int j=0;j<2;j++){
//                System.out.print(dw[i][j]+" ");
//            }
//            System.out.println("");
//        }

    }
}
