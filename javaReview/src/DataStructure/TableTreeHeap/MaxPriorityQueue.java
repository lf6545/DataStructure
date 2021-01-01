package DataStructure.TableTreeHeap;

import java.io.OutputStream;

/*
* 最大优先级队列:基于堆的数据结构
*       可以获取并且删除队列中的最大值
* */
public class MaxPriorityQueue<T extends Comparable<T>> {
    //存储可比较的数据类型
    private T[] items;//用于存储队列中元素的数组
    private int N;//记录队列中的元素个数

    //构造方法
    public MaxPriorityQueue(int capacity){
        //初始化数组容量
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    //判断索引i处的值是否小于索引j处的值
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换索引i和索引j处的值
    private void exchange(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //获取队列中的元素个数
    public int size(){
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //删除并返回队列中最大值
    public T delMax(){
        //堆中最大的元素就是数组索引1处的元素
        T max = items[1];

        //交换索引1处和数组最后一个元素
        exchange(1,N);
        //删除最大元素
        items[N--] = null;

        //使用sink方法,将当前索引1处的元素下沉到正确的位置
        sink(1);
        return max;
    }

    //向队列中插入一个元素
    public void insert(T t){
        //在数组最后添加元素
        items[++N] = t;
        //使用swim方法将插入的元素上浮到正确的位置
        swim(N);
    }

    //上浮
    private void swim(int k){
        while (k>1){
            if (less(k/2,k)){
                //索引k出的元素大于其父节点的元素
                //交换位置
                exchange(k/2,k);
                k = k/2;
            }else{
                //索引k出的元素小于于其父节点的元素
                //已经处于正确位置
                return;
            }
        }
    }

    //下沉
    private void sink(int k){
        while (2*k<=N){
            //左子节点存在
            int max;//用于存储较大值的索引
            if (2*k+1<=N){
                //右子节点存在
                //判断当前节点的左右子节点中的较大者
                if (less(2*k,2*k+1)){
                    max = 2*k+1;
                }else{
                    max = 2*k;
                }
            }else{
                max = 2*k;
            }

            if (less(k,max)){
                //当前节点小于其子节点中的较大者
                //交换位置
                exchange(k,max);
                k = max;
            }else{
                //当前节点大于其子节点中的较大者
                //处于正确位置
                break;
            }
        }
    }
}
