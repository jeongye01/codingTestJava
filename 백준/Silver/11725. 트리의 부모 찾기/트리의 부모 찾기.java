import java.util.*;
import java.io.*;


public class Main {
    static List<List<Integer>> list;
    static int[] result;
    static int N;

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st;
       list = new ArrayList<>();
       N = Integer.parseInt(br.readLine().trim());
       result = new int[N+1];
       for(int i=0;i<N+1;i++){
           list.add(new ArrayList<>());
       }
       for(int i=0;i<N-1;i++){
           st = new StringTokenizer(br.readLine().trim());
           int a = Integer.parseInt(st.nextToken());
           int b =  Integer.parseInt(st.nextToken());
           list.get(a).add(b);
           list.get(b).add(a);
       }
       bfs();
       for(int i=2;i<=N;i++){
           sb.append(result[i]).append('\n');
       }
        System.out.println(sb);

    }
    private static void bfs(){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(Integer node : list.get(now)){
                if(!visited[node]){
                    visited[node]=true;
                    q.add(node);
                    result[node]=now;
                }
            }
        }
    }


}