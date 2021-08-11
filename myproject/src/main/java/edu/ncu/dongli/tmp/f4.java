package edu.ncu.dongli.tmp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class f4 {
    public static void main(String[] args) throws ParseException {
        String beginTime=new String("2017-06-09 10:22:22");
        String endTime=new String("2017-05-08 11:22:22");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sd1=df.parse(beginTime);
        Date sd2=df.parse(endTime);
        long long1 =sd1.getTime();
        long long2= sd2.getTime();
        System.out.println(long1>long2);
    }
}
