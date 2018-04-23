package com.test.time;

import java.time.*;

public class MyTime {
    public static void now(){
        //当前时间，本地格式显示
        LocalDate now = LocalDate.now();
        //3天后
        LocalDate plusDays = now.plusDays(3);

        System.out.println(plusDays);
        System.out.println(now);
    }
    //生日
    public static void birthday(){
        MonthDay birthday = MonthDay.of(9, 1);
        MonthDay today = MonthDay.from(LocalDate.now());
        if (birthday.equals(today)) {
            System.out.println("生日快乐");
        } else {
            System.out.println("不是生日");
        }
    }
    //星期
    public static void week(){
        DayOfWeek dayOfWeek = DayOfWeek.from(LocalDate.now());
        System.out.println(dayOfWeek.getValue());
    }
    //时间
    public static void time(){
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }
    public static void main(String[] args) {
        now();
        birthday();
        week();
        time();
    }
}
