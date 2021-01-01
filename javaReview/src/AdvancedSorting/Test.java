package AdvancedSorting;

import day4.insertion.Insertion;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
        //1.创建ArrayList集合存储要测试的数据
        ArrayList<Integer> list  = new ArrayList<Integer>();
        //2.创建缓存读取流,将文件中的数据读取出来,存储到ArrayList中
        BufferedReader br = new BufferedReader(new FileReader("D:/手机视频/MV/eee.txt"));
        String str;
        while ((str = br.readLine()) != null){
            int i = Integer.parseInt(str);
            list.add(i);
        }
        br.close();
        //3.将集合传给排序程序处理
        Integer[] a = new Integer[list.size()];
        list.toArray(a);

        //testInsertion(a);//29091毫秒//27919

        //testShell(a);//24毫秒

        testMerge(a);//46毫秒
    }

    public static void testShell(Comparable[] a){
        //1.获取执行之前的时间
        long start = System.currentTimeMillis();
        //2.执行排序算法进行排序
        Shell.sort(a);
        //3.获取执行之后的时间
        long end = System.currentTimeMillis();
        //4.算出程序执行的时间并输出
        System.out.println("希尔排序执行时间"+(end-start)+"毫秒");
    }

    public static void testInsertion(Comparable[] a){
        //1.获取执行之前的时间
        long start = System.currentTimeMillis();
        //2.执行排序算法进行排序
        Insertion.sort(a);
        //3.获取执行之后的时间
        long end = System.currentTimeMillis();
        //4.算出程序执行的时间并输出
        System.out.println("插入排序执行时间"+(end-start)+"毫秒");
    }
    public static void testMerge(Comparable[] a){
        //1.获取执行之前的时间
        long start = System.currentTimeMillis();
        //2.执行排序算法进行排序
        Merge.sort(a);
        //3.获取执行之后的时间
        long end = System.currentTimeMillis();
        //4.算出程序执行的时间并输出
        System.out.println("归并排序执行时间"+(end-start)+"毫秒");
    }
}
