package com.kk.job;

import com.kk.entity.ScheduleJob;
import com.kk.service.MeetingService;
import org.quartz.*;

import java.util.List;

public class PlanJob implements Job {

    MeetingService meetingService=new MeetingService();
//    public MeetingService meetingService;

    //JobExecutionContext:可以获取设置的各种参数值

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();

        System.out.println(triggerKey+"\r\n"+jobKey);

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
//        List<String> infos=(List<String>) jobDataMap.get("infos");
//        System.out.println(infos);

        ScheduleJob job=(ScheduleJob) jobDataMap.get("scheduleJob");

        System.out.println("spring:"+job.getJobId()+"\t"+job.getJobName());

        //存放计划执行的任务
        meetingService.calClassMeeting();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("end...");
    }

    public MeetingService getMeetingService() {
        return meetingService;
    }

    public void setMeetingService(MeetingService meetingService) {
        this.meetingService = meetingService;
    }
}
