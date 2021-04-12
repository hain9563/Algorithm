import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
5
YCPZY
CYZZP
CCPPP
CCYZP
CPPZZ
 */

//빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y
public class CandyGame {
    public static void swap(String[][] array, int i1, int j1, int i2, int j2) {
        String tempObject = array[i1][j1];
        array[i1][j1] = array[i2][j2];
        array[i2][j2] = tempObject;
    }

    public static int numOfCandy(String[][] candy, int N){
        int temp = 1;
        int columnMax = -1;
        for(int i=0;i<N;i++){   // 위아래 비교
            temp = 1;   //column 하나 끝날때 마다 초기화
            for(int j=1;j<N;j++){
                if(candy[j-1][i].equals(candy[j][i])){  //위아래가 같으면
                    temp++;
//                    System.out.println("j-1 : "+ (j-1)+ " i : "+i);
                }else{  //같지 않으면 다시 초기화
                    columnMax = Math.max(temp, columnMax);
                    temp = 1;
                }
            }
            columnMax = Math.max(temp, columnMax);
        }

        int rowMax = -1;
        for(int i=0;i<N;i++){   //왼오 비교
            temp = 1;
            for(int j=1;j<N;j++){
                if(candy[i][j-1].equals(candy[i][j]))   temp++;
                else{
                    rowMax = Math.max(temp, rowMax);
                    temp = 1;
                }
            }
            rowMax = Math.max(temp, rowMax);
        }
        int max = Math.max(rowMax, columnMax);
        return max;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] candy = new String[N][N];
        for(int i=0;i<N;i++){
            String[] a = br.readLine().split("");
            for(int j =0;j<N;j++){
                candy[i][j] = a[j];
            }
        }


        int result = 0;
        for(int i=0;i<N;i++){
            for(int j =1;j<N;j++){
                swap(candy, j,i,j-1,i);
                result = Math.max(result, numOfCandy(candy, N));
                swap(candy, j,i,j-1,i);

                swap(candy, i, j-1, i, j);
                result = Math.max(result, numOfCandy(candy, N));
                swap(candy, i, j-1, i, j);

            }
        }
        System.out.println(result);

    }
}
