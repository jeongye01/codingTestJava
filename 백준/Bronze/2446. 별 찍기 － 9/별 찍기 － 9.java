import java.util.*;
import java.io.*;


public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //      StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=2*N-1;i++){
            int end = i<=N?(2*N-i) : (2*N-1-(2*N-1-i));
            for(int j=1;j<=end;j++) {

                boolean condition=j>=i;
                if(i>N){
                    condition=j>(2*N-1-i);
                }

                if(condition){
                    sb.append('*');
                }else{
                    sb.append(' ');
                }

            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}