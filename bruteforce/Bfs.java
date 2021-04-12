import java.util.Scanner;

public class Bfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();   //1~ N 중에 선택할 개수
        int[] arr = new int[10];
        boolean[] visited = new boolean[10];
        bfs(arr, visited, N, M, 0, 0);

    }

    public static void bfs(int[] arr, boolean[] visited, int N, int M, int index, int cnt){
        if(cnt == M){
            for(int i=0;i<M;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
        }

        for(int i=index+1;i<=N;i++){
            if(!visited[i]){    //아직 방문하지 않았다면
                arr[cnt] = i;
                visited[i] = true;
                bfs(arr, visited, N, M, i, cnt + 1);
                visited[i] = false;

            }
        }
    }
}
