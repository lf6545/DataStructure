package DataStructure.TableTreeHeap.test;

import DataStructure.ArrayAndList.QueueByList;
import DataStructure.TableTreeHeap.BinaryTree;
import org.junit.Before;
import org.junit.Test;


/*
* 测试二叉查找树
* */
public class TestBinaryTree {

    public static void main(String[] args) {
        //创建二叉查找树对象
        BinaryTree<Integer, String> tree = new BinaryTree<>();

        //测试插入
        tree.put(13,"James Harden");
        tree.put(5,"Kevin Garnett");
        tree.put(11,"Kyrie Irving");
        tree.put(23,"Lebron James");
        tree.put(0,"Ressull Westbrook");
        tree.put(7,"Kevin Durant");
        tree.put(3,"Alen Iverson");
        tree.put(30,"Steph Curry");
        tree.put(34,"Yannis Adetokounbo");
        tree.put(10,"Tim Hardaway");
        tree.put(14,"Brandon Ingram");
        tree.put(39,"Dwight Howard");
        tree.put(2,"凯里-欧文");
        tree.put(1,"Tracy McGrady");
        tree.put(4,"Victor Oladipo");
        tree.put(77,"Luka Dincic");
        tree.put(6,"勒布朗-詹姆斯");
        tree.put(35,"凯文-杜兰特");
        tree.put(8,"科比-布莱恩特");
        tree.put(9,"Tony Parker");
        tree.put(24,"Kobe Bryant");


        //测试get
//        tree.get(11);
//        tree.get(2);
//        tree.get(77);
//
//        System.out.println("二叉树中有多少个元素?? "+tree.size());
//
//        tree.get(5);
//        tree.getLeft(5);//key=5节点的left是key=0的节点
//        tree.delete(0);//删掉key为0的节点
//        tree.get(0);//0节点不存在了
//        tree.getLeft(5);//0节点被3节点替换,所以5节点的left是3节点
//
//        tree.getLeft(1);//1节点是叶子节点,左右子节点都为null
//        tree.getRight(1);
//

        System.out.println("最小的键"+tree.min());
        System.out.println("最大的键"+tree.max());

        QueueByList<Integer> preQueue = tree.preErgodic();

        QueueByList<Integer> midQueue = tree.midErgodic();
        System.out.println("中序遍历:");
        for (int i = 0; i < 22; i++) {
            midQueue.dequeue();
        }


    }

    @Test
    public void testErgodic(){
//        //创建二叉查找树对象
//        BinaryTree<Character, Integer> tree = new BinaryTree<>();
//        tree.put('F',100);
//        tree.put('G',200);
//        tree.put('H',300);
//        tree.put('B',50);
//        tree.put('A',10);
//        tree.put('D',70);
//        tree.put('C',60);
//        tree.put('E',80);

        //前序遍历
        QueueByList<Character> preQueue = tree.preErgodic();
        System.out.println("=========================================");
        System.out.println("前序遍历");
        for (int i = 0; i < 8; i++) {
            preQueue.dequeue();
        }

        System.out.println("***********************************************");

        //中序遍历
        QueueByList<Character> midQueue = tree.midErgodic();
        System.out.println("=========================================");
        System.out.println("中序遍历");
        for (int i = 0; i < 8; i++) {
            midQueue.dequeue();
        }

        System.out.println("***********************************************");
        //后序遍历
        QueueByList<Character> afterQueue = tree.afterErgodic();
        System.out.println("=========================================");
        System.out.println("后序遍历");
        for (int i = 0; i < 8; i++) {
            afterQueue.dequeue();
        }

        System.out.println("***********************************************");
        //层序遍历
        QueueByList<Character> layerQueue = tree.layerErgodic();
        System.out.println("=========================================");
        System.out.println("层序遍历");
        for (int i = 0; i < 8; i++) {
            layerQueue.dequeue();
        }
    }

    @Test
    public void testMaxDepth(){
        System.out.println("最大深度:"+tree.maxDepth());
    }


    private BinaryTree<Character, Integer> tree = null;
    @Before
    public void before(){
        //创建二叉查找树对象
        tree = new BinaryTree<>();
        tree.put('F',100);
        tree.put('G',200);
        tree.put('H',300);
        tree.put('B',50);
        tree.put('A',10);
        tree.put('D',70);
        tree.put('C',60);
        tree.put('E',80);
    }

}
