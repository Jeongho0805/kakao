package Intern04;

public class Main {


    public static void main(String[] args) {

        int n = 6;
        int[][] path = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gate = {1,3};
        int[] summit = {5};


        Solution s = new Solution();
        int[] result = s.solution(n, path, gate, summit);


    }
}

class Solution {

    int[][] map;
    boolean[] check;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};

        // 정보 저장 2차원 배열 생성

        map = new int[50001][50001];
        check = new boolean[50001];

        for(int i=0; i<n; i++){
            int temp1 = 0;
            int temp2 = 0;
            int temp3 = 0;
            for(int j=0; j<2; j++) {
                if(j==0){
                    temp1 = paths[i][j];
                }
                else if(j==1){
                    temp2 = paths[i][j];
                }
                else {
                    temp3 = paths[i][j];
                }
            }
            map[temp1][temp2]=map[temp2][temp1]=temp3;
        }




        return answer;
    }
}
