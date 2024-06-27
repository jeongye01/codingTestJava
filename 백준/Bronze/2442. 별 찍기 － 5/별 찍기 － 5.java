import java.util.*;
import java.io.*;
import java.util.Scanner;


public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  //      StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=N;i++){

            for(int j=0;j<N-i;j++){
                sb.append(' ');
            }
            for(int j=0;j<2*i-1;j++){
                sb.append('*');
            }

            sb.append('\n');

        }

        System.out.println(sb);
    }
}

