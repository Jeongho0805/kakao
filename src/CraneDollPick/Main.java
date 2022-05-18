package CraneDollPick;

// Stack 활용하면 더 쉽게 풀 수 있는 문제

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 인형 담을 바구니
        ArrayList<Integer> basket = new ArrayList<>();

        int length = board.length;

        for(int move: moves){
            for(int i=0; i<length; i++){
                if(board[i][move-1]!=0){
                    int temp = board[i][move-1];
                    board[i][move-1] = 0;
                    basket.add(temp);
                    break;
                }
            }
        }


        int size = basket.size();

        // 없어지는 현상 갯수 설정
        for(int i=0; i<basket.size(); i++){
            System.out.print(basket.get(i));
        }
        System.out.println();


        int cnt = 0;
        for(int j=0; j<size; j++) {
            for (int i = 0; i < basket.size() - 1; i++) {
                if (basket.get(i) == basket.get(i+1)) {
                    basket.remove(i);
                    basket.remove(i);
                    cnt++;
                    break;
                }
            }
        }

        for(int i=0; i<basket.size(); i++){
            System.out.print(basket.get(i));
        }
        System.out.println();
        System.out.println(cnt);
        answer = cnt*2;

        return answer;

    }
}

public  class Main{

    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(s.solution(board, moves));
    }
}

