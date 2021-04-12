/*
일곱 난쟁이
20
7
23
19
10
15
25
8
13
 */

import java.util.*;

public class Troll {
    static void print(int[] arr, boolean[] visited, int n, List<String> a){
        String temp = "";
        for(int i=0;i<n;i++){
            if(visited[i])  temp = temp + arr[i];
        }
        a.add(temp);
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r, List<String> a){
        if(r==0){
            print(arr, visited, n, a);
            return;
        }
        for(int i=start;i<n;i++){
            visited[i] = true;
            combination(arr, visited, i+1,n,r-1, a);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] troll = new int[9];
        int[] number = new int[9];
        boolean[] visited = new boolean[9];
        List<String> comb = new ArrayList<>();
        int sum = 0;
        String answer = "";
        for(int i=0;i<9;i++){
            troll[i] = sc.nextInt();
            number[i] = i;
        }

        combination(number, visited, 0, 9, 7, comb);    //9C7
        for (String s : comb) {
            String[] temp = s.split("");  //각 조합
//            System.out.println(s);
            for (String value : temp) { //조합에서 나오는 대로 sum에다가 더하기
                sum = sum + troll[Integer.parseInt(value)];
//                System.out.println(sum);
            }
            if(sum == 100){ // 합이 100이면 해당 조합을 answer에 저장
                answer = s;
//                System.out.println(answer);
            }
            sum = 0;
//            System.out.println("");
        }
//        System.out.println(answer);
        String[] splited = answer.split("");
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<splited.length;i++){
            list.add(troll[Integer.parseInt(splited[i])]);
        }
        Collections.sort(list);

        for(int i=0;i<splited.length;i++){
            System.out.println(list.get(i));
        }
    }
}
