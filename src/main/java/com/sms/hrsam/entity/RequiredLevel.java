package com.sms.hrsam.entity;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
@Entity
@Table(name = "required_levels")
@Data
public class RequiredLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Min(1)
    @Max(5)
    private Integer requiredLevel;
}