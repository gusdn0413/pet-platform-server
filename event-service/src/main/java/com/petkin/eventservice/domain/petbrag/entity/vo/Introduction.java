package com.petkin.eventservice.domain.petbrag.entity.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Introduction {

    @NotBlank(message = "한 줄 소개는 필수 값입니다.")
    @Column(name = "one_line_introduction")
    @Max(value = 30)
    private String introduction;

    public static Introduction form(final String introduction) {
        return new Introduction(introduction);
    }

    @JsonValue
    public String introduction() {
        return introduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Introduction introduction = (Introduction) o;
        return Objects.equals(introduction(), introduction.introduction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(introduction());
    }
}
