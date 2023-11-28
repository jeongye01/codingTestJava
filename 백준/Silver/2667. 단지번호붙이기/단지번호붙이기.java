// 풀이시간 -> 20
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int arr[][], n;
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { -1, 0, 1, 0 };
    static List<Integer> cnts = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			char[] row = br.readLine().trim().toCharArray();
			for (int j = 0; j < n; j++) {
				arr[i][j] = row[j] - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
	
		Collections.sort(cnts);
		StringBuilder sb = new StringBuilder();
		sb.append(cnts.size()).append('\n');
		for(Integer c : cnts) {
			sb.append(c).append('\n');
		}
		System.out.println(sb);

	}

	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });
		arr[i][j] = 2;
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[1], y = now[0];
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[ny][nx] != 1)
					continue;
				cnt++;
				q.add(new int[] { ny, nx });
				arr[ny][nx] = 2;
			}

		}
		cnts.add(cnt);
		

	}
}