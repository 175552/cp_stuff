import java.util.*;
public class treasurer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        long mod = 1000000007;
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            int k = input.nextInt();
            input.nextLine();
            String line = input.nextLine();
            int as = (int)Math.ceil((double)n/(k + 1));
            long total = 0;
            int length = 0;
            for(int h = n; h >= 1; h--) {
                if(as == h) {
                    if(line.charAt(h - 1) == 'A') {
                        continue;
                    }
                    total += (long)Math.pow(2, h);
                    as--;
                    continue;
                }
                if(line.charAt(h - 1) == 'B') {
                    length++;
                    if(length > k) {
                        total += (long)Math.pow(2, h);
                        length = 0;
                        as--;
                    }
                } else{
                    length = 0;
                    as--;
                }
            }
            System.out.println(total);
        }
    }
}
