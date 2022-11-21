import java.util.*;
import java.io.*;
import java.awt.*;

public class replication {
    public static class query{
        Point p;
        int replication;
        int d;
        query(Point p, int replication, int d) {
            this.p = p;
            this.replication = replication;
            this.d = d;
        }
    }
    public static class store{
        Point p;
        int distance;
        store(Point p, int distance) {
            this.p = p;
            this.distance = distance;
        }
    }
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] memoize;
    static int[][] realting;
    public static void bfs(ArrayList<Point> starts, char[][] map, int d) {
        Queue<query> queue = new LinkedList<>();
        for(Point p : starts) {
            queue.add(new query(p, 1, 0));
            memoize[p.x][p.y] = 1;
        }
        while(!queue.isEmpty()) {
            query temp = queue.remove();
            reach[temp.p.x][temp.p.y] = temp.replication;
            if(temp.d == d) {
                if(possible[temp.p.x][temp.p.y] >= (temp.replication) + 1 && memoize[temp.p.x][temp.p.y] < (temp.replication + 1)){
                    queue.add(new query(new Point(temp.p.x, temp.p.y), temp.replication + 1, 0));
                    reach[temp.p.x][temp.p.y] = temp.replication + 1;
                    memoize[temp.p.x][temp.p.y] = temp.replication + 1;
                }
            } else
                for(int i = 0; i < 4; i++) {
                Point newPt = new Point(temp.p.x + dx[i], temp.p.y + dy[i]);
                if(valid(newPt)) {
                    if(possible[newPt.x][newPt.y] >= temp.replication && memoize[newPt.x][newPt.y] < temp.replication) {
                        queue.add(new query(newPt, temp.replication, temp.d + 1));
                        memoize[newPt.x][newPt.y] = temp.replication;
                    }
                }
            }
        }
    }
    public static void expand() {
        for(int i = n/2 - 1; i > 1; i--) {
            for(Point p : allCenters[i]) {
                for(int k = 0; k < 4; k++) {
                    Point newPt = new Point(p.x + dx[k], p.y + dy[k]);
                    if(realting[newPt.x][newPt.y] != 0) {
                        continue;
                    }
                    allCenters[i - 1].add(newPt);
                    realting[newPt.x][newPt.y] = 1;
                }
            }
        }
    }
    public static boolean valid(Point newPt) {
        if(newPt.x < 0 || newPt.y < 0 || newPt.x >= n || newPt.y >= n) {
            return false;
        }
        return true;
    }
    public static int[][] possible;
    static int[][] reach;
    static int n;
    static Set<Point>[] allCenters;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        char[][] map = new char[n][n];
        reach = new int[n][n];
        memoize = new int[n][n];
        possible = new int[n][n];
        realting = new int[n][n];
        int d = input.nextInt();
        input.nextLine();
        ArrayList<Point> starts = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String line = input.nextLine();
            for(int k = 0; k < n; k++) {
                possible[i][k] = Integer.MAX_VALUE - 5;
                map[i][k] = line.charAt(k);
                if(map[i][k] == 'S') {
                    starts.add(new Point(i, k));
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int k = 0; k < n; k++) {
                char temp = map[i][k];
                if(temp == '#') {
                    possible[i][k] = 0;
                } else {
                    possible[i][k] = Math.min(Math.min(possible[i][k], possible[i - 1][k] + 1), possible[i][k - 1] + 1);
                }
            }
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int k = n - 1; k >= 0; k--) {
                char temp = map[i][k];
                if(temp == '#') {
                    possible[i][k] = 0;
                } else {
                    possible[i][k] = Math.min(Math.min(possible[i][k], possible[i + 1][k] + 1), possible[i][k + 1] + 1);
                }
            }
        }
        bfs(starts, map, d);
        allCenters = new HashSet[n/2];
        for(int i = 0; i < n/2; i++) {
            allCenters[i] = new HashSet<Point>();
        }
        for(int i = 0; i < n; i++) {
            for(int k = 0; k < n; k++) {
                if(reach[i][k] == 0) {
                    continue;
                }
                realting[i][k] = 1;
                allCenters[reach[i][k]].add(new Point(i, k));
            }
        }
        expand();
        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int k = 0; k < n; k++) {
                if(realting[i][k] != 0) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
