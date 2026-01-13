/*
 * _________________________________________________________________________________________________________________________________
 * |                                                                                                                               |
 * |    ___   __   __ _   _   _____  _   _    ______ ______   ___   _____   ___   ______     _____  _____  _   _  _____  _   _     |
 * |   / _ \  \ \ / /| | | | /  ___|| | | |   | ___ \| ___ \ / _ \ |_   _| / _ \  | ___ \   /  ___||_   _|| \ | ||  __ \| | | |    |
 * |  / /_\ \  \ V / | | | | \ `--. | |_| |   | |_/ /| |_/ // /_\ \  | |  / /_\ \ | |_/ /   \ `--.   | |  |  \| || |  \/| |_| |    |
 * |  |  _  |   | |  | | | |  `--. \|  _  |   |  __/ |    / |  _  |  | |  |  _  | |  __/     `--. \  | |  | . ` || | __ |  _  |    |
 * |  | | | |   | |  | |_| | /\__/ /| | | |   | |    | |\ \ | | | |  | |  | | | | | |       /\__/ / _| |_ | |\  || |_\ \| | | |    |
 * |  \_| |_/   \_/   \___/  \____/ \_| |_/   \_|    \_| \_|\_| |_/  \_/  \_| |_/ \_|       \____/  \___/ \_| \_/\_____/|_| |_|    |
 * |                                                                                                                               |
 * |  "Talk is cheap. Show me the code." - Linus Torvalds                                                                          |
 * |_______________________________________________________________________________________________________________________________|
 */
 
import java.util.*;
import java.io.*;
 
public class Removing_Digits {
    static FastScanner sc = new FastScanner();
 
    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        sc.out.close();
    }
 
    static int getLargestDigit(int n){
        int largestDigit = 0;
        while(n>0){
            largestDigit = Math.max(largestDigit,n%10);
            n /= 10;
        }
        return largestDigit;
    }
 
    static int solve(int n){
        if(n==0){
            return 0;
        }
        int largestDigit = getLargestDigit(n);
        return 1 + solve(n-largestDigit);
    }
 
    static void solve() {
        int n = sc.nextInt();
        sc.out.println(solve(n));
    }
 
    static long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
    static long lcm(long a, long b) { return (a / gcd(a, b)) * b; }
    static void debug(int[] arr) { for(int i=0; i<arr.length; i++) { System.out.print(arr[i] + " "); } System.out.println();} 
    static void debug(long[] arr) { for(int i=0; i<arr.length; i++) { System.out.print(arr[i] + " "); } System.out.println();} 
    static void debug(char[] arr) { for(int i=0; i<arr.length; i++) { System.out.print(arr[i] + " "); } System.out.println();} 
    static void debug(String[] arr) { for(int i=0; i<arr.length; i++) { System.out.print(arr[i] + " "); } System.out.println();} 
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public PrintWriter out = new PrintWriter(System.out);
        String next() { while (!st.hasMoreTokens()) try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        int[] readArray(int n) { int[] a = new int[n]; for (int i=0; i<n; i++) a[i]=nextInt(); return a; }
    }
}
