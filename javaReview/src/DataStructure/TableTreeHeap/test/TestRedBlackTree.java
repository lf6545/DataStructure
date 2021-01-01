package DataStructure.TableTreeHeap.test;

import DataStructure.TableTreeHeap.RedBlackTree;

/*
* 测试红黑树
* */
public class TestRedBlackTree {
    public static void main(String[] args) {
        RedBlackTree<Integer,Integer> tree = new RedBlackTree<>();
        tree.put(1,1);
        System.out.println(tree.getRoot());
        tree.put(8,8);
        System.out.println(tree.getRoot());
        tree.put(2,2);
        System.out.println(tree.getRoot());
        tree.put(7,7);
        System.out.println(tree.getRoot());
        tree.put(3,3);
        System.out.println(tree.getRoot());
        tree.put(6,6);
        System.out.println(tree.getRoot());
        tree.put(4,4);
        System.out.println(tree.getRoot());

        System.out.println("====================");
        System.out.println("索引4:"+tree.get(4));
        System.out.println("索引1:"+tree.get(1));

        System.out.println("红黑树中元素个数:"+tree.size());
    }
}
