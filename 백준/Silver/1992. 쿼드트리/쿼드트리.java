import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		//입력으로 주어진 0과 1을 arr 배열 값으로 받기.
		for (int i = 0; i < arr.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		//arr 배열의 첫 인덱스[0,0]와 row/col 길이를 인수로 넘겨주기.
		quadTree(0, 0, n);
		System.out.println(sb);
	}

	private static void quadTree(int x, int y, int size) {
		// 색이 같으면 색을 출력
		if (sameColor(x, y, size)) {
			sb.append(arr[x][y]);
		}
		// 색이 다르면 다시 분할하여 검색
		else {
			int halfSize = size / 2;

			sb.append("(");
			quadTree(x, y, halfSize); //왼쪽 위
			quadTree(x, y + halfSize, halfSize);//오른쪽 위
			quadTree(x + halfSize, y, halfSize);//왼쪽 아래
			quadTree(x + halfSize, y + halfSize, halfSize);//오른쪽 아래
			sb.append(")");
		}
	}

	private static boolean sameColor(int x, int y, int size) {
		//요소 1개는 항상 같은 색을 가지기 때문에 true 반환
		if (size == 1) {
			return true;
		} else {
			//2개 이상의 요소를 탐색해야 할 경우 첫번째 값을 기준으로 나머지 요소들과 비교하기.
			int color = arr[x][y];

			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					//다른 색이 발견되면 false를 반환.
					if (arr[i][j] != color) {
						return false;
					}
				}
			}
			//비교가 모두 끝나고도 다른 색이 발견된 적 없으면 true를 반환.
			return true;
		}
		
	}

}