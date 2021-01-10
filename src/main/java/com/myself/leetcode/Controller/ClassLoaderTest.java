package com.myself.leetcode.Controller;

public class ClassLoaderTest {
    private int a=1;
    private static int b=2;

    static {
        System.out.println("static {...} "+'{' +
//                        "a=" + a +
                "b=" + b +
//                        "c=" + c +
                '}');
        b=20;
        c=30;
        System.out.println("static {...} "+'{' +
//                        "a=" + a +
                        "b=" + b +
//                        "c=" + c +
                        '}');
    }

    private static int c=3;

    {
        System.out.println("{...} "+'{' +
                "a=" + a +
                "b=" + b +
                "c=" + c +
//                "d=" + d +
                '}');
        a=100;
        b=200;
        c=300;
        d=400;
        System.out.println("{...} "+'{' +
                "a=" + a +
                "b=" + b +
                "c=" + c +
//                "d=" + d +
                '}');
    }

    private int d=4;

    public ClassLoaderTest(){
        System.out.println("ClassLoaderTest() "+'{' +
                "a=" + a +
                "b=" + b +
                "c=" + c +
                "d=" + d +
                '}');
        a=1000;
        b=2000;
        c=3000;
        d=4000;
        System.out.println("ClassLoaderTest() "+'{' +
                "a=" + a +
                "b=" + b +
                "c=" + c +
                "d=" + d +
                '}');
    }

    @Override
    public String toString() {
        return "ClassLoaderTest{" +
                "a=" + a +
                "b=" + b +
                "c=" + c +
                "d=" + d +
                '}';
    }

    public static void main(String[] args) {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        System.out.println(classLoaderTest);
    }
}
