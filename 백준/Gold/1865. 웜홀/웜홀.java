import java.util.stream.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

import java.util.*;
import java.io.*;


public class Main {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-->0){
             int[] input = stream(br.readLine().split(" "))
                      .mapToInt(Integer::parseInt).toArray();
             n = input[0];
             int m = input[1], w= input[2];

            graph = new ArrayList<>();
            IntStream.rangeClosed(0,n).forEach(e->graph.add(new ArrayList<>()));

            for(int i=0;i<m+w;i++){
                 input = stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt).toArray();
                if(i<m){
                    graph.get(input[0]).add(new Node(input[1],input[2]));
                    graph.get(input[1]).add(new Node(input[0],input[2]));
                }else
                    graph.get(input[0]).add(new Node(input[1],-1*input[2]));
            }//end input

            if(bellmanford())
                System.out.println("YES");
            else
                System.out.println("NO");

        }

    }

    private static boolean bellmanford(){

        int[] distance = new int[n+1]; // distance 배열 0으로 초기화

        boolean update =false;

        for(int i=1; i<=n; i++){ // 수행횟수 : n-1(다익스트라) +1(최종확인) = n번
            update =false;
            for(int cur=1; cur<=n; cur++){  

                for (Node next : graph.get(cur)) {
                    if(distance[next.node] > distance[cur]+next.weight){
                        distance[next.node] = distance[cur]+next.weight;
                        update = true; 
                    }
                }
            }
            if(!update) // 음의 사이클이 없는 경우
                break;
        }
        return update;
    }

    static class Node{
        int node,weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}