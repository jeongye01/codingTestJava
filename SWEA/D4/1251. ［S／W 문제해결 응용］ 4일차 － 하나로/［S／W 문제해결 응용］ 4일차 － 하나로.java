import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static double E;
	static List<Edge> edgeList;
	static int arrX[], arrY[];
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			edgeList = new ArrayList<>();
			arrX = new int[N];
			arrY = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < N; x++) {

				arrX[x] = Integer.parseInt(st.nextToken());

			}
		
			st = new StringTokenizer(br.readLine(), " ");
			for (int y = 0; y < N; y++) {

				arrY[y] = Integer.parseInt(st.nextToken());

			}
			
			E = Double.parseDouble(br.readLine().trim());
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					double w = (Math.pow(arrX[i] - arrX[j], 2) + Math.pow(arrY[i] - arrY[j], 2)) * E;
					edgeList.add(new Edge(i, j, w));
				}
			}
		
			Collections.sort(edgeList);
			
			make();

			
			double result = 0; // MST 비용
			int count = 0; // 연결된 간선 개수
			for (Edge e : edgeList) {
			
				if (union(e.from, e.to)) {
					result += e.weight;
					if (++count == N - 1) {
						break;
					}
				}
			}
			edgeList.clear();
			sb.append("#").append(tc).append(" ").append(Math.round(result)).append("\n");
		}
		System.out.println(sb);

	}

	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}

	static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) {
			return false; // 사이클 발생
		}
		parents[bRoot] = aRoot;
		return true;
	}

}
