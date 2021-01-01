package DataStructure.ArrayAndList;
/*
* 用数组实现队列
* */
public class QueueByArray<T> {
    private T[] a;
    private int N;

    public QueueByArray(){
        this.a = (T[]) new Object[10];
        this.N = 0;
    }

    //判断是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取元素个数
    public int size(){
        return N;
    }

    //向队列中插入一个元素
    public void enqueue(T t){
        //进队列,在数组末尾添加一个元素
        this.a[N] = t;
        System.out.println(t+":进入队列");
        N++;

    }
    //从队列中获取一个元素
    public T dequeue(){
        //出队列,数组索引为0的元素离开
        if (isEmpty()){
            System.out.println("队列已为空!");
            //队列为空
            return null;
        }else{
            T t = this.a[0];
            for (int i = 0; i < N; i++) {
                a[i] = a[i+1];
//                if (i == N-1){
//                    a[N-1] = null;
//                }
            }
            N--;
            System.out.println(t+":离开队列");
            return t;
        }
    }

    //遍历栈内元素
    public void traverse(){
        for (T t : a) {
            if (t == null){
                break;
            }
            System.out.println(t);

        }
    }
}
