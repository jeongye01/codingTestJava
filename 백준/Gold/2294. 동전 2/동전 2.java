import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N+1];
        int[] dp = new int[K+1];
        for(int i=1;i<=N;i++){
            coins[i] = Integer.parseInt(br.readLine().trim());
        }
        for(int i=1;i<=K;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=1;i<=N;i++){

            for(int j=coins[i];j<=K;j++){
                if(dp[j-coins[i]]==Integer.MAX_VALUE)continue;
               dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }

        }

        System.out.println(dp[K]==Integer.MAX_VALUE?-1:dp[K]);


    }



}