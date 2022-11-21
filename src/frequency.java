import java.util.*;
public class frequency {
    public static int get(int temp) {
        int freq = 0;
        while(temp > 0) {
            //System.out.println(temp);
            freq += bit.get(temp);
            temp -= temp & (-temp);
        }
        return freq;
    }
    public static void update(int temp) {
        while(temp < n) {
            //System.out.println(temp);
            if(bit.containsKey(temp)) {
                bit.put(temp, bit.get(temp) + 1);
            } else bit.put(temp, 1);
            temp += temp & (-temp);
        }
    }
    static HashMap<Integer, Integer> bit = new HashMap<>();
    static int n;
    //10 100 -1000 100 2 1000000000 -1000 100 1000000000 1 2
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        for(int i = 0; i < n; i++) {
            int temp = input.nextInt();
            update(temp);
        }
        for(Integer i : bit.keySet()) {
            System.out.println(i + " " + bit.get(i));
        }
    }
}
