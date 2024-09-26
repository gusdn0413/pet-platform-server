package com.petkin.eventservice.domain.petbrag.utility;

import com.petkin.eventservice.domain.petbrag.entity.PetBrag;
import com.petkin.eventservice.domain.petbrag.entity.vo.Explanation;
import com.petkin.eventservice.domain.petbrag.entity.vo.Introduction;

public class PetBragUtil {
    public static final Introduction GIVEN_INTRODUCTION = Introduction.form("테스트 한 줄 소개입니다.");
    public static final Explanation GIVEN_EXPLANATION = Explanation.from("테스트 설명입니다.");

    public static PetBrag getEntity() {
        return PetBrag.builder()
                .explanation(GIVEN_EXPLANATION)
                .introduction(GIVEN_INTRODUCTION)
                .memberIdx(1L)
                .build();
    }
}
