package com.member.domain.member.repository.email;


import com.member.domain.member.entity.email.JoinEmailCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoinEmailCodeRepository extends JpaRepository<JoinEmailCode, String> {
    Optional<JoinEmailCode> findByEmail(String email);
}
