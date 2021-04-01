package com.leecode;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

public class TestLee {
    ////////////////////////////////////////////////////////////////////////////////////
    public static int[] search(String string, String str) {
        if (str.length() > string.length()) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        int strCode = getCode(str, 0, str.length() - 1);
        int stringCode = getCode(string, 0, str.length() - 1);
        sign:
        for (int i = 0; i <= string.length() - str.length(); i++) {
            if (strCode == stringCode) {
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) != string.charAt(i + j)) {
                        continue sign;
                    }
                }
                list.add(i);
            }

            stringCode = stringCode ^ string.charAt(i) ^ string.charAt(i + str.length() - 1);
        }


        int[] result = new int[list.size()];

        IntStream.range(0, result.length).forEach(i -> {
            result[i] = list.get(i);
        });
        return result;
    }

    public static int getCode(String string, int beginIndex, int endIndex) {
        if (beginIndex > endIndex || beginIndex < 0 || endIndex >= string.length() || string.length() <= 0) {
            return 0;
        }

        int h = 0;

        for (int i = beginIndex; i <= endIndex; i++) {
            h ^= string.charAt(i);
        }
        //System.out.println("===h==="+h);
        return h;

    }

    @Test
    public void test250() {
        System.out.println(System.getProperty("file.separator"));
        System.out.println(System.getProperty("user.dir"));
    }

    //回行
    @Test
    public void test01() {
        String S = "babca";
        StringBuffer stack = new StringBuffer();

        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }


        System.out.println(stack.toString());
    }

    //二叉树的前序编列
    @Test
    public void test02() {
        String preorder = " 9,3,4,#,#,1,#,#,2,#,6,#,#";
        int n = preorder.length();
        String[] p = preorder.split(",");
        int i = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        while (i < n) {
// pp = p[i];
            System.out.println("当前处理的是 " + preorder.charAt(i));
            if (stack.isEmpty()) {
                System.out.println(false);
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                // System.out.println("当前处理的是 "+preorder.charAt(i));

                System.err.println("去掉栈顶元素=====此时栈 " + stack.toString());

                i++;
            } else {
                // System.out.println("当前处理的是 "+preorder.charAt(i));

                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);

                System.out.println("去掉栈顶元素======================此时栈 " + stack.toString());

            }
        }
        System.out.println(stack.isEmpty());
    }

    //螺旋矩阵
    @Test
    public void test03() {
        /*
            1  2  3
            4  5  6
            7  8  9
         */
        //int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}};//[[1,2,3],[4,5,6],[7,8,9]];
        int[][] matrix = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < matrix.length; i++) {
            //System.out.println(matrix[i][0]);
            System.out.println(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " [" + i + "," + j + "]   ");
            }

        }

     /*   //输出：[1,2,3,6,9,8,7,4,5]
        for (int i = 0; i < matrix.length; i++) {
            //System.out.println(matrix[i][0]);
            System.out.println(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                //System.out.print(matrix[i][j]+" ["+i+","+j+"]   ");
                //如果i 和j 相同, 将 j 不变, i --
            }
        }
        int m = 0;
        int n = -1;
        while (true) {


            if (n > 1) {
                m++;
                if (m > 2) {
                    n--;
                }
            } else {
                n++;
            }
            //输出
            System.out.print(matrix[m][n] + " [" + m + "," + n + "]   ");
        }
*/
    }

    //螺旋矩阵
    @Test
    public void test04() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}};//[[1,2,3],[4,5,6],[7,8,9]];

        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.err.println(order);// order;
        }
        int rows = matrix.length, columns = matrix[0].length;

        boolean[][] visited = new boolean[rows][columns];

        int total = rows * columns;


        int row = 0, column = 0;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            System.out.println("===2222222222=" + matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
            System.err.println("===r===" + row + "=====c===" + column);
        }
        System.out.println(order);// order;
    }

    //螺旋矩阵
    @Test
    public void test05() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}};//[[1,2,3],[4,5,6],[7,8,9]];
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println(order);// order;
        }

        int rows = matrix.length, columns = matrix[0].length;

        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {
            System.err.println("============================================================================");
            //从左边到右边
            for (int column = left; column <= right; column++) {
                System.err.println("===========================");

                order.add(matrix[top][column]);
                System.out.println("===1====" + "===t=" + top + "====c===" + column + "===" + matrix[top][column]);
            }
            //
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
            //System.out.println("l="+left+"==r=="+right+"==t=="+top+"===b=="+bottom);
        }
        System.out.println(order);// order;

    }

    //
    @Test
    public void test06() {
        String targetStr = "AAAA";
        String ruleStr = "AA";
        //start
        ArrayList<Object> stack = new ArrayList<>();
        for (int i = 0; i < targetStr.length(); i++) {
            char firstElement = targetStr.charAt(i);
            if (firstElement == ruleStr.charAt(0)) {
                if (i + 1 < targetStr.length()) {
                    char secondElement = targetStr.charAt(i + 1);
                    if (ruleStr.charAt(1) == secondElement) {
                        stack.add(i);
                    }
                }

            }
        }
        System.out.println(stack.toString());
    }

    public int Fib1(int index) {
        if (index < 1) {
            return -1;
        }
        if (index == 1 || index == 2) {
            return 1;
        }
        return Fib1(index - 1) + Fib1(index - 2);
    }

    @Test
    public void test07() {
        // Fib1(5);
        //test10(0);
        //int[] search = search("ABCABABCAB", "ABC");
        //System.out.println(Arrays.toString(search));
        System.out.println("===========================");
        long time1 = System.currentTimeMillis();
        ArrayList list = new ArrayList();
        test11(0, list);
        System.out.println(list);
        ArrayList list2 = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("AA")) {
                list2.add(i);
            }
        }
        System.out.println(list2);
        long time2 = System.currentTimeMillis();
        System.out.println("===递归实现===" + (time2 - time1));
    }

    @Test
    public void test08() {
        test09(5);
    }

    public int test09(int n) {
        if (n < 0) {
            return 0;
        }
        System.out.println("===" + n);
        return test09(n - 1);
    }

    public String test10(int n) {
        String targetStr = "ABCD";
        System.out.println("=1111=" + n);
        if (targetStr.length() <= n) {
            return "";
        }
        char aim1 = targetStr.charAt(n);
        char aim2 = 0;
        if (targetStr.length() > n + 1) {
            aim2 = targetStr.charAt(n + 1);
        }
        String aim = aim1 + "" + aim2;
        System.out.println(aim);
        return test10(n + 1);
        //+targetStr.charAt(n-1);
    }

    public String test13(int n) {
        //String targetStr="ABCD";
        String targetStr = "FAGEGEWRGAEGERSKGJIEWRHOUIQ3REGHFADJGFIUERHGIUAERFGASDKJFPQI3EHGFJPOADGAKLDNFAKNEJRHAEIRFNAJFNPEIRTIERTJAIPEROGJEAIRNRUEHGUAERIPNGFJAERNGEIPRUGHAUIGHAODNFLKADNFAKNGIERHTUERIQHTQIJGNQJRIGBNJDANFKAJDFIUQERBGQJKERGQIPREFNQPJIREGHQRUIEGBQURHTQURIPHTQUPIRNFGJQREIGNJANDGKAJHGUQIRGBNAJKLDGHUQIREBGQRHGQIREPNGQEKJRGNKQERNGFKAJGKALBFGKAERBIQUBERFQO3IRUHQIERPFNQEJIFBNALJDFBIUQEBRFAJKDSBFQIEHBFHJDSLBFJHASFUQEWBFHQGFUOQEHFHQEPGJIADBFALKDJBGQIUEUHFQJEIBFIWEHGQIBFADSGHQUIEFBQIWEBFUQIEWRHTUQIBGQIHGQUIETGHQUEBGQIHGQUEIHRQI3BFQIEWGHQUEIGHQUIHVUQIBNUQIERHUQEGNQUEIRGHQU3ITHQUEWBGQUIERHTQUEIRNQIERUTHQUITRBEWQUIJFBQIUWEGRUIQEBFQJIWEBFAKJDSBFQUIEGHRUQIOERGHOBQEJWIFNQJWEBGJBEGAKNDBGJQIEHFQIJENFAKJDFUHIQEGHU3IQRTPQHTPIEQRJNFAKJDGBAUFGHEQUIRGEQIRGHQEURIGHPQIJQWEPHFQJEWNFADKSGNQUIERHGQIREJGNIQERJGBNJKDFNAMDGBQIEROHTUIQP3RGFNIREQHQPERGFNKJDNFGAKLJDGBFNWQERQWEROUIQBEOFIJQ3BRUGBQERFJABNDKJSFBQNERFBQQWERQIOJEHFQJEFNALKWEUHRQLIUEFAGEGEWRGAEGERSKGJIEWRHOUIQ3REGHFADJGFIUERHGIUAERFGASDKJFPQI3EHGFJPOADGAKLDNFAKNEJRHAEIRFNAJFNPEIRTIERTJAIPEROGJEAIRNRUEHGUAERIPNGFJAERNGEIPRUGHAUIGHAODNFLKADNFAKNGIERHTUERIQHTQIJGNQJRIGBNJDANFKAJDFIUQERBGQJKERGQIPREFNQPJIREGHQRUIEGBQURHTQURIPHTQUPIRNFGJQREIGNJANDGKAJHGUQIRGBNAJKLDGHUQIREBGQRHGQIREPNGQEKJRGNKQERNGFKAJGKALBFGKAERBIQUBERFQO3IRUHQIERPFNQEJIFBNALJDFBIUQEBRFAJKDSBFQIEHBFHJDSLBFJHASFUQEWBFHQGFUOQEHFHQEPGJIADBFALKDJBGQIUEUHFQJEIBFIWEHGQIBFADSGHQUIEFBQIWEBFUQIEWRHTUQIBGQIHGQUIETGHQUEBGQIHGQUEIHRQI3BFQIEWGHQUEIGHQUIHVUQIBNUQIERHUQEGNQUEIRGHQU3ITHQUEWBGQUIERHTQUEIRNQIERUTHQUITRBEWQUIJFBQIUWEGRUIQEBFQJIWEBFAKJDSBFQUIEGHRUQIOERGHOBQEJWIFNQJWEBGJBEGAKNDBGJQIEHFQIJENFAKJDFUHIQEGHU3IQRTPQHTPIEQRJNFAKJDGBAUFGHEQUIRGEQIRGHQEURIGHPQIJQWEPHFQJEWNFADKSGNQUIERHGQIREJGNIQERJGBNJKDFNAMDGBQIEROHTUIQP3RGFNIREQHQPERGFNKJDNFGAKLJDGBFNWQERQWEROUIQBEOFIJQ3BRUGBQERFJABNDKJSFBQNERFBQQWERQIOJEHFQJEFNALKWEUHRQLIUEFAGEGEWRGAEGERSKGJIEWRHOUIQ3REGHFADJGFIUERHGIUAERFGASDKJFPQI3EHGFJPOADGAKLDNFAKNEJRHAEIRFNAJFNPEIRTIERTJAIPEROGJEAIRNRUEHGUAERIPNGFJAERNGEIPRUGHAUIGHAODNFLKADNFAKNGIERHTUERIQHTQIJGNQJRIGBNJDANFKAJDFIUQERBGQJKERGQIPREFNQPJIREGHQRUIEGBQURHTQURIPHTQUPIRNFGJQREIGNJANDGKAJHGUQIRGBNAJKLDGHUQIREBGQRHGQIREPNGQEKJRGNKQERNGFKAJGKALBFGKAERBIQUBERFQO3IRUHQIERPFNQEJIFBNALJDFBIUQEBRFAJKDSBFQIEHBFHJDSLBFJHASFUQEWBFHQGFUOQEHFHQEPGJIADBFALKDJBGQIUEUHFQJEIBFIWEHGQIBFADSGHQUIEFBQIWEBFUQIEWRHTUQIBGQIHGQUIETGHQUEBGQIHGQUEIHRQI3BFQIEWGHQUEIGHQUIHVUQIBNUQIERHUQEGNQUEIRGHQU3ITHQUEWBGQUIERHTQUEIRNQIERUTHQUITRBEWQUIJFBQIUWEGRUIQEBFQJIWEBFAKJDSBFQUIEGHRUQIOERGHOBQEJWIFNQJWEBGJBEGAKNDBGJQIEHFQIJENFAKJDFUHIQEGHU3IQRTPQHTPIEQRJNFAKJDGBAUFGHEQUIRGEQIRGHQEURIGHPQIJQWEPHFQJEWNFADKSGNQUIERHGQIREJGNIQERJGBNJKDFNAMDGBQIEROHTUIQP3RGFNIREQHQPERGFNKJDNFGAKLJDGBFNWQERQWEROUIQBEOFIJQ3BRUGBQERFJABNDKJSFBQNERFBQQWERQIOJEHFQJEFNALKWEUHRQLIUEFAGEGEWRGAEGERSKGJIEWRHOUIQ3REGHFADJGFIUERHGIUAERFGASDKJFPQI3EHGFJPOADGAKLDNFAKNEJRHAEIRFNAJFNPEIRTIERTJAIPEROGJEAIRNRUEHGUAERIPNGFJAERNGEIPRUGHAUIGHAODNFLKADNFAKNGIERHTUERIQHTQIJGNQJRIGBNJDANFKAJDFIUQERBGQJKERGQIPREFNQPJIREGHQRUIEGBQURHTQURIPHTQUPIRNFGJQREIGNJANDGKAJHGUQIRGBNAJKLDGHUQIREBGQRHGQIREPNGQEKJRGNKQERNGFKAJGKALBFGKAERBIQUBERFQO3IRUHQIERPFNQEJIFBNALJDFBIUQEBRFAJKDSBFQIEHBFHJDSLBFJHASFUQEWBFHQGFUOQEHFHQEPGJIADBFALKDJBGQIUEUHFQJEIBFIWEHGQIBFADSGHQUIEFBQIWEBFUQIEWRHTUQIBGQIHGQUIETGHQUEBGQIHGQUEIHRQI3BFQIEWGHQUEIGHQUIHVUQIBNUQIERHUQEGNQUEIRGHQU3ITHQUEWBGQUIERHTQUEIRNQIERUTHQUITRBEWQUIJFBQIUWEGRUIQEBFQJIWEBFAKJDSBFQUIEGHRUQIOERGHOBQEJWIFNQJWEBGJBEGAKNDBGJQIEHFQIJENFAKJDFUHIQEGHU3IQRTPQHTPIEQRJNFAKJDGBAUFGHEQUIRGEQIRGHQEURIGHPQIJQWEPHFQJEWNFADKSGNQUIERHGQIREJGNIQERJGBNJKDFNAMDGBQIEROHTUIQP3RGFNIREQHQPERGFNKJDNFGAKLJDGBFNWQERQWEROUIQBEOFIJQ3BRUGBQERFJABNDKJSFBQNERFBQQWERQIOJEHFQJEFNALKWEUHRQLIUE";
        //System.out.println("=1111="+n);
        if (targetStr.length() <= n) {
            return "";
        }
        char aim1 = targetStr.charAt(n);
        char aim2 = 0;
        char aim3 = 0;
        if (targetStr.length() > n + 1) {
            aim2 = targetStr.charAt(n + 1);

        }
        if (targetStr.length() > n + 2) {
            aim3 = targetStr.charAt(n + 2);
        }

        String aim = aim1 + "" + aim2 + "" + aim3;
        //System.out.println(aim);
        return test13(n + 1);
        //+targetStr.charAt(n-1);
    }

    public String test14(int n, ArrayList list) {
        //String targetStr="ABCD";
        String targetStr = "FAGEGEWRGAEGERSKGJIEWRHOUIQ3REGHFADJGFIUERHGIUAERFGASDKJFPQI3EHGFJPOADGAKLDNFAKNEJRHAEIRFNAJFNPEIRTIERTJAIPEROGJEAIRNRUEHGUAERIPNGFJAERNGEIPRUGHAUIGHAODNFLKADNFAKNGIERHTUERIQHTQIJGNQJRIGBNJDANFKAJDFIUQERBGQJKERGQIPREFNQPJIREGHQRUIEGBQURHTQURIPHTQUPIRNFGJQREIGNJANDGKAJHGUQIRGBNAJKLDGHUQIREBGQRHGQIREPNGQEKJRGNKQERNGFKAJGKALBFGKAERBIQUBERFQO3IRUHQIERPFNQEJIFBNALJDFBIUQEBRFAJKDSBFQIEHBFHJDSLBFJHASFUQEWBFHQGFUOQEHFHQEPGJIADBFALKDJBGQIUEUHFQJEIBFIWEHGQIBFADSGHQUIEFBQIWEBFUQIEWRHTUQIBGQIHGQUIETGHQUEBGQIHGQUEIHRQI3BFQIEWGHQUEIGHQUIHVUQIBNUQIERHUQEGNQUEIRGHQU3ITHQUEWBGQUIERHTQUEIRNQIERUTHQUITRBEWQUIJFBQIUWEGRUIQEBFQJIWEBFAKJDSBFQUIEGHRUQIOERGHOBQEJWIFNQJWEBGJBEGAKNDBGJQIEHFQIJENFAKJDFUHIQEGHU3IQRTPQHTPIEQRJNFAKJDGBAUFGHEQUIRGEQIRGHQEURIGHPQIJQWEPHFQJEWNFADKSGNQUIERHGQIREJGNIQERJGBNJKDFNAMDGBQIEROHTUIQP3RGFNIREQHQPERGFNKJDNFGAKLJDGBFNWQERQWEROUIQBEOFIJQ3BRUGBQERFJABNDKJSFBQNERFBQQWERQIOJEHFQJEFNALKWEUHRQLIUEFAGEGEWRGAEGERSKGJIEWRHOUIQ3REGHFADJGFIUERHGIUAERFGASDKJFPQI3EHGFJPOADGAKLDNFAKNEJRHAEIRFNAJFNPEIRTIERTJAIPEROGJEAIRNRUEHGUAERIPNGFJAERNGEIPRUGHAUIGHAODNFLKADNFAKNGIERHTUERIQHTQIJGNQJRIGBNJDANFKAJDFIUQERBGQJKERGQIPREFNQPJIREGHQRUIEGBQURHTQURIPHTQUPIRNFGJQREIGNJANDGKAJHGUQIRGBNAJKLDGHUQIREBGQRHGQIREPNGQEKJRGNKQERNGFKAJGKALBFGKAERBIQUBERFQO3IRUHQIERPFNQEJIFBNALJDFBIUQEBRFAJKDSBFQIEHBFHJDSLBFJHASFUQEWBFHQGFUOQEHFHQEPGJIADBFALKDJBGQIUEUHFQJEIBFIWEHGQIBFADSGHQUIEFBQIWEBFUQIEWRHTUQIBGQIHGQUIETGHQUEBGQIHGQUEIHRQI3BFQIEWGHQUEIGHQUIHVUQIBNUQIERHUQEGNQUEIRGHQU3ITHQUEWBGQUIERHTQUEIRNQIERUTHQUITRBEWQUIJFBQIUWEGRUIQEBFQJIWEBFAKJDSBFQUIEGHRUQIOERGHOBQEJWIFNQJWEBGJBEGAKNDBGJQIEHFQIJENFAKJDFUHIQEGHU3IQRTPQHTPIEQRJNFAKJDGBAUFGHEQUIRGEQIRGHQEURIGHPQIJQWEPHFQJEWNFADKSGNQUIERHGQIREJGNIQERJGBNJKDFNAMDGBQIEROHTUIQP3RGFNIREQHQPERGFNKJDNFGAKLJDGBFNWQERQWEROUIQBEOFIJQ3BRUGBQERFJABNDKJSFBQNERFBQQWERQIOJEHFQJEFNALKWEUHRQLIUEFAGEGEWRGAEGERSKGJIEWRHOUIQ3REGHFADJGFIUERHGIUAERFGASDKJFPQI3EHGFJPOADGAKLDNFAKNEJRHAEIRFNAJFNPEIRTIERTJAIPEROGJEAIRNRUEHGUAERIPNGFJAERNGEIPRUGHAUIGHAODNFLKADNFAKNGIERHTUERIQHTQIJGNQJRIGBNJDANFKAJDFIUQERBGQJKERGQIPREFNQPJIREGHQRUIEGBQURHTQURIPHTQUPIRNFGJQREIGNJANDGKAJHGUQIRGBNAJKLDGHUQIREBGQRHGQIREPNGQEKJRGNKQERNGFKAJGKALBFGKAERBIQUBERFQO3IRUHQIERPFNQEJIFBNALJDFBIUQEBRFAJKDSBFQIEHBFHJDSLBFJHASFUQEWBFHQGFUOQEHFHQEPGJIADBFALKDJBGQIUEUHFQJEIBFIWEHGQIBFADSGHQUIEFBQIWEBFUQIEWRHTUQIBGQIHGQUIETGHQUEBGQIHGQUEIHRQI3BFQIEWGHQUEIGHQUIHVUQIBNUQIERHUQEGNQUEIRGHQU3ITHQUEWBGQUIERHTQUEIRNQIERUTHQUITRBEWQUIJFBQIUWEGRUIQEBFQJIWEBFAKJDSBFQUIEGHRUQIOERGHOBQEJWIFNQJWEBGJBEGAKNDBGJQIEHFQIJENFAKJDFUHIQEGHU3IQRTPQHTPIEQRJNFAKJDGBAUFGHEQUIRGEQIRGHQEURIGHPQIJQWEPHFQJEWNFADKSGNQUIERHGQIREJGNIQERJGBNJKDFNAMDGBQIEROHTUIQP3RGFNIREQHQPERGFNKJDNFGAKLJDGBFNWQERQWEROUIQBEOFIJQ3BRUGBQERFJABNDKJSFBQNERFBQQWERQIOJEHFQJEFNALKWEUHRQLIUEFAGEGEWRGAEGERSKGJIEWRHOUIQ3REGHFADJGFIUERHGIUAERFGASDKJFPQI3EHGFJPOADGAKLDNFAKNEJRHAEIRFNAJFNPEIRTIERTJAIPEROGJEAIRNRUEHGUAERIPNGFJAERNGEIPRUGHAUIGHAODNFLKADNFAKNGIERHTUERIQHTQIJGNQJRIGBNJDANFKAJDFIUQERBGQJKERGQIPREFNQPJIREGHQRUIEGBQURHTQURIPHTQUPIRNFGJQREIGNJANDGKAJHGUQIRGBNAJKLDGHUQIREBGQRHGQIREPNGQEKJRGNKQERNGFKAJGKALBFGKAERBIQUBERFQO3IRUHQIERPFNQEJIFBNALJDFBIUQEBRFAJKDSBFQIEHBFHJDSLBFJHASFUQEWBFHQGFUOQEHFHQEPGJIADBFALKDJBGQIUEUHFQJEIBFIWEHGQIBFADSGHQUIEFBQIWEBFUQIEWRHTUQIBGQIHGQUIETGHQUEBGQIHGQUEIHRQI3BFQIEWGHQUEIGHQUIHVUQIBNUQIERHUQEGNQUEIRGHQU3ITHQUEWBGQUIERHTQUEIRNQIERUTHQUITRBEWQUIJFBQIUWEGRUIQEBFQJIWEBFAKJDSBFQUIEGHRUQIOERGHOBQEJWIFNQJWEBGJBEGAKNDBGJQIEHFQIJENFAKJDFUHIQEGHU3IQRTPQHTPIEQRJNFAKJDGBAUFGHEQUIRGEQIRGHQEURIGHPQIJQWEPHFQJEWNFADKSGNQUIERHGQIREJGNIQERJGBNJKDFNAMDGBQIEROHTUIQP3RGFNIREQHQPERGFNKJDNFGAKLJDGBFNWQERQWEROUIQBEOFIJQ3BRUGBQERFJABNDKJSFBQNERFBQQWERQIOJEHFQJEFNALKWEUHRQLIUE";
        //System.out.println("=1111="+n);
        if (targetStr.length() <= n) {
            return "";
        }
        char aim1 = targetStr.charAt(n);
        char aim2 = 0;
        char aim3 = 0;
        if (targetStr.length() > n + 1) {
            aim2 = targetStr.charAt(n + 1);

        }
        if (targetStr.length() > n + 2) {
            aim3 = targetStr.charAt(n + 2);
        }

        String aim = aim1 + "" + aim2 + "" + aim3;
        list.add(aim);
        //System.out.println(aim);
        return test14(n + 1, list);
        //+targetStr.charAt(n-1);
    }

    public String test11(int n, ArrayList list) {
        String targetStr = "AAAA";
        if (targetStr.length() <= n) {
            return "";
        }
        char aim1 = targetStr.charAt(n);
        char aim2 = 0;
        if (targetStr.length() > n + 1) {
            aim2 = targetStr.charAt(n + 1);
        }
        String aim = aim1 + "" + aim2;
        System.out.println(aim);
        list.add(aim);
        return test11(n + 1, list);
        //+targetStr.charAt(n-1);
    }

    @Test
    public void test12() {
        System.out.println("===========================");
        long time1 = System.currentTimeMillis();
        ArrayList list = new ArrayList();
        test14(0, list);
        System.out.println(list);
        ArrayList list2 = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("JFU")) {
                list2.add(i);
            }
        }
        System.out.println(list.size());
        System.out.println("==list2==" + list2.size());

        // System.out.println(list2);
        long time2 = System.currentTimeMillis();
        System.out.println("===递归实现===" + (time2 - time1));
        System.err.println("===========================");
        long time3 = System.currentTimeMillis();
        int[] search = search("FAGEGEWRGAEGERSKGJIEWRHOUIQ3REGHFADJGFIUERHGIUAERFGASDKJFPQI3EHGFJPOADGAKLDNFAKNEJRHAEIRFNAJFNPEIRTIERTJAIPEROGJEAIRNRUEHGUAERIPNGFJAERNGEIPRUGHAUIGHAODNFLKADNFAKNGIERHTUERIQHTQIJGNQJRIGBNJDANFKAJDFIUQERBGQJKERGQIPREFNQPJIREGHQRUIEGBQURHTQURIPHTQUPIRNFGJQREIGNJANDGKAJHGUQIRGBNAJKLDGHUQIREBGQRHGQIREPNGQEKJRGNKQERNGFKAJGKALBFGKAERBIQUBERFQO3IRUHQIERPFNQEJIFBNALJDFBIUQEBRFAJKDSBFQIEHBFHJDSLBFJHASFUQEWBFHQGFUOQEHFHQEPGJIADBFALKDJBGQIUEUHFQJEIBFIWEHGQIBFADSGHQUIEFBQIWEBFUQIEWRHTUQIBGQIHGQUIETGHQUEBGQIHGQUEIHRQI3BFQIEWGHQUEIGHQUIHVUQIBNUQIERHUQEGNQUEIRGHQU3ITHQUEWBGQUIERHTQUEIRNQIERUTHQUITRBEWQUIJFBQIUWEGRUIQEBFQJIWEBFAKJDSBFQUIEGHRUQIOERGHOBQEJWIFNQJWEBGJBEGAKNDBGJQIEHFQIJENFAKJDFUHIQEGHU3IQRTPQHTPIEQRJNFAKJDGBAUFGHEQUIRGEQIRGHQEURIGHPQIJQWEPHFQJEWNFADKSGNQUIERHGQIREJGNIQERJGBNJKDFNAMDGBQIEROHTUIQP3RGFNIREQHQPERGFNKJDNFGAKLJDGBFNWQERQWEROUIQBEOFIJQ3BRUGBQERFJABNDKJSFBQNERFBQQWERQIOJEHFQJEFNALKWEUHRQLIUEFAGEGEWRGAEGERSKGJIEWRHOUIQ3REGHFADJGFIUERHGIUAERFGASDKJFPQI3EHGFJPOADGAKLDNFAKNEJRHAEIRFNAJFNPEIRTIERTJAIPEROGJEAIRNRUEHGUAERIPNGFJAERNGEIPRUGHAUIGHAODNFLKADNFAKNGIERHTUERIQHTQIJGNQJRIGBNJDANFKAJDFIUQERBGQJKERGQIPREFNQPJIREGHQRUIEGBQURHTQURIPHTQUPIRNFGJQREIGNJANDGKAJHGUQIRGBNAJKLDGHUQIREBGQRHGQIREPNGQEKJRGNKQERNGFKAJGKALBFGKAERBIQUBERFQO3IRUHQIERPFNQEJIFBNALJDFBIUQEBRFAJKDSBFQIEHBFHJDSLBFJHASFUQEWBFHQGFUOQEHFHQEPGJIADBFALKDJBGQIUEUHFQJEIBFIWEHGQIBFADSGHQUIEFBQIWEBFUQIEWRHTUQIBGQIHGQUIETGHQUEBGQIHGQUEIHRQI3BFQIEWGHQUEIGHQUIHVUQIBNUQIERHUQEGNQUEIRGHQU3ITHQUEWBGQUIERHTQUEIRNQIERUTHQUITRBEWQUIJFBQIUWEGRUIQEBFQJIWEBFAKJDSBFQUIEGHRUQIOERGHOBQEJWIFNQJWEBGJBEGAKNDBGJQIEHFQIJENFAKJDFUHIQEGHU3IQRTPQHTPIEQRJNFAKJDGBAUFGHEQUIRGEQIRGHQEURIGHPQIJQWEPHFQJEWNFADKSGNQUIERHGQIREJGNIQERJGBNJKDFNAMDGBQIEROHTUIQP3RGFNIREQHQPERGFNKJDNFGAKLJDGBFNWQERQWEROUIQBEOFIJQ3BRUGBQERFJABNDKJSFBQNERFBQQWERQIOJEHFQJEFNALKWEUHRQLIUEFAGEGEWRGAEGERSKGJIEWRHOUIQ3REGHFADJGFIUERHGIUAERFGASDKJFPQI3EHGFJPOADGAKLDNFAKNEJRHAEIRFNAJFNPEIRTIERTJAIPEROGJEAIRNRUEHGUAERIPNGFJAERNGEIPRUGHAUIGHAODNFLKADNFAKNGIERHTUERIQHTQIJGNQJRIGBNJDANFKAJDFIUQERBGQJKERGQIPREFNQPJIREGHQRUIEGBQURHTQURIPHTQUPIRNFGJQREIGNJANDGKAJHGUQIRGBNAJKLDGHUQIREBGQRHGQIREPNGQEKJRGNKQERNGFKAJGKALBFGKAERBIQUBERFQO3IRUHQIERPFNQEJIFBNALJDFBIUQEBRFAJKDSBFQIEHBFHJDSLBFJHASFUQEWBFHQGFUOQEHFHQEPGJIADBFALKDJBGQIUEUHFQJEIBFIWEHGQIBFADSGHQUIEFBQIWEBFUQIEWRHTUQIBGQIHGQUIETGHQUEBGQIHGQUEIHRQI3BFQIEWGHQUEIGHQUIHVUQIBNUQIERHUQEGNQUEIRGHQU3ITHQUEWBGQUIERHTQUEIRNQIERUTHQUITRBEWQUIJFBQIUWEGRUIQEBFQJIWEBFAKJDSBFQUIEGHRUQIOERGHOBQEJWIFNQJWEBGJBEGAKNDBGJQIEHFQIJENFAKJDFUHIQEGHU3IQRTPQHTPIEQRJNFAKJDGBAUFGHEQUIRGEQIRGHQEURIGHPQIJQWEPHFQJEWNFADKSGNQUIERHGQIREJGNIQERJGBNJKDFNAMDGBQIEROHTUIQP3RGFNIREQHQPERGFNKJDNFGAKLJDGBFNWQERQWEROUIQBEOFIJQ3BRUGBQERFJABNDKJSFBQNERFBQQWERQIOJEHFQJEFNALKWEUHRQLIUEFAGEGEWRGAEGERSKGJIEWRHOUIQ3REGHFADJGFIUERHGIUAERFGASDKJFPQI3EHGFJPOADGAKLDNFAKNEJRHAEIRFNAJFNPEIRTIERTJAIPEROGJEAIRNRUEHGUAERIPNGFJAERNGEIPRUGHAUIGHAODNFLKADNFAKNGIERHTUERIQHTQIJGNQJRIGBNJDANFKAJDFIUQERBGQJKERGQIPREFNQPJIREGHQRUIEGBQURHTQURIPHTQUPIRNFGJQREIGNJANDGKAJHGUQIRGBNAJKLDGHUQIREBGQRHGQIREPNGQEKJRGNKQERNGFKAJGKALBFGKAERBIQUBERFQO3IRUHQIERPFNQEJIFBNALJDFBIUQEBRFAJKDSBFQIEHBFHJDSLBFJHASFUQEWBFHQGFUOQEHFHQEPGJIADBFALKDJBGQIUEUHFQJEIBFIWEHGQIBFADSGHQUIEFBQIWEBFUQIEWRHTUQIBGQIHGQUIETGHQUEBGQIHGQUEIHRQI3BFQIEWGHQUEIGHQUIHVUQIBNUQIERHUQEGNQUEIRGHQU3ITHQUEWBGQUIERHTQUEIRNQIERUTHQUITRBEWQUIJFBQIUWEGRUIQEBFQJIWEBFAKJDSBFQUIEGHRUQIOERGHOBQEJWIFNQJWEBGJBEGAKNDBGJQIEHFQIJENFAKJDFUHIQEGHU3IQRTPQHTPIEQRJNFAKJDGBAUFGHEQUIRGEQIRGHQEURIGHPQIJQWEPHFQJEWNFADKSGNQUIERHGQIREJGNIQERJGBNJKDFNAMDGBQIEROHTUIQP3RGFNIREQHQPERGFNKJDNFGAKLJDGBFNWQERQWEROUIQBEOFIJQ3BRUGBQERFJABNDKJSFBQNERFBQQWERQIOJEHFQJEFNALKWEUHRQLIUE", "JFU");
        System.out.println(Arrays.toString(search));
        long time4 = System.currentTimeMillis();
        System.out.println("===实现===" + (time4 - time3));


    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //高辉面试题, 二维数组,  行列 都递增,  找一个值 是否存在
    /*
        1  2  3   4  5    6
        7  8  9  10  11   12
        13 14 15 16  17   18

        在二维数组中找到 11 是否存在
     */
    @Test
    public void test13() {
        // 以右上角的值为 第一个查询对象
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 8, 9,}, {7, 8, 9}};//[[1,2,3],[4,5,6],[7,8,9]];
        int targetElement = 5;
        for (int i = 0; i < matrix.length; i++) {

            //System.out.println(matrix[i][0]);
            System.out.println(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " [" + i + "," + j + "]   ");
            }

        }
        ///////////////////
        int e1 = matrix[0][matrix.length - 1];
        System.out.println(e1);
        if (targetElement > e1) {
            //System.out.println("元素不存在");
            for (int i = 1; i <= 2; i++) {
                int e2 = matrix[i][matrix.length - 1 - i];
                if (targetElement == e2) {
                    System.out.println("钙元素存在" + "==i==" + i + "===j==" + (matrix.length - 1 - i));
                }
            }
        } else {
            for (int i = 0; i < 1; i++) {
                int e3 = matrix[0][i];
                System.out.println("===e3=" + e3);
                if (targetElement == e3) {
                    System.out.println("钙元素存在");

                } else {
                    for (int j = 1; j <= 2; j++) {
                        int e2 = matrix[i][j];
                        if (targetElement == e2) {
                            System.out.println("钙元素存在");
                        }
                    }
                }
            }
        }

    }

    public boolean Find(int target, int[][] array) {
        if (array.length < 1 || target < 0 || array == null) {
            return false;
        }
        int rows = array.length; //得到行长度
        int cols = array[0].length; //列长度
        int col = cols - 1;  //开始列号
        int row = 0; //开始行号
        while (col >= 0 && col < cols && row < rows && row >= 0) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    @Test
    public void test14() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 6, 9,}, {7, 8, 9}};//[[1,2,3],[4,5,6],[7,8,9]];
        int targetElement = 5;
        boolean find = Find(targetElement, matrix);
        System.out.println(find);
    }
