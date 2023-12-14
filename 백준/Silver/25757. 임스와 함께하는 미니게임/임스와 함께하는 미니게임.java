import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// ans : 임스가 최대로 몇 번이나 게임을 플레이할 수 있는지 
public class Main {
	static int N;
	static char Type;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		HashSet<String> set = new HashSet<>();
		N = Integer.parseInt(st.nextToken());
		Type = st.nextToken().charAt(0);
		for (int i = 0; i < N; i++) {
			String name = br.readLine().trim();
			set.add(name);
		}
		if (Type == 'Y') {
			ans = set.size();
		} else if (Type == 'F') {
			ans = set.size() / 2;
		} else if (Type == 'O') {
			ans = set.size() / 3;
		}

		System.out.println(ans);

	}

}