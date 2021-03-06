package com.myty.soldier.study_java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BatchRunner implements CommandLineRunner {

    @Autowired
    private ExecuteVelocity executeVelocity;

    @Override
    public void run(String... args) throws Exception {
        executeVelocity.execute();
    }

}
