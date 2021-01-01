package AdvancedSorting;
/*
* 快速排序
*
* */
public class Quick {
    public static void main(String[] args) {
        Integer[] a = {9,8,7,6,5,4,3,2,1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" , ");
        }
    }

    //排序
    public static void sort(Comparable[] array) {
        int lo = 0;
        int hi = array.length -1;
        sort(array,lo,hi);
    }

    //对数组array中从索引lo到hi之间的元素进行排序
    private static void sort(Comparable[] array,int lo,int hi) {
        //安全性校验
        if (hi<=lo){
            return;
        }

        //对数组进行分组,并且获取分组界限的索引值
        int partition = partition(array, lo, hi);

        //左子租排序
        sort(array,lo,partition-1);
        //右子组排序
        sort(array,partition+1,hi);
    }

    //对数组array中,从索引lo到索引hi之间的元素进行分组,并返回分组界限对应的索引值
    public static int partition(Comparable[] array,int lo,int hi){
        //定义两个指针
        int left = lo;
        int right = hi+1;
        Comparable key = array[lo];

        while (true){
            //right向左扫描,直到找到小于key的值
            while (!greater(key,array[--right])){
                //right指向的值比key大,不是要交换的目标
                if (right == lo){
                    break;
                }
            }
            while (greater(key,array[++left])){
                //left指向的值比key小,不是要交换的目标
                if (left == hi){
                    break;
                }
            }
            if (left >= right){
                exchange(array,lo,right);
                break;
            }else{
                exchange(array,right,left);
            }
        }

        return right ;
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

}
