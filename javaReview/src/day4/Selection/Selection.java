package day4.Selection;




/*
* 选择排序算法
* 时间复杂度 O(n^2)
* */
public class Selection {
    public static void sort(Comparable[] arry) {
        int min_index;
        for (int i = 0; i< arry.length; i++) {
            min_index = i;
            //System.out.println("确定数组 "+i+"处最小值:");

            for (int j = i+1; j < arry.length; j++) {

                if (greater(arry[min_index],arry[j])){
                    //预定的最小值>arry[i],预定最小值的索引改变
                    //System.out.println(min_index+"处的值>"+arry[j]+",min_index="+j);
                    min_index = j;
                }else{
                    //System.out.println(min_index+"处的值<="+arry[j]+",min_index不变");
                }
            }
            //将数组i处与min_index处的值交换
            exchange(arry,i,min_index);
            //System.out.println("arry["+i+"]="+arry[i]);
           //System.out.println("-------------------------");
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
