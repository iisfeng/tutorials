package com.testeru.strs;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/14 1:44 下午
 */
public class Demo2 {


    public static void main(String[] args) {
        //字符串比较
        String s = "string";
        String s1 = "string";
        String s2 = s1;
        String s3 = new String("string");
        char[] chars = {'s', 't', 'r','i','n','g'};
        String s4 = new String(chars);

        boolean equals1 = s.equals(s1);
        boolean equals2 = s.equals(s2);
        boolean equals3 = s.equals(s3);
        boolean equals4 = s.equals(s4);

        System.out.println(equals1);//true
        System.out.println(equals2);//true
        System.out.println(equals3);//true
        System.out.println(equals4);//true

        System.out.println(s.equalsIgnoreCase(s1));

        //==检查s1,s2是否指向同一个对象，但是不会比较对象的内容是否相等
        //所以不用==判断2个字符串变量内容是否相同

        int i1 = s.compareTo(s4);
        System.out.println(i1);//0
//a b c d e f g
//1 2 3 4 5 6 7   7-3=4
        //compareTo
        String a = "abc";
        String b = "abg";

        int i2 = a.compareTo(b);
        System.out.println(i2);//-4
        System.out.println(a.compareToIgnoreCase(b));
//        System.out.println("a" > "i");



        System.out.println(a.startsWith("a"));

        System.out.println(a.endsWith("c"));
        System.out.println(a.contains("cc"));


        String a1 = "this is string";
        /**
         * this is string
         */
        String substring1 = a1.substring(7);
        String substring2 = a1.substring(1, 3);

        System.out.println(substring1);// string
        System.out.println(substring2);//hi
        System.out.println(a1.substring(3,3));
//        System.out.println(a1.substring(7,3));



        //张 小强
        String name = "张 小强";
        int indexOf = name.indexOf(" ");
        String firstName = name.substring(0,indexOf);
        String lastName = name.substring(indexOf + 1);
        System.out.println("姓："+firstName);
        System.out.println("名："+lastName);



    }
}
