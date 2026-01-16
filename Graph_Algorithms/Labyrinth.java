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

public class Labyrinth {
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
        char[][] labyrinth = new char[n][m];
        Node source = null;
        
        char[][] fromStep = new char[n][m]; 

        for(int i=0; i<n; i++){
            String s = sc.next();
            for(int j=0; j<m; j++){
                labyrinth[i][j] = s.charAt(j);
                if(labyrinth[i][j] == 'A'){
                    source = new Node(i,j);
                }
            }
        }
        
        boolean[][] vis = new boolean[n][m];

        Queue<Node> q = new ArrayDeque<>();
        q.add(source);
        vis[source.row][source.col] = true;

        char[] dirChar = {'U', 'R', 'D', 'L'};
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Node curr = q.remove();
            int row = curr.row;
            int col = curr.col;

            if(labyrinth[row][col] == 'B'){
                System.out.println("YES");
                
                StringBuilder pathBuilder = new StringBuilder();
                int currR = row;
                int currC = col;

                while(currR != source.row || currC != source.col){
                    char move = fromStep[currR][currC];
                    pathBuilder.append(move);
                    
                    if(move == 'U') currR++;      
                    else if(move == 'R') currC--;  
                    else if(move == 'D') currR--;  
                    else if(move == 'L') currC++;
                }
                
                String finalPath = pathBuilder.reverse().toString();
                System.out.println(finalPath.length());
                System.out.println(finalPath);
                return;
            }

            for(int j=0; j<4; j++){
                int nrow = row + delRow[j];
                int ncol = col + delCol[j];

                if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0){
                    if(!vis[nrow][ncol] && (labyrinth[nrow][ncol] == '.' || labyrinth[nrow][ncol] == 'B')){
                        vis[nrow][ncol] = true;
                        
                        fromStep[nrow][ncol] = dirChar[j]; 
                        
                        q.add(new Node(nrow, ncol));
                    }
                }
            }
        }
        System.out.println("NO");
    }

    static class Node{
        int row;
        int col;
    
        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public PrintWriter out = new PrintWriter(System.out);
        String next() { while (!st.hasMoreTokens()) try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
    }
}