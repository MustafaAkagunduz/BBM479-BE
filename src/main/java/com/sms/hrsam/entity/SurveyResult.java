package com.sms.hrsam.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "survey_result",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_id", "survey_id"})
        })
@Data
public class SurveyResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

    @OneToMany(mappedBy = "surveyResult",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<ProfessionMatch> professionMatches = new ArrayList<>();

    private LocalDateTime createdAt;

    // Helper method to add ProfessionMatch
    public void addProfessionMatch(ProfessionMatch match) {
        professionMatches.add(match);
        match.setSurveyResult(this);
    }

    // Helper method to remove ProfessionMatch
    public void removeProfessionMatch(ProfessionMatch match) {
        professionMatches.remove(match);
        match.setSurveyResult(null);
    }
}