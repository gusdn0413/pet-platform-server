package com.member.domain.member.gender;

public enum Gender {
    MALE("남성"),
    FEMALE("여성");

    private final String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
