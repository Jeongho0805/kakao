package InternShip_2021._01;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] a = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] b = {"0","1","2","3","4","5","6","7","8","9"};

        // for문 사용하여 String s 전체 대체
        for(int i=0; i<a.length; i++){
            s = s.replace(a[i],b[i]);
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}