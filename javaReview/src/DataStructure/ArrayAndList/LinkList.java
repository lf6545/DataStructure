package DataStructure.ArrayAndList;


import java.util.Iterator;

/*
* 单向链表
* */
public class LinkList<T> implements Iterable<T>{
    //首节点
    private Node head;
    //链表长度
    private int N;

    //给hasLoop()方法测试的,返回一个有回路的链表
    public LinkList getLoopList(){
        Node<String> one = new Node<>("one", null);
        Node<String> two = new Node<>("two", null);
        Node<String> three = new Node<>("three", null);
        Node<String> four = new Node<>("four", null);
        Node<String> five = new Node<>("five", null);
        Node<String> six = new Node<>("six", null);
        Node<String> seven = new Node<>("seven", null);
        Node<String> eight = new Node<>("eight", null);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = seven;
        LinkList<String> numbers=new LinkList<>();
        numbers.head.next = one;
        return numbers;
    }
    //约瑟夫问题中的循环链表
    public LinkList getCycleList(){
        Node node41 = new Node(41, null);
        Node node40 = new Node(40, node41);
        Node node39 = new Node(39, node40);
        Node node38 = new Node(38, node39);
        Node node37 = new Node(37, node38);
        Node node36 = new Node(36, node37);
        Node node35 = new Node(35, node36);
        Node node34 = new Node(34, node35);
        Node node33 = new Node(33, node34);
        Node node32 = new Node(32, node33);
        Node node31 = new Node(31, node32);
        Node node30 = new Node(30, node31);
        Node node29 = new Node(29, node30);
        Node node28 = new Node(28, node29);
        Node node27 = new Node(27, node28);
        Node node26 = new Node(26, node27);
        Node node25 = new Node(25, node26);
        Node node24 = new Node(24, node25);
        Node node23 = new Node(23, node24);
        Node node22 = new Node(22, node23);
        Node node21 = new Node(21, node22);
        Node node20 = new Node(20, node21);
        Node node19 = new Node(19, node20);
        Node node18 = new Node(18, node19);
        Node node17 = new Node(17, node18);
        Node node16 = new Node(16, node17);
        Node node15 = new Node(15, node16);
        Node node14 = new Node(14, node15);
        Node node13 = new Node(13, node14);
        Node node12 = new Node(12, node13);
        Node node11 = new Node(11, node12);
        Node node10 = new Node(10, node11);
        Node node9 = new Node(9, node10);
        Node node8 = new Node(8, node9);
        Node node7 = new Node(7, node8);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        node41.next = node1;
        LinkList problem = new LinkList();
        problem.head.next = node1;
        problem.N = 41;
        return problem;
    }
    //内部类,节点
    private class Node<T>{
        //节点的数据
        public T t;
        //指向的下一个节点
        public Node next;

        public Node(T t,Node next){
            this.t = t;
            this.next = next;
        }
    }

