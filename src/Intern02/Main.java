//package Intern02;
//
//import java.util.LinkedList;
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        int[] queue1 = {3,2,7,2};
//        int[] queue2 = {4,6,5,1};
//        Solution s = new Solution();
//        int result = s.solution(queue1, queue2);
//
//
//    }
//}
//
//class Solution {
//
//    int start1;
//    int start2;
//    int min;
//
//    public int solution(int[] queue1, int[] queue2) {
//        int answer = -2;
//
//        // 시작점 기준으로 재방문 방지
//
//        // queue에 입력 및 toal 구하기
//        int total =  0;
//
//        ArrayList<Integer> q1 = new ArrayList<>();
//        ArrayList<Integer> q2 = new ArrayList<>();
//
//        for(int i=0; i<queue1.length; i++){
//            total += queue1[i];
//            q1.add(queue1[i]);
//        }
//        for(int i=0; i<queue2.length; i++){
//            total += queue2[i];
//            q2.add(queue2[i]);
//        }
//        // total 홀수 일 경우 불가능 -1 리턴
//        if(total%2!=0){
//            return -1;
//        }
//
//        // 시작점 지정
//        start1 = q1.get(0);
//        start2 = q2.get(0);
//        int cnt = 0;
//        min = Integer.MIN_VALUE;
//
//        dfs(q1, q2, cnt);
//
//        System.out.println(min);
//
//
//
//        return answer;
//    }
//
//    public void dfs(ArrayList<Integer> q1, ArrayList<Integer> q2, int cnt){
//        // 탈출 조건
//
//        int total1 = 0;
//        int total2 = 0;
//        for(int i=0; i<q1.size(); i++){
//            total1+=q1.get(i);
//        }
//        for(int i=0; i<q2.size(); i++){
//            total2+=q2.get(i);
//        }
//
//        if(total1 == total2 && min<cnt){
//            System.out.println(cnt);
//            min = cnt;
//            return;
//
//        }
//
////        for(int i=0; i<2; i++){
//        if(!q1.isEmpty()){
//            if(q1.get(0) != start2) {
//                q2.add(q1.remove(0));
//                int cnt1 = cnt+1;
//                dfs(q1, q2, cnt1);
//                q1.add(q2.remove(0));
//            }
//        }
//
//        if(!q2.isEmpty()){
//            if(q2.get(0) != start1){
//                q1.add(q2.remove(0));
//                int cnt2 = cnt+1;
//                dfs(q1, q2, cnt2);
//                q2.add(q1.remove(0));1
//            }
//        }
//    }
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////class Solution {
//
////    int min;
////    boolean[] check1;
////    boolean[] check2;
////    ArrayList<Integer> q11;
////    ArrayList<Integer> q22;
////
////    public int solution(int[] queue1, int[] queue2) {
////        int answer = -1;
////
////        int total = 0;
////        //방문여부체크
////
////
////        // queue에 입력 및 toal 구하기
////        ArrayList<Integer> q1 = new ArrayList<>();
////        q11 = new ArrayList<>();
////        ArrayList<Integer> q2 = new ArrayList<>();
////        q22 = new ArrayList<>();
////
////        for(int i=0; i<queue1.length; i++){
////            total += queue1[i];
////            q1.add(queue1[i]);
////            q11.add(queue1[i]);
////        }
////        for(int i=0; i<queue2.length; i++){
////            total += queue2[i];
////            q2.add(queue2[i]);
////            q22.add(queue2[i]);
////        }
////        check1 = new boolean[q1.size()];
////        check2 = new boolean[q2.size()];
////        // total 홀수 일 경우 불가능 -1 리턴
////        if(total%2!=0){
////            return -1;
////        }
////
////        // map check 배열 확인
//////        for(Integer key : map1.keySet()){
//////            System.out.println(key + ":" + map1.get(key));
//////        }
////
////
////        // queue 입력 디버깅 체크
//////        while(!q1.isEmpty()){
//////            System.out.println(q1.poll());
//////        }
//////        while(!q2.isEmpty()){
//////            System.out.println(q2.poll());
//////        }
////
////
////        min = Integer.MIN_VALUE;
////        int cnt = 0;
////        dfs(q1, q2, cnt);
////
////        System.out.println(cnt);
////
////
////
////
////        return answer;
////    }
////
////    public void dfs(ArrayList<Integer> q1, ArrayList<Integer> q2, int cnt){
////        // 탈출 조건
////        int total1 = 0;
////        int total2 = 0;
////        for(int i=0; i<q1.size(); i++){
////            total1+=q1.get(i);
////        }
////        for(int i=0; i<q2.size(); i++){
////            total2+=q2.get(i);
////        }
////
////        if(total1 == total2 && min<cnt){
////            min = cnt;
////            return;
////        }
////
////        // q1, q2 각각 pop, add 과정
////        for(int i=0; i<2; i++){
////            if(i==0 && !q2.isEmpty() && !check2[q22.indexOf(q2.get(0))]){
////                check2[q22.indexOf(q2.get(0))] = true;
////                q1.add(q2.remove(0));
////                cnt++;
////
////                dfs(q1,q2,cnt);
////            }
////            if(i==1 && !q1.isEmpty() && !check1[q11.indexOf(q1.get(0))]) {
////                check1[q11.indexOf(q1.get(0))] = true;
////                q2.add(q1.remove(0));
////                cnt++;
////                dfs(q1,q2,cnt);
////            }
////        }
////
////
////    }
////
////
////}
