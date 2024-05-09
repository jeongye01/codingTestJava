import java.util.*;
import java.io.*;

public class Main {

   static int[][] board;
   static int sx,sy,ex,ey;
   static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());


        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine().trim());
            board = new int[N][N];
            StringTokenizer st;
            st = new StringTokenizer(br.readLine().trim());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine().trim());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());
            sb.append(bfs()).append('\n');
        }
        System.out.println(sb);
    }
    private static int bfs(){
        int[] dx={-1,-2,-2,-1,  1,2,2,1};
        int[] dy={-2,-1,1,2,    2,1,-1,-2};
        board[sy][sx]=1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sy,sx,0});
        while(!q.isEmpty()){
            int now[] = q.poll();
            int y=now[0];
            int x=now[1];
            int cnt=now[2];
            if(y==ey && x==ex) return cnt;
            for(int d=0;d<8;d++){
                int ny= y+dy[d];
                int nx = x+dx[d];
                if(ny<0 || ny>=N || nx<0||nx>=N || board[ny][nx]==1)continue;
                board[ny][nx]=1;
                q.add(new int[] {ny,nx,cnt+1});
            }
        }
        return -1;

    };



}