import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// ans : 입력받은 국가 K의 등수를 하나의 정수로 출력
public class Main {

	static int N, K;
	static Man[] list;

	static class Man implements Comparable<Man> {
		int w, h, g = 1;

		public Man(int w, int h) {
			this.w = w;
			this.h = h;

		}

		@Override
		public int compareTo(Man o) {
			if (this.w > o.w && this.h > o.h) {
				return 1;
			}
			return -1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());

		list = new Man[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			list[i] = new Man(w, h);

		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					if (list[j].compareTo(list[i]) > 0) {
						list[i].g += 1;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			sb.append(list[i].g).append(' ');
		}
		System.out.println(sb);

	}

}