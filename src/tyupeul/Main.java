package tyupeul;

import java.util.*;

/**
 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/64065
 * 문제 이름 : 튜플
 */

public class Main {

    public static void main(String[] args) {

        String a = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        Solution s = new Solution();
        int[] result = s.solution(a);
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] solution(String s) {

        ArrayList<Integer> result = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(s,"{},");
        HashMap<String, Integer> map = new HashMap<>();
        while(st.hasMoreTokens()){
            String key = st.nextToken();
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        ArrayList<Integer> arr = new ArrayList<>(map.values());
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i=0; i<map.size(); i++){
            for(String key : map.keySet()){
                if(map.get(key)==arr.get(i)){
                    result.add(Integer.parseInt(key));
                }
            }
        }

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}
