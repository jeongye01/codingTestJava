import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] dp = new int[N+1][10];
        for(int i=0;i<10;i++){
            dp[1][i]=1;
        }
        for(int i=2;i<=N;i++){
            int preTotal=0;
            for(int j=0;j<10;j++){

                preTotal += dp[i-1][j]%10007;
            }
            dp[i][0] = preTotal%10007;
            int acc=0;
            for(int j=1;j<=9;j++){
                acc+=(dp[i-1][j-1])%10007;
                dp[i][j] = (preTotal-acc)%10007;

            }


        }
        int ans=0;
        for(int i=0;i<10;i++){
            ans+=(dp[N][i])%10007;
        }
        System.out.println(ans%10007);



    }


}