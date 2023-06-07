import java.util.*;
import java.io.*;
import java.awt.*;

public class alliswell {
    public static void dfs(Point cur, Point parent, Point origin, int hearing, int index) {
        hear[cur.x][cur.y][index] = 1;
        for(int i = 0; i < 4; i++) {
            Point newPt = new Point(cur.x + dx[i], cur.y + dy[i]);
            if(newPt.x == parent.x && newPt.y == parent.y) {
                continue;
            }
            if(Math.pow(cur.x - origin.x, 2) + Math.pow(cur.y - origin.y, 2) > Math.pow(hearing, 2)) {
                continue;
            }
        }
    }
    public static boolean valid(Point temp) {
        if(temp.x < 0 || temp.y < 0 || temp.x >= r || temp.y >= c) {
            return false;
        }
        return true;
    }
    static int[][][] hear;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int r, c, p;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("alliswell.in"));
        PrintWriter out = new PrintWriter(new File("alliswell.out"));
        r = input.nextInt();
        c = input.nextInt();
        p = input.nextInt();
        int[] nums = new int[p];
        for(int i = 0; i < p; i++) {
            nums[i] = input.nextInt();
        }
        int[][] map = new int[r][c];
        hear = new int[r][c][p];
        input.nextLine();
        Point[] people = new Point[p];
        for(int i = 0; i < r; i++) {
            String[] line = input.nextLine().split(" ");
            for(int k = 0; k < c; k++) {
                if(Character.isLetter(line[k].charAt(0))) {
                    map[r][c] = ((int)line[k].charAt(0) - 64) * -1;
                    people[(map[r][c] *- 1) - 1] = new Point(i, k);
                } else map[r][c] = Integer.parseInt(line[k]);
            }
        }
    }
}