package com.myty.soldier.study_java.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
public class MqConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.activemq")
    public ActiveMQConnectionFactory mqConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        return factory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory mqFactory(ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        ExecutorService executor = Executors.newCachedThreadPool();
        factory.setTaskExecutor(executor);
        return factory;
    }

}
