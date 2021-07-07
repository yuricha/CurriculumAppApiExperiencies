package com.curriculumapp.api.experiencies.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ExperienceRequestModel  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String experienceId;
    private String userId; 
    private String name;
    private String description;
}
