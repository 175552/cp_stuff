import java.util.*;
import java.io.*;
import java.awt.*;

public class hayfeast {
    public static class haybale{
        int taste;
        int spice;
        haybale(int taste, int spice) {
            this.taste = taste;
            this.spice = spice;
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("hayfeast.in"));
        PrintWriter out = new PrintWriter(new FileWriter("hayfeast.out"));
        int n = input.nextInt();
        long m = input.nextLong();
        haybale[] haybales = new haybale[n];
        for(int i = 0; i < n; i++) {
            haybales[i] = new haybale(input.nextInt(), input.nextInt());
        }
        int best = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        long sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> spice = new TreeSet<>();
        while(sum < m) {
            right++;
            sum += haybales[right - 1].taste;
            if(map.containsKey(haybales[right - 1].spice)) {
                map.put(haybales[right - 1].spice, map.get(haybales[right - 1].spice) + 1);
            } else {
                spice.add(haybales[right - 1].spice);
                map.put(haybales[right - 1].spice, 1);
            }
        }
        best = Math.min(best, spice.last());
        while(right < n) {
            sum -= haybales[left].taste;
            map.put(haybales[left].spice, map.get(haybales[left].spice) - 1);
            if(map.get(haybales[left].spice) == 0) {
                spice.remove(haybales[left].spice);
            }
            left++;
            while(sum < m && right < n) {
                right++;
                sum += haybales[right - 1].taste;
                if(map.containsKey(haybales[right - 1].spice)) {
                    if(map.get(haybales[right - 1].spice) == 0) {
                        spice.add(haybales[right - 1].spice);
                    }
                    map.put(haybales[right - 1].spice, map.get(haybales[right - 1].spice) + 1);
                } else {
                    spice.add(haybales[right - 1].spice);
                    map.put(haybales[right - 1].spice, 1);
                }
            }
            best = Math.min(best, spice.last());
        }
        out.println(best);
        out.close();
    }
}