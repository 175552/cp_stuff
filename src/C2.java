import java.util.*;
public class C2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            int k = input.nextInt();
            int diff = k - 3;
            k -= diff;
            n -= diff;
            if(n % 2 == 0) {
                if((n/2) % 2 == 0) {
                    System.out.print(n/2 + " " + n/4 + " " + n/4);
                } else System.out.print(((n/2)-1) + " " + ((n/2)-1) + " " + 2);
            } else System.out.print(((n/2)) + " " + ((n/2)) + " " + 1);
            for(int h = 0; h < diff; h++) {
                System.out.print(" " + 1);
            }
            System.out.println();
        }
    }
}
