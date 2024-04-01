import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine().trim());
    StringTokenizer st = new StringTokenizer(br.readLine().trim());

    Set<Integer> set = new HashSet<Integer>();
    for(int i=0;i<n;i++){
      set.add(Integer.parseInt(st.nextToken()));
    }
    List<Integer> list = new ArrayList<Integer>(set);
    Collections.sort(list);
    for(Integer e :list){
      sb.append(e).append(' ');
    }
    System.out.println(sb);

  }

}