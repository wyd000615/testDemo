package com.leecode;

import org.junit.Test;

public class OneQuestionPerDay {
    /*
    * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
    * */
    @Test
    public void test1() {
     /*   输入：00000000000000000000000000001011
        输出：3
        解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/number-of-1-bits
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
        int n =00000000000000000000000000001011;
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        System.out.println(ret);


    }


}
