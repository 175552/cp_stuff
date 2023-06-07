import java.util.*;
import java.io.*;
import java.awt.*;

public class timeline {
    public static class edge{
        int to;
        int dist;
        edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    static boolean[] visited;
    static int[] result;
    static Stack<Integer> stacks;
    public static void dfs(int source, ArrayList<edge>[] edgeList, int[] earliest) {
        visited[source] = true;
        for(edge e : edgeList[source]) {
            if(!visited[e.to]) {
                dfs(e.to, edgeList, earliest);
            }
        }
        stacks.add(source);
    }
    public static void dfs1(int source, int time, ArrayList<edge>[] edgeList, int[] earliest) {
        visited[source] = true;
        for(edge e : edgeList[source]) {
            if(time + e.dist > result[e.to]) {
                dfs1(e.to, time + e.dist, edgeList, earliest);
            }
        }
        result[source] = time;
    }
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("timeline.in"));
        PrintWriter out = new PrintWriter(new File("timeline.out"));
        int n = input.nextInt();
        int m = input.nextInt();
        int c = input.nextInt();
        result = new int[n];
        int[] earliest = new int[n];
        for(int i = 0; i < n; i++) {
            earliest[i] = input.nextInt();
            result[i] = earliest[i];
        }
        ArrayList<edge>[] edgeList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for(int i = 0; i < c; i++) {
            int from = input.nextInt() - 1;
            int to = input.nextInt() - 1;
            int dist = input.nextInt();
            edgeList[from].add(new edge(to, dist));
        }
        visited = new boolean[n];
        stacks = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, edgeList, earliest);
            }
        }
        visited = new boolean[n];
        for(Integer i : stacks) {
            if(!visited[i]) {
                dfs1(i, Math.max(0, earliest[i]), edgeList, earliest);
            }
        }
        for(Integer i : result) {
            out.println(i);
        }
        out.close();
    }
}