import java.util.*;

public class 센서 {
    static class Element implements Comparable<Element>{
        int index;
        int diff;
        public Element(int index, int diff) {
            this.index = index;
            this.diff = diff;
        }

        @Override
        public int compareTo(Element element) {
            return this.diff > element.diff ? 1 : -1;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //센서 개수
        int K = sc.nextInt();   //기지국 개수
        int[] sensor = new int[N];  //센서 위치

        for(int i=0;i<N;i++){
            sensor[i] = sc.nextInt();
        }

        Arrays.sort(sensor);

        int sum;
        if(K ==  1) sum = sensor[N-1] - sensor[0];
        else{
            PriorityQueue<Element> pq = new PriorityQueue<>(K - 1);
            int diff;
            for (int i = 0; i < N - 1; i++) {
                diff = sensor[i + 1] - sensor[i];
                if (pq.size() != K - 1) {   //queue의 크기가 다 안찼을 때
                    pq.offer(new Element(i, diff));
                } else if (pq.size() == K - 1) {  //queue가 full
                    if (pq.peek() != null && pq.peek().diff < diff) {
                        pq.poll();
                        pq.offer(new Element(i, diff));
                    }
                }
            }

//        while(!pq.isEmpty()) {
//            Element m = pq.poll();
//            System.out.println(m.index + " " + m.diff);
//        }

            sum = sensor[pq.peek().index] - sensor[0];
            for (int i = 1; i < K; i++) {
                if (pq.size() == 1) { //queue에 마지막 값만 남은 경우 sensor의 가장 마지막 인덱스에서 빼주기
                    sum = sum + sensor[N - 1] - sensor[pq.peek().index + 1];
                    break;
                }
                int before = sensor[pq.poll().index + 1];
                sum = sum + sensor[pq.peek().index] - before;

            }
        }
        System.out.println(sum);



    }
}
