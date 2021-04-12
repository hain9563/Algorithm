import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 멀티탭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //멀티탭 개수
        int K = sc.nextInt();   //
        int[] index = new int[K+1];
        List<Integer> multiTab = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        input.add(0);
        for(int i=1;i<=K;i++){
            int num = sc.nextInt();
            index[num] = i;
            input.add(i, num);
        }

        int count = 0;
        int max_num = 0;
        for(int i=1;i<K+1;i++){
            if(!multiTab.contains(input.get(i)) && multiTab.size() < N) multiTab.add(input.get(i)); // 콘센트 꽂기
            else if (multiTab.contains(input.get(i)))   continue;   //현재 꽂혀있는 멀티탭에 있는 거면 다음으로
            else if (multiTab.size() == N ) {   //멀티탭이 다 찬 경우
                for(int j = 0;j<multiTab.size();j++){   //더 이상 쓰이지 않는 것 제거
                    if(index[multiTab.get(j)] <= i){
                        multiTab.remove(j);
                        count++;
                        break;
                    }
                }
                if(multiTab.size() == N){   //현재 꽂혀있는 것 중 가장 마지막에 쓰이는 것 먼저 뺌
                    int max = -1;
                    List<Integer> subList = new ArrayList<>(input.subList(i+1, K+1));
//                    System.out.println(multiTab);
//                    System.out.println(subList);
                    for (int j = 0; j < multiTab.size(); j++) {
                        if (subList.indexOf(multiTab.get(j)) > max) {
                            max = subList.indexOf(multiTab.get(j));
                            max_num = multiTab.get(j);
                        }
                    }
                    multiTab.remove((Integer) max_num);
                    count++;
                }
                multiTab.add(input.get(i));

            }
//            System.out.println(multiTab);
        }
        System.out.println(count);

    }
}