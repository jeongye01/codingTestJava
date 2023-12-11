import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// ans : 입력받은 국가 K의 등수를 하나의 정수로 출력
public class Main {

	static int N, K;
	static Country[] list;

	static class Country implements Comparable<Country> {
		int g, s, b, n;

		public Country() {

		}

		public Country(int n, int g, int s, int b) {
			this.n = n;
			this.g = g;
			this.s = s;
			this.b = b;
		}

		@Override
		public int compareTo(Country o) {
			if (this.g == o.g && this.s == o.s) {
				return this.b - o.b;
			} else if (this.g == o.g) {
				return this.s - o.s;
			} else {
				return this.g - o.g;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new Country[N];
		Country c = new Country();
		int ans = 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[i] = new Country(n, g, s, b);
			if (n == K) {
				c.n = n;
				c.g = g;
				c.s = s;
				c.b = b;
			}
		}
		for (int i = 0; i < N; i++) {
			if (list[i].n != K && c.compareTo(list[i]) < 0) {
				ans++;
			}
		}
		System.out.println(ans);

	}

}