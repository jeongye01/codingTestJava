import java.util.*;
import java.io.*;


public class Main {
    static int[][] adj;
    static int[][] dist;
    static int N,M,X;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        adj = new int[N+1][N+1];
        dist = new int[N+1][N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[a][b] = cost;
        }


        solve();
        int ans=0;
        for(int i=1;i<=N;i++){



           ans=Math.max(ans,dist[i][X]+dist[X][i]);
        }

        System.out.println(ans);


    }
    private static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) dist[i][j] = 0;
                else if (adj[i][j] > 0) dist[i][j] = adj[i][j];
                else dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                   if(dist[i][k] == Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE){
                       continue;
                   }
                   dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);


                }
            }
        }


    }

}