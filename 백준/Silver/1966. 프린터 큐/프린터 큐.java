import java.util.*;
import java.io.*;

public class Main {
   static class Document{
       int imp;
       int n;
       public Document(int imp,int n){
           this.imp = imp;
           this.n=n;
       }

   }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        List<Document> list = new ArrayList<>();
        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            int M =  Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine().trim());
            for(int i=0;i<N;i++){
                list.add(new Document(Integer.parseInt(st.nextToken()),i));
            }
            int idx=0;
            while(!list.isEmpty()){
                Document first=list.get(0);
                boolean isMax=true;
                for(Document d:list){
                    if(d.imp > first.imp){
                        isMax=false;
                        break;
                    }
                }
                if(isMax){
                    idx++;
                    if(first.n == M){
                        break;
                    }
                }else{
                    list.add(first);
                }
                list.remove(0);

            }
            sb.append(idx).append('\n');
            list.clear();



        }
        System.out.println(sb);


    }

}