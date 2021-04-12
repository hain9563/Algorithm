import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chess {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String[][] input = new String[M][N];

        String[][] B = {{"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"}};

        String[][] W = {{"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"}};

        for (int i = 0; i < M; i++) {
            input[i] = br.readLine().split("");
        }

        int Bcount = 0;
        int Wcount = 0;
        int min = 100;
        int temp = 100;
        for (int i = 0; i + 8 <= M; i++) {
            for (int j = 0; j + 8 <= N; j++) {
                for (int k = i; k < i + 8; k++) {
                    for (int q = j; q < j + 8; q++) {
                        if (!input[k][q].equals(B[k - i][q - j])) {
                            Bcount++;
//                                System.out.println(input[k][q]+" "+B[k-i][q-j] );
                        }
                        if (!input[k][q].equals(W[k - i][q - j])) {
                            Wcount++;
//                                System.out.println(input[k][q]+" "+W[k-i][q-j] );
                        }
                    }
                }
                temp = Math.min(Wcount, Bcount);
                min = Math.min(temp, min);
                Wcount = 0;
                Bcount = 0;
            }
//                System.out.println(count);
        }

        System.out.println(min);
    }
}


