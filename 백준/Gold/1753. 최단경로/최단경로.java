import java.util.*;
import java.io.*;

public class Main {
	static int V, E, K;

	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine().trim()) - 1;
		Node[] adjList = new Node[V]; // 인접 리스트
		int[] distance = new int[V]; // 시작점에서 자신으로 오는 최단거리
		boolean[] visited = new boolean[V]; // 방문 처리 리스트
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(distance, INF);
		distance[K] = 0;

		int min = 0, stopOver = 0;
		for (int i = 0; i < V; i++) { // 모든 정점을 다 처리할때까지 반
			stopOver = -1;
			min = INF;
			// step1 : 미방문 정점 중 출발지에서 가장 가까운 정점을 경유지로 선
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					stopOver = j;
				}
			}
			if (stopOver == -1)
				break;
			// step2 : 방문 처리
			visited[stopOver] = true;
			for (Node temp = adjList[stopOver]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && distance[temp.vertex] > min + temp.weight) {
					distance[temp.vertex] = min + temp.weight;
				}
			}

		}
		for (int d : distance) {
			System.out.println(d == INF ? "INF" : d);
		}

	}

}