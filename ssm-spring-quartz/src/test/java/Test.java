import com.kk.job.PlanJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 异步任务Quartz
 */
public class Test {

    public static void main(String[] args) throws Exception{
        JobBuilder jobBuilder = JobBuilder.newJob(PlanJob.class);//PlanJob,PlanJob,PlanJob

        //产生实际使用的Job
        JobDetail jobDetail=jobBuilder.withIdentity("meeting Job","group-1").build();

        //向Job的execute()中传入一些参数
        JobDataMap  jobDataMap=jobDetail.getJobDataMap();
        List<String> names= Arrays.asList(new String[]{"张三","李四","王五"});
        jobDataMap.put("infos",names);

        //触发器(Trigger):时间规则,依赖2个对象(TriggerBuilder,Schedule)
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder=triggerBuilder.withIdentity("meeting Trigger","group-1");
        triggerBuilder.startNow(); //满足条件立刻执行

        //2019-6-15 14:37:45~2019-6-15 14:40:45
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start=sdf.parse("2019-6-15 14:45:45");
        Date end=sdf.parse("2019-6-15 14:47:45");

//        triggerBuilder.startAt(start);
//        triggerBuilder.endAt(end);

        //ScheduleBuilder:定义执行的周期(时机)
//        ScheduleBuilder scheduleBuilder= SimpleScheduleBuilder.simpleSchedule();
//        ((SimpleScheduleBuilder) scheduleBuilder).withIntervalInSeconds(1); //每隔1秒执行一次
//        ((SimpleScheduleBuilder) scheduleBuilder).withRepeatCount(1); //重复执行3此

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("5,10,15,30 * * * * ? *");

        //产生触发器
//        Trigger trigger = triggerBuilder.withSchedule(scheduleBuilder).build();
            CronTrigger trigger=triggerBuilder.withSchedule(cronScheduleBuilder).build();


        //调度器(工厂产生调度器)
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();
        //产生调度器
        Scheduler scheduler=schedulerFactory.getScheduler();

        //通过调度器和任务和触发器一一对应
        scheduler.scheduleJob(jobDetail,trigger);
//        scheduler.start();

//        Thread.sleep(1000);
        scheduler.shutdown(true);

        spring();
    }

    static void spring()throws Exception{
        //single:容器初始化时
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Scheduler scheduler =applicationContext.getBean("schedulerFactoryBean",Scheduler.class);
        scheduler.start(); //autoStart=true
    }

}