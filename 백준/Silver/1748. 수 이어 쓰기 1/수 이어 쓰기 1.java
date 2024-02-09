import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int totalCount = 0;
		int num = 1;
		int criteria = 10;
		for (int i = 1; i <= n; i++) {
			if (i % criteria == 0) {
				num += 1;
				criteria *= 10;
			}
			totalCount += num;
		}
		System.out.println(totalCount);
	}
}