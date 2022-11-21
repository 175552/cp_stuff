import java.util.*;
import java.io.*;
public class A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        ArrayList<Integer> maxes = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int length = 0;
            for(int h = 0; h < m; h++) {
                int temp = input.nextInt();
                if(temp == 0) {
                    maxes.add(length);
                    length = 0;
                } else {
                    length++;
                }
            }
            maxes.add(length);
        }
        Collections.sort(maxes);
        int count = 0;
        int sum = 0;
        for(int i = maxes.size() - 1; i >= 0; i--) {
            if(count < k) {
                sum += maxes.get(i);
                count++;
            } else break;
        }
        System.out.println(sum);
    }
}