/*    // 后续  6  4  5   2   7  3   1   中序 6 4   2  5   1   3 7
         1
    2         3
 4    5     7
6
 */


/*                 5
             4     3
            6 2   1  7





      // 先 4  1 3 2 6 5 7
       //中 1 2 3  4  5 6 7
    //后 2 3  1   5 7 6  4


        4
      1    6
    2  3  5  7*/

    //：已知二叉树的后序遍历序列是dabe c,中序遍历序列是deba c      ,它的前序遍历序列是（cedba）。


    //第1个⼈10，第2个⽐第1个⼈⼤2岁，依次递推，请⽤递归⽅式计算出第8个⼈
    // 多⼤？
    @Test
    public void test15() {
      /*  for (int i = 1; i <9 ; i++) {
            int age = getAge(i);
            System.out.println("第"+i+"个人"+"==="+age);
        }*/
        int age = getAge(8);
        System.out.println(age);
    }

    public int getAge(int n) {
        if (n == 1) {
            return 10;
        }
        return getAge(n - 1) + 2;
    }

    //有⼀对兔⼦，从出⽣后第3个⽉起每个⽉都⽣⼀对兔⼦，⼩兔⼦⻓到第四个⽉后
    //每个⽉⼜⽣⼀对兔⼦，假如兔⼦都不死，问第⽉的兔⼦总数为多少
  /*  f(1) = 1  1
    f(2) = 2 1
    f(3) ==3  2
    f(4) ==4  3
    f(5) ==5  5
   */
    @Test
    public void test16() {
        int i = bigTuzi(4);
        System.out.println("====" + i);
    }

    public int bigTuzi(int n) {
        if (n == 1 || n == 2) {
            return 2;
        }
        int i = samllTuzi(n - 3);
        System.out.println("===n===" + n + "===小兔子=" + i + "===" + (bigTuzi(n - 1) + 2 + i));
        return bigTuzi(n - 1) + 2 + i;
    }

    public int samllTuzi(int n) {
        if (n == 0) {
            return 0;
        }
        if (0 < n || n < 4) {
            return 2;
        }
        return samllTuzi(n - 1) + 2;
    }

    //打印出所有的 "⽔仙花数 "，所谓 "⽔仙花数 "是指⼀个三位数，其各位数字⽴
    //          ⽅和等于该数本身。例 如：153是⼀个 "⽔仙花数 "，因为153=1的三次⽅＋5的三
