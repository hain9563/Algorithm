import java.util.Scanner;

public class WaterLeak_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] num = new int[1001];

        for(int i=0;i<N;i++){

            num[sc.nextInt()] = 1;
        }

        int count = 0;
        for(int i=0;i<1001;i++){
            if(num[i] != 0){
                i = i + L-1;
                count++;
            }
        }

        System.out.println(count);
    }
}
