package com.petkin.eventservice.domain.theme.utility;

import com.petkin.eventservice.domain.theme.entity.Theme;
import com.petkin.eventservice.domain.theme.entity.vo.ThemeCode;
import com.petkin.eventservice.domain.theme.entity.vo.ThemeName;

public class ThemeUtil {
    public static ThemeCode GIVEN_CODE = ThemeCode.from("TEST");
    public static ThemeName GIVEN_NAME = ThemeName.from("테스트");

    public static Theme getEntity() {
        return Theme.of(GIVEN_CODE, GIVEN_NAME);
    }

}