    public LinkList(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    //清空链表
    public void clear(){
        head.next=null;
        N = 0;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取元素个数(链表长度)
    public int length(){
        return N;
    }

    //获取链表中第i个元素
    public T get(int i){
        if (i>N){
            //超过链表长度
            return null;
        }
        Node<T> n = head.next;
        for (int j = 1; j < i; j++) {
            n = n.next;
        }
        return n.t;
    }

    //插入一个元素
    public void insert(T t){
        //遍历链表,找到最后一个节点
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        Node<T> insert = new Node<>(t, null);
        //让最后一个借点指向插入的节点
        n.next = insert;
        N++;
    }

    //在第i的位置插入元素
    public void insert(T t,int i){

        if (i<1||i>N){
            //插入位置不合理,直接插入到最后
            insert(t);
        }else{
            Node pre = head;
            for (int j = 1; j < i; j++) {
                pre = pre.next;
            }
            //新节点指向原节点
            Node<T> newNode = new Node<>(t, pre.next);
            //前一个节点指向新节点
            pre.next = newNode;
        }
        N++;
    }

    //删除链表中第i个元素并返回
    public T remove(int i){
        if (i>N){
            //超出链表长度
            return null;
        }
        //设置前一个节点
        Node<T> pre = head;
        for (int j = 1; j < i; j++) {
            pre = pre.next;
        }
        //当前要删除的节点
        Node<T> remove = pre.next;
        //remove.next = null;
        //后一个节点
        Node after = remove.next;
        //前一个节点指向后一个节点
        pre.next = after;

        N--;
        return remove.t;
    }

    //返回链表中首次出现指定元素的序号
    public int indexOf(T t){
        Node n = head.next;
        for (int i = 1; i <= N; i++) {
            if (t.equals(n.t)){
                return i;
            }
            n = n.next;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new lIterator();
    }

    private class lIterator implements Iterator{
        private Node<T> n;
        public lIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.t;
        }
    }

//--------------------------------------------------------------------------
    //链表反转
    public void reverse(){
        //空链表不反转
        if (isEmpty()){
            return;
        }
        Node curr = this.head;

        reverse(curr).next = null;
    }
    //反转链表中某个节点的下一个节点
    public Node reverse(Node curr){

        curr = curr.next;
        if (curr.next == null){
            //已经遍历到链表最后一个元素
            //反转后,最后一个元素会变为第一个元素,所以头节点指向它
            head.next = curr;
        }else{

            Node now = reverse(curr);
            now.next = curr;
        }
        //返回需要反转的元素的下一个元素
        return curr;
    }

    public void re(){
        if (isEmpty()){
            return;
        }
        re(head.next);
    }
    public Node re(Node curr){

        if (curr.next == null){
            //最后一个节点反转变成第一个节点,head指向它
            head.next = curr;
            return curr;
        }
        //curr.next!=null,先反转curr.next
        Node curred = re(curr.next);
        //next_pre.next = next;next = curr;
        //反转
        curred.next = curr;
        curr.next = null;
        //返回当前在反转的节点
        return curr;
    }

    //如链表 head --> 1 --> 2 --> 3
    /*
    * 反转逻辑
    * 反转head.next,也就是反转1节点 --> 1.next!=null --> 反转1.next,即2节点 |
    * 3.next==null(3是最后一个节点)<--反转2.next,即3节点<-- 2.next!=null<--|
    * |-->让head节点指向3节点 --> 返回3节点
     * 返回:
    * 反转3节点处获取了返回的3节点,此时处于反转2节点的代码中,于是,让3节点指向2节点,接着return 2,并且2.next=null
    * 反转2节点处获取了返回的2节点,此时处于反转1节点的代码中,于是,让2节点指向1节点,接着return 1,并且1.next=null
    *
    * */
//--------------------------------------------------------------------------

    //快慢指针
    //1-获取中间节点
    public Node getMid(Node node){
        //定义快慢两个指针
        Node fast = node;//一次移动两个位置
        Node slow = node;//一次移动一个位置

        //用两个指针分别同时分别遍历链表
        while (fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;

        }
        return slow;
    }
    //获取中间元素
    public T getMid(T t){
        if (indexOf(t)>N){
            //超过链表长度
            return null;
        }
        Node<T> n = head.next;
        for (int j = 1; j < indexOf(t); j++) {
            n = n.next;
        }
        Node mid = getMid(n);
        return (T) mid.t;
    }

    //2-判断链表是否有环
    public Node hasLoop(){
        //定义快慢两个指针,快指针移动速度是慢指针的2倍
        Node fast = head.next;
        Node slow = head.next;

        while (fast != null && fast.next !=null){
            fast = fast.next.next;

            slow = slow.next;
            if (fast == slow){
                //将快慢指针在回路中相遇的节点返回
                return slow;
            }
        }
        //遍历结束,快慢指针没有相遇,返回null
        return null;
    }
    //根据传入的节点判断链表是否有回路
    public boolean hasLoop(Node meet){
        if (meet != null){
            return true;
        }
        return false;
    }

    //3-获取链表回路的入口
    public T getEntrance(){
        //判断是否有回路
        if (hasLoop(hasLoop())){
            //获取相遇点,设置为原来的慢指针
            Node slow = hasLoop();
            //设置新指针,指向第一个节点
            Node temp = head.next;
            while (temp != slow){
                //当新指针temp和慢指针相遇时,所在的节点就是链表的入口
                slow = slow.next;
                temp = temp.next;
            }
            return (T) temp.t;
        }
        return null;
    }

    //让循环链表报数减去对应节点,从入口1节点开始报数,报数为3的节点删除,接着继续从一开始报数
    public LinkList reduce(LinkList problem){
        //报数从1开始
        int count = 1;
        //当前报数的节点的前驱节点
        Node pre = problem.head;
        //报数节点从start=第一个节点开始
        Node start = pre.next;
        //链表中超过两个节点,就继续循环报数
        while (problem.N>0){
            //轮到下一个节点
            pre = start;
            start = start.next;
            //报数+1
            count++;
            //如果报的数是3,节点自杀
            if (count == 3){
                //报数为3的人去世(从链表中删除)
                pre.next = start.next;
                problem.N--;
                System.out.println("删除"+start.t);
                start = start.next;//轮到下一个报数
                count = 1;//报数变为1
            }
        }
        return problem;
    }
}
