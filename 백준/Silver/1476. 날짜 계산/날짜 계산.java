import java.io.*;
import java.util.*;

public class Main {
	static boolean board[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int E = Integer.parseInt(st.nextToken()) - 1;
		int S = Integer.parseInt(st.nextToken()) - 1;
		int M = Integer.parseInt(st.nextToken()) - 1;
		int ans = 1;
		int e = 0, s = 0, m = 0;
		while (true) {

			if (e == E && s == S && m == M) {
				break;
			}
			ans++;
			e = (e + 1) % 15;
			s = (s + 1) % 28;
			m = (m + 1) % 19;

		}

		System.out.println(ans);
	}

	

}