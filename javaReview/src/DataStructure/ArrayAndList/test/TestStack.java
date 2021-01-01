package DataStructure.ArrayAndList.test;

import DataStructure.ArrayAndList.StackByArray;


//测试栈
public class TestStack {
    public static void main(String[] args) {
//        System.out.println("创建一个新的栈(链表实现的栈)~");
//        StackByList<String> stack1 = new StackByList<>();
//        System.out.println("栈是否为空?"+stack1.isEmpty());
//        System.out.println("栈内元素个数?"+stack1.size());
//
//        stack1.push("李锋");
//        stack1.push("李华");
//        stack1.push("张明");
//
//        System.out.println("遍历栈内元素:");
//        for (Object o : stack1) {
//            System.out.println(o);
//        }
//
//        stack1.pop();
//        stack1.pop();
//        stack1.pop();
//        System.out.println(stack1.pop());

        StackByArray<String> stack2 = new StackByArray<>();
        System.out.println("栈是否为空?"+stack2.isEmpty());
        System.out.println("栈内元素个数?"+stack2.size());

        stack2.push("李锋");
        stack2.push("李华");
        stack2.push("张明");
        stack2.push("张明明");
        stack2.push("张明明明");
        stack2.push("张明明明明");
        stack2.push("张明明明明明");
        stack2.push("张明明明明明明");
        stack2.push("张明明明明明明明");
        stack2.push("张明明明明明明明明");
        stack2.push("张明明明明明明明明明");




        stack2.pop();
        stack2.pop();
        stack2.pop();
        System.out.println(stack2.pop());
    }
}
