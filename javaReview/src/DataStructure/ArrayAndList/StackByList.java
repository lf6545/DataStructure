package DataStructure.ArrayAndList;


import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

/*
* 用链表实现栈的数据结构
* */
public class StackByList<T> implements Iterable{
    private Node head;
    private int N;



    private class Node<T>{
        public Node next;
        public T t;
        public Node(T t,Node next){
            this.next = next;
            this.t = t;
        }
    }
    public StackByList(){
        this.head = new Node(null,null);
        this.N = 0;
    }
    //判断是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //栈中元素个数
    public int size(){
        return N;
    }

    //弹出栈顶元素
    public T pop(){
        if (this.N<1){
            return null;
        }
        /*//以链表末尾作为栈的出口
        Node pre = this.head;
        Node n = pre.next;
        while(n.next!=null){
            pre = n;
            n = n.next;
        }
        pre.next = null;
        N--;
        return (T) n.t;*/

        //以链表的头节点处作为栈的出口
        Node ele = this.head.next;
        if (ele != null){
            if (ele.next != null){
                this.head.next = ele.next;
            }else{
                this.head.next = null;
            }
            N--;
            System.out.println("Pop "+ele.t);
            return (T)ele.t;
        }
        return null;
    }

    //向栈中压入元素t
    public void push(T t){
        /*//从链表末尾添加
        Node n = this.head;
        while (n.next != null){
            n = n.next;
        }
        Node newNode = new Node(t,null);
        n.next = newNode;
        N++;*/

        //从链表的头节点后面添加
        Node after = this.head.next;
        Node<T> newNode = new Node<>(t, after);
        System.out.println("Push "+t);
        this.head.next = newNode;
        N++;
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private Node n;
        public SIterator(){
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
