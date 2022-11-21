import java.util.*;
import java.io.*;
import java.awt.*;

public class shortcut {
    public static class edge{
        int to;
        int dist;
        edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    public static class query implements Comparable<query>{
        int node;
        long dist;
        query(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
        public int compareTo(query o) {
            if(dist < o.dist) {
                return -1;
            } else if(dist > o.dist) {
                return 1;
            } else return 0;
        }
    }
    static int[] parent;
    static long[] distances;
    static long[] pass;
    public static void dijkstra(ArrayList<edge>[] edgeList){
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        PriorityQueue<query> pq = new PriorityQueue<>();
        pq.add(new query(0, 0));
        while(!pq.isEmpty()) {
            query temp = pq.remove();
            for(edge e : edgeList[temp.node]) {
                if(distances[e.to] > temp.dist + e.dist) {
                    distances[e.to] = temp.dist + e.dist;
                    pq.add(new query(e.to, distances[e.to]));
                    parent[e.to] = temp.node;
                } else if(distances[e.to] == temp.dist + e.dist) {
                    if(parent[e.to] > temp.node) {
                        pq.add(new query(e.to, distances[e.to]));
                        parent[e.to] = temp.node;
                    }
                }
            }
        }
    }
    public static long dfs(int source, int parent, int[] cows, ArrayList<edge>[] edgeList) {
        long total = 0;
        for(edge e : edgeList[source]) {
            if(e.to == parent) {
                continue;
            }
            total += dfs(e.to, source, cows, edgeList);
        }
        total += cows[source];
        return pass[source] = total;
    }
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("shortcut.in"));
        PrintWriter out = new PrintWriter(new File("shortcut.out"));
        int n = input.nextInt();
        int m = input.nextInt();
        int t = input.nextInt();
        int[] cows = new int[n];
        parent = new int[n];
        distances = new long[n];
        pass = new long[n];
        for(int i = 0; i < n; i++) {
            cows[i] = input.nextInt();
        }
        ArrayList<edge>[] edgeList = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int from = input.nextInt() - 1;
            int to = input.nextInt() - 1;
            int dist = input.nextInt();
            edgeList[from].add(new edge(to, dist));
            edgeList[to].add(new edge(from, dist));
        }
        dijkstra(edgeList);
        ArrayList<edge>[] newList = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            newList[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++) {
            int temp = parent[i];
            newList[i].add(new edge(temp, 1));
            newList[temp].add(new edge(i, 1));
        }
        dfs(0, -1, cows, newList);
        long best = 0;
        for(int i = 1; i < n; i++) {
            long curdist = distances[i] * pass[i];
            long newdist = t * pass[i];
            best = Math.max(best, curdist - newdist);
        }
        out.println(best);
        out.close();
    }
}