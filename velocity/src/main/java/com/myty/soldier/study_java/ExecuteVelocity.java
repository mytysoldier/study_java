package com.myty.soldier.study_java;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class ExecuteVelocity {

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private MailSender mailSender;

    public void execute() {
        // Load Velocity template
        StringWriter writer = new StringWriter();
        VelocityContext ctx = new VelocityContext();
        ctx.put("message", "test message!");
        Template template = velocityEngine.getTemplate("sample.vm");
        template.merge(ctx, writer);
        String body = writer.toString();

        // Create mail message
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sampleFrom@sample.jp");
        message.setTo("sampleTo@sample.jp");
        message.setSubject("velocity mail test");
        message.setText(body);

        try {
            // Send mail
            mailSender.send(message);
        } catch (final MailException e) {
            System.out.println("Failed to send mail!");
        }
    }

}
