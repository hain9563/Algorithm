import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class WareHouse {
    private static Object getKey(HashMap<Integer, Integer> m, Object value) {
        for(Object o: m.keySet()) {
            if(m.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    //입력 개수
        int max = 0;
        LinkedList<Integer> house = new LinkedList<>();
        HashMap<Integer,Integer> input = new HashMap<>();
        ArrayList<Integer> loc = new ArrayList<>(n);

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            max = Math.max(H, max);
            loc.add(L);
            input.put(L,H);
        }
//        System.out.println(max);
        Collections.sort(loc);

        for(int i=0;i<n-1;i++){
            if(input.get(loc.get(i)) == max)    break;
            if(input.get(loc.get(i)) < input.get(loc.get(i+1))){
                house.add(input.get(loc.get(i+1)));
            }
        }

        List<Integer> temp = new ArrayList<>();
        for(int i=n-1;i>0;i--){
            if(input.get(loc.get(i-1)) == max)    break;
            if(input.get(loc.get(i)) < input.get(loc.get(i-1))){
                temp.add(input.get(loc.get(i-1)));
            }
        }

        Collections.reverse(temp);
        house.addAll(temp);
        house.addFirst(input.get(loc.get(0)));
        house.addLast(input.get(loc.get(n-1)));

        System.out.println(house);
        int ret = 0;
        for(int i=0;i<house.size()-1;i++){
            if(house.get(i) == max) {
                ret += house.get(i);
                break;
            }
            int height = house.get(i);
            int width = (int) getKey(input, house.get(i+1)) - (int) getKey(input, house.get(i));
            ret += height * width;
            System.out.println("ret : "+ret);
        }
        System.out.println("ret : "+ret);
        for(int i=house.size()-1;i>0;i--){
            if(house.get(i) == max) break;
            int height = house.get(i);
            int width = (int) getKey(input, house.get(i)) - (int) getKey(input, house.get(i-1));
            ret += height * width;
            System.out.println("i-1 : "+(int) getKey(input, house.get(i-1)));
            System.out.println("i : "+(int) getKey(input, house.get(i)));
            System.out.println(ret);

        }

//        System.out.println(ret);
    }
}
