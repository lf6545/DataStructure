package DataStructure.ArrayAndList.test;

import DataStructure.ArrayAndList.TwoWayLinkList;

public class TestTwoWayLinkList {
    public static void main(String[] args) {

        TwoWayLinkList<String> list = new TwoWayLinkList<>();

        list.insert("张三");
        list.insert("李四");
        list.insert("王五");
        list.insert("赵六");
        list.insert("田七");

//        System.out.println("插入五个数据后,遍历:");
//        for (String s : list) {
//            System.out.println(s);
//        }
//
//        System.out.println("第三个元素是:"+list.get(3));
//        System.out.println("查询第五个元素"+list.get(5));
//        list.insert("赵六点五",5);
//        System.out.println("在第五个元素处插入新元素'赵六点五'!");
//        System.out.println("查询第五个元素"+list.get(5));
//
//        System.out.println("遍历链表:");
//        for (String s : list) {
//            System.out.println(s);
//        }
//        System.out.println("删除第五个元素:"+list.remove(5));
//        System.out.println("删除后遍历链表");
//        for (String s : list) {
//            System.out.println(s);
//        }
//
//        System.out.println("第一个元素:"+list.getFirst());
//        System.out.println("最后一个元素:"+list.getLast());
//
//        System.out.println("田七在链表中第几个? "+list.indexOf("田七"));
//        System.out.println("查找链表中不存在的元素'王八'的索引: "+list.indexOf("王八"));

//        System.out.println("链表长度:"+list.length());
//        System.out.println("清空链表");list.clear();
//        System.out.println("链表长度:"+list.length());


        int[] a = new int[10];
        System.out.println(a.length);
    }
}
