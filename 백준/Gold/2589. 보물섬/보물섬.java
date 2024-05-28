import java.util.*;
import java.io.*;
// 상하좌우로 이웃한 육지로만 가능

public class Main {
    static char[][] board;
    static int N,M;
    static int ans=0;
    static boolean visited[][];
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for(int i=0;i<N;i++){
            char[] chs = br.readLine().trim().toCharArray();
            for(int j=0;j<M;j++){
                board[i][j] = chs[j];
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]=='L'){
                    visited = new boolean[N][M];
                    ans=Math.max(bfs(i,j),ans);
                }
            }
        }


        System.out.println(ans);


    }
    private static int bfs(int i,int j){
        int max=0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j,0});
        visited[i][j]=true;
        while(!q.isEmpty()){
            int now[] = q.poll();
            int y=now[0];
            int x=now[1];
            int dist=now[2];
            max = Math.max(max,dist);
            for(int d=0;d<4;d++){
                  int ny = y + dy[d];
                  int nx = x + dx[d];
                  if(ny<0 || ny>=N || nx<0 || nx>= M || visited[ny][nx] || board[ny][nx]=='W')continue;
                  visited[ny][nx]=true;
                  q.add(new int[] {ny,nx,dist+1});
            }
        }



        return max;
    }



}