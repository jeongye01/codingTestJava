import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	// N, answer 선언
	static int N, answer;

	public static void main(String[] args) throws IOException {
		// 입력을 위해 buffer 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 속도를 위해 사용
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 스택을 이용 후입 선출 구조
		Stack<int[]> works = new Stack<int[]>();
		// 분 N 입력
		N = Integer.parseInt(st.nextToken());
		// answer 초기화
		answer = 0;
		// 차례대로 시간 지남을 for문으로 나타탬
		for (int i = 0; i < N; i++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			// 일이 생기는지 없는지
			int w = Integer.parseInt(st.nextToken());
			if (w == 1) {
				// 일이라면 value 입력
				int value = Integer.parseInt(st.nextToken());
				// 시간 입력
				int time = Integer.parseInt(st.nextToken());
				// 일단 받자마자 일하기 때문에 1 빼본다.
				if (time - 1 == 0) {
					// 0이라면 answer 더하고 스택에 넣지는 않음
					answer += value;
				} else {
					// 그게 아니라면 1 빼서 스택 구조에 넣ㅇ므
					works.add(new int[] { value, time - 1 });
				}
			} else {
				// 일이 아니라면 스택이 비었는지 탐색하고
				if (!works.isEmpty()) {
					// 있다면 가장 마지막에 입력된 값을 가져옴
					int[] last = works.pop();
					// 1빼봄
					last[1]--;
					// 0이면
					if (last[1] == 0) {
						// answer 더하고
						answer += last[0];
					} else {
						// 아니면 다시 넣어줌
						works.add(last);
					}
				}
			}
		}
		// 반복문 빠져 나오면 마지막 answer 입력
		System.out.println(answer);
	}
}