package com.petkin.eventservice.domain.theme.entity.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ThemeName {

    @Column(name = "theme_name")
    private String themeName;

    public static ThemeName from(final String themeName) {
        return new ThemeName(themeName);
    }

    @JsonValue
    public String themeName() {
        return themeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThemeName themeName = (ThemeName) o;
        return Objects.equals(themeName(), themeName.themeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(themeName());
    }
}
