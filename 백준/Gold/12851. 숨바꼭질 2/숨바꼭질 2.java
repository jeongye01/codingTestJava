import java.util.*;
import java.io.*;


public class Main {
    static int N,K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();


    }

    private static void bfs(){
        int end = 100000;
        int[] time= new int[end+1];
        int[] cnt = new int[end+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        cnt[N]=1;


        while(!q.isEmpty()){
            Integer now = q.poll();

            if(now==K){

                StringBuilder sb = new StringBuilder();
                sb.append(time[now]).append('\n');
                sb.append(cnt[now]);
                System.out.println(sb);
                return;
            }
            int[] np = {now+1,now-1,now*2};
            for(int i=0;i<3;i++){
                if(np[i]<0 || np[i]>end || (time[np[i]]<time[now]+1 && cnt[np[i]]>0))continue;
                time[np[i]]=time[now]+1;
                cnt[np[i]]+=1;
                q.add(np[i]);

            }

        }
    }


}