//    次⽅＋3的三次⽅。在2000以内的数字。
    @Test
    public void test17() {
        for (int i = 100; i < 1000; i++) {
            Boolean aBoolean = queryFollow(i);
            if (aBoolean) {
                System.out.println("====" + i);
            }
        }
    }

    public Boolean queryFollow(int n) {
        int a, b, c = 0;
        a = n / 100;
        b = (n % 100) / 10;
        c = n % 10;
        if (n == 153) {
            System.out.println("==n=" + n + "===" + a + "===b===" + b + "===c==" + c);

        }
        if (a * a * a + b * b * b + c * c * c == n) {
            return true;
        }
        return false;
    }

    //猴⼦吃桃问题：猴⼦第⼀天摘下若⼲个桃⼦，当即吃了⼀半，还不瘾，⼜多吃
    //了⼀个 第⼆天早上⼜ 将剩下的桃⼦吃掉⼀半，⼜多吃了⼀个。以后每天早上都吃
    //了前⼀天剩下的⼀半零⼀个。到第 10 天早上想再吃时，⻅只 剩下⼀个桃⼦了。求
    //第⼀天共摘了多少。
 /*   10  1
    9   4
    8   10
    7   22 */
    @Test
    public void test18() {
        int i = eatPeach(1);
        System.out.println(i);
    }

    public int eatPeach(int day) {
        if (day == 10) {
            return 1;
        }

        int num = (eatPeach(day + 1) + 1) * 2;
        System.out.println("===" + day + "===" + num);
        return num;
    }
    // 有⼀分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前 20
    // 项之和。
