package day2;

import org.junit.Test;

import java.awt.*;

public class TestAndBreak {
    /*
    * &和&&
    * 操作数限制 : 两边操作数不分别为int和boolean
    *             &&两边不能都为int,他把0,1也视为int
    *             &两边可以都为int,但执行的是按位取反
    *   相同点 : 都可以做与运算,
    *   区别 :
    *       && : 具有短路作用,当运算符左边语句执行为false时,右边的语句不会再执行
    *       &  : 还可以作为位运算符,当两边操作数不是boolean类型时,按位取反运算,取整数的后4个bite位
    * */
    @Test
    public void test1(){
        int i = 2;
        //++i执行了
        System.out.println((1>3)&(++i>2));//false
        System.out.println(i);//3
        //true $$ ++i执行了
        System.out.println((3>1)&&(++i>3));//true
        System.out.println(i);//4
        //false && ++i没有执行
        System.out.println((3>6)&&(++i>4));//false
        System.out.println(i);//4

    }


    /*
    *
    * 跳出嵌套循环
    *   1, 循环里用break;结束循环
    * */
    @Test
    public void test2(){
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j]==5){

                    System.out.println("j="+j);
                    break;
                }

            }
        }
        System.out.println("出来了");
    }

    @Test
    public void test3(){
        short i =1;
        //i = i+1; //i+1为int类型,赋值会报强制类型转换错误
        i+=1;
        char c = '中';

        //2 : 0000010
        //16: 0010000
        System.out.println(2 << 3);//2*2^3

    }


    /*
    * 实例变量和静态变量
    * 实例变量 :在对象实例化的时候实例变量才分配内存空间
    * 静态变量 :当程序加载类的字节码文件时,飞静态变量分配内存空间
    *
    * */
    @Test
    public void test4(){

        VariantTest v1 = new VariantTest();
        VariantTest v2 = new VariantTest();
        VariantTest v3 = new VariantTest();
        VariantTest v4 = new VariantTest();
//  v1  staticVar = 1 , instanceVar = 1
//  v2  staticVar = 2 , instanceVar = 1
//  v3  staticVar = 3 , instanceVar = 1
//  v4  staticVar = 4 , instanceVar = 1

    }
}
