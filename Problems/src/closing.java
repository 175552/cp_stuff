import java.util.*;
import java.io.*;
public class closing {
    public static void dfs(int cur, ArrayList<Integer>[] edgeList) {
        visited[cur] = true;
        for(Integer i : edgeList[cur]) {
            if(!visited[i] && farms[i]) {
                dfs(i, edgeList);
            }
        }
    }
    public static boolean connected() {
        for(int i = 1; i < farms.length; i++) {
            if(farms[i] && !visited[i]) {
                return false;
            }
        }
        return true;
    }
    static boolean[] visited;
    static boolean[] farms;
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("closing.in"));
        PrintWriter out = new PrintWriter(new FileWriter("closing.out"));
        int n = input.nextInt();
        int m = input.nextInt();
        int[] nums = new int[n];
        visited = new boolean[n + 1];
        farms = new boolean[n + 1];
        ArrayList<Integer>[] edgeList = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            edgeList[from].add(to);
            edgeList[to].add(from);
        }
        Arrays.fill(farms, true);
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        dfs(nums[n - 1], edgeList);
        if(connected()) {
            out.println("YES");
        } else out.println("NO");
        for(int i = 0; i < n - 1; i++) {
            farms[nums[i]] = false;
            edgeList[nums[i]] = new ArrayList<>();
            visited = new boolean[n + 1];
            dfs(nums[n - 1], edgeList);
            if(connected()) {
                out.println("YES");
            } else out.println("NO");
        }
        out.close();
    }
}
