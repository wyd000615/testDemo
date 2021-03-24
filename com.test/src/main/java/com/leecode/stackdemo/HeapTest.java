package com.leecode.stackdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 堆
* */
public class HeapTest {

    /*
    输入整数数组 arr ，找出其中最小的 k 个数。
    例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
    输入：arr = [3,2,1], k = 2
    输出：[1,2] 或者 [2,1]
     */
    @Test
    public void test01() {
        int[] arr=new int[]{3,2,1};
        int k =2;
        int[] leastNumbers = getLeastNumbers(arr, k);
        List list = Arrays.asList(leastNumbers);
        System.out.println(list.size());
        list.stream().forEach(System.out::print);
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }


}
