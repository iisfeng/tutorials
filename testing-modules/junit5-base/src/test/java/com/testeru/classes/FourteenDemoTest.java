package com.testeru.classes;


import com.testeru.base.SelfOrder;
import com.testeru.params.ArraySource;
import com.testeru.params.ArraySources;
import com.testeru.params.VariableSource;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description: 自定义测试顺序
 * @Version 1.0
 * @create: 2022/1/10 10:47 上午
 */
@DisplayName("第14个测试用例")
@TestMethodOrder(SelfOrder.class)
public class FourteenDemoTest {
    private static StringBuilder output = new StringBuilder("");

    @BeforeAll
    static void beforeAll1() {
        System.out.println("---进入到首页---");
    }

    @BeforeEach
    void beforeEach1() {
        System.out.println("---搜索商品---");
    }

    @DisplayName("search11")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "8"})
    void search11(String num) {
        System.out.println("---点击查看第" + num + "个商品详情---");
        output.append("下单日期为20220101\n");

    }

    @DisplayName("test2")
    @Disabled("先不执行")
    @Test
    void test2() {
        System.out.println("---点击查看第 2 个商品详情---");
        output.append("下单日期为20220102\n");

    }

    @DisplayName("testok3")
    @Disabled
    @Test
    void testok3() {
        System.out.println("---点击查看第 2 个商品详情---");
        output.append("下单日期为20220103\n");

    }

    @DisplayName("num6")
    @RepeatedTest(value = 3, name = "6 {currentRepetition}/{totalRepetitions}")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "8"})
    void num6(String num) {
        System.out.println("---点击查看第" + num + "个商品详情---");
        output.append("下单日期为20220109\n");
    }

    @DisplayName("wdc5")
    @RepeatedTest(value = 3, name = "Custom name {currentRepetition}/{totalRepetitions}")
    void wdc5() {
        System.out.println("---点击查看第 6 个商品详情---");
        output.append("下单日期为20220109\n");
    }

    @AfterEach
    void afterEach1() {

        System.out.println("---添加购物车---");
    }

    @AfterAll
    static void afterAll1() {
        System.out.println("---进入购物车列表，生成订单，进行订单付款---");
        System.out.println(output.toString());
    }

    @DisplayName("qax4")
    @RepeatedTest(value = 3, name = "重复搜索次数 {currentRepetition}/{totalRepetitions}")
    void qax4(RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        System.out.println("第" + currentRepetition + "次搜索 查看第 " + currentRepetition + "个商品详情");
    }

    @DisplayName("ijn7")
    @ParameterizedTest
    @ValueSource(ints = {20220109, 20220109, 20220109})
    void ijn7(String num) {
        System.out.println("---点击查看第" + num + "个商品详情---");
        output.append("下单日期为20220101\n");
    }

    @DisplayName("fre8")
    @ParameterizedTest
    @ValueSource(ints = {20220109, 20220109, 20220109})
    void fre8(int date) {
        System.out.println("---点击查看第 8 个商品详情---");
        System.out.println("下单日期为：" + date + "\n");
        output.append("下单日期为：" + date + "\n");
    }

    @DisplayName("olk9")
    @ParameterizedTest
//    @NullSource
//    @EmptySource
    @NullAndEmptySource
    @ValueSource(strings = {"2", "9", "19"})
    void olk9(String num) {
        System.out.println("---点击查看第 " + num + " 个商品详情---");
        output.append("下单日期为20220109\n");
    }

    @DisplayName("qwe51")
    @ParameterizedTest
    //只需要一个参数
    //声明指定参数的方法名
    @MethodSource
    void qwe51(int date) {
        System.out.println("---点击查看第 10 个商品详情---");
        System.out.println("下单日期为：" + date + "\n");
        output.append("下单日期为：" + date + "\n");
    }

    //使用的是包装类
    static Stream<Integer> intDate1() {
        return Stream.of(20220109, 20220119, 20220122);
    }

    static List<Integer> intDate2() {
        return Arrays.asList(20220209, 20220219, 20220222);
    }

    static IntStream intDate3() {
        return IntStream.of(20220309, 20220319, 20220322);
    }

    static int[] intDate4() {
        return new int[]{20220409, 20220419, 20220422};
    }


    @DisplayName("strData3")
    @ParameterizedTest
    @MethodSource
    void strData3(String num) {
        System.out.println("---点击查看第 " + num + " 个商品详情---");
        output.append("下单日期为20220209\n");
    }

    static String[] strData1() {
        return new String[]{"2", "6", "8"};
    }

    static List<String> strData2() {
        return Arrays.asList("12", "16", "18");
    }

    static Stream<String> strData3() {
        return Stream.of("22", "26", "28");
    }

    @DisplayName("twelveTest0")
    @ParameterizedTest
    //默认方法名参数化
//    @MethodSource
    //声明对应方法名
    @MethodSource("moreData")
    void twelveTest0(String num, int date, List<String> list) {
        System.out.println("---点击查看第 " + num + " 个商品详情---");
        System.out.println("下单日期为：" + date + "\n");
        System.out.println(list);
        output.append("下单日期为：" + date + "\n");
    }

    static Stream<Arguments> twelveTest() {
        return Stream.of(
                arguments("2", 20220409, Arrays.asList("查看", "详情")),
                arguments("6", 20220419, Arrays.asList("Hello", "world")),
                arguments("8", 20220422, Arrays.asList("参数化", "用例"))
        );
    }

    static Stream<Arguments> moreData() {
        return Stream.of(
                arguments("12", 20220609, Arrays.asList("搜索", "结果")),
                arguments("16", 20220619, Arrays.asList("你好", "世界")),
                arguments("18", 20220622, Arrays.asList("junit5", "test"))
        );
    }



    public static Stream<Arguments> selfdata = Stream.of(
            arguments("22", 20220709, Arrays.asList("自定义搜索", "结果")),
            arguments("26", 20220719, Arrays.asList("自定义你好", "世界")),
            arguments("28", 20220722, Arrays.asList("自定义junit5", "test"))
            );

    @ParameterizedTest
    @VariableSource("selfdata")
    @DisplayName("selfdataTest78")
    void selfdataTest78(String num, int date, List<String> list) {
        System.out.println("---点击查看第 " + num + " 个商品详情---");
        System.out.println("下单日期为：" + date + "\n");
        System.out.println(list);
    }



        @ParameterizedTest
        @ArraySources(
                arrays = {
                        @ArraySource(array = {1, 2, 3}),
                        @ArraySource(array = {4, 5, 6}),
                        @ArraySource(array = {7, 8, 9})
                }
        )
        @DisplayName("example678")
    void example678(int[] array) {
        System.out.println(Arrays.toString(array));
        System.out.println("Test Over");
    }

}







