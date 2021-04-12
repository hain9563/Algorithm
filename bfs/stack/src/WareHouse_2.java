import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
/*
7
2 4
11 4
15 8
4 6
5 3
8 10
13 6

[0,0,4]
 */
public class WareHouse_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    //입력 개수
        int[] input = new int[1001];
        int max=0;
        int maxIndex=0;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            input[L] = H;
            if(H>max){
                maxIndex = L;
                max = H;
            }
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> loc = new ArrayList<>();
        stack.push(0);
        int location = 0;
        int area = max;
        for(int i=0;i<=maxIndex;i++){
            if(input[i] >= stack.peek()) {  //큐의 top보다 크면 넣어준다.
                int width = i - location;   //가로축 빼기
                location = i;
                area += width * stack.peek();   //하나씩 넣을 때 마다 면적 계산
                stack.push(input[i]);   //maxIndex까지 가면서 오름차순으로 쌓이게 함
            }
        }

        location = 0;
        stack.clear();
        stack.push(0);
        for(int i=1000;i>=maxIndex;i--){         //끝에서부터 maxIndex까지 가면서 오름차순으로 쌓이게 함
            if(input[i] >= stack.peek()) {
                int width = location - i;
                location = i;
                area += width * stack.peek();
                stack.push(input[i]);
            }
        }
        System.out.println(area);
    }
}
