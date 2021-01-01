package DataStructure.TableTreeHeap.test;

import DataStructure.TableTreeHeap.IndexMinPriorityQueue;

/*
* 测试基于最小优先队列的索引优先队列
* */
public class TestIndexMinPriorityQueue {
    public static void main(String[] args) {
        IndexMinPriorityQueue<Character> queue = new IndexMinPriorityQueue(20);

        //插入数据
        queue.insert(1,'A');
        queue.insert(2,'B');
        queue.insert(3,'C');
        queue.insert(5,'D');
        queue.insert(6,'E');
        queue.insert(8,'F');
        queue.insert(8,'G');

        System.out.println("最小元素的索引?: "+ queue.minIndex());
        System.out.println("队列是否为空?: "+ queue.isEmpty());
        System.out.println("队列中元素个数?: "+ queue.size());
        System.out.println("索引3是否被元素关联?"+queue.contains(3));
        System.out.println("索引4是否被元素关联?"+queue.contains(4));
        queue.changeItem(6,'E');
        queue.changeItem(7,'E');
        System.out.println("删除最小元素!");
        queue.delMin();
        System.out.println("最小元素的索引?: "+ queue.minIndex());
        System.out.println("索引1是否被元素关联?"+queue.contains(1));

        System.out.println("删除索引5的元素");
        queue.delete(5);
        System.out.println("索引5是否被元素关联?"+queue.contains(5));

        System.out.println("队列中元素个数?: "+ queue.size());
        queue.delete(5);
        queue.delete(6);
    }
}
