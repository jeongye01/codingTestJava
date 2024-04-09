import java.util.*;
import java.io.*;


public class Main {
    static int N,M;
    static int[] arr;
    static int[] perm;
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
       solve(0);
        System.out.println(sb);
    }
    private static void solve(int idx){
        if(idx == M){
            for(int e:perm){
                sb.append(e).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=0;i<N;i++){
            perm[idx]=arr[i];
            solve(idx+1);
        }
    }

}