import java.util.*;

public class Practice02 {

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {


        /**
         *  조합 combination 단어 만들고 hashMap 활용하여 count 하기
         */

//        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int course = 2;
//        // 배열 별 사전 순으로 재정렬
//        for(int i=0; i<orders.length; i++){
//            char[] temp = orders[i].toCharArray();
//            Arrays.sort(temp);
//            orders[i] = new String(temp); // 1. 생성자 활용하여 char배열 String 변환, 2. String.valueOf(char[])을 활용한 방법
//
//        }
//
//        for(int i=0; i<orders.length; i++){
//            combination("", orders[i], course);
//        }
//
//        for(String key: map.keySet()){
//            System.out.println(key+":"+map.get(key));
//        }
//
//    }
//
//    static void combination(String order, String other, int cnt){
//        if(cnt==0){
//            map.put(order, map.getOrDefault(order,0)+1);
//            return;
//        }
//        // other이 문자열에서 끝지점일 경우 for문을 돌 수 없다. 고로 cnt가 0이 되지 않아 map에 들어가지 않는다.
//        for(int i=0; i<other.length(); i++){
//            combination(order+other.charAt(i), other.substring(i+1), cnt-1);
//        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put("as",2);
        map.put("gd",5);
        ArrayList<Integer> arr = new ArrayList<>(map.values());
        int max = Collections.max(arr);
        System.out.println(max);
        map.clear();

        String a = "abc";
        char[] b = a.toCharArray();

        Stack<Integer> stack = new Stack<>();
        stack.isEmpty();
        Queue<String> q = new LinkedList<>();

    }
}
