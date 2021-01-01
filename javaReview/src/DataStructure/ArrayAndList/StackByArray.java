package DataStructure.ArrayAndList;

public class StackByArray<T> {
    private T[] a;
    private int N;
    public StackByArray(){
        this.a = (T[]) new Object[10];//初始栈大小为10
        this.N = 0;
    }

    //遍历栈内元素
    public void traverse(){
        for (T t : a) {
            System.out.println(t);
        }
    }
    //获取栈容量
    public int getCapacity(){
        return a.length;
    }

    //判断是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //栈中元素个数
    public int size(){
        return N;
    }

    //弹出栈顶元素
    public T pop(){
        if (N==0){
            return null;
        }
        T ele = a[N-1];
        System.out.println("Pop "+ele);
        a[N-1] = null;
        N--;
        //弹出数组中最后一个元素
        return ele;
    }

    //向栈中压入元素t
    public void push(T t){
        if (this.N<a.length){
            a[N] = t;
            System.out.println("Push "+t);
            N++;
        }else{
            System.out.println("栈空间已满!!");
        }
    }


}
