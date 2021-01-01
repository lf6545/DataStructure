package AdvancedSorting;


/*
* 希尔排序:插入排序的改进版本
* */
public class Shell {
    public static void main(String[] args) {

        Integer[] array = {8,2,6,1,4,6,12,55,26,22,1,3,6,8,9,5,4,21,6,5};

        sort(array);
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" , ");
        }
        System.out.print("}");
    }
    //排序
    public static void sort(Comparable[] array) {
        //确定增长量
        int h = 1;
        while (h < array.length/2){
            h = 2*h +1;
        }

        while (h>=1){
            //排序
            for (int i = h;i<array.length;i++){
                for (int j = i; j >= h; j=j-h){
                    if (greater(array[j-h],array[j])){
                        //前者大于后者,交换位置
                       exchange(array,j-h,j);
                    }else{
                        //位置正确
                        break;
                    }
                }

            }
            //增长量减小
            h=h/2;
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
