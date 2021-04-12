import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchRank {
    public static <T> List<T> intersection(List<T> list1, List<T> list2) {
        if(list1 == null)   return list2;
        if(list2 == null)   return list1;
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }
        return list;
    }
    public static int[] solution(String[] info, String[] query) {
        String[][] apply = new String[info.length][5];
        String[][] condition = new String[query.length][5];

        List<Integer> java = new ArrayList<>();
        List<Integer> python = new ArrayList<>();
        List<Integer> cpp = new ArrayList<>();
        List<Integer> frontend = new ArrayList<>();
        List<Integer> backend = new ArrayList<>();
        List<Integer> junior = new ArrayList<>();
        List<Integer> senior = new ArrayList<>();
        List<Integer> pizza = new ArrayList<>();
        List<Integer> chicken = new ArrayList<>();
        List<Integer> score = new ArrayList<>();


        for(int i=0;i<info.length;i++){
            apply[i] = info[i].split(" ");
            for(int j=0;j<5;j++){
                if (j == 0) {
                    if(apply[i][0].equals("java"))  java.add(i);
                    else if(apply[i][0].equals("python"))   python.add(i);
                    else if(apply[i][0].equals("cpp"))  cpp.add(i);
                }
                else if(j==1){
                    if(apply[i][1].equals("frontend"))  frontend.add(i);
                    else    backend.add(i);
                }
                else if(j==2){
                    if(apply[i][2].equals("junior"))    junior.add(i);
                    else    senior.add(i);
                }
                else if(j==3) {
                    if (apply[i][3].equals("pizza")) pizza.add(i);
                    else chicken.add(i);
                }
                else if(j==4) {
                    score.add(Integer.parseInt(apply[i][4]));
                }
            }
        }

        List<Integer> language = new ArrayList<>();
        List<Integer> job = new ArrayList<>();
        List<Integer> career = new ArrayList<>();
        List<Integer> food = new ArrayList<>();
        List<Integer> X = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] answer = new int[query.length];

        for(int i=0;i<query.length;i++){
            condition[i] = query[i].replace("and ","").split(" ");
            for(int j=0;j<5;j++){
                if(j==0){
                    if(condition[i][0].equals("java")) language = java;
                    else if(condition[i][0].equals("python"))   language = python;
                    else if(condition[i][0].equals("cpp"))  language = cpp;
                    else language = null;
                }
                else if(j==1){
                    if(condition[i][1].equals("frontend"))  job = frontend;
                    else if(condition[i][1].equals("backend"))   job = backend;
                    else job = null;
                }
                else if(j==2){
                    if(condition[i][2].equals("junior"))    career = junior;
                    else if (condition[i][2].equals("senior"))    career = senior;
                    else career = null;
                }
                else if(j==3) {
                    if (condition[i][3].equals("pizza")) food = pizza;
                    else if (condition[i][3].equals("chicken")) food = chicken;
                    else food = null;
                }
                else if(j==4){
                    X.add(Integer.parseInt(condition[i][4]));
                }


            }
            int count=0;
            temp = intersection(language, job);
            temp = intersection(career, temp);
            temp = intersection(food, temp);

//            System.out.println(X.get(i));
            if(temp == null){// 점수빼고 모두 - 일때 OR 앞 조건에서 겹치는게 아무것도 없는 경우
                for(int k = 0; k < score.size(); k++) {
                    if (X.get(i) <= score.get(k)) {
//                        System.out.println(score.get(k));
                        count++;
                    }
                }
            }else {
//                System.out.println("i : "+i+" temp : "+temp);
                for (int k = 0; k < temp.size(); k++) {
//                    System.out.println(score.get(temp.get(k)));
                    if (score.get(temp.get(k)) >= X.get(i)){
//                        System.out.println(score.get(temp.get(k)));
//                        System.out.println("조건 : "+X.get(i)+" 지원점수 : "+score.get(temp.get(k)));
                        count++;
                    }
                }
            }

            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260",
                "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250","- and backend and senior and - 150",
                        "- and - and - and chicken 100","- and - and - and - 150"});
        System.out.println(Arrays.toString(answer));
    }


}
