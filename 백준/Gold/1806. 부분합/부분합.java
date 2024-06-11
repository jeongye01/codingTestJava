import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine().trim());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long sum=0;
        Deque<Integer> q = new ArrayDeque<>();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){

               q.add(arr[i]);
               sum+=arr[i];
               if(sum>=S){
                   ans = Math.min(ans,q.size());
               }
               while(!q.isEmpty() && sum-q.peekFirst()>=S){

                   sum-=q.pollFirst();
                   ans = Math.min(ans,q.size());


               }

        }
        System.out.println(ans==Integer.MAX_VALUE?0:ans);





    }
}