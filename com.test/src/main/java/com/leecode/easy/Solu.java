package com.leecode.easy;

import org.junit.Test;

import java.util.*;

public class Solu {

    int ans = 0;

    @Test
    public void test05() {
        String word = "leetcode";
        System.out.println(word.equals(word.toUpperCase()) || word.substring(1).equals(word.substring(1).toLowerCase()));
    }

    @Test
    public void test06() {
        String word = "aaa";
        String substring = word.substring(1);
        System.out.println(substring);
        String s = word.substring(1).toLowerCase();
        System.err.println(s);
        boolean equals = word.substring(1).equals(word.substring(1).toLowerCase());
        System.out.println(equals);
    }

    /**
     * 318. 最大单词长度乘积
     * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
     * 并且这两个单词不含有公共字母。
     * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
     */
    @Test
    public void test07() {
        //String[] words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        String[] words = new String[]{"az", "z"};
        int length = words.length;
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                int num = (word.charAt(j) - 'a');
                int z = 1 << (word.charAt(j) - 'a');

                masks[i] |= 1 << (word.charAt(j) - 'a');
                System.out.println("--元素----" + word.charAt(j) + "---num---" + num + "----z===" + z + "---masks[i]---" + masks[i]);

            }
        }
        int maxProd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        System.out.println(maxProd);


    }

    @Test
    public void test08() {
        int i = 1;
        int j = 2;
        int z = i | j;
        System.out.println(z);
/*        //ab   0000 0011
        //a    0000 0001*/
        //abc   0000 0111
        //ac   0000 0101
        //az  001000000000000000000000 0001
    }

    /**
     * 563. 二叉树的坡度
     * 给定一个二叉树，计算 整个树 的坡度 。
     * <p>
     * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
     * <p>
     * 整个树 的坡度就是其所有节点的坡度之和。
     *
     * @return
     */
    @Test
    public void findTilt() {
        //[4,2,9,3,5,null,7]
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(1, r1, r2);
        TreeNode r4 = new TreeNode(1);
        TreeNode r5 = new TreeNode(7, r3, r4);
        TreeNode r6 = new TreeNode(2);
        TreeNode r7 = new TreeNode(2);
        TreeNode r8 = new TreeNode(14, r6, r7);
        TreeNode root = new TreeNode(21, r5, r8);

        List<Integer> list = new ArrayList<>();
        int result = dfs(root);
        System.out.println(ans);
    }

    //定义一个递归方法，计算 左节点 - 右节点的绝对值
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = dfs(node.left);
        int sumRight = dfs(node.right);
        ans = Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + node.val;


    }

    /**
     * 397. 整数替换
     * 给定一个正整数 n ，你可以做如下操作：
     * <p>
     * 如果 n 是偶数，则用 n / 2替换 n 。
     * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
     * n 变为 1 所需的最小替换次数是多少？
     */
    public Integer change(int num) {
        if (num <= 1) {
            return 1;
        }
        ans += 1;
        int sum = change(num);
        if (sum % 2 != 0 && sum != 1) {
            num += 1;
        }
        return num / 2;

    }

    @Test
    public void test09() {
        int n = 219;
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                ++ans;
                n /= 2;
            } else if (n % 4 == 1) {
                ans += 2;
                n /= 2;
            } else {
                if (n == 3) {
                    ans += 2;
                    n = 1;
                } else {
                    System.err.println(n);
                    ans += 2;
                    n = n / 2 + 1;
                }
            }
        }
        System.out.println(ans);
    }

    /**
     * 594. 最长和谐子序列
     * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
     * <p>
     * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
     * <p>
     * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
     */
    @Test
    public void test10() {
        Integer[] arr = {1, 3, 2, 2, 5, 2, 3, 7};

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        ArrayList<Integer> list3 = new ArrayList<>();

        //循环遍历，根据第一个元素找到对应的序列
        for (int i = 0; i < list.size(); i++) {
            int before = list.get(i);
            ArrayList<Integer> list2 = new ArrayList<>();
            list2.add(before);
            for (int j = i + 1; j < list.size(); j++) {
                int after = list.get(j);
                if (Math.abs(after - before) <= 1) {
                    list2.add(after);
                }
            }
            //如果得到的list2的长度大于原先的就替换
            if (list2.size() > list3.size()) {
                list3 = list2;
            }

        }
        //比较所有序列，选出最长的序列
        System.out.println(list3.toString());


    }

    @Test
    public void test11() {

        int[] arr = {1, 3, 2, 2, 5, 2, 3, 7};

        ArrayList<Integer> list3 = new ArrayList<>();

        //循环遍历，根据第一个元素找到对应的序列
        for (int i = 0; i < arr.length; i++) {
            int before = arr[i];
            ArrayList<Integer> list2 = new ArrayList<>();
            list2.add(before);
            for (int j = i + 1; j < arr.length; j++) {
                int after = arr[i];
                if (Math.abs(after - before) <= 1) {
                    list2.add(after);
                }
            }
            //如果得到的list2的长度大于原先的就替换
            if (list2.size() > list3.size()) {
                list3 = list2;
            }

        }
        //比较所有序列，选出最长的序列
        System.out.println(list3.toString());


    }

    @Test
    public void test12() {

        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};


        Arrays.sort(nums);
        int begin = 0;
        int res = 0;
        for (int end = 0; end < nums.length; end++) {
            System.err.println("end=========================================================" + end);

            while (nums[end] - nums[begin] > 1) {
                begin++;
            }
            System.out.println("begin=" + begin);
            if (nums[end] - nums[begin] == 1) {
                System.out.println("nums[end]=" + nums[end] + "nums[begin]=" + nums[begin]);

                res = Math.max(res, end - begin + 1);
            }
        }
        System.out.println("res==" + res);
    }


    @Test
    public void test13() {

        Map<String, String> map = new HashMap<String, String>();
        map.getOrDefault("s", "12");
        System.out.println(map.get("s"));
        System.out.println(map.getOrDefault("s", "12"));
        map.put("b", map.getOrDefault("b", "a") + "z");

        System.err.println(map.get("b"));
        System.out.println("");
    }

    /**
     * 859. 亲密字符串
     * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
     * <p>
     * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
     * <p>
     * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
     */
    @Test
    public void test14() {

    }

    /**
     * 423. 从英文中重建数字
     * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
     */
    @Test
    public void test15() {
        String s = "owoztneoer";
        Map<Character, Integer> c = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            c.put(ch, c.getOrDefault(ch, 0) + 1);
        }

        int[] cnt = new int[10];
        cnt[0] = c.getOrDefault('z', 0);
        cnt[2] = c.getOrDefault('w', 0);
        cnt[4] = c.getOrDefault('u', 0);
        cnt[6] = c.getOrDefault('x', 0);
        cnt[8] = c.getOrDefault('g', 0);

        cnt[3] = c.getOrDefault('h', 0) - cnt[8];
        cnt[5] = c.getOrDefault('f', 0) - cnt[4];
        cnt[7] = c.getOrDefault('s', 0) - cnt[6];

        cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < 10; ++i) {
            System.out.println("--------------");

            for (int j = 0; j < cnt[i]; ++j) {
                System.err.println("------1--------"+i+"----"+cnt[i]);
                ans.append((char) (i + '0'));
            }
        }
        System.out.println(ans.toString());
    }

    /**
     * 1446. 连续字符
     * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
     *
     * 请你返回字符串的能量。
     *
     *
     */
    @Test
    public void test16() {

    }

    /**
     * 506. 相对名次
     * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
     *
     * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
     *
     * 名次第 1 的运动员获金牌 "Gold Medal" 。
     * 名次第 2 的运动员获银牌 "Silver Medal" 。
     * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
     * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
     * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
     *
     *
     */
    @Test
    public void test17() {
        int[] score =new int[]{10,3,8,9,4};
        int[][] arr = new int[10][2];
        for (int i = 0; i < 10; ++i) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        Arrays.sort(arr);

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


}
