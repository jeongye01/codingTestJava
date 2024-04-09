import java.util.*;
import java.io.*;


public class Main {

    static int N;
    static int[] perm;
    static boolean[] selected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine().trim());
       perm = new int [N];
       selected = new boolean[N];
       solve(0);

        System.out.println(sb);
    }
    private static void solve(int idx){
        if(idx==N){
            for(int e:perm){
                sb.append(e).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=1;i<=N;i++){
            if(!selected[i-1]) {
                perm[idx] = i;
                selected[i - 1] = true;
                solve(idx + 1);
                selected[i - 1] = false;
            }
        }

    }

}