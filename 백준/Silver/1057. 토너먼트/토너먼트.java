import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int N = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int round = 1;
    if (a < b) {
      while (!(a % 2 == 1 && b % 2 == 0 && b - 1 == a)) {
        a = (a / 2 + a % 2);
        b = (b / 2 + b % 2);
        round++;
      }
    } else {
      while (!(a % 2 == 0 && b % 2 == 1 && a - 1 == b)) {
        a = (a / 2 + a % 2);
        b = (b / 2 + b % 2);
        round++;
      }
    }
    System.out.println(round);

  }

}