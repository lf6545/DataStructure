package DataStructure.ArrayAndList;

import java.util.Iterator;

/*
* 顺序表
* java中的ArrayList<T>
* */
public class SequenceList<T> implements Iterable<T> {
    //存储数据的数组
    private T[] ele;
    //数组的元素个数
    private int N;


    /*
     * 构造方法
     * @param capacity:容量
     * */
    public SequenceList(int capacity) {
        ele = (T[]) new Object[capacity];
        this.N = 0;
    }

    //清空数组
    public void clear() {
        int capacity = ele.length;
        ele = (T[]) new Object[capacity];
        this.N = 0;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //获取数组长度
    public int length() {
        return N;
    }

    //获取指定索引处的元素
    public T get(int index) {
        return ele[index];
    }

    //在数组末尾添加一个元素
    public void insert(T t) {
        //检查是否扩容
        incrCapacity();
        ele[N++] = t;
    }

    //在指定索引处插入一个元素
    public void insert(int index, T t) {
        //检查是否扩容
        incrCapacity();

        //index索引后面的元素都向后移动一个索引位置
        for (int i = N; i > index; i++) {
            ele[i] = ele[i - 1];
        }
        //插入元素
        ele[index] = t;
        N++;
    }

    //扩容
    public void incrCapacity() {
        //当插入元素时,数组元素已满,进行扩容,数组容量翻倍
        if (N == ele.length) {
            System.out.println("当前容量:" + ele.length);
            Object[] newEle = new Object[2 * ele.length];
            for (int i = 0; i < N; i++) {
                newEle[i] = ele[i];
            }
            ele = (T[]) newEle;
            System.out.println("完成扩容:容量-->" + ele.length);
        }
    }

    //缩容
    public void decrCapacity() {
        //当删除元素后,如果数组中元素个数N<=1/4capacity,容量缩小到原容量的一半
        if (N <= (ele.length / 4)) {
            System.out.println("当前容量:" + ele.length);
            Object[] newEle = new Object[ele.length / 2];
            for (int i = 0; i < N; i++) {
                newEle[i] = ele[i];
            }
            ele = (T[]) newEle;
            System.out.println("完成缩容:容量-->" + ele.length);
        }
    }

    //删除一个元素,并且返回该元素
    public T remove(int index) {
        T tt = ele[index];
        for (int i = index; i < N; i++) {
            ele[i] = ele[i + 1];
        }
        N--;
        //检查是否缩容
        decrCapacity();
        return tt;
    }

    //返回指定元素的索引,元素不存在则返回-1
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (t.equals(ele[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new sIterator();
    }

    private class sIterator implements Iterator {
        //用于遍历的指针
        private int cusor;

        public sIterator() {
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return ele[cusor++];
        }
    }
}
