import java.util.*;

public class 박스채우기 {
    static class Cube implements Comparable<Cube>{
        int side;   //큐브의 한 변의 길이
        int number; //큐브 개수
        long cube_vol;   //큐브 하나의 부피

        public Cube(int s, int number) {
            this.side = s;
            this.number = number;
        }
        public void showInfo() {
            System.out.println(side+" "+number);
        }

        @Override
        public int compareTo(Cube cube) {
            if(this.side < cube.side)   return -1;
            else    return 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int length = sc.nextInt();
        int width = sc.nextInt();
        int height = sc.nextInt();
        int N = sc.nextInt();
        Cube[] cubes = new Cube[21];
        Arrays.fill(cubes, new Cube(0,0));
//        long[] max_cube_num = new long[N];

        for(int i=0;i<N;i++){
            int a = sc.nextInt();
            cubes[a] = new Cube(a, sc.nextInt());
        }

//        for(int i=0;i<21;i++){
//            cubes[i].showInfo();
//        }
        Arrays.sort(cubes);

        long temp;
        long count = 0;
        long side = (long) Math.pow(2, cubes[N-1].side);;
        long tmp = 0;
        long max_cube_num;
        long need;
        for(int i=20;i>=0;i--){    //한 변이 큰 것부터
            temp = (long) (side /  Math.pow(2, cubes[i].side));   // = 이전 cube 변 / 현재 cube 변
            side = (long) Math.pow(2, cubes[i].side);
            if(side > length && side > width && side > height) continue;
            else{
                tmp = (long) (tmp * Math.pow(temp, 3));
                max_cube_num = length / side * width / side * height / side;
                need = Math.min(cubes[i].number, max_cube_num - tmp);
                tmp = tmp + need;
                count = count + need;
            }

        }

        if(tmp == length * width * height) System.out.println(count);
        else    System.out.println("-1");
    }

//        if(volume > 0)  count = -1;
//        System.out.println(count);



//        for(int i=0;i<N;i++){
//            cubes[i].showInfo();
//        }

}
