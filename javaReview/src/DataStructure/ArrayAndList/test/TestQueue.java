package DataStructure.ArrayAndList.test;

import DataStructure.ArrayAndList.QueueByArray;

/*
* 测试队列类QueueByList和QueueByArray
* */
public class TestQueue {
    public static void main(String[] args) {
//        QueueByList<String> queue = new QueueByList<>();
//        queue.enqueue("阿毛");
//        queue.enqueue("阿呆");
//        queue.enqueue("小明");
//        queue.enqueue("小红");
//        System.out.println("队列是否为空?"+queue.isEmpty());
//        System.out.println("队列中元素个数?"+queue.size());
//        System.out.println("遍历队列:");
//        for (Object o : queue) {
//            System.out.println(o);
//        }
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();


        QueueByArray<String> queue = new QueueByArray<>();
        queue.enqueue("阿毛");
        queue.enqueue("阿呆");
        queue.enqueue("小明");
        queue.enqueue("小红");
        System.out.println("队列是否为空?"+queue.isEmpty());
        System.out.println("队列中元素个数?"+queue.size());
        System.out.println("遍历队列:");
        queue.traverse();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

    }
}
