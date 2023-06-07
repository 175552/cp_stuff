import java.util.*;
public class Solution {
    public static class store{
        point cur;
        ArrayList<point> visited = new ArrayList<>();
        store(point cur) {
            this.cur = cur;
        }
    }
    public static class point{
        int x;
        int y;
        point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        point() {}
        @Override
        public boolean equals(Object o) {
            point c = (point)o;
            if(x == c.x && y == c.y) {
                return true;
            }
            return false;
        }
    }

    public static int bfs(int[][] grid, point start, point end, int count) {
        int result = 0;
        Queue<store> queue = new LinkedList<>();
        store pls = new store(start);
        pls.visited.add(start);
        queue.add(pls);
        while(!queue.isEmpty()) {
            store temp = queue.remove();
            System.out.println(temp.cur.x + " " + temp.cur.y);
            for(point p : temp.visited) {
                System.out.println("visited " + p.x + " " + p.y);
            }
            System.out.println();
            if(temp.cur.x == end.x && temp.cur.y == end.y && temp.visited.size() == count) {
                result++;
                continue;
            }
            if(temp.visited.size() >= count) {
                continue;
            }
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            for(int i = 0; i < 4; i++) {
                point newPt = new point(temp.cur.x + dx[i], temp.cur.y + dy[i]);
                if(newPt.x < 0 || newPt.y < 0 || newPt.x >= length || newPt.y >= width || grid[newPt.x][newPt.y] == -1) {
                    continue;
                }
                if(!temp.visited.contains(newPt)) {
                    store next = new store(newPt);
                    ArrayList<point> fuck = new ArrayList<>();
                    fuck.add(newPt);
                    for(point p : temp.visited) {
                        fuck.add(new point(p.x, p.y));
                    }
                    next.visited = fuck;
                    queue.add(next);
                }
            }
        }
        return result;
    }
    static int length;
    static int width;
    public static int uniquePathsIII(int[][] grid) {
        point start = new point();
        point end = new point();
        length = grid.length;
        width = grid[0].length;
        int count = 1;
        for(int i = 0; i < grid.length; i++) {
            for(int k = 0; k < grid[0].length; k++) {
                if(grid[i][k] == 1) {
                    start = new point(i, k);
                }
                if(grid[i][k] == 2) {
                    end = new point(i, k);
                }
                if(grid[i][k] == 0) {
                    count++;
                }
            }
        }
        return bfs(grid, start, end, count);
    }
    public static void main(String [] args) {
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println(uniquePathsIII(grid));
    }
}