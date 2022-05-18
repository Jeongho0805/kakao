package ColorBook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};

        for(int i=0; i<picture.length; i++){
            System.out.println(Arrays.toString(picture[i]));
        }


        Solution s = new Solution();
        int[] result = s.solution(m,n,picture);
        System.out.println(Arrays.toString(result));

    }
}

class Solution {

    // 상하좌우 컨트롤러
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] check;
    int[][] map;
    int m = 0;
    int n = 0;
    int cnt;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        this.m = m;
        this.n = n;

        // 방문 여부 체크 boolean 2차 배열 생성
        check = new boolean[m][n];
        // dfs 쓰기 위한 객체 변수, 매게변수 매핑
        map = picture;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0;
                if (map[i][j] != 0 && !check[i][j]) {
//                    System.out.println(i+":"+j);
                    dfs(i, j);
                    int max = cnt;
                    System.out.println(cnt);
//                    System.out.println(i+":"+j+":"+max);
                    numberOfArea++;
                    if (max > maxSizeOfOneArea) {
                        maxSizeOfOneArea = max;
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }


    //  bfs 알고리즘 짤 때 값 넣기전에 방문 처리 꼭해주기! 차후에 하면 서로 겹쳐서 중복 카운트 된다.
    int bfs(int a, int b, int cnt) {

        Node node = new Node(a, b);
        Queue<Node> q = new LinkedList<Node>();
        check[a][b] = true; // 방문체크
        q.add(node);

        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            int x = currentNode.getX();
            int y = currentNode.getY();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                if (map[x][y] == map[nx][ny] && !check[nx][ny]) {
//                    System.out.println(nx+":"+ny);
                    check[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
        return cnt;
    }

    class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

    // dfs 안되는 이유는? cnt 값이 반영안되는 이유
    // dfs 알고리즘은 먼저 시행된 것이 제일 나중에 끝난다. cnt를 카운트 하게 될 경우,
    // 종료를 가장 늦게 하는 것이 가장 처음에 시작 된 점이기 때문에 cnt가 1로 return 하게 된다.
    // 따라서 횟수 카운팅할때 매게변수로 주는게 아니라 전역변수로 밖에다 설정해두고 cnt를 카운팅 해야한다.
    void dfs(int a, int b) {
        // 방문체크
        check[a][b] = true;
        // 영역 갯수 증가
        cnt++;


        // 상하좌우 체크 및 dfs 재귀 작업
        for (int i = 0; i < 4; i++) {
            int nx = a + dx[i];
            int ny = b + dy[i];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }
            if (map[a][b] == map[nx][ny] && !check[nx][ny]) {
//                System.out.println(nx+":"+ny);
                dfs(nx, ny);

            }
        }
        System.out.println(a+":"+b+"="+cnt);


    }
}

