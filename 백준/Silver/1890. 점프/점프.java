import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] board;
    static long[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        board = new int[N][N];
        dp = new long[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0]=1;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==N-1 && j==N-1)break;
                int jump = board[i][j];
                if(i+jump<N){
                    dp[i+jump][j]+=dp[i][j];
                }
                if(j+jump<N){
                    dp[i][j+jump]+=dp[i][j];
                }


            }
        }

        System.out.println(dp[N-1][N-1]);



    }


}