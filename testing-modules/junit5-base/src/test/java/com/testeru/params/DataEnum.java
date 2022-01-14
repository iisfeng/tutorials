package com.testeru.params;

/**
 * @program: tutorials
 * @author: 盖盖
 * @description:
 * @Version 1.0
 * @create: 2022/1/11 4:32 下午
 */
public enum DataEnum {
    ONE("one","这是一个搜索用例",20220601),
    Three("three","这是三个搜索用例",20220603),
    Four("four","这是四个搜索用例",20220605),
    TWO("two","这是第二个搜索用例",20220607),
    Five("five","这是5个搜索用例",20220609);

    private final String name;
    private final String duration;
    private final int id;

    DataEnum(String name, String duration, int id) {
        this.name = name;
        this.duration = duration;
        this.id = id;
    }


    @Override
    public String toString() {
        return "DataEnum{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", id=" + id +
                '}';
    }
}
