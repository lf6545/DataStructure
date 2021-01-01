package DataStructure.TableTreeHeap;


import java.util.Iterator;

/*
* 有序符号表数据结构
* 使用链表实现
* 使用节点的key来对表中元素进行排序,如果所设置的Key类型实现了Comparable接口的CompareTo方法
* */
public class OrderSymbolTable<K extends Comparable<K>,V> implements Iterable{
    private int N;//记录表中键值对个数
    private Node head;//头节点


    private class Node<K,V>{
        public K key;//存储键
        public V value;//存储值
        public Node next;//下一个节点

        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    //构造方法
    public OrderSymbolTable(){
        this.N = 0;
        this.head = new Node(null,null,null);
    }
    //获取表中键值对个数
    public int size(){
        return N;
    }
    //根据Key获取对应的值
    public V get(K key){
        Node n = this.head;
        while (n.next!=null){
            n = n.next;
            if (key.equals(n.key)){
                N--;
                //Key相同,获取该节点的Value
                return (V)n.value;
            }
        }
        //没有找到该Key
        System.out.println("The Key("+key+") doesn't exist!get Failed!");
        return null;
    }

    //向表中插入一对键值
    public void put(K key,V value){
        //为了保证Key的唯一性,先判断key是否存在
        if (!contains(key)){
            //表中不包含该Key,进行插入,在头节点后插入
            Node pre = this.head;
            Node n = pre.next;
            while (n != null){
                if (key.compareTo((K) n.key)<0){
                    //如果待插入的key小于当前节点的key
                    //将该键值对插入到当前节点的前面
                    Node newNode = new Node(key,value,n);
                    pre.next = newNode;
                    System.out.println("put(Key["+key+"]:Value["+value+"])");
                    N++;
                    return;
                }
                pre = n;
                n = n.next;
            }
            //遍历结束,表中没有更大的key,将新节点插入到链表最后
            Node newNode = new Node(key,value,null);
            pre.next = newNode;
            System.out.println("put(Key["+key+"]:Value["+value+"])");
            N++;
        }else{
            System.out.println("The Key("+key+") already exists!The put fails.");
        }
    }

    //判断表中是否包含该Key
    public boolean contains(K key){
        Node n = this.head;
        for (int i = 0; i < N; i++) {
            n = n.next;
            if (key.equals(n.key)){
                //找到表中含有相同的key
                return true;
            }
        }
        //不存在相同的Key
        return false;
    }

    //根据key删除键值对
    public void delete(K key){
        if (!contains(key)){
            //key不存在,直接返回
            System.out.println("The Key("+key+") doesn't exist!Delete Failed!");
            return;
        }
        Node pre = this.head;
        Node n = pre.next;
        while (n != null){
            if (key.equals(n.key)){
                pre.next = n.next;
                N--;
                System.out.println("put(Key["+key+"]:Value["+n.value+"])");
            }
            n = n.next;
        }
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
            return n;
        }

    }
    //遍历表中所有键值对
    public void traverse(){
        Node<K,V> n = new Node(null,null,null);
        for (Object o : this) {
            n = (Node<K, V>) o;
            System.out.println(n.key+":"+n.value);
        }
    }
}
