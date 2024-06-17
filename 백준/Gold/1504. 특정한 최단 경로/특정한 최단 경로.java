import java.util.*;
import java.io.*;

public class Main {

    static int N, E ,V1,V2;

    static ArrayList<int[]>[] graph;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        for(int i=0;i<N;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b,c});
            graph[b].add(new int[]{a,c});
        }
        st = new StringTokenizer(br.readLine().trim());
        V1 = Integer.parseInt(st.nextToken())-1;
        V2 = Integer.parseInt(st.nextToken())-1;

        int ans1=solve(V1,V2);
        int ans2=solve(V2,V1);

        if(ans1==Integer.MAX_VALUE&& ans2==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(ans1,ans2));
        }



    }
    private static int solve(int v1,int v2){
        int route1 = bfs(0,v1);
        int route2 =bfs(v1,v2);
        int route3=bfs(v2,N-1);
        if(route1==Integer.MAX_VALUE || route2==Integer.MAX_VALUE || route3==Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return route1+route2+route3;
    }

    private static int bfs(int s,int e){


        int[] distances = new int[N];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);


        while(!q.isEmpty()){
            int now = q.poll();

            for(int[] node : graph[now]){
                int n = node[0];
                int newDist = node[1]+distances[now];
                if(newDist >= distances[n])continue;
                q.add(n);
                distances[n]=newDist;
            }
        }


        return distances[e];
    }


}



