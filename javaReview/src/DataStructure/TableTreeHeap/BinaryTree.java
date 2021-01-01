package DataStructure.TableTreeHeap;


import DataStructure.ArrayAndList.QueueByList;

/*
* 二叉树
* */
public class BinaryTree<K extends Comparable<K>,V> {
    private Node root;//跟节点
    private int N;//树中元素个数

    //节点类
    private class Node<K extends Comparable<K>,V>{
        public Node left;//左子节点
        public Node right;//右子节点
        public K key;//键
        public V value;//值

        //构造函数
        public Node(K key,V value,Node left,Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //构造函数
    public BinaryTree(){
        this.root = new Node(null,null,null,null);
        this.N = 0;
    }

    //获取元素个数
    public int size(){

        return N;
    }

    //向树中插入元素
    public void put(K key,V value){
        root = put(root, key, value);
    }
    //在指定树x上添加键值对,并返回新的树x
    public Node put(Node x,K key,V value){
        if (x != null && x.key != null){
            //key与当前节点的key的大小比较结果
            int result = key.compareTo((K) x.key);

            if (result<0){
                //待插入的key小于当前节点的key
                //继续遍历当前节点的左子树,递归调用
                x.left = put(x.left,key,value);
            }else if (result>0){
                //待插入的key大于当前节点的key
                //继续遍历当前节点的右子树
                x.right = put(x.right,key,value);
            }else{
                //待插入的key等于当前节点的key
                //将当前节点的值设置为value
                x.value = value;
                return x;
            }
            return x;
        }else{
            //指定的树为null
            x = new Node(key,value,null,null);
            N++;
            return x;
        }

    }

    //通过key获取对应的value
    public V get(K key){
        Node n = get(this.root, key);
        if (n == null){
            return null;
        }else{
            return (V) n.value;
        }
    }

    //从指定的树中查找对应的值
    public Node get(Node x,K key){
        if (x == null || x.key == null){
            //树x为空
            System.out.println("当前查找的二叉树为空或者二叉树中不存在key("+key+")");
            return null;
        }
        //比较参数key和当前节点的key的大小
        int result = key.compareTo((K) x.key);

        if (result<0){
            //参数key小于当前节点的key
            //继续遍历当前节点的左子树(递归调用)
            return get(x.left,key);
        }else if (result>0){
            //参数key大于当前节点的key
            //继续遍历当前节点的右子树
            return get(x.right,key);
        }else{
            //参数key等于当前节点的key
            //System.out.println("Key:"+key+" ==> Value["+x.value+"]");
            return x;
        }
    }

    //删除树中key对应的键值对
    public void delete(K key){
        delete(this.root,key);
    }


    //从指定树x中删除key对应的键值对
    public Node delete(Node x,K key){
        //删除一个节点时,从该节点的右子树中找出一个最小key的节点代替被删除的节点
        //从而保证查找二叉树的左子树的节点的key都小于右子树的节点的key
        if (x == null){
            //未找到键为key的节点
            System.out.println("No key is "+key+" !");
            return null;
        }else{
            int result = key.compareTo((K) x.key);
            if (result == 0){
                //参数key与当前节点的key相等,当前节点就是要删除的节点

                if (x.right == null){
                    //右子树为空
                    N--;
                    return x.left;
                }
                if (x.left == null){
                    //左子树为空
                    N--;
                    return x.right;
                }
                //左右子树都不为空,从右子树中找到最小值代替当前节点的位置,也可以赵左子树最大值
                Node min = getMin(x.right);
                //将右子树最小节点与右子树中第二小节点断开
                Node n = x.right;
                while (n.left != null){
                    if (n.left.left == null){
                        //此时n就是第二小节点了
                        n.left = null;
                    }else{
                        n = n.left;
                    }
                }

                //用min代替被删除的x节点
                min.left = x.left;
                min.right = x.right;
                N--;
                return min;

            }else if (result < 0){
                //参数key小于当前节点的key
                //继续遍历当前节点的左子树(递归调用)
                x.left = delete(x.left,key);
            }else if (result > 0 ){
                //参数key大于当前节点的key
                //继续遍历当前节点的右子树(递归调用)
                x.right = delete(x.right,key);
            }
        }
        return x;
    }
    //获取指定树x中的最小节点
    public Node getMin(Node x){
        while (x.left != null){
            x = x.left;
        }
        //x.left == null,说明节点x已经是树中最左边的节点了
        return x;
    }
    //查找最小节点的key
    public K min(){
        return (K) getMin(root).key;
    }
    //获取指定树x中的最大节点
    public Node getMax(Node x){
        while (x.right != null){
            x = x.right;
        }
        //x.right == null,说明节点x已经是树中最右边的节点了
        return x;
    }
    //查找最大节点的key
    public K max(){
        return (K) getMax(root).key;
    }
    //获取节点left的元素
    public V getLeft(K key){
        Node curr = get(root, key);
        if (curr == null){
            System.out.println("所以Key为"+key+"的左节点也不存在!");
            return null;
        }

        //当前节点!=null
        if (curr.left == null){
            System.out.println("Key为"+key+"的左节点为null!");
            return null;
        }

        //curr.left != null
        System.out.println("Key:"+key+" .left = [Key:"+curr.left.key+" => Value:"+curr.left
                .value+"]");
        return (V) curr.left.value;
    }

    //获取节点right的元素
    public V getRight(K key){
        Node curr = get(root, key);
        if (curr == null){
            System.out.println("所以Key为"+key+"的右节点也不存在!");
            return null;
        }

        //当前节点!=null
        if (curr.right == null){
            System.out.println("Key为"+key+"的右节点为null!");
            return null;
        }

        //curr.left != null
        System.out.println("Key:"+key+" .right = [Key:"+curr.right.key+" => Value:"+curr.right
                .value+"]");
        return (V) curr.right.value;
    }

    //前序遍历  根 --> 左 --> 右
    public QueueByList<K> preErgodic(){
        //创建一个队列,用来存储遍历的key
        QueueByList<K> queue = new QueueByList<>();

        preErgodic(this.root,queue);

        return queue;
    }
    //将指定节点x的key存入队列queue中
    public void preErgodic(Node x,QueueByList<K> queue){
        if (x == null || x.key == null){
            //节点为空,或者二叉树中只有初始化的根节点,根节点的key为null
            return;
        }
        while (x != null){
            //节点x不为空,入队列
            queue.enqueue((K) x.key);
            //遍历左子树
            if (x.left != null){
                //递归遍历左子树
                preErgodic(x.left,queue);
            }
            //遍历右子树
            if (x.right != null){
                //递归遍历右子树
                preErgodic(x.right,queue);
            }
            return;
        }
    }


    //中序遍历  左 --> 根 --> 右
    public QueueByList<K> midErgodic(){
        //创建一个队列,用来存储遍历的key
        QueueByList<K> queue = new QueueByList<>();

        midErgodic(this.root,queue);

        return queue;
    }
    //将指定节点x的key存入队列queue中
    public void midErgodic(Node x,QueueByList<K> queue){
        if (x == null){
            //当前二叉树为空
            return;
        }
        //遍历左子树
        if (x.left != null){
            midErgodic(x.left,queue);
        }
        //当前节点的左子树为空了,说明当前节点是最左边的节点了,入队列
        queue.enqueue((K) x.key);

        //遍历右子树
        if (x.right != null){
            midErgodic(x.right,queue);
        }
    }

    //后序遍历  左 --> 右 --> 根
    public QueueByList<K> afterErgodic(){
        //创建一个队列,用来存储遍历的key
        QueueByList<K> queue = new QueueByList<>();
        afterErgodic(this.root,queue);
        return queue;
    }
    //将指定节点x的key存入队列queue中
    public void afterErgodic(Node x,QueueByList<K> queue){
        if (x == null){
            //当前二叉树为空
            return;
        }
        //遍历左子树
        if (x.left != null){
            afterErgodic(x.left,queue);
        }

        //遍历右子树
        if (x.right != null){
            afterErgodic(x.right,queue);
        }

        //当前节点的左子树为空了,说明当前节点是最左边的节点了,入队列
        queue.enqueue((K) x.key);
    }

    //层序遍历 从上到下,从左往右
    public QueueByList<K> layerErgodic(){
        //创建一个队列,用来存储遍历的节点
        QueueByList<Node> nodeQueue = new QueueByList<>();
        //创建一个队列,用来存储遍历的key
        QueueByList<K> keyQueue = new QueueByList<>();

        if (this.root == null || this.root.key == null){
            //当前二叉树为空
            return null;
        }

        //将头节点放入队列1
        nodeQueue.enqueue(this.root);
        //定义节点n,用于存储队列1弹出的元素
        Node n = null;
        //节点队列不为空就继续循环
        while (!nodeQueue.isEmpty()){
            //节点队列中弹出一个节点,N--
            n = nodeQueue.dequeue();
            //将弹出的节点的key存入key队列
            keyQueue.enqueue((K) n.key);

            if (n.left != null){
                //如果当前节点有左子树,让左子树进入节点队列
                nodeQueue.enqueue(n.left);
            }
            if (n.right != null){
                //如果当前节点有右子树,让右子树进入节点队列
                nodeQueue.enqueue(n.right);
            }
        }
        //返回遍历好的key队列
        return keyQueue;
    }


    //获取树的最大深度
    public int maxDepth(){
        return maxDepth(this.root);
    }

    //获取指定树x的最大深度
    private int maxDepth(Node x){
        if (x == null || x.key == null){
            return 0;
        }
        //左子树最大深度
        int leftD = maxDepth(x.left);
        //右子树最大深度
        int rightD = maxDepth(x.right);

        //比较左右子树深度,返回较大者,加1是因为加上自身深度
        if (leftD>rightD){
            return leftD+1;
        }else{
            return rightD+1;
        }
    }


}
