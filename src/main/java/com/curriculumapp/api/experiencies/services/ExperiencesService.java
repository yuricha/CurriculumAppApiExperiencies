package com.curriculumapp.api.experiencies.services;

import java.util.List;

import com.curriculumapp.api.experiencies.data.ExperienceEntity;

public interface ExperiencesService {

	List<ExperienceEntity> getExperiences(String id);

	List<ExperienceEntity> createExperiences(List<ExperienceEntity> listExp);

	void deleteExpeByUserId(String userId);

}
