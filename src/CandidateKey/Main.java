package CandidateKey;

// 난이도 : lv2
// 문제 이름 : 후보키
// 풀이 출처 : https://girawhale.tistory.com/102

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        Solution s = new Solution();
        int result = s.solution(relation);
        System.out.println(result);

    }
}


class Solution {
    List<Integer> key = new ArrayList<>();

    boolean ckMinimality(int i) {
        for (int k : key)
            if ((k & i) == k) return false;
        return true;
    }

    public int solution(String[][] relation) {

        // n은 row 수, m은 칼럼 속성 수
        int n = relation.length, m = relation[0].length;

        /**
         *  의문점 : 조건을 만족시키는 key가 등장했는데 나중에 기존의 key보다 최소성을 만족시키는 key가 등장하는 경우는?
         *  해답 : 비트마스크 구조상 차례대로 증가하기 때문에 먼저 발견되 key보다 최소성을 만족시킬 수 있는 나중의 key는 존재하지 않는다.
         */
        // 비트 마스크 활용 -> 칼럼 갯수가 4일 경우 k는 1~15범위
        for (int k = 1; k < (1 << m); k++) {
            if (!ckMinimality(k)) continue;

            // key마다 중복 값 파악하기 위한 set 생성
            Set<String> set = new HashSet<>();

            // 1키 기준으로 모든 열에 값 중복 없는지 파악
            for (int i = 0; i < n; i++) {
                StringBuilder key = new StringBuilder();

                for (int j = 0; j < m; j++) {
                    if (((1 << j) & k) > 0) key.append(relation[i][j]).append('/');
                }

                // 중복 값 있을 시 add 메서드에서 false 반환 -> 반복문 종료-> 다음 key 검토
                if (!set.add(key.toString())) break;
            }

            // 모든 row 검토 완료 하면 검증된 key 배열에 넣기
            if (set.size() == n) key.add(k);
        }
        return key.size();
    }
}
