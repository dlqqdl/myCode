package edu.ncu.dongli.tmp;

import java.math.BigDecimal;
import java.util.*;

public class Hello {
    public static final String me=new String("hello");
    public static float divide(int a,int b){
        float r = 0;
        try{
            r=a/b;
        }catch (ArithmeticException e){
            System.out.println("除0");
            e.printStackTrace();
        }
        return r;
    }
    public static float divide1(int a,int b) throws ArithmeticException{
        float r = 0;
        r=a/b;
        System.out.println("除0");
        return r;
    }
    public static void display(){
        float r=divide1(10, 0);
        System.out.println(r);
    }
    public static void main(String[] args) {
//        //上面两个语句等价于下面一条语句
//        List<String> myList2 = Arrays.asList("Apple","Banana", "Orange");
//        myList2.stream().forEach(p-> System.out.println(p));
//
//        myList2.sort((o1,o2)->{return o2.compareTo(o1);});
//
//        myList2.stream().forEach(p-> System.out.println(p));

//
        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        list.forEach(System.out::println);
        Collections.reverse(list);
        list.forEach(System.out::println);
        s=list.toArray(new String[0]);//没有指定类型的话会报错
    }
}

