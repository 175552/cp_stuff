//daniel ting
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class daniel
{
    public static int n;
    public static List<List<Integer>> edges;
    public static boolean[] visited;

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner file = new Scanner(System.in);
//        Scanner file = new Scanner(new File("ErnestAndABlueprint.in"));
//        System.setOut(new PrintStream(new File("ErnestAndABlueprint.out")));
        n = file.nextInt();
        int m = file.nextInt();
        int[][] pipes = new int[m][2];
        for (int i = 0; i < m; i++)
        {
            pipes[i] = new int[]{file.nextInt() - 1, file.nextInt() - 1};
        }
        int low = 1;
        int high = m;
        while (low <= high)
        {
            int middle = (low + high) / 2;
            edges = new ArrayList<>();
            for (int i = 0; i < n; i++)
            {
                edges.add(new ArrayList<>());
            }
            for (int i = 0; i < middle; i++)
            {
                int u = pipes[i][0];
                int v = pipes[i][1];
                edges.get(u).add(v);
                edges.get(v).add(u);
            }
            visited = new boolean[n];
            dfs(0);
            if (!visited[n - 1])
            {
                low = middle + 1;
            }
            else if (low == middle)
            {
                System.out.println(middle);
                return;
            }
            else
            {
                high = middle;
            }
        }
        System.out.println(-1);
    }

    public static void dfs(int start)
    {
        visited[start] = true;
        for (int edge : edges.get(start))
        {
            if (!visited[edge])
            {
                dfs(edge);
            }
        }
    }
}
