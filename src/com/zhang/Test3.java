package com.zhang;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author zph
 * @version 1.0
 */
public class Test3 {
    List<User> users = UserDB.users;
    @Test
    /**
     * 匹配与查找中断操作
     */
    public void test(){
        /**
         * allMatch(Predicate p)查看stream每个元素是否匹配所满足这个p断言
         * 练习:判断所有user的年龄是否都大于18岁
         */
//        boolean flag = users.stream().allMatch(new Predicate<User>() {
//            @Override
//            public boolean test(User user) {
//                return user.getAge()>18;
//            }
//        });
        //上面是匿名内部类的方式，这里用lambda表达式进行简化.
        boolean flag = users.stream().allMatch(user -> user.getAge()>18);
        System.out.println(flag);
        /**
         * anyMatch(Predicate p)查看stream每个元素是否至少有一个满足这个p断言，有一个满足就返回true,否则false
         */
        boolean b = users.stream().anyMatch(user -> user.getAge() <= 19);
        System.out.println(b);
        /**
         * noneMatch(predicate p)是第一种的对立面，相当于取反的操作，都不满足这个p规则就返回true,有一个满足返回false
         */
        boolean b1 = users.stream().anyMatch(user -> user.getAge() < 19);
        System.out.println(b1);
    }

        @Test
        public void test1(){
            /**
             * findFirst返回第一个元素,可以在这个进行之前进行一些过滤操作
             */
            Optional<User> first = users.stream().findFirst();
            System.out.println(first);

            /**
             * finaAny返回当前stream中的任意元素,只有第一次执行才是返回任意一个元素，重复执行是返回同一个元素
             */
            Optional<User> any = users.parallelStream().findAny();
            System.out.println(any);

        }

    @Test
    public void Test2(){
        /**
         * count-进行之前可以进行一些过滤操作，返回stream中的个数
         */
        //返回年龄大于20的user数
        long count = users.stream().filter(user -> user.getAge()>20).count();
        System.out.println(count);

        /**
         * max(Comparator com)-返回流中一个最大值
         */
        //练习查询年龄最大的数
        Optional<Integer> max = users.stream().map(user -> user.getAge()).max(Integer::compare);
        System.out.println(max);

        //练习查询年龄最小的
        Optional<Integer> min = users.stream().map(user -> user.getAge()).min(Integer::compare);
        System.out.println(min);

        /**
         * foreach(Consumer c)就是内部迭代,传入一个消费者的实现类对象
         */
        users.stream().forEach(System.out::println);//这是对stream的终止操作
        System.out.println("===============");
        users.forEach(System.out::println);//这是集合中的default遍历方法
    }
}
