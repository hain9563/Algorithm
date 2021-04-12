import java.text.Format;
import java.util.Arrays;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
5
ABC*+DE/-
1
2
3
4
5

 */

public class PostfixCal {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());    //피연산자 개수
        char [] cmd = bf.readLine().toCharArray(); //후위연산식
        double [] operand = new double[n]; //피연산자 숫자 저장 배열
        for(int i=0;i<n;i++) operand[i] = Integer.parseInt(bf.readLine());

        Stack<Double> stack = new Stack<>();

        HashMap<Character, Double> map = new HashMap<>();
        // A-Z를 key로 두고 해당 숫자를 value로 저장
        for(int i =0;i<n;i++){
            map.put((char) (i+65), operand[i]);
        }

        double answer;
        for(char a : cmd){
            if((a >= 'A' && a <= 'Z')) {
                stack.push(map.get(a));    //피연산자인 경우 push
            }
            else{   //연산자인 경우
//                if(stack.size() <=1) {
//                    answer = stack.peek();
//                    stack.pop();
//                }
                double op2 = stack.pop();
                double op1 = stack.pop();
                switch (a){
                    case '*':
                        stack.push(op1 * op2);
                        break;
                    case '/' :
                        stack.push(op1 /op2);
                        break;
                    case '+' :
                        stack.push(op1 + op2);
                        break;
                    case '-' :
                        stack.push(op1 - op2);
                }
            }
        }
        answer = stack.peek();
        System.out.printf("%.2d", answer);




    }
}
