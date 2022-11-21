import java.util.*;
import java.awt.*;
public class I {
    static int m, n;
    public static boolean valid(Point p) {
        if(p.x < 0 || p.y < 0 || p.x >= m || p.y >= n) {
            return false;
        }
        return true;
    }

    public static boolean possible(int value, long[][] matrix) {
        boolean[][] visited = new boolean[m][n];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        while(!queue.isEmpty()) {
            Point temp = queue.remove();
            if(visited[temp.x][temp.y]) {
                continue;
            }
            visited[temp.x][temp.y] = true;
            if(temp.x == m - 1 && temp.y == n - 1) {
                return true;
            }
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            for(int i = 0; i < 4; i++) {
                Point newPt = new Point(temp.x + dx[i], temp.y + dy[i]);
                if(valid(newPt)) {
                    if(!visited[newPt.x][newPt.y] && matrix[newPt.x][newPt.y] - matrix[temp.x][temp.y] <= value) {
                        queue.add(newPt);
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        m = input.nextInt();
        n = input.nextInt();
        long[][] matrix = new long[m][n];
        for(int i = 0; i < m; i++){
            for(int k = 0; k < n;k++) {
                 matrix[i][k] = input.nextInt();
             }
        }
        int low = 0;
        int high = 1000000000;
        while(low < high) {
            int mid = (low + high)/2;
            if(possible(mid, matrix)) {
                high = mid;
            } else low = mid + 1;
        }
        System.out.println(low);
    }
}
