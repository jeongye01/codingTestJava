import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String s = br.readLine().trim();
    List<String> list = new ArrayList<String>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      list.add(s.substring(i, len));
    }
    Collections.sort(list);
    for (String str : list) {
      sb.append(str).append('\n');
    }
    System.out.println(sb);
  }

}