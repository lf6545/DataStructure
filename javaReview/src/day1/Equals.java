package day1;

import org.junit.Test;
import sun.security.util.AuthResources_it;

/*
* equals和==的区别
*
* */
public class Equals {

    /*
    * ==
    *   1, 比较的是两边的操作数是否是同一对象,
    *   2, 两边操作数必须是同一类型,不然编译不通过
    *   3, 阿拉伯数值比较的是值(基本数据类型参与的比较,比较的是数值)
    *
    * */
    @Test
    public void testIs(){
        int a = 10;
        long b = 10L;
        float c = 10.0f;
        double d = 10.0d;
        Integer e = 10;
        Float f = 10.00f;
        Double g = 10.000d;
        int a1 = 200;
        Integer a2 = 200;
        Integer a3 = 200;

        System.out.println(a1 == 2);//true
        System.out.println(a3==a2);//比较的是俩对象地址值false
        System.out.println(a==b);//true
        System.out.println(a==c);//true
        System.out.println(a==d);//true
        System.out.println(a==e);//true
        System.out.println(a==f);//true
        System.out.println(a==g);//true
    }

    @Test
    public void testEquals(){

        Integer e = 10;
        Float f1 = 10.00f;
        Float f2 = 10.0f;
        Double g = 10.000d;

        Integer a2 = 200;
        Integer a3 = 200;
        String s1 = null;
        String s2 = null;
        System.out.println(a2.equals(a3));//true
        System.out.println(f1.equals(f2));//true
        System.out.println(s1.equals(s2));//java.lang.NullPointerException
    }

    /*
    * String中重写的equals方法
    * public boolean equals(Object anObject) {
        if (this == anObject) {//先判断是不是同一个对象
            return true;
        }
        if (anObject instanceof String) {//判断是不是String的实例
            String anotherString = (String)anObject;//强转
            int n = value.length;
            if (n == anotherString.value.length) {//逐个字符比较
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i])//出现不同字符返回false
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;//String对象和其他对象比较直接返回false
    }
    *
    *
    * */
    @Test
    public void testEqualsString() {
        String s1 = "helloWord";
        String s2 = "hello";
        char[] s3 = {'h','e','l','l','o'};
        System.out.println(s2.equals(s3));//false  不同对象
        System.out.println(s1.equals(s2+"Word"));//true
    }
}
