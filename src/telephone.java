import java.util.*;
import java.io.*;
import java.awt.*;

public class telephone {
    public static class edge{
        int to;
        long dist;
        edge(int to, long dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    public static class query{
        int pos;
        long dist;
        query(int pos, long dist) {
            this.pos = pos;
            this.dist = dist;
        }
    }
    public static long bfs(int n, int k, int source, int dest, edge[][] edgeList) {
        long[] distance = new long[k];
        Arrays.fill(distance, Long.MAX_VALUE);
        Queue<query> queue = new LinkedList<>();
        queue.add(new query(source, 0));
        while(!queue.isEmpty()) {
            query temp = queue.remove();
            edge[] possible = edgeList[temp.pos];
            for(int i = 0; i < possible.length; i++) {
                if(possible[i] == null || possible[i].dist == Long.MAX_VALUE) {
                    continue;
                }
                edge current = possible[i];
                if(current.dist + temp.dist < distance[i]) {
                    distance[i] = current.dist + temp.dist;
                    queue.add(new query(current.to, distance[i]));
                }
            }
        }
        return distance[dest];
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("telephone.in"));
        PrintWriter out = new PrintWriter(new File("telephone.out"));
        int n = input.nextInt();
        int k = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt() - 1;
        }
        input.nextLine();
        int[][] matrix = new int[k][k];
        for(int i = 0; i < k; i++) {
            String line = input.nextLine();
            for(int h = 0; h < k; h++) {
                matrix[i][h] = Integer.parseInt(line.substring(h, h + 1));
            }
        }
        edge[][] distance = new edge[n][k];
        for(int i = 0; i < k; i++) {
            int cur = -1;
            for(int h = 0; h < n; h++) {
                if(nums[h] == i) {
                    cur = h;
                }
                if(cur == -1) {
                    continue;
                } else {
                    if(matrix[nums[h]][i] == 1) {
                        if(distance[h][i] == null) {
                            distance[h][i] = new edge(cur, Math.abs(h - cur));
                        } else if(Math.abs(h - cur) < distance[h][i].dist) {
                            distance[h][i] = new edge(cur, Math.abs(h - cur));
                        }
                    }
                }
            }
            cur = -1;
            for(int h = n - 1; h >= 0; h--) {
                if(nums[h] == i) {
                    cur = h;
                }
                if(cur == -1) {
                    continue;
                } else {
                    if(matrix[nums[h]][i] == 1) {
                        if(distance[h][i] == null) {
                            distance[h][i] = new edge(cur, Math.abs(h - cur));
                        } else if(Math.abs(h - cur) < distance[h][i].dist) {
                            distance[h][i] = new edge(cur, Math.abs(h - cur));
                        }
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(matrix[nums[i]][nums[n - 1]] == 1) {
                distance[i][nums[n - 1]] = new edge(n - 1, n - 1 - i);
            }
        }
        long temp = bfs(n, k, 0, nums[n - 1], distance);
        if(temp == Long.MAX_VALUE) {
            System.out.println(-1);
        } else System.out.println(temp);
    }
}