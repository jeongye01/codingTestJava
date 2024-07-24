import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            q.add(i);
        }
        while(q.size()>1){
            int now = q.poll();
            sb.append(now).append(' ');
            q.add(q.poll());
        }
        sb.append(q.poll());
        System.out.println(sb);


    }



}