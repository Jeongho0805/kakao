package InternShip_2021._02;

// 출처 : https://moonsbeen.tistory.com/297

import java.util.*;

class Solution {

    // 이동 리모콘
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public int[] solution(String[][] places) {
        // 배열로 입력받는데 1차원 배열에 2차원 배열 정보가 들어있음.
        // 정답 형식 배열 생성
        int[] result = new int[places.length];

        // isCorrect 메서드를 통해 바로 정답을 배열로 입력받음.
        for(int i = 0; i < places.length; i++){
            result[i] = isCorrext(places[i]);
        }
        return result;
    }

    // 2차원 String에서 1행에 관환 정보를 매게변수를 받음
    // 1행에 2차원 정보가 내포
    public int isCorrext(String[] board) {
        // 행에 해당하는 열의 갯수를 기준으로 나눈다.
        for(int i = 0; i < board.length; i++){
            // 각 행과 열에 해당하는 5글자로 이루어진 String을 charAt기능을 활용하여 split한다.
            for(int j = 0; j < board[i].length(); j++){
                // 참석자를 의미하는 'P'인 경우에만 BFS알고리즘 탐색 수행
                if(board[i].charAt(j) == 'P') {
                    // 정상일 경우 1 반환, 아닐 경우 0 반환
                    if(!bfs(board, i, j)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public boolean bfs(String[] board, int x, int y) {

        // BFS탐색을 위해 Queue 생성
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board.length];
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int manhattan = Math.abs(x - nx) + Math.abs(y - ny);

                // 해당 nx, ny가 map 범위를 넘어서면 다음 nx ny 탐색
                if(nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) continue;
                // 해당 nx. ny를 방문한 적이 있거나 뉴클리드 거리가 2이상일 경우, 그 장소에 사람이 있어도 상관없으므로 다음 nx,ny 탐색
                if(visited[nx][ny] || manhattan > 2) continue;


                visited[nx][ny] = true;

                // nx ny과 빈 테이블일 경우에만 BFS 탐색 수행
                if(board[nx].charAt(ny) == 'X') continue;
                else if(board[nx].charAt(ny) == 'P') return false;
                else q.offer(new Node(nx, ny));
            }
        }
        return true;
    }

    public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
