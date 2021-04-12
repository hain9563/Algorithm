/*
동일한 자리에 위치하면 스트라이크 한 번으로 센다.
다른 자리에 위치하면 볼 한 번으로 센다.

나올 수 있는 수는 123~999 인데 0이 포함된 수는 생각x(각 자릿수는 1~9만 가지고 있음)
가능 범위 123~987
각 숫자별로 strike랑 ball 세버리기

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baseball {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][3];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        boolean[] check = new boolean[988];

        int il, sip, baak, num, num_il,num_sip,num_baak;
        int answer = 0;

        for(int i=123 ;i<988;i++){
            il = i%100%10;  //일의 자리
            sip = i%100/10; //십의 자리
            baak = i/100;   //백의 자리

            if(il == sip || sip == baak || il == baak)  continue;   // 자릿수 같은 것 제외
            if(il == 0 || sip == 0)    continue;    // 자릿수에 0있는거 제외

            int strike = 0;
            int ball =0;
            int isTrue = 0;

            for(int j=0;j<N;j++){   //주어진 테스트케이스 만큼
                num = input[j][0];
                num_il = num%100%10;
                num_sip = num%100/10;
                num_baak = num/100;

                if(il == num_il)  strike++;   //서로의 자릿수 값이 같으면
                if(sip == num_sip) strike++;
                if(baak == num_baak) strike++;

                if(il == num_sip) ball++; //자릿값이 하나라도 같으면
                if(il == num_baak) ball++;
                if(sip == num_il)   ball++;
                if(sip == num_baak) ball++;
                if(baak == num_il)  ball++;
                if(baak == num_sip) ball++;

//                System.out.println("i : "+i+" num : "+num+" strike : "+ strike+" ball : "+ball + "\n");
                if(strike == input[j][1] && ball == input[j][2])    isTrue++;
                ball = 0;
                strike = 0;
            }

            if(isTrue == N) answer++;
        }
        System.out.println(answer);
    }
}
