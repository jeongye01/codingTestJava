import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 가장 처음에 양분은 모든 칸에 5만큼 들어있다.
// 같은 1×1 크기의 칸에 여러 개의 나무가 심어져 있을 수도 있다.
// 각 칸에 추가되는 양분의 양은 A[r][c]
// ans :  K년이 지난 후 살아남은 나무의 수

public class Main {
	static int N, M, K;
	static int add[][], board[][];
	static LinkedList<Tree> trees;
	static Queue<Tree> dead;
	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int ans;

	static class Tree {
		int x;
		int y;
		int age;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		trees = new LinkedList<>();
		dead = new LinkedList<>();
		add = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = 5;
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				add[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			trees.add(new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken())));
		}

		play();

		System.out.println(trees.size());

	}

	public static void play() {
		for (int k = 0; k < K; k++) {
			// 봄 .
			Iterator<Tree> iterator = trees.iterator();
			while (iterator.hasNext()) {
				Tree tree = iterator.next();
				int r = tree.x;
				int c = tree.y;
				int age = tree.age;
				if (board[r][c] - age < 0) {
					dead.offer(tree);
					iterator.remove();
				} else {
					board[r][c] -= age;
					tree.age += 1;
				}
			}
			// 여름
			while (!dead.isEmpty()) {
				Tree tree = dead.poll();
				board[tree.x][tree.y] += tree.age / 2;
			}
			LinkedList<Tree> newTrees = new LinkedList<>();
			// 가을
			for (Tree tree : trees) {
				int r = tree.x;
				int c = tree.y;
				if (tree.age % 5 != 0)
					continue;
				for (int d = 0; d < 8; d++) {
					int nr = r + dy[d];
					int nc = c + dx[d];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					newTrees.add(new Tree(nr, nc, 1));
				}
			}
			trees.addAll(0, newTrees);
			// 겨울
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] += add[i][j];
				}
			}
		}
	}

}
