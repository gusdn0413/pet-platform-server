package com.member.domain.member.service;

import com.member.domain.member.dto.MemberUpdateRequestDTO;
import com.member.domain.member.entity.Member;
import com.member.domain.member.repository.MemberRepository;
import com.member.global.validator.PasswordValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public boolean verifyPassword(Long memberId, String currentPassword) {
        Optional<Member> findMember = memberRepository.findById(memberId);
        if (findMember.isPresent()) {
            Member member = findMember.get();
            return bCryptPasswordEncoder.matches(currentPassword, member.getPassword());
        } else {
            log.error("아이디를 찾을 수 없습니다");
            return false;
        }
    }

    @Transactional
    public boolean updateMemberInfo(Long memberId, MemberUpdateRequestDTO updateRequestDTO) {

        Optional<Member> findMember = memberRepository.findById(memberId);
        if (findMember.isPresent()) {
            Member member = findMember.get();
            String newNickName = updateRequestDTO.getNickName();
            if (memberRepository.existByNickName(newNickName)) {
                log.error("닉네임이 이미 존재합니다");
                return false;
            } else {
                member.updateNickName(newNickName);
            }

            String newPassword = updateRequestDTO.getPassword();
            if (newPassword != null) {
                if (!PasswordValidator.validate(newPassword)) {
                    log.error("비밀번호는 최소 8자 이상이어야 하며, 최소 1개의 숫자, 1개의 소문자, 1개의 대문자, 1개의 특수 문자를 포함해야 합니다.");
                    return false;
                } else {
                    member.setEncodedPassword(bCryptPasswordEncoder.encode(newPassword));
                }
            }
            memberRepository.save(member);
            return true;
        } else {
            log.error("아이디를 찾을 수 없습니다");
            return false;
        }
    }

    @Transactional
    public boolean withdraw(Long memberId, String currentPassword) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            if (bCryptPasswordEncoder.matches(currentPassword, member.getPassword())) {
                memberRepository.delete(member);
                log.info("회원 ID {}의 회원 탈퇴가 완료되었습니다.", memberId);
                return true;
            } else {
                log.error("비밀번호가 일치하지 않습니다.");
            }
        } else {
            log.error("회원을 찾을 수 없습니다.");
        }
        return false;
    }
}