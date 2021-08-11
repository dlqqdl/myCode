package edu.ncu.dongli.tmp;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class Test {
    private static Stack stack=new Stack();

    public static void main(String[] args) {
//        Deque<String> deque=new ArrayDeque<>();
//        deque.stream().forEach(System.out::println);
//        List<Object> l=new ArrayList<>();
//        l.add(null);
//        l.forEach(System.out::println);
//        Set<Object> s=new HashSet<>();
//        //Set<Object> s2=new TreeSet<>();
//        s.add(null);
//        //s2.add(null);
//        s.forEach(System.out::println);
//        //s2.forEach(System.out::println);
//        Map<String,Object>  m=new HashMap<>();
//        m.put(null,null);
//        m.put(null,44);
//        System.out.println(m.get(null));
//        int a=4;
//        int b=a/5;
        Map<String,Object>  m=new HashMap<>(10);
        for (int i = 0; i < 10; i++) {
            m.put("m"+i,i);
        }
        Logger logger=Logger.getGlobal();
        ConcurrentHashMap<String,Object> map=new ConcurrentHashMap<>();
        List<String> list=new ArrayList<>();
        list.add("aa");
        list.add("ba");
        list.add("ac");
        list.add("bc");
        list.sort((o1,o2)->o2.compareTo(o1));//reverse
        list.forEach(System.out::println);
    }
}
