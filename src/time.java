import java.util.*;
import java.io.*;
import java.awt.*;

public class time {
    public static long calculate(long d) {
        return c * d * d;
    }
    public static class query implements Comparable<query>{
        int pos;
        long distance;
        int days;
        query(int pos, long distance, int days) {
            this.pos = pos;
            this.distance = distance;
            this.days = days;
        }
        public int compareTo(query o) {
            if(distance < o.distance) {
               return -1;
            } else if(distance > o.distance) {
                return 1;
            } else return 0;
        }
    }
    public static long bfs(ArrayList<Integer>[] edgeList, int[] money) {
        long[] dist = new long[n];
        dist[0] = 0;
        PriorityQueue<query> pq = new PriorityQueue<>();
        pq.add(new query(0, 0, 0));
        while(!pq.isEmpty()) {
            query temp = pq.remove();
            for(Integer i : edgeList[temp.pos]) {
                if(temp.distance + money[i] - calculate(temp.days + 1) > dist[i]) {
                    dist[i] = temp.distance + money[i] - calculate(temp.days + 1);
                    pq.add(new query(i, temp.distance + money[i], temp.days + 1));
                }
            }
        }
        return dist[0];
    }
    static int n, m, c;
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("time.in"));
        PrintWriter out = new PrintWriter(new File("time.out"));
        n = input.nextInt();
        m = input.nextInt();
        c = input.nextInt();
        int[] money = new int[n];
        for(int i = 0; i < n; i++) {
            money[i] = input.nextInt();
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
        out.println(bfs(edgeList, money));
        out.close();
    }
}