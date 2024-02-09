import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Map<String,String> map = new HashMap<String,String>();
    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    for(int i=0;i<N;i++){
      st = new StringTokenizer(br.readLine().trim());
      map.put(st.nextToken(),st.nextToken());
    }
    for(int i=0;i<M;i++){
     
      sb.append(map.get(br.readLine().trim())).append('\n');
    }
    System.out.println(sb);
  }

}