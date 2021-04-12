import java.util.*;

public class PrinterQueue1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, m, count; // m의 인덱스는 0부터
        for(int i=0; i<t; i++) {
            LinkedList<int[]> queue = new LinkedList<>();
            count = 0;
            n=sc.nextInt(); //문서의 개수
            m=sc.nextInt(); //궁금한 문서
            for(int j=0; j<n; j++)  // 인덱스, 중요도 입력받기
                queue.add(new int[] {j, sc.nextInt()});
            while(!queue.isEmpty()){ // 큐가 빌 때까지
                int[] now = queue.poll();
                boolean able = true;
                for (int[] q : queue)
                    if(q[1] > now[1])   //더 중요한 값이 있으면 출력x
                        able = false;
                if (able) {             //현재 큐에서 가장 중요도가 높으면
                    count++;
                    if (now[0]==m) break;   //궁금했던 애면 출력
                }
                else {  //중요도가 낮은 거면 꼬리에 추가해줌
                    queue.add(now);
                }
            }
            System.out.println(count);
        }
    }
}