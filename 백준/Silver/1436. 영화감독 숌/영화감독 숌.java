import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		int cnt = 1;
		int now = 666;
		int ans = 666;
		while (cnt < N) {
			now++;
			if ((now + "").contains("666")) {
				cnt++;
				ans = now;
			}
		}
		System.out.println(ans);

	}

}