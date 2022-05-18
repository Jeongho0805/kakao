package Bracket_Transformation;

// 출처 : https://programmers.co.kr/learn/courses/30/lessons/60058?language=java
// 문제 이름 : 괄호변환

import java.util.*;

public class Main {

    public static void main(String[] args) {

    }
}

class Solution {

    // u,v 구분할 수 있는 pos 선언
    int pos;

    public String solution(String p) {

        String answer = "";

        // 1. 빈 문자열인 경우 빈 문자열 반환
        if(p.isEmpty()){
            return p;
        }

        // 2. u,v로 구분 메서드
        boolean result = isCorrect(p);
        String u = p.substring(0,pos);
        String v = p.substring(pos,p.length());

        // 3. u가 올바른 괄호 문자열 일 경우
        if(result){
            return u+solution(v);
        }

        // 4. u가 올바르 괄호 문자열이 아닌 경우
        answer = "("+solution(v)+")";
        for(int i=1; i<u.length()-1; i++){
            if(u.charAt(i)=='('){
                answer+=")";
            }
            else{
                answer+="(";
            }
        }


        return answer;
    }

    // 옳바른 문자열 여부 파악 및 pos 정보 제공 메서드
    boolean isCorrect(String p){

        boolean result = true;
        int left = 0;
        int right = 0;

        Stack<Character> st = new Stack<>();

        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='('){
                left++;
                st.push('(');
            }
            else{
                right++;
                if(st.empty()){
                    result = false;
                }
                else{
                    st.pop();
                }

            }

            if(left==right){
                // u,v 구분점
                pos = i+1;
                return result;
            }
        }

        // ),( 갯수가 항상 같기 때문에 해당 명령어가 수행될 순 없다. 형식상 넣기
        return result;

    }
}