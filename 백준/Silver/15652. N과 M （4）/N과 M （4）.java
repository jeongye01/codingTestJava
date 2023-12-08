
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;
	static int seq[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		seq = new int[M];

		make(0, 1);

		System.out.println(sb);

	}

	public static void make(int depth, int st) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(seq[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = st; i <= N; i++) {
			
			seq[depth] = i;
			make(depth + 1, i );
		}
	}

}