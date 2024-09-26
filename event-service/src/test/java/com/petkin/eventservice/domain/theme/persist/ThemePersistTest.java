package com.petkin.eventservice.domain.theme.persist;

import com.petkin.eventservice.domain.theme.entity.Theme;
import com.petkin.eventservice.domain.theme.utility.ThemeUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class ThemePersistTest {

    @Autowired
    private ThemeRepository themeRepository;

    @BeforeEach
    void init() {
        themeRepository.save(ThemeUtil.getEntity());
    }

    @Test
    @DisplayName("테스트 코드 실행 이전 저장 로직 정상 동작 확인 테스트")
    void initTest() {
        Theme given = ThemeUtil.getEntity();
        Theme theme = themeRepository.findById(ThemeUtil.GIVEN_CODE).get();

        assertThat(theme.getCode()).isEqualTo(ThemeUtil.GIVEN_CODE);
        assertThat(theme.getName()).isEqualTo(ThemeUtil.GIVEN_NAME);

        List<Theme> themeList = themeRepository.findAll();
        assertThat(themeList.size()).isEqualTo(1);
    }
}
