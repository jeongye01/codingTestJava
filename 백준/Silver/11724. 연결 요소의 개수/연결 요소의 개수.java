import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
    static boolean[] visited;
    static List<List<Integer>> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	    StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	    visited = new boolean[N];
	    list = new ArrayList<>();
	    for(int i=0;i<N;i++) {
	    	list.add(new ArrayList<>());
	    }
	    for(int i=0;i<M;i++) {
	    	st = new StringTokenizer(br.readLine().trim());
	    	int u=Integer.parseInt(st.nextToken())-1;
	    	int v=Integer.parseInt(st.nextToken())-1;
	    	list.get(u).add(v);
	    	list.get(v).add(u);
	    }
	    int ans=0;
	    for(int i=0;i<N;i++) {
	    	if(!visited[i]) {
	    		bfs(i);
	    		ans++;
	    	}
	    }
	    System.out.println(ans);
	}
	private static void bfs(int i) {
		visited[i]=true;
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(Integer node : list.get(now)) {
				if(!visited[node]) {
					visited[node]=true;
					q.add(node);
				}
			}
		}
	}

}
