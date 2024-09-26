package com.petkin.eventservice.domain.theme.entity.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ThemeCode implements Serializable {

    @Column(name = "theme_code")
    private String themeCode;

    public static ThemeCode from(final String themeCode) {
        return new ThemeCode(themeCode);
    }

    @JsonValue
    public String themeCode() {
        return themeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThemeCode themeCode = (ThemeCode) o;
        return Objects.equals(themeCode(), themeCode.themeCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(themeCode());
    }
}
