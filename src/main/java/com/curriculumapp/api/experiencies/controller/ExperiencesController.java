package com.curriculumapp.api.experiencies.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculumapp.api.experiencies.data.ExperienceEntity;
import com.curriculumapp.api.experiencies.model.ExperienceResponseModel;
import com.curriculumapp.api.experiencies.services.ExperiencesService;
import com.google.common.reflect.TypeToken;

@RestController
@RequestMapping("/users/{id}/experiences")
public class ExperiencesController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ExperiencesService expService;
    
    @GetMapping( 
            produces = { 
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
            })
    public List<ExperienceResponseModel> userExperiences(@PathVariable String id) {

        List<ExperienceResponseModel> returnValue = new ArrayList<>();
        
        List<ExperienceEntity> experiencesEntities = expService.getExperiences(id);
        
        if(experiencesEntities == null || experiencesEntities.isEmpty())
        {
            return returnValue;
        }
        
        Type listType = new TypeToken<List<ExperienceResponseModel>>(){}.getType();
 
        returnValue = new ModelMapper().map(experiencesEntities, listType);
        logger.info("Returning " + returnValue.size() + " experiences");
        return returnValue;
    }
    
    @PostMapping( 
            produces = { 
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
            })
    public List<ExperienceResponseModel> createUserExperiences( @RequestBody List<ExperienceEntity> listExp) {

        List<ExperienceResponseModel> returnValue = new ArrayList<>();
        
        List<ExperienceEntity> experiencesEntities = expService.createExperiences(listExp);
        
        if(experiencesEntities == null || experiencesEntities.isEmpty())
        {
            return returnValue;
        }
        
        Type listType = new TypeToken<List<ExperienceResponseModel>>(){}.getType();
 
        returnValue = new ModelMapper().map(experiencesEntities, listType);
        logger.info("Returning " + returnValue.size() + " experiences");
        return returnValue;
    }
    
    @PutMapping( 
            produces = { 
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
            })
    public List<ExperienceResponseModel> updateUserExperiences( @RequestBody List<ExperienceEntity> listExp) {

        List<ExperienceResponseModel> returnValue = new ArrayList<>();
        
        List<ExperienceEntity> experiencesEntities = expService.createExperiences(listExp);
        
        if(experiencesEntities == null || experiencesEntities.isEmpty())
        {
            return returnValue;
        }
        
        Type listType = new TypeToken<List<ExperienceResponseModel>>(){}.getType();
 
        returnValue = new ModelMapper().map(experiencesEntities, listType);
        logger.info("Returning " + returnValue.size() + " experiences");
        return returnValue;
    }
    
    @DeleteMapping( 
            produces = { 
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
            })
    public String deleteUserExperiences(@PathVariable String userId) {
    	logger.info("Returning " +userId + " userId");
    	expService.deleteExpeByUserId(userId);        
        return "1";
    }
}
