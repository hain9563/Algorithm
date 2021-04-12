import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class GuitarPlay {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        Stack<Integer>[] stack = new Stack[7];  //줄의 수(6개) 만큼 stack 생성
        int count = 0;

        for(int i=1;i<=6;i++){
            stack[i] = new Stack<Integer>();
            stack[i].push(0);
        }

        for(int i =0; i<n;i++){
            st = new StringTokenizer(bf.readLine());    //각 음에 해당하는 플랫 stack에 하나씩 넣어주기
            int line = Integer.parseInt(st.nextToken());
            int flat = Integer.parseInt(st.nextToken());

            while(stack[line].peek() > flat) {  //새로 들어온 플랫이 작으면 pop
                stack[line].pop();
                count++;
            }

            if(stack[line].peek() < flat){  //새로 들어온 플랫이 크면 push
                stack[line].push(flat);
                count++;
            }
            //새로 들어온 플랫이 top과 같으면 아무것도 안해줘도 되므로 조건문 x
        }
        System.out.println(count);
    }
}
