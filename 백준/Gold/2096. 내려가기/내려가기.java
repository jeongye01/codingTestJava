import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine().trim());

        int[][] arr=new int[N][3];
        int max_dp[][]=new int[N][3];
        int min_dp[][]=new int[N][3];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max=0;
        int min=Integer.MAX_VALUE;
        max_dp[0][0]=arr[0][0];
        max_dp[0][1]=arr[0][1];
        max_dp[0][2]=arr[0][2];
        min_dp[0][0]=arr[0][0];
        min_dp[0][1]=arr[0][1];
        min_dp[0][2]=arr[0][2];
        for(int i=1;i<N;i++){
            max_dp[i][0]=arr[i][0]+Math.max(max_dp[i-1][0],max_dp[i-1][1]);
            max_dp[i][1]=arr[i][1]+Math.max(Math.max(max_dp[i-1][0],max_dp[i-1][1]),max_dp[i-1][2]);
            max_dp[i][2]=arr[i][2]+Math.max(max_dp[i-1][1],max_dp[i-1][2]);
            min_dp[i][0]=arr[i][0]+Math.min(min_dp[i-1][0],min_dp[i-1][1]);
            min_dp[i][1]=arr[i][1]+Math.min(Math.min(min_dp[i-1][0],min_dp[i-1][1]),min_dp[i-1][2]);
            min_dp[i][2]=arr[i][2]+Math.min(min_dp[i-1][1],min_dp[i-1][2]);

        }

        System.out.println(Math.max(Math.max(max_dp[N-1][0],max_dp[N-1][1]),max_dp[N-1][2])+" "+Math.min(Math.min(min_dp[N-1][0],min_dp[N-1][1]),min_dp[N-1][2]));
    }



}