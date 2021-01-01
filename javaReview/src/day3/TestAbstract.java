package day3;

import org.junit.Test;

public class TestAbstract {
    @Test
    public void testabstract(){
        AbstractClass ac1 = new AbstractClass() {
            @Override
            public void fun1() {
                System.out.println("创建AbstractClass时需要传入具体实现");
            }
        };
        //通过子类创建
        AbstractClass ac2 = new CommonClass();

        ac1.fun1();
        ac1.fun2();
        ac2.fun1();
        ac2.fun2();
    }

}
