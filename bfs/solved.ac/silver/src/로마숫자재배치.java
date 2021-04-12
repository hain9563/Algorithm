import java.util.Scanner;

public class 로마숫자재배치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        if(input.contains("VI")){
            input = input.replace("VI", "IV");
        }
        else if(input.contains("LX")){
            input = input.replace("LX", "XL");
        }
        else if(input.contains("XI")){
            input = input.replace("XI", "IX");
        }

        System.out.println(input);
    }
}
