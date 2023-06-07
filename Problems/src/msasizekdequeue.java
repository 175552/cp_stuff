import java.util.*;
import java.io.*;
public class msasizekdequeue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for(int i = k; i < n; i++) {
            System.out.print(nums[deque.getFirst()] + " ");
            while(!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        System.out.println(nums[deque.getFirst()]);
    }
}
