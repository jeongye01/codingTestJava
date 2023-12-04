import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  ans : S층에서 G층으로 가기 위해 눌러야 하는 버튼의 수의 최솟값, G층에 갈 수 없다면, "use the stairs"

public class Main {
	static int F, S, G, U, D; // 1~F층 까지

	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		ans = Integer.MAX_VALUE;

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		if (S == G) {
			ans = 0;
		} else {
			bfs();
		}

		System.out.println(ans == Integer.MAX_VALUE ? "use the stairs" : ans);
	}

	public static void bfs() {
		boolean visited[] = new boolean[F + 1];
		Queue<int[]> q = new LinkedList<>();
		visited[S] = true;
		q.add(new int[] { S, 0 });
		while (!q.isEmpty()) {
			int now[] = q.poll();
			int p = now[0], cnt = now[1];
			if (p == G) {
				ans = cnt;
				return;
			}
			if (p - D >= 1 && !visited[p - D]) {
				visited[p - D] = true;
				q.add(new int[] { p - D, cnt + 1 });
			}
			if (p + U <= F && !visited[p + U]) {
				visited[p + U] = true;
				q.add(new int[] { p + U, cnt + 1 });
			}

		}

	}

}