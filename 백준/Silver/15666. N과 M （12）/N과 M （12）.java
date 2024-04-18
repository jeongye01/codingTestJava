import java.util.*;
import java.io.*;


public class Main {


    static int N,M;
    static int[] perm;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine().trim());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       arr = new int[N];
       perm = new int[M];

       st = new StringTokenizer(br.readLine().trim());
       for(int i=0;i<N;i++){
           arr[i] = Integer.parseInt(st.nextToken());
       }
        Arrays.sort(arr);
       solve(0,0);
        System.out.println(sb);

    }
    private static void solve(int idx,int st){
        if(idx==M){
            for(int e:perm){
                sb.append(e).append(' ');
            }
            sb.append('\n');
            return;
        }
        perm[idx]=-1;
        for(int i=st;i<N;i++){
            if(perm[idx]==arr[i])continue;
            perm[idx]=arr[i];
            solve(idx+1,i);
        }
    }



}