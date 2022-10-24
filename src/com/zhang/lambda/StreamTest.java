package com.zhang.lambda;

/**
 * @author zph
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 实例化stream的方法
 */
public class StreamTest {
    public static void main(String[] args) {

        /**
         * 创建stream方式一:通过集合的默认方法创建
         */
        List<User> userList = new ArrayList<>();
        //List接口中的一个默认方法，jdk8新特性
        //这个方式得到的stream是一个顺序流
        Stream<User> stream = userList.stream();
        //这个方式得到的是一个并行流
        Stream<User> Stream1 = userList.parallelStream();

        /**
         * 创建Stream方式二:通过数组创建
         */
        int[] arr = {1,2,3,4,5,6};
        //调用arrays类中的stream方法来实例
        IntStream stream2 = Arrays.stream(arr);

        User u1 = new User(1, "zhangsan", "123456",23);
        User u2 = new User(2, "zhangsan", "123456",34);
        User u3 = new User(3, "zhangsan", "123456",45);

        User[] users = {u1,u2,u3};
        Stream<User> stream3 = Arrays.stream(users);

        /**
         * 创建stream方式三:通过stream.of()
         */
        Stream<Integer> Stream4 = Stream.of(1, 2, 3, 4, 5, 6);

        /**
         * 创建stream方式4:创建无限流
         */
        Stream.iterate(0,t -> t+2).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}
