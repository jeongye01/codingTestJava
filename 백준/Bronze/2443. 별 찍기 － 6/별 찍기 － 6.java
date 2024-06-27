import java.util.*;
import java.io.*;


public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  //      StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=N;i++){

            for(int j=0;j<i-1;j++){
                sb.append(' ');
            }
            for(int j=0;j<2*N-2*(i-1)-1;j++){
                sb.append('*');
            }

            sb.append('\n');

        }

        System.out.println(sb);
    }
}





