package com.lishunpu.stream;

import com.lishunpu.lambdaexercise.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lishunpu on 2017/5/22.
 */
/*
    1. 创建Stream
    2. 中间操作：filter, distinct, limit, skip
    3. 终止操作
    多个中间操作可以连接起来形成一个流水线，除非流水线触发终止操作，否则
中间操作不会执行任何的处理！而在终止操作时一次性全部处理，称为“惰性求值”。
 */
public class TestStreamAPI1 {
    //创建Stream
    @Test
    public void test1() {
        //1. 通过Collection系列结合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2. 通过Arrays中的静态方法stream获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3. 通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa","bb","cc");

        //4. 创建无限流
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2); //从0开始，每次加2. 0为起始值
        stream4.limit(10).forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(12,34,4324,234,54,654,13,34,4324,654 );
        Stream<Integer> stream = list.stream().filter((x) -> {
            System.out.println("Stream API的中间操作");
            return x>34;
        });
        //内部迭代：迭代操作由Stream API完成
        stream.forEach(System.out::println);

        //limit: 得到满足条件的元素个数后就不再继续运行
        list.stream().filter(x -> x>34).limit(2).forEach(System.out::println);

        //skip: 跳过元素，返回一个扔掉了前n个元素的流。若流中元素个数不足n, 则返回一个空流，与limit(n)互补
        list.stream().filter(x -> x>34).skip(2).forEach(System.out::println);

        System.out.println("分割线");
        //distinct: 通过流生成元素的hashCode()和equals()去除重复元素。因此，对于对象，必须覆盖其hashCode()和equals()方法, 自动生成就行
        list.stream().distinct().forEach(System.out::println);
    }

    //映射
    //map: 接受Lambda，将元素转换成其它形式或提取信息。接受一个函数作为参数，该桉树会被应用到每个元素上，并将其映射成一个新的元素
    //flatMap： 接受一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
    //map与flatMap的关系类似与list的add与addAll.
    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(12,34,4324,234,54,654,13,34,4324,654 );
        list.stream().map(x -> x+10000).forEach(System.out::println);
    }

    List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 8888, Employee.Status.BUSY),
            new Employee("李四", 43, 7777, Employee.Status.FREE),
            new Employee("王五", 59, 4444, Employee.Status.VOCATION),
            new Employee("赵六", 38, 2421, Employee.Status.FREE),
            new Employee("田七", 24, 5677, Employee.Status.VOCATION)
    );

    /*规约
      reduce(Integer identity, BinaryOperator<Integer> accumulator)
    */
    @Test
    public void test4() {
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
        System.out.println(list.stream().reduce(0, (x,y) -> x+y));

        //计算所有员工的工资总和
        Optional<Integer> op = emps.stream().map(Employee::getSalary).reduce(Integer::sum);
        System.out.println(op.get());
    }

    /*
    收集:
    colllect--将流转换为其它形式。接收一个Collector接口的实现，用于给Stream中元素进行汇总
     */
    @Test
    public void test5() {
        List<String> list = emps.stream()
                                .map(Employee::getName)
                                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("------我是分割线-------");
        //将所有员工的姓名放入set中
        HashSet<String> hs = emps.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        hs.forEach(System.out::println);

        //获取员工总数
        System.out.println(emps.stream().collect(Collectors.counting()));

        //获取员工平均工资
        System.out.println(emps.stream().collect(Collectors.averagingDouble(Employee::getAge)));

        //获取员工总工资
        System.out.println(emps.stream().collect(Collectors.summingInt(Employee::getSalary)));

        //获取最高工资的员工
        Optional<Employee> e3 = emps.stream().collect(Collectors.maxBy((e1,e2)->Integer.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(e3.get());

        //获取工资的最小值
        Optional<Integer> i2 = emps.stream().map(Employee::getSalary).collect(Collectors.minBy(Integer::compare));
        System.out.println(i2.get());
    }

    //分组
    @Test
    public void test6() {
        Map<Employee.Status, List<Employee>> map = emps.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    //多级分组
    @Test
    public void test7() {
        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((Employee e) -> {
            if (e.getAge() <= 35) {
                return "青年";
            } else if (e.getAge() <= 50) {
                return "中年";
            } else {
                return "老年";
            }
        })));
        System.out.println(map);
    }

    //分区
    @Test
    public void test8() {
        Map<Boolean, List<Employee>> map = emps.stream().collect(Collectors.partitioningBy(e->e.getSalary()>6666));
        System.out.println(map);
    }

    //统计特性
    @Test
    public void test9() {
        DoubleSummaryStatistics dss = emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getAverage());
        System.out.println(dss.getMax());
        System.out.println(dss.getMin());
        System.out.println(dss.getCount());
        System.out.println(dss.getSum());
    }

    //
    @Test
    public void test10() {
        System.out.println(emps.stream().map(Employee::getName).collect(Collectors.joining()));
        System.out.println(emps.stream().map(Employee::getName).collect(Collectors.joining(",")));
        System.out.println(emps.stream().map(Employee::getName).collect(Collectors.joining(",","-","+")));
    }
}
