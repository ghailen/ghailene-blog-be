package com.ghailene.myblog.service.mail.impl;

import com.ghailene.myblog.dto.ContactDto;
import com.ghailene.myblog.service.mail.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(ContactDto contact) {

        String from = contact.getEmail();
        String to = "ghailenemark@gmail.com";

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(contact.getTitle());
        message.setText(contact.getBody());

        mailSender.send(message);
    }
}