/*
    1   1     1
    2    2
    3    3
    4    5*/


    @Test
    public void test19() {


    }
  /*  public int math(int num){
        if(num ==1){
            return  2/1;
        }
        int sum = math(num-1)-
    }
*/
    //有 5 个⼈坐在⼀起，问第五个⼈多少岁？他说⽐第 4 个⼈⼤ 2 岁。问第4 个
    //⼈岁数，他说⽐第 3 个⼈ ⼤ 2 岁。问第三个⼈，⼜说⽐第 2 ⼈⼤两岁。问第 2 个
    //⼈，说⽐第⼀个⼈⼤两岁。最后问第⼀个⼈，他说是10 岁。请问第 五个⼈多⼤？

    @Test
    public void test20() {
        math(5);

    }

    public int math(int num) {
        if (num == 1) {
            return 10;
        }
        int sum = math(num - 1) + 2;
        System.out.println("===" + num + "===" + sum);
        return sum;
    }

    public int Test(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

    @Test
    public void test21() {
        int i = 666;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Test(i));
    }

    @Test
    public void test22() {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        int i = 6;
        String s = Integer.toBinaryString(i);
        System.out.println(Integer.toBinaryString(i));
        int j = 5;
        System.out.println(Integer.toBinaryString(j));
        //System.out.println(Test(i));
        System.out.println(i & j);
        System.out.println(Integer.toBinaryString(i & j));


    }

    /**
     * 判断单链表是否存在环

     * @return
     *//*
    public static <T> boolean isLoopList(ListNode<T> head){
        ListNode<T> slowPointer, fastPointer;
        ArrayList<Object> objects = new ArrayList<>();
        objects.
        //使用快慢指针，慢指针每次向前一步，快指针每次两步
        slowPointer = fastPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            //两指针相遇则有环
            if(slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }*/
/*
    N个人围成一圈，从第一个人开始报数，
    报到m的人出圈，剩下的人继续从1开始报数，报到m的人出圈；
    如此往复，直到所有人出圈。（模拟此过程，输出出圈的人的序号）
    */
    @Test
    public void test23() {

    }

    public int yuesefu(ArrayList<Integer> list, int m) {
        if (list.size() == 1) {
            return list.get(0);
        }
        //
        int j = 0;
        if (m > list.size()) {
            m = m % list.size();
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == m) {
                j = i;
                break;
            }
        }
        Integer remove = list.remove(j);

        return remove;
    }
    public static void yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        // 从第K个开始计数
        int k = 0;
        while (start.size() > 0) {
            k = k + countNum;
            // 第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }

}
