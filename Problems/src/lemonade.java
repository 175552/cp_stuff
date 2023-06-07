import java.util.*;
import java.io.*;
public class lemonade {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("lemonade.in"));
        PrintWriter out = new PrintWriter(new FileWriter("lemonade.out"));
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        int counter = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] < counter) {
                break;
            } else {
                counter++;
            }
        }
        out.println(counter);
        out.close();
    }
}
