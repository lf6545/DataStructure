package day1;

import javax.xml.bind.annotation.XmlType;

/*
* 重写:
*   1,发生在子类和弗雷之间
*   2,方法名,返回值类型,参数列表(子类中方法的返回值类型可以使父类方法返回值类型的子类)必须相同
*   3,子类方法访问权限一定不小于父类的(public>protect>default>private)
*   (父类私有子类也继承不了)
*   4,重写方法不能抛出新的异常检查或者比父类方法声明更加宽泛的检查型异常
*
* 重载:
*   1,是一个类中多态性的表现
*   2,要求同名方法的参数列表不同(参数个数,参数类型甚至顺序不同)
*   3,返回值类型可以相同或不相同,无法以返回值类型不同作为区分重载的标准
*
* */
public class OverrideAndOverload {

    public class Father{
        void say(){
            System.out.println("Father:Hi~Son~");
        }

        int say(String name){
            System.out.println("这是个重载方法!有一个参数name:"+name);
            return 1;
        }
    }
    public class Son extends Father{
        //重写,对父类的方法重新写,子类继承了父类的方法
        //在保持方法名,返回值类型,参数列表和父类相同的同时,对方法体修改或重写.
        //要注意的是子类方法的访问权限不能少于父类,如父类protect,子类重写方法可以是public或protect
        @Override
        protected void say() {
            super.say();
            System.out.println("Son:Hi~Father~");
        }
    }
}
