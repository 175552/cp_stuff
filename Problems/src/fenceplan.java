import java.util.*;
import java.io.*;
import java.awt.*;
public class fenceplan {
    static boolean[] visited;
    public static int floodfill(int cur, Point[] cows, ArrayList<Integer>[] edgeList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        visited[cur] = true;
        int up = cows[cur].y;
        int right = cows[cur].x;
        int left = cows[cur].x;
        int down = cows[cur].y;
        while(!queue.isEmpty()) {
            int temp = queue.remove();
            for(Integer i : edgeList[temp]) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    up = Math.max(up, cows[i].y);
                    right = Math.max(right, cows[i].x);
                    left = Math.min(left, cows[i].x);
                    down = Math.min(down, cows[i].y);
                }
            }
        }
        return ((up - down) + (right - left)) * 2;
    }
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("fenceplan.in"));
        PrintWriter out = new PrintWriter(new File("fenceplan.out"));
        int n = input.nextInt();
        int m = input.nextInt();
        Point[] cows = new Point[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            cows[i] = new Point(input.nextInt(), input.nextInt());
        }
        ArrayList<Integer>[] edgeList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int from = input.nextInt() - 1;
            int to = input.nextInt() - 1;
            edgeList[from].add(to);
            edgeList[to].add(from);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                min = Math.min(min, floodfill(i, cows, edgeList));
            }
        }
        out.println(min);
        out.close();
    }
}
