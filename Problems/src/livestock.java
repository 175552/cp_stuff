import java.util.*;
import java.io.*;
import java.awt.*;

public class livestock {
    public static boolean works(int[] permutation, int[] first, int[] second) {
        for(int i = 0; i < first.length; i++) {
            boolean works = false;
            for(int k = 0; k < permutation.length; k++) {
                if(permutation[k] == first[i]) {
                    try{
                        if(permutation[k - 1] == second[i]) {
                            works = true;
                        }
                    } catch(Exception e) {}
                    try{
                        if(permutation[k + 1] == second[i]) {
                            works = true;
                        }
                    } catch(Exception e) {}
                }
            }
            if(!works) {
                return false;
            }
        }
        return true;
    }
    static int[] permutation;
    static int[] first;
    static int[] second;
    static boolean found = false;
    public static void recurse(int[] temp, int size, boolean[] used) {
        if(size == 8) {
            if(works(temp, first, second)) {
                permutation = temp;
                found = true;
                return;
            }
        } else {
            for(int i = 0; i < 8; i++) {
                if(!used[i]) {
                    temp[size] = i;
                    used[i] = true;
                    recurse(temp, size + 1, used);
                    used[i] = false;
                    if(found) {
                        return;
                    }
                }
            }
        }
    }
    static ArrayList names = new ArrayList<>(Arrays.asList("Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"));
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("lineup.in"));
        PrintWriter out = new PrintWriter(new FileWriter("lineup.out"));
        int n = input.nextInt();
        first = new int[n];
        second = new int[n];
        input.nextLine();
        for(int i = 0; i < n; i++) {
            String[] line = input.nextLine().split(" ");
            first[i] = names.indexOf(line[0]);
            second[i] = names.indexOf(line[line.length - 1]);
        }
        recurse(new int[8], 0, new boolean[8]);
        for(int i = 0; i < 8; i++) {
            out.println(names.get(permutation[i]));
        }
        out.close();
    }
}