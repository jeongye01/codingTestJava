import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] matrix;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine().trim());
        matrix = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0;j<N;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            visited = new boolean[N];
            dfs(i,i);
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(matrix[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }
    private static void dfs(int now,int start){
        for(int i=0;i<N;i++){
            if(!visited[i] && matrix[now][i]==1){
                visited[i] = true;
                matrix[start][i]=1;
                dfs(i,start);
            }
        }

    };



}