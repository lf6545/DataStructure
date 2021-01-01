package DataStructure.TableTreeHeap;

import org.junit.Before;

/*
* 堆:使用数组实现
* */
public class Heap<T extends Comparable<T>> {
    private T[] items;//存储元素的数组
    private int N;//记录堆中元素个数

    //构造方法,初始化堆的容量
    public Heap(int capacity) {
        //数组0索引出不存储数据
        this.items = (T[]) new Comparable[capacity+1];
        N = 0;
    }

    //判断索引i处的值是否小于索引j处的值
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    //交换堆中索引i和索引j处的值
    private void exchange(int i, int j) {
        T t = items[i];
        items[i] = items[j];
        items[j] = t;
    }

    //删除堆中最大的元素,并返回
    public T delMax() {
        //也就是删除根节点
        //保存根节点
        T max = items[1];
        //让根节点与最后一个子节点交换位置
        exchange(1, N);
        items[N] = null;
        N--;
        //使用下沉方法,将新的根节点下沉到正确位置
        sink(1);
        return max;
    }

    //插入一个元素
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    //使用上浮算法,使索引k处的值在堆中处于正确的位置
    private void swim(int k) {
        while (k > 1) {//k/2!=0
            if (!less(k, k / 2)) {
                //k处的元素不小于他的父节点
                //交换两者位置
                exchange(k, k / 2);
                k = k / 2;
            } else {
                //k处的值小于其父节点,位置正确
                return;
            }
        }
    }

    //使用下沉算法,使索引k处的值在堆中处于正确的位置
    private void sink(int k) {
        //k节点的左子树不为空时
        while ((2*k)<=N) {//items[2 * k] != null
            //k节点左子树不为空
            if ((2*k+1)<=N) {//items[2 * k + 1] != null
                //左右子树都不为空,判断子节点大小
                //左<右
                if (less(2 * k, 2 * k + 1)) {
                    if (less(k, 2 * k + 1)) {
                        //k<右,交换位置
                        exchange(k, 2 * k + 1);
                        k = 2 * k + 1;
                    } else {
                        //k>=右
                        //k比子节点都大,位置正确
                        return;
                    }
                }else{//右<左
                    if (less(k, 2 * k)) {
                        //k<左,交换位置
                        exchange(k, 2 * k);
                        k = 2 * k;
                    } else {
                        //k>=左
                        //k比子节点都大,位置正确
                        return;
                    }
                }
            }else{
                //右子节点为空
                //k节点直接比较左子树
                if (less(k, 2 * k)) {
                    //k节点小于子节点,交换位置
                    exchange(k, 2 * k);
                    //堆是完全二叉树,遇到只有左子树的节点说明已经到了堆的最后一个元素,调整结束
                    return;
                }
                //k节点大于子节点,k节点位置已经调整正确
                return;
            }
        }
    }

    //对数组进行排序(从小到大)
    //使用排序方法时,请不要向堆中进行insert和delMax操作
    public Comparable[] sort(Comparable[] array){
        for (Comparable t : array) insert((T) t);

        for (int i = N; i > 0; i--) {
            array[i-1] = delMax();
        }
        return array;
    }
}
