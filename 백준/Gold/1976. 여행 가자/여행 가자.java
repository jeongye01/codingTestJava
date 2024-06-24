import java.util.*;
import java.io.*;


public class Main {
    static int[] parent;
    static int N,M;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        M = Integer.parseInt(br.readLine().trim());
        StringTokenizer st;
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=1;j<=N;j++){
                if(Integer.parseInt(st.nextToken())==1){
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine().trim());
        int start = find(Integer.parseInt(st.nextToken()));
        boolean check=true;
        for(int i=1;i<M;i++){
            int now = Integer.parseInt(st.nextToken());
            if(start!=find(now)){
                check=false;
                break;
            }
        }
        System.out.println(check?"YES":"NO");



    }

    private static int find(int x) {
         if(parent[x]==x)return x;
         return parent[x]=find(parent[x]);
    }
    private static void union(int a,int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa<fb)parent[fb]=fa;
        else if(fa>fb)parent[fa]=fb;
    }



}
