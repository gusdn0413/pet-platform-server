package com.petkin.eventservice.domain.petbrag.persist;

import com.petkin.eventservice.domain.petbrag.entity.PetBrag;
import com.petkin.eventservice.domain.petbrag.entity.vo.Explanation;
import com.petkin.eventservice.domain.petbrag.entity.vo.Introduction;
import com.petkin.eventservice.domain.petbrag.utility.PetBragUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class PetBragPersistTest {

    @Autowired
    private PetBragRepository petBragRepository;

    @BeforeEach
    void init() {
        petBragRepository.save(PetBragUtil.getEntity());
    }

    @Test
    @DisplayName("테스트 코드 실행 이전 저장 로직 정상 동작 확인 테스트")
    void initTest() {

        PetBrag given = PetBragUtil.getEntity();
        PetBrag petBrag = petBragRepository.findById(1L).get();

        assertThat(petBrag.getExplanation()).isEqualTo(given.getExplanation());
        assertThat(petBrag.getIntroduction()).isEqualTo(given.getIntroduction());

        List<PetBrag> petBragList = petBragRepository.findAll();
        assertThat(petBragList.size()).isEqualTo(1);
    }
}
