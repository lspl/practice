package builder;

/**
 * from： http://baike.baidu.com/link?url=23OjFq_49EbYhZ10G9Dly5nk0m_SCpMZ74qBCoz4zdeFZAuX_cAmvHMHay-hY8nUyZh7noCz9w8SfoKQbYtfOPTSWMJkAaM3kV_StCA56Qmf66kdgwJSCk55ijQZNkMk-84IU_ANvEgCk3_YsB0tnq
 * @author lishunpu
 * @create 2017-07-16 16:35
 *
 * note: 建造者模式
 *      将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式
 * 适用范围：
 *  ① 当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时
 *  ② 当构造过程必须允许被构造的对象有不同表示时
 */
public class Test {
    public static void main(String[] args) {
        PersonDirector pd = new PersonDirector();
        Person person = pd.constructPerson(new ManBuilder());
        System.out.println(person.getBody());
        System.out.println(person.getFoot());
        System.out.println(person.getHead());
    }
}
