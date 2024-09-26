package com.petkin.eventservice.domain.petbrag.entity.vo;

import com.fasterxml.jackson.annotation.JsonValue;
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
public class Explanation {

    @NotBlank(message = "설명은 필수 값 입니다.")
    @Max(value = 300)
    private String explanation;

    public static Explanation from(final String explanation) {
        return new Explanation(explanation);
    }

    @JsonValue
    public String explanation() {
        return explanation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Explanation explanation = (Explanation) o;
        return Objects.equals(explanation(), explanation.explanation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(explanation());
    }
}
