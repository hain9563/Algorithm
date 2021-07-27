import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 최빈수 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("test6.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			int[] counts = new int[101];
			int max = Integer.MIN_VALUE;
			int max_bin = 0;
			for(int j=0;j<1000;j++) {
				int a = sc.nextInt();
				counts[a]++;
			}
			
			for(int j=0;j<101;j++) {
				if(max <= counts[j]) {
					max_bin = j;
					max = counts[j];
				}
			}
			System.out.println("#"+n+" "+max_bin);
			
		}
	}

}
