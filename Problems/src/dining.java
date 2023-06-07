import java.util.*;
import java.io.*;
import java.awt.*;

public class dining {
    public static class edge{
        int to;
        int dist;
        edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    public static void dijkstra(int n, ArrayList<edge>[] edgeList) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(n - 1);
        Arrays.fill(init, Integer.MAX_VALUE);
        init[n - 1] = 0;
        while(!pq.isEmpty()) {
            int temp = pq.remove();
            for(edge e : edgeList[temp]) {
                if(init[e.to] > init[temp] + e.dist) {
                    init[e.to] = init[temp] + e.dist;
                    pq.add(e.to);
                }
            }
        }
    }
    public static void dijkstra2(int n, ArrayList<edge>[] edgeList) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(n);
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[n] = 0;
        while(!pq.isEmpty()) {
            int temp = pq.remove();
            for(edge e : edgeList[temp]) {
                if(distances[e.to] > distances[temp] + e.dist) {
                    distances[e.to] = distances[temp] + e.dist;
                    pq.add(e.to);
                }
            }
        }
    }
    static int[] init;
    static int[] distances;
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("dining.in"));
        PrintWriter out = new PrintWriter(new File("dining.out"));
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        init = new int[n];
        distances = new int[n + 1];
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
        dijkstra(n, edgeList);
        for(int i = 0; i < k; i++) {
            int index = input.nextInt() - 1;
            int yum = input.nextInt();
            edgeList[n].add(new edge(index, init[index] - yum));
        }
        dijkstra2(n, edgeList);
        for(int i = 0; i < n - 1; i++) {
            if(init[i] >= distances[i]) {
                out.println(1);
            } else out.println(0);
        }
        out.close();
    }
}