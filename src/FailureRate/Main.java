package FailureRate;

/**
 * 방법
 * 1. 클래스 객체 활용
 * 2. 배열 2개 생성 후 이전 배열과 이후 배열 값 비교하여 인덱스 추가
 * 3.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int N = 5;
        int[] result = s.solution(N, stages);
        System.out.println(Arrays.toString(result));
    }
}



class Solution {

    class Info{

        int stage;
        double rate;

        // 생성자를 통한 객체 입력
        public Info(int stage, double rate){
            this.stage = stage;
            this.rate = rate;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        // 인덱스(stage), 값(인원) 배열 생성
        int[] temp = new int[N+2];

        // 배열에 인원 정보 입력
        for(int stage: stages){
            temp[stage]++;
        }

        // stage 정보와 실패율을 객체로 담을 수 있는 arrayList 생성
        ArrayList<Info> arr = new ArrayList<>();

        // 전체인원에서 빼야 될 수 minus 생성
        int minus = 0;

        for(int i=1; i<=N; i++){
            int total = stages.length-minus;
//            System.out.println(total);
            double rate = 0;
            if(total!=0){
                rate = (double)temp[i]/total;
            }

            minus += temp[i];

            // stage 정보 i와 실패율 객체를 arr에 저장
            arr.add(new Info(i,rate));
        }

        for(int i=0; i<arr.size(); i++) {
            System.out.println(arr.get(i).rate);
        }



        // 실패율에 따른 내림차순 정렬
        Collections.sort(arr, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.rate<o2.rate){
                    return 1;
                }

//              같은 경우도 조건으로 명시해줘야 됨.
                else if(o1.rate==o2.rate){
                    return 0;
                }
                else{
                    return -1;
                }
            }
        });

        for(int i=0; i<N; i++){
            answer[i] = arr.get(i).stage;
        }

//        for(int i=0; i<N; i++){
//            System.out.println(arr.get(i).rate);
//        }

        return answer;
    }
}

