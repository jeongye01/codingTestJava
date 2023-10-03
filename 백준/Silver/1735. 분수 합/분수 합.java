import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int ac = Integer.parseInt(st.nextToken());
		int ap = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		int bc = Integer.parseInt(st.nextToken());
		int bp = Integer.parseInt(st.nextToken());

		int p = ap * bp;
		int c = ac * bp + bc * ap;
		int mod = gcd(c, p);
		System.out.println(c / mod + " " + p / mod);

	}

	public static int gcd(int a, int b) {
		if (a <= b) {
			int temp = a;
			a = b;
			b = temp;
		}

		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

}