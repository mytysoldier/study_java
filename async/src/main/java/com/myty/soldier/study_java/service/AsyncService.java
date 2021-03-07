package com.myty.soldier.study_java.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.myty.soldier.study_java.db.AsyncDbLogic;
import com.myty.soldier.study_java.db.tables.SampleTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsyncService {

    @Autowired
    private AsyncDbLogic asyncDbLogic;

    public void executeAsync() throws InterruptedException, ExecutionException {
        // Define future jobs
        CompletableFuture<List<SampleTable>> job1 = asyncDbLogic.findAllData();
        CompletableFuture<List<SampleTable>> job2 = asyncDbLogic.findAllDataAfterSleep();

        // Complete jobs
        CompletableFuture.allOf(job1, job2).join();

        // Retrieve result
        List<SampleTable> result1 = job1.get();
        List<SampleTable> result2 = job2.get();
        log.info(String.format("The result data is {%s}, {%s}", result1, result2));
    }

}
