package day4.Bubble;
//冒泡排序算法
//时间复杂度 O(n^2)
public class Bubble {
    public static void sort(Comparable[] arry) {
        int len = arry.length-1;
        for (int i = 0; i < arry.length-1; i++,len--) {
            //System.out.println("第"+i+1+"次遍历:");
            for (int j=0;j<len;j++){
                //System.out.print("j="+j+" : ");
                if (greater(arry[j], arry[j + 1])) {
                    //true --> arry[i]>arry[i+1]
                    //System.out.println(arry[j]+">"+arry[j+1]+",交换位置");
                    exchange(arry,j,j+1);
                }else {
                    //System.out.println(arry[j] + "<=" + arry[j + 1] + ",位置不变");
                }
            }

        }
    }
    //判断a是否>b
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
