import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로찾기 {
    static int[][] graph;
    static int[] check;
    static int[][] path;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        check = new int[n];
        path = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){   //각 행마다 한번씩 확인해야하므로 초기화
                check[j] = 0;
            }
            for(int j=0;j<n;j++){
                if(graph[i][j] == 1 && check[j] == 0){
                    dfs(i,j);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(path[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static void dfs(int start, int end){
        check[end] = 1;
        path[start][end] = 1;
        for(int i=0;i<n;i++){
            if(check[i] == 0 && graph[end][i] == 1){
                dfs(start,i);
            }
        }

    }

}
