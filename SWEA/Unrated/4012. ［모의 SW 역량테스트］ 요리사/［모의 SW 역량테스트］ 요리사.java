import java.io.*;
import java.util.*;
 
public class Solution {
    static int record[][], N, ans;
    static boolean[] classify;
 
    private static void comb(int idx,int cnt) {
        if (cnt == N/2) {
            int food1 = 0, food2 = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (classify[i] && classify[i] == classify[j] ) {
                        food1 += record[i][j] + record[j][i];
                    } else if (! classify[i] && classify[i] == classify[j]) {
                        food2 += record[i][j] + record[j][i];
                    }
                }
            }
            
            ans = Math.min(ans, Math.abs(food1 - food2));
            return;
        }
        for(int i=idx;i<N;i++) {
             
            classify[i] = true;
            comb(i + 1,cnt+1);
            classify[i] = false;
        }
 
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ans = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            record = new int[N][N];
            classify = new boolean[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    record[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            comb(0,0);
             
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
             
        }
        System.out.println(sb);
    }
 
}