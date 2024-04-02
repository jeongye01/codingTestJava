import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine().trim());
    for (int t = 0; t < T; t++) {

      StringTokenizer st = new StringTokenizer(br.readLine().trim());
      int n = Integer.parseInt(st.nextToken());
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      Long sum = 0l;
      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          sum += gcd(arr[i], arr[j]);
        }
      }
      sb.append(sum).append('\n');

    }
    System.out.println(sb);
  }

  private static int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

}