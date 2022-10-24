package com.zhang;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author zph
 * @version 1.0
 */
public class StreamTest1 {

    List<User> users = UserDB.users;

    /**
     * 通过stream进行集合数据源的中间操作
     */
    @Test
    public void test() {

        //通过list得到stream
        Stream<User> stream = users.stream();
        /**
         * filter方法对数据源进行过滤，下面进行的过滤是找出list中年龄大于20的user
         */
        stream.filter(user -> user.getAge() > 20).forEach(System.out::println);

    }

    @Test
    public void test1() {
        /**
         * limit(n)-截断流，使输出的元素不超过n这个数量
         * 注意当上面的stream在执行foreach方法后就会关闭，需要重新创建stream
         */
        Stream<User> stream1 = users.stream();
        stream1.limit(3).forEach(System.out::println);
    }

    @Test
    public void test2() {
        /**
         * skip(n)-跳过前面n个元素，返回跳过之后剩余的元素
         */
        Stream<User> stream1 = users.stream();
        stream1.skip(3).forEach(System.out::println);
    }

    @Test
    public void test3(){
        /**
         * distinct-刷选，通过数据源所生成的hashcode()和equals()去除重复元素
         * 只要在对应的User中重写hashcode和equals方法即可，在调用distinct方法的时候会自动根据规则去重
         */

        users.add(new User(7,"刘强东","12345",40));
        users.add(new User(7,"刘强东","12345",40));
        users.add(new User(7,"刘强东","12345",40));
        users.add(new User(7,"刘强东","12345",40));
        users.add(new User(7,"刘强东","12345",40));

        Stream<User> stream = users.stream();
        stream.distinct().forEach(System.out::println);

    }

    @Test
    public void test4(){
        /**
         * map(Function f)接收一个function函数对象作为参数，把list中的每一个元素映射成一个新元素进行返回
         * 这是function接口中的R apply(T t)抽象方法,接收一个T对象然后映射成R对象进行返回;
         * 比如下面代码就是接收一个小写的str之后映射成大写进行返回
         */
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd");
        strings.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //练习姓名长度大4的用户的姓名
        Stream<User> stream = users.stream();
        //首先将每个userStream映射成一个只有名字的stream
        Stream<String> namesStream = stream.map(user -> user.getUsername());
        //然后在filter得到大于23的名字
        namesStream.filter(e -> e.length()>4).forEach(System.out::println);
    }

    @Test
    public void test5(){
        /**
         * flatMap(function f)接收一个函数作为参数，将流中的每一个值换成另外一个流，再将这些流连接成一个流
         * 当一个集合中又有其他集合，想得到外层集合中的每一个元素还想得到内部集合中的每一个元素推荐使用这个方法
         */
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd");
        Stream<Character> characterStream = strings.stream().flatMap(StreamTest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }
    //将原来的String打散成cha并把这个变成一个流
    public static Stream<Character> fromStringToStream(String str){
        ArrayList list =new ArrayList();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test6(){

        /**
         * sorted()-自然排序
         */
        List<Integer> list = Arrays.asList(12,43,8,23,1,67,34);
        list.stream().sorted().forEach(System.out::println);

        //如果想实现User的排序就要让User实现Comparable接口，定制排序规则，或者直接使用下面的方法实现定制排序
        Stream<User> stream = users.stream();
        stream.sorted().forEach(System.out::println);
    }

    @Test
    public void test7(){

        /**
         * sorted(Comparator com)
         * 把user对象根据年龄进行排序
         */
        users.stream().sorted((e1,e2) -> {
            //得到年龄的差值，这个compare函数是根据是正数还是负数来进行排序的
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0){
                //如果年龄不相等就正常排序即可
                return ageValue;
            }else {
                //如果年龄相等就根据名字的长度进行排序
                return Integer.compare(e1.getId(),e2.getId());
            }
        }).forEach(System.out::println);
    }

    @Test
    public void test8(){
        System.out.println("hello git");
    }
}
