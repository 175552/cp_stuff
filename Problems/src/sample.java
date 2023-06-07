import java.util.*;
public class sample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer += input.nextInt();
        }
        System.out.println(answer);
    }
}
