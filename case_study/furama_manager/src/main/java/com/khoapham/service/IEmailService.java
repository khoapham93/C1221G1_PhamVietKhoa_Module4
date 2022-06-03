package com.khoapham.service;

public interface IEmailService {
    void sendSimpleMessage(
            String to, String subject, String text);
}
