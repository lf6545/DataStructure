package DataStructure.TableTreeHeap.test;

import DataStructure.TableTreeHeap.Heap;
import day3.AbstractClass;
import org.junit.Test;

/*
* 测试堆Heap的方法
* */
public class TestHeap {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(50);

        //向堆中插入数据
        heap.insert((int) 'A');
        heap.insert(9);
        heap.insert(8);
        heap.insert(7);
        heap.insert(6);
        heap.insert(5);
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);

        Integer result = null;
        while ((result = heap.delMax())!=null){
            System.out.print(result+"-");
        }
    }

    //测试堆的排序方法
    @Test
    public void testSort(){
        Integer a[] = {5,26,45,48,9,2,74,9,15,6,21};
        //int[] a = {5,26,45,48,9,2,74,9,15,6,21};
        Character c[] = {'i','p','a','s','j','o','t','g','n'};
        Heap<Integer> heap = new Heap<>(30);
        Integer[] sortA = (Integer[]) heap.sort(a);
        System.out.println("排好序的Integer数组:");
        for (Integer i : sortA) {
            System.out.print(i+"-");
        }
        Character[] sortC = (Character[]) heap.sort(c);
        System.out.println("排好序的Character数组:");
        for (Character ch : sortC) {
            System.out.print(ch+"-");
        }
//        Heap<Character> heap2 = new Heap<>(30);
//        Character[] sortC = (Character[]) heap2.sort(c);
//        System.out.println("排好序的Character数组:");
//        for (Character ch : sortC) {
//            System.out.print(ch+"-");
//        }
    }

}
