package com.curriculumapp.api.experiencies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculumapp.api.experiencies.data.ExperienceEntity;
import com.curriculumapp.api.experiencies.model.ExperienceRequestModel;
import com.curriculumapp.api.experiencies.repository.ExperiencesRespository;



@Service
public class ExperiencesServiceImpl implements ExperiencesService {

	@Autowired
	ExperiencesRespository experienceRepository;
	@Override
	public List<ExperienceEntity> getExperiences(String id) {
    	//List<ExperienceEntity> returnValue =(List<ExperienceEntity>) experienceRepository.findAll();
		return  experienceRepository.findByUserId(id);
	}
	@Override
	public List<ExperienceEntity> createExperiences(List<ExperienceEntity> listExp) {
		
		 experienceRepository.saveAll(listExp);
		 
		return listExp;
	}
	@Override
	public void deleteExpeByUserId(String userId) {
		//experienceRepository.deleteExpeByUserId(userId);
	}

}
