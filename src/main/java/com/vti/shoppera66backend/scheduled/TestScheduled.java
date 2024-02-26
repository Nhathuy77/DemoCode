package com.vti.shoppera66backend.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public class TestScheduled {

    @Scheduled(cron = "0 0/1 * * * *")
    public void test(){
        System.out.println("Job run at: " + Instant.now());
    }
}
