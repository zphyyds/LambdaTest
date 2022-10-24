package com.zhang;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author zph
 * @version 1.0
 */
public class Test4 {

    List<User> users = UserDB.users;

    @Test
    public void test(){

        /**
         * T是初始值,后面是具体的操作
         * reduce(T identity,BinaryOperator)归一可以将流中的元素反复结合起来得到一个值
         */
        //练习计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);//在内部会自动加
        System.out.println(sum);

        /**
         * reduce(BinaryOperator)将流中的每个元素进行结合，最后返回一个optional对象
         */
        //返回年龄的总和
        Optional<Integer> sum1 = users.stream().map(user -> user.getAge()).reduce(Integer::sum);
        Optional<Integer> sum2 = users.stream().map(user -> user.getAge()).reduce((d1,d2) -> d1+d2);
        System.out.println(sum1);
        System.out.println(sum2);

    }

    @Test
    public void test2(){

        /**
         * collect(collector c)将stream数据收集到集合中进行返回
         */
        //比如得到一个年龄大于20的user集合
        List<User> userList = users.stream().filter(user -> user.getAge() > 20).collect(Collectors.toList());
        userList.forEach(System.out::println);

        System.out.println();
        Set<User> userSet = users.stream().filter(user -> user.getAge() > 20).collect(Collectors.toSet());
        userSet.forEach(System.out::println);
    }
}
