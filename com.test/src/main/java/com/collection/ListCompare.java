package com.collection;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ListCompare {
    /**
     * 方法2：利用List的 retainAll的方法进行判断
     */

    static boolean checkDiffrent1(List<String> list, List<String> list1) {
        long st = System.nanoTime();
        System.out.println("消耗时间为：" + (System.nanoTime() - st));
        return !list.retainAll(list1);
    }

    @Test
    public void test() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("V0003");
        list1.add("V0013");
        list1.add("V0213");
        list1.add("V0015");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("V0004");
        list2.add("V0014");
        list2.add("V0213");
        list2.add("V0015");

        long st = System.nanoTime();
        System.out.println("消耗时间为： " + (System.nanoTime() - st));
        list1.sort(Comparator.comparing(String::hashCode));
        list2.sort(Comparator.comparing(String::hashCode));
        System.out.println(list1.toString().equals(list2.toString()));
    }

    @Test
    public void test2() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        //for (int i = 0; i < 1000; i++) {
        list1.add("V0003");


        list2.add("V0003");
        list2.add("V0002");


        //  }
        System.out.println(checkDiffrent1(list1, list2));
    }


    /**
     * list
     * 去重
     */
    @Test
    public void test3() {
        List<String> instList = new ArrayList<>();
        //for (int i = 0; i < 1000; i++) {
        instList.add("IOT00001");
        instList.add("IOT00001");
        instList.add("IOT00002");
        System.out.println("list去重之前" + instList);

        instList = instList.stream().distinct().collect(Collectors.toList());
        System.out.println("list去重之后" + instList);
        ArrayList<String> instList2 = new ArrayList<>();
        //for (int i = 0; i < 1000; i++) {
        instList2.add("IOT00001");
        instList2.add("IOT00001");
        instList2.add("IOT00002");
        System.out.println("list2去重之前" + instList2);

        instList2 = (ArrayList<String>) instList2.stream().distinct().collect(Collectors.toList());
        System.out.println("list2去重之后" + instList2);


    }

    /**
     * map的keyset转list
     */
    @Test
    public void test4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("5", "E");
        List<String> keylist = new ArrayList<>(map.keySet());
        for (String key : keylist) {
            System.out.println(key);

        }
    }
    /**
     * arr的keyset转list
     */
    @Test
    public void test5() {
        String MVNO_PRODUCT ="6,7";
        String[] mvnoProductArr = MVNO_PRODUCT.split(",");
        List<String> list = Arrays.asList(mvnoProductArr);  //此集合无法操作添加元素
        List<String> list1 = new ArrayList<String>(list); //此集合可操作元素
        System.out.println(list1);
        if(list.contains("6")){
            System.out.println("22222");
        }
        System.out.println(list.toString());
    }
    /**
     * arr的keyset转list
     */
    @Test
    public void test6() {
        HashSet<String> prodPackageTypeSet = new HashSet<String>();
        prodPackageTypeSet.add("6");
        prodPackageTypeSet.add("6");
        prodPackageTypeSet.add("6");
        prodPackageTypeSet.add("7");
        prodPackageTypeSet.add("7");
        System.out.println(prodPackageTypeSet.toString());
        for (String  prodPackageType:prodPackageTypeSet) {
            System.out.println(prodPackageType);
        }
    }
}