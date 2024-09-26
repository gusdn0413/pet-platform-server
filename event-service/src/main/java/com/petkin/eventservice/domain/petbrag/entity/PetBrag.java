package com.petkin.eventservice.domain.petbrag.entity;


import com.petkin.eventservice.domain.petbrag.entity.vo.Explanation;
import com.petkin.eventservice.domain.petbrag.entity.vo.Introduction;
import com.petkin.eventservice.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Getter
@Entity
@Table(name = "pet_brag", indexes = {
        @Index(name="member_index", columnList = "member_idx"),
        @Index(name="hit_index", columnList = "hit_idx")
})
@Where(clause = "delete_flag = false")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PetBrag extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_brag_idx")
    private Long id;

    @Column(name = "member_idx", nullable = false)
    private Long memberIdx;

    @Embedded
    private Introduction introduction;

    @Embedded
    private Explanation explanation;

    @Column(name = "world_cup_participation_flag")
    private boolean worldCupParticipationFlag = false;

    @Column(name = "hit_idx")
    private Long hitIdx;

    @Column(name = "report_flag")
    private boolean reportFlag = false;

    @Column(name = "delete_flag")
    private boolean deleteFlag = false;

    @Builder
    private PetBrag(Long memberIdx, Introduction introduction, Explanation explanation, Long hitIdx) {
        this.memberIdx = memberIdx;
        this.introduction = introduction;
        this.explanation = explanation;
        this.hitIdx = hitIdx;
    }

    public void report() {
        this.reportFlag = true;
    }

    public void delete() {
        this.deleteFlag = true;
    }
}

