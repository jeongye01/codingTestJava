import java.util.*;
import java.io.*;


public class Main {

    static int arr[] ;
    static int K;

    static int[] perm = new int[6];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       StringTokenizer st;
       while(true){
           st = new StringTokenizer(br.readLine().trim());

           K = Integer.parseInt(st.nextToken());
           if(K==0)break;
           arr=new int[K];
           for(int i=0;i<K;i++) {
               arr[i] = Integer.parseInt(st.nextToken());
           }
           solve(0,0);
           sb.append('\n');
       }
        System.out.println(sb);

    }
    private static void solve(int idx,int st){
        if(idx==6){
            for(Integer e: perm){
                sb.append(e).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=st;i<K;i++){
            perm[idx]=arr[i];
            solve(idx+1,i+1);
        }

    }
}