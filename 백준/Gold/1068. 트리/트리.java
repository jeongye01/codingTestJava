import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int remove;
    static int ans;
    static List<List<Integer>> graph;
    static int parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        graph = new ArrayList<>();
        for(int i=0;i<N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            if(n!=-1){
                graph.get(n).add(i);
            }else{
               parent=i;
            }


        }

        remove = Integer.parseInt(br.readLine().trim());
        dfs(parent);

        System.out.println(ans);
    }
    private static void dfs(int now){

        if(now==remove){return;}
        if(graph.get(now).isEmpty() || (graph.get(now).size()==1 && graph.get(now).get(0)==remove)){

            ans++;
            return;
        };
        for(Integer node:graph.get(now)){

             dfs(node);
        }

    }



}