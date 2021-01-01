package DataStructure.TableTreeHeap;


/*
* 索引优先队列:基于最大优先队列
* */
public class IndexMaxPriorityQueue<T extends Comparable<T>> {

    private T[] items;//存储元素的数组
    private int[] pq; //保存items中元素的个数,并且是基于元素的堆有序
    private int[] qp; //按照pq的数据存储pq中的索引,如pq[1]=5,则qp[5]=1
    private int N;    //元素个数

    //构造方法
    public IndexMaxPriorityQueue(int capacity){
        this.items = (T[]) new Comparable[capacity+1];
        this.pq = new int[capacity+1];
        this.qp = new int[capacity+1];
        this.N = 0;

        //默认情况下,队列中没有元素,qp中默认是-1
        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取队列中元素个数
    public int size(){
        return N;
    }

    //判断索引i处的值是否小于索引j处的值
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换指定数组索引i和j处的值
    private void exchange(int i,int j){

        int temp1 = pq[i];
        pq[i] = pq[j];
        pq[j] = temp1;

        //qp也要做改变,pq与qp的关系:pq[a]=b => qp[b]=a
        qp[pq[i]] = i;
        qp[pq[j]] = j;

    }

    //删除队列中最小的元素,并返回该元素关联的索引
    public int delMax(){
        //最小元素的索引存储在pq数组的0索引处
        int max = pq[1];

        //pq数组中最小元素索引与最后一个元素索引交换位置
        exchange(1,N);
        //相关数据删除
        items[max] = null;
        qp[pq[N]] = -1;
        pq[N] = -1;
        N--;
        //对pq数组中0处元素进行下沉调整
        sink(1);
        return max;
    }

    //往队列中插入一个元素,并关联索引i
    public void insert(int i,T t){
        if (items[i] == null){
            //存储元素
            items[i] = t;
            N++;
            //存储元素对应的索引
            pq[N] = i;//从1索引处开始存
            //在qp中存储pq索引
            qp[i] = N;

            //上浮调整
            swim(N);
        }else{
            //索引i已被关联
            System.out.println("索引"+i+"已被其他元素关联!你可以使用changeItem()方法进行修改!");
            return;
        }
    }

    //上浮调整
    private void swim(int k){
        while (k>1){
            if (less(pq[k/2],pq[k])){
                //当前节点大于父节点
                //交换位置
                exchange(k,k/2);
                k = k/2;
            }else{
                //当前节点小于父节点
                //位置正确,调整结束
                break;
            }
        }
    }

    //下沉调整
    private void sink(int k){
        while (2*k<=N){
            //左子节点存在
            int max;//用来存储左右子节点中较小值索引
            if (2*k+1<=N){
                //右子节点存在
                if (less(pq[2*k],pq[2*k+1])){
                    //左子节点小于右子节点
                    max = 2*k+1;
                }else{
                    max = 2*k;
                }
            }else{
                //右子节点不存在
                max = 2*k;
            }
            if (less(pq[max],pq[k])){
                //当前节点小于其子节点
                //位置调整正确
                break;
            }else{
                //当前节点大于其子节点
                //交换位置
                exchange(k,max);
                k = max;
            }
        }
    }

    //判断队列中索引i是否有对应的元素
    public boolean contains(int k){
        return qp[k] != -1;
    }

    //修改索引i关联的元素为t
    public void changeItem(int i,T t){
        if (contains(i)){
            items[i] = t;
            //原来元素在pq中的位置
            int k = qp[i];

            swim(k);
            sink(k);
        }else{
            System.out.println("索引"+i+"未被任何元素关联!请先插入元素再进行修改...");
            return;
        }
    }

    //获取队列中最小元素关联的索引
    public int maxIndex(){
        return pq[1];
    }

    //删除索引i关联的元素
    public void delete(int i){
        int k = qp[i];
        if (k == -1){
            //索引i没有被元素关联
            System.out.println("索引"+i+"没有被元素关联!删除失败!");
        }else{
            exchange(k,N);
            System.out.println("已删除:"+i+":"+items[i]);
            items[i] = null;
            qp[pq[N]] = -1;
            pq[N] = -1;

            N--;

            swim(k);
            sink(k);
        }
    }
}
