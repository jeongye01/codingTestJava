import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

static int N,M;
	static int p1,p2;
	static int ans;
	static List<List<Integer>> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim());
		p1 = Integer.parseInt(st.nextToken())-1;
		p2 = Integer.parseInt(st.nextToken())-1;
		M = Integer.parseInt(br.readLine().trim());
		list = new ArrayList<>();
		for(int i=0;i<N;i++){
			list.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine().trim());
			int p=Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			list.get(p).add(c);
			list.get(c).add(p);
		}
		bfs();
		System.out.println(ans);


	}
	private static void bfs(){
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited= new boolean[N];
		visited[p1] =true;
		q.add(new int[] {p1,0} );
		while(!q.isEmpty()){
			int now[] = q.poll();
			int cur_node = now[0];
			int cnt =now[1];
			for(Integer node : list.get(cur_node)){
				if(visited[node])continue;
				if(node==p2){
					ans=cnt+1;
					return;
				}
				q.add(new int[]{node,cnt+1});
				visited[node]=true;
			}
		}




		ans=-1;
	}
}