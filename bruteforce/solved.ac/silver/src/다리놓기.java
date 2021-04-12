import java.util.Scanner;

public class 다리놓기 {
    static int[][] sum = new int[30][30];

    static int comb(int n, int r){
        if(sum[n][r] !=0)   return sum[n][r];
        if(r==0||r==n)  return 1;
        else{
            sum[n][r] = comb(n-1, r-1) + comb(n-1, r);
            return sum[n][r];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int p = sc.nextInt();
            int q = sc.nextInt();
            System.out.println(comb(q,p));
        }
    }

}
