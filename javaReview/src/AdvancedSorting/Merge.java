package AdvancedSorting;
/*
* 归并排序
*时间复杂度nlogn
* 需要创建辅助数组,以空间换时间
* */
public class Merge {
    public static void main(String[] args) {

        Integer[] a = {8,5,2,4,7,6,1,9,3};
        sort(a);
        for (Integer integer : a) {
            System.out.print(integer+"　，");
        }
    }


    //辅助数组
    private static Comparable[] assist;

    //排序
    public static void sort(Comparable[] array) {
        //初始化辅助数组
        assist = new Comparable[array.length];
        //定义要排序的数组边界
        int lo = 0;
        int hi = array.length-1;
        sort(array,lo,hi);
    }

    //部分排序
    private static void sort(Comparable[] array,int lo,int hi) {
        int mid = (lo+hi)/2;
        if (lo>=hi){
            return;
        }else{
            //将数组拆分成两个分别排序
            sort(array,lo,mid);
            sort(array,mid+1,hi);
            merge(array,lo,mid,hi);
        }


    }

    //合并
    //lo~mid为一组,mid+1~hi为一组,将两组合并
    private static void merge(Comparable[] array,int lo,int mid,int hi){
        //定义三个指针
        int p1 = lo;
        int p2 = mid+1;
        int i = lo;

        while (p1<=mid && p2<=hi){
            //两个数组都没有遍历结束
            if (greater(array[p1],array[p2])){
                //p1处的值大于p2处的值,将更小者存入辅助数组
                assist[i] = array[p2];
                p2++;
            }else{
                assist[i] = array[p1];
                p1++;
            }
            i++;
        }
        //其中一组数据遍历结束,直接将另外一组神域数据填入辅助数组
        while (p2<=hi){
            //p1结束,p2未遍历结束
            assist[i++] = array[p2++];

        }
        while (p1<=mid){
            //p2结束,p1未遍历结束
            assist[i++] = array[p1++];

        }

        for (int j = lo; j <= hi; j++) {
            array[j] = assist[j];
        }

    }

    //判断两元素谁更小,a>b return true
    private static boolean greater(Comparable a,Comparable b){
        return a.compareTo(b)>0;
    }

    //交换两个索引处的值
    private static void exchange(Comparable[] arry,int i,int j){
        Comparable temp = arry[i];
        arry[i] = arry[j];
        arry[j] = temp;
    }

    //求n的阶乘
    public static long factorial(int n){

        if (n == 1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
}
