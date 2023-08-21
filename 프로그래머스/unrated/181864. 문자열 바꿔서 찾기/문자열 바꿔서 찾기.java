class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<myString.length();i++){
            char c=myString.charAt(i);
            if(c=='A'){
                 sb.append('B');
            }else if(c=='B'){
                sb.append('A');
            }else{
                sb.append(c);
            }
           
        }
        return sb.toString().contains(pat)?1:0;
    }
}