package com.test.quartz.Task;

import java.util.Timer;
import java.util.TimerTask;

public class MyTask {
    public static void first(){
        //计数器
        Timer timer = new Timer();
        //新开一个子线程执行，延迟3s后，每隔2s，就执行run方法
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long id = Thread.currentThread().getId();
                System.out.println("子线程：" + id);
                System.out.println(999);
            }
        },3000,2000);
    }

    public static void main(String[] args) {
        System.out.println("start");
        long id = Thread.currentThread().getId();
        System.out.println("id:" + id);
        first();
        System.out.println("over");
    }
}
