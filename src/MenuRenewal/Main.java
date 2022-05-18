package MenuRenewal;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        Solution s = new Solution();
        String[] result = s.solution(orders, course);
        System.out.println(Arrays.toString(result));

    }
}

class Solution {

    HashMap<String, Integer> map = new HashMap<>();


    public String[] solution(String[] orders, int[] course) {

        // 문자열 정렬, 추가에 용이한 정답 관련 ArrayList 생성
        ArrayList<String> answerList = new ArrayList<>();

        // combination 작업에 용이하기 위한 정렬 작업 수행
        for(int i=0; i<orders.length; i++){
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = String.valueOf(temp);
        }


        // 길이, 문자별 combination 메서드 실행
        for(int length: course){
            for(String order: orders){
                combination("", order, length);

            }

            if(!map.isEmpty()){
                // map.value의 max 값을 찾기 위한 ArrayList 추가 생성
                ArrayList<Integer> arr = new ArrayList<>(map.values());
                int max = Collections.max(arr);
                if(max>1){
                    for(String key: map.keySet()){
                        if(map.get(key)==max){
                            answerList.add(key);
                        }
                    }

                }

            }
            map.clear();
        }

        Collections.sort(answerList);

        String[] answer = new String[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);

        }

        return answer;
    }

    void combination(String order, String other, int cnt){

        if(cnt==0){
            map.put(order, map.getOrDefault(order, 0)+1);
            return;
        }

        for(int i=0; i<other.length(); i++){
            combination(order+other.charAt(i), other.substring(i+1), cnt-1);
        }
    }
}
