import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

/*
7
2
1
4
5
1
3
3

stack에는 해당 높이의 index 값이 들어간다.
 */

public class Histogram {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());    //가로 칸
        int[] input = new int[n+2];   //각 높이
        for(int i=1;i<=n;i++)    input[i] = Integer.parseInt(bf.readLine());

        Stack<Integer> stack = new Stack<>();
        int area = 0;
        stack.push(0);   //처음에 일단 하나 채워줌
        for(int i=1;i<= n+1;i++){
//            if(stack.peek()<input[i])   stack.push(i);
//            else{   //top보다 현재가 작으면 pop
                while(!stack.isEmpty() && (input[stack.peek()] > input[i])){
                    int height = input[stack.peek()];   //현재 top의 높이
                    stack.pop();
                    area = Math.max(area, height*(i - stack.peek() -1));
//                    System.out.println(area);
                }
                stack.push(i);
//            }
        }
        System.out.println(area);
    }
}
