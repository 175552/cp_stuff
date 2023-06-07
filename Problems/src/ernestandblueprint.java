import java.util.*;
import java.io.*;
public class ernestandblueprint {
    //global variables
    static int n, m, result;
    static int[] parent;
    //return the component node i is part of
    public static int find(int i) {
        if(parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]); //path compression
    }
    //merge two components
    public static void union(int x, int y) {
        int gx = find(x);
        int gy = find(y);
        parent[gy] = gx;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        //parent[i] represents the component node i is a part of
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            //intially every node is its own component
            parent[i] = i;
        }
        result = -1;
        for(int i = 0; i < m; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            //merge the components of the two edges being connected
            union(from, to);
            //check if node 1 and node n are in the same component
            if(find(n) == find(1)) {
                result = i + 1;
                break;
            }
        }
        System.out.println(result);
    }
}
