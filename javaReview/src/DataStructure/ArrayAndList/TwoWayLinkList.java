package DataStructure.ArrayAndList;


import java.util.Iterator;

/*
* 双向链表
* java中的LinkedList<T >
* */
public class TwoWayLinkList<T> implements Iterable<T>{

    private class Node<T>{
        //前驱节点
        private Node pre;
        //后继节点
        private Node next;
        //数据
        private T item;

        public Node(Node pre, Node next, T item) {
            this.pre = pre;
            this.next = next;
            this.item = item;
        }
    }

    //首节点
    private Node head;
    //尾节点
    private Node last;
    //链表长度
    private int N;

    public TwoWayLinkList() {
        this.head = new Node(null,null,null);
        this.last = null;
        this.N = 0;
    }

    //清空链表
    public void clear(){
        this.head.next = null;
        this.last = null;
        this.N = 0;
    }

    //获取第i个元素
    public T get(int i){
        Node<T> n = this.head;
        if (i<1||i>N){
            //不在个数范围
            return null;
        }
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        return n.item;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取链表长度
    public int length(){
        return this.N;
    }

    //在链表末尾插入元素
    public void insert(T t){
        if (this.N == 0){
            //链表为空,链表中只有初始化的首尾节点
            //将第一个插入的元素赋值给last
            this.last = new Node(this.head,null,t);
            this.head.next = this.last;
        }else{
            //尾节点设置为新节点的前驱,新节点的后继节点设置为null
            Node<T> newNode = new Node<>(this.last, null, t);

            //当前尾节点的后继节点设置为新插入的节点
            this.last.next = newNode;

            //插入的节点成为新的尾节点
            this.last = newNode;
        }
        //元素个数+1
        N++;
    }

    //在指定位置插入元素
    public void insert(T t,int i){
        if (i>N){
            //i大于链表长度,在链表末尾插入
            insert(t);
        }else if (i < 1){
            //0或负数,默认在首节点后插入
            //新节点的前驱节点设置为首节点,后继节点设置为首节点的后继
            Node<T> newNode = new Node<>(this.head.next, this.head, t);
            //首节点的后继节点设置为新节点
            this.head.next = newNode;
        }else{
            //i[1,N]
            Node pre = this.head;
            for (int j = 1; j < i; j++) {
                pre = pre.next;
            }
            //新节点的前驱节点设置为pre,后继节点设置为pre的后继,
            Node<T> newNode = new Node<>(pre, pre.next, t);

            //pre的后继节点设置为新节点
            pre.next = newNode;
        }
        //元素个数+1
        N++;
    }

    //删除第i个元素,并返回
    public T remove(int i){
        if (i<1||i>N){
            //i不在链表长度范围,不删,
            System.out.println("没有第"+i+"个元素");
            return null;
        }
        //re表示找到的待删除的元素节点
        Node re = this.head;
        for (int j = 0; j < i; j++) {
            re = re.next;
        }
        //将re节点的前驱后继相互指向
        re.pre.next = re.next;
        re.next.pre = re.pre;

        //元素个数-1
        N--;
        return (T)re.item;
    }

    //返回某个元素节点的索引
    public int indexOf(T t){
        Node n = this.head;
        for (int i = 1; n.next != null; i++) {
            if (t.equals(n.next.item)){
                return i;
            }
        }
        //链表中不包含该元素
        return -1;
    }

    //获取第一个元素
    public T getFirst(){
        if (!isEmpty()){
            //链表不为空
            return (T) this.head.next.item;
        }
        return null;
    }

    //获取最后一个元素
    public T getLast(){
        return (T) this.last.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TWLIterator();
    }
    //内部迭代器
    private class TWLIterator implements Iterator{
        private Node n ;
        public TWLIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public T next() {
            n = n.next;
            return (T) n.item;
        }
    }
}
