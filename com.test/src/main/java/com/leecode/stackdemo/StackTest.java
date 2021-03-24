package com.leecode.stackdemo;

import org.junit.Test;

import java.util.*;

/*
 * 主要是针对栈的测试用例
 * */
public class StackTest {
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2235 👎 0

    @Test
    public void test01() {
        //()[]{}{[]}
        String str = "()[]{}{[({})]}";
        if (str.contains("()") || str.contains("[]") || str.contains("{}")) {
            str = str.replace("()", "");
            str = str.replace("[]", "");
            str = str.replace("{}", "");
        }
        //System.out.println("==过滤后的="+str+"=");
        //定义一个栈
        //循环 字符串  将  字符串元素 按顺序放到栈中,如果栈顶元素和 字符串元素相同, 则 出栈, 字符串 顺延一个
        ArrayList<String> stack = new ArrayList<>();

        stack.add("-1");
        //
        for (int i = 0; i < str.length(); i++) {
            char element = str.charAt(i);
            //获取栈顶元素
            String popElement = stack.get(stack.size() - 1);
            System.err.println("==i==" + i + "=pop=" + popElement + "==e=" + element);
            if ((element + "").equals(")") && (popElement + "").equals("(")
                    || (element + "").equals("]") && (popElement + "").equals("[")
                    || (element + "").equals("}") && (popElement + "").equals("{")) {

                stack.remove(stack.size() - 1);
            } else {

                stack.add(element + "");
            }

        }
        stack.stream().forEach(System.out::print);
        System.out.println();
        //System.out.println("===栈中元素="+stack.toArray().toString());
        if (stack.size() == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }


    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();


        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }


    @Test
    public void test02() {
        boolean valid = isValid("()[]{}{[({}})]}");
        System.out.println(valid);
    }

    /*输入：s = "leEeetcode"
    输出："leetcode"
    解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。*/
    @Test
    public void test03() {
        //String s = "leEeetcode";
        String s = "abBAcC";
        int n = s.length();
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char element = s.charAt(i);
            System.out.println("===e===" + element + "===s==" + stack.peek());
            if ((stack.peek() + "").equals((element + "").toUpperCase()) || (stack.peek() + "").toUpperCase().equals((element + ""))) {
                stack.pop();
            } else {
                stack.push(element);
            }
        }

        System.out.println(stack);
    }

    public String makeGood(String s) {
        StringBuffer ret = new StringBuffer();
        int retIndex = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ret.length() > 0 && Character.toLowerCase(ret.charAt(retIndex)) == Character.toLowerCase(ch) && ret.charAt(retIndex) != ch) {
                ret.deleteCharAt(retIndex);
                retIndex--;
            } else {
                ret.append(ch);
                retIndex++;
            }
        }
        return ret.toString();
    }

    /*
    给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

    注意：如果对空文本输入退格字符，文本继续为空。

   输入：S = "ab#c", T = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。
     */
    @Test
    public void test04() {
        String S = "a##c";
        String T = "#a#c";
        dealStr(S);
        dealStr(T);

    }

    public String dealStr(String str) {
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < str.length(); i++) {
            char element = str.charAt(i);
            System.out.println(element);
            if ((element + "").equals("#")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {
                stack.push(element);
            }
        }
        System.out.println("===str===" + str + "===stack===" + stack);
        return stack.toString();
    }
}
