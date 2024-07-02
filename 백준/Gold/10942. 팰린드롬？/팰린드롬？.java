import java.util.*;
import java.io.*;


public class Main {
    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine().trim());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine().trim());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine().trim());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            sb.append(solve(s,e)).append('\n');
        }
        System.out.println(sb);

    }
    private static int solve(int s,int e){
             while(s<=e){
                 if(arr[s]!=arr[e])return 0;
                 s++;e--;
             }
             return 1;
    }

}