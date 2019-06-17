package com.kk.service;

public class MeetingService {

    static int count;

    public void calClassMeeting(){
        System.out.println("召开会议(任务)..."+ ++count);
    }
}
