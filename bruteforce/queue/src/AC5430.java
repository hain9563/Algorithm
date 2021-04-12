import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class AC5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); //테스트 케이스 개수
        String[] answer = new String[testCase];
        for(int i=0;i<testCase;i++){
            boolean reverse = false;
            boolean error = false;
            String[] cmd = br.readLine().split(""); //명령어
            int n = Integer.parseInt(br.readLine());    //배열 길이
            String arr_str;
            arr_str = br.readLine().replace("[","");
            arr_str = arr_str.replace("]","");
            String[] arr = arr_str.split(",");

            ArrayList<String> list = new ArrayList<String>();
            for(int j=0;j<n;j++){
                list.add(arr[j]);
            }

            for(int k=0;k<cmd.length;k++){
                switch(cmd[k]){
                    case "R":
                        reverse = !reverse;
                        break;
                    case "D":
                        if(list.isEmpty()){
                            error = true;
                            break;
                        } else if(reverse) { //뒤에서 부터 없앰
                            list.remove(list.size() - 1);
                        }else {
                            list.remove(0);
                        }
                }
            }
            if(reverse){
                Collections.reverse(list);
            }

            if(error){
                answer[i] = "error";
            } else{
                answer[i] = list.toString().replace(" ", "");
            }
        }
        for(int i =0 ;i<answer.length;i++){
            System.out.println(answer[i]);
        }

    }
}
