import org.junit.Test;

import java.util.*;

public class test01 {
    @Test
    public void test(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        String s = list.get(0);

        System.out.println(s);
        System.out.println(list.toArray());
        System.out.println(list.toArray().toString());
        System.out.println(list.toString());
    }
    @Test
    public void test1(){
       Set set = new HashSet();
       set.add("9");
       set.add("2");
       set.add("2");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            String next = (String) iterator.next();
            System.out.println("===next==="+next);
            String[] split = next.split(",");

        }


        boolean contains = set.contains("2");
        System.out.println("bo"+contains);
        System.out.println("==="+set.size());
        System.out.println(set.toArray());
        System.out.println(set.toString());
    }
    @Test
    public void test2(){
     Map map = new HashMap<String,String>();
     map.put("1","1");
     map.put("2","2");
     map.get("2");
    }
    @Test
    public void test3(){
       String str ="123";
       str = str.substring(0,str.length()-1);
        System.out.println(str);
        String str1 ="1234";
        str1 = str1.substring(2);
        System.out.println(str1);
    }
    @Test
    public void test4() {
        String str ="{" +
                "    \"data\":{" +
                "        \"status\":true," +
                "        \"message\":\"success\"" +
                "    }" +
                "}";
        System.out.println(str);
    }
    @Test
    public void test5() {
        String status="true";
        String str ="{" +
                "    \"data\":{" +
                "\"status\":\""+status+"\","+
                "        \"message\":\"success\"" +
                "    }" +
                "}";
        System.out.println(str);
    }
}
