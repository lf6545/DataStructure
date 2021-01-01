package day4.Selection;


import day4.Compare.Student;


public class Test {

    @org.junit.Test
    public void testIntegerCompare(){
        Integer[] a = {3,5,2,1,6,4,12,8,88,10};
        Selection.sort(a);
        //System.out.println(a);
        System.out.print("{");
        for (Integer integer : a) {
            System.out.print(integer+",");
        }
        System.out.print("}");
    }
    @org.junit.Test
    public void testStudentCompare(){
        Student s1 = new Student("李锋",20);
        Student s2 = new Student("欧文",28);
        Student s3 = new Student("詹姆斯",35);
        Student s4 = new Student("奥特曼",88);
        Student s5 = new Student("小明",5);
        Student[] stus = {s1,s2,s3,s4,s5};
        System.out.println("排序前:");
        for (Student student : stus) {
            System.out.println(student);
        }

        Selection.sort(stus);

        System.out.println("排序后:");
        for (Student student : stus) {
            System.out.println(student);
        }
    }
}
