package com.myty.soldier.study_java.controller;

import java.util.concurrent.ExecutionException;

import com.myty.soldier.study_java.service.AsyncService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public void async() throws InterruptedException, ExecutionException {
        asyncService.executeAsync();
    }

}
