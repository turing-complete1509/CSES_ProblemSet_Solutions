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
 
public class Grid_Paths_I {
    static FastScanner sc = new FastScanner();
 
    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        sc.out.close();
    }
 
    static int mod = (int)1e9 + 7;
 
    static void solve() {
        int n = sc.nextInt();
        char[][] m = new char[n][n];
        for(int i=0; i<n; i++){
            String s = sc.next();
            for(int j=0; j<n; j++){
                m[i][j] = s.charAt(j);
            }
        }
        int[][] dp = new int[n][n];
        for(int row = n-1; row>=0; row--){
            for(int col=n-1; col>=0; col--){
                if(m[row][col]=='*'){
                    continue;
                }
                if(row==n-1 && col==n-1){
                    dp[row][col] = 1;
                    continue;
                }
                dp[row][col] = ((row+1<n ? dp[row+1][col] : 0) + (col+1<n ? dp[row][col+1] : 0))%mod;
            }
        }
        sc.out.println(dp[0][0]);
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