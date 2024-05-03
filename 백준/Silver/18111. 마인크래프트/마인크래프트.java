import java.util.*;
import java.io.*;

// 작업1 : 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다. -> 2초
// 작업2 : 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다. -> 1초
// 작업을 시작할 때 인벤토리에는 B개의 블록
// 땅의 높이는 256블록을 초과할 수 없다
// ans :  땅을 고르는 데 걸리는 최소 시간과 땅의 높이를 출력하시오. 답이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것
public class Main {
    static int N,M;
    static long B;
    static int maxh=-1;
    static int mint=Integer.MAX_VALUE;
    static int[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        board = new int[N][M];
        int maxb=0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0;j<M;j++){
               board[i][j] = Integer.parseInt(st.nextToken());
               if(maxb<board[i][j])maxb=board[i][j];
            }
        }
        for(int h=0;h<=maxb;h++){
            int lack=0;
            int over=0;
            int time=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(board[i][j]>h){
                      over+=(board[i][j]-h);

                    }else if(board[i][j]<h){
                       lack+=(h-board[i][j]);
                    }
                }
            }

            if((over+B)>=lack){
               //System.out.println(time+" "+h);
                time=(lack+over*2);
                if(mint>=time){
                    mint=time;
                    maxh=h;
                }
            }
        }




        sb.append(mint).append(' ').append(maxh);
        System.out.println(sb);

    }

}