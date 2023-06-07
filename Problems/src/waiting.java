import java.util.*;
public class waiting {
    public static class store{
        int n;
        boolean start;
        int num;
        store(int n, boolean start, int num) {
            this.n = n;
            this.start = start;
            this.num = num;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int l = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        long result = 0;
        int cur = 0;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> line = new ArrayList<>();
        int pointer = 0;
        for(int i = nums[0]; true; i++) {
            if(cur < n && nums[cur] == i) {
                if(line.size() - pointer >= l) {
                    queue.add(nums[cur]);
                } else {
                    line.add(nums[cur] + m);
                }
                cur++;
            }
            for(int k = 0; k < line.size(); k++) {
                if(line.get(k) == i) {
                    pointer = k + 1;
                }
            }
            while(line.size() - pointer < l && !queue.isEmpty()) {
                line.add(i + m);
                queue.remove();
            }
            if(line.size() - pointer == 0 && cur == n) {
                break;
            }
            if(line.size() - pointer == 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}
