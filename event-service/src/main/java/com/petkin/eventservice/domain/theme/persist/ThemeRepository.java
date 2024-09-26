package com.petkin.eventservice.domain.theme.persist;

import com.petkin.eventservice.domain.theme.entity.Theme;
import com.petkin.eventservice.domain.theme.entity.vo.ThemeCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, ThemeCode> {
}
