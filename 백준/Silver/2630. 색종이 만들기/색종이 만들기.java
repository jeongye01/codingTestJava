import java.util.*;
import java.io.*;


public class Main {

    static int N;
    static int[][] board;
    static int wCnt; // 0
    static int bCnt; // 1
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st;
       N = Integer.parseInt(br.readLine().trim());
       board = new int[N][N];
       for(int i=0;i<N;i++){
           st=new StringTokenizer(br.readLine().trim());
           for(int j=0;j<N;j++){
               board[i][j] = Integer.parseInt(st.nextToken());
           }
       }
       solve(0,N,0,N,N);
       sb.append(wCnt).append('\n').append(bCnt);
       System.out.println(sb);
    }
    private static void solve(int sy,int ey,int  sx,int ex,int size){

        int cnt=0;
        for(int i=sy;i<ey;i++){
            for(int j=sx;j<ex;j++){
                cnt+=board[i][j];
            }
        }
        if(cnt==0){
            wCnt++;
        }else if(cnt==(ey-sy)*(ex-sx)){
            bCnt++;
        }else{
            solve(sy,ey-size/2,sx,ex-size/2,size/2);
            solve(sy,ey-size/2,sx+size/2,ex,size/2);
            solve(sy+size/2,ey,sx,ex-size/2,size/2);
            solve(sy+size/2,ey,sx+size/2,ex,size/2);

        }
    }
}