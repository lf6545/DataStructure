package DataStructure.TableTreeHeap;


/*
* 红黑树
* */
public class RedBlackTree<K extends Comparable<K>,V> {

    private Node root;//根节点
    private int N;//元素个数
    private static final boolean RED=true;//父节点指向当前节点的链接颜色
    private static final boolean BLACK=false;

    //节点类
    private class Node<K,V>{
        public Node left;//左子节点
        public Node right;//右子节点
        public K key;//键
        public V value;//值
        public boolean color;//父节点指向它的链接颜色
        public Node(K key,V value,Node left,Node right,boolean color){
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    //构造方法
    public RedBlackTree(){
        //根节点没有父节点,color一直是BLACK
        this.root = new Node(null,null,null,null,BLACK);
        this.N = 0;
    }

    //判断当前节点的父节点指向它的链接是否为红色
    private boolean isRed(Node x){
        if (x == null){
            //空链接默认为false
            return false;
        }
        return x.color;
    }

    //对指定树h进行左旋调整,调整好并且返回
    private Node rotateLeft(Node h){
        //需要左旋的情况:传入的节点h指向其右子节点的链接为RED
        Node s = h.right;
        //当前节点的右子节点变为其原来右子节点的左子节点
        h.right = s.left;
        //s成为h的父节点
        s.left = h;
        s.color = h.color;
        h.color = RED;
        return s;
    }

    //对指定树h进行右旋调整,调整好并且返回
    private Node rotateRight(Node h){
        //需要右旋的情况:传入的节点h的左子节点和左子节点的左子节点的color都是RED
        //左链接连续两个RED
        Node s = h.left;
        h.left = s.right;
        s.right = h;
        s.color = h.color;
        h.color = RED;
        return s;
    }

    //颜色反转
    private void flipColor(Node h){
        //需要颜色反转的情况:当前节点h指向左右子节点的链接都是RED
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }

    //向整棵树中插入元素
    public void put(K key,V value){
        root = put(root,key,value);
        root.color = BLACK;
    }

    //向指定树h中插入元素
    private Node put(Node h,K key,V value){
        if (h==null || h.key==null){
            //树h为空
            h = new Node(key,value,null,null,RED);
            N++;
            return h;
        }
        //树不为空!
        while (h != null){
            if (key.compareTo((K) h.key)<0){
                //待插入的key小于当前节点h的key
                //往左子树插
                h.left = put(h.left,key,value);
                if (h.left.left !=null){
                    if (isRed(h.left) && isRed(h.left.left)){
                        //连续两个左链接为RED
                        //需要右旋
                        Node newH = rotateRight(h);
                        //右旋后进行颜色反转
                        flipColor(newH);
                        return newH;
                    }
                }
                //没有出现连续左链接RED,直接返回
                return h;
            }else{
                //待插入的key大于当前节点的key
                //往右子树插
                h.right = put(h.right,key,value);

                //判断当前节点的右链接是否为RED
                if (isRed(h.right)) {
                    //当前节点h的右链接为RED
                    if (h.left != null) {
                        //当前节点左链接不为空
                        if (isRed(h.left)) {
                            //左链接为RED
                            //颜色反转
                            flipColor(h);
                            return h;
                        }
                    }
                    //h左链接不是RED,右链接RED
                    //左旋调整
                    Node newH = rotateLeft(h);
                    return newH;
                }
                //右链接没有RED,正常返回
                return h;
            }
        }
        return h;
    }

    //根据key获取value
    public V get(K key){
        return get(root,key);
    }

    //从指定树中根据键获取值
    private V get(Node x,K key){
        if (x == null){
            System.out.println("当前红黑树中不存在key:"+key+"!");
            return null;
        }
        while (x != null){
            if (key.compareTo((K) x.key)<0) {
                //key小于当前节点x的key
                return get(x.left,key);
            }else if (key.compareTo((K) x.key)>0){
                //key大于当前节点x的key
                return get(x.right,key);
            }else{
                //key等于当前节点x的key,找到目标节点
                //返回当前节点的值
                return (V) x.value;
            }
        }
        return null;
    }

    //获取树中元素个数
    public int size(){
        return N;
    }

    //获取根节点
    public V getRoot(){
        return (V) root.value;
    }
}
