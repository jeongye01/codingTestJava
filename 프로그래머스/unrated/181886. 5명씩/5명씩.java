import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> answer = new ArrayList<>();
        for(int i=0;i<names.length;i+=5){
            answer.add(names[i]);
        }
        String[] answer2=new String[answer.size()];
        for(int i=0;i<answer.size();i++){
            answer2[i]=answer.get(i);
        }
        return answer2;
    }
}