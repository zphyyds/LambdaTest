package com.zhang.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * @author zph
 * @version 1.0
 */
public class Test1 {



    @Test
    /**
     * 当 -> 左边没有参数或者有两个参数以上的情况不可以省略()
     * 当 —> 右边只有一条语句的时候可以省略 {}
     */
    public void test() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我正在吃饭.....");
            }
        };
        runnable.run();
        System.out.println("lambda简写之后....");
        Runnable runnable1 = () -> System.out.println("我正在打游戏呢...");
        runnable1.run();
    }

    @Test
    /**
     * 当 ->左边有两个参数的时候()不可以被省略，但是参数类型无论是一个参数还是多个参数都可以被省略
     * 当 -> 右边有返回值且只有一条语句的时候可以把return和{}都省略掉,只有一条输出语句同样可以省略{}
     */

    public void test1(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(12, 21));
        System.out.println("lambda简化以后....");
        Comparator<Integer> comparator1 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(comparator1.compare(21, 12));
    }

    @Test
    public void test2(){
        System.out.println("hello");
    }
}
