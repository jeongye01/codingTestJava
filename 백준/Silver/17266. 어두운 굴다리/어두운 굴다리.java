import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 단 가로등은 모두 높이가 같아야 하고, 정수이다.
// 가로등의 높이가 H라면 왼쪽으로 H, 오른쪽으로 H만큼 주위를 비춘다.
// ans : 굴다리의 길이 N을 모두 비추기 위한 가로등의 최소 높이
public class Main {
	static int N,M;
	static int[] arr;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		arr = new int[M];
		st = new StringTokenizer(br.readLine().trim());
		
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int s=arr[0]-0;
		int e=N-arr[M-1];
		int max=0;
		for(int i=0;i<M-1;i++) {
			int half = (int)Math.ceil((double)(arr[i+1]-arr[i])/2);
			max=Math.max(half,max);
		}
		//System.out.println(e+" "+s+" "+max);
		max=Math.max(max, e);
		max=Math.max(max, s);
		System.out.println(max);

	}

}