package DataStructure.TableTreeHeap.test;

import DataStructure.TableTreeHeap.UF_Tree;

/*
* 测试优化了find()方法和union()方法的并查集
* */
public class TestUFTree {
    public static void main(String[] args) {
        UF_Tree uf = new UF_Tree(7);
        System.out.println("分组个数:"+uf.count());
        uf.union(0,1);
        uf.union(0,2);

        uf.union(3,4);
        uf.union(3,5);
        uf.union(4,6);
        System.out.println("==========================");
        System.out.println("分组个数:"+uf.count());
        uf.print();
    }

}

