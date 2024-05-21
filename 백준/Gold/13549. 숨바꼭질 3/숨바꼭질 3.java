import java.util.*;
import java.io.*;

public class Main {
    static int N,K;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(bfs());
    }
    private static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N,0,0});
        int size = 1000000;
        boolean visited[] = new boolean[size+1];
        int minTime= Math.abs(N-K);
        while(!q.isEmpty()){
            int[] now = q.poll();
            int p = now[0];
            int cnt=now[1];
            int time = now[2];
            visited[p]=true;
            if(p==K){
                if(time<minTime)minTime=time;
            }
            if(time>minTime)continue;
            int np = p*2;
            if(np<=size  && !visited[np]){
                q.add(new int[]{np,cnt+1,time});

            }
            np = p+1;
            if(np<=size && !visited[np]){
                q.add(new int[]{np,cnt+1,time+1});

            }
            np = p-1;
            if(np>=0  && !visited[np]){
                q.add(new int[]{np,cnt+1,time+1});
              
            }


        }
        return minTime;

    }



}