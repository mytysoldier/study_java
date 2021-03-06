package com.myty.soldier.study_java;

import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VelocityConfig {

    @Bean("velocityProperties")
    @ConfigurationProperties(prefix = "mail.velocity")
    public Properties velocityProperites() {
        return new Properties();
    }

    @Bean
    public VelocityEngine velocityEngine(@Qualifier("velocityProperties") Properties velocityProperites) {
        VelocityEngine engine = new VelocityEngine(velocityProperites);
        engine.init();
        return engine;
    }

}
