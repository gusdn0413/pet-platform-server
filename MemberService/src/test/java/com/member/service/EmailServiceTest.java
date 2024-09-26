package com.member.service;

import com.member.exception.GlobalExceptionHandler;
import com.member.service.random.RandomCodeGenerator;
import jakarta.mail.internet.MimeMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmailServiceTest {
    @Autowired
    private EmailService emailService;
    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    @DisplayName("코드 전송 성공")
    void sendVerificationCode_Success() {
        // 테스트에서 메일 전송
        emailService.sendVerificationCode("gusdn0413@naver.com");
        // 여기서 추가적인 검증이 필요하다면 Mockito 등을 활용하여 검증 가능
    }
}