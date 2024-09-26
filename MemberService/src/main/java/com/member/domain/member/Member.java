package com.member.domain.member;

import com.member.domain.member.gender.Gender;
import com.member.domain.member.mobileCarrier.MobileCarrier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Table(name = "MEMBER")
@Entity
@Getter
@Builder
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LOGIN_ID", nullable = false, length = 30, unique = true)
    private String loginId;

    @Column(name = "NAME", nullable = false, length = 30)
    private String name;

    @Column(name = "NICKNAME", nullable = false, length = 30)
    private String nickName;

    @Column(name = "PASSWORD", nullable = false, length = 30)
    private String password;

    @Column(name = "ADDRESS")
    private String address; // 주소

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private Gender gender; // 성별

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "E_MAIL")
    private String eMail;

    @Column(name = "WITHDRAWN")
    private boolean withdrawn; // 탈퇴 여부

    @Column(name = "DORMANT")
    private boolean dormant; // 휴면 여부

    @Column(name = "DORMANCY_START_DATE")
    private LocalDateTime dormancyStartDate; // 휴면 시작일

    @Column(name = "DORMANCY_END_DATE")
    private LocalDateTime dormancyEndDate; // 휴면 종료일

    @Enumerated(EnumType.STRING)
    @Column(name = "MOBILE_CARRIER")
    private MobileCarrier mobileCarrier;


    // 정보 수정

    public void updatePassword(PasswordEncoder passwordEncoder, String password) {
        this.password = passwordEncoder.encode(password);
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateNickName(String nickName) {
        this.nickName = nickName;
    }


    // 패스워드 암호화
    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }
}
