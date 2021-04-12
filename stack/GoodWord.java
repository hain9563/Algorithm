import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class GoodWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0;i<n;i++){
            Stack<Character> stack = new Stack<>();
            char[] word = br.readLine().toCharArray();
            stack.push(word[0]);    //하나 미리 넣어놓기
            for(int j =1;j< word.length;j++){
                if(!stack.isEmpty() && stack.peek() !=word[j]){ //큐의 top과 다르면 push
                    stack.push(word[j]);
//                    System.out.println("PUSH : "+ word[j]);
                }
                else if(!stack.isEmpty() && stack.peek() == word[j]){   //큐의 top과 같으면 pop
                    char a = stack.peek();
                    stack.pop();
//                    System.out.println("POP : "+a);
                }
                else if(stack.isEmpty())    stack.push(word[j]);    //큐가 비어있는 경우
            }

            if(stack.isEmpty()) count++;    //위에서 한 결과 큐비 비어있다면 좋은 단어 + 1

        }
        System.out.println(count);

    }
}
