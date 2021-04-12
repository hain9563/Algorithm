import java.util.Scanner;

// 분해합 : M은 N의 생성자, M + M의 각자리수 = N
// N이 주어지면 역으로 M을 찾는 것

public class Decomposition_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int length = (int)(Math.log10(N)+1);    //N의 자릿수
        int max = (int) Math.pow(10, length);   //10의 N승을 저장 ex) N=3 , max = 1000
        int answer = 0;

        for(int i =1;i<max;i++){
            int minus = N;
            int digit = i;
            while(digit !=0){   //i의 자릿수마다 빼줌
                minus = minus - digit % 10;
                digit = digit / 10;
            }
            if(minus < 0) continue; //뺀것이 0보다 작으면 pass

            digit = minus;
            int plus = minus;
            int temp = minus;

            while(digit!=0){    //빼준애 + 빼준애의 각 자릿수
                plus = plus + digit % 10;
                digit = digit / 10;
            }
//            System.out.println(plus);
            if(plus == N)   answer = temp;  //원래 꺼랑 같으면 그게 답

        }
        System.out.println(answer);

    }
}
