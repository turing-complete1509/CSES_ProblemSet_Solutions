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

public class Building_Roads {
    static FastScanner sc = new FastScanner();

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        sc.out.close();
    }

    static class DSU{
        int[] par;
        int[] size;

        public DSU(int n){
            par = new int[n+1];
            size = new int[n+1];

            for(int i=0; i<=n; i++){
                par[i] = i;
                size[i] = 1;
            }
        }

        public int findPar(int node){
            if(par[node]==node){
                return node;
            }

            return par[node] = findPar(par[node]);
        }

        public void insert(int node1, int node2){
            int par1 = findPar(node1);
            int par2 = findPar(node2);

            if(par1==par2){
                return;
            }

            int size1 = size[par1];
            int size2 = size[par2];

            if(size1>size2){
                par[par2] = par1;
                size[par1] += size[par2];
            }else{
                par[par1] = par2;
                size[par2] += size[par1];
            }
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        DSU ds = new DSU(n);
        for(int i=0; i<k; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            ds.insert(u,v);
        }

        int count = 0;
        List<Integer> res = new ArrayList<>();

        for(int i=1; i<=n; i++){
            if(ds.findPar(i)==i){
                count++;
                res.add(i);
            }
        }

        sc.out.println(count-1);
        for(int i=0; i<count-1; i++){
            sc.out.println(res.get(i) + " " + res.get(i+1));
        }
        sc.out.println();
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