import java.io.*;


public class Main {
    static int N;
    static boolean[][] stars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine().trim());
        stars = new boolean[N*3+1][N*3+1];
        draw(1,1,N,false);
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(stars[i][j])sb.append('*');
                else sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }
    private static void draw(int y,int x,int size,boolean blank){
          if(blank)return;
          if(size==1){
              stars[y][x] = true;
              return;
          }
          int newSize = size/3;
          draw(y,x,newSize,false);
          draw(y,x+newSize,newSize,false);
          draw(y,x+newSize*2,newSize,false);
          draw(y+newSize,x,newSize,false);
          draw(y+newSize,x+newSize,newSize,true);
          draw(y+newSize,x+newSize*2,newSize,false);
          draw(y+newSize*2,x,newSize,false);
          draw(y+newSize*2,x+newSize,newSize,false);
          draw(y+newSize*2,x+newSize*2,newSize,false);
    }
}