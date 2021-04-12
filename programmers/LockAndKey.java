public class LockAndKey {
    static int[][] rotateClockwise(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int[][] temp = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                temp[i][j] = matrix[rowNum - j - 1][i];
            }
        }
        return temp;
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int M = key.length;
        int N = lock.length;
        int[][] arr = new int[2*M+N-2][2*M+N-2];    // 7x7

        for(int i=M-1;i<arr.length-M+1;i++){
            for(int j=M-1;j<arr.length-M+1;j++){
                arr[i][j] = lock[i-M+1][j-M+1];
            }
        }

        int[][]arr_copy = new int[2*M+N-2][2*M+N-2];
        for (int i = 0; i < arr_copy.length; i++) {
            System.arraycopy(arr[i], 0, arr_copy[i], 0, arr[i].length);
        }

        int[][] rotated = new int[key.length][key.length];
        int count=0;

        // M(key) <= N(lock)
        for(int i=0;i<arr.length-M+1;i++){
            for(int j=0;j<arr.length-M+1;j++) {
                for (int r = 0; r < 4; r++) {
                    key = rotateClockwise(key);
                    for (int k = i; k < i + M; k++) {
                        for (int q = j; q < j + M; q++) {
                            arr[k][q] = arr[k][q] + key[k - i][q - j];
                        }
                    }// key와 lock 더해보기 done

//                    for (int x = 0; x < arr.length; x++) {
//                        for (int y = 0; y < arr.length; y++) {
//                            System.out.print(arr[x][y] + " ");
//                        }
//                        System.out.println("");
//                    }

                    //check lock
                    for (int k = M - 1; k < M + N - 1; k++) {
                        for (int q = M - 1; q < M + N - 1; q++) {
                            if (arr[k][q] == 1) {
                                count++;
                            }
                            if (count == N * N) return true;
                        }
                    }
                    count = 0;  //key와 더한 lock이 풀리지 못하면 0으로 초기화

                    //원래 상태로 돌려놓기
                    for (int x = 0; x < arr.length; x++) {
                        System.arraycopy(arr_copy[x], 0, arr[x], 0, arr_copy[x].length);
                    }

//                    System.out.println("");
                }
            }
        }

//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr.length;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println("");
//        }

        return answer;
    }
    public static void main(String[] args) {
//        boolean answer1 = solution(new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][] {{1, 1, 1,1}, {1, 1, 0,1}, {1, 0, 1,1},{1, 0, 1,1}});
        boolean answer2 = solution(new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
        System.out.println(answer2);
    }
}
