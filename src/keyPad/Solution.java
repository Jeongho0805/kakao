package keyPad;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        // 왼쪽 오르쪽 위치 지정
        int left = 10;
        int right = 12;

        // numbers 배열 마다 L, R 결과 출력
        for(int number: numbers){
            // 숫자가 0 일경우 예외처리
            if(number==0){
                number = 11;
            }
            if(number%3==1){
                answer+="L";
                left = number;
            }
            else if(number%3==0){
                answer+="R";
                right = number;
            }
            // 숫자가 가운데 있는 경우
            else{
                int leftDis = getDistance(left, number);
                int rightDis = getDistance(right, number);
                if(leftDis>rightDis){
                    answer+="R";
                    right = number;
                }
                else if(leftDis<rightDis){
                    answer+="L";
                    left = number;
                }
                else{
                    if(hand.equals("right")){
                        answer+="R";
                        right = number;
                    }
                    else{
                        answer+="L";
                        left = number;
                    }
                }
            }
        }


        return answer;
    }

    public int getDistance(int start, int end){
        int startRow = (start-1)/3;
        int startCol = (start-1)%3;
        int endRow = (end-1)/3;
        int endCol = (end-1)%3;

        int result = Math.abs(startRow-endRow)+Math.abs(startCol-endCol);
        return result;
    }
}
