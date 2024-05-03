import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int w[][];
    static boolean[] visited;
    static long ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine().trim());
        w = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0;j<N;j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Long.MAX_VALUE;

            visited = new boolean[N];
            solve(0,0,0);

        System.out.println(ans);

    }
    private static void solve(int n,int cnt,long cost){
        if(cnt==N && n==0){
            if(cost<ans)ans=cost;
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i] && w[n][i]>0){
                visited[i]=true;
                solve(i,cnt+1,cost+w[n][i]);
                visited[i]=false;
            }
        }
    }

}