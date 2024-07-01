import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static boolean[][] stars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine().trim());
        stars = new boolean[N+1][N*2+2];
        draw(N,1,N);
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N*2+1;j++){
                if(stars[i][j])sb.append('*');
                else sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }
    private static void draw(int y,int x,int height){

          if(height==3){
              stars[y-2][x+2] = true;
              stars[y-1][x+3] = true;
              stars[y-1][x+1] = true;
              for(int i=0;i<5;i++){
                  stars[y][x+i] = true;
              }
              return;
          }
          int newHeihgt = height/2;
          draw(y,x,newHeihgt);
          draw(y,x+height,newHeihgt);
          draw(y-newHeihgt,x+newHeihgt,newHeihgt);




    }
}