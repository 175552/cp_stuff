import java.util.*;
import java.io.*;
import java.awt.*;

public class timetake2 {
    public static class query{
        long money;
        long time;
        int cur;
        query(int cur, long money, long time) {
            this.cur = cur;
            this.money = money;
            this.time = time;
        }
    }
    public static long convert(int c, long time) {
        return c * time * time;
    }
    public static long bfs(int n, int c, int[] cities, ArrayList<Integer>[] edgeList) {
        long[] dist = new long[n];
        dist[0] = cities[0];
        Queue<query> queue = new LinkedList<>();
        queue.add(new query(0, dist[0], 0));
        while(!queue.isEmpty()) {
            query temp = queue.remove();
            for(Integer i : edgeList[temp.cur]) {
                if(temp.money + cities[i] - convert(c, temp.time + 1) > dist[i]) {
                    dist[i] = temp.money + cities[i] - convert(c, temp.time + 1);
                    queue.add(new query(i, temp.money + cities[i], temp.time + 1));
                }
            }
        }
        return dist[0];
    }
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("time.in"));
        PrintWriter out = new PrintWriter(new File("time.out"));
        int n = input.nextInt();
        int m = input.nextInt();
        int c = input.nextInt();
        int[] cities = new int[n];
        for(int i = 0; i < n; i++) {
            cities[i] = input.nextInt();
        }
        ArrayList<Integer>[] edgeList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
           edgeList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int from = input.nextInt() - 1;
            int to = input.nextInt() - 1;
            edgeList[from].add(to);
        }
        out.println(bfs(n, c, cities, edgeList));
        out.close();
    }
}