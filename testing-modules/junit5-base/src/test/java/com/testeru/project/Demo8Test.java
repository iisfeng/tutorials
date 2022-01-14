package com.testeru.project;

import com.example.project.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 参数化执行
 * @Version 1.0
 * @create: 2022/1/12 1:52 下午
 */
@DisplayName("第8个计算器用例😊")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Demo8Test {


    static Calculator calculator;
    @BeforeAll
    static void beforeAll(){
        System.out.println("打开计算器app");
        calculator = new Calculator();
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("进入科学计算器，计算器清零");

    }

    @Order(16)
    @DisplayName("加法用例")
    @ParameterizedTest
    @ValueSource(ints = {1,3,4,5,6,7,8})
    void test1(int a){
        System.out.println("加法用例");
        int add = calculator.add(a, 5);
        System.out.println("计算结果:"+add);
//        assertEquals(6,add);
    }

    @ParameterizedTest
    @MethodSource("intDate")
    @Order(13)
    @DisplayName("减法用例")
    void test2(int a){
        System.out.println("减法用例");
        int sub = calculator.sub(a, 5);
        System.out.println("计算结果比对:"+sub);
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


    @Order(6)
    @DisplayName("乘法用例")
    @ParameterizedTest
    @MethodSource
    void test3(int a){
        System.out.println("乘法用例");
        int mul = calculator.mul(a, 5);
        System.out.println("计算结果比对:"+mul);

    }
    static int[] test3(){
        return new int[]{1,3,4,5,6,7,8};
    }
    @Test
    @Order(1)
    @DisplayName("除法用例")
    void test4(){
        System.out.println("除法用例");
        int add = calculator.div(10, 5);
        System.out.println("计算结果比对");
        assertEquals(2,add);
    }



    @AfterEach
    void afterEach(){
        //保持数据清空
        System.out.println("用例结束，返回标准计算器");

    }
    @AfterAll
    static void afterAll(){
        System.out.println("退出计算器app");
    }

}
