package Intern01;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};

        Solution s = new Solution();
        String result = s.solution(survey, choices);

    }
}
class Solution {

    HashMap<Character, Integer> map;

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        // HashMap 생성 점수 기록
        map = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);

        int length = survey.length;

        for(int i=0; i<length; i++){
            Character order1 = survey[i].charAt(0);
            Character order2 = survey[i].charAt(1);

            calc(order1, order2, choices[i]);
        }

        // 입력 확인 디버그
//        for(Character key : map.keySet()){
//            System.out.println(key+ ":"+map.get(key));
//
//        }

        answer += kind('R','T');
        answer += kind('C','F');
        answer += kind('J','M');
        answer += kind('A','N');

        // 답 디버깅
//        System.out.println(answer);


        return answer;
    }

    public void calc(Character order1, Character order2, int value){

        if(value==1){
            map.put(order1, map.get(order1)+3);
        }
        if(value==2){
            map.put(order1, map.get(order1)+2);
        }
        if(value==3){
            map.put(order1, map.get(order1)+1);
        }
        if(value==5){
            map.put(order2, map.get(order2)+1);
        }
        if(value==6){
            map.put(order2, map.get(order2)+2);
        }
        if(value==7){
            map.put(order2, map.get(order2)+3);
        }

    }

    public char kind(Character sort1, Character sort2){
        char[] temp = {sort1, sort2};
        Arrays.sort(temp);
        if(map.get(sort1)>map.get(sort2)){
            return sort1;
        }
        else if(map.get(sort1)==map.get(sort2)){
            return temp[0];
        }
        else{
            return sort2;
        }

    }
}