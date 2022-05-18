package OpenChatRoom;

// 난이도 : lv2
// 문제 이름 : 오픈채팅방
// HashMap사용

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Solution s = new Solution();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
                "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        s.solution(record);


    }
}

class Solution {
    public String[] solution(String[] record) {

        // 명령어 Change 제외하고 나머지 다 출력되어야 함
        int orderCnt = 0;
        for(int i=0; i<record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            if(!st.nextToken().equals("Change")){
                orderCnt++;
            }
        }

        String[] answer = new String[orderCnt];

        // key를 id, value를 닉네임으로 하는 hashMap 생성 및 입력
        HashMap<String,String> map = new HashMap<>();
        for(int i=0; i< record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String order = st.nextToken();
            if(order.equals("Enter")){
                String id = st.nextToken();
                String name = st.nextToken();
                map.put(id,name);
            }
            else if(order.equals("Leave")){
                String id = st.nextToken();
            }
            else{
                String id = st.nextToken();
                String name = st.nextToken();
                map.put(id, name);
            }
        }

        // answer 배열에 map을 통하여 값 추가
        int idx=0;
        for(int i=0; i< record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String order = st.nextToken();
            if(order.equals("Enter")){
                String id = st.nextToken();
                answer[idx]=map.get(id)+"님이 들어왔습니다.";
                idx++;
            }
            else if(order.equals("Leave")){
                String id = st.nextToken();
                answer[idx]=map.get(id)+"님이 나갔습니다.";
                idx++;
            }
            else{
                continue;
            }
        }

        return answer;
    }
}
