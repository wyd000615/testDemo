package com.nange;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    /**
     * @param args
     */
    public static void main(String[] args) {

        // 测试是否为合法的身份证号码
        String[] strs = { "130681198712092019", "13068119871209201x","13068119871209201", "123456789012345",
                "12345678901234x",
                "1234567890123" };
        Pattern p1 = Pattern.compile("(\\d{17}[0-9a-zA-Z]|\\d{14}[0-9a-zA-Z])");
        for (int i = 0; i < strs.length; i++) {
            Matcher matcher = p1.matcher(strs[i]);
            System.out.println(strs[i] + ":" + matcher.matches());
        }
        Pattern p2 = Pattern.compile("\\d{6}(\\d{8}).*"); // ⽤于提取出⽣⽇字符串
        Pattern p3 = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})");// ⽤于将⽣⽇字符串进⾏分解为年⽉⽇
        for (int i = 0; i < strs.length; i++) {
            Matcher matcher = p2.matcher(strs[i]);
            boolean b = matcher.find();
            if (b) {
                String s = matcher.group(1);
                Matcher matcher2 = p3.matcher(s);
                if (matcher2.find()) {
                    System.out
                            .println("⽣⽇为" + matcher2.group(1) + "年"
                                    + matcher2.group(2) + "⽉"
                                    + matcher2.group(3) + "⽇");
                }
            }
        }
    }
}