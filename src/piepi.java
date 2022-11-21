import java.util.*;
import java.io.*;
import java.awt.*;

public class piepi {
    public static class pie implements Comparable<pie>{
        int id;
        int one;
        int two;
        pie(int blah, int id, int one, int two) {
            this.id = id;
            if(id < n) {
                this.one = one;
                this.two = two;
            } else {
                this.one = two;
                this.two = one;
            }
        }
        pie(int id, int one, int two) {
            this.id = id;
            this.one = one;
            this.two = two;
        }
        public int compareTo(pie o) {
            if(two == o.two) {
                return id - o.id;
            }
            return two - o.two;
        }
    }
    static int n;
    public static long[] bfs(ArrayList<pie> starts, TreeSet<pie> b, TreeSet<pie> e, int d) {
        long[] dists = new long[2 * n];
        Arrays.fill(dists, Long.MAX_VALUE);
        for(pie p : starts) {
            dists[p.id] = 0;
        }
        Queue<pie> queue = new LinkedList<>();
        for(pie p : starts) {
            queue.add(p);
        }
        while(!queue.isEmpty()) {
            pie temp = queue.remove();
            if(temp.id < n) {
                pie top = e.floor(new pie(2 * n, 0, temp.one));
                while(top != null && top.two >= temp.one - d) {
                    if(dists[top.id] > dists[temp.id] + 1) {
                        dists[top.id] = dists[temp.id] + 1;
                        queue.add(new pie(top.id, top.one, top.two));
                    }
                    top = e.lower(top);
                }
            } else {
                pie top = b.floor(new pie(2 * n, 0, temp.one));
                while(top != null && top.two >= temp.one - d) {
                    if(dists[top.id] > dists[temp.id] + 1) {
                        dists[top.id] = dists[temp.id] + 1;
                        queue.add(new pie(top.id, top.one, top.two));
                    }
                    top = b.lower(top);
                }
            }
        }
        return dists;
    }
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("piepie.in"));
        PrintWriter out = new PrintWriter(new File("piepie.out"));
        n = input.nextInt();
        int d = input.nextInt();
        TreeSet<pie> b = new TreeSet<>();
        TreeSet<pie> e = new TreeSet<>();
        ArrayList<pie> starts = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int one = input.nextInt();
            int two = input.nextInt();
            if(two == 0) {
                starts.add(new pie(0, i, one, two));
            }
            b.add(new pie(0, i, one, two));
        }
        for(int i = 0; i < n; i++) {
            int one = input.nextInt();
            int two = input.nextInt();
            if(one == 0) {
                starts.add(new pie(0, i + n, one, two));
            }
            e.add(new pie(0, i + n, one, two));
        }
        long[] temp = bfs(starts, b, e, d);
        for(int i = 0; i < n; i++) {
            if(temp[i] == Long.MAX_VALUE) {
                out.println(-1);
                continue;
            }
            out.println(temp[i] + 1);
        }
        out.close();
    }
}