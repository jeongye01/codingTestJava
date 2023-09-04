import java.io.*;

public class Main {
	static String[] files;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		files = new String[N];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			files[i] = br.readLine().trim();
		}
		for (int i = 0; i < files[0].length(); i++) {
			boolean isSame = true;
			for (int j = 1; j < N; j++) {
				if (files[j - 1].charAt(i) != files[j].charAt(i)) {
					isSame = false;
					break;
				}
			}
			if (isSame) {
				sb.append(files[0].charAt(i));
			} else {
				sb.append('?');
			}
		}
		System.out.println(sb.toString());
	}
}
