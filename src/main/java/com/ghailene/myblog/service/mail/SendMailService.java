package com.ghailene.myblog.service.mail;

import com.ghailene.myblog.dto.ContactDto;

public interface SendMailService {

    public void sendEmail(ContactDto contact);
}
