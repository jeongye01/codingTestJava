


import java.io.*;
import java.util.*;

public class Main {
	
    static int N,M;
    static int[] parent;
    
    static class Edge implements Comparable<Edge>{
    	int a;
    	int b;
    	int cost;
    	public Edge(int a,int b,int cost) {
    		this.a = a;
    		this.b = b;
    		this.cost = cost;
    	}
    	public int compareTo(Edge o) {
    		return this.cost-o.cost;
    	}
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());	
		M = Integer.parseInt(st.nextToken());	
		List<Edge> edges = new ArrayList<>();
	    parent =new int[N+1];
	    for(int i=0;i<M;i++) {
	    	st = new StringTokenizer(br.readLine().trim());
	    	edges.add(new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
	    }
	    Collections.sort(edges);
	    for(int i=0;i<=N;i++) {
	    	parent[i]=i;
	    }
	    int ans =0;
	    int bigCost =0; 
	    for(Edge e : edges) {
	    	int pa=find(e.a);
	    	int pb=find(e.b);
	    	if(pa!=pb) {
	    		union(e.a,e.b,pa,pb);
	    		ans+=e.cost;
	    		bigCost=e.cost;
	    	}
	    }
	    System.out.println(ans-bigCost);
		
		
		
	}
	private static int find(int x) {
		if(parent[x]==x)return x;
		return parent[x]=find(parent[x]);
		
	}
	private static void union(int a,int b,int pa,int pb) {

		if(pa>pb) {
			parent[pa]= pb;
		}else parent[pb] = pa;
	}


}
