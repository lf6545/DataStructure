package DataStructure.TableTreeHeap.test;

import DataStructure.TableTreeHeap.MaxPriorityQueue;

/*
* 测试最大优先队列
* */
public class TestMaxPriorityQueue {
    public static void main(String[] args) {
        MaxPriorityQueue<Integer> queue = new MaxPriorityQueue<>(20);

        //插入数据
        queue.insert(999);
        queue.insert(888);
        queue.insert(555);
        queue.insert(111);
        queue.insert(333);
        queue.insert(777);
        queue.insert(444);
        queue.insert(222);
        queue.insert(123);
        queue.insert(456);
        queue.insert(789);

        System.out.println("根据队列中值的大小作为优先级大小出队列:");
        while (!queue.isEmpty()){
            System.out.println(queue.delMax());
        }

    }


}
