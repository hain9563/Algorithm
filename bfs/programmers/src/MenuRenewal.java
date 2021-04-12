//  A\w*?B  A로 시작해서 B로 끝나는 String 찾기
//  .*(B).*?(C).*?(F).*?(G).*

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MenuRenewal {

    private static String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<String>();
        List<String> comb = new ArrayList<>();      //orders로 들어온 모든 알파벳의 조합이 담기는 list

        String[] keyword = alphabetToInt(orders).split("");
        boolean[] visited = new boolean[keyword.length];
//        System.out.println(Arrays.toString(keyword));
//        System.out.println(Arrays.toString(orders));

        for (int num : course) {
            combination(keyword, visited, 0, keyword.length, num, comb);
//            System.out.println(comb);
            int[] count = new int[comb.size()]; //각 조합의 경우가 몇번 나왔는지 셈

            //orders 의 string보다 길이가 크면 regex로 비교
            for (int i = 0; i < orders.length; i++) {
                for (int j = 0; j < comb.size(); j++) {
                    String[] charArr = comb.get(j).split("");
                    String regexStr = "";
                    for (int k = 1; k < charArr.length; k++) {  //해당 조합이 나왔는지 찾기 위한 regex 만들기
                        regexStr = regexStr + ".*?" + charArr[k];
                    }
                    regexStr = ".*" + charArr[0] + regexStr + ".*";
                    if (orders[i].matches(regexStr)) count[j]++;    //regex와 맞으면 count

                }
            }
//            System.out.println(Arrays.toString(count));
            addMax(comb, count, answer );
            comb.clear();
        }

        Collections.sort(answer);   //나온 결과를 알파벳 순으로 정렬
        System.out.println(answer);
        String[] ans = answer.toArray(new String[answer.size()]);
        return ans;
    }

    static void combination(String[] arr, boolean[] visited, int start, int n, int r, List<String> a) {
        if(r == 0) {
            print(arr, visited, n, a);
            return;
        }
        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, a);
            visited[i] = false;
        }
    }

    private static String alphabetToInt(String[] arr){
        int[] a = new int[26];  //a-z 개수
        String keyword = "";
        for (int i =0;i<arr.length;i++) {
            char[] charArr = arr[i].toCharArray();
            Arrays.sort(charArr);      //알파벳 순으로 정렬
            arr[i] = new String(charArr);   //다시 string으로 넣어줌
            for (char c : charArr) {    //각 알파벳의 개수 새기
                a[c - 'A'] += 1;        // a[0] 가 A가 나온 횟수
            }
        }

        for(int i=0;i<26;i++){
            if(a[i]>1) keyword = keyword + (char) (i + 'A');    //만약 2번 이상 등장한 알파벳이면 조합을 구하는데 쓰임
        }
        return keyword;
    }


    static void print(String[] arr, boolean[] visited, int n, List<String> a) {
        String temp ="";
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                temp = temp + arr[i];
            }
        }
        a.add(temp);
    }

    static void addMax(List<String> comb, int[] count, List<String> answer){
        int max = -1;
        for(int num: count){
            if(num > max)   max = num;
        }

        for(int i=0;i<count.length;i++){
            if(max == 1) {      //만약 max가 1이면 메뉴가 2번 이상 주문 된 것이 아니므로 제외
                break;
            }
            else if(count[i] == max){
                answer.add(comb.get(i));
            }
        }
    }


    public static void main(String[] args) {
//        String[] a = solution(new String[]{"ABCFG", "CA", "EDC", "ACDE", "BCFG", "ACDEH"},new int[]{2,3,4});
        String[] a = solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},new int[]{2,3,5});
//        String[] a = solution(new String[]{"XYZ", "XWY", "WXA"},new int[]{2,3,4});
//        System.out.println(Arrays.toString(a));
//        String s = alphabetToInt(new String[] {"ABCFG", "CA", "EDC", "ACDE", "BCFG", "ACDEH"});
//        System.out.println(s);


    }
}
