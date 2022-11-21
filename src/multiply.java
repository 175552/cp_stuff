import java.util.*;
public class multiply {
    public static long binpow(long a, long b, long m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0)
                res = res * a % m;
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        long mod = 1000000007;
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        long[] evens = new long[n];
        evens[0] = nums[0];
        evens[1] = nums[0];
        for(int i = 2; i < n; i += 2) {
            evens[i] = (evens[i - 2] * nums[i]) % mod;
            if(i < n - 1) {
                evens[i + 1] = evens[i];
            }
        }
        long[] evens1 = new long[n];
        evens1[0] = nums[0];
        for(int i = 2; i < n; i += 2) {
            if(evens1[i - 2] == 0) {
                evens1[i] = nums[i];
            } else {
                evens1[i] = (evens1[i - 2] * nums[i]) % mod;
            }
        }
        TreeSet<Integer> evenzeroes = new TreeSet<>();
        for(int i = 0; i < n; i += 2) {
            if(nums[i] == 0) {
                evenzeroes.add(i);
            }
        }
        long[] odds = new long[n];
        odds[1] = nums[1];
        odds[2] = nums[1];
        for(int i = 3; i < n; i+= 2) {
            odds[i] = (odds[i - 2] * nums[i]) % mod;
            if(i < n - 1) {
                odds[i + 1] = odds[i];
            }
        }
        long[] odds1 = new long[n];
        odds1[1] = nums[1];
        for(int i = 3; i < n; i += 2) {
            if(odds1[i - 2] == 0) {
                odds1[i] = nums[i];
            } else {
                odds1[i] = (odds1[i - 2] * nums[i]) % mod;
            }
        }
        TreeSet<Integer> oddszeroes = new TreeSet<>();
        for(int i = 1; i < n; i += 2) {
            if(nums[i] == 0) {
                oddszeroes.add(i);
            }
        }
        int m = input.nextInt();
        for(int i = 0; i < m; i++) {
            int l = input.nextInt() - 1;
            int r = input.nextInt() - 1;
            long answer;
            if(l % 2 == 0) {
                if(r % 2 != 0) {
                    r--;
                }
                if(l - 2 < 0) {
                    answer = evens[r];
                } else {
                    if(evenzeroes.ceiling(l) != null && evenzeroes.ceiling(l) <= r) {
                        answer = 0;
                    } else if(nums[l - 2] == 0){
                        answer = evens1[r];
                    } else {
                        answer = evens1[r] * binpow(evens1[l - 2], mod - 2, mod) % mod;
                    }
                }
            } else {
                if(r % 2 != 1) {
                    r--;
                }
                if(l - 2 < 0) {
                    answer = odds[r];
                } else {
                    if(oddszeroes.ceiling(l) != null && oddszeroes.ceiling(l) <= r) {
                        answer = 0;
                    } else if(nums[l - 2] == 0){
                        answer = odds1[r];
                    } else {
                        answer = odds1[r] * binpow(odds1[l - 2], mod - 2, mod) % mod;
                    }
                }
            }
            System.out.println(answer % mod);
        }
    }
}
