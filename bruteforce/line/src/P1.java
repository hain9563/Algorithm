import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1 {
    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        String[] job = new String[5];
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<languages.length;i++){
            map.put(languages[i], preference[i]);
        }
        int[] score = new int[5];
        int max = -1;
        for(int i=0;i<table.length;i++){
            String[] temp = table[i].split(" ");
            job[i] = temp[0];
            System.out.println(Arrays.toString(temp));
            for(int k=temp.length-1;k>0;k--) {
                for (int j = 0; j < languages.length; j++) {
                    if (temp[k].equals(languages[j])){
                        score[i] += (temp.length - k )*map.get(languages[j]);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(score));
        int result = 0;
        for(int i=0;i<score.length;i++){
            if(max == score[i]){
                System.out.println(job[i]);
                int a = job[i].compareTo(job[result]);
                if(a<0) return job[i];
            }
            if(max < score[i]){
                max = score[i];
                result = i;
            }
        }
        return job[result];
    }

    public static void main(String[] args) {
//        String a = solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"}, new String[] {"PYTHON", "C++", "SQL"}, new int[] {7,5,5} );
//        System.out.println(a);
                String b = solution(new String[]{ "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"}, new String[] { "JAVA", "JAVASCRIPT"}, new int[]{7,5});

    }
}
