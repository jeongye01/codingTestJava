import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static List<List<Integer>> list;
	static int visited[], cnt[], max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		
		cnt = new int[N];
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			list.get(b).add(a);
		}
		for (int i = 0; i < N; i++) {
			visited = new int[N];
			bfs(i);

		}
		for (int i = 0; i < N; i++) {
			
            if(cnt[i]==max) {
            	 sb.append(i+1).append(" ");
            }
			

		}
		System.out.println(sb);
	}

	public static void bfs(int st) {

	
		visited[st] = 1;
		int tmp = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(st);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (Integer node : list.get(now)) {
				if (visited[node] == 0) {
					visited[node] = 1;
					q.offer(node);
					tmp++;
				}
			}

		}

		cnt[st] = tmp;
		max = Math.max(max, tmp);
	}

}