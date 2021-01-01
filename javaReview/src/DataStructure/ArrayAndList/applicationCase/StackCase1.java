package DataStructure.ArrayAndList.applicationCase;

import DataStructure.ArrayAndList.StackByList;
/*
* 解决字符串中的括号匹配问题
* 判断字符串语句中的某种括号是否完整匹配
* */
public class StackCase1 {
    public static void main(String[] args) {
        String s = "{我}[爱](北京)(天安门),(天安门){前}(太阳)[升]!";
        String s2 = "((())";
        String s3 = "我自[横刀]]向[天笑,去留[肝胆]两昆仑";
        System.out.println(match(s3,'['));
    }

    //获取字符串中指定的字符,并且压入栈中
    public static StackByList parse(String str, char left, char right){
        char[] s = str.toCharArray();
        StackByList<Character> stack = new StackByList<Character>();
        for (char c : s) {
            if (c == left || c == right){
                stack.push(c);
            }
        }
        return stack;
    }

    //判断并返回括号类型
    public static char[] resolveType(char type){
        char left=' ';
        char right=' ';
        if (type == '('||type == ')'){
            left = '(';
            right = ')';
        }else if (type == '['||type == ']'){
            left = '[';
            right = ']';
        }else if (type == '{'||type == '}'){
            left = '{';
            right = '}';
        }else if (type == '<'||type == '>'){
            left = '<';
            right = '>';
        }else{
            System.out.println("Unable to resolve type("+type+")!");
        }
        char[] bracket = {left,right};
        return bracket;
    }
    //判断栈内的括号是否完整匹配
    public static boolean match(String str,char type){
        StackByList stack = null;
        //获取类型对应的括号
        char[] bracket = resolveType(type);
        char left = bracket[0];
        char right = bracket[1];

        //获取含有从str中所有括号的栈
        stack = parse(str,left,right);

        //用flag来记录右括号个数,因为正常()push入栈后,pop后的顺序是)(
        int flag = 0;
        char temp;
        while (stack.size()>0){
            temp = (char) stack.pop();
            if (temp == right){
                flag++;
            }else if (temp == left){
                //左括号减,表示括号相匹配了
                flag--;
            }
            if (flag<0){
                //出现了这种情况())...或者)(...,以右括号开始,这是一定错误的
                break;
            }
        }
        if (flag == 0){
            return true;
        }
        if (flag >0){
            System.out.println("'"+left+"'"+"比"+"'"+right+"'"+"少"+flag+"个");
            return false;
        }
        if (flag<0){
            System.out.println("检查语句\""+str+"\",语句中存在:以'"+right+"'开头的情况");
            return false;
        }
        return false;
    }
}
