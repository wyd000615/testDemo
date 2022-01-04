package easy;

public class Solution {


    public static boolean detectCapitalUse(String word) {
        String substring = word.substring(1);
        System.out.println(substring);
        String s = word.substring(1).toLowerCase();
        System.err.println(s);
        boolean equals = word.substring(1).equals(word.substring(1).toLowerCase());
        return equals;
    }

    public static void main(String[] args) {
        detectCapitalUse("Asss");
    }
}
