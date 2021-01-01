package DataStructure.TableTreeHeap.applicationCase;

import DataStructure.ArrayAndList.QueueByList;


/*
 * 运用二叉树解决折纸中的折痕问题
 * */
public class PaperFolding2 {
    public static void main(String[] args) {
        Node<String> folding = folding(5);
        QueueByList<String> result = new QueueByList<>();
        result = midErgodic(folding, result);
        System.out.print("-");
        for (int i = 0; i < 31; i++) {
            System.out.print(result.dequeue()+"-");
        }
    }


    /*//返回折纸K次的二叉树的根节点(首次代码)
    public static Node<String> folding(int K){
        Node<String> root = null;
        QueueByList<Node> nodes = null;
        QueueByList<Node> copy = new QueueByList<>();

        for (int i = 0; i < K; i++) {
            //第一次对折
            if (i == 0){
                root = new Node("down",null,null);
                Node<String> n = root;
                //使用队列保存遍历的节点
                nodes = new QueueByList<>();
                nodes.enqueue(root);
            }else{
                //不是第一次对折
                while (!nodes.isEmpty()){
                    Node n = nodes.dequeue();
                    n.left = new Node("down",null,null);
                    n.right = new Node("up",null,null);
                    copy.enqueue(n.left);
                    copy.enqueue(n.right);
                }
                QueueByList<Node> Queue = nodes;
                nodes = copy;
                copy = Queue;
            }
        }
        return root;
    }

    //中序遍历二叉树
    public static QueueByList<String> midErgodic(Node<String> x,QueueByList<String> queue){
        if (x == null){
            //当前二叉树为空
            return null;
        }else{
            //遍历左子树
            if (x.left != null){
                midErgodic(x.left,queue);
            }
            //当前节点的左子树为空了,说明当前节点是最左边的节点了,入队列
            queue.enqueue(x.t);

            //遍历右子树
            if (x.right != null){
                midErgodic(x.right,queue);
            }
        }
        return queue;
    }*/
    //返回折纸K次的二叉树的根节点(优化)
    public static Node<String> folding(int K){
        Node<String> root = null;
        QueueByList<Node> nodes = null;

        for (int i = 0; i < K; i++) {
            //第一次对折
            if (i == 0){
                root = new Node("down",null,null);
                Node<String> n = root;
            }else{
                //使用队列保存遍历的节点
                nodes = new QueueByList<>();
                nodes.enqueue(root);
                //不是第一次对折
                while (!nodes.isEmpty()){
                    Node n = nodes.dequeue();
                    if (n.left != null){
                        //当前节点有左子树,让左子树进入队列
                        nodes.enqueue(n.left);
                    }
                    if (n.right != null){
                        //当前节点有右子树,让右子树进入队列
                        nodes.enqueue(n.right);
                    }
                    //当前节点n左右子树都为null
                    //本次折纸为当前节点产生左右子节点
                    n.left = new Node<String>("down",null,null);
                    n.right = new Node<String>("up",null,null);
                }

            }
        }
        return root;
    }

    //中序遍历二叉树
    public static QueueByList<String> midErgodic(Node<String> x,QueueByList<String> queue){
        if (x == null){
            //当前二叉树为空
            return null;
        }else{
            //遍历左子树
            if (x.left != null){
                midErgodic(x.left,queue);
            }
            //当前节点的左子树为空了,说明当前节点是最左边的节点了,入队列
            queue.enqueue(x.t);

            //遍历右子树
            if (x.right != null){
                midErgodic(x.right,queue);
            }
        }
        return queue;
    }


    //节点类
    private static class Node<T>{
        public Node left;//左子节点
        public Node right;//右子节点
        public T t;//存储的数据

        //构造函数
        public Node(T t, Node left, Node right){
            this.t = t;
            this.left = left;
            this.right = right;
        }
    }
}
