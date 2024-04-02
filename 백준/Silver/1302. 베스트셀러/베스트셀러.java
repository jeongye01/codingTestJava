import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<String, Integer> map = new HashMap<String, Integer>();
    int n = Integer.parseInt(br.readLine().trim());
    String ans = "";
    int max = 0;
    for (int i = 0; i < n; i++) {
      String book = br.readLine().trim();
      Integer cnt = map.get(book);
      if (cnt != null) {
        map.replace(book, cnt + 1);

      } else {
        map.put(book, 1);
        cnt = 0;
      }
      if (cnt + 1 > max) {
        ans = book;
        max = cnt + 1;
      } else if (cnt + 1 == max) {
        if (book.compareTo(ans) < 0) {
          ans = book;
        }
      }
    }
    System.out.println(ans);

  }

}