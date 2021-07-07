package com.curriculumapp.api.experiencies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curriculumapp.api.experiencies.data.ExperienceEntity;


public interface ExperiencesRespository extends JpaRepository<ExperienceEntity, Long> {

	List<ExperienceEntity>findByUserId(String userId);
	 
	//@Query(value = "delete FROM experiences exp where exp.userId = ?1")
    //void deleteExpeByUserId(String userId);
}
