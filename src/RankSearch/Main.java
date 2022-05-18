//package RankSearch;
//
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
//        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
//        Solution s = new Solution();
//        int[] result = s.solution(info, query);
//    }
//}
//
//class Solution {
//    public int[] solution(String[] info, String[] query) {
//        int[] answer = new int[query.length];
//
//        int n = info.length;
//        // 이차원 배열에 정보 입력
//        String[][] arr = new String[n][5];
//        for(int i=0; i<n; i++){
//            StringTokenizer st = new StringTokenizer(info[i]);
//            for(int j=0; j<5; j++){
//                arr[i][j] = st.nextToken();
//            }
//        }
//
//        // query문 이차원 배열로 변환
//        String[][] match = new String[n][5];
//        for(int i=0; i<n; i++){
//            StringTokenizer st = new StringTokenizer(query[i]);
//            for(int j=0; j<5; j++){
//                match[i][j] = st.nextToken();
//                if(j<3){
//                    st.nextToken();
//                }
//            }
//        }
//
//        /**
//         * 입력 확인
//         */
////        for(int i=0; i<n; i++){
////            for(int j=0; j<5; j++){
////                System.out.print(arr[i][j]+" ");
////            }
////            System.out.println();
////        }
//
//        // 이차원 배열 간 검증
//
//
//        for(int i=0; i<n; i++){
//            int cnt = 0;
//            for(int j=0; j<n; j++){
//                boolean flag = true;
//                for(int k=0; k<5; k++){
//                    if(match[i][k].equals("-")){
//                        continue;
//                    }
//                    if(!match[i][k].equals(arr[j][k])){
//                        if(k<4){
//                            flag = false;
//                        }
//                        else{
//                            if(Integer.parseInt(match[i][k])>Integer.parseInt(arr[j][k])){
//                                flag = false;
//                            }
//                        }
//                    }
//
//
//
//                }
//                if(flag){
//                    cnt++;
//                }
//
//            }
//            answer[i] = cnt;
//
//        }
//
//        System.out.println(Arrays.toString(answer));
//
//
//        return answer;
//    }
//}
