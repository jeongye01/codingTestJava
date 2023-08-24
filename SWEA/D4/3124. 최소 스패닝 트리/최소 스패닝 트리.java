import java.io.*;
import java.util.*;

// prim
// priority queue와 edgelist edge(v,w)타입
//정점과 간선이 크므로 edgelist로 풀어아야함
//가중치 값이 1,000,000이 누적되면 int 범위 넘으므로, result를 long 타입

public class Solution{
	// 간선과 정점
	static int V,E;
	
	// pq와 edgelist에 넣을 값. (v,w) 
	static class Edge implements Comparable<Edge>{
		int v, w;

		Edge(int e, int v) {
			this.v = e;
			this.w = v;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}
    public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		
		int t=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			st=new StringTokenizer(br.readLine()," ");
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			boolean[] visited= new boolean[V];
			
			List<Edge>[] edgeList = new ArrayList[V];
			
			for(int i=0;i<V;i++) {
				edgeList[i] = new ArrayList<Edge>();
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				int weight=Integer.parseInt(st.nextToken());
				
				// edgeList 출발idx에 목적idx와 가중치
				edgeList[from].add(new Edge(to,weight));
				edgeList[to].add(new Edge(from,weight));
			}
			
			//pq 선언. (v,w)로 넣어주고  w에 따라 정렬
			PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
			
			// 가중치 더하다보면 int 넘어가므로 long
			long result=0;
			int cnt=0;
			//임의의 출발지.
			visited[0]=true;
			
			// 0과 연결된 간선들 pq에 넣어주기
			for(Edge e : edgeList[0]) {
				pq.add(e);
			}
			// pq에 가중치가 작은 간선들부터 탐색
			while(!pq.isEmpty()){
				Edge cur=pq.poll();
				
				if(visited[cur.v]) continue;
				// 가중치 더해주기
				result+=cur.w;  
				
				// 방문처리
				visited[cur.v]=true;
				
				//v-1 일때 완성
				if(cnt++ == V-1) break; 
				
				for(Edge e:edgeList[cur.v]) {
					// 방문한 정점 continue
					if(visited[e.v]) continue;
					// 방문 안했다면 pq넣어주기
					pq.add(e);
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}

        System.out.println(sb);
        br.close();
    }
}