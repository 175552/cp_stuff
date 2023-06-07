import java.util.*;
public class test {
    public static String caesar(String line, int key) {
        String result = "";
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i = 0; i < line.length(); i++) {
            if(!Character.isLetter(line.charAt(i))) {
                result += line.charAt(i);
            } else result += alphabet[((int)line.charAt(i) - 97 + key) % 26];
        }
        return result;
    }
    public static String decrpyt(String line, int key) {
        String result = "";
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i = 0; i < line.length(); i++) {
            if(!Character.isLetter(line.charAt(i))) {
                result += line.charAt(i);
            } else result += alphabet[((int)line.charAt(i) - 97 - key + 26) % 26];
        }
        return result;
    }
    public static void scrambleshit(String line) {
        System.out.println(line);
        double rng = 1;
        int start = 0;
        int end = 0;
        for(int i = 0; i < line.length(); i++) {
            if(Character.isLetter(line.charAt(i))) {
                start = i;
                break;
            }
        }
        for(int i = line.length() - 1; i >= 0; i--) {
            if(Character.isLetter(line.charAt(i))) {
                end = i;
                break;
            }
        }
        char[] temp = line.toCharArray();
        for(int i = start + 1; i < end - 1; i++) {
            if(Math.random() < rng) {
                char temptemp = temp[i];
                temp[i] = temp[i + 1];
                temp[i + 1] = temptemp;
            }
        }
        System.out.println(new String(temp));
    }
    public static boolean isVowel(char a) {
        Character.toLowerCase(a);
        if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
            return true;
        }
        return false;
    }
    public static int countVowels(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            if(isVowel(s.charAt(i))) {
                sum++;
            }
        }
        return sum;
    }
    public static boolean prefix(String s, int n) {
        if(s.substring(n).contains(s.substring(0, n))) {
            return true;
        }
        return false;
    }
    public static boolean temp(String s, char a, char b) {
        int sum1 = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == a) {
                sum1++;
            }
        }
        int sum2 = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == b) {
                sum2++;
            }
        }
        if(sum1 == sum2) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        caesar("what is this", 6);
    }
}
