import javafx.print.PageLayout;

import java.text.ParseException;
import java.util.Date;

public class AdInsertion {
    public static String solution(String play_time, String adv_time, String[] logs) throws ParseException {
        String answer = "";
        int[] count = new int[36000];  //0초 ~ 359999초
        for(int i =0;i<logs.length;i++){
            String[] log = logs[i].split("-");
            int start = toSeconds(log[0]);
            int end = toSeconds(log[1]);
            for(int j=start;j< end;j++){
                count[j]++;
            }

        }



        return answer;
    }

    public static int toSeconds(String time){
        String[] splitted = time.split(":");
        int seconds = Integer.parseInt(splitted[0]) * 3600 + Integer.parseInt(splitted[1]) * 60 + Integer.parseInt(splitted[2]);
        return seconds;
    }

    public static void main(String[] args) throws ParseException {
        String result = solution("02:03:55","00:14:15", new String[] {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
    }
}
