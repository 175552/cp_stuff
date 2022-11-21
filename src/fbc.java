import java.util.*;
import java.io.*;
public class fbc {
    public static class tree implements Comparable<tree>{
        int pos;
        int height;
        tree(int pos, int height) {
            this.pos = pos;
            this.height = height;
        }
        public int compareTo(tree o) {
            return pos - o.pos;
        }
    }
    public static class store implements Comparable<store>{
        int left;
        int right;
        int num;
        store(int num, int left, int right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
        public int compareTo(store o){
            return left - o.left;
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            tree[] trees = new tree[n];
            for(int k = 0; k < n; k++) {
                trees[k] = new tree(input.nextInt(), input.nextInt());
            }
            Arrays.sort(trees);
            TreeSet<store> points = new TreeSet<>();
            for(int k = 0; k < n; k++) {
                tree temp = trees[k];
                points.add(new store(k, temp.pos - temp.height, temp.pos));
                points.add(new store(k, temp.pos, temp.pos + temp.height));
            }
            int max = 0;
            while(!points.isEmpty()) {
                store temp = points.first();
                int cur = temp.right - temp.left;
                int rightbound = temp.right;
                TreeSet<Integer> used = new TreeSet<>();
                used.add(temp.num);
                points.remove(points.first());
                while(true) {
                    try{
                        store other = points.floor(new store(-1, rightbound, rightbound));
                        if(other.left != rightbound || used.contains(other.num)) {
                            break;
                        } else {
                            cur += other.right - other.left;
                            rightbound = other.right;
                            used.add(other.num);
                            points.remove(other);
                        }
                    } catch(Exception e) {
                        break;
                    }
                }
                max = Math.max(max, cur);
            }
            System.out.println("Case #" + (i + 1) + ": " + max);
        }
    }
}
