import java.util.*;
import java.io.*;
public class knives {
    public static class knife implements Comparable<knife>{
        int sharp;
        int size;
        int pos;
        knife(int sharp, int sie, int pos) {
            this.sharp = sharp;
            this.size = sie;
            this.pos = pos;
        }
        public int compareTo(knife o) {
            if(size == o.size) {
                return sharp - o.sharp;
            }
            return size - o.size;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        knife[] knifes = new knife[n];
        TreeSet<knife> sorted = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            knifes[i] = new knife(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
            if(!map.containsKey(knifes[i].size)) {
                map.put(knifes[i].size, knifes[i].sharp);
            } else {
                map.put(knifes[i].size, Math.max(knifes[i].sharp, map.get(knifes[i].size)));
            }
        }
        ArrayList<knife> newknifes = new ArrayList<>();
        for(Integer i : map.keySet()) {
            newknifes.add(new knife(map.get(i), i, 0));
        }
        Collections.sort(newknifes);
        for(int i = 0; i < newknifes.size(); i++) {
            newknifes.get(i).pos = i;
            sorted.add(newknifes.get(i));
        }
        long[] dp = new long[newknifes.size()];
        dp[0] = newknifes.get(0).sharp;
        for(int i = 1; i < newknifes.size(); i++) {
            knife temp = new knife(newknifes.get(i).sharp, newknifes.get(i).size - k, -1);
            try {
                dp[i] = Math.max(dp[i - 1], dp[sorted.lower(temp).pos] + newknifes.get(i).sharp);
            } catch(Exception e) {
                dp[i] = Math.max(dp[i - 1], newknifes.get(i).sharp);
            }
        }
        System.out.println(dp[newknifes.size() - 1]);
    }
}
