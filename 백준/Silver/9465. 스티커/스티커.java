import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for(int t=1;t<=T;t++){
            int N = Integer.parseInt(br.readLine().trim());
            arr = new int[2][N];
            dp = new int[2][N];
            for(int i=0;i<2;i++){
                st = new StringTokenizer(br.readLine().trim());
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            for(int i=1;i<N;i++){
                dp[0][i]=Math.max(dp[1][i-1]+arr[0][i],dp[0][i-1]);
                dp[1][i]=Math.max(dp[0][i-1]+arr[1][i],dp[1][i-1]);
            }
            sb.append(Math.max(dp[0][N-1],dp[1][N-1])).append('\n');


        }
        System.out.println(sb);



    }


}