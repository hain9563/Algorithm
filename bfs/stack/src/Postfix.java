import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Postfix {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split("");
        HashMap<String, Integer> op = new HashMap<String, Integer>();
        String answer = "";
        op.put("(",0);
        op.put("+",1);
        op.put("-",1);
        op.put("*",2);
        op.put("/",2);

        for(String a : input){
            if(a.matches("[A-Z]")) answer += a; //문자면 출력
            else {                                     //연산자인 경우
                if(a.equals("(")) {
                    stack.push(a);  // 여는 괄호이면 stack에 넣음
                }
                else if (a.equals(")")){  //닫는 괄호를 만나면 여는 괄호 나올때까지 pop
                    while(!stack.isEmpty()) {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                            break;
                        }
                        answer += stack.peek();
                        stack.pop();
                    }

                }
                else{   //+-*/ 이면 우선순위 비교  새로들어온 애의 우선순위가 작으면 pop
                    while(!stack.isEmpty() && ((op.get(stack.peek()) >= op.get(a)))){
                        answer +=stack.peek();
                        stack.pop();
                    }
                    stack.push(a);
                }
            }
        }

        while(!stack.isEmpty()){
            answer += stack.peek();
            stack.pop();
        }

        System.out.println(answer);
    }
}
