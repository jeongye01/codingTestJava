import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		int aN = Integer.parseInt(st.nextToken());
		int aM = Integer.parseInt(st.nextToken());
		int[][] aArr = new int[aN][aM];
		for(int i=0;i<aN;i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0;j<aM;j++) {
				aArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine().trim());
		int bN = Integer.parseInt(st.nextToken());
		int bM = Integer.parseInt(st.nextToken());
		int[][] bArr = new int[bN][bM];
		for(int i=0;i<bN;i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0;j<bM;j++) {
				bArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<aN;i++) {
			for(int j=0;j<bM;j++) {
				int tmp=0;
				for(int k=0;k<bN;k++) {
					tmp+=(aArr[i][k]*bArr[k][j]);
				}
				
				
				sb.append(tmp).append(' ');
			}
			sb.append('\n');
		}
		
	

		System.out.println(sb);

	}

}