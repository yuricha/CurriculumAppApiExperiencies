package com.curriculumapp.api.experiencies.data;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="experiences")
public class ExperienceEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;
    
    @Column(name="experienceId")
    private String experienceId;
    
    @Column(name="userId")
    private String userId; 
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;

    /**
    @Column(name="dateStart")
    private Timestamp dateStart;
    
    @Column(name="dateEnd")
    private Timestamp dateEnd;/**/
}
