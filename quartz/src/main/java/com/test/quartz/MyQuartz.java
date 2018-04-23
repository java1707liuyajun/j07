package com.test.quartz;

import com.test.quartz.quartz.FirstJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MyQuartz {
    //(任务不能直接使用，需要包装)包装第一个任务，为任务起名字
    static JobDetail detail;
    static {
         detail = JobBuilder.newJob(FirstJob.class).withIdentity("first").build();
    };
    //任务执行的时间
    public static CronScheduleBuilder cron(){
        return CronScheduleBuilder.cronSchedule("0 * 17 * * ?");
    }
    public static void main(String[] args) {
        //触发器
          CronTrigger trigger = TriggerBuilder.newTrigger().startNow().withSchedule(cron()).build();
        try {
            //获得调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(detail,trigger);
            //开始任务
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }
    //
    //
    //
    //15到16每隔5s执行一次
    //每月的最后一天
    //任务执行的执行，每月每天的15点每分钟执行一次。
    // 每天的4月23灵活凌晨零点；

}
