import java.util.Scanner;

public class NorK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int K = sc.nextInt();
        int count = 0;
        while(num != 1){
            if(num%K == 0){
                num = num /K;
                count++;
            }
            else{
                num = num - 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
