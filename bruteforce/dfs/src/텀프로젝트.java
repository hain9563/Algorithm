import java.util.Arrays;
import java.util.Scanner;

//https://dalconbox.tistory.com/157
//https://dundung.tistory.com/32


public class 텀프로젝트 {
    static int[] choice;    //각 학생이 선택한 학생 번호
    static int[] visited;   //시작 정점이 어딘지
    static int[] check;     //방문했는지 (시작에서부터 몇번째로 방문되는지)
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            n = sc.nextInt();
            choice = new int[n+1];
            check = new int[n+1];
            visited = new int[n+1];

            for(int i=1;i<n+1;i++){
                choice[i] = sc.nextInt();
            }
            int count = 0;
            for(int i=1;i<n+1;i++){
                if(check[i] == 0 ){
                    count += dfs(i,1, i);
                }
            }
            System.out.println(n-count);


        }
    }

    static int dfs(int x, int cnt, int start) {
        if(check[x] != 0){
            if(start != visited[x]) return 0;
            return cnt - check[x];
        }
        check[x] = cnt;
        visited[x] = start;
        return dfs(choice[x], cnt+1, start);
    }
}
