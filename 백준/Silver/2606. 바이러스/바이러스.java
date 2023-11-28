// 풀이시간 -> 20
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int c, pair;
	static List<List<Integer>> computer = new ArrayList<>();
	static int ans;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		c = Integer.parseInt(br.readLine().trim());
		pair = Integer.parseInt(br.readLine().trim());
		visited = new boolean[c];
		ans = 0;
		for (int i = 0; i < c; i++) {
			computer.add(new ArrayList<>());
		}
		for (int i = 0; i < pair; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			computer.get(a).add(b);
			computer.get(b).add(a);
		}
		bfs();
		System.out.println(ans>1 ? ans-1 : 0);

	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			//System.out.println(now+1);
			ans++;
			for (Integer com : computer.get(now)) {
				if (visited[com])
					continue;
				visited[com]=true;
				q.add(com);

			}
		}

	}

}