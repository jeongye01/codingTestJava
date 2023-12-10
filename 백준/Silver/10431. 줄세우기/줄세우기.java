import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// ans : 위의 방법을 마지막 학생까지 시행하여 줄서기가 끝났을 때 학생들이 총 몇 번 뒤로 물러서게 될까?
public class Main {
   
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
		int P = Integer.parseInt(st.nextToken());

		for(int p=1;p<=P;p++) {
			int cnt=0;
			st = new StringTokenizer(br.readLine().trim());
			st.nextToken();
			int[] arr = new int[20];
			for(int i=0;i<20;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=1;i<20;i++) {
				int taller=0;
				for(int j=i-1;j>=0;j--) {
					if(arr[j]>arr[i])taller++;
				}
				cnt+=taller;
			}
			sb.append(p).append(' ').append(cnt).append('\n');
		}
		System.out.println(sb);

	}

}
