package DataStructure.ArrayAndList.applicationCase;

import DataStructure.ArrayAndList.StackByList;

/*
* 解决逆波兰表达式的计算问题
* 也就是后缀表达式,如 中缀表达式a*(b+c) => 后缀表达式abc+*
* */
public class StackCase2 {
    public static void main(String[] args) {
        String[] s = {"2","20","10","1","4","2","+","+","-","-","*"};
        //2*(20-(10-(4+2+1)))
        System.out.println(caculate(s));
    }

    public static double caculate(String[] expression){
        StackByList<String> stack = new StackByList();
        double sum = 0;
        String expr = " ";
        for (String s : expression) {
            if (s.equals("+")){
                //字符串是运算符,弹栈两次,结合操作符进行计算
                String o1 = stack.pop();
                String o2 = stack.pop();
                sum=Double.parseDouble(o2) + Double.parseDouble(o1);

                //把计算结果入栈
                stack.push(String.valueOf(sum));
            }else if (s.equals("-")){
                String o1 = stack.pop();
                String o2 = stack.pop();
                sum=Double.parseDouble(o2) - Double.parseDouble(o1);
                stack.push(String.valueOf(sum));
            }else if (s.equals("*")){
                String o1 = stack.pop();
                String o2 = stack.pop();
                sum=Double.parseDouble(o2) * Double.parseDouble(o1);
                stack.push(String.valueOf(sum));
            }else if (s.equals("/")){
                String o1 = stack.pop();
                String o2 = stack.pop();
                sum=Double.parseDouble(o2) / Double.parseDouble(o1);
                stack.push(String.valueOf(sum));
            }else if (s.equals("%")){
                String o1 = stack.pop();
                String o2 = stack.pop();
                sum=Double.parseDouble(o2) % Double.parseDouble(o1);
                stack.push(String.valueOf(sum));
            }else{
                //不是运算符,也就是操作数,入栈
                stack.push(s);
            }
        }
        return sum;
    }
}
