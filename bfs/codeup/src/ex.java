import java.util.Arrays;
import java.util.Scanner;

public class ex {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String time = sc.next();
        System.out.println(time);
        String[] a = time.split("\\.");
        System.out.println(Arrays.toString(a));

        System.out.printf("%02d-%02d-%04d",Integer.parseInt(a[2]),Integer.parseInt(a[1]),Integer.parseInt(a[0]));
    }
}
