package Primary_SecretMap;

// 런타임 에러 발생 -> 간단 명료하게 코드 구현 변경
// 비트 연산자 | 참고

// 비트 앞에 0 채워주는 과정 2가지
// 1. String temp = "0" + temp 를 필요한 자릿 수 만큼 반복 -> 해당 방법 활용
// 2. String.format 메서드 사용

// String 배열 생성 후 += 이런 식으로 값을 넣으면 안에 null 존재! 처음엔 대입해야 함

public class Main {

    public static void main(String[] args) {

        Solution s = new Solution();
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] result = s.solution(n, arr1, arr2);
        for(int i=0; i<5; i++){
            System.out.println(result[i]);
        }
    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        // 비트연산자 합한 map 배열 생성
        int[] map = new int[n];
        for(int i=0; i<n; i++){
            map[i] = arr1[i]|arr2[i];
        }

        // map을 반복문 돌려 길이 모자란 부분 0 채우고 결과값 replace하여 answer에 추가
        for(int i=0; i<n; i++){
            String temp = Integer.toBinaryString(map[i]);

            // 공백 0 추가 작업
            if(temp.length()<n){
                int cha = n-temp.length();
                for(int j=0; j<cha; j++){
                    temp = "0"+temp;
                }
            }

            temp = temp.replaceAll("0"," ");
            temp = temp.replaceAll("1","#");
            answer[i] = temp;

        }
        return answer;
    }
}
