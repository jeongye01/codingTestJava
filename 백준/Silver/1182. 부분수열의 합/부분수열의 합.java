import java.util.*;
import java.io.*;


public class Main {

    static int N,M;
    static int[] arr;
    static int ans;
    static int[] picked;

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st = new StringTokenizer(br.readLine().trim());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       arr = new int[N];
       picked =new int[N];
       st = new StringTokenizer(br.readLine().trim());
       for(int i=0;i<N;i++){
           arr[i] = Integer.parseInt(st.nextToken());
       }
       for(int size=1;size<=N;size++){
           solve(0,0,size);
       }



        System.out.println(ans);


    }
    private static void solve(int idx,int st,int size){
        if(idx==size){
            int sum=0;
            for(int e:picked){
                sum+=e;
            }
           // System.out.println(Arrays.toString(picked));
            if(sum==M)ans++;
            return;
        }
        for(int i=st;i<N;i++){
            picked[idx]=arr[i];
            solve(idx+1,i+1,size);
        }
    }


}