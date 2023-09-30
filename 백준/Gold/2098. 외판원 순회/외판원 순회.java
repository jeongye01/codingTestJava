import java.util.*;
import java.io.*;

// 외판원 순회 (Traveling Salesman problem)
// DFS + DP + Bitmasking
public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int maxBitMask;
    static int ans = Integer.MAX_VALUE/2;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        maxBitMask = (int)Math.pow(2,N);
        // 만약 N이 4라면 0000~1111 (2) 이용해서 방문표시
        dp = new int[N][maxBitMask];
        for(int i = 0; i < N; i++){
        // 처음 dp를 모두 INF로 초기화
            Arrays.fill(dp[i],Integer.MAX_VALUE/2);
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 1);
        System.out.println(ans);
    }

//    @param : 현재 방문한 도시, 현재까지 방문한 도시들 (bitmasking)
    public static void dfs(int city, int visited){
//        전부 방문했으면
        if(visited == maxBitMask-1){
//            마지막 노드에서 출발 노드로 돌아오는 엣지가 없으면 오류
            if(map[city][0] == 0){
                return;
            }
            ans = Math.min(ans, dp[city][visited]+map[city][0]);
            return;
        }
        for(int i = 0; i < N; i++){
            if((visited & (1 << i)) == 0 && map[city][i] != 0){
//        출발점에서 다음 노드까지 거리 초기화
                if(visited == 1){
//                    System.out.println("초기 값 세팅");
                    dp[i][visited | (1 << i)] = map[0][i];
                    dfs(i, visited | (1 << i));
                }
                // 방문 기록이 동일할 때
                // i까지 가는 비용 vs 현재 비용 + 현재 위치에서 i까지 가는 비용 비교
                else if(dp[i][visited | (1 << i)] > dp[city][visited] + map[city][i]){
                    dp[i][visited | (1 << i)] = dp[city][visited] + map[city][i];
                    dfs(i, visited | (1 << i));
                }
            }
        }
    }
}