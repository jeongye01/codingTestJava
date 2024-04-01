import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    Long a = Long.parseLong(st.nextToken());
    Long b = Long.parseLong(st.nextToken());
    Long ans = 0l;
    Long n = a > b ? a : b;
    Long m = n;
    while (!(n % a == 0 && n % b == 0) && n < a * b) {

      n += m;
    }
    ans = n;
    System.out.println(ans);

  }

}