import java.io.IOException;
import java.util.*;
public class waterpipes {
    public static class store{
        int paths;
        int num;
        int prev;
        store(int paths, int num, int prev) {
            this.paths = paths;
            this.num = num;
            this.prev = prev;
        }
    }
    public static long bfs(ArrayList<Integer> starts, ArrayList<Integer>[] edgeList) {
        Queue<store> queue = new LinkedList<>();
        for(Integer i : starts) {
            queue.add(new store(1, i, -1));
        }
        int[] dist = new int[n + 1];
        long max = 1;
        while(!queue.isEmpty()) {
            store temp = queue.remove();
            if(temp.num == n) {
                max = Math.max(max, temp.paths);
            }
            for(Integer i: edgeList[temp.num]) {
                if (i != temp.prev) {
                    dist[i] += temp.paths;
                    queue.add(new store(dist[i], i, temp.num));
                }
            }
        }
        return max;
    }
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int m = input.nextInt();
        ArrayList<Integer>[] reverseedgeList = new ArrayList[n + 1];
        ArrayList<Integer>[] edgeList = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
            reverseedgeList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            reverseedgeList[to].add(from);
            edgeList[from].add(to);
        }
        ArrayList<Integer> starts = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            if(reverseedgeList[i].size() == 0) {
                starts.add(i);
            }
        }
        System.out.println(bfs(starts, edgeList));
    }
}
