import java.util.*;
import java.io.*;
import java.awt.*;

public class pump {
    public static class edge{
        int to;
        int cost;
        int flow;
        edge(int to, int cost, int flow) {
            this.to = to;
            this.cost = cost;
            this.flow = flow;
        }
    }
    public static int convert(int cost, int flow) {
        return (int)(1000000 * (double)flow/cost);
    }
    public static class store{
        int cost;
        int flow;
        store(int cost, int flow) {
            this.cost = cost;
            this.flow = flow;
        }
    }
    public static int bfs(int n, ArrayList<edge>[] edgeList) {
        store[] dist = new store[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        dist[1] = new store(0, Integer.MAX_VALUE);
        queue.add(1);
        while(!queue.isEmpty()) {
            int cur = queue.remove();
            for(edge e : edgeList[cur]) {
                if(dist[e.to] == null || convert(dist[e.to].cost, dist[e.to].flow) < convert(dist[cur].cost + e.cost, Math.min(dist[cur].flow, e.flow))) {
                    dist[e.to] = new store(dist[cur].cost + e.cost, Math.min(dist[cur].flow, e.flow));
                    queue.add(e.to);
                }
            }
        }
        return convert(dist[n].cost, dist[n].flow);
    }
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("pump.in"));
        PrintWriter out = new PrintWriter(new File("pump.out"));
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<edge>[] edgeList = new ArrayList[n + 1];
        for(int i = 0; i < n; i++) {
            edgeList[i + 1] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            int cost = input.nextInt();
            int flow = input.nextInt();
            edgeList[from].add(new edge(to, cost, flow));
            edgeList[to].add(new edge(from, cost, flow));
        }
        out.println(bfs(n, edgeList));
        out.close();
    }
}