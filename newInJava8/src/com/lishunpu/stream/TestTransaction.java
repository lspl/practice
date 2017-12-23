package com.lishunpu.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lishunpu on 2017/5/22.
 */
public class TestTransaction {
    List<Transaction> transactions = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan,  2012, 950)
        );
    }

    //1. 找出2011年发生的所有交易，并按交易额排序（从低到高）
    @Test
    public void test1() {
        List<Transaction> ts = transactions.stream().filter(t->t.getYear()==2011).sorted((t1,t2)->Integer.compare(t1.getValue(), t2.getValue())).collect(Collectors.toList());
        ts.forEach(System.out::println);
    }

    //2. 交易员都在哪些不同的城市工作过？
    @Test
    public void test2() {
        transactions.stream().map(x->x.getTrader().getCity()).distinct().forEach(System.out::println);
    }

    //3. 查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test3() {
        transactions.stream().map(t->t.getTrader()).filter(x->x.getCity().equals("Cambridge")).distinct().sorted((x,y)->(x.getName().compareTo(y.getName()))).forEach(System.out::println);
//        transactions.stream().map(Transaction::getTrader()).filter(x->x.getCity().equals("Cambridge")).distinct().sorted((x,y)->(x.getName().compareTo(y.getName()))).forEach(System.out::println);
    }

    //4. 返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void test4() {
        transactions.stream().map(t->t.getTrader().getName()).distinct().sorted().forEach(System.out::println);
    }

    //5. 有没有交易员是在米兰工作的？
    @Test
    public void test5() {
        //System.out.println(transactions.stream().map(t->t.getTrader().getCity()).filter(x->x.equals("Milan")).distinct().count());
        System.out.println(transactions.stream().anyMatch((t)->t.getTrader().getCity().equals("Milan")));
    }

    //6. 打印生活在剑桥的交易员的所有交易额
    @Test
    public void test6() {
        //transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge")).map(x->x.getValue()).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println(transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).reduce(Integer::sum).get());
    }
    //7. 所有交易中，最高的交易额是多少
    @Test
    public void test7() {
        System.out.println(transactions.stream().map(x->x.getValue()).collect(Collectors.maxBy(Integer::compare)).get());
        System.out.println(transactions.stream().map(x->x.getValue()).max(Integer::compare).get());
    }

    //8. 找到交易额最小的交易
    @Test
    public void test8() {
        System.out.println(transactions.stream().min((x,y)->Integer.compare(x.getValue(),y.getValue())).get());
    }

}
