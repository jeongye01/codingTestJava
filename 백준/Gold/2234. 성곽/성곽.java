import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	// input
	static int N, M,room =0, maxNum = 0;
	static int[][] map, wall;
	// bfs
	static Deque<int[]> deque;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dir = { 1, 2, 4, 8 };
	static ArrayList<Integer> space =  new ArrayList(); // 방의 넓이 담기 
	static HashMap<Integer, Set<Integer>> side = new HashMap<>(); // 키: 방 넘버 , 값: 근접해 있는 방들의 넘버 

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		wall = new int[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				wall[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1
		int num = 1; // 1번 방부터
		deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					bfs(i, j, num++); // 방 하나를 탐색하는 함수
					room++; // 방 개수 증가
				}
			}
		}
		
		System.out.println(room); // 방 개수 
		System.out.println(maxNum); // bfs에서 계속 갱신시킨 가장 넓은 방의 넓이
		int sum = 0; // 벽 하나 허물고 합친 넓이
		for (int i = 1; i <= room; i++) { // 1번방부터 room(방의 개수)번 방까지 살펴보면서
			if (side.get(i) != null) { // 인접한 방이 있으면
				for (int j : side.get(i)) { // 방의 넘버를 하나씩 받아온다
					sum = Math.max(space.get(i-1) + space.get(j-1), sum); // 최대 값으로 계속 갱신
				}
			}
		}
		System.out.println(sum);
	}

	private static void bfs(int x, int y, int num) {
		int nx, ny, cnt =0;
		int[] pos = new int[2]; // 좌표값을 담을 배열
		deque.add(new int[] { x, y }); // num번 방 시작
		map[x][y] = num; // num번 방이므로 num 할당
		Set<Integer> set = new HashSet<>(); // 인접한 방의 번호를 담을 set(중복 방지)
		while (!deque.isEmpty()) {
			pos = deque.poll();
			x = pos[0];
			y = pos[1];
			cnt++; // 새로운 블럭에 올때마다 방의 넓이 증가
			for (int i = 0; i < 4; i++) { // 서, 북, 동, 남 순서
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) // 범위 벗어나면
					continue;
				if (map[nx][ny] != 0 && map[nx][ny] != num) { // 번호가 할당된 방이고(이미 들린 방이고), 그게 지금 방은 아닐때 
					set.add(map[nx][ny]); // 인접한 방 세트에 추가
					continue;
				}
				// dir = {1, 2, 4, 8}; 서, 북, 동, 남 순서 
				if ((wall[x][y] & dir[i]) == 0 // * 비트 연산을 만족하고,
						&& map[nx][ny] == 0) { // 아직 방문 안했으면
					deque.add(new int[] { nx, ny }); // 탐색하기 위해 담고, 
					map[nx][ny] = num; // num번 방이므로 num 할당
					continue;
				}
				
			}
		}
		side.put(num, set); // 키: num, 값: 인접한 방 세트
		space.add(cnt); // 방 넓이 담기
		maxNum = Math.max(maxNum, cnt); // 가장 넓은 방 넓이 갱신
	}
}