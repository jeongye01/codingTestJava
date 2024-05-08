import java.util.*;
import java.io.*;

public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N+1];
        int[] dp= new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i-j]+arr[j],dp[i]);
            }

        }
        System.out.println(dp[N]);


    }



}