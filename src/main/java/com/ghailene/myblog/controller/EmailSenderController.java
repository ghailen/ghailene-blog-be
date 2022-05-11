package com.ghailene.myblog.controller;

import com.ghailene.myblog.dto.ContactDto;
import com.ghailene.myblog.service.mail.SendMailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
public class EmailSenderController {

    private final SendMailService sendMailService;

    public EmailSenderController(SendMailService sendMailService) {

        this.sendMailService = sendMailService;
    }

    @PostMapping("")
    public ResponseEntity<Object> sendEmail(@RequestBody ContactDto contact) {
        sendMailService.sendEmail(contact);
        return ResponseEntity.ok().build();
    }

}
