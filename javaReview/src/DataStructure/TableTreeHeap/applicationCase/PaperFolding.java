package DataStructure.TableTreeHeap.applicationCase;

import DataStructure.ArrayAndList.QueueByList;
import DataStructure.TableTreeHeap.BinaryTree;

/*
* 运用二叉树解决折纸中的折痕问题
* */
public class PaperFolding {
    public static void main(String[] args) {
        BinaryTree<Integer, String> folding = folding(6);
        QueueByList<Integer> queue = folding.midErgodic();
        System.out.println("中序遍历:");
        for (int i = 0; i < 63; i++) {
            System.out.print(folding.get(queue.dequeue())+"-");
        }
    }

    //将折纸k次的结果转换为生成一颗二叉树
    public static BinaryTree<Integer,String> folding(int k){
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        if (k < 0){
            return null;
        }else{
            //对折产生的树是满二叉树
            //根节点的key值
            int rootKey = (int) Math.pow(2,k)/2;
            tree.put(rootKey,"down");//根节点,第一次对折后折痕为down
            //对折规律:第二次对折后,在前一次折痕左右分别是down,up
            for (int i = 1; i < k; i++) {
                //传入的k也对应着二叉树的层数
                for (int j = 0; j < Math.pow(2,i); j++) {
                    if (j%2 == 0){
                        //计算key值,根据k即可知道满二叉树的Key值范围,如k=3,key=>[1~7]
                        tree.put((int) (rootKey/Math.pow(2,i)+j*rootKey/Math.pow(2,i-1)),"down");
                    }else{
                        tree.put((int) (rootKey/Math.pow(2,i)+j*rootKey/Math.pow(2,i-1)),"up");
                    }
                }

            }
        }
        return tree;
    }
}
