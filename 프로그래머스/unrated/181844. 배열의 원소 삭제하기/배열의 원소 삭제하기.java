import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] dl=new int[1001];
        for(int i=0;i<delete_list.length;i++){
            dl[delete_list[i]]++;
        }
        List<Integer> tmp=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(dl[arr[i]]==0){
                tmp.add(arr[i]);
            }
        }
        int[] answer = new int[tmp.size()];
         for(int i=0;i<tmp.size();i++){
           answer[i]=tmp.get(i);
        }
        return answer;
    }
}