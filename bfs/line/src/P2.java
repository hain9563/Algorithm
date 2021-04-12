import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2 {
    public static boolean isContinuousPattern(final String password) {
        if (password == null) return false;
        int count = 0;
        char c = 0; char before = 0;
        for (int i = 0; i < password.length(); i++) {
            c = password.charAt(i);
            if (c >= 48 && c <= 57 && (before + 1 == c)) {
                count++;
                if (count > 3) return true;
            }
            else {
                count = 0;
            }
            before = c;
        }
        return false;
    }


    public static int[] solution(String inp_str) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();
        if(inp_str.length() <8 || inp_str.length() > 15){
            ans.add(1);
        }
        if(inp_str.matches(".*[()\\-_=+].*")){
            ans.add(2);
        }
        int count = 0;
        if(inp_str.matches(".*[A-Z].*"))    count++;

        if(inp_str.matches(".*[a-z].*")){
            count++;
        }
        if(inp_str.matches(".*[0-9].*")){
            count++;
        }
        if(inp_str.matches(".*[~!@#$%^&*].*")){
            count++;
        }

        if(count <3)    ans.add(3);

        if(isContinuousPattern(inp_str))    ans.add(4);

        System.out.println(ans);
        return answer;
    }
    public static void main(String[] args) {
        int[] a = solution("AaTa+!12-3");
        int[] b = solution("aaaaZZZZ)");
        int[] c = solution("CaCbCgCdC888834A");
        int[] d = solution("UUUUU");
        int[] e = solution("ZzZz9Z824");

        if("AaTa+!12-3".matches(".*[A-Z].*")){
            System.out.println("true");
        }
    }
}
