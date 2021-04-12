import java.util.Arrays;

// 모든 정점 -> 모든 정점까지의 최단 경로를 구하는 알고리즘
// for문이 3중으로 들어가기 때문에 N(정점 개수)가 상대적으로 적어야 한다.
// 이 문제의 경우 N의 개수가 최대 200개 이기 때문에 이 알고리즘의 적용이 가능하다.

public class Taxi {

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 20000000;
        int cost[][] = new int[n+1][n+1];
        final int INF = 20000000;

        for(int i = 0;i <= n;i++) {
            for(int j = 0;j <= n;j++) {
                if(i==j) cost[i][j] =0; // 정점이 같으면 거리가 0이므로
                else {
                    if (cost[i][j] == 0) cost[i][j] = INF;  //0으로 초기화 된 부분은 최대값으로 SET
                }
            }
        }

        //fares의 값으로 cost 초기화
        for(int i=0;i<fares.length;i++){    // a -> b 와 b-> a 의 cost는 같다.
            cost[fares[i][0]][fares[i][1]] = fares[i][2];
            cost[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        for (int k = 1; k < n+1; k++) { // 거치는 정점 K
            for (int i = 1; i < n+1; i++) { // 정점 K에 대해 모든 정점 순회
                for (int j = 1; j < n+1; j++) {
                    // 기존 거리와 정점을 거치는 거리 비교(i -> j 와 i -> k -> j)
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);

                }
            }
        }

        for(int i=1;i<n+1 ;i++){
//            System.out.println("answer : "+answer);
//            System.out.println("new one : "+cost[s][i] + cost[i][a] + cost[i][b]);
//            if(cost[s][i] + cost[i][a] + cost[i][b] == 0) continue;
            answer = Math.min(answer, cost[s][i] + cost[i][a] + cost[i][b]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4,1,10},{3,5,24},{5,6,2},{3,1,41},{5,1,24},{4,6,50},{2,4,66},{2,3,22},{1,6,25}};
        int answer = solution(6,4,6,2,fares);
        System.out.println(answer);
    }
}
