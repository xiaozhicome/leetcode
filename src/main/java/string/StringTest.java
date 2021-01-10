package string;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class StringTest {

    public static void main(String[] args) {
        String s1="abc";
        String s2="abc";
        System.out.println(s1==s2);//true
        System.out.println(toString(s1));
        System.out.println(toString(s2));

        String s3="abc"+"d";
        String s4="abcd";
        System.out.println(s3==s4);//true
        System.out.println(toString(s3));
        System.out.println(toString(s4));

        String s5=s1+"d";
        String s6="abcd";
        System.out.println(s5==s6);//false  注意
        System.out.println(toString(s5));
        System.out.println(toString(s6));

        String s7=new String("abc");
        String s8="abc";
        System.out.println(s7==s8);
        System.out.println(toString(s7));
        System.out.println(toString(s8));
    }


    public static String toString(Object object) {
        return object.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object));
    }

}
