
import java.util.*;
import java.io.*;

public class Main {
	static int total;
	static int[] parent;

	static class Node implements Comparable<Node> {
		int to;
		int from;
		int value;

		public Node(int to, int from, int value) {
			this.to = to;
			this.from = from;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		parent = new int[v + 1];
		for (int i = 1; i < v + 1; i++) {
			parent[i] = i;
		}
		Queue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.add(new Node(a, b, w));

		}
		total = 0;
		for (int i = 0; i < e; i++) {
			Node node = pq.poll();
			if (!isSameParent(find(node.from), find(node.to))) {
				total += node.value;
				union(node.to, node.from);
			}

		}
		System.out.println(total);

	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			parent[y] = x;
		}

	}

	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return true;
		return false;
	}

}