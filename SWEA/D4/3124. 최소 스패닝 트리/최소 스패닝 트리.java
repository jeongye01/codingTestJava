import java.util.*;
import java.io.*;

public class Solution {
	static class Vertex implements Comparable<Vertex> {
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			List<List<Vertex>> adjMatrix = new ArrayList<>();
			for (int i = 0; i < V; i++) {
				adjMatrix.add(new ArrayList<>());
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int weight = Integer.parseInt(st.nextToken());
				adjMatrix.get(a).add(new Vertex(b, weight));
				adjMatrix.get(b).add(new Vertex(a, weight));

			}
			// 방문정점(트리정점표시)
			boolean[] visited = new boolean[V];
			int[] minEdge = new int[V];
			PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
			Arrays.fill(minEdge, Integer.MAX_VALUE);
			minEdge[0] = 0;
			pQueue.offer(new Vertex(0, minEdge[0]));
			long result = 0;
			int min = 0, minVertex = 0, cnt = 0;
			while (!pQueue.isEmpty()) {
				Vertex cur = pQueue.poll();
				minVertex = cur.no;
				min = cur.weight;
				if (visited[minVertex])
					continue;
				visited[minVertex] = true;
				result += min;
				if (++cnt == V)
					break;
				for(Vertex nv :adjMatrix.get(minVertex)) {
					if(!visited[nv.no]) {
						minEdge[nv.no] = nv.weight;
						pQueue.offer(new Vertex(nv.no,nv.weight));
					}
				}
				
			}

			sb.append("#").append(tc).append(" ").append(result).append("\n");

		}
		System.out.println(sb);

	}
}