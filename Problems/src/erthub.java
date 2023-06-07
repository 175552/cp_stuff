import java.util.*;
public class erthub {
    public static int dfs(int root, int value, int[] nums, ArrayList<Integer>[] edgeList) {
        int result = value;
        for(Integer i : edgeList[root]) {
            result = Math.max(result, result ^ dfs(i, nums[i], nums, edgeList));
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Integer>[] edgeList = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++) {
            edgeList[input.nextInt() - 1].add(i);
        }
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        System.out.println(dfs(0, nums[0], nums, edgeList));
    }
}
