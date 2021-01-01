package day2;

import org.junit.Test;

public class TestMath {

    /*
    * Math中的取整方法
    *   ceil  : 天花板,向上取整,  return double
    *   floor : 地板,向下取整     return double
    *   round : 大约,算法是Math.floor(x+0.5) return long
    *
    * */
    @Test
    public void TestCeilFloorRound(){
        System.out.println(Math.ceil(11.4));//12.0
        System.out.println(Math.ceil(11.8));//12.0

        System.out.println(Math.floor(11.4));//11.0
        System.out.println(Math.floor(11.8));//11.0

        System.out.println(Math.round(11.2));//11
        System.out.println(Math.round(11.5));//12
        System.out.println(Math.round(-11.5));//-11

    }
}
