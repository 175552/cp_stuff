import java.util.*;
public class C1 {
    public static int[] perform(int[] temp, int length) {
        int[] result = new int[temp.length];
        for(int i = 0; i <= length; i++) {
            if(temp[i] == 0) {
                result[i] = 1;
            } else result[i] = 0;
        }
        for(int i = length + 1; i < temp.length; i++) {
            result[i] = temp[i];
        }
        int[] answer = new int[temp.length];
        for(int i = 0; i <= length; i++) {
            answer[i] = result[length - i];
        }
        for(int i = length + 1; i < temp.length; i++) {
            answer[i] = result[i];
        }
        return answer;
    }
    public static void printArray(int[] temp){
        for(Integer i : temp) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            input.nextLine();
            String temp1 = input.nextLine();
            String temp2 = input.nextLine();
            int[] one = new int[n];
            int[] two = new int[n];
            for(int k = 0; k < n; k++) {
                one[k] = Integer.parseInt(temp1.substring(k, k + 1));
            }
            for(int k = 0; k < n; k++) {
                two[k] = Integer.parseInt(temp2.substring(k, k + 1));
            }
            int length = 0;
            ArrayList<Integer> operations = new ArrayList<>();
            for(int k = n - 1; k >= 0; k--) {
                if(one[k] != two[k]) {
                    if(one[0] == two[k]) {
                        length++;
                        operations.add(1);
                        if(one[0] == 0) {
                            one[0] = 1;
                        } else one[0] = 0;
                    }
                    one = perform(one, k);
                    length++;
                    operations.add(k + 1);
                }
            }
            System.out.print(length);
            for(Integer k : operations) {
                System.out.print(" " + k);
            }
            System.out.println();
        }
    }
}
