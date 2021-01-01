package DataStructure.TableTreeHeap.test;

import DataStructure.TableTreeHeap.MinPriorityQueue;


/*
* 测试最小优先队列
* */
public class TestMinPriorityQueue {
    public static void main(String[] args) {
        MinPriorityQueue<Integer> queue = new MinPriorityQueue<>(20);

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

        System.out.println("根据队列中值的小到大顺序作为优先级大小出队列:");
        while (!queue.isEmpty()){
            System.out.println(queue.delMin());
        }

    }


}
