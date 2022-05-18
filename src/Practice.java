import java.util.*;
import java.util.regex.Pattern;

public class Practice {

    public static void main(String[] args) {

//        String[] a = {"123","asdf","12"};
//        Arrays.sort(a, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if(o1.length()>o2.length()){
//                    return 1;
//                }
//                else{
//                    return -1;
//                }
//            }
//        });
//
//        System.out.println(Arrays.toString(a));

//        double rate = (double)1/7;
//        System.out.println(rate);

//        int a = 11;
//        byte b = (byte) a;
//        String c = Integer.toBinaryString(a);
//        System.out.println(c);

//        int[] arr1 = {9, 20, 28, 18, 11};
//        int[] arr2 = {30, 1, 21, 17, 28};
//
//        for(int i=0; i<5; i++){
//            String b = String.format("%05d", Integer.parseInt(Integer.toBinaryString(arr1[i]).toString()));
//            String b = String.format("%05d", Integer.parseInt(Integer.toBinaryString(arr1[i])));
//            System.out.println(b);
//        }

        // 비트 연산자 계산 과정
//        int a = 13;
//        int b = 8;
//        String c = Integer.toBinaryString(a|b);
//        int d = a|b;
//        System.out.println(c);
//        System.out.println(d);

        // 생성 후 바로 값 += 으로 넣으면 null 값 그대로 있음
//        String[] arr = new String[2];
//        arr[0] += "12";
//        System.out.println(arr[0]);

        // replace와 replaceAll 차이 (정규식 부분)
        // 해당 과정에선 똑같음
//        String ex1 = "aaaaaaaaa";
//        String ex2 = "aaaaaaaaa";
//        ex1 = ex1.replace("a","b");
//        ex2 = ex2.replaceAll("a","b");
//        System.out.println(ex1);
//        System.out.println(ex2);

        // 숫자만 공백으로 변환하고 싶다면?
        // replace는 1부터 9까지 replace. 을 붙여가며 다써줘야 하지만
        // replaceAll은 정규표현식을 통해 손쉽게 처리 가능
//        String ex3 ="29493asjdjf8283";
//        String ex4 ="29493asjdjf8283";
//        ex3 = ex3.replace("1","").replace("2","");
//        ex4 = ex4.replaceAll("[1-9]","");
//        System.out.println(ex3);
//        System.out.println(ex4);


//        ArrayList<Integer> arr = new ArrayList<>();
//
//        int temp = 5;
//        int temp2 = temp*-1;
//        System.out.println(temp2);

//        int a = 3;
//        ArrayList<String> arr = new ArrayList<>();
//        String b = a+"입니다.";
//        arr.add(b);
//        a = 5;
//        String c = arr.get(0);
//        System.out.println(c);
//        // b보다 a바뀐게 뒤에 있기 때문에 반영이 안된다.


        // String.valueOf() 함수
//        char[] c ={'a','b','c'};
//        String a = String.valueOf(c);
//        System.out.println(a);

        // HashMap values 사용법
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("asdf",1);
//        map.put("bdsf",2);
//        ArrayList<Integer> arr = new ArrayList<>(map.values());
//        for(int i=0; i<arr.size(); i++){
//            System.out.println(arr.get(i));
//        }


        /**
         * String과 char합 가능
         */
//        String a = "ABCD";
//        char b = 'E';
//        String add = a+b;
//        System.out.println(add);

        /**
         * 빈 문자열 체크 시 isEmpty 메서드 사용 가능, But, null일 경우 불가
         */

//        String a = "";
//        System.out.println(a.isEmpty());
//        String b = null;
//        System.out.println(b.isEmpty());


        /**
         *  Set 활용
         */

//        HashSet<String> set1 = new HashSet<>();
//        HashSet<String> set2 = new HashSet<>();
//
//        String str1 = "aa1+aa2";
//        String str2 = "AAAA12";
//        String pattern = "^[a-zA-Z]*$";
//
//        for(int i=0; i<str1.length()-1; i++){
//            String temp = ""+str1.charAt(i)+str1.charAt(i+1);
//            if(Pattern.matches(pattern, temp)){
//                set1.add(temp);
//            }
//        }
//        for(int i=0; i<str2.length()-1; i++){
//            String temp = ""+str2.charAt(i)+str2.charAt(i+1);
//            if(Pattern.matches(pattern, temp)) {
//                set2.add(temp);
//            }
//        }
//
//        System.out.println(set1);
//        System.out.println(set2);

//        HashSet<String> result = new HashSet<>(set1);
//        HashSet<String> result2 = new HashSet<>(set1);
//        result.retainAll(set2);
//        System.out.println(result);
//        result2.addAll(set2);
//        System.out.println(result2);

        /**
         *  정규 표현식을 활용하여 문자열 검증
         *  Pattern.matches(정규식, 검증 문자) 메서드 활용
         */

//        String pattern = "^[a-zA-Z]*$";
//        String alpha = "abc";
//        String nonAlpha = "123";
//        if(Pattern.matches(pattern, alpha))
//            System.out.println("영어로만 구성되어있습니다.");
//        if(!Pattern.matches(pattern,nonAlpha))
//            System.out.println("영어로만 구성되어있지 않습니다.");


        /**
         *  합집합 교집합 중복 반영 ArrayList 활용하여 구하기
         */

//        ArrayList<String> arr1 = new ArrayList<>();
//        ArrayList<String> arr2 = new ArrayList<>();
//
//        String str1 = "E=M*C^2";
//        String str2 = "e=m*c^2";
//        String pattern = "^[a-zA-Z]*$";
//
//        for(int i=0; i<str1.length()-1; i++){
//            String temp = ""+str1.charAt(i)+str1.charAt(i+1);
//            if(Pattern.matches(pattern, temp)){
//                arr1.add(temp);
//            }
//        }
//        for(int i=0; i<str2.length()-1; i++){
//            String temp = ""+str2.charAt(i)+str2.charAt(i+1);
//            if(Pattern.matches(pattern, temp)) {
//                arr2.add(temp);
//            }
//        }
//
//
//        int total = arr1.size()+arr2.size();
//        int interCnt = 0;
//
//        for(int i=0; i<arr1.size(); i++){
//            for(int j=0; j<arr2.size(); j++){
//                if(arr1.get(i).equalsIgnoreCase(arr2.get(j))){
//                    arr2.set(j, "0");
//                    interCnt++;
//                    break;
//                }
//            }
//        }
//
//        int unionCnt = total-interCnt;
//
//        double rate = (double)interCnt/unionCnt;
//        int result = (int)Math.floor(rate*65536);
//        System.out.println(result);

        /**
         *  StringTokenizer, split 메서드 비교
         */

//        String temp = "123+23-14584*34234+4342";
//        StringTokenizer st1 = new StringTokenizer(temp,"*,+,-");
//        ArrayList<Integer> num = new ArrayList<>();
//
//        while(st1.hasMoreTokens()){
//            num.add(Integer.parseInt(st1.nextToken()));
//        }
//
//        StringTokenizer st2 = new StringTokenizer(temp, "1,2,3,4,5,6,7,8,9");
//        ArrayList<Character> order = new ArrayList<>();
//        while(st2.hasMoreTokens()){
//            order.add(st2.nextToken().charAt(0));
//        }
//
//        for(int i=0; i<order.size(); i++){
//            System.out.println(order.get(i));
//        }
//
//        String rule = "*+-";

        /**
         * st.nextToken 범위 넘어선 부분 출력 시 예외 터짐
         */
//        String a = "12 34 56";
//        StringTokenizer st = new StringTokenizer(a);
//        for(int i=0; i<5; i++){
//
//            System.out.println(st.nextToken());
//        }

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);

        System.out.println(arr.indexOf(2));


    }
}
