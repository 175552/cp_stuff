import java.util.*;
import java.io.*;
public class reststops {
    public static class stop implements Comparable<stop>{
        int pos;
        int taste;
        stop(int pos, int taste) {
            this.pos = pos;
            this.taste = taste;
        }
        public int compareTo(stop o) {
            return pos - o.pos;
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("reststops.in"));
        PrintWriter out = new PrintWriter(new FileWriter("reststops.out"));
        int l = input.nextInt();
        int n = input.nextInt();
        int rf = input.nextInt();
        int rb = input.nextInt();
        boolean[] max = new boolean[n];
        stop[] stops = new stop[n];
        for(int i = 0; i < n; i++) {
            stops[i] = new stop(input.nextInt(), input.nextInt());
        }
        Arrays.sort(stops);
        long curmax = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(stops[i].taste > curmax) {
                curmax = stops[i].taste;
                max[i] = true;
            }
        }
        long laststop = 0;
        long total = 0;
        for(int i = 0; i < n; i++) {
            if(max[i]) {
                total += (stops[i].pos - laststop) * (rf - rb) * stops[i].taste;
                laststop = stops[i].pos;
            }
        }
        out.println(total);
        out.close();
    }
}
