import java.util.Scanner;

// P일 중 L일 동안 사용 가능 , V일 휴가
public class Camping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int L,P,V,num;
        int i = 1;
        while(flag){
            L = sc.nextInt();
            P = sc.nextInt();
            V = sc.nextInt();
            if(L < 1 && P < 1 && V < 1)  break;
            if(V%P > L) num = (V/P) * L + L;
            else    num = (V/P) * L + V % P;
            System.out.println("Case "+i+": "+num);
            i++;
        }
    }
}
