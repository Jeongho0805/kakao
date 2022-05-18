package News_Clustering;

import java.util.*;
import java.util.regex.Pattern;

// 출처 : https://programmers.co.kr/learn/courses/30/lessons/17677?language=java
// 문제 이름 : 뉴스 클러스터링

public class Main {

    public static void main(String[] args) {

        String str1 = "FRANCE";
        String str2 = "french";

        Solution s = new Solution();
        int result = s.solution(str1,str2);

        System.out.println(result);

    }
}
class Solution {
    public int solution(String str1, String str2) {

        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();

        String pattern = "^[a-zA-Z]*$";

        /**
         *  프로그래머스 Pattern.matches 적용이 안됨 이유는?
         */

        for(int i=0; i<str1.length()-1; i++){
            String temp = ""+str1.charAt(i)+str1.charAt(i+1);
            if(Pattern.matches(pattern, temp)){
                arr1.add(temp);
            }
        }

        for(int i=0; i<str2.length()-1; i++){
            String temp = ""+str2.charAt(i)+str2.charAt(i+1);
            if(temp.matches(pattern)){
                arr2.add(temp);
            }
        }

        // 공집합 예외처리
        int size1 = arr1.size();
        int size2 = arr2.size();
        if(size1==0 && size2==0){
            return 65536;
        }

        int total = size1+size2;
        int interCnt = 0;

        // 교집합 갯수 구하기
        for(int i=0; i<size1; i++){
            for(int j=0; j<size2; j++){
                if(arr1.get(i).equalsIgnoreCase(arr2.get(j))){
                    arr2.set(j, "0");
                    interCnt++;
                    break;
                }
            }
        }

        int unionCnt = total-interCnt;

        double rate = (double) interCnt/unionCnt;
        int answer = (int)Math.floor(rate*65536);

        return answer;
    }
}
