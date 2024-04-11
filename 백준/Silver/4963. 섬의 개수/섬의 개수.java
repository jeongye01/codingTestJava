import java.util.*;
import java.io.*;


public class Main {

    static int W,H;

    static int[][] board;

    static int ans;


    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st;
       while(true){
           st = new StringTokenizer(br.readLine().trim());
           W = Integer.parseInt(st.nextToken());
           H = Integer.parseInt(st.nextToken());
           if(W==0 && H==0)break;
           board = new int[H][W];
           for(int i=0;i<H;i++){
               st = new StringTokenizer(br.readLine().trim());
               for(int j=0;j<W;j++){
                   board[i][j] = Integer.parseInt(st.nextToken());
               }
           }
           for(int i=0;i<H;i++){
               for(int j=0;j<W;j++){
                   if(board[i][j]==1){
                       ans++;
                       bfs(i,j);

                   }
               }
           }
           sb.append(ans).append('\n');
           ans=0;


       }
        System.out.println(sb);





    }
    private static void bfs(int i,int j){
        int[] dx= {-1,0,1,0,1,1,-1,-1};
        int[] dy={0,1,0,-1,-1,1,1,-1};
        board[i][j]=0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] now = q.poll();
            int y=now[0];
            int x=now[1];
            for(int d=0;d<8;d++){
                int ny=y+dy[d];
                int nx=x+dx[d];
                if(ny<0 || ny>=H || nx<0 || nx>=W || board[ny][nx]==0)continue;
                board[ny][nx]=0;
                q.add(new int[]{ny,nx});
            }
        }
    }



}