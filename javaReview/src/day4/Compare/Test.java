package day4.Compare;

import day4.Compare.Student;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("AA",10);
        Student s2 = new Student("BB",20);


        System.out.println(s1.compareTo(s2));

    }

    @org.junit.Test
    public void testStringCompare(){
        String a = "的";
        String b = "不";
        System.out.println(b.compareTo(a));

    }

    @org.junit.Test
    public void testIntegerCompare(){
        Integer a = 50;
        Integer a2 = 55;
        System.out.println(a.compareTo(a2));
    }
}
