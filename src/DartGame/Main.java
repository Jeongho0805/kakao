package DartGame;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String dartResult = "10D4S10D";
        Solution s = new Solution();
        int result = s.solution(dartResult);
        System.out.println(result);
    }
}

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        // 3라운드 진행 -> 크기 3 배열에 점수 만 넣기
        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(dartResult, "SDT*#");

        for(int i=0; i<3; i++){
            arr[i]  = Integer.parseInt(st.nextToken());
        }

        System.out.println(Arrays.toString(arr)); // 입력 완료 디버깅

        // 현재 계산 순서를 알려주는 idx 설정
        int idx = 0;

        for(int i=0; i<dartResult.length(); i++){
            char ch = dartResult.charAt(i);
//            System.out.println(ch);
            if(ch=='S'){}
            else if(ch=='D'){
                arr[idx] = arr[idx]*arr[idx];
            }
            else if(ch=='T'){
                arr[idx] = arr[idx]*arr[idx]*arr[idx];
            }
            else if(ch=='*'){
                arr[idx] = arr[idx]*2;
                if(idx!=0){
                    arr[idx-1] = arr[idx-1]*2;
                }
            }
            else if(ch=='#'){
                arr[idx] = arr[idx]*-1;
            }
            // 숫자 일 경우 idx 증가
            else{
                if(i>1) {
                    if (dartResult.charAt(i + 1) == '0') {
                        idx++;
                        i++;
                    } else {
                        idx++;
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(arr));

        for(int i=0; i<3; i++){
            answer+=arr[i];
        }

        return answer;


    }
}