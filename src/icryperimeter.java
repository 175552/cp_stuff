import java.util.*;
import java.io.*;
import java.awt.*;
public class icryperimeter {
    static boolean[][] visited;
    static int area, perimeter;
    public static boolean valid(Point temp, char[][] map) {
        if(temp.x < 0 || temp.y < 0 || temp.x >= map.length || temp.y >= map.length) {
            return false;
        }
        return true;
    }
    public static void bfs(Point start, char[][] map) {
        int temparea = 1;
        int tempperimeter = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        while(!queue.isEmpty()) {
            Point temp = queue.remove();
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            for(int i = 0; i < 4; i++) {
                Point newPt = new Point(temp.x + dx[i], temp.y + dy[i]);
                if(!valid(newPt, map)) {
                    tempperimeter++;
                    continue;
                }
                if(visited[newPt.x][newPt.y]) {
                    continue;
                }
                if(map[newPt.x][newPt.y] == '.') {
                    tempperimeter++;
                } else if(map[newPt.x][newPt.y] == '#'){
                    temparea++;
                    visited[newPt.x][newPt.y] = true;
                    queue.add(newPt);
                }
            }
        }
        if(area == temparea) {
            perimeter = Math.min(perimeter, tempperimeter);
        } else if(temparea > area){
            area = temparea;
            perimeter = tempperimeter;
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("perimeter.in"));
        PrintWriter out = new PrintWriter(new FileWriter("perimeter.out"));
        int n = input.nextInt();
        input.nextLine();
        visited = new boolean[n][n];
        char[][] map = new char[n][n];
        area = 0;
        perimeter = 0;
        for(int i = 0; i < n; i++) {
            String line = input.nextLine();
            for(int k = 0; k < n; k++) {
                map[i][k] = line.charAt(k);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int k = 0; k < n; k++) {
                if(map[i][k] == '#' && !visited[i][k]) {
                    bfs(new Point(i, k), map);
                }
            }
        }
        out.println(area + " " + perimeter);
        out.close();
    }
}
