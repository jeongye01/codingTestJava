public class MSTKruskalTest{
  static class Edge implements Comparable<Edge>{
    int from,to,weight;
    public Edge(int from,int to,int weight){
        super();
      this.from=from;
      this.to=to;
      this.weight=weight;
    }
    @override
    public int compareTo(Edge o){
      return Integer.compare(this.weight,o.weight);
    }
  }
  static Edge[] edgeList;
  static int V,E;
  static int[] parents;
  static void make(){
    parents=new int[V];
    for(int i=0;i<V;i++){
      parents[i]=i;
    }
  }
  static int find(int a){
    if(parents[a]==a){
      return a;
    }
    return parents[a]=find(parents[a]);
  }
  static boolean union(int a,int b){
    int aRoot=find(a);
    int bRoot=find(b);
    if(aRoot==bRoot){
      return false; //사이클 발생
    }
    parents[bRoot]=aRoot;
    return true;
  }
  public static void main(String[] args){
      BufferedReader in = new BufferedReader(new InputStreamReader(Sysem.in));
      StringTokenizer st=new StringTokenizer(in.readLine()," ");
      V=Integer.parseInt(st.nextToken());
      E=Integer.parseInt(st.nextToken());
      edgeList=new Edge[E];
      for(int i=0;i<E;i++){
        st=new StringTokenizer(in.readLine()," ");
        int from=Integer.parseIt(st.nextToken());
        int to=Integer.parseInt(st.nextToken());
        int weight=Integer.parseInt(st.nextToken());
        edgeList[i]=new Edge(from,to,weight);
        
        
      }
      // 간선리스트를 가중치 기준 오름차순 정렬
      Arrays.sort(edgeList);
      //V개의 정점으로 make set 작업
      make();
      int result=0; //MST 비용
      int count=0;  //연결된 간선 개수 
      for(Edge e : edgeList){
         if(union(edge.from,edge.to)){
           result+=edge.weight;
           if(++count==V-1){
             break;
           }
         }
      }
      
    
  }
}
