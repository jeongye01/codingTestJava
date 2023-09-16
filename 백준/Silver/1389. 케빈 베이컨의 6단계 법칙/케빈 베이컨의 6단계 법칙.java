import java.util.*;
import java.io.*;

public class Main {
	static String s;
    static int N,M;
    static int ans,ansn;
    static boolean[] visited;
    static int[] cnts;
    static List<List<Integer>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		visited=new boolean[N];
		cnts=new int[N];
		graph= new ArrayList<>();
		ans=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine().trim());
			int A=Integer.parseInt(st.nextToken())-1;
			int B=Integer.parseInt(st.nextToken())-1;
			graph.get(A).add(B);
			graph.get(B).add(A);
			
		}
		
		for(int i=0;i<N;i++) {
			bfs(i);
		}

		System.out.println(ansn);
	}
    public static void bfs(int st) {
    	Queue<int[]> q= new LinkedList<>();
    	q.offer(new int[] {st,0} );
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int fn=now[0],depth=now[1];
  
    		for(int f: graph.get(fn)) {
    			if(!visited[f]) {
    			   visited[f]=true;
    			   cnts[f]=depth+1;
    			   q.offer(new int[] {f,depth+1});
    			}
    		}
    		
    		
    	}
    	int tmp=0;
    	for(int i=0;i<N;i++) {
    		tmp+=cnts[i];
    	}
    	if(ans> tmp) {
    		ansn=(st+1);
    		ans=tmp;
    	}
     	Arrays.fill(visited,false);
    	Arrays.fill(cnts,0);
    }

}
