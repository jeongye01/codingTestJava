import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean visited[];
	static int N, M, V;
	static List<List<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(graph.get(i));

		}
		dfs(V);
		System.out.println(sb);
		visited = new boolean[N + 1];
		sb.setLength(0);
		bfs();
		System.out.println(sb);
		graph.clear();

	}

	private static void dfs(int node) {
		sb.append(node).append(" ");
		visited[node] = true;
		for (int n : graph.get(node)) {
			if (!visited[n]) {
				dfs(n);
			}
		}
	}

	private static void bfs() {
		Deque<Integer> q=new ArrayDeque<>();
		sb.append(V).append(" ");
		visited[V] = true;
	    q.add(V);
	    while(!q.isEmpty()) {
	    	int node=q.poll();
	    	for (int n : graph.get(node)) {
				if (!visited[n]) {
					visited[n]=true;
					q.add(n);
					sb.append(n).append(" ");
				}
			}
	    }

	
	}

}