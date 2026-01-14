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

public class Rectangle_Cutting {
    static FastScanner sc = new FastScanner();

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        sc.out.close();
    }

    static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] dp = new long[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i==j){
                    dp[i][j] = 1;
                }else{
                    int min = Math.min(i,j);
                    long minMoves = Integer.MAX_VALUE;
                    for(int k=1; k<=min; k++){
                        long min1 = 1+dp[i][j-k]+dp[i-k][k];
                        long min2 = 1+dp[i-k][j]+dp[k][j-k];
                        minMoves = Math.min(minMoves,Math.min(min1,min2));
                    }
                    dp[i][j] = minMoves;
                }
            }
        }
        sc.out.println(dp[n][m]-1);
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