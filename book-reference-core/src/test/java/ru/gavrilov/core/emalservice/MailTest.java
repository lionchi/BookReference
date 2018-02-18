package ru.gavrilov.core.emalservice;

import org.junit.Test;

import static org.junit.Assert.*;

public class MailTest {
    @Test
    public void sendSimpleMessage() throws Exception {
        String subject = "Subject";
        String content = "Test";
        String to = "gavrilov.vania@yandex.ru";
        Mail.sendSimpleMessage(to,content,subject);
    }

    @Test
    public void sendMultiMessage() throws Exception {
        String subject = "Subject";
        String content = "Test";
        String to = "gavrilov.vania@yandex.ru";
        Mail.sendMultiMessage(to,content,subject);
    }

}