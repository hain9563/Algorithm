
import java.util.Arrays;
import java.util.Scanner;

public class Decomposition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        int length = (int)(Math.log10(N)+1);    //N의 자릿수
        int max = (int) Math.pow(10, length);
        String[] num = new String[max];
        String format = "%0"+length+"d";

        for(int i=0;i<max;i++){   //1~ N-1 까지 자릿수 formatting 해서 num에 String으로 집어넣음
            num[i] = String.format(format, i);
        }

        for(int i=1;i<max;i++){
            String[] temp = num[i].split("");
            int a = N;
            for(int j=0;j<temp.length;j++){ //N에서 빼보기
                a = a - Integer.parseInt(temp[j]);
            }
            if(a<0) continue;
            String[] M = Integer.toString(a).split("");
//            System.out.println(Arrays.toString(M));
            int aa = a;
            for(int k =0;k<M.length;k++){   //뺐던 것을 다시 더해보기
                aa = aa + Integer.parseInt(M[k]);
            }
            if(aa == N){    //만약 뺐던 것에서 다시 더했는데 N과 같다면
//                System.out.println(temp[0] + temp[1] + temp[2]);
                answer = a;
            }
        }
        System.out.println(answer);
    }
}
