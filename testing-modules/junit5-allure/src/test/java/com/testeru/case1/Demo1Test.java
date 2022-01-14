package com.testeru.case1;

import com.example.project.Calculator;
import com.testeru.base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/12 5:56 下午
 */
public class Demo1Test extends BaseTest {


    //测试方法
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("2个 int 类型数字相加")
    @Lead("shantonu.sarker")
    @Story("An User should be able to add two numbers")
    @Issue("WW-21")
    @Epic("Adding functionality of Adding two int ")
    @TmsLink("tc-256")
    public void testAdd(){
        assertEquals(30,calculator.add(25,5));
    }


    @DisplayName("加法用例")
    @ParameterizedTest
    @ValueSource(ints = {1,3,4,5,6,7,8})
    void add1(int a){
        int add = calculator.add(a, 5);
        System.out.println("计算结果:"+add);
    }

    @ParameterizedTest
    @MethodSource("intDate")
    @DisplayName("减法用例")
    void sub6(int a){
        int sub = calculator.sub(a, 5);
        System.out.println("计算结果:"+sub);
    }

    //使用的是包装类
    static Stream<Integer> intDate() {
        return Stream.of(1,3,4,5,6,7,8);
    }
    static List<Integer> factory(){
        return Arrays.asList(1,3,4,5,6,7,8);
    }
    static IntStream factory1(){
        return IntStream.of(1,3,4,5,6,7,8);
    }
    static int[] factory2(){
        return new int[]{1,3,4,5,6,7,8};
    }


    @DisplayName("乘法用例")
    @ParameterizedTest
    @MethodSource
    void mul8(int a){

//        System.out.println("计算结果:"+mul);

    }
    static int[] mul8(){
        return new int[]{1,3,4,5,6,7,8};
    }


    @ParameterizedTest
    @DisplayName("除法用例")
    @MethodSource
    void div2(int a,int b,String c,List<String> stringList){
        int div = calculator.div(a, b);
        System.out.println(stringList.get(0)+" 除以 "+ stringList.get(1) +" 的计算结果:"+div);
        assertEquals(Integer.parseInt(c),div);

    }


     static Stream<Arguments> div2() {
         List<String> strings = Arrays.asList("10", "5");
         return Stream.of(
                arguments(10,5,"2",Arrays.asList("10","5")),
                arguments(15,5,"3",Arrays.asList("15","5"))
        );
    }




}
