import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean[] visited;
	static int flag;
	static List<List<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		flag = 0;

		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			
			dfs(i, 0);
		
			if(flag==1) {
				break;
			}
		}

		System.out.println(flag);
	}

	private static void dfs(int idx, int cnt) {
		visited[idx] = true;
		if (cnt >= 4) {
			flag = 1;
			return;
		}
		for (Integer e : list.get(idx)) {
			if (!visited[e]) {
				visited[e] = true;
				dfs(e, cnt + 1);
				visited[e] = false;

			}
			if (flag == 1) {
				return;
			}

		}
		visited[idx] = false;
	}

}