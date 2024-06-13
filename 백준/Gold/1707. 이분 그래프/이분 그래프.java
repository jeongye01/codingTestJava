import java.util.*;
import java.io.*;

public class Main {

    static int V, E;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine().trim());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                graph[a].add(b);
                graph[b].add(a);


            }


            sb.append(bfs() ? "YES" : "NO").append('\n');

        }
        System.out.println(sb);

    }

    private static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();

        int[] group = new int[V];

        for(int i = 0; i < V; i++) {
            if(group[i]==0){
                q.add(i);
                group[i] = 1;
            }
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int node : graph[now]) {
                    if (group[node] == 0) {
                        group[node] = group[now] *-1;
                        q.add(node);
                    } else if (group[node] == group[now]) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}



