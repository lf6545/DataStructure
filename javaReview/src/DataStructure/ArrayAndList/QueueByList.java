package DataStructure.ArrayAndList;


import java.util.Iterator;

/*
* 用链表实现队列
* 特点:先进先出
* */
public class QueueByList<T> implements Iterable{
    private Node head;//头节点
    private int N;
    private Node last;//尾节点



    private class Node<T>{
        private Node next;
        private T t;
        public Node(T t,Node next){
            this.next = next;
            this.t = t;
        }
    }

    public QueueByList(){
        this.head = new Node(null,null);
        this.last = new Node(null,null);
        this.N = 0;
    }

    //判断是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取队列中的元素个数
    public int size(){
        return N;
    }

    //从队列中拿出一个元素
    public T dequeue(){
        if (N==0){
            //System.out.println("队列为空!");
            return null;
        }
        Node pre = this.head;
        Node n = pre.next;
        //从链表末尾拿出元素
        while (n.next!=null){
            pre = n;
            n = n.next;
        }
        pre.next = null;
        N--;
        //System.out.println(n.t+":离开队列");
        return (T) n.t;
    }

    //往队列里插入一个元素
    public void enqueue(T t){
        //在链表第一个节点的位置插入
        Node first = this.head.next;
        Node<T> newNode = new Node<>(t, first);
        this.head.next = newNode;
        System.out.println(t+":进入队列");
        N++;
    }


    //判断队列中是否包含元素t
    public boolean contains(T t){
        Node n = this.head.next;
        while (n != null){
            if (t.equals(n.t)){
                return true;
            }
            n = n.next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new QIterator();
    }
    private class QIterator implements Iterator{
        private Node n;

        public QIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.t;
        }
    }
}
