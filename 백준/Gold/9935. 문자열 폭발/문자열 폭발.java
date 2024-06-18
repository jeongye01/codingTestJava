import java.util.*;
import java.io.*;
//  문제를 잘못 이해했다 ..
public class Main {
    static class Char {
        int index;
        char c;
        int cursor;
        public Char(int index,char c,int cursor){
            this.index = index;
            this.c =c;
            this.cursor = cursor;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Char> stk = new Stack<>();
        char[] chs1 = br.readLine().trim().toCharArray();
        char[] chs2 = br.readLine().trim().toCharArray();

        int cursor=0;

        for(int i=0;i<chs1.length;i++){

            if(cursor>0 && chs2[cursor-1]==stk.peek().c && chs1[i]==chs2[cursor]){

                stk.add(new Char(i,chs1[i],cursor));
                cursor+=1;
            }else if(chs2[0]==chs1[i]){
                stk.add(new Char(i,chs1[i],0));
                cursor=1;
            }else{
              while(!stk.isEmpty()){
                  stk.pop();
              }
              cursor=0;
            }

            if(cursor == chs2.length){
                for(int cur=0;cur<cursor;cur++){
                    chs1[stk.pop().index] = '.';
                }
                if(stk.isEmpty()){
                    cursor=0;
                }else{
                    cursor=stk.peek().cursor+1;
                }


            }



        }




        StringBuilder sb = new StringBuilder();

       for(char c:chs1){
           if(c!='.')sb.append(c);
       }
    // System.out.println(Arrays.toString(chs1));

        System.out.println(sb.toString().length()==0?"FRULA":sb);


    }



}