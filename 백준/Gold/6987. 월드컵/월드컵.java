import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static int[][] games = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 },
			{ 2, 3 }, { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 5 }, { 4, 5 } },
			// 게임 경기 결과 -> 나중에 입력받을 result 배열 순서에 따라 0번 인덱스는 승리, 1번은 무승부, 2번은 패배
			// 0, 2 -> 앞 팀은 승리, 뒤 팀은 패배, 1, 1 -> 둘 다 무승부, 2, 0 -> 앞 팀은 패배 뒤 팀은 승리
			order = { { 0, 2 }, { 1, 1 }, { 2, 0 } },
			// 경기 결과 이중 리스트 받기 위해 선언
			record;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		record = new int[6][3];
		for (int i = 0; i < 4; i++) {
			int ix = 0;
			st = new StringTokenizer(br.readLine());
			// 한 줄로 입력받기 때문에 결고 개씩 끊어서 result에 넣어준다.
			for (int j = 0; j < 16; j += 3) {
				record[ix][(j % 3)] = Integer.parseInt(st.nextToken());
				record[ix][(j + 1) % 3] = Integer.parseInt(st.nextToken());
				record[ix][(j + 2) % 3] = Integer.parseInt(st.nextToken());
				ix++;
			}
			// 초기 answer 0 선언
			ans = 0;
			// 백트래킹 시작
			bt(0);
			// sb에 추가하기
			sb.append(ans).append(" ");
		}
		// sb 출력
		System.out.println(sb);

	}

	public static void bt(int idx) {

		// 종료 조건 -> 게임 결과가 총 15게임이기 때문에 games 배열 길이
		if (idx == 15) {
			// result 배열의 값들이 모두 0이라면 정상적으로 게임이 다 진행되고 짝이 맞게 진행됐다.
			// sum이 0이면 answer 1로 변경
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (record[i][j] > 0) {
						ans = 0;
						return;
					}
				}
			}
			ans = 1;
			return;
		}

		int teamA = games[idx][0];
		int teamB = games[idx][1];

		for (int i = 0; i < 3; i++) {
			// 승리, 패배, 무승부 총 3가지 이기 때문에 for문으로 order 배열 인덱스 탐색.
			int aGameResult = order[i][0];
			int bGameResult = order[i][1];
			// 각 팀의 게임 결과가 0보다 커야지만 다음 경기 탐색에 의미가 있고 그게 아니라면 무의미하기 때문에 걸러준다.
			if (record[teamA][aGameResult] > 0 && record[teamB][bGameResult] > 0) {
				// 각 팀 게임 결과 값들을 1씩 빼준다. (짝 맞춰서)
				record[teamA][aGameResult] -= 1;
				record[teamB][bGameResult] -= 1;
				bt(idx + 1);
				// 다시 원상 복구를 시켜준다.
				record[teamA][aGameResult] += 1;
				record[teamB][bGameResult] += 1;
			}
		}

	}

}