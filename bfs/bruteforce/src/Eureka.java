import java.util.*;

// 유레카 이론 : 삼각수끼리의 최대 3개의 합으로 모든 수를 표현할 수 있다.
// 이때 정확히 3개의 삼각수로 표현이 가능한 수면 1 아니면 0을 반환

public class Eureka {

    // 각 삼각수는 중복이 가능하므로 중복조합을 이용한다.
    // 중복조합은 [0,0], [1,1,2] 와 같은 꼴을 허용한다.
    static void recombination(int[] nums , int[] ans , int n , int r ,int idx , int target, List<Integer> tri ) {
        if( r == 0 ){
            int temp = 0;
            for(int i : ans) {
                temp = temp + i;
            }
            tri.add(temp);
            return;
        }

        if(target == n) return;
        ans[idx] = nums[target];
        recombination(nums, ans , n , r-1, idx+1, target, tri);
        recombination(nums, ans , n , r , idx , target+1, tri);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] testcase = new int[n];
        boolean[] yes_or_no = new boolean[n];
        int[] triangle = new int[44]; // 입력이 1000까지 이므로 최대 n은 44
        List<Integer> non_tri = new ArrayList<>();
//        int[] non_triangle = new int[1936];
        int[] comArr = new int[3];


        for(int i=0;i<n;i++){
            testcase[i] = sc.nextInt();
        }

        for(int i=0;i<44;i++){  //삼각수 공식 n(n+1)/2
            triangle[i] = (i+2)*(i+1)/2;
        }

        int[] ans2 = new int[3];    // 3개의 중복조합을 구해야하므로 r=3
        recombination(triangle, ans2, 44 ,3, 0 ,0 , non_tri);

        for(int i=0;i<testcase.length;i++){
            for(int j=0;j<non_tri.size();j++){  // 만약 input이 삼각수와 같다면 배열에 true로 set
                if(testcase[i] == non_tri.get(j))   yes_or_no[i] = true;
            }
            if(!yes_or_no[i]){  //3개로 된 합이 아닌경우
                System.out.println("0");
            } else{
                System.out.println("1");
            }
        }


    }
}
