package com.testeru.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/12 5:04 下午
 */
public class StringsUtils {

    public static Integer num(String a){
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(a);
        String trim = m.replaceAll("").trim();
        System.out.println(trim);
        return Integer.parseInt(trim);
    }
}
