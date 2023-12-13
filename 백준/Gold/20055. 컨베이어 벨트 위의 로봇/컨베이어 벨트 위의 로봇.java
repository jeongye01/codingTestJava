import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 위의 그림에서 1번 칸이 있는 위치를 "올리는 위치", N번 칸이 있는 위치를 "내리는 위치"라고 한다.
// 로봇은 올리는 위치에만 올릴 수 있다. 
// 언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내린다. 로봇은 컨베이어 벨트 위에서 스스로 이동할 수 있다. 로봇을 올리는 위치에 올리거나 로봇이 어떤 칸으로 이동하면 그 칸의 내구도는 즉시 1만큼 감소한다.
// ans : 몇 번째 단계가 진행 중일때 종료되었는지 
public class Main {

	static int N, K;
	static int ans = 0;
	static LinkedList<Square> deque = new LinkedList<>();

	static class Square {
		boolean robot;
		int dur; // 내구성

		public Square(int dur) {
			this.dur = dur;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < 2 * N; i++) {
			deque.addLast(new Square(Integer.parseInt(st.nextToken())));
		}
		solve();
		System.out.println(ans);

	}

	public static void solve() {
		int up = 0;
		int down = N - 1;

		while (true) {
			int cnt = 0;
			for (Square s : deque) {

				if (s.dur == 0) {
					cnt++;
					if (cnt >= K) {
						return;
					}
				}

			}
			ans++;

			deque.addFirst(deque.pollLast());
			
			Square downSquare = deque.get(down);
			if ( downSquare.robot) {
				 downSquare.robot = false;
			}

			for (int i = N - 1; i > 0; i--) {
                Square now =deque.get(i);
                Square prev =deque.get(i-1);
				if (prev.robot && !now.robot && now.dur >= 1) {
					now.robot = true;
					now.dur -= 1;
					prev.robot = false;

				}

			}
			if ( downSquare.robot) {
				 downSquare.robot = false;
			}
			Square upSquare = deque.get(up);
			if (upSquare.dur > 0 && !upSquare.robot) {
				upSquare.robot = true;
				upSquare.dur -= 1;
			}

			// System.out.println(cnt);

		}
	}

}
