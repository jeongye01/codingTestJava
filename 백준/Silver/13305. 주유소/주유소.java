import java.io.*;
import java.util.*;
// ans : 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력
public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		long ans=0;
		long[] dist=new long[N-1];
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<N-1;i++) {
			dist[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		long minOil=arr[0];
		for(int i=0;i<N-1;i++) {
			ans+=dist[i]*minOil;
			if(arr[i+1]<minOil) {
				minOil=arr[i+1];
			}
		}
		System.out.println(ans);
		
		
	}

}
