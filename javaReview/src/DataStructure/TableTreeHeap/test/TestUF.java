package DataStructure.TableTreeHeap.test;

import DataStructure.TableTreeHeap.UF;

/*
* 测试并查集
* */
public class TestUF {
    public static void main(String[] args) {
        UF uf = new UF(20);
        System.out.println("分组个数:"+uf.count());

        uf.union(1,0);
        uf.union(2,0);
        uf.union(3,0);
        uf.union(4,0);
        uf.union(5,0);
        System.out.println("分组个数:"+uf.count());
        uf.print();
        System.out.println("====================================");

        uf.union(7,6);
        uf.union(8,6);
        uf.union(9,6);
        uf.union(10,6);
        uf.union(11,6);
        System.out.println("分组个数:"+uf.count());
        uf.print();
        System.out.println("====================================");

        uf.union(13,12);
        uf.union(14,12);
        uf.union(15,12);
        uf.union(16,12);
        System.out.println("分组个数:"+uf.count());
        uf.print();
        System.out.println("====================================");

        uf.union(18,17);
        uf.union(19,17);
        System.out.println("分组个数:"+uf.count());
        uf.print();
        System.out.println("====================================");


        uf.union(0,6);
        uf.union(16,6);
        uf.union(18,6);
        System.out.println("分组个数:"+uf.count());
        uf.print();
        System.out.println("====================================");
    }

}

