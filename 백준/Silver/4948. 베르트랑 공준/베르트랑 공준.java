import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int N = Integer.parseInt(br.readLine().trim());
			if (N == 0)
				break;
			int cnt = 0;
			for (int n = N + 1; n <= 2 * N; n++) {

				boolean isPrime = true;
				for (int i = 2; i <= Math.sqrt(n); i++) {
					if (n % i == 0) {
						isPrime = false;
						break;
					}

				}
				if (isPrime)
					cnt++;

			}
			sb.append(cnt).append('\n');

		}

		System.out.println(sb);
	}

}