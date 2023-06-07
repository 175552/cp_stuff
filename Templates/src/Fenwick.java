public class Fenwick {
    int[] tree;
    int n;
    Fenwick(int[] nums) {
        n = nums.length;
        tree = new int[n + 1];
        init(nums);
    }
    void init(int[] nums) {
        for(int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }
    void update(int pos, int num) {
        pos++;
        while(pos <= n) {
            tree[pos] += num;
            pos += pos & (-pos);
        }
    }
    int query(int right) {
        right++;
        int sum = 0;
        while(right > 0) {
            sum += tree[right];
            right -= right & (-right);
        }
        return sum;
    }
}
