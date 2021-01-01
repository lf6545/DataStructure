package DataStructure.TableTreeHeap.test;

import DataStructure.TableTreeHeap.OrderSymbolTable;

/*
* 测试符号表
* */
public class TestSymbolTable {
    public static void main(String[] args) {
//        SymbolTable<Integer,String> table = new SymbolTable<>();
//        System.out.println("空表测试:");
//        System.out.println(table.contains(5));
//        table.delete(100);
//        System.out.println(table.get(8));
//        System.out.println(table.size());
//        System.out.println("=========================================");
//        table.put(11,"Kyrie Irving");
//        table.put(7,"Kevien Durant");
//        table.put(23,"Lebron James");
//        table.put(3,"Antony Davis");
//        table.put(24,"Kobe Bryant");
//
//        System.out.println(table.get(11));
//        table.traverse();


        //测试有序符号表
        OrderSymbolTable<Integer,String> table = new OrderSymbolTable<>();

        System.out.println(table.size());
        System.out.println("=========================================");
        table.put(11,"Kyrie Irving");
        table.put(7,"Kevien Durant");
        table.put(23,"Lebron James");
        table.put(3,"Antony Davis");
        table.put(24,"Kobe Bryant");

        System.out.println(table.get(11));
        table.put(4,"Alen Iverson");
        table.traverse();

    }
}
