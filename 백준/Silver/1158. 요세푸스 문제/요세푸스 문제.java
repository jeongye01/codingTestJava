import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		List<Integer> list=new LinkedList<>();
		List<Integer> ans=new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			list.add(i);
		}
		
		int idx=K-1;
		while(list.size()>1) {
			ans.add(list.get(idx));
			list.remove(idx);
			idx=(idx+(K-1))%list.size();
		};
		System.out.print("<");
		for(int i=0;i<N-1;i++) {
			System.out.print(ans.get(i)+", ");
		}
		System.out.print(list.get(0)+">");
	}

}
