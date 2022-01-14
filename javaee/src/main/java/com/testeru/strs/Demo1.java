package com.testeru.strs;

import com.testeru.files.FileUtil;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/14 11:41 上午
 */
public class Demo1 {

    public static void main(String[] args) {
        char one = 's';
        String a = "this is string";

        char data[] = {'s', 't', 'r','i','n','g'};
        String str = new String(data);

        System.out.println(one);
        System.out.println(a);
        System.out.println(str);

        //获取字符串长度 6
        int length = str.length();
        System.out.println(length);
        System.out.println("string".length());
        //空字符串的长度 0
        System.out.println("".length());

        //获取特定字符
        /**
         * t h i s   i s   s t  r  i n  g
         * 0 1 2 3 4 5 6 7 8 9 10 11 12 13
         */
        char c = a.charAt(12);
        System.out.println(a.length());
        System.out.println(c);
        System.out.println("11"+true);
        System.out.println("11"+ Arrays.asList(1,2,3,4,54));
        System.out.println("11"+ new FileUtil());


        int i = 1;
        int j = 2;
        System.out.println("i+j ="+ i + j);//12
        System.out.println("(i+j) = " + (i + j));//3


        String atoLowerCase = a.toLowerCase();
        System.out.println(atoLowerCase);//this is string
        String atoUpperCase = a.toUpperCase();
        System.out.println(atoUpperCase);//THIS IS STRING

        String b = " this is string ";
        System.out.println(b+"1");// this is string 1
        System.out.println(b.trim()+"1");//this is string1
        System.out.println(b.length());//16
        System.out.println(b.trim().length());//14


        //键盘读取字符串
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始输入从键盘读取输入的字符串：");

        //next() 读取以空白字符结束的字符串
        //' '、\t、\f、\n、\r
        String next1 = scanner.next();//输入
        String next2 = scanner.next();
        System.out.println(next1);
        System.out.println(next2);

        //nextLine()读取一整行文本 读取按下 回车键 结束的字符串
        //键盘读取字符串
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("开始输入从键盘读取输入的整行字符串：");
        String nextLine = scanner1.nextLine();
        System.out.println(nextLine);

        //字符串比较


    }
}
