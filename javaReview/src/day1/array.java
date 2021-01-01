package day1;

import org.junit.Test;

public class array {
    /*
    * 数组对象也是引用对象
    * 将数组赋值给另一个数组就是赋值一个引用
    * 两个数组对象本质上是同一个数组对象
    * */
    @Test
    public void testArray(){
        int[] num1 = {1,2,3,4,5};
        int[] num2 = num1;
        num1[0] = 10;
        num1[1] = 20;
        num1[2] = 30;
        num1[3] = 40;
        num1[4] = 50;
        /*for (int i : num2) {
            System.out.println(i);
        }*/
        System.out.println(num1 == num2);//true
    }

    @Test
    public void testInstanceOf(){
        int i = 3;
        //System.out.println(i instanceof Integer);//编译不通过,i必须是引用类型
        //System.out.println(i instanceof Object);//编译不通过

        Integer a = 10;
        System.out.println(a instanceof Integer);//true
        System.out.println(a instanceof Object);//true

        //在javase中规定instanceof的运算规则:如果object为null,则返回false
        System.out.println(null instanceof Object);//false
        }

        /*
        * public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
          }
        * 在通过value方法创建Integer对象时,如果数值在[-128,127]之间,
        * 则返回IntegerCache.cache[]中已有的对象引用,否则创建一个新的Integer对象
        * */
    @Test
    public void testInteger(){
        Integer a=100;
        Integer b=100;
        Integer c=200;
        Integer d=200;
        System.out.println(a==b);//true
        System.out.println(c==d);//false

    }

    /*
    * public static Double valueOf(double d) {
        return new Double(d);
    }
        在创建Double对象时都是直接创建新对象,可能是精度问题吧,
    * */
    @Test
    public void testDouble(){
        Double a = 100.0;
        Double b = 100.0;
        Double c = 200.0;
        Double d = 200.0;
        System.out.println(a==b);//false
        System.out.println(c==d);//false
    }
}
