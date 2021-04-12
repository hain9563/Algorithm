import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

public class P3 {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }


    public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];
//        String[][] rule = new String[flag_rules.length][2];
        HashMap<String, String> rule = new HashMap<String, String>();
        String[] flag_name = new String[flag_rules.length];
        // 각 명령어의 형식 맵핑
        for(int i=0;i<flag_rules.length;i++){
            String[] temp = flag_rules[i].split(" ");
            rule.put(temp[0], temp[1]);
        }


        for(int i=0;i<commands.length;i++){
            String[] command = commands[i].split(" ");

            // 1. 프로그램 명 확인
            if(!command[0].equals(program)){
                continue;
            }
            // 2. 명령어 일치 여부
            String currentCmd = "";
            boolean flag = false;
            boolean flag2 = false;

            for(int j=1;j<command.length;j++){
                if(!rule.containsKey(command[j])) {  // 존재하지 않는 flag name인 경우
                    flag = true;
                    break;
                }

                currentCmd = command[j];
//                System.out.println(currentCmd);
                int numOfParam = 0;

                while(j+1 != command.length && !command[j+1].contains("-")){ // 다음 idx의 string이 flag name 일 때까지
//                    System.out.println(command[j]);
                    if(rule.get(currentCmd).equals("STRING")){
                        numOfParam++;
                        j++;
                        if (isNumeric(command[j]) || numOfParam > 1) {    // 파라미터가 숫자이면 다음 command 확인
                            flag = true;
                            break;
                        }

                    }
                    else if(rule.get(currentCmd).equals("STRINGS")){
                        if (isNumeric(command[j + 1])) {    // 파라미터가 숫자이면 다음 command 확인
                            flag = true;
                            break;
                        }
                        j++;
                    }
                    else if(rule.get(currentCmd).equals("NUMBER")) {
                        numOfParam++;
                        j++;
                        if (!isNumeric(command[j]) || numOfParam > 1) {
                            flag = true;
                            break;
                        }
                    }
                    else if(rule.get(currentCmd).equals("NUMBERS")){
                        if (!isNumeric(command[j + 1])) {    // 파라미터가 숫자이면 다음 command 확인
                            flag = true;
                            break;
                        }
                        j++;
                    }
                    else if(rule.get(currentCmd).equals("NULL")) {
                        if (j == command.length - 1) break; //만약 -e의 위치가 가장 마지막 idx라면 다음 명령어로 넘어감
                        if (!(command[j + 1].equals("-n") || command[j + 1].equals("-s"))) {
                            flag = true;
                            break;
                        }
                    }
                    else {
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    answer[i] = true;
                }
            }

        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }
    public static void main(String[] args) {
        boolean[] a = solution("line", new String[] {"-s STRINGS", "-n NUMBERS", "-e NULL"}, new String[] {"line -n 100 102 -s hi hello -e", "line -n id pwd -n 100"});
        boolean[] b = solution("trip", new String[] {"-days NUMBERS", "-dest STRING"}, new String[] {"trip -days 15 10 -dest Seoul Paris"});
    }
}
