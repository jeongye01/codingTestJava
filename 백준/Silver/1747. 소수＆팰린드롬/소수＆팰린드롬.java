import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		int n = N;
		while (true) {
			if (isPrime(n) && isPel(n + "")) {
				System.out.println(n);
				break;
			}
			n++;
		}

	}

	static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	static boolean isPel(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.toString().equals(sb.reverse().toString());

	}

}