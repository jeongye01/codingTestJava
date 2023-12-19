
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N,M;
	static int[] arr;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==0 && b==0 && c==0)break;
			int max = Math.max(a, b);
			max = Math.max(c, max);
			if((a+b+c)-max <=max) sb.append("Invalid");
			else if(a==b && b==c) sb.append("Equilateral");
			else if(a==b || b==c || c==a) sb.append("Isosceles");
			else if(a!=b && b!=c && c!=a) sb.append("Scalene");
			else sb.append("Invalid");
			sb.append('\n');
		}
		
		System.out.println(sb);

	}

}
