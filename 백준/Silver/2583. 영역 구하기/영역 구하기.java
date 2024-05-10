import java.util.*;
import java.io.*;

public class Main {

    static int M,N,K;
    static int[][] board;
    static List<Integer> areas;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[M][N];
        areas = new ArrayList<>();
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine().trim());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            for(int y=sy; y<ey; y++){
                for(int x=sx;x<ex;x++){

                    board[y][x]=1;
                }
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]==0){

                    areas.add(bfs(i,j));
                }
            }
        }
        sb.append(areas.size()).append('\n');
        Collections.sort(areas);
        for(Integer area:areas){
            sb.append(area).append(' ');
        }
        System.out.println(sb);



    }
    static private int bfs(int i,int j){
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {0,-1,0,1};
        int[] dy = {-1,0,1,0};
        q.add(new int[]{i,j});
        board[i][j]=2;
        int cnt = 0;
        while(!q.isEmpty()){
            int now[] = q.poll();
            cnt++;
            int y = now[0];
            int x = now[1];
            for(int d=0;d<4;d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny<0|| ny>=M ||  nx<0 || nx>=N || board[ny][nx]!=0) continue;
                board[ny][nx]=2;
                q.add(new int[] {ny,nx} );

            }
        }
        return cnt;
    }



}