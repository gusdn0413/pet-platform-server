package com.petkin.eventservice.domain.theme.entity;

import com.petkin.eventservice.domain.theme.entity.vo.ThemeCode;
import com.petkin.eventservice.domain.theme.entity.vo.ThemeName;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Theme {

    @EmbeddedId
    private ThemeCode code;

    @Embedded
    private ThemeName name;

    public static Theme of(ThemeCode themeCode, ThemeName themeName) {
        return new Theme(themeCode, themeName);
    }

}
