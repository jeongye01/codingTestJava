import java.util.Scanner;

public class Main {

    static int MOD = 1000000000;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int dp[][] = new int[N+1][K+1];

        // 초기화 0개로 만들수 있는것의 개수는 0개, 1개로 만들수 있는 개수는 N, 1개 뿐이다.
        for(int i=0;i<=N;i++){
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        // N이 1일 경우 만들수 있는 갯수는 K개
        for(int i=0;i<=K;i++){
            dp[1][i] = i;
        }

        for(int i=2;i<=N;i++){
            for(int j=2;j<=K;j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }

        System.out.println(dp[N][K]);
    }
}