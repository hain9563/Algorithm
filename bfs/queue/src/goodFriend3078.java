/*
모든 학생은 자신과 반 등수의 차이가 K를 넘으면 친구가 아니라는거
좋은 친구는 이름의 길이가 같아야 된다

6 3
CYNTHIA
LLOYD
STEVIE
KEVIN
MALCOLM
DABNEY
 */
import java.util.*;
import java.util.stream.Collectors;

public class goodFriend3078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int count =0;
        List<String> names = new ArrayList<>(N);
        for(int i=0;i<N;i++){
            names.add(sc.next());
        }
        final Map<Integer, List<String>> all = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(all);

        for(Integer i : all.keySet()){
            List<String> sameLength = all.get(i);   //이름 길이가 같은 친구들
            for (int j = 0; j < sameLength.size()-1; j++)
                for (int k = j+1; k < sameLength.size(); k++)
                    if(Math.abs(names.indexOf(sameLength.get(j)) - names.indexOf(sameLength.get(k))) <= K)
                        count++;

        }
        System.out.println(count);
    }

}
