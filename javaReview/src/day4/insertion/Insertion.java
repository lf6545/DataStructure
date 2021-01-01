package day4.insertion;


/*
* 插入算法
* 时间复杂度 O(n^2)
* */
public class Insertion {
    //排序
    public static void sort(Comparable[] arry) {

        //待排序的数量i
        for (int i = arry.length-1; i >0; i--) {

            for (int j = arry.length-i; j >0 ; j--) {//表示已排序的数量j
                if (greater(arry[j-1],arry[j])){
                    exchange(arry,j,j-1);
                }else{
                    break;
                }
            }

        }

    }
    //判断两元素谁更小
    public static boolean greater(Comparable a,Comparable b){
        return a.compareTo(b)>0;
    }
    //交换两个索引处的值
    public static void exchange(Comparable[] arry,int i,int j){
        Comparable temp = arry[i];
        arry[i] = arry[j];
        arry[j] = temp;
    }
}
