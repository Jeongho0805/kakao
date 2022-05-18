package Maximiza;


// 출처 : https://programmers.co.kr/learn/courses/30/lessons/67257
// 문제 이름 : 수식 최대화

import java.util.Arrays;
import java.util.LinkedList;

public class Main {



    public static void main(String[] args) {

        String expression = "100-200*300-500+20";
        Solution s = new Solution();
        long result = s.solution(expression);
//        System.out.println(result);
    }
}

class Solution {

    LinkedList<Character> list;

    public long solution(String expression) {
        long answer = 0;

        list = new LinkedList<>();
        list.add('*');
        list.add('+');
        list.add('-');

        dfs(new LinkedList<Character>(), new boolean[list.size()]);

        return answer;
    }

    public void dfs(LinkedList<Character> list2, boolean[] picked){

        if(list.size()==list2.size()){
            for(int i=0; i<list.size(); i++){
                System.out.print(list2.get(i));
            }
            System.out.println();
        }

        for(int i=0; i<list.size(); i++){

            if(!picked[i]){
                list2.add(list.get(i));
                picked[i] = true;
                dfs(list2, picked);

                picked[i] = false;
                list2.removeLast();

            }


        }

    }
}
