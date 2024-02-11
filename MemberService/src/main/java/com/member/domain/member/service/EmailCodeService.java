package com.member.domain.member.service;

import com.member.domain.member.entity.email.JoinEmailCode;
import com.member.domain.member.repository.email.JoinEmailCodeRepository;
import com.member.global.email.EmailService;
import com.member.global.email.random.RandomCodeGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailCodeService {

    private final JoinEmailCodeRepository joinEmailCodeRepository;
    private final EmailService emailService;

    public void sendJoinCode(String email) {
        final String code = RandomCodeGenerator.generateRandomCode();
        emailService.sendEmail(email, "", code);

        final JoinEmailCode joinEmailCode = JoinEmailCode.builder()
                .email(email)
                .code(code)
                .build();
        joinEmailCodeRepository.save(joinEmailCode);
    }

    public boolean checkJoinCode(String email, String code) {
        final JoinEmailCode joinEmailCode = joinEmailCodeRepository.findByEmail(email).orElseThrow(RuntimeException::new);
        if (!joinEmailCode.getEmail().equals(email) || !joinEmailCode.getCode().equals(code)) {
            return false;
        }
        joinEmailCodeRepository.delete(joinEmailCode);
        return true;
    }
}
