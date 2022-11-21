import java.util.*;
import java.io.*;
import java.awt.*;
public class lineup {
    public static boolean works(int[] permutation, int[] first, int[] second) {
        for(int i = 0; i < first.length; i++) {
            boolean works = false;
            for(int k = 0; k < permutation.length; k++) {
                if(permutation[k] == first[i]) {
                    try{
                        if(permutation[k - 1] == second[i]) {
                            works = true;
                        }
                    } catch(Exception e) {

                    }
                    try{
                        if(permutation[k + 1] == second[i]) {
                            works = true;
                        }
                    } catch(Exception e) {

                    }
                }
            }
            if(!works) {
                return false;
            }
        }
        return true;
    }
    static ArrayList names = new ArrayList<>(Arrays.asList("Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"));
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("lineup.in"));
        PrintWriter out = new PrintWriter(new FileWriter("lineup.out"));
        int n = input.nextInt();
        int[] first = new int[n];
        int[] second = new int[n];
        input.nextLine();
        for(int i = 0; i < n; i++) {
            String[] line = input.nextLine().split(" ");
            first[i] = names.indexOf(line[0]);
            second[i] = names.indexOf(line[line.length - 1]);
        }
        boolean[] used = new boolean[8];
        int[] permutation = new int[8];
        boolean found = false;
        for(int a = 0; a < 8; a++) {
            if(!used[a]) {
                permutation[0] = a;
                used[a] = true;
            }
            for(int b = 0; b < 8; b++) {
                if(!used[b]) {
                    permutation[1] = b;
                    used[b] = true;
                } else continue;
                for(int c = 0; c < 8; c++) {
                    if(!used[c]) {
                        permutation[2] = c;
                        used[c] = true;
                    } else continue;
                    for(int d = 0; d < 8; d++) {
                        if(!used[d]) {
                            permutation[3] = d;
                            used[d] = true;
                        } else continue;
                        for(int e = 0; e < 8; e++) {
                            if(!used[e]) {
                                permutation[4] = e;
                                used[e] = true;
                            } else continue;
                            for(int f = 0; f < 8; f++) {
                                if(!used[f]) {
                                    permutation[5] = f;
                                    used[f] = true;
                                } else continue;
                                for(int g = 0; g < 8; g++) {
                                    if(!used[g]) {
                                        permutation[6] = g;
                                        used[g] = true;
                                    } else continue;
                                    for(int h = 0; h < 8; h++) {
                                        if(!used[h]) {
                                            permutation[7] = h;
                                            used[h] = true;
                                            if(works(permutation, first, second)) {
                                                found = true;
                                                break;
                                            } else {
                                                used[h] = false;
                                            }
                                        } else continue;
                                    }
                                    if(found) {
                                        break;
                                    }
                                    used[g] = false;
                                }
                                if(found) {
                                    break;
                                }
                                used[f] = false;
                            }
                            if(found) {
                                break;
                            }
                            used[e] = false;
                        }
                        if(found) {
                            break;
                        }
                        used[d] = false;
                    }
                    if(found) {
                        break;
                    }
                    used[c] = false;
                }
                if(found) {
                    break;
                }
                used[b] = false;
            }
            if(found) {
                break;
            }
            used[a] = false;
        }
        for(int i = 0; i < 8; i++) {
            out.println(names.get(permutation[i]));
        }
        out.close();
    }
}
