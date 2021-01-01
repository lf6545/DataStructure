package DataStructure.ArrayAndList.test;

import DataStructure.ArrayAndList.LinkList;


public class TestLinkList {
    public static void main(String[] args) {
        LinkList<String> list = new LinkList<>();

        list.insert("AAA");
        list.insert("BBB");
        list.insert("CCC");
        list.insert("DDD");
        list.insert("EEE");
        list.insert("FFF");




//        System.out.println("插入数据完成!遍历查看:");
//        for (String s : list) {
//            System.out.println(s);
//        }
//
//        System.out.println("插入节点'FFF'后遍历:");
//        list.insert("FFF");
//
//        for (String s : list) {
//            System.out.println(s);
//        }
//
//        System.out.println("定点3处插入'XXX'后遍历:");
//        list.insert("XXX",3);
//
//        for (String s : list) {
//            System.out.println(s);
//        }

//        System.out.println("删除:"+list.remove(1));
//        System.out.println("删除1位置后遍历:");
//        for (String s : list) {
//              System.out.println(s);
//        }
//
//        System.out.println("删除:"+list.remove(5));
//        System.out.println("删除5位置后遍历:");
//        for (String s : list) {
//            System.out.println(s);
//        }

//        System.out.println("第六个元素:"+list.get(6));
//        System.out.println("第三个元素:"+list.get(3));

//        System.out.println("DDD在第几个?"+list.indexOf("DDD"));
//        System.out.println("FFF在第几个?"+list.indexOf("FFF"));

//        for (String s : list) {
//            System.out.println(s);
//        }
//        list.clear();
//        System.out.println("清空元素后:");
//        for (String s : list) {
//            System.out.println(s);
//
//        }
//        System.out.println(list);

        //链表反转
//        System.out.println("链表正常顺序:");
//        for (String s : list) {
//            System.out.println(s);
//        }
//        //list.reverse();
//        list.re();
//        System.out.println("链表反转后:");
//        for (String s : list) {
//            System.out.println(s);
//        }

        //快慢指针获取中间元素
        //System.out.println(list.getMid("AAA"));

        //快慢指针判断链表是否有回路
//        LinkList loopList = list.getLoopList();
//        if (loopList.hasLoop(loopList.hasLoop())){
//            System.out.println("链表loopList有回路");
//            System.out.println("回路入口是: "+loopList.getEntrance());
//        }

        LinkList cycleList = list.getCycleList();
        System.out.println("问题链表:");
        for (Object o : cycleList) {
            System.out.println(o);
            if (o.equals(41)){
                break;
            }
        }
        System.out.println("报数自杀幸存的两个:");
        System.out.println("删除过程:");
        LinkList survivor = list.reduce(cycleList);
        //约瑟夫和它朋友最后两个死就行
    }

}
