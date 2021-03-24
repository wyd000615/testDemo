package com.other;
public class A {

    class Inner {
        public  String  v1 = "Fake News";
        public String v2 = "Go ahead";
    }

    private static String GetVal() {
        try {
            System.out.println(Inner.class.newInstance().v1);
            return Inner.class.newInstance().v1;
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());

                return Inner.class.getDeclaredConstructor(A.class).newInstance((A)null).v2;
            } catch (Exception ee) {
                ee.printStackTrace();
                return "Fake News, Go ahead";
            }
        }
    }
    public static void main(String[] args) {

        System.out.println(GetVal());
    }
